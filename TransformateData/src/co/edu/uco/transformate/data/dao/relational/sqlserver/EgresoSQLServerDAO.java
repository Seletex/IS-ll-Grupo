package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.EgresoDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.EgresoEntity;

import co.edu.uco.transformate.entities.GerenteEntity;
import co.edu.uco.transformate.entities.TipoEgresoEntity;

public class EgresoSQLServerDAO extends SQLDAO<EgresoEntity> implements EgresoDAO {

	@Override
	public void create(EgresoEntity entity) {
		final var sqlStatement = "INSERT INTO Clase (identificacion, nombre,descripcion,total,fecha, responsable, tipoEgreso) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentiUuid());
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getTotal());
			preparedStatement.setObject(5, entity.getFecha());
			preparedStatement.setObject(6, entity.getResponsable());
			preparedStatement.setObject(7, entity.getTipoEgreso());
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
	public List<EgresoEntity> read(EgresoEntity entity) {
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
		return "SELECT identificacion, nombre,descripcion,total,fecha, responsable, tipoEgreso ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Clase ";
	}

	@Override
	protected String prepareWhere(EgresoEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentiUuid())) {
				parameters.add(entity.getIdentiUuid());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : " AND ").append(" nombre=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : " AND ").append("descripcion=? ");
				setWhere = false;
			}

			if (UtilNumber.isEmpty(entity.getTotal())) {
				parameters.add(entity.getTotal());
				where.append(setWhere ? "WHERE " : " AND ").append("total=? ");
				setWhere = false;
			}
			if (UtilDate.getUtilDate().isEmptyDateTime(entity.getFecha()) != null) {
				parameters.add(entity.getFecha());
				where.append(setWhere ? "WHERE " : " AND ").append(" fecha=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getResponsable())) {
				parameters.add(entity.getResponsable());
				where.append(setWhere ? "WHERE " : " AND ").append(" responsable=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getTipoEgreso())) {
				parameters.add(entity.getTipoEgreso());
				where.append(setWhere ? "WHERE " : " AND ").append(" tipoEgreso=? ");

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
	protected List<EgresoEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<EgresoEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new EgresoEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"), resultSet.getString("descripcion"), resultSet.getInt("total"),
						resultSet.getObject("fecha", LocalDateTime.class),
						resultSet.getObject("responsable", GerenteEntity.class),
						resultSet.getObject("tipoEgreso", TipoEgresoEntity.class));
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
