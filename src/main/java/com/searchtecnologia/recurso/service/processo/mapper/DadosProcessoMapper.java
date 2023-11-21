package com.searchtecnologia.recurso.service.processo.mapper;

import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import com.searchtecnologia.recurso.service.processo.dto.DadosProcessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DadosProcessoMapper {

    DadosProcessoDTO toDTO(DadosProcessoView dadosProcesso);

}
