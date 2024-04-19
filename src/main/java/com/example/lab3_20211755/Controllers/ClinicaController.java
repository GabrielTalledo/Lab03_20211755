package com.example.lab3_20211755.Controllers;

import com.example.lab3_20211755.Entities.Clinica;
import com.example.lab3_20211755.Entities.Oftalmologo;
import com.example.lab3_20211755.Entities.Paciente;
import com.example.lab3_20211755.Repositories.ClinicaRepository;
import com.example.lab3_20211755.Repositories.OftalmologoRepository;
import com.example.lab3_20211755.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/clinica","/"})
public class ClinicaController {

    //Repositorios

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public ClinicaController(ClinicaRepository clinicaRepository, OftalmologoRepository oftalmologoRepository, PacienteRepository pacienteRepository){
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Métodos
    @GetMapping(value = "")
    public String listadoClinicas(Model model){

        List<Clinica> listaClinicas = clinicaRepository.findAll();
        model.addAttribute("listaClinicas", listaClinicas);

        return "Clinica/Lista";
    }

    @GetMapping(value = "/listaOftalmologos")
    public String listadoClinicaOftalmologo(@RequestParam("id") String id, Model model){

        Integer idInt;
        try{
            idInt = Integer.parseInt(id);
        }catch(NumberFormatException e){
            return "redirect:/clinica";
        }

        Optional<Clinica> optClinica = clinicaRepository.findById(idInt);

        if (optClinica.isPresent()) {
            Clinica clinica = optClinica.get();

            List<Oftalmologo> listaOftalmologoClinica = oftalmologoRepository.findByClinicaId(idInt);

            if(listaOftalmologoClinica.isEmpty()){
                return "redirect:/clinica";
            }else{
                model.addAttribute("clinica", clinica);
                model.addAttribute("listaOftalmologoClinica", listaOftalmologoClinica);
                return "Clinica/ListaOftalmologos";
            }
        } else {
            return "redirect:/clinica";
        }


    }

    @GetMapping(value = "/listaPacientes")
    public String listadoClinicaPaciente(@RequestParam("id") String id, Model model){

        Integer idInt;
        try{
            idInt = Integer.parseInt(id);
        }catch(NumberFormatException e){
            return "redirect:/clinica";
        }

        Optional<Clinica> optClinica = clinicaRepository.findById(idInt);

        if (optClinica.isPresent()) {
            Clinica clinica = optClinica.get();

            List<Paciente> listaPacienteClinica = pacienteRepository.findByClinicaId(idInt);

            if(listaPacienteClinica.isEmpty()){
                return "redirect:/clinica";
            }else{
                model.addAttribute("clinica", clinica);
                model.addAttribute("listaPacienteClinica", listaPacienteClinica);
                return "Clinica/ListaPacientes";
            }
        } else {
            return "redirect:/clinica";
        }


    }

}
