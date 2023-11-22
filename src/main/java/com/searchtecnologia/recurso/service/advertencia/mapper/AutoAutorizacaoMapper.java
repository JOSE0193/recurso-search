package com.searchtecnologia.recurso.service.advertencia.mapper;

import com.searchtecnologia.recurso.model.advertencia.AutoAutorizacao;
import com.searchtecnologia.recurso.service.advertencia.dto.AdvertenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AutoAutorizacaoMapper {

    @Mapping(target = "idAutorizacao", source = "autoAutorizacao.autorizacaoAdvertencia.id")
    @Mapping(target = "numeroOficio", source = "autoAutorizacao.autorizacaoAdvertencia.numeroOficio")
    @Mapping(target = "data", source = "autoAutorizacao.autorizacaoAdvertencia.data")
    @Mapping(target = "idSessao", source = "autoAutorizacao.autorizacaoAdvertencia.idSessao")
    @Mapping(target = "idServicoSistema", source = "autoAutorizacao.autorizacaoAdvertencia.idServicoSistema")
    @Mapping(target = "idOperador", source = "autoAutorizacao.autorizacaoAdvertencia.idOperador")
    @Mapping(target = "observacao", source = "autoAutorizacao.autorizacaoAdvertencia.observacao")
    @Mapping(target = "operador", source = "autoAutorizacao.autorizacaoAdvertencia.operador")
    AdvertenciaDTO toAdvertenciaDTO(AutoAutorizacao autoAutorizacao);

}
