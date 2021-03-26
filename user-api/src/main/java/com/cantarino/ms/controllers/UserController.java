package com.cantarino.ms.controllers;

import com.cantarino.ms.dtos.UserDTO;
import com.cantarino.ms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<>();

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/usuarios")
    public List<UserDTO> getUsuarios()
    {
        return userService.All();
    }

    @GetMapping("/usuarios/{cpf}")
    public UserDTO getUsuario(@PathVariable String cpf)
    {
        Optional<UserDTO> usuario = usuarios
                .stream()
                .filter(c-> c.getCpf().equals(cpf))
                .findFirst();

        return usuario.orElse(null);

    }



    @DeleteMapping("/usuarios/{cpf}")
    public void deleteUsuario(@PathVariable String cpf)
    {
        Optional<UserDTO> usuario = usuarios
                .stream()
                .filter(c-> c.getCpf().equals(cpf))
                .findFirst();

        usuario.ifPresent(userDTODTO -> usuarios.remove(userDTODTO));
    }


    @PostMapping("/usuarios/novo")
    public UserDTO postUsuario(@RequestBody UserDTO usuario)
    {
        usuario.setDataCadastro(new Date());
        usuarios.add(usuario);

        return usuario;
    }

    @PostConstruct
    private void Initiate()
    {
        UserDTO userDTO = new UserDTO("Eduardo", "123","Rua a",
                "eduardo@email.com", "1234-3454", new Date());

        UserDTO userDTODTO2 = new UserDTO("Renato", "01174811577","Rua a",
                "eduardo@email.com", "1234-3454", new Date());

        UserDTO userDTODTO3 = new UserDTO("Lucas", "25687455971","Rua a",
                "eduardo@email.com", "1234-3454", new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTODTO2);
        usuarios.add(userDTODTO3);
    }
}
