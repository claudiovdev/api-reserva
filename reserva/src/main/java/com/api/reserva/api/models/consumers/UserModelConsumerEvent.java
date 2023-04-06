package com.api.reserva.api.models.consumers;

import com.api.reserva.domain.domainModels.UsuarioDomain;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserModelConsumerEvent {
    private String usuarioId;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private String tipoDeAcao;

    public UsuarioDomain toDomain(){
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        BeanUtils.copyProperties(this, usuarioDomain);
        return usuarioDomain;
    }
}
