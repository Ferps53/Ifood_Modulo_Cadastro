package dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PratoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

}
