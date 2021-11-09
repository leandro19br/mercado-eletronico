package br.com.me.util;

import br.com.me.dto.StatusPedidoDto;
import br.com.me.dto.form.StatusPedidoForm;
import br.com.me.enun.StatusPedidoEnun;

import java.math.BigDecimal;
import java.util.List;

public class CriadorStatusPedidoDto {

    public static StatusPedidoDto criaStatusPedidoAprovado() {
        return StatusPedidoDto.StatusPedidoDtoBuilder.newStatusPedidoDto()
                .pedido(1L)
                .status(List.of(StatusPedidoEnun.APROVADO))
                .build();
    }

    public static StatusPedidoDto criaStatusPedidoReprovado() {
        return StatusPedidoDto.StatusPedidoDtoBuilder.newStatusPedidoDto()
                .pedido(1L)
                .status(List.of(StatusPedidoEnun.REPROVADO))
                .build();

    }

}
