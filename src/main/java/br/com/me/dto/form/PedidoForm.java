package br.com.me.dto.form;

import br.com.me.dto.ItemPedidoDto;
import br.com.me.model.ItemPedido;
import br.com.me.model.Pedido;
import br.com.me.repository.PedidoRepository;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project forum
 * Created by Leandro Saniago on 27/10/2021 - 15:47.
 */
@Data
public class PedidoForm {

    private List<ItemPedidoDto> itens;

    public PedidoForm() {
    }

    public PedidoForm(Pedido pedido) {
        this.itens = new ArrayList<>();
        itens.addAll(pedido.getItensPedido().stream().map(ItemPedidoDto::new).collect(Collectors.toList()));
    }

    public static List<PedidoForm> converterListaPedido(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoForm::new).collect(Collectors.toList());
    }

    public Pedido atualizaPedido(Long id, PedidoRepository pedidoRepository) {
        Pedido pedido = pedidoRepository.getById(id);
        List<ItemPedido> itensPedido = pedido.getItensPedido();
        itensPedido.addAll(itens.stream().map(ItemPedido::new).collect(Collectors.toList()));
        return pedido;
    }


    public static final class PedidoFormBuilder {
        private List<ItemPedidoDto> itens;

        private PedidoFormBuilder() {
        }

        public static PedidoFormBuilder newPedidoForm() {
            return new PedidoFormBuilder();
        }

        public PedidoFormBuilder itens(List<ItemPedidoDto> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoForm build() {
            PedidoForm pedidoForm = new PedidoForm();
            pedidoForm.setItens(itens);
            return pedidoForm;
        }
    }
}
