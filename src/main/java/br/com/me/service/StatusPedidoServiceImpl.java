package br.com.me.service;

import br.com.me.dto.StatusPedidoDto;
import br.com.me.dto.form.StatusPedidoForm;
import br.com.me.enun.StatusPedidoEnun;
import br.com.me.exception.BadRequestExeception;
import br.com.me.model.Pedido;
import br.com.me.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @project codeblog
 * Created by Leandro Saniago on 01/11/2021 - 16:42.
 */
@Service
public class StatusPedidoServiceImpl implements StatusPedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    public StatusPedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public StatusPedidoDto alteraStatusPedido(StatusPedidoForm statusPedidoForm) {
        Pedido pedido = pedidoRepository.findById(statusPedidoForm.getPedido()).get();
        List<StatusPedidoEnun> statusPedidoEnuns = new ArrayList<>();
        StatusPedidoDto statusPedidoDto = new StatusPedidoDto();

        if (!pedido.equals(null)) {
            if (statusPedidoForm.getStatus() == StatusPedidoEnun.REPROVADO ){
                statusPedidoEnuns.add(StatusPedidoEnun.REPROVADO);//1 condição
            }else if (statusPedidoForm.getStatus() == StatusPedidoEnun.APROVADO  &&statusPedidoForm.getItensAprovados().equals(pedido.getquantidadeTotalPedido()) && statusPedidoForm.getValorAprovado().compareTo(pedido.getValorTotalPedido())== 0) {
                statusPedidoEnuns.add(StatusPedidoEnun.APROVADO);//1 condição
            }else if (statusPedidoForm.getStatus() == StatusPedidoEnun.APROVADO && statusPedidoForm.getValorAprovado().compareTo(pedido.getValorTotalPedido()) == -1){
                statusPedidoEnuns.add(StatusPedidoEnun.APROVADO_VALOR_A_MENOR);//2 condição
            }else if (statusPedidoForm.getStatus() == StatusPedidoEnun.APROVADO && statusPedidoForm.getItensAprovados() < (pedido.getquantidadeTotalPedido())){
                statusPedidoEnuns.add(StatusPedidoEnun.APROVADO_QTD_A_MENOR);//3 condição
            }else if (statusPedidoForm.getStatus() == StatusPedidoEnun.APROVADO  && statusPedidoForm.getValorAprovado().compareTo(pedido.getValorTotalPedido()) == 1){
                statusPedidoEnuns.add(StatusPedidoEnun.APROVADO_VALOR_A_MAIOR);//4 condição
            }else if (statusPedidoForm.getStatus() == StatusPedidoEnun.APROVADO && statusPedidoForm.getItensAprovados() > (pedido.getquantidadeTotalPedido())){
                statusPedidoEnuns.add(StatusPedidoEnun.APROVADO_QTD_A_MAIOR);//5 condição
            }
            statusPedidoDto.setPedido(statusPedidoForm.getPedido());
            statusPedidoDto.setStatus(statusPedidoEnuns);

        } else {
            statusPedidoEnuns.add(StatusPedidoEnun.CODIGO_PEDIDO_INVALIDO);
            statusPedidoDto.setPedido(statusPedidoForm.getPedido());
            statusPedidoDto.setStatus(statusPedidoEnuns);
            throw new BadRequestExeception("Pedido com código inválido");
        }

        return statusPedidoDto;
    }
}
