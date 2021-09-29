package com.sda.fish.store.entities;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorityId;

    private String username;
    private String authority;

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }
}
