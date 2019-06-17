package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Material;
import org.eventhub.remote.dto.MaterialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaterialAdapter extends GenericAdapter<Material, MaterialDTO> {

	@Autowired
	SessionInstructorAdapter sessionInstructorAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sessionInstructorAdapter);
	}
	
	public MaterialDTO toMaterialDTO(Material material) {
		return toDTO(material);
	}
	
	public Material fromMaterial(MaterialDTO materialDTO) {
		return fromDTO(materialDTO);
	}
	
}
