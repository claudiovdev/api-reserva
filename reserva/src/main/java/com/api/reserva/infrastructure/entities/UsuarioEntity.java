package com.api.reserva.infrastructure.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_USUARIOS")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String usuarioId;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    private String telefone;

    @Column(nullable = false)
    private String status;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<ReservaEntity> reservas;

}
