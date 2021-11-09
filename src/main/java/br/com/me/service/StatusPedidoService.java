package br.com.me.service;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.StatusPedidoDto;
import br.com.me.dto.form.StatusPedidoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @project desafio
 * Created by Leandro Saniago on 15/10/2021 - 09:02.
 */

@Service
public interface StatusPedidoService {

    StatusPedidoDto alteraStatusPedido(StatusPedidoForm statusPedidoForm);

}
