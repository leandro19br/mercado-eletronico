package br.com.me.util;

import br.com.me.model.ItemPedido;

import java.math.BigDecimal;

public class CriadorProduto {


    public static ItemPedido criaProduto() {
        return ItemPedido.ItemPedidoBuilder.newItemPedido()
                .descricao("AÇÚCAR REFINADO UNIÃO 1KG")
                .precoUnitario(new BigDecimal(3.99))
                .quantidade(100L)
                .build();
    }

}
