package org.lasalle.services.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.lasalle.services.controller.ControllerUsuario;
import org.lasalle.services.model.Usuario;

@Path("usuario")
public class RestUsuario {


    @Path("getAllCredenciales")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCredenciales(@FormParam("user") String user, 
                                       @FormParam("password") String password) {//Se pasan los parametros
        String out = "";
        Usuario usuario = null;
        Gson gson = new Gson();
        
        try {
            ControllerUsuario controllerUsuario = new ControllerUsuario(); // se intancia el controller
            usuario = controllerUsuario.getAllCredenciales(user, password);
            out = gson.toJson(usuario);
            
        } catch (Exception e) {
            out = """
                  {
                    "result": "%s"
                  }
                  """;
            
            out = String.format(out, e.getMessage());
        }
        return Response.ok(out).build();
    }
    
    @Path("getAll")
    @GET   
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        String out = "";
        List<Usuario> listUsers = null;
        Gson gson = new Gson();
        try {
            ControllerUsuario  cu = new ControllerUsuario();
            listUsers = cu.getAll();
            out = gson.toJson(listUsers);
            
        } catch (Exception e) {
            out = """
                  {"result": "%s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
}
