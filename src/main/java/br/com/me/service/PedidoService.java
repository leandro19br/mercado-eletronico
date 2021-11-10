package br.com.me.service;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.form.PedidoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @project desafio
 * Created by Leandro Saniago on 15/10/2021 - 09:02.
 */

@Service
public interface PedidoService {

    List<PedidoDto> findAll();
    Optional<PedidoDto> findById(Long id);
    PedidoDto save(PedidoForm pedidoForm);
    ResponseEntity<Void> deleteById(Long id);
    PedidoDto atualizar(Long id, PedidoDto pedidoDto);
}
