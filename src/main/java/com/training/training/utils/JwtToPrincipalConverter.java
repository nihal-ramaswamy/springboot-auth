package com.training.training.utils;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.training.training.constants.Constants;
import com.training.training.dto.UserPrincipalDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtToPrincipalConverter {
    public UserPrincipalDto convert(DecodedJWT decodedJWT) {
        return new UserPrincipalDto(
                decodedJWT.getSubject(),
                decodedJWT.getClaim(Constants.EMAIL).asString(),
                this.getAuthorities(decodedJWT.getClaim(Constants.AUTHORITIES)));
    }

    private List<SimpleGrantedAuthority> getAuthorities(Claim claim) {
        return claim.isNull() || claim.isMissing() ?
                List.of() :
                claim.asList(SimpleGrantedAuthority.class);
    }
}
