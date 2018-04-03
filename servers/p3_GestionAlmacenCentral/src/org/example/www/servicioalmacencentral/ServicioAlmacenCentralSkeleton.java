
/**
 * ServicioAlmacenCentralSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.example.www.servicioalmacencentral;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * ServicioAlmacenCentralSkeleton java skeleton for the axisService
 */
public class ServicioAlmacenCentralSkeleton {


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
	 * Comprueba si hay stock para realizar el pedido
	 * @param comprobarStock
	 * @return comprobarStockResponse
	 */
	public org.example.www.servicioalmacencentral.ComprobarStockResponse comprobarStock(
			org.example.www.servicioalmacencentral.ComprobarStock comprobarStock) {

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
	 * Actualiza el stock en el almacen central
	 * @param actualizarStock
	 * @return actualizarStockResponse
	 */
	public org.example.www.servicioalmacencentral.ActualizarStockResponse actualizarStock(
			org.example.www.servicioalmacencentral.ActualizarStock actualizarStock) {

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
