package com.okancezik.Flight.Search.API.auth.api;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.okancezik.Flight.Search.API.auth.requests.AuthenticationRequest;
import com.okancezik.Flight.Search.API.auth.requests.RegisterRequest;
import com.okancezik.Flight.Search.API.auth.responses.AuthenticationResponse;
import com.okancezik.Flight.Search.API.auth.services.AuthenticationService;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest,
            HttpServletResponse response
    ) {

        AuthenticationResponse authResponse = authenticationService.authenticate(authenticationRequest);

        return ResponseEntity.ok()
                .body(authResponse);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request,response);
    }
}
