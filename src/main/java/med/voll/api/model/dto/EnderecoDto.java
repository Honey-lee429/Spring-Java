package med.voll.api.model.dto;

/* record --> java já cria getter and setter automaticamente*/

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto (

         String logradouro,
         @NotBlank
         String bairro,
         @Pattern(regexp = "\\d{4}")
         String cep,
         String cidade,
         String uf,
         @NotBlank
         String numero,
         String complemento) {

}


