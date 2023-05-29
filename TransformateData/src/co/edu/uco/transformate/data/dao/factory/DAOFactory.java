package co.edu.uco.transformate.data.dao.factory;

import co.edu.uco.transformate.data.dao.ClaseDAO;
import co.edu.uco.transformate.data.dao.CompraDAO;
import co.edu.uco.transformate.data.dao.DescuentoDAO;
import co.edu.uco.transformate.data.dao.EgresoDAO;
import co.edu.uco.transformate.data.dao.EjercicioDAO;
import co.edu.uco.transformate.data.dao.EntrenadorDAO;
import co.edu.uco.transformate.data.dao.EquipoDAO;
import co.edu.uco.transformate.data.dao.EstadoPagoDAO;
import co.edu.uco.transformate.data.dao.EventoDAO;
import co.edu.uco.transformate.data.dao.FacturaDAO;
import co.edu.uco.transformate.data.dao.GerenteDAO;
import co.edu.uco.transformate.data.dao.GimnasioDAO;
import co.edu.uco.transformate.data.dao.HistorialClaseDAO;
import co.edu.uco.transformate.data.dao.HistorialNotaMedicaDAO;
import co.edu.uco.transformate.data.dao.HistorialProgresoDAO;
import co.edu.uco.transformate.data.dao.HistorialPruebaFisicaDAO;
import co.edu.uco.transformate.data.dao.InformeFinancieroDAO;
import co.edu.uco.transformate.data.dao.MembresiaDAO;
import co.edu.uco.transformate.data.dao.MiembroDAO;
import co.edu.uco.transformate.data.dao.NivelDificultadDAO;
import co.edu.uco.transformate.data.dao.NotaMedicaDAO;
import co.edu.uco.transformate.data.dao.ObjetivoEntrenamientoDAO;
import co.edu.uco.transformate.data.dao.ObjetivoPlanDAO;
import co.edu.uco.transformate.data.dao.PlanEntrenamientoDAO;
import co.edu.uco.transformate.data.dao.ProductoDAO;
import co.edu.uco.transformate.data.dao.ProgresoDAO;
import co.edu.uco.transformate.data.dao.PruebaFisicaDAO;
import co.edu.uco.transformate.data.dao.RecepcionistaDAO;
import co.edu.uco.transformate.data.dao.RutinaDAO;
import co.edu.uco.transformate.data.dao.TipoDescuentoDAO;
import co.edu.uco.transformate.data.dao.TipoDocumentoDAO;
import co.edu.uco.transformate.data.dao.TipoEgresoDAO;
import co.edu.uco.transformate.data.dao.TipoMembresiaDAO;
import co.edu.uco.transformate.data.dao.TipoMiembroDAO;
import co.edu.uco.transformate.data.dao.TipoPagoDAO;
import co.edu.uco.transformate.data.dao.TipoRutinaDAO;
import co.edu.uco.transformate.data.dao.ZonaDAO;
import co.edu.uco.transformate.data.dao.factory.relational.postgresql.PostgreSQLDAOFactory;
import co.edu.uco.transformate.data.dao.factory.relational.sqlserver.SQLServerDAOFactory;


public abstract class DAOFactory {

	public static DAOFactory getFactory(final Factory factory) {

		final DAOFactory daoFactory;

		switch (factory) {
		case SQLSERVER -> daoFactory = new SQLServerDAOFactory();
		case POSTGRESQL -> daoFactory = new PostgreSQLDAOFactory();
		default -> throw new IllegalArgumentException("Not Implemented yet!!" + factory);
		}

		return daoFactory;
	}

	protected abstract void abrirConexion();

	public abstract void cerrarConexion();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void cancelarTransaccion();

	public abstract ClaseDAO getClaseDAO();

	public abstract CompraDAO getCompraDAO();

	public abstract DescuentoDAO getDescuentoDAO();

	public abstract EgresoDAO getEgresoDAO();

	public abstract EjercicioDAO getEjercicioDAO();

	public abstract EntrenadorDAO getEntrenadorDAO();

	public abstract EquipoDAO getEquipoDAO();

	public abstract EstadoPagoDAO getEstadoPagoDAO();

	public abstract EventoDAO getEventoDAO();

	public abstract FacturaDAO getFacturaDAO();

	public abstract GerenteDAO getGerenteDAO();

	public abstract GimnasioDAO getGimnasioDAO();

	public abstract HistorialClaseDAO getHistorialClaseDAO();

	public abstract HistorialNotaMedicaDAO getHistorialNotaMedicaDAO();

	public abstract HistorialProgresoDAO getHistorialProgresoDAO();

	public abstract HistorialPruebaFisicaDAO getHistorialPruebaFisicaDAO();

	public abstract InformeFinancieroDAO getInformeFinancieroDAO();

	public abstract MembresiaDAO getMembresiaDAO();

	public abstract MiembroDAO getMiembroDAO();

	public abstract NivelDificultadDAO getDificultadDAO();

	public abstract NotaMedicaDAO getNotaMedicaDAO();

	public abstract ObjetivoEntrenamientoDAO getObjetivoEntrenamientoDAO();

	public abstract ObjetivoPlanDAO getObjetivoPlanDAO();

	public abstract PlanEntrenamientoDAO getPlanEntrenamientoDAO();

	public abstract ProductoDAO getProductoDAO();

	public abstract ProgresoDAO getProgresoDAO();

	public abstract PruebaFisicaDAO getPruebaFisicaDAO();

	public abstract RecepcionistaDAO getRecepcionistaDAO();

	public abstract RutinaDAO getRutinaDAO();

	public abstract TipoDescuentoDAO geTipoDescuentoDAO();

	public abstract TipoDocumentoDAO geTipoDocumentoDAO();

	public abstract TipoEgresoDAO getTipoEgresoDAO();

	public abstract TipoMembresiaDAO geTipoMembresiaDAO();

	public abstract TipoMiembroDAO geTipoMiembroDAO();

	public abstract TipoPagoDAO geTipoPagoDAO();

	public abstract TipoRutinaDAO geTipoRutinaDAO();

	public abstract ZonaDAO getZonaDAO();

}
