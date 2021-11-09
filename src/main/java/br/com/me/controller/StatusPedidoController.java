package br.com.me.controller;

import br.com.me.dto.PedidoDto;
import br.com.me.dto.StatusPedidoDto;
import br.com.me.dto.form.StatusPedidoForm;
import br.com.me.service.PedidoService;
import br.com.me.service.StatusPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/status")
public class StatusPedidoController {

    private StatusPedidoService statusPedidoService;

    @Autowired
    public StatusPedidoController(StatusPedidoService statusPedidoService) {
        this.statusPedidoService = statusPedidoService;
    }

    @PostMapping
    public ResponseEntity<StatusPedidoDto> alterarStatusPedido(@RequestBody @Valid StatusPedidoForm statusPedidoForm) {
        statusPedidoService.alteraStatusPedido(statusPedidoForm);
        return null;
    }

}
