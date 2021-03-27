package com.cantarino.ms.controllers;

import com.cantarino.ms.dtos.UserDTO;
import com.cantarino.ms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;
    private final String DELETADO_SUCESSO = "Deletado com sucesso";

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/usuarios")
    public ResponseEntity<List<UserDTO>> getUsuarios() {
        return ResponseEntity.ok(userService.All());
    }

    @GetMapping("/usuarios/{cpf}")
    public ResponseEntity<UserDTO> getUsuario(@PathVariable String cpf) {
        return ResponseEntity.ok(userService.Get(cpf));
    }

    @DeleteMapping("/usuarios/{cpf}")
    public ResponseEntity deleteUsuario(@PathVariable String cpf) {
        userService.Remove(cpf);
        return ResponseEntity.ok().body(DELETADO_SUCESSO);
    }

    @PostMapping("/usuarios/novo")
    public ResponseEntity<UserDTO> postUsuario(@RequestBody @Valid UserDTO usuario) {
        return new ResponseEntity<>(userService.Add(usuario), HttpStatus.CREATED);
    }
}
