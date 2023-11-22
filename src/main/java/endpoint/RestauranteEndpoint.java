package endpoint;

import controller.RestauranteController;
import dto.AdicionarPratoDTO;
import dto.AdicionarRestauranteDTO;
import dto.PratoDTO;
import dto.RestauranteDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Restaurante;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestauranteEndpoint {

    @Inject
    RestauranteController restauranteController;

    @GET
    @Tag(name = "Restaurante")
    public List<RestauranteDTO> buscar(){
        return restauranteController.buscarRestaurantes();
    }

    @POST
    @Transactional
    @Tag(name = "Restaurante")
    public Response adicionar(AdicionarRestauranteDTO dto){
        Restaurante restaurante = restauranteController.adicionarRestaurante(dto);
        return Response.ok(restaurante).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Tag(name = "Restaurante")
    public Response atualizar(@PathParam("id") Long id, AdicionarRestauranteDTO dto){
        Restaurante restaurante = restauranteController.atualizarRestaurante(dto, id);
        return Response.ok(restaurante).build();
    }

    @DELETE
    @Path("{id}")
    @Tag(name = "Restaurante")
    public Response delete(@PathParam("id") Long id){
        restauranteController.deletarRestaurante(id);
        return Response.ok().build();
    }

    @GET
    @Tag(name = "Prato")
    @Path("{idRestaurante}")
    public List<PratoDTO> buscarPratos(@PathParam("idRestaurante") Long id){
        return restauranteController.buscarPratos(id);
    }

    @POST
    @Transactional
    @Tag(name = "Prato")
    @Path("{idRestaurante}")
    public Response adicionarPratos(@PathParam("idRestaurante") Long id, AdicionarPratoDTO dto){
        PratoDTO pratoDTO = restauranteController.adicionarPrato(id, dto);
        return Response.ok(pratoDTO).build();
    }

    @POST
    @Transactional
    @Tag(name = "Prato")
    @Path("{idRestaurante}/{idPrato}")
    public Response atualizarPrato(@PathParam("idRestaurante") Long idRestaurante,
                                   @PathParam("idPrato") Long idPrato, AdicionarPratoDTO dto){
        PratoDTO pratoDTO = restauranteController.atualizarPrato(dto, idPrato, idRestaurante);
        return Response.ok(pratoDTO).build();
    }

    @DELETE
    @Transactional
    @Tag(name = "Prato")
    @Path("{idRestaurante}/{idPrato}")
    public Response deletePrato(@PathParam("idRestaurante") Long idRestaurante,
                                @PathParam("idPrato") Long idPrato){
        restauranteController.deletarPrato(idRestaurante, idPrato);
        return Response.ok().build();
    }

}
