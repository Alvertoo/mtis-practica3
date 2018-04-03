
/**
 * ServicioAlmacenLocalSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.example.www.servicioalmacenlocal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ServicioAlmacenLocalSkeleton java skeleton for the axisService
 */
public class ServicioAlmacenLocalSkeleton {

	private int getUnidadesProducto(String referenciaProducto) {
		int unidadesDisponibles = 0;
		
		MysqlConnect mysqlConnect = new MysqlConnect();
		
		String sql = "SELECT unidades FROM `stock` WHERE referencia = \'" + referenciaProducto + "\';";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    ResultSet rs = statement.executeQuery( sql );
		    while (rs.next()) {
		    	unidadesDisponibles = rs.getInt("unidades");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		return unidadesDisponibles;
	}
	
	/**
	 * Comprobar si existe suficiente stock en el almacen local
	 * 
	 * @param comprobarStock
	 * @return comprobarStockResponse
	 */
	public org.example.www.servicioalmacenlocal.ComprobarStockResponse comprobarStock(
			org.example.www.servicioalmacenlocal.ComprobarStock comprobarStock) {

		ComprobarStockResponse response = new ComprobarStockResponse();
		
		String referenciaProducto = comprobarStock.localReferenciaProducto;
		int unidades = comprobarStock.localNumeroUnidades;
		boolean existe = false;

	    int unidadesDisponibles = getUnidadesProducto(referenciaProducto);

	    if(unidadesDisponibles >= unidades) {
	    	existe = true;
	    }
		
		response.localExiste = existe;
		return response;
	}

	/**
	 * Actualizar stock del almacen local (restar numeroUnidades al producto
	 * referenciaProducto)
	 * 
	 * @param actualizarStock
	 * @return actualizarStockResponse
	 */
	public org.example.www.servicioalmacenlocal.ActualizarStockResponse actualizarStock(
			org.example.www.servicioalmacenlocal.ActualizarStock actualizarStock) {

		ActualizarStockResponse response = new ActualizarStockResponse();

		String referenciaProducto = actualizarStock.localReferenciaProducto;
		int unidades = actualizarStock.localNumeroUnidades;
		boolean actualizado = false;
		

	    int unidadesDisponibles = getUnidadesProducto(referenciaProducto);
	    
	    int unidadesRestantes = unidadesDisponibles - unidades;

		MysqlConnect mysqlConnect = new MysqlConnect();
		
		String sql = "UPDATE `stock` SET `unidades` = \'" + unidadesRestantes + "\' WHERE referencia = \'" + referenciaProducto + "\';";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    int rows = statement.executeUpdate();
		    actualizado = (rows > 0);
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		response.localActualizado = actualizado;
		return response;
	}
}
