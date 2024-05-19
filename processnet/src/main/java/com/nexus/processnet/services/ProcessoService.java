package com.nexus.processnet.services;


import com.nexus.processnet.models.*;
import com.nexus.processnet.repositories.ProcessoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoService {


    @Autowired
    private ProcessoRepository processoRepository;

    @Transactional
    public ProcessoModel create(ProcessoModel novoProcesso, UsuarioModel usuario) {
        novoProcesso.setResponsavel(usuario);
        return processoRepository.save(novoProcesso);
    }

    @Transactional
    public List<ProcessoModel> findByResponsavel(Long idPessoa) {
        return processoRepository.findByResponsavel_IdPessoa(idPessoa);
    }

    @Transactional
    public List<ProcessoModel> findByTipoProcesso(TipoProcesso tipo) {
        return processoRepository.findByTipoProcesso(tipo);
    }


    @Transactional
    public List<ProcessoModel> findByStatus(Status status) {
        return processoRepository.findByStatus(status);
    }

    @Transactional
    public void updateStatus(Long idProcesso, Status novoStatus) {
        ProcessoModel processo = processoRepository.findById(idProcesso)
                .orElseThrow(() -> new IllegalArgumentException("Processo não encontrado com ID: " + idProcesso));
        processo.setStatus(novoStatus);
        processoRepository.save(processo);
    }

    @Transactional
    public void updateParecer(Long idProcesso, Parecer parecer) {
        ProcessoModel processo = processoRepository.findById(idProcesso)
                .orElseThrow(() -> new IllegalArgumentException("Processo não encontrado com ID: " + idProcesso));
        processo.setParecer(parecer);
        processo.setStatus(Status.CONCLUIDO);
        processoRepository.save(processo);
    }

    @Transactional
    public void selectProcesso(Long idProcesso, FuncionarioModel funcionario) {
        ProcessoModel processo = processoRepository.findById(idProcesso)
                .orElseThrow(() -> new IllegalArgumentException("Processo não encontrado com ID: " + idProcesso));

        if (processo.getStatus() == Status.AGUARDANDO && (funcionario.getCargo() == Cargo.VISTORIADOR || funcionario.getCargo() == Cargo.ANALISTA)) {
            processo.setStatus(Status.EM_ANALISE);
            processoRepository.save(processo);
        }
    }

    @Transactional
    public List<ProcessoModel> findAll() {
        return processoRepository.findAll();
    }

    @Transactional
    public ProcessoModel findById(Long id) {
        return processoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Processo não encontrado com ID: " + id));
    }
}
