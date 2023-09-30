package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.model.dto.PacienteDto;

/* record --> java já cria uma classe imutável criando os atributos, cria os getter and setter automaticamente
* Esse tipo de classe se encaixa perfeitamente para representar classes DTO
* */

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDto novoPaciente) {
        this.nome = novoPaciente.nome();
        this.email = novoPaciente.email();
        this.telefone = novoPaciente.telefone();
        this.endereco = new Endereco(novoPaciente.endereco());
        this.cpf = novoPaciente.cpf();
    }
}