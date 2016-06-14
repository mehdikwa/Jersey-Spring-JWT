package com.auth.rest.api.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

    /**
     * 
     */

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String BEARER = "Bearer ";
    
    @Value("${vkauthentication.jwt.secret}")
    private String secret;

    @Value("${vkauthentication.jwt.expiration}")
    private Long expiration;

    @Value("${vkauthentication.jwt.header}")
    private String tokenHeader;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    // public Integer getUserIdFromToken(String token) {
    // if (token == null) {
    // return null;
    // }
    // Integer id;
    // try {
    // final Claims claims = getClaimsFromToken(token);
    // id = (Integer) claims.get(ClaimKeyEnum.CLAIM_KEY_USERID.getValue());
    // } catch (Exception e) {
    // id = null;
    // }
    // return id;
    // }
    // public Date getCreatedDateFromToken(String token) {
    // Date created;
    // try {
    // final Claims claims = getClaimsFromToken(token);
    // created = new Date((Long) claims.get(ClaimKeyEnum.CLAIM_KEY_CREATED.getValue()));
    // } catch (Exception e) {
    // created = null;
    // }
    // return created;
    // }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }


    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }


    public String generateToken(JwtUser jwtUser) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(ClaimKeyEnum.CLAIM_KEY_USERID.getValue(), jwtUser.getId());
        claims.put(ClaimKeyEnum.CLAIM_KEY_USERNAME.getValue(), jwtUser.getUsername());
        claims.put(ClaimKeyEnum.CLAIM_KEY_CREATED.getValue(), new Date());
        StringBuffer nameSbf = new StringBuffer();
        nameSbf.append(jwtUser.getFirstname()).append(" ").append(jwtUser.getLastname());
        claims.put(ClaimKeyEnum.CLAIM_KEY_NAME.getValue(), nameSbf.toString());
        claims.put(ClaimKeyEnum.CLAIM_KEY_AUTH_TYPE.getValue(), jwtUser.getAuthtype());
        claims.put(ClaimKeyEnum.CLAIM_KEY_ADMIN.getValue(), jwtUser.isAdmin());
        claims.put(ClaimKeyEnum.CLAIM_KEY_EMAIL.getValue(), jwtUser.getEmail());
        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = (Date) getClaimValueFromToken(ClaimKeyEnum.CLAIM_KEY_CREATED, token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset) && (!isTokenExpired(token));
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(ClaimKeyEnum.CLAIM_KEY_CREATED.getValue(), new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = (Date) getClaimValueFromToken(ClaimKeyEnum.CLAIM_KEY_CREATED, token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
    }

    public String getTokenFromRequest(HttpServletRequest httpRequest) {
        String authToken = httpRequest.getHeader(this.tokenHeader);
        if (!StringUtils.isEmpty(authToken) && authToken.startsWith(BEARER)) {
            authToken = authToken.substring(BEARER.length());
        }
        return authToken;
    }

    public Object getClaimValueFromToken(ClaimKeyEnum claim, String token) {
        Object result;
        try {
            final Claims claims = getClaimsFromToken(token);
            result = new Date((Long) claims.get(claim.getValue()));
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    public Object getClaimValueFromRequest(ClaimKeyEnum claim, HttpServletRequest httpRequest) {
        String token = getTokenFromRequest(httpRequest);
        return getClaimValueFromToken(claim, token);
    }
}