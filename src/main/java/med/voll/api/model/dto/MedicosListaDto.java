package med.voll.api.model.dto;

import med.voll.api.model.Medico;
import med.voll.api.model.util.Especialidade;

public record MedicosListaDto(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public MedicosListaDto (Medico medico){
        this(medico.getEmail(), medico.getCrm(), medico.getNome(), medico.getEspecialidade());
    }

}
