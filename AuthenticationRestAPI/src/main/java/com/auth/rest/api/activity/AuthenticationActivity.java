package com.auth.rest.api.activity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.auth.rest.api.bom.JwtRequestDto;
import com.auth.rest.api.bom.JwtResponseDto;
import com.auth.rest.api.security.JdbcUserDetailsService;
import com.auth.rest.api.security.JwtTokenUtil;
import com.auth.rest.api.security.JwtUser;

@Component
@Path("/login")
public class AuthenticationActivity {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationActivity.class);

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JdbcUserDetailsService userDetailsService;

    @POST
    @Path("/signup")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createAuthenticationToken(@Valid JwtRequestDto authenticationRequest) {
        LOGGER.info("LOGIN: " + authenticationRequest.getUsername());
        // Perform the security
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            return Response.status(Status.UNAUTHORIZED).entity("Unauthorized").build();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final JwtUser userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return Response.status(Response.Status.OK).entity(new JwtResponseDto(token)).build();
    }

    @GET
    @Path("/referesh")
    @Produces("application/json")
    public Response refreshAndGetAuthenticationToken(@Context HttpServletRequest httpRequest) {
        String authToken = jwtTokenUtil.getTokenFromRequest(httpRequest);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        Response response = null;
        if (username == null) {
            response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        } else {
            JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.canTokenBeRefreshed(authToken, user.getLastPasswordResetDate())) {
                String refreshedToken = jwtTokenUtil.refreshToken(authToken);
                response = Response.status(Response.Status.OK).entity(new JwtResponseDto(refreshedToken)).build();
            } else {
                response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
            }
        }
        return response;

    }

}
