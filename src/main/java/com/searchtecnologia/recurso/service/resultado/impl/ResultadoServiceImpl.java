package com.searchtecnologia.recurso.service.resultado.impl;

import com.searchtecnologia.recurso.exception.NotFoundException;
import com.searchtecnologia.recurso.model.resultado.*;
import com.searchtecnologia.recurso.repository.resultado.ResultadoRepository;
import com.searchtecnologia.recurso.service.resultado.ResultadoService;
import com.searchtecnologia.recurso.service.resultado.dto.CadastrarResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoSalvoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.TiposResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.mapper.ResultadoMapper;
import com.searchtecnologia.recurso.service.resultado.query.criteria.ResultadoCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.resultado.query.specification.ResultadoSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class ResultadoServiceImpl implements ResultadoService {

    private final ResultadoRepository repository;
    private final ResultadoMapper mapper;

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_RESULTADO.FNC_LISTAR_RESULTADO
     */
    @Override
    public List<ResultadoDTO> listarResultados(String codigoResultado, String descResultado, String tipoJulgamento,
                                             String tipoRecurso, String ativos, String orgaoAnalisador) {
        ResultadoCriteria criteria = ResultadoCriteria.builder()
                .codigoResultado(StringFilter.buildEquals(codigoResultado))
                .tipoJulgamento(StringFilter.buildEquals(tipoJulgamento))
                .tipoRecurso(StringFilter.buildEquals(tipoRecurso))
                .descricaoResultado(StringFilter.buildContains(descResultado))
                .ativoResultado(StringFilter.buildEquals(ativos))
                .ativoMotivo(StringFilter.buildEquals("SIM"))
                .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                .build();
        return this.repository.findAll(buildSpecification(criteria))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_RESULTADO.FNC_LISTAR_RESULTADO_TIPO
     */
    @Override
    public List<TiposResultadoDTO> listarTiposResultado() {
        String ativo = "S";
        List<Resultado> listaTiposResultado = repository.findByAtivo(ativo);
        return listaTiposResultado.stream()
                .map(mapper::toTiposResultadoDTO)
                .collect(Collectors.toList());
    }

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_RESULTADO.FNC_VERIFICA_SE_EXISTE
     */
    @Override
    public String veirificarSeExiste(String codigo) {
        Long quantidadeResultados = repository.countByIdCodigo(codigo);
        if(quantidadeResultados > 0){
            return "S";
        }
        return "N";
    }

    /**
     * PROCEDURE: PKG_SGM_RECURSO_RESULTADO.PRC_SALVAR_RESULTADO
     */
    @Override
    public ResultadoSalvoDTO salvarResultado(CadastrarResultadoDTO cadastrarResultadoDTO) {
        if (cadastrarResultadoDTO.update().equals("S")) {
            Resultado resultado = this.atualizarResultado(cadastrarResultadoDTO);
            return mapper.toResultadoSalvoDTO(resultado);
        }
            return this.mapper.toResultadoSalvoDTO(cadastrarResultado(cadastrarResultadoDTO));
    }
    private Resultado cadastrarResultado(CadastrarResultadoDTO cadastrarResultadoDTO){
        Resultado resultado = new Resultado();
        ResultadoPK resultadoPK = new ResultadoPK();
        resultadoPK.setCodigo(cadastrarResultadoDTO.codigoResultado());
        resultado.setId(resultadoPK);
        resultado.setDescricao(cadastrarResultadoDTO.descricao());
        resultado.setTipoJulgamento(TipoJulgamentoResultado.valueOf(cadastrarResultadoDTO.tipoJulgamento()));
        resultado.setTipoRecurso(TipoRecursoResultado.valueOf(cadastrarResultadoDTO.tipoRecurso()));
        resultado.setConhecido(SimNao.S);
        resultado.setExigeEdital(SimNao.N);
        resultado.setNovoPrazo(NovoPrazo.N);
        resultado =  repository.save(resultado);
        return resultado;
    }

    private Resultado atualizarResultado(CadastrarResultadoDTO cadastrarResultadoDTO){
        Resultado resultado = repository.findByIdCodigo(cadastrarResultadoDTO.codigoResultado())
                .orElseThrow(() -> new NotFoundException("O código de resultado não existe"));
        ResultadoPK resultadoPK = new ResultadoPK();
        resultadoPK.setCodigo(cadastrarResultadoDTO.codigoResultado());
        resultado.setId(resultadoPK);
        resultado.setDescricao(cadastrarResultadoDTO.descricao());
        resultado.setTipoJulgamento(TipoJulgamentoResultado.valueOf(cadastrarResultadoDTO.tipoJulgamento()));
        resultado.setTipoRecurso(TipoRecursoResultado.valueOf(cadastrarResultadoDTO.tipoRecurso()));
        resultado.setConhecido(SimNao.S);
        resultado.setExigeEdital(SimNao.N);
        resultado.setNovoPrazo(NovoPrazo.N);
        return repository.save(resultado);
    }

}


