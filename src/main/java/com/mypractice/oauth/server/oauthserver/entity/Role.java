package com.mypractice.oauth.server.oauthserver.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role extends BaseIdEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id") })
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}