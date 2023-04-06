package com.api.reserva.domain.services.impl;

import com.api.reserva.domain.domainModels.ReservaDomain;
import com.api.reserva.domain.gateway.ReservaGatway;
import com.api.reserva.domain.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaGatway reservaGatway;

    @Override
    public ReservaDomain cadastrar(ReservaDomain reservaDomain) {
        return reservaGatway.cadastrar(reservaDomain);
    }



    @Override
    public List<ReservaDomain> listar() {
        return reservaGatway.listar();
    }

    @Override
    public List<ReservaDomain> listarTodos(String usuarioId) {
        return reservaGatway.listarReservasPorUsuarioId(usuarioId);
    }

}
