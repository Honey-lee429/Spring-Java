package med.voll.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.model.util.Especialidade;
import org.springframework.validation.annotation.Validated;

/* record --> java já cria uma classe imutável criando os atributos, cria os getter and setter automaticamente
* Esse tipo de classe se encaixa perfeitamente para representar classes DTO
* */
public record MedicoCadastroDto (
       @NotNull
       String nome,
       @NotNull
       @Email
       String email,
       @NotNull
       @Min(value = 4)
       String telefone,
       @NotBlank
       @Pattern(regexp = "\\d{4,6}")
       String crm,
       Especialidade especialidade,
       @Valid
       EnderecoDto endereco
){

}