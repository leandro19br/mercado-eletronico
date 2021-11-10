package br.com.me.service;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.form.PedidoForm;
import br.com.me.model.Pedido;
import br.com.me.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @project codeblog
 * Created by Leandro Saniago on 01/11/2021 - 16:42.
 */
@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<PedidoDto> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return PedidoDto.converterListaPedido(pedidos);
    }

    @Override
    public Optional<PedidoDto> findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return Optional.of(new PedidoDto(pedido.get()));
    }

    @Override
    public PedidoDto save(PedidoForm pedidoForm) {
        Pedido pedido = new Pedido(pedidoForm);
        Pedido PedidoSalvo = pedidoRepository.save(pedido);
        return new PedidoDto(PedidoSalvo);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        pedidoRepository.deleteById(id);
        return null;
    }

    @Override
    public PedidoDto atualizar(Long id, PedidoDto pedidoDto) {
        Pedido pedidoAtualizado = pedidoDto.atualizaPedido(id, pedidoRepository);
        return new PedidoDto(pedidoAtualizado);
    }
}
