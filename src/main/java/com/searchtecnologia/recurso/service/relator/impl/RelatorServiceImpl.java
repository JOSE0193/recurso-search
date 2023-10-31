package com.searchtecnologia.recurso.service.relator.impl;

import com.searchtecnologia.recurso.exception.NotFoundException;
import com.searchtecnologia.recurso.model.jari.Jari;
import com.searchtecnologia.recurso.model.jari.JariPK;
import com.searchtecnologia.recurso.model.jari.TipoJari;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.relator.Relator;
import com.searchtecnologia.recurso.model.relator.RelatorPK;
import com.searchtecnologia.recurso.model.resultado.*;
import com.searchtecnologia.recurso.repository.relator.RelatorRepository;
import com.searchtecnologia.recurso.service.relator.RelatorService;
import com.searchtecnologia.recurso.service.relator.dto.CadastroRelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorSalvoDTO;
import com.searchtecnologia.recurso.service.relator.mapper.RelatorMapper;
import com.searchtecnologia.recurso.service.relator.query.criteria.RelatorCriteria;
import com.searchtecnologia.recurso.service.relator.query.filter.TipoJariFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.AtivoFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.relator.query.specification.RelatorSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class RelatorServiceImpl implements RelatorService {

    private final RelatorRepository repository;
    private final RelatorMapper mapper;

    /**
     * PROCEDURE: PKG_SGM_RECURSO_RESULTADO.FNC_LISTAR_RELATOR
     */
    @Override
    public List<RelatorDTO> listarRelatores(String codigoRelator, String descricaoRelator, String orgaoRelator, String codigoJari,
                                            String tipoJari, String ativo) {

        RelatorCriteria criteria = RelatorCriteria.builder()
                .codigo(StringFilter.buildEquals(codigoRelator))
                .nome(StringFilter.buildEquals(descricaoRelator))
                .jari(StringFilter.buildEquals(codigoJari))
                .tipoJari(StringFilter.buildEquals(tipoJari))
                .orgaoAutuador(StringFilter.buildEquals(orgaoRelator))
                .ativo(StringFilter.buildEquals(ativo))
                .build();
        return this.repository.findAll(buildSpecification(criteria))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * PROCEDURE: PKG_SGM_RECURSO_RESULTADO.FNC_VERIFICA_SE_EXISTE
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
     * PROCEDURE: PKG_SGM_RECURSO_RESULTADO.FNC_GERAR_CODIGO_RELATOR
     */
    public String gerarCodigoRelator() {
            Optional<Relator> codigoRelator = repository.findTopByOrderByIdCodigo();
        if (codigoRelator.isPresent()) {
            Relator relator = codigoRelator.get();
            int proximoCodigo = Integer.parseInt(relator.getId().getCodigo()) + 1;
            return String.format("%03d", proximoCodigo);
        } else {
            return "001"; // Se nenhum código estiver em uso, retorne "001"
        }
    }



    /**
     * PROCEDURE: PKG_SGM_RECURSO_RESULTADO.PRC_SALVAR_RELATOR
     */
    @Override
    public RelatorSalvoDTO salvarRelator(CadastroRelatorDTO cadastroRelatorDTO) {
        if (cadastroRelatorDTO.update().equals("S")) {
            Relator relator = this.atualizarRelator(cadastroRelatorDTO);
            return mapper.toSaveDTO(relator);
        }
        return this.mapper.toSaveDTO(cadastrarRelator(cadastroRelatorDTO));
    }

    private Relator cadastrarRelator(CadastroRelatorDTO cadastroRelatorDTO){
        Relator relator = new Relator();
        RelatorPK relatorPK = new RelatorPK();
        relatorPK.setCodigo(cadastroRelatorDTO.codigo());
        relator.setId(relatorPK);
        relator.setNome(cadastroRelatorDTO.nome());
        relator.setMaricula(cadastroRelatorDTO.matricula());
        relator.setAtivo(SimNao.valueOf(cadastroRelatorDTO.ativo().getValor()));
        relator.setDataCadastro(LocalDate.now());
        relator.setHoraCadastro(LocalTime.now());
        relator.setOperadorCadastro(cadastroRelatorDTO.operador());
        relator.setEstacaoCadastro(cadastroRelatorDTO.estacao());
        relator.setFuncaoCadastro(cadastroRelatorDTO.funcao());

        OrgaoAutuador orgaoAutuador = new OrgaoAutuador();
        orgaoAutuador.setCodigo(cadastroRelatorDTO.codigoOrgao());
        relator.setOrgaoAutuador(orgaoAutuador);

        Jari jari = new Jari();
        JariPK jariPK = new JariPK();
        jariPK.setCodigo(cadastroRelatorDTO.codigoJari());
        jari.setId(jariPK);
        relator.setJari(jari);
        relator =  repository.save(relator);

        return relator;
    }

    private Relator atualizarRelator(CadastroRelatorDTO cadastroRelatorDTO){
        Relator relator = repository.findByIdCodigo(cadastroRelatorDTO.codigo())
                .orElseThrow(() -> new NotFoundException("O código do relator não existe"));
        RelatorPK relatorPK = new RelatorPK();
        relatorPK.setCodigo(cadastroRelatorDTO.codigo());
        relator.setId(relatorPK);
        relator.setNome(cadastroRelatorDTO.nome());
        relator.setMaricula(cadastroRelatorDTO.matricula());
        relator.setAtivo(SimNao.valueOf(cadastroRelatorDTO.ativo().getValor()));
        relator.setDataCadastro(LocalDate.now());
        relator.setHoraCadastro(LocalTime.now());
        relator.setOperadorCadastro(cadastroRelatorDTO.operador());
        relator.setEstacaoCadastro(cadastroRelatorDTO.estacao());
        relator.setFuncaoCadastro(cadastroRelatorDTO.funcao());

        OrgaoAutuador orgaoAutuador = new OrgaoAutuador();
        orgaoAutuador.setCodigo(cadastroRelatorDTO.codigoOrgao());
        relator.setOrgaoAutuador(orgaoAutuador);

        Jari jari = new Jari();
        JariPK jariPK = new JariPK();
        jariPK.setCodigo(cadastroRelatorDTO.codigoJari());
        jari.setId(jariPK);
        relator.setJari(jari);
        return repository.save(relator);
    }

}