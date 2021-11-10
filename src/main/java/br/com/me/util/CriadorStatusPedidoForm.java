package br.com.me.util;

import br.com.me.dto.StatusPedidoDto;
import br.com.me.dto.form.StatusPedidoForm;
import br.com.me.enun.StatusPedidoEnun;
import br.com.me.model.ItemPedido;

import java.math.BigDecimal;

public class CriadorStatusPedidoForm {

    public static StatusPedidoForm criaStatusPedidoAprovado() {
        return StatusPedidoForm.StatusPedidoFormBuilder.newStatusPedidoForm()
                .pedido(1L)
                .status("APROVADO")
                .valorAprovado(new BigDecimal(20))
                .itensAprovados(3L)
                .build();
    }

    public static StatusPedidoForm criaStatusPedidoReprovado() {
        return StatusPedidoForm.StatusPedidoFormBuilder.newStatusPedidoForm()
                .pedido(1L)
                .status("REPROVADO")
                .valorAprovado(new BigDecimal(20))
                .itensAprovados(3L)
                .build();
    }

}
