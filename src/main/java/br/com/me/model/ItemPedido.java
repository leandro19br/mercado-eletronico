package br.com.me.model;

import br.com.me.dto.ItemPedidoDto;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal precoUnitario;
    private Long quantidade;
    @ManyToOne
    private Pedido pedido;
    @Transient
    private BigDecimal valorTotalItem;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.descricao = itemPedido.getDescricao();
        this.precoUnitario = itemPedido.getPrecoUnitario();
        this.quantidade = itemPedido.getQuantidade();
    }

    public ItemPedido(ItemPedidoDto itemPedidoDto) {
        this.id = itemPedidoDto.getId();
        this.descricao = itemPedidoDto.getDescricao();
        this.precoUnitario = itemPedidoDto.getPrecoUnitario();
        this.quantidade = itemPedidoDto.getQuantidade();
    }

    public BigDecimal getValorTotalItem() {
        return this.precoUnitario.multiply(BigDecimal.valueOf(this.quantidade));
    }

    public static final class ItemPedidoBuilder {
        private Long id;
        private String descricao;
        private BigDecimal precoUnitario;
        private Long quantidade;
        private Pedido pedido;

        private ItemPedidoBuilder() {
        }

        public static ItemPedidoBuilder newItemPedido() {
            return new ItemPedidoBuilder();
        }

        public ItemPedidoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemPedidoBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ItemPedidoBuilder precoUnitario(BigDecimal precoUnitario) {
            this.precoUnitario = precoUnitario;
            return this;
        }

        public ItemPedidoBuilder quantidade(Long quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemPedidoBuilder pedido(Pedido pedido) {
            this.pedido = pedido;
            return this;
        }

        public ItemPedido build() {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setId(id);
            itemPedido.setDescricao(descricao);
            itemPedido.setPrecoUnitario(precoUnitario);
            itemPedido.setQuantidade(quantidade);
            itemPedido.setPedido(pedido);
            return itemPedido;
        }
    }
}
