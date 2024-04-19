package com.example.lab3_20211755.Controllers;

import com.example.lab3_20211755.Entities.Clinica;
import com.example.lab3_20211755.Entities.Oftalmologo;
import com.example.lab3_20211755.Repositories.ClinicaRepository;
import com.example.lab3_20211755.Repositories.OftalmologoRepository;
import com.example.lab3_20211755.Repositories.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/oftalmologo"})
public class OftalmologoController {
    //Repositorios

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public OftalmologoController(ClinicaRepository clinicaRepository, OftalmologoRepository oftalmologoRepository, PacienteRepository pacienteRepository){
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Métodos
    @GetMapping(value = "")
    public String listadoOftalmologos(Model model){

        List<Oftalmologo> listaOftalmologo = oftalmologoRepository.findAll();
        List<Clinica> listaClinicas = clinicaRepository.findAll();
        model.addAttribute("listaOftalmologos", listaOftalmologo);
        model.addAttribute("listaClinicas",listaClinicas);
        return "Oftalmologo/Lista";
    }
}
