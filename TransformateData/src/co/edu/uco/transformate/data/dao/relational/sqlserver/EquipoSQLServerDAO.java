package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.transformate.data.dao.EquipoDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.EquipoEntity;

public class EquipoSQLServerDAO extends SQLDAO<EquipoEntity> implements EquipoDAO{

	@Override
	public void create(EquipoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EquipoEntity> read(EquipoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EquipoEntity entity) {
		// TODO Auto-generated method stub
		
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
	protected String prepareWhere(EquipoEntity entity, List<Object> parameters) {
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
	protected List<EquipoEntity> executeQuery(PreparedStatement preparedStatement) {
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
