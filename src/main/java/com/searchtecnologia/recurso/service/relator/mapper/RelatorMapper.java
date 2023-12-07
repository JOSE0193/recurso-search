package com.searchtecnologia.recurso.service.relator.mapper;

import com.searchtecnologia.recurso.model.relator.Relator;
import com.searchtecnologia.recurso.service.relator.dto.CadastroRelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorSalvoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RelatorMapper {

    RelatorMapper INSTANCE = Mappers.getMapper(RelatorMapper.class);

    @Mapping(target = "codigo", source = "id.codigo")
    @Mapping(target = "orgaoAutuador", source = "orgaoAutuador.codigo")
    @Mapping(target = "descricaoJari", source = "jari.tipoJari")
    RelatorDTO toDTO(Relator relator);

    RelatorSalvoDTO toSaveDTO(Relator relator);

}