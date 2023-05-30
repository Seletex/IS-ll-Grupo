package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.transformate.data.dao.HistorialClaseDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.HistorialClaseEntity;

public class HistorialClaseSQLServerDAO extends SQLDAO<HistorialClaseEntity> implements HistorialClaseDAO{

	@Override
	public void create(HistorialClaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistorialClaseEntity> read(HistorialClaseEntity entity) {
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
	protected String prepareWhere(HistorialClaseEntity entity, List<Object> parameters) {
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
	protected List<HistorialClaseEntity> executeQuery(PreparedStatement preparedStatement) {
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
