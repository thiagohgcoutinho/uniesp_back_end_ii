package com.nexus.processnet.repositories;

import com.nexus.processnet.models.ProcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {
    boolean existsByIdResponsavel(Long idUsuario);
}
