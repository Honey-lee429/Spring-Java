package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.model.dto.MedicoCadastroDto;
import med.voll.api.model.util.Especialidade;

/* record --> java já cria uma classe imutável criando os atributos, cria os getter and setter automaticamente
* Esse tipo de classe se encaixa perfeitamente para representar classes DTO
* */

@Entity
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoCadastroDto novoMedico) {
        this.nome = novoMedico.nome();
        this.email = novoMedico.email();
        this.telefone = novoMedico.telefone();
        this.endereco = new Endereco(novoMedico.endereco());
        this.crm = novoMedico.crm();
        this.especialidade = novoMedico.especialidade();
    }
}