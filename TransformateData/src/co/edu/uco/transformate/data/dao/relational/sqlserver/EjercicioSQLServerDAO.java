package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.EjercicioDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.EjercicioEntity;

import co.edu.uco.transformate.entities.EquipoEntity;

public class EjercicioSQLServerDAO extends SQLDAO<EjercicioEntity> implements EjercicioDAO {

	@Override
	public void create(EjercicioEntity entity) {
		final var sqlStatement = "INSERT INTO Clase (identificacion, nombre,descripcion,equipo,repeticiones, serie) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdenti());
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getEquipoEntity());
			preparedStatement.setObject(5, entity.getRepeticiones());
			preparedStatement.setObject(6, entity.getSeries());
			
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
	public List<EjercicioEntity> read(EjercicioEntity entity) {
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
	public void update(EjercicioEntity entity) {
		final var sqlStatement = "UPDATE Clase SET nombre=?,descripcion=?,equipo=?,repeticion=?, serie=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getEquipoEntity());
			preparedStatement.setObject(5, entity.getRepeticiones());
			preparedStatement.setObject(6, entity.getSeries());

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
	public void delete(EjercicioEntity entity) {
		final var sqlStatement = "DELETE FROM Ejercicio WHERE Identificador = ? ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdenti());

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
		return "SELECT identificacion, nombre,descripcion,equipo,repeticiones, serie ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Ejercicio ";
	}

	@Override
	protected String prepareWhere(EjercicioEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdenti())) {
				parameters.add(entity.getIdenti());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			if (UtilText.getUtilText().isEmpty(entity.getNombre()) ) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? where() : and()).append(" nombre=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getDescripcion()) ) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? where() : and()).append(" descripcion=? ");
				setWhere = false;
			}
			
			if (UtilObject.isEmpty(entity.getEquipoEntity())) {
				parameters.add(entity.getEquipoEntity());
				where.append(setWhere ? where() : and()).append(" equipo=? ");
				setWhere = false;
			}
			
			if (UtilNumber.isEmpty(entity.getRepeticiones())) {
				parameters.add(entity.getRepeticiones());
				where.append(setWhere ? where() : and()).append(" repeticion=? ");
				setWhere = false;
			}
			
			if (UtilNumber.isEmpty(entity.getSeries())) {
				parameters.add(entity.getSeries());
				where.append(setWhere ? where() : and()).append(" serie=? ");
			
			}
			
		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		return "ORDER BY nombre ASC";
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
	protected List<EjercicioEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<EjercicioEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new EjercicioEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"),
						resultSet.getString("descripcion"),
						resultSet.getObject("equipo", EquipoEntity.class),
						resultSet.getInt("repeticion"), resultSet.getInt("serie"));
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
