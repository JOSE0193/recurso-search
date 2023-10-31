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

    @Mapping(target = "codigo", source = "relator.id.codigo")
    @Mapping(target = "orgaoAutuador", source = "relator.orgaoAutuador.codigo")
    @Mapping(target = "codigoJari", source = "relator.jari.id.codigo")
    @Mapping(target = "descricaoJari", source = "relator.jari.tipoJari")
    RelatorDTO toDTO(Relator relator);

    @Mapping(target = "codigo", source = "relator.id.codigo")
    @Mapping(target = "codigoOrgao", source = "relator.id.codigoOrgaoAutuador")
    @Mapping(target = "jari", source = "relator.jari.id.codigo")
    RelatorSalvoDTO toSaveDTO(Relator relator);

//    @Mapping(target = "codigo", source = "relator.id.codigo")
//    @Mapping(target = "orgaoAutuador", source = "relator.orgaoAutuador.codigo")
//    @Mapping(target = "codigoJari", source = "relator.jari.id.codigo")
//    @Mapping(target = "descricaoJari", source = "relator.jari.tipoJari")
//    @Mapping(target = "update", ignore = true)
//    CadastroRelatorDTO toCadastroDTO(Relator relator);

    @InheritInverseConfiguration
    Relator toEntity(RelatorDTO relatorDTO);

}