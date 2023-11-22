package dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdicionarPratoDTO {

    public String nome;

    public String descricao;

    public BigDecimal preco;

}
