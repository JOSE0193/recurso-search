package com.searchtecnologia.recurso.repository.multa;

import com.searchtecnologia.recurso.model.multa.LogMulta;
import com.searchtecnologia.recurso.model.multa.LogMultaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMultaRepository extends JpaRepository<LogMulta, LogMultaPK> {
}