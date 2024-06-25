package com.nexus.processnet.repositories;

import com.nexus.processnet.models.ProcessoModel;
import com.nexus.processnet.models.Status;
import com.nexus.processnet.models.TipoProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {
    boolean existsByResponsavel_IdPessoa(Long idPessoa);

    List<ProcessoModel> findByResponsavel_IdPessoa(Long idPessoa);

    List<ProcessoModel> findByTipoProcessoAndStatus(TipoProcesso tipo, Status status);

    List<ProcessoModel> findByStatus(Status status);

    List<ProcessoModel> findByFuncionario_IdPessoa(Long idPessoa);

    List<ProcessoModel> findByTipoProcesso(TipoProcesso tipoProcesso);
}
