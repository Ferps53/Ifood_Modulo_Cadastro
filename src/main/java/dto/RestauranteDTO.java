package dto;

import lombok.Data;
import java.util.Date;

@Data
public class RestauranteDTO {

    private String nome;

    private String cnpj;

    private LocalizacaoDTO localizacao;

    private String proprietario;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
