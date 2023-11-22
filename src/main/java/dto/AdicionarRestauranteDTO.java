package dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionarRestauranteDTO {

    private String proprietario;

    private String cnpj;

    private String nome;

    private LocalizacaoDTO localizacaoDTO;

}
