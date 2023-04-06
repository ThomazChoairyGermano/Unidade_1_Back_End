package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Documentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumantariosRepository
        extends JpaRepository<Documentarios, Integer> {
}
