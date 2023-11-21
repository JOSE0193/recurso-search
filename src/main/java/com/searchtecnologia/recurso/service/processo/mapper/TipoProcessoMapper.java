package com.searchtecnologia.recurso.service.processo.mapper;

import com.searchtecnologia.recurso.model.processo.OrgaoLotacaoTipoProcesso;
import com.searchtecnologia.recurso.service.processo.dto.TipoProcessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TipoProcessoMapper {

    TipoProcessoDTO toDTO(OrgaoLotacaoTipoProcesso orgaoLotacaoTipoProcesso);
}
