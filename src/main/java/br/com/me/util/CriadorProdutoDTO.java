package br.com.me.util;

import br.com.me.dto.ItemPedidoDto;

import java.math.BigDecimal;

public class CriadorProdutoDTO {


    public static ItemPedidoDto criaProdutoDTO() {
        return ItemPedidoDto.ItemPedidoDtoBuilder.newItemPedidoDto()
                .descricao("AÇÚCAR REFINADO UNIÃO 1KG")
                .quantidade(10L)
                .precoUnitario(new BigDecimal(2.99))
                .build();
    }

}
