package com.api.reserva.api.controlleries;
import com.api.reserva.api.mappers.UsuarioMapperApi;
import com.api.reserva.api.models.response.UsuarioModelResponse;
import com.api.reserva.domain.domainModels.UsuarioDomain;
import com.api.reserva.domain.services.ReservaService;
import com.api.reserva.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioMapperApi mapperApi;

    @GetMapping("/reservas/{reservaId}/usuarios")
    public List<UsuarioModelResponse> buscaTodosUsuariosPorReserva(@PathVariable(value = "reservaId") String reservaId){
        List<UsuarioDomain> usuarioDomainList =  usuarioService.listarUsuariosPorCurso(reservaId);
        List<UsuarioModelResponse> usuarioModelResponseList = mapperApi.toModelResponse(usuarioDomainList);
        return usuarioModelResponseList;
    }


}
