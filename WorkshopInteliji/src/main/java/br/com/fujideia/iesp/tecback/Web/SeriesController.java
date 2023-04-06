package br.com.fujideia.iesp.tecback.Web;

import br.com.fujideia.iesp.tecback.Service.SeriesService;
import br.com.fujideia.iesp.tecback.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService service;

    @PostMapping
    public ResponseEntity<Series> salvar(@RequestBody Series series){
        series = service.salvar(series);
        return ResponseEntity.ok(series);
    }

    @PutMapping
    public ResponseEntity<Series> alterar(@RequestBody Series series){
        series = service.alterar(series);
        return ResponseEntity.ok(series);
    }

    @GetMapping
    public ResponseEntity<List<Series>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> consultar(@PathVariable("id") Integer id){
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
