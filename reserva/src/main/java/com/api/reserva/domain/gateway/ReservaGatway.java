package com.api.reserva.domain.gateway;

import com.api.reserva.domain.domainModels.ReservaDomain;

import java.util.List;

public interface ReservaGatway {
    ReservaDomain cadastrar(ReservaDomain reservaDomain);




    List<ReservaDomain> listar();

    List<ReservaDomain> listarReservasPorUsuarioId(String usuarioId);
}
