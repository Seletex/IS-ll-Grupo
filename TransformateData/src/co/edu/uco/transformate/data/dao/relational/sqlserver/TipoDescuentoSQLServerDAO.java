package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.TipoDescuentoDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.TipoDescuentoEntity;


public class TipoDescuentoSQLServerDAO extends SQLDAO<TipoDescuentoEntity> implements TipoDescuentoDAO{

	@Override
	public List<TipoDescuentoEntity> read(TipoDescuentoEntity entity) {
		final var sqlStatement = new StringBuilder();
		final var parameters = new ArrayList<>();
		sqlStatement.append(prepareSelec());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareStringOrderBy());

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {
			setParameters(preparedStatement, parameters);
			return executeQuery(preparedStatement);
		} catch (final TransformateException exception) {

			throw exception;
		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_READ_SQLEXCEPTION,
					SQLServerDAOMessage.USER_PROBLEM_READ_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_UNEXPECTED_PROBLEM_READ_SQLEXCEPTION,
					SQLServerDAOMessage.USER_UNEXPECTED_PROBLEM_READ_SQLEXCEPTION, exception);

		}
	}

	@Override
	protected String prepareSelec() {
		return "SELECT identificador,nombre ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM TipoDescuento ";
	}

	@Override
	protected String prepareWhere(TipoDescuentoEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			if (UtilText.getUtilText().isEmpty(entity.getNombre()) ) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? where() : and()).append(" nombre=? ");
				setWhere = false;
			}

			

		
		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		return "ORDER BY nombre ASC ";
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement)) {
				for (int index = 0; index < parameters.size(); index++) {
					preparedStatement.setObject(index + 1, parameters.get(index));
				}
			}
		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_READ_SETWHERE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_PROBLEM_READ_SETWHERE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_READ_SETWHERE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_UNEXPECTED_PROBLEM_READ_SETWHERE_SQLEXCEPTION, exception);

		}
		
	}

	@Override
	protected List<TipoDescuentoEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<TipoDescuentoEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new TipoDescuentoEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"));
					
				resultEntities.add(entityTmp);
			}

			return resultEntities;
		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_READ_PROBLEM_STRING,
					SQLServerDAOMessage.USER_READ_PROBLEM_STRING, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_READ_UNEXPECTED_PROBLEM_STRING,
					SQLServerDAOMessage.USER_READ_UNEXPECTED_PROBLEM_STRING, exception);

		}
	}

	@Override
	protected String where() {
		
		return "WHERE ";
	}

	@Override
	protected String and() {
		
		return " AND ";
	}


}
