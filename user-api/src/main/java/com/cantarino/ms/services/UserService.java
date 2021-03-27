package com.cantarino.ms.services;

import com.cantarino.ms.dtos.UserDTO;
import com.cantarino.ms.models.User;
import com.cantarino.ms.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> All() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO Add(UserDTO usuario) {

        usuario.setDataCadastro(new Date());
        ModelMapper _mapper = new ModelMapper();
        User user = _mapper.map(usuario, User.class);
        userRepository.saveAndFlush(user);
        return usuario;


    }

    public void Remove(String cpf) {
        Optional<User> user = userRepository.findByCpf(cpf);
        user.ifPresent(userRepository::delete);
    }

    public UserDTO Get(String cpf) {
        Optional<User> user = userRepository.findByCpf(cpf);
        return user.map(this::ConvertToDTO).orElse(null);
    }


    private UserDTO ConvertToDTO(User user) {
        return new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(),
                user.getEmail(), user.getTelefone(), user.getDataCadastro());
    }


}
