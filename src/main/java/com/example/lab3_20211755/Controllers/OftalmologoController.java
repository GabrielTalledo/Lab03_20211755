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
import java.util.Optional;

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

    @GetMapping(value = "/listaPacientes")
    public String listadoOftalPaciente(@RequestParam("id") String id, Model model){

        Integer idInt;
        try{
            idInt = Integer.parseInt(id);
        }catch(NumberFormatException e){
            return "redirect:/oftalmologo";
        }

        Optional<Oftalmologo> optOftal = oftalmologoRepository.findById(idInt);

        if (optOftal.isPresent()) {
            Oftalmologo oftalmologo = optOftal.get();

            List<Paciente> listaPacienteOftal = pacienteRepository.findByOftalmologoId(idInt);

            if(listaPacienteOftal.isEmpty()){
                return "redirect:/oftalmologo";
            }else{
                model.addAttribute("oftalmologo", oftalmologo);
                model.addAttribute("listaPacienteOftal", listaPacienteOftal);
                return "Oftalmologo/ListaPacientes";
            }
        } else {
            return "redirect:/oftalmologo";
        }


    }

    @GetMapping(value = "/listaCitas")
    public String listadoOftalCita(@RequestParam("id") String id, Model model){

        Integer idInt;
        try{
            idInt = Integer.parseInt(id);
        }catch(NumberFormatException e){
            return "redirect:/oftalmologo";
        }

        Optional<Oftalmologo> optOftal = oftalmologoRepository.findById(idInt);

        if (optOftal.isPresent()) {
            Oftalmologo oftalmologo = optOftal.get();

            List<Paciente> listaPacienteOftal = pacienteRepository.findByOftalmologoIdCitas(idInt);

            if(listaPacienteOftal.isEmpty()){
                return "redirect:/oftalmologo";
            }else{
                model.addAttribute("oftalmologo", oftalmologo);
                model.addAttribute("listaPacienteOftal", listaPacienteOftal);
                return "Oftalmologo/ListaCitas";
            }
        } else {
            return "redirect:/oftalmologo";
        }


    }
}
