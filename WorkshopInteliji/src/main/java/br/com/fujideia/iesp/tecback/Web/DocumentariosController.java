package br.com.fujideia.iesp.tecback.Web;

import br.com.fujideia.iesp.tecback.Service.DocumentariosService;
import br.com.fujideia.iesp.tecback.model.Documentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentarios")
public class DocumentariosController {

    @Autowired
    private DocumentariosService service;

    @PostMapping
    public ResponseEntity<Documentarios> salvar(@RequestBody Documentarios documentarios){
        documentarios = service.salvar(documentarios);
        return ResponseEntity.ok(documentarios);
    }

    @PutMapping
    public ResponseEntity<Documentarios> alterar(@RequestBody Documentarios documentarios){
        documentarios = service.alterar(documentarios);
        return ResponseEntity.ok(documentarios);
    }

    @GetMapping
    public ResponseEntity<List<Documentarios>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documentarios> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
