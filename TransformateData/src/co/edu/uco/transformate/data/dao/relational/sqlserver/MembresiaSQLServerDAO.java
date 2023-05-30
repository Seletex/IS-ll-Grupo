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
import co.edu.uco.transformate.data.dao.MembresiaDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.MembresiaEntity;

import co.edu.uco.transformate.entities.TipoMembresiaEntity;

public class MembresiaSQLServerDAO extends SQLDAO<MembresiaEntity> implements MembresiaDAO{



	@Override
	public List<MembresiaEntity> read(MembresiaEntity entity) {
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
		return "SELECT identificador, tipoMembresia,fechaInicio, fechaFin ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Membresia ";
	}


	@Override
	protected String prepareWhere(MembresiaEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getTipoMembresiaDTO())) {
				parameters.add(entity.getTipoMembresiaDTO());
				where.append(setWhere ? where() : and()).append(" tipoMembresia=? ");
				setWhere = false;
			}
			
			if (UtilObject.isEmpty(entity.getFechaInicio())) {
				parameters.add(entity.getFechaInicio());
				where.append(setWhere ? where() : and()).append(" fechaInicio=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getFechaFin())) {
				parameters.add(entity.getFechaFin());
				where.append(setWhere ? where() : and()).append(" fechaFin=? ");
				setWhere = false;
			}

		

		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		return "ORDER BY fechaInicio ASC";
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
	protected List<MembresiaEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<MembresiaEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new MembresiaEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getObject("tipoMembresia", TipoMembresiaEntity.class),
						resultSet.getObject("fechaInicio", LocalDate.class), resultSet.getObject("fechaFin",LocalDate.class));
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
