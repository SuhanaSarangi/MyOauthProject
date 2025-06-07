package se.suhan.mynewproject.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class BaseController {

    public DefaultOAuth2User getOAuth2User() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof DefaultOAuth2User user) {
            return user;
        }
        return null;
    }

    public String getLoggedInEmail() {
        DefaultOAuth2User user = getOAuth2User();
        return user != null ? user.getAttribute("email") : null;
    }

    public String getLoggedInSub() {
        DefaultOAuth2User user = getOAuth2User();
        return user != null ? user.getAttribute("sub") : null;
    }
}
