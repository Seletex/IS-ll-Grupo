package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;

import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.ObjetivoPlanDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.ObjetivoEntrenamientoEntity;
import co.edu.uco.transformate.entities.ObjetivoPlanEntity;
import co.edu.uco.transformate.entities.PlanEntrenamientoEntity;



public class ObjetivoPlanSQLServerDAO extends SQLDAO<ObjetivoPlanEntity> implements ObjetivoPlanDAO{

	@Override
	public void create(ObjetivoPlanEntity entity) {
		final var sqlStatement = "INSERT INTO ObjetivoPlan (identificador, nombre, objetivoEntrenamiento,descripcion,planEntrenamiento) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getObjetivoEntrenamientoDTO());
			preparedStatement.setObject(4, entity.getDescripcion());
			preparedStatement.setObject(5, entity.getPlanEntrenamientoDTO());
	

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
	public List<ObjetivoPlanEntity> read(ObjetivoPlanEntity entity) {
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
	public void update(ObjetivoPlanEntity entity) {
		final var sqlStatement = "UPDATE Recepcionista SET nombre=?,usuario=?,telefono=?,salario=?, gimnasio=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

		
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getObjetivoEntrenamientoDTO());
			preparedStatement.setObject(4, entity.getDescripcion());
			preparedStatement.setObject(5, entity.getPlanEntrenamientoDTO());

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
		return "SELECT identificador, nombre, objetivoEntrenamiento,descripcion,planEntrenamiento ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM ObjetivoPlan ";
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
	protected String where() {

		return "WHERE ";
	}

	@Override
	protected String and() {

		return " AND ";
	}

	@Override
	protected String prepareWhere(ObjetivoPlanEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? where() : and()).append(" nombre=? ");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getObjetivoEntrenamientoDTO())) {
				parameters.add(entity.getObjetivoEntrenamientoDTO());
				where.append(setWhere ? where() : and()).append(" telefono=? ");
				setWhere = false;
			}
			
			if (UtilObject.isEmpty(entity.getPlanEntrenamientoDTO())) {
				parameters.add(entity.getPlanEntrenamientoDTO());
				where.append(setWhere ? where() : and()).append(" telefono=? ");

			}

		}
		return where.toString();
	}

	@Override
	protected List<ObjetivoPlanEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<ObjetivoPlanEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new ObjetivoPlanEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"),resultSet.getObject("objetivoEntrenamiento", ObjetivoEntrenamientoEntity.class), resultSet.getString("descripcion"),
						resultSet.getObject("planEntrenamiento", PlanEntrenamientoEntity.class));
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
