package com.example.GestioneEventi.controllers;

import com.example.GestioneEventi.entities.Utente;
import com.example.GestioneEventi.exceptions.FieldValidationException;
import com.example.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public ResponseEntity<Utente> registerUser(@RequestBody Utente utente) {
        if (utenteService.findByUsername(utente.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Utente savedUtente = utenteService.saveUtente(utente);
        return ResponseEntity.ok(savedUtente);
    }

    public record LoginModel(@NotBlank @Length(max = 125) String username, //
                             @NotBlank @Length(max = 15) String password) {

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {

        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        return new ResponseEntity<>(utenteService.login(model.username(), model.password()).orElseThrow(), //
                HttpStatus.OK);
    }

    /*@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {
        var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        a.getAuthorities();
        SecurityContextHolder.getContext().setAuthentication(a);

        var dto = mapLogin.map(users.findOneByUsername(username).orElseThrow());
        dto.setToken(jwt.generateToken(a));


        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        var response = new ResponseEntity<>(utenteService.login(model.username(), model.password()).orElseThrow(), //
                HttpStatus.OK);
        var token = jwt.generateToken(response)
    }*/
}
