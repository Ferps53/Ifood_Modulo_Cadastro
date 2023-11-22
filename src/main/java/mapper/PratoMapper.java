package mapper;

import dto.AdicionarPratoDTO;
import dto.PratoDTO;
import model.Prato;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PratoMapper {

    Prato toPrato(AdicionarPratoDTO dto);

    Prato toPrato(PratoDTO dto);

    PratoDTO toPratoDTO(Prato prato);

    List<PratoDTO> toListPratoDTO(List<Prato> pratoList);
}
