package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Medico;
import med.voll.api.model.dto.MedicoCadastroDto;
import med.voll.api.model.dto.MedicosListaDto;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;


//    @PostMapping("/cadastro")
//    @Transactional
//    public void cadastrar(@RequestBody @Valid MedicoDto novoMedico){
//        medicoRepository.save(new Medico(novoMedico));
//    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid MedicoCadastroDto novoMedico){
        return ResponseEntity.ok(medicoRepository.save(new Medico(novoMedico)));
    }

    /*
    * alem da List<> de registros o Page<> devolve a paginação e quantidade de itens na página*/
    @GetMapping("/lista")
    public Page<MedicosListaDto> getAllMedicos(@PageableDefault(size = 1, sort=("nome")) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(MedicosListaDto::new);
    }
    /*
     * recebe a requisição do json no console
     * */
    //@PostMapping("/cadastro")
    //public void  cadastrar(@RequestBody Medico novoMedico){
    //    System.out.println(novoMedico);
   // }
}
