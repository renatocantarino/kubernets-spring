package com.cantarino.ms.services;


import dtos.UsersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private UsersDTO getByCpf(String cpf) {

        RestTemplate _restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/cpf/" + cpf;

        ResponseEntity<UsersDTO> response =
                _restTemplate.getForEntity(url, UsersDTO.class);

        return response.getBody();
    }

    public UsersDTO get(String cpf) {
        UsersDTO usuario = getByCpf(cpf);
        if (usuario == null)
            throw new RuntimeException("Usuario não encontrado!");

        return usuario;
    }


}
