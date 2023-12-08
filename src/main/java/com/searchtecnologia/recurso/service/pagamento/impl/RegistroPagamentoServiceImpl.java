package com.searchtecnologia.recurso.service.pagamento.impl;

import com.searchtecnologia.recurso.repository.pagamento.RegistroPagamentoMultaRepository;
import com.searchtecnologia.recurso.service.pagamento.RegistroPagamentoService;
import com.searchtecnologia.recurso.service.pagamento.query.criteria.RegistroPagamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.searchtecnologia.recurso.service.pagamento.query.specification.RegistroPagamentoSpecification.buildSpecification;


@Service
@Transactional
@AllArgsConstructor
public class RegistroPagamentoServiceImpl implements RegistroPagamentoService {

    private RegistroPagamentoMultaRepository registroPagamentoMultaRepository;

    /**
     * FUNÇÃO: PKG_SGM_INFRACAO_CONSULTA.FNC_POSSUI_HIST_PAGAMENTO
     */
    @Override
    public String possuiHistoricoPagamento(String numeroAuto, String codigoInfracao, String orgaoAutuador) {
        RegistroPagamentoCriteria criteria = RegistroPagamentoCriteria.builder()
                .numeroAuto(StringFilter.buildEquals(numeroAuto))
                .codigoInfracao(StringFilter.buildEquals(codigoInfracao))
                .orgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .build();
        Long quantidade = this.registroPagamentoMultaRepository.count(buildSpecification(criteria));
        if(quantidade > 0){
            return "S";
        }
        return "N";
    }
}
