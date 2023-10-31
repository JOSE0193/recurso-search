package com.searchtecnologia.recurso.repository.recurso;

import com.searchtecnologia.recurso.model.recurso.RecursoItem;
import com.searchtecnologia.recurso.model.recurso.RecursoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoItemRepository extends JpaRepository<RecursoItem, RecursoItemPK>, JpaSpecificationExecutor<RecursoItem> {

}