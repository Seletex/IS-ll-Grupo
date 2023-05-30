package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.transformate.data.dao.EventoDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.EventoEntity;

public class EventoSQLServerDAO extends SQLDAO<EventoEntity> implements EventoDAO{

	@Override
	public void create(EventoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventoEntity> read(EventoEntity entity) {
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
	protected String prepareWhere(EventoEntity entity, List<Object> parameters) {
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
	protected List<EventoEntity> executeQuery(PreparedStatement preparedStatement) {
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
