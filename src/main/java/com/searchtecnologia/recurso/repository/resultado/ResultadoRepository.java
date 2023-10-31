package com.searchtecnologia.recurso.repository.resultado;

import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.model.resultado.ResultadoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoPK>, JpaSpecificationExecutor<Resultado> {

    Long countByIdCodigo(String codigo);

    List<Resultado> findByAtivo(String ativo);

    Optional<Resultado> findByIdCodigo(String codigo);

}
