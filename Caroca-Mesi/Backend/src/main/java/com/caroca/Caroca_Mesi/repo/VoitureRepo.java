package com.caroca.Caroca_Mesi.repo;

import com.caroca.Caroca_Mesi.Model.VoitureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoitureRepo extends JpaRepository<VoitureInfo, Long> {
    void deleteById(Long id);
    Optional<VoitureInfo> findVoitureById(Long id);
}
