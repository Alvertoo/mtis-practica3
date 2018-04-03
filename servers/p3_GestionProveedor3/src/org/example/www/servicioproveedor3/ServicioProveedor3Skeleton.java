
/**
 * ServicioProveedor3Skeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package org.example.www.servicioproveedor3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ServicioProveedor3Skeleton java skeleton for the axisService
 */
public class ServicioProveedor3Skeleton {

	
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
	 * Solicita un presupuesto para el pedido realizado
	 * @param solicitarPresupuesto
	 * @return solicitarPresupuestoResponse
	 */
	public org.example.www.servicioproveedor3.SolicitarPresupuestoResponse solicitarPresupuesto(
			org.example.www.servicioproveedor3.SolicitarPresupuesto solicitarPresupuesto) {

		SolicitarPresupuestoResponse response = new SolicitarPresupuestoResponse();
		
		String referenciaProducto = solicitarPresupuesto.localReferenciaProducto;
		int unidades = solicitarPresupuesto.localNumeroUnidades;
		float precioUnitario = 0.0f;
		
		MysqlConnect mysqlConnect = new MysqlConnect();
		
		String sql = "SELECT precio FROM `stock` WHERE referencia = \'" + referenciaProducto + "\';";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    ResultSet rs = statement.executeQuery( sql );
		    while (rs.next()) {
		    	precioUnitario = rs.getFloat("precio");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		float precioTotal = unidades * precioUnitario;
		
		response.localPrecio = precioTotal;
		return response;
	}
	
	/**
	 * Ordena la compra del pedido y deja constancia en la BD
	 * @param ordenarCompra
	 * @return ordenarCompraResponse
	 */
	public org.example.www.servicioproveedor3.OrdenarCompraResponse ordenarCompra(
			org.example.www.servicioproveedor3.OrdenarCompra ordenarCompra) {

		OrdenarCompraResponse response = new OrdenarCompraResponse();
		
		String referenciaProducto = ordenarCompra.localReferenciaProducto;
		int unidades = ordenarCompra.localNumeroUnidades;
		boolean realizadaCorrectamente = false;
		
		MysqlConnect mysqlConnect = new MysqlConnect();
		
		String sql = "INSERT INTO `ventas`(`referencia`, `unidades`) VALUES ( \'" + referenciaProducto + "\', " + unidades + " );";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    int rows = statement.executeUpdate();
		    realizadaCorrectamente = (rows > 0);
		} catch (SQLException e) {
			realizadaCorrectamente = false;
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		response.localRealizadaCorrectamente = realizadaCorrectamente;
		return response;
	}

	/**
	 * Actualiza el stock del proveedor 3
	 * @param actualizarStock
	 * @return actualizarStockResponse
	 */
	public org.example.www.servicioproveedor3.ActualizarStockResponse actualizarStock(
			org.example.www.servicioproveedor3.ActualizarStock actualizarStock) {

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
		    actualizado = false;
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		response.localActualizado = actualizado;
		return response;
	}

}
