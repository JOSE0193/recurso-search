package com.searchtecnologia.recurso.repository.processo;

import com.searchtecnologia.recurso.model.processo.OrgaoLotacaoTipoProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgaoLotacaoTipoProcessoRepository extends JpaRepository<OrgaoLotacaoTipoProcesso, String>
        , JpaSpecificationExecutor<OrgaoLotacaoTipoProcesso> {

    List<OrgaoLotacaoTipoProcesso> findByCodigoOrgaoOrderByTipoProcesso(String orgao);

}
