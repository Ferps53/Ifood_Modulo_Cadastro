package dto;

import annotations.ValidDTO;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import model.Restaurante;

@Getter
@Setter
@ValidDTO
public class AdicionarRestauranteDTO implements DTO {

    @NotNull
    @NotEmpty
    private String proprietario;

    @Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
    @NotNull
    private String cnpj;

    @Size(min = 3, max = 40)
    private String nome;

    private LocalizacaoDTO localizacaoDTO;

    @Override
    public boolean isValid(ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        if(Restaurante.find("cnpj", cnpj).count() > 0){
            context.buildConstraintViolationWithTemplate("CNPJ já cadastrado")
                    .addPropertyNode("cnpj")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }


}
