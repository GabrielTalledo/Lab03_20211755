package com.example.lab3_20211755.Repositories;

import com.example.lab3_20211755.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>  {

    @Query(nativeQuery = true, value = "SELECT * FROM paciente WHERE clinica_id = ?1")
    List<Paciente> findByClinicaId(Integer id);


}
