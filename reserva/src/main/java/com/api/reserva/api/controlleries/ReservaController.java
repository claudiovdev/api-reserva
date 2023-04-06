package com.api.reserva.api.controlleries;

import com.api.reserva.api.mappers.ReservaMapperApi;
import com.api.reserva.api.models.request.ReservaModelRequest;
import com.api.reserva.api.models.response.ReservaModelResponse;
import com.api.reserva.domain.domainModels.ReservaDomain;
import com.api.reserva.domain.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @Autowired
    ReservaMapperApi mapperApi;

    @PostMapping
    public ReservaModelResponse cadastrarReserva(@RequestBody ReservaModelRequest reservaModelRequest){
        ReservaDomain reservaDomain = mapperApi.toDomain(reservaModelRequest);
        reservaDomain = reservaService.cadastrar(reservaDomain);
        ReservaModelResponse reservaModelReponse = mapperApi.toResponse(reservaDomain);
        return  reservaModelReponse;

    }

    @GetMapping
    public List<ReservaModelResponse>listarTodos(@RequestParam(required = false)String usuarioId){
        List<ReservaModelResponse> reservaModelResponseList = null;

        if (usuarioId != null){
            reservaModelResponseList =mapperApi.listaToResponse(reservaService.listarTodos(usuarioId));
        }else {
            reservaModelResponseList = mapperApi.listaToResponse(reservaService.listar());
        }

        return reservaModelResponseList;
    }

}
