package br.com.me.dto;

import br.com.me.model.ItemPedido;
import br.com.me.model.Pedido;
import br.com.me.repository.PedidoRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project forum
 * Created by Leandro Saniago on 27/10/2021 - 15:47.
 */
@Data
public class PedidoDto {
    private Long pedido;
    private List<ItemPedidoDto> itens;

    public PedidoDto(Pedido pedido) {
        this.pedido = pedido.getId();
        this.itens = new ArrayList<>();
        itens.addAll(pedido.getItensPedido().stream().map(ItemPedidoDto::new).collect(Collectors.toList()));
    }

    public static List<PedidoDto> converterListaPedido(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }

    public Pedido atualizaPedido(Long id, PedidoRepository pedidoRepository) {
        Pedido pedido = pedidoRepository.getById(id);
        List<ItemPedido> itensPedido = pedido.getItensPedido();
        itensPedido.addAll(itens.stream().map(ItemPedido::new).collect(Collectors.toList()));
        return pedido;
    }


    public static final class PedidoDtoBuilder {
        private Long pedido;
        private List<ItemPedidoDto> itens;

        private PedidoDtoBuilder() {
        }

        public static PedidoDtoBuilder newPedidoDto() {
            return new PedidoDtoBuilder();
        }

        public PedidoDtoBuilder pedido(Long pedido) {
            this.pedido = pedido;
            return this;
        }

        public PedidoDtoBuilder itens(List<ItemPedidoDto> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoDto build() {
            PedidoDto pedidoDto = new PedidoDto(null);
            pedidoDto.setPedido(pedido);
            pedidoDto.setItens(itens);
            return pedidoDto;
        }
    }
}
