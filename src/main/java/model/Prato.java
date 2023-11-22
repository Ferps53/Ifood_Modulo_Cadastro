package model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prato")
@Data
public class Prato extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String descricao;

    @ManyToOne
    public Restaurante restaurante;

    public BigDecimal preco;

}
