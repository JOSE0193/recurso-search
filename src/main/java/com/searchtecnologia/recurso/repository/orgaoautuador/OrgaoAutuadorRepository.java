package com.searchtecnologia.recurso.repository.orgaoautuador;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoAutuadorRepository extends JpaRepository<OrgaoAutuador, String> {
}