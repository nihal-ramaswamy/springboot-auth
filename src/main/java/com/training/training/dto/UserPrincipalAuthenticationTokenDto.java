package com.training.training.dto;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
public class UserPrincipalAuthenticationTokenDto extends AbstractAuthenticationToken {
    private final UserPrincipalDto principal;

    public UserPrincipalAuthenticationTokenDto(UserPrincipalDto principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
