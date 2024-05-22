package com.training.training.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Component
public class TrailingSlashRedirectFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String url = ServletUriComponentsBuilder.fromRequest(request).build().toUriString();
        String path = request.getRequestURI();
        String fixedUrl = "";

        if (url.endsWith("/") && path.length() > 1 /* not the root path */)
            fixedUrl = url.substring(0, url.length() - 1);

        if (path.isEmpty() /* root path without '/' */)
            fixedUrl = StringTemplate.STR."\{url}/";

        if (!fixedUrl.isEmpty()) {
            response.setHeader(HttpHeaders.LOCATION, fixedUrl);
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            logger.trace(StringTemplate.STR."Redirecting with HttpStatus 301 for requested URL '\{url}' to '\{fixedUrl}'");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
