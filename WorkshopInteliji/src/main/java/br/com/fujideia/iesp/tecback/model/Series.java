package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_series")


public class Series {

    @Id
    @GeneratedValue
    private int id;

    private String titulo;

    @Column(name ="ds_sinopse", length = 500)
    private String sinopse;
}
