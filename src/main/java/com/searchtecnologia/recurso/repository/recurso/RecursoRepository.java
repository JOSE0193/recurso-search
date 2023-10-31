package com.searchtecnologia.recurso.repository.recurso;

import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.model.recurso.RecursoPK;
import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, RecursoPK> {
}