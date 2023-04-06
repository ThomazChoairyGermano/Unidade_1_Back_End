package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_filme")

public class Filme {

    @Id
    @GeneratedValue                                     //gera um id sem que se repita
    private int id;

    private String titulo;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @Transient                  //deixa fora do banco de dados
    private String teste;
}
