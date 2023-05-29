package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;

import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;

import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.data.dao.ClaseDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;
import co.edu.uco.transformate.entities.ClaseEntity;
import co.edu.uco.transformate.entities.EntrenadorEntity;

public class ClaseSQLServerDAO extends SQLDAO<ClaseEntity> implements ClaseDAO {

	public ClaseSQLServerDAO(final Connection connection) {

	}

	@Override
	public void create(ClaseEntity entity) {
		final var sqlStatement = "INSERT INTO Clase (identificacion, fechaClase, horaInicio, HoraFin, entrenador) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificadorUuid());
			preparedStatement.setObject(2, entity.getFechaDate());
			preparedStatement.setObject(3, entity.getHoraInicioDate());
			preparedStatement.setObject(4, entity.getHoraFinDate());
			preparedStatement.setObject(5, entity.getEntrenadorDTO());

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
	public List<ClaseEntity> read(ClaseEntity entity) {
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
	public void update(ClaseEntity entity) {
		final var sqlStatement = "UPDATE Clase SET fecha=?,horaInicio=?,horaFin=?,entrenador=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(2, entity.getFechaDate());
			preparedStatement.setObject(3, entity.getHoraInicioDate());
			preparedStatement.setObject(4, entity.getHoraFinDate());
			preparedStatement.setObject(5, entity.getEntrenadorDTO());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_UPDATE_SQLEXCEPTION,
					SQLServerDAOMessage.TECHNICAL_PROBLEM_UPDATE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, exception);
		}

	}

	@Override
	public void delete(ClaseEntity entity) {
		final var sqlStatement = "DELETE FROM Clase WHERE Identificador = ? ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificadorUuid());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_PROBLEM_DELETE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_PROBLEM_DELETE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw TransformateDataException.create(SQLServerDAOMessage.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_SQLEXCEPTION,
					SQLServerDAOMessage.USER_UNEXPECTED_PROBLEM_DELETE_SQLEXCEPTION, exception);

		}
	}

	@Override
	protected String prepareSelec() {
		return "SELECT identificacionuuid,fecha, horaInicio,horaFin,entrenador ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Clase ";
	}

	@Override
	protected String prepareWhere(ClaseEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificadorUuid())) {
				parameters.add(entity.getIdentificadorUuid());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			if (UtilDate.getUtilDate().IsEmptyDate(entity.getFechaDate()) != null) {
				parameters.add(entity.getFechaDate());
				where.append(setWhere ? "WHERE " : " AND ").append(" fecha=? ");
				setWhere = false;
			}

			if (UtilDate.getDefaultTime(entity.getHoraInicioDate()) != null) {
				parameters.add(entity.getHoraInicioDate());
				where.append(setWhere ? "WHERE " : " AND ").append("horaInicio=? ");
				setWhere = false;
			}

			if (UtilDate.getDefaultTime(entity.getHoraFinDate()) != null) {
				parameters.add(entity.getHoraFinDate());
				where.append(setWhere ? "WHERE " : " AND ").append("horaFin=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getEntrenadorDTO())) {
				parameters.add(entity.getEntrenadorDTO());
				where.append(setWhere ? "WHERE " : " AND ").append(" entrenador=? ");

			}
		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		return "ORDER BY fecha ASC";
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
	protected List<ClaseEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<ClaseEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new ClaseEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getObject("fecha", LocalDate.class),
						resultSet.getObject("horaInicio", LocalDateTime.class),
						resultSet.getObject("horaFin", LocalDateTime.class),
						resultSet.getObject("entrenador", EntrenadorEntity.class));
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
}
