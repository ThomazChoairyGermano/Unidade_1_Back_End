package br.com.fujideia.iesp.tecback.Service;

import br.com.fujideia.iesp.tecback.model.Documentarios;
import br.com.fujideia.iesp.tecback.repository.DocumantariosRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DocumentariosService {

    @Autowired
    private DocumantariosRepository repository;

    public Documentarios salvar(Documentarios documentarios){
        documentarios = repository.save(documentarios);
        return documentarios;
    }

    public Documentarios alterar(Documentarios documentarios){                  //ALTERAR
        if(Objects.nonNull((documentarios.getId()))){
            documentarios = repository.save(documentarios);
        }
        else{
            throw new jakarta.ws.rs.NotFoundException();
        }
        return documentarios;
    }

    public List<Documentarios> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Documentarios consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}
