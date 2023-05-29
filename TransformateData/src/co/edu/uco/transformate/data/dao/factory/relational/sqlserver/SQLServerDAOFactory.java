package co.edu.uco.transformate.data.dao.factory.relational.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;

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
			
		}
		
	}

	

	@Override
	public ClaseDAO getClaseDAO() {
	
		return null;
	}

	@Override
	public CompraDAO getCompraDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescuentoDAO getDescuentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EgresoDAO getEgresoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EjercicioDAO getEjercicioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntrenadorDAO getEntrenadorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipoDAO getEquipoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoPagoDAO getEstadoPagoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventoDAO getEventoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GerenteDAO getGerenteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GimnasioDAO getGimnasioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialClaseDAO getHistorialClaseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialNotaMedicaDAO getHistorialNotaMedicaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialProgresoDAO getHistorialProgresoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialPruebaFisicaDAO getHistorialPruebaFisicaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InformeFinancieroDAO getInformeFinancieroDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembresiaDAO getMembresiaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroDAO getMiembroDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NivelDificultadDAO getDificultadDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaMedicaDAO getNotaMedicaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetivoEntrenamientoDAO getObjetivoEntrenamientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetivoPlanDAO getObjetivoPlanDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanEntrenamientoDAO getPlanEntrenamientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgresoDAO getProgresoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruebaFisicaDAO getPruebaFisicaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecepcionistaDAO getRecepcionistaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RutinaDAO getRutinaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDescuentoDAO geTipoDescuentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDocumentoDAO geTipoDocumentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoEgresoDAO getTipoEgresoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoMembresiaDAO geTipoMembresiaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoMiembroDAO geTipoMiembroDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPagoDAO geTipoPagoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRutinaDAO geTipoRutinaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZonaDAO getZonaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
