package com.example.lab3_20211755.Controllers;

import com.example.lab3_20211755.Entities.Clinica;
import com.example.lab3_20211755.Entities.Oftalmologo;
import com.example.lab3_20211755.Entities.Paciente;
import com.example.lab3_20211755.Repositories.ClinicaRepository;
import com.example.lab3_20211755.Repositories.OftalmologoRepository;
import com.example.lab3_20211755.Repositories.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"/paciente"})
public class PacienteController {

    //Repositorios

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public PacienteController(ClinicaRepository clinicaRepository, OftalmologoRepository oftalmologoRepository, PacienteRepository pacienteRepository){
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Métodos
    @GetMapping(value = "")
    public String listadoPacientes(Model model){

        List<Paciente> listaPacientes = pacienteRepository.findAll();
        List<Oftalmologo> listaOftalmologos = oftalmologoRepository.findAll();
        List<Clinica> listaClinicas = clinicaRepository.findAll();
        model.addAttribute("listaPacientes", listaPacientes);
        model.addAttribute("listaOftalmologos", listaOftalmologos);
        model.addAttribute("listaClinicas",listaClinicas);
        return "Paciente/Lista";
    }

    @GetMapping(value = "")
    public String editarNumHabitacion(@RequestParam("id") String id, Model model){

        model.addAttribute("id",id);
        return "Paciente/FormEditarHabitacion";
    }
}
