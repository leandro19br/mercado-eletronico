package br.com.me.controller;

import br.com.me.service.PedidoService;
import br.com.me.service.StatusPedidoService;
import br.com.me.util.CriadorPedidoDto;
import br.com.me.util.CriadorStatusPedidoDto;
import br.com.me.util.CriadorStatusPedidoForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @project desafio
 * Created by Leandro Saniago on 09/11/2021 - 19:07.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StatusPedidoControllerTest {

    @InjectMocks
    StatusPedidoController statusPedidoControllerMock;

    @Mock
    StatusPedidoService statusPedidoServiceMock;

    @BeforeEach
    void setup() {
        BDDMockito.when(statusPedidoServiceMock.alteraStatusPedido(CriadorStatusPedidoForm.criaStatusPedidoAprovado())).thenReturn(CriadorStatusPedidoDto.criaStatusPedidoAprovado());
        BDDMockito.when(statusPedidoServiceMock.alteraStatusPedido(CriadorStatusPedidoForm.criaStatusPedidoReprovado())).thenReturn(CriadorStatusPedidoDto.criaStatusPedidoReprovado());
    }

    @Test
    void DevealterarStatusPedidoQuandoReprovado() {


    }
    @Test
    void DevealterarStatusPedidoQuandoAprovado() {


    }
}