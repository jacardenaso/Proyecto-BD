/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jr.Armando
 */
public class TestProcedimiento {
     public static void main(String args[])throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse("system","system");
        CallableStatement callate=con.prepareCall("{call GUARDAR_PELICULA(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,"Ted");
        callate.setString(3,"Risa");

      
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("El id ingresado es:"+pk);
    }
}
