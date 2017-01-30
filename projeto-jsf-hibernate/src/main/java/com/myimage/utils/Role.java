/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.utils;

/**
 *
 * @author Yvonei
 */
public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_COMMON("ROLE_COMMON");

    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
