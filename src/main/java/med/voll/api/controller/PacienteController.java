package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Paciente;
import med.voll.api.model.dto.PacienteDto;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping("/cadastrar")
    @Transactional
    public void Paciente(@RequestBody @Valid PacienteDto novoPaciente) {
        pacienteRepository.save(new Paciente(novoPaciente));
    }
}
