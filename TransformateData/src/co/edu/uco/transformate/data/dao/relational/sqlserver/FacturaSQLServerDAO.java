package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.transformate.data.dao.FacturaDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.FacturaEntity;

public class FacturaSQLServerDAO extends SQLDAO<FacturaEntity> implements FacturaDAO{

	@Override
	public void create(FacturaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FacturaEntity> read(FacturaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FacturaEntity entity) {
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
	protected String prepareWhere(FacturaEntity entity, List<Object> parameters) {
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
	protected List<FacturaEntity> executeQuery(PreparedStatement preparedStatement) {
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
