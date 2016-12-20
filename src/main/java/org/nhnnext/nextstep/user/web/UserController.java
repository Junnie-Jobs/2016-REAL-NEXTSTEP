package org.nhnnext.nextstep.user.web;

import org.nhnnext.nextstep.user.User;
import org.nhnnext.nextstep.user.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/api/user")
    public User getAuthenticatedUser() {
        return service.getAuthenticatedUser().orElseGet(null);
    }
}
