package com.searchtecnologia.recurso.repository.recurso;

import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoViewRepository extends JpaRepository<RecursoView, String>, JpaSpecificationExecutor<RecursoView> {

}
