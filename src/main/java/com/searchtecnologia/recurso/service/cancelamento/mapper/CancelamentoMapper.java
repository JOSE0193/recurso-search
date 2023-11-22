package com.searchtecnologia.recurso.service.cancelamento.mapper;

import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;
import com.searchtecnologia.recurso.model.cancelamento.CancelamentoMulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CancelamentoMapper {

    @Mapping(target = "numeroAuto", source = "id.numeroAuto")
    @Mapping(target = "sequencial", source = "id.sequencial")
    @Mapping(target = "descricaoOrgao", source = "orgaoAutuador.descricao")
    @Mapping(target = "codigoMotivo", source = "motivoCancelamento.id.codigo")
    @Mapping(target = "descricaoMotivo", source = "motivoCancelamento.descricao")
    @Mapping(target = "descricaoMotivoExclusao", source = "rinfMotivoCancelamento.descricao")
    CancelamentoDTO toDTO(CancelamentoMulta cancelamento);

}
