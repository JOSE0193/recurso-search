package com.searchtecnologia.recurso.repository.processo;

import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosProcessoRepository extends JpaRepository<DadosProcessoView, String>, JpaSpecificationExecutor<DadosProcessoView> {
    @Query(value = "SELECT * FROM V_SGM_DADOS_PROCESSO V, " +
            "(SELECT PROC.MU_IDPR_CODIGO, PROC.MM_OAU_CODIGO, MAX(PROC.MU_PROC_LOG_DATA_RESULTAD1 || PROC.MU_PROC_LOG_HORA_RESULTAD1) AS DATA_RESULTADO " +
            "FROM MULTAWEB.MMA1PROC PROC " +
            "WHERE PROC.MU_PROC_LOG_DATA_RESULTAD1 BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY PROC.MU_IDPR_CODIGO, PROC.MM_OAU_CODIGO) PROC " +
            "WHERE V.NUMERO_PROCESSO = PROC.MU_IDPR_CODIGO " +
            "AND V.COD_ORGAO_PROCESSO = PROC.MM_OAU_CODIGO " +
            "AND V.COD_RELATOR = :relator " +
            "AND (:tipoRecurso IS NULL OR V.TIPO_RECURSO = :tipoRecurso) " +
            "ORDER BY DATA_RESULTADO DESC", nativeQuery = true)
    List<DadosProcessoView> findProcessos(@Param("relator") String relator, @Param("dataInicio") String dataInicio,
                                      @Param("dataFim") String dataFim, @Param("tipoRecurso") String tipoRecurso);
}
