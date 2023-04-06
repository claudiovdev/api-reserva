package com.api.reserva.infrastructure.repositories.impl;

import com.api.reserva.infrastructure.entities.ReservaEntity;
import com.api.reserva.infrastructure.repositories.ReservaRepository;
import com.api.reserva.infrastructure.repositories.ReservaRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepositoryImpl implements ReservaRepositoryQueries {

    @Autowired @Lazy
    ReservaRepository reservaRepository;

}
