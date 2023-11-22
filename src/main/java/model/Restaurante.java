package model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;



@Entity
@Data
@Table(name = "restaurante")
@EqualsAndHashCode(callSuper = true)
public class Restaurante extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    public Localizacao localizacao;

    public String proprietario;

    @CreationTimestamp
    public Date dataCriacao;

    @UpdateTimestamp
    public Date dataAtualizacao;
}
