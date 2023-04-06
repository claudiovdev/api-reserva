package com.api.reserva.consumers;

import com.api.reserva.api.models.consumers.UserModelConsumerEvent;
import com.api.reserva.domain.gateway.UsuarioGateway;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @Autowired
    UsuarioGateway usuarioGateway;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${apireserva.broker.queue.userEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${apireserva.broker.exchange.userEventExchange}",type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true"))
    )
    public void escutandoEventoDeUsuarios(@Payload UserModelConsumerEvent userModelConsumerEvent){
        var usuarioDomain = userModelConsumerEvent.toDomain();

        switch (userModelConsumerEvent.getTipoDeAcao()){
            case "create":
                usuarioGateway.salvar(usuarioDomain);
                break;
        }
    }
}
