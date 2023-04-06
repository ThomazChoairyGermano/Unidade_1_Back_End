package br.com.fujideia.iesp.tecback.Service;

import br.com.fujideia.iesp.tecback.model.Series;
import br.com.fujideia.iesp.tecback.repository.SeriesRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SeriesService {

    @Autowired
    private SeriesRepository repository;

    public Series salvar(Series series){
        series = repository.save(series);
        return series;
    }

    public Series alterar(Series series){                  //ALTERAR
        if(Objects.nonNull((series.getId()))){
            series = repository.save(series);
        }
        else{
            throw new jakarta.ws.rs.NotFoundException();
        }
        return series;
    }

    public List<Series> listar(){
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

    public Series consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }


}
