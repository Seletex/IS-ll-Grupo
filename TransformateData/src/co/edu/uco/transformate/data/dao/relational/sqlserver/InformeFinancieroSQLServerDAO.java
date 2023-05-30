package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;

import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.InformeFinancieroDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.EgresoEntity;

import co.edu.uco.transformate.entities.InformeFinancieroEntity;


public class InformeFinancieroSQLServerDAO extends SQLDAO<InformeFinancieroEntity> implements InformeFinancieroDAO{

	@Override
	public void create(InformeFinancieroEntity entity) {
		final var sqlStatement = "INSERT INTO InformeFinanciero (identificador, fechaInicio,fechaFin, egreso, beneficio, perdida) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getFechaInicioDate());
			preparedStatement.setObject(3, entity.getFechaFinDate());
			preparedStatement.setObject(4, entity.getEgreso());
			preparedStatement.setObject(5, entity.getBeneficio());
			preparedStatement.setObject(6, entity.getPerdida());
		

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_CREATE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_PROBLEM_CREATE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, exception);

		}

		
	}

	@Override
	public List<InformeFinancieroEntity> read(InformeFinancieroEntity entity) {
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
		return "SELECT identificador, fechaInicio,fechaFin, egreso, beneficio, perdida ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM InformeFinanciero ";
	}


	@Override
	protected String prepareWhere(InformeFinancieroEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getFechaInicioDate())) {
				parameters.add(entity.getFechaInicioDate());
				where.append(setWhere ? where() : and()).append(" fechaInicio=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getFechaFinDate())) {
				parameters.add(entity.getFechaFinDate());
				where.append(setWhere ? where() : and()).append(" fechaFin=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getEgreso())) {
				parameters.add(entity.getEgreso());
				where.append(setWhere ? where() : and()).append(" egreso=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getBeneficio())) {
				parameters.add(entity.getBeneficio());
				where.append(setWhere ? where() : and()).append(" beneficio=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getPerdida())) {
				parameters.add(entity.getPerdida());
				where.append(setWhere ? where() : and()).append(" perdida=? ");
			
			}

		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		return "ORDER BY egreso ASC";
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
	protected List<InformeFinancieroEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<InformeFinancieroEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new InformeFinancieroEntity(resultSet.getObject("identificador", UUID.class),
						
						resultSet.getObject("fechaInicio", LocalDate.class),resultSet.getObject("fechaFin", LocalDate.class),
						resultSet.getObject("egreso",EgresoEntity.class),
						resultSet.getFloat("beneficio"),
						resultSet.getFloat("perdida"));
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
