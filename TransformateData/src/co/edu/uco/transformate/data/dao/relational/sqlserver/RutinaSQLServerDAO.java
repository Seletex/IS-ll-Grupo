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
import co.edu.uco.transformate.data.dao.RutinaDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.EjercicioEntity;

import co.edu.uco.transformate.entities.PlanEntrenamientoEntity;
import co.edu.uco.transformate.entities.RutinaEntity;
import co.edu.uco.transformate.entities.TipoRutinaEntity;

public class RutinaSQLServerDAO extends SQLDAO<RutinaEntity> implements RutinaDAO {

	@Override
	public void create(RutinaEntity entity) {
		final var sqlStatement = "INSERT INTO Rutina (identificacion, descripcion, planEntrenamiento, ejercicio, tipoRutina) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getDescripcion());
			preparedStatement.setObject(3, entity.getPlanEntrenamientoDTO());
			preparedStatement.setObject(4, entity.getEjercicioDTO());
			preparedStatement.setObject(5, entity.getTipoRutinaDTO());

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
	public List<RutinaEntity> read(RutinaEntity entity) {
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
	public void update(RutinaEntity entity) {
		final var sqlStatement = "UPDATE Clase SET fecha=?,horaInicio=?,horaFin=?,entrenador=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getPlanEntrenamientoDTO());
			preparedStatement.setObject(5, entity.getEjercicioDTO());
			preparedStatement.setObject(6, entity.getTipoRutinaDTO());
			
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
	protected String prepareSelec() {
		return "SELECT identificacion,descripcion, planEntrenamiento,ejercicio,tipoRutina ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Rutina ";
	}


	@Override
	protected String prepareWhere(RutinaEntity entity, List<Object> parameters) {
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
			if (UtilText.getUtilText().isEmpty(entity.getDescripcion()) ) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? where() : and()).append(" descripcion=? ");
				setWhere = false;
			}

		
			if (UtilObject.isEmpty(entity.getPlanEntrenamientoDTO())) {
				parameters.add(entity.getPlanEntrenamientoDTO());
				where.append(setWhere ? where() : and()).append("planEntrenamiento=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getEjercicioDTO())) {
				parameters.add(entity.getEjercicioDTO());
				where.append(setWhere ? where() : and()).append(" ejercicio=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getTipoRutinaDTO())) {
				parameters.add(entity.getTipoRutinaDTO());
				where.append(setWhere ? where() : and()).append(" tipoRutina=? ");
				
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
	protected List<RutinaEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<RutinaEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new RutinaEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("descripcion"),resultSet.getString("nombre"),
						resultSet.getObject("planEntrenamiento", PlanEntrenamientoEntity.class),
						resultSet.getObject("ejercicio", EjercicioEntity.class),
						resultSet.getObject("tipoRutina", TipoRutinaEntity.class));
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
