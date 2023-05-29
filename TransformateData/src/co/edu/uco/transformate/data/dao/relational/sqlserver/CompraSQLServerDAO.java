package co.edu.uco.transformate.data.dao.relational.sqlserver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.exception.TransformateDataException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.CompraDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.CompraEntity;

import co.edu.uco.transformate.entities.EstadoPagoEntity;
import co.edu.uco.transformate.entities.ProductoEntity;
import co.edu.uco.transformate.entities.TipoPagoEntity;

public class CompraSQLServerDAO extends SQLDAO<CompraEntity> implements CompraDAO {

	@Override
	public void create(CompraEntity entity) {
		final var sqlStatement = "INSERT INTO Clase (identificacion, fecha, producto,tipoPago, estadoPago ) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificadorUuid());
			preparedStatement.setObject(2, entity.getFechaDate());
			preparedStatement.setObject(3, entity.getProductoDTO());
			preparedStatement.setObject(4, entity.getTipoPagoDTO());
			preparedStatement.setObject(5, entity.getEstadoPagoDTO());

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
	public List<CompraEntity> read(CompraEntity entity) {
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
		return "SELECT identificacion, fecha, producto,tipoPago, estadoPago ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Compra ";
	}

	@Override
	protected String prepareWhere(CompraEntity entity, List<Object> parameters) {
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

			if (UtilObject.isEmpty(entity.getProductoDTO())) {
				parameters.add(entity.getProductoDTO());
				where.append(setWhere ? "WHERE " : " AND ").append("producto=? ");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getTipoPagoDTO())) {
				parameters.add(entity.getTipoPagoDTO());
				where.append(setWhere ? "WHERE " : " AND ").append("tipoPago=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getEstadoPagoDTO())) {
				parameters.add(entity.getEstadoPagoDTO());
				where.append(setWhere ? "WHERE " : " AND ").append(" estadoPago=? ");

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
	protected List<CompraEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<CompraEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new CompraEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getObject("producto", ProductoEntity.class),
						resultSet.getObject("fecha", LocalDate.class),
						resultSet.getObject("estadoPago", EstadoPagoEntity.class),
						resultSet.getObject("tipoPago", TipoPagoEntity.class));
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
