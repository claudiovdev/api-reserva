package com.api.reserva.api.models.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioModelResponse {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
}
