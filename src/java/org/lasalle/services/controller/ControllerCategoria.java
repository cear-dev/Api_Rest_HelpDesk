package org.lasalle.services.controller;

import org.lasalle.services.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControllerCategoria {
    public Categoria saveCategoria(Categoria categoria){
        String query = "INSERT INTO categoria VALUES (0,?,?,?)";
        try {
            ConnectionMysql connectionMySql = new ConnectionMysql();
            Connection connection = connectionMySql.open();
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, categoria.getCategoria());
            pstm.setString(2, categoria.getDepartamento());
            pstm.setInt(3, categoria.getResponsable());
            pstm.execute();
            System.out.println("Registro generado");
            pstm.close();
            connectionMySql.close();
        } catch (Exception e) {
        
        }
        
        return categoria;
    }
}