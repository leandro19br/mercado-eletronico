package br.com.me.util;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.form.PedidoForm;

import java.util.ArrayList;
import java.util.List;

public class CriadorPedidoForm {

    public static PedidoForm criaPedidoAntesDeSalvar() {
        return PedidoForm.PedidoFormBuilder.newPedidoForm()
                .itens(new ArrayList<>(List.of(CriadorProdutoDTO.criaProdutoDTO())))
                .build();

    }

}
