package com.searchtecnologia.recurso.repository.multa;

import com.searchtecnologia.recurso.model.multa.Multa;
import com.searchtecnologia.recurso.model.multa.MultaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MultaRepository extends JpaRepository<Multa, MultaPK>, JpaSpecificationExecutor<Multa> {
}
