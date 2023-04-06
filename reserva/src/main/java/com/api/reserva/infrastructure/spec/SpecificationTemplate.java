package com.api.reserva.infrastructure.spec;

import com.api.reserva.infrastructure.entities.ReservaEntity;
import com.api.reserva.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class SpecificationTemplate {

    public static Specification<UsuarioEntity> usuarioReservaId(final String reservaId){
        return (root, query, cb) -> {
            query.distinct(true);
            Root<UsuarioEntity> usuario = root;
            Root<ReservaEntity> reserva = query.from(ReservaEntity.class);
            Expression<Collection<UsuarioEntity>> reservasUsuarios = reserva.get("usuarios");
            return cb.and(cb.equal(reserva.get("reservaId"), reservaId), cb.isMember(usuario,reservasUsuarios));
        };
    }

    public static Specification<ReservaEntity> reservaUsuarioId(final String usuarioId){
        return (root, query, cb) -> {
            query.distinct(true);
            Root<ReservaEntity> reserva = root;
            Root<UsuarioEntity> usuario = query.from(UsuarioEntity.class);
            Expression<Collection<ReservaEntity>> usuariosReservas = usuario.get("reservas");
            return cb.and(cb.equal(reserva.get("usuarioId"), usuarioId), cb.isMember(reserva, usuariosReservas));
        };
    }

}
