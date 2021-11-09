package br.com.me.dto;

import br.com.me.enun.StatusPedidoEnun;
import lombok.Data;

import java.util.List;

/**
 * @project desafio
 * Created by Leandro Saniago on 09/11/2021 - 10:05.
 */
@Data
public class StatusPedidoDto {

    private Long pedido;
    private List<StatusPedidoEnun> status;

    public static final class StatusPedidoDtoBuilder {
        private Long pedido;
        private List<StatusPedidoEnun> status;

        private StatusPedidoDtoBuilder() {
        }

        public static StatusPedidoDtoBuilder newStatusPedidoDto() {
            return new StatusPedidoDtoBuilder();
        }

        public StatusPedidoDtoBuilder pedido(Long pedido) {
            this.pedido = pedido;
            return this;
        }

        public StatusPedidoDtoBuilder status(List<StatusPedidoEnun> status) {
            this.status = status;
            return this;
        }

        public StatusPedidoDto build() {
            StatusPedidoDto statusPedidoDto = new StatusPedidoDto();
            statusPedidoDto.setPedido(pedido);
            statusPedidoDto.setStatus(status);
            return statusPedidoDto;
        }
    }
}
