package br.com.fujideia.iesp.tecback.Service;

//obs service faz validções, ex:verificar se o nome está em uma lista

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service        //separa o que é serviço do que é banco de dados
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }

    public Filme alterar(Filme filme){                  //ALTERAR
        if(Objects.nonNull((filme.getId()))){
            filme = repository.save(filme);
        }
        else{
            throw new jakarta.ws.rs.NotFoundException();
        }
        return filme;
    }

    public List<Filme> listar(){
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

    public Filme consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
