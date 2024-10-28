package com.code.library_gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    // list of end points that are allowed to access without authentication
    public static final List<String> openApiEndpoints = List.of(
            "/library/authentication/register",
            "/library/authentication/validateuser",
            "/library/authentication/validatetoken"
    );

    public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
            .noneMatch(uri -> request
                    .getURI()
                    .getPath()
                    .contains(uri));
}
