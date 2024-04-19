package com.example.lab3_20211755.Repositories;


import com.example.lab3_20211755.Entities.Oftalmologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OftalmologoRepository extends JpaRepository<Oftalmologo,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM oftalmologo WHERE clinica_id = ?1")
    List<Oftalmologo> findByClinicaId(Integer id);
}
