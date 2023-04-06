package com.api.reserva.domain.domainModels;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UsuarioDomain {

    private String usuarioId;
    private String nome;
    private String email;
    private String telefone;
    private String status;
}
