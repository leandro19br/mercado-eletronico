package br.com.me.controller;

import br.com.me.dto.PedidoDto;
import br.com.me.service.PedidoService;
import br.com.me.util.CriadorPedidoDto;
import br.com.me.util.CriadorPedidoForm;
import br.com.me.util.CriadorProdutoDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @project desafio
 * Created by Leandro Saniago on 08/11/2021 - 15:48.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PedidoControllerTest {

    @InjectMocks
    PedidoController pedidoControllerMock;

    @Mock
    PedidoService pedidoServiceMock;

    @BeforeEach
    void setup() {
        BDDMockito.when(pedidoServiceMock.findAll()).thenReturn(Arrays.asList(CriadorPedidoDto.criaPedidoAntesDeSalvar()));
        BDDMockito.when(pedidoServiceMock.save(ArgumentMatchers.any())).thenReturn(CriadorPedidoDto.criaPedidoSalvo());
        BDDMockito.when(pedidoServiceMock.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CriadorPedidoDto.criaPedidoSalvo()));
        BDDMockito.when(pedidoServiceMock.atualizar(ArgumentMatchers.anyLong(),CriadorPedidoDto.criaPedidoAntesDeSalvar())).thenReturn(CriadorPedidoDto.criaPedidoSalvo());
        BDDMockito.doNothing().when(pedidoServiceMock).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    void deveRetornarTodosPedidosQuandoSucesso() {
        List<PedidoDto> listPedido = pedidoServiceMock.findAll();
        Assertions.assertThat(listPedido)
                .isNotNull();
    }

    @Test
    void deveRetornarPedidoPorIdQuandoSuccesso() {
        Optional<PedidoDto> byId = pedidoServiceMock.findById(1L);
        Assertions.assertThat(byId)
                .isNotNull();
    }

    @Test
    void devesalvarPedidoquandoSucesso() {
        PedidoDto pedido = pedidoServiceMock.save(CriadorPedidoForm.criaPedidoAntesDeSalvar());
        Assertions.assertThat(pedido)
                .isNotNull()
        .isEqualTo(CriadorPedidoDto.criaPedidoSalvo());
    }

    @Test
    void deveAtualizarPedidoQuandoSucesso() {
        PedidoDto atualizado = pedidoServiceMock.atualizar(1L, CriadorPedidoDto.criaPedidoAntesDeSalvar());
        Assertions.assertThat(atualizado)
                .isNotNull();
    }

    @Test
    void deveRemoverPedidoQuandoSuccesso() {
         ResponseEntity<Void> entity = pedidoServiceMock.deleteById(1L);
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}