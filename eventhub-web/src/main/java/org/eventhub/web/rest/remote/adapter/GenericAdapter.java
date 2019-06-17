package org.eventhub.web.rest.remote.adapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * generic adapter of Entities and DTOs
 * @author M. ALI
 * @param <E> Entity
 * @param <D> DTO
 */
public abstract class GenericAdapter<E, D> {
	
	Class<E> entityClass;
	Class<D> dtoClass;
	List<Method> dtoSetters = new LinkedList<>();
	List<Method> dtoGetters = new LinkedList<>();
	boolean converting;
	
	protected GenericAdapter() {
		entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		for(Method method : dtoClass.getMethods()) {
			if(method.getName().startsWith("set")) {
				dtoSetters.add(method);
			}
			else if((method.getName().startsWith("get") || method.getName().startsWith("is")) &&
					!method.getName().equals("getClass")) {
				dtoGetters.add(method);
			}
		}
	}
	
	protected D toDTO(E entity) {
		try {
			D returnObj = dtoClass.newInstance();
			for(Method setter : dtoSetters) {
				String setterMethod = setter.getName().substring(3);
				Method getter;
				try {
					getter = entityClass.getMethod("get" + setterMethod);
				} catch (NoSuchMethodException ex) {
					getter = entityClass.getMethod("is" + setterMethod);
				}
				if(getter.getReturnType().equals(List.class)) {
					Class entityClass = (Class) ((ParameterizedType) getter.getGenericReturnType()).getActualTypeArguments()[0];
					GenericAdapter entityAdapter = getEntityAdapter(entityClass);
					if(entityAdapter == null) {
						setter.invoke(returnObj, getter.invoke(entity));
					}
					else if(!converting) {
						entityAdapter.converting = true;
						setter.invoke(returnObj, ((List) getter.invoke(entity)).stream()
								.map(e -> entityAdapter.toDTO(e)).collect(Collectors.toList()));
						entityAdapter.converting = false;
					}
				}
				else {
					GenericAdapter entityAdapter = getEntityAdapter(getter.getReturnType());
					if(entityAdapter == null) {
						setter.invoke(returnObj, getter.invoke(entity));
					}
					else if(!converting) {
						entityAdapter.converting = true;
						setter.invoke(returnObj, entityAdapter.toDTO(getter.invoke(entity)));
						entityAdapter.converting = false;
					}
				}
			}
			return returnObj;
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected E fromDTO(D dto) {
		if(dto == null) {
			return null;
		}
		else {
			try {
				E returnObj = entityClass.newInstance();
				for (Method getter : dtoGetters) {
					String getterMethod;
					if (getter.getName().startsWith("is")) {
						getterMethod = getter.getName().substring(2);
					} else {
						getterMethod = getter.getName().substring(3);
					}
					if (getter.getReturnType().equals(List.class)) {
						Method setter = entityClass.getMethod("set" + getterMethod, getter.getReturnType());
						Class entityClass = (Class) ((ParameterizedType) getter.getGenericReturnType()).getActualTypeArguments()[0];
						GenericAdapter entityAdapter = getDTOAdapter(entityClass);
						if (entityAdapter == null) {
							setter.invoke(returnObj, getter.invoke(dto));
						} else if (!converting) {
							entityAdapter.converting = true;
							setter.invoke(returnObj, ((List) getter.invoke(dto)).stream()
									.map(e -> entityAdapter.fromDTO(e)).collect(Collectors.toList()));
							entityAdapter.converting = false;
						}
					} else {
						GenericAdapter entityAdapter = getDTOAdapter(getter.getReturnType());
						if (entityAdapter == null) {
							Method setter = entityClass.getMethod("set" + getterMethod, getter.getReturnType());
							setter.invoke(returnObj, getter.invoke(dto));
						} else if (!converting) {
							entityAdapter.converting = true;
							Method setter = entityClass.getMethod("set" + getterMethod, getEntityOfDTO(getter.getReturnType()));
							setter.invoke(returnObj, entityAdapter.fromDTO(getter.invoke(dto)));
							entityAdapter.converting = false;
						}
					}
				}
				return returnObj;
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	protected abstract List<GenericAdapter> getAdapters();
	
	private GenericAdapter getEntityAdapter(Class clazz) {
		if(getAdapters() != null) {
			for(GenericAdapter genericAdapter : getAdapters()) {
				Class<E> entityClass = (Class<E>) ((ParameterizedType) genericAdapter.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				if(clazz.equals(entityClass)) {
					return genericAdapter;
				}
			}
		}
		return null;
	}
	
	private GenericAdapter getDTOAdapter(Class clazz) {
		if(getAdapters() != null) {
			for(GenericAdapter genericAdapter : getAdapters()) {
				Class<D> dtoClass = (Class<D>) ((ParameterizedType) genericAdapter.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
				if(clazz.equals(dtoClass)) {
					return genericAdapter;
				}
			}
		}
		return null;
	}

	private Class getEntityOfDTO(Class clazz) {
		if(getAdapters() != null) {
			for(GenericAdapter genericAdapter : getAdapters()) {
				Class<D> dtoClass = (Class<D>) ((ParameterizedType) genericAdapter.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
				if(clazz.equals(dtoClass)) {
					return (Class<D>) ((ParameterizedType) genericAdapter.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				}
			}
		}
		return null;
	}

}
