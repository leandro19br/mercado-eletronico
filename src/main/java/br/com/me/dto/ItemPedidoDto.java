package br.com.me.dto;

import br.com.me.model.ItemPedido;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @project desafio
 * Created by Leandro Saniago on 05/11/2021 - 11:31.
 */
@Data
public class ItemPedidoDto {

    private Long id;
    private String descricao;
    private BigDecimal precoUnitario;
    private Long quantidade;

    public ItemPedidoDto(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.descricao = itemPedido.getDescricao();
        this.precoUnitario = itemPedido.getPrecoUnitario();
        this.quantidade = itemPedido.getQuantidade();
    }


    public static final class ItemPedidoDtoBuilder {
        private Long id;
        private String descricao;
        private BigDecimal precoUnitario;
        private Long quantidade;

        private ItemPedidoDtoBuilder() {
        }

        public static ItemPedidoDtoBuilder newItemPedidoDto() {
            return new ItemPedidoDtoBuilder();
        }

        public ItemPedidoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemPedidoDtoBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ItemPedidoDtoBuilder precoUnitario(BigDecimal precoUnitario) {
            this.precoUnitario = precoUnitario;
            return this;
        }

        public ItemPedidoDtoBuilder quantidade(Long quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemPedidoDto build() {
            ItemPedidoDto itemPedidoDto = new ItemPedidoDto(null);
            itemPedidoDto.setId(id);
            itemPedidoDto.setDescricao(descricao);
            itemPedidoDto.setPrecoUnitario(precoUnitario);
            itemPedidoDto.setQuantidade(quantidade);
            return itemPedidoDto;
        }
    }
}
