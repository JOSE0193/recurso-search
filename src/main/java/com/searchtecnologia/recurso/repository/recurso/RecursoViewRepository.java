package com.searchtecnologia.recurso.repository.recurso;

import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoViewRepository extends JpaRepository<RecursoView, String> {

    RecursoView findByNumeroAndOrgaoAnalizadorCodigoAndTipoRecurso(String numeroProcesso, String orgaoAnalizador, TipoRecurso tipoRecurso);

    RecursoView findByNumeroAndTipoRecurso(String numeroProcesso, TipoRecurso tipoRecurso);

    RecursoView findByNumero(String numeroProcesso);

}
