package com.example.sweater.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

public enum Role implements GrantedAuthority{
    USER,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
