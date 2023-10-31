package com.searchtecnologia.recurso.repository.processo;

import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosProcessoRepository extends JpaRepository<DadosProcessoView, String>, JpaSpecificationExecutor<DadosProcessoView> {
}
