package controller;

import dto.AdicionarPratoDTO;
import dto.AdicionarRestauranteDTO;
import dto.PratoDTO;
import dto.RestauranteDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import mapper.PratoMapper;
import mapper.RestauranteMapper;
import model.Prato;
import model.Restaurante;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RestauranteController {

    @Inject
    RestauranteMapper restauranteMapper;

    @Inject
    PratoMapper pratoMapper;

    String erroRestaurante = "Restaurante não existe";

    public List<RestauranteDTO> buscarRestaurantes(){
        return  restauranteMapper.toListRestauranteDTO(Restaurante.listAll());
    }

    public Restaurante adicionarRestaurante(AdicionarRestauranteDTO dto){
        Restaurante restaurante = restauranteMapper.toRestaurante(dto);
        restaurante.persist();
        return restaurante;
    }

    public Restaurante atualizarRestaurante(AdicionarRestauranteDTO dto, Long id){
        Optional<Restaurante> restauranteOptional = Restaurante.findByIdOptional(id);
        if(restauranteOptional.isEmpty()){
            throw new NotFoundException(erroRestaurante);
        }

        Restaurante restaurante = restauranteOptional.get();
        restaurante.nome = dto.getNome();
        restaurante.persist();
        return restaurante;
    }

    public void deletarRestaurante(Long id){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);

        restauranteOp.ifPresentOrElse(Restaurante::delete, ()->{
            throw new NotFoundException(erroRestaurante);
        });
    }

    public List<PratoDTO> buscarPratos(Long idRestaurante){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException(erroRestaurante);
        }
        List<Prato> listPrato = Prato.list("restaurante", restauranteOp.get());

        return pratoMapper.toListPratoDTO(listPrato);

    }

    public PratoDTO adicionarPrato(Long idRestaurante, AdicionarPratoDTO dto){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException(erroRestaurante);
        }
        Prato prato = pratoMapper.toPrato(dto);
        prato.setRestaurante(restauranteOp.get());
        prato.persist();
        return pratoMapper.toPratoDTO(prato);
    }

    public PratoDTO atualizarPrato(AdicionarPratoDTO dto, Long idPrato, Long idRestaurante){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException(erroRestaurante);
        }

        Optional<Prato> pratoOp = Prato.findByIdOptional(idPrato);
        if(pratoOp.isEmpty()){
            throw new NotFoundException("Prato não encontrado");
        }

        Prato prato = pratoOp.get();

        prato.setPreco(dto.getPreco());
        prato.persist();
        return pratoMapper.toPratoDTO(prato) ;
    }

    public void deletarPrato(Long idRestaurante, Long idPrato){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException(erroRestaurante);
        }

        Optional<Prato> pratoOp = Prato.findByIdOptional(idPrato);

        pratoOp.ifPresentOrElse(Prato::delete, ()->{
            throw new NotFoundException("Prato não encontrado");
        });
    }

}
