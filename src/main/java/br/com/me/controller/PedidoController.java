package br.com.me.controller;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.form.PedidoForm;
import br.com.me.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<PedidoDto>> listAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Long id) {
        Optional<PedidoDto> pedidoDto = pedidoService.findById(id);
        if (pedidoDto.isPresent()) {
            return new ResponseEntity(pedidoDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> salvar(@RequestBody @Valid PedidoForm pedidoForm) {
        return new ResponseEntity<PedidoDto>(pedidoService.save(pedidoForm), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoDto pedidoDto) {
        Optional<PedidoDto> topicoOptional = pedidoService.findById(id);
        if (topicoOptional.isPresent()) {
            PedidoDto pedidoAtualizado = pedidoService.atualizar(id, pedidoDto);
            return ResponseEntity.ok(pedidoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<PedidoDto> pedidoDto = pedidoService.findById(id);
        if (pedidoDto.isPresent()) {
            pedidoService.deleteById(pedidoDto.get().getPedido());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
