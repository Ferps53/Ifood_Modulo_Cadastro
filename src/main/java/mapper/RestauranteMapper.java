package mapper;

import dto.AdicionarRestauranteDTO;
import dto.PratoDTO;
import dto.RestauranteDTO;
import model.Prato;
import model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RestauranteMapper {
   @Mapping(target = "localizacao", source = "localizacaoDTO")

   Restaurante toRestaurante(AdicionarRestauranteDTO dto);

   Restaurante toRestaurante(RestauranteDTO dto);

   RestauranteDTO toRestauranteDTO(Restaurante restaurante);

   List<RestauranteDTO> toListRestauranteDTO(List<Restaurante> restauranteList);
}
