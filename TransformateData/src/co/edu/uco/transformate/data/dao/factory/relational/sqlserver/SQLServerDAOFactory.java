package co.edu.uco.transformate.data.dao.factory.relational.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.transformate.crosscutting.exception.TransformateCrossCuttingException;
import co.edu.uco.transformate.crosscutting.utils.UtilSql;
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
import co.edu.uco.transformate.data.dao.factory.DAOFactory;



public final class SQLServerDAOFactory extends DAOFactory{

	private Connection connection;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	protected final void abrirConexion() {
	UtilSql.connectionIsOpen(connection);
	}

	@Override
	public final void cerrarConexion() {
		
		UtilSql.closeConnection(connection);
	}

	@Override
	public final void initTransaction() {
		try {
			UtilSql.initTransaction(connection);
		} catch (SQLException exception) {
			throw TransformateCrossCuttingException.create("No ha sido posible iniciar la transaccion. Porfavor intentelo de nuevo, si el problema persiste contacte al administrador");
		}
		
	}

	@Override
	public final void commitTransaction() {
		UtilSql.commitTransaction(connection);
	}

	@Override
	public void cancelarTransaccion() {
		try {
			UtilSql.rollBackTransaction(connection);
		} catch (SQLException e) {
			throw TransformateCrossCuttingException.create("No ha sido posible devolver la transaccion. Porfavor intentelo de nuevo, si el problema persiste contacte al administrador");
		}
		
	}

	

	@Override
	public ClaseDAO getClaseDAO() {
		
		return getClaseDAO();
	}
	@Override
	public CompraDAO getCompraDAO() {
		return getCompraDAO();
	}
	@Override
	public DescuentoDAO getDescuentoDAO() {
		return getDescuentoDAO();
	}
	@Override
	public EgresoDAO getEgresoDAO() {
		
		return getEgresoDAO();
	}
	@Override
	public EjercicioDAO getEjercicioDAO() {
		
		return getEjercicioDAO();
	}
	@Override
	public EntrenadorDAO getEntrenadorDAO() {
		
		return getEntrenadorDAO();
	}
	@Override
	public EquipoDAO getEquipoDAO() {
		
		return getEquipoDAO();
	}
	@Override
	public EstadoPagoDAO getEstadoPagoDAO() {
	
		return getEstadoPagoDAO();
	}
	@Override
	public EventoDAO getEventoDAO() {
	
		return getEventoDAO();
	}
	@Override
	public FacturaDAO getFacturaDAO() {
	
		return getFacturaDAO();
	}
	@Override
	public GerenteDAO getGerenteDAO() {
		
		return getGerenteDAO();
	}
	@Override
	public GimnasioDAO getGimnasioDAO() {
		
		return getGimnasioDAO();
	}
	@Override
	public HistorialClaseDAO getHistorialClaseDAO() {
	
		return getHistorialClaseDAO();
	}
	@Override
	public HistorialNotaMedicaDAO getHistorialNotaMedicaDAO() {
	
		return getHistorialNotaMedicaDAO();
	}
	@Override
	public HistorialProgresoDAO getHistorialProgresoDAO() {
		return getHistorialProgresoDAO() ;
	}
	@Override
	public HistorialPruebaFisicaDAO getHistorialPruebaFisicaDAO() {
		return getHistorialPruebaFisicaDAO();
	}
	@Override
	public InformeFinancieroDAO getInformeFinancieroDAO() {
		return getInformeFinancieroDAO();
	}
	@Override
	public MembresiaDAO getMembresiaDAO() {
		return getMembresiaDAO();
	}
	@Override
	public MiembroDAO getMiembroDAO() {
		return getMiembroDAO();
	}
	@Override
	public NivelDificultadDAO getDificultadDAO() {
		return getDificultadDAO();
	}
	@Override
	public NotaMedicaDAO getNotaMedicaDAO() {
		return getNotaMedicaDAO();
	}
	@Override
	public ObjetivoEntrenamientoDAO getObjetivoEntrenamientoDAO() {
		return getObjetivoEntrenamientoDAO();
	}
	@Override
	public ObjetivoPlanDAO getObjetivoPlanDAO() {
		return getObjetivoPlanDAO();
	}
	@Override
	public PlanEntrenamientoDAO getPlanEntrenamientoDAO() {
		return getPlanEntrenamientoDAO();
	}
	@Override
	public ProductoDAO getProductoDAO() {
		return getProductoDAO();
	}
	@Override
	public ProgresoDAO getProgresoDAO() {
		return getProgresoDAO();
	}
	@Override
	public PruebaFisicaDAO getPruebaFisicaDAO() {
		return getPruebaFisicaDAO() ;
	}
	@Override
	public RecepcionistaDAO getRecepcionistaDAO() {
		return getRecepcionistaDAO();
	}
	@Override
	public RutinaDAO getRutinaDAO() {
		return getRutinaDAO();
	}
	@Override
	public TipoDescuentoDAO geTipoDescuentoDAO() {
		return geTipoDescuentoDAO();
	}
	@Override
	public TipoDocumentoDAO geTipoDocumentoDAO() {
		return geTipoDocumentoDAO();
	}
	@Override
	public TipoEgresoDAO getTipoEgresoDAO() {
		return getTipoEgresoDAO();
	}
	@Override
	public TipoMembresiaDAO geTipoMembresiaDAO() {
		return geTipoMembresiaDAO();
	}
	@Override
	public TipoMiembroDAO geTipoMiembroDAO() {
		return geTipoMiembroDAO();
	}
	@Override
	public TipoPagoDAO geTipoPagoDAO() {
		return geTipoPagoDAO();
	}
	@Override
	public TipoRutinaDAO geTipoRutinaDAO() {
		return geTipoRutinaDAO();
	}
	@Override
	public ZonaDAO getZonaDAO() {
		return getZonaDAO();
	}

}
