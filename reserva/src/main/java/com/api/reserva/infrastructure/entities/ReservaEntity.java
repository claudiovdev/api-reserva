package com.api.reserva.infrastructure.entities;


import com.api.reserva.infrastructure.enums.StatusReserva;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Table(name = "TB_RESERVAS")
public class ReservaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String reservaId;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCadastro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataInicialDaReserva;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataFinalDaReserva;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataAtualização;


    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_RESERVAS_USUARIOS", joinColumns = @JoinColumn(name = "reservaId"),
                                              inverseJoinColumns = @JoinColumn(name = "usuarioId"))
    private Set<UsuarioEntity> usuarios;
}
