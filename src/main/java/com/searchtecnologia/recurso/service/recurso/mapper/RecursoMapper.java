package com.searchtecnologia.recurso.service.recurso.mapper;

import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.service.recurso.dto.RecursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecursoMapper {
    @Mapping(target = "numero", source = "recurso.id.numero")
    RecursoDTO toDTO(Recurso recurso);
}