package com.api.reserva.domain.services;

import com.api.reserva.domain.domainModels.ReservaDomain;

import java.util.List;


public interface ReservaService {
    ReservaDomain cadastrar(ReservaDomain reservaDomain);

    List<ReservaDomain> listar();

    List<ReservaDomain> listarTodos(String usuarioId);
}
