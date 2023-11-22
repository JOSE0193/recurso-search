package com.searchtecnologia.recurso.repository.advertencia;

import com.searchtecnologia.recurso.model.advertencia.AutoAutorizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoAutorizacaoRepository extends JpaRepository<AutoAutorizacao, Long>, JpaSpecificationExecutor<AutoAutorizacao> {
}
