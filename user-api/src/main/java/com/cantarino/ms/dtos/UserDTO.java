package com.cantarino.ms.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class UserDTO {

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    @NotBlank(message = "{endereco.not.blank}")
    private String endereco;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{telefone.not.blank}")
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
