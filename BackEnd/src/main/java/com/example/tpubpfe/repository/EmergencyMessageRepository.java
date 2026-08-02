package com.example.tpubpfe.repository;

import com.example.tpubpfe.model.EmergencyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyMessageRepository extends JpaRepository<EmergencyMessage, Long> {
}
