/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.config;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eventhub.common.model.entity.*;
import org.eventhub.dal.dao.SystemUserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.eventhub.dal.dao.PrivilegeRepository;
import org.eventhub.dal.dao.RolePrivilegeRepository;
import org.eventhub.dal.dao.RoleRepository;
import org.eventhub.dal.dao.SystemUserHasRoleRepository;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class TestApplication {

    ApplicationContext context;
    SystemUserRepository systemUserRepository;
    PrivilegeRepository privilegeRepository;
    RoleRepository roleRepository;
    RolePrivilegeRepository rolePrivilegeRepository;
    SystemUserHasRoleRepository systemUserHasRoleRepository;

    public TestApplication() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        systemUserRepository = context.getBean(SystemUserRepository.class);
        privilegeRepository = context.getBean(PrivilegeRepository.class);
        roleRepository = context.getBean(RoleRepository.class);
        rolePrivilegeRepository = context.getBean(RolePrivilegeRepository.class);
        systemUserHasRoleRepository = context.getBean(SystemUserHasRoleRepository.class);
    }

    private SystemUser createUserIfNotPresent(String email, String password) {
        SystemUser user = systemUserRepository.findByEmail(email);
        if (user == null) {
            user = new SystemUser(null, "username", "firstname", password, email, UserGender.Female,new Date());
            user.setUserName(email);
            systemUserRepository.save(user);
        }
        return user;
    }

    private Role createRoleIfNotPresent(String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            role = new Role(null, roleName);
            roleRepository.save(role);
        }
        return role;
    }

    private Privilege createPrivilegeIfNotPresent(String privilegeName) {
        Pageable page = Pageable.unpaged();
        Privilege privilege = getFirstElement(privilegeRepository.findAllByName(privilegeName, page));
        if (privilege == null) {
            privilege = new Privilege(null, privilegeName);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    static <T> T getFirstElement(List<T> list) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    void addPrivilegesToRole(Role role, Privilege... privileges) {
        Set<Privilege> old = rolePrivilegeRepository
                .findAllByRole(role, Pageable.unpaged()).stream()
                .map((rolePrivilege) -> {
                    return rolePrivilege.getPrivilege();
                }).collect(Collectors.toSet());
        for (Privilege privilege : privileges) {
            if (!old.contains(privilege)) {
                RolePrivilege rolePrivilege = new RolePrivilege();
                rolePrivilege.setRole(role);
                rolePrivilege.setPrivilege(privilege);
                rolePrivilegeRepository.save(rolePrivilege);
            }
        }
    }

    void addRolesToUser(SystemUser user, Role... roles) {
        Set<Role> old = systemUserHasRoleRepository
                .findAllBySystemUser(user, Pageable.unpaged()).stream()
                .map((systemUserHasRole) -> {
                    return systemUserHasRole.getRole();
                }).collect(Collectors.toSet());
        for (Role role : roles) {
            if (!old.contains(role)) {
                SystemUserHasRole systemUserHasRole = new SystemUserHasRole();
                systemUserHasRole.setSystemUser(user);
                systemUserHasRole.setRole(role);
                systemUserHasRoleRepository.save(systemUserHasRole);
            }
        }
    }

    void run() {
        SystemUser user = createUserIfNotPresent("user@user.com", "user");
        SystemUser admin = createUserIfNotPresent("admin@admin.com", "admin");
        Role adminRole = createRoleIfNotPresent("admin");
        Role userRole = createRoleIfNotPresent("user");
        Privilege adminPrivilege = createPrivilegeIfNotPresent("ROLE_ADMIN");
        Privilege userPrivilege = createPrivilegeIfNotPresent("ROLE_USER");
        addPrivilegesToRole(adminRole, adminPrivilege, userPrivilege);
        addPrivilegesToRole(userRole, userPrivilege);
        addRolesToUser(admin, adminRole);
        addRolesToUser(user, userRole);
    }

    public static void main(String arg[]) {
        TestApplication application = new TestApplication();
        application.run();
    }
}
