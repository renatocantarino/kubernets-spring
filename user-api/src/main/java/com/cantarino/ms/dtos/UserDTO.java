package com.cantarino.ms.dtos;

import java.util.Date;
import java.util.Objects;

public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public UserDTO(String nome, String cpf, String endereco, String email, String telefone, Date dataCadastro) {
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setEmail(email);
        setTelefone(telefone);
        setDataCadastro(dataCadastro);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return cpf.equals(userDTO.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

}
