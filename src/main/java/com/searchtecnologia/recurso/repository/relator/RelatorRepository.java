package com.searchtecnologia.recurso.repository.relator;

import com.searchtecnologia.recurso.model.relator.Relator;
import com.searchtecnologia.recurso.model.relator.RelatorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelatorRepository extends JpaRepository<Relator, RelatorPK>, JpaSpecificationExecutor<Relator> {

    Optional<Relator> findByIdCodigo(String codigo);

    Long countByIdCodigo(String codigo);

    Optional<Relator> findTopByOrderByIdCodigo();

}
