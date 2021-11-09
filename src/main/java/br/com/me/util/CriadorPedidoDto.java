package br.com.me.util;

import br.com.me.dto.PedidoDto;
import br.com.me.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CriadorPedidoDto {

    public static PedidoDto criaPedidoAntesDeSalvar() {
        return PedidoDto.PedidoDtoBuilder.newPedidoDto()
                .itens(new ArrayList<>(List.of(CriadorProdutoDTO.criaProdutoDTO())))
                        .build();
    }

    public static PedidoDto criaPedidoSalvo() {
        return PedidoDto.PedidoDtoBuilder.newPedidoDto()
                .pedido(1L)
                .itens(new ArrayList<>(List.of(CriadorProdutoDTO.criaProdutoDTO())))
                .build();

    }
}
