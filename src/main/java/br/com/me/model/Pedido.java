package br.com.me.model;


import br.com.me.dto.ItemPedidoDto;
import br.com.me.dto.PedidoDto;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project desafio
 * Created by Leandro Saniago on 15/10/2021 - 09:18.
 * Classe representa o objeto Pedido
 */

@Entity
@Data
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(Long id, List<ItemPedido> itensPedido) {
        this.id = id;
        this.itensPedido = itensPedido;
    }

    public Pedido(PedidoDto pedidoDto) {
        this.id = pedidoDto.getPedido();
        this.itensPedido = new ArrayList<>();
        this.itensPedido.addAll(pedidoDto.getItens().stream().map(ItemPedido::new).collect(Collectors.toList()));
    }

    public Long getquantidadeTotalPedido() {
        return itensPedido.stream().mapToLong(ItemPedido::getQuantidade).sum();
    }
    public BigDecimal getValorTotalPedido() {
        return itensPedido.stream().map(ItemPedido::getValorTotalItem).reduce(BigDecimal::add).get();
    }

    public static final class PedidoBuilder {
        private Long id;
        private List<ItemPedido> itensPedido;

        private PedidoBuilder() {
        }

        public static PedidoBuilder newPedido() {
            return new PedidoBuilder();
        }

        public PedidoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PedidoBuilder itensPedido(List<ItemPedido> itensPedido) {
            this.itensPedido = itensPedido;
            return this;
        }

        public Pedido build() {
            Pedido pedido = new Pedido();
            pedido.setId(id);
            pedido.setItensPedido(itensPedido);
            return pedido;
        }
    }
}
