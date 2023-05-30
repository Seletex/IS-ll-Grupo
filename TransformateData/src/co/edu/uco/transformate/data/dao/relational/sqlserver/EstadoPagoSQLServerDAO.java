package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.transformate.data.dao.EstadoPagoDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.EstadoPagoEntity;

public class EstadoPagoSQLServerDAO extends SQLDAO<EstadoPagoEntity> implements EstadoPagoDAO{

	@Override
	public List<EstadoPagoEntity> read(EstadoPagoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareSelec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareWhere(EstadoPagoEntity entity, List<Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareStringOrderBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<EstadoPagoEntity> executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String where() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String and() {
		// TODO Auto-generated method stub
		return null;
	}

}
