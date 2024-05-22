/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import org.lasalle.services.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class ControllerUsuario {
    
    public List<Usuario> getAll(){
        List<Usuario> listUsers = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try {
            ConnectionMysql connMysql = new  ConnectionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setToken(rs.getString("token"));
                //u.setLastConnection(rs.getDate("lastConnection"));
                listUsers.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return listUsers;
        }
        return listUsers;
    }
    
    
    public Usuario getAllCredenciales2(String username, 
                                      String password) throws Exception{
        List<Usuario> usuarios = getAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
    
    public Usuario getAllCredenciales(String username, String password) throws Exception{
        List<Usuario> usuarios = getAll();
        
        for (int i = 0; i < usuarios.size(); i++) {
        Usuario usuario = usuarios.get(i);
        if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
            return usuario;
        }
    }
        
        return null;
    }
    
    
}
