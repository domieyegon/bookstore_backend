
package com.bookstore.bookstore.domian.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

/**
 * Authority
 */
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 123123L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}