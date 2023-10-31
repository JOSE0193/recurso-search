package com.searchtecnologia.recurso.service.resultado.mapper;

import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.service.resultado.dto.CadastrarResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoSalvoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.TiposResultadoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResultadoMapper {

    ResultadoDTO toDTO(Resultado resultado);

    TiposResultadoDTO toTiposResultadoDTO(Resultado resultado);


    ResultadoSalvoDTO toResultadoSalvoDTO(Resultado resultado);

    @InheritInverseConfiguration
    Resultado toEntity(ResultadoSalvoDTO resultadoSalvoDTO);

    @InheritInverseConfiguration
    Resultado toEntityCadastro(CadastrarResultadoDTO cadastrarResultadoDTO);

}