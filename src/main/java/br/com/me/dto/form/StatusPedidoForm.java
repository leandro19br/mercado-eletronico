package br.com.me.dto.form;

import br.com.me.enun.StatusPedidoEnun;
import br.com.me.model.Pedido;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @project desafio
 * Created by Leandro Saniago on 09/11/2021 - 10:06.
 */
@Data
public class StatusPedidoForm {

    @NotNull @NotBlank
    private StatusPedidoEnun status;
    @NotNull @NotBlank
    private Long itensAprovados;
    @NotNull @NotBlank
    private BigDecimal valorAprovado;
    @NotNull @NotBlank
    private Long pedido;


    public static final class StatusPedidoFormBuilder {
        private StatusPedidoEnun status;
        private Long itensAprovados;
        private BigDecimal valorAprovado;
        private Long pedido;

        private StatusPedidoFormBuilder() {
        }

        public static StatusPedidoFormBuilder newStatusPedidoForm() {
            return new StatusPedidoFormBuilder();
        }

        public StatusPedidoFormBuilder status(StatusPedidoEnun status) {
            this.status = status;
            return this;
        }

        public StatusPedidoFormBuilder itensAprovados(Long itensAprovados) {
            this.itensAprovados = itensAprovados;
            return this;
        }

        public StatusPedidoFormBuilder valorAprovado(BigDecimal valorAprovado) {
            this.valorAprovado = valorAprovado;
            return this;
        }

        public StatusPedidoFormBuilder pedido(Long pedido) {
            this.pedido = pedido;
            return this;
        }

        public StatusPedidoForm build() {
            StatusPedidoForm statusPedidoForm = new StatusPedidoForm();
            statusPedidoForm.setStatus(status);
            statusPedidoForm.setItensAprovados(itensAprovados);
            statusPedidoForm.setValorAprovado(valorAprovado);
            statusPedidoForm.setPedido(pedido);
            return statusPedidoForm;
        }
    }
}
