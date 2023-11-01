package tech.stl.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.patient.entity.JwtRequest;
import tech.stl.patient.entity.JwtResponse;
import tech.stl.patient.service.JwtServiceimpl;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtServiceimpl jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
