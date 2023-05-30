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
import co.edu.uco.transformate.data.dao.RecepcionistaDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.GimnasioEntity;
import co.edu.uco.transformate.entities.RecepcionistaEntity;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class RecepcionistaSQLServerDAO extends SQLDAO<RecepcionistaEntity> implements RecepcionistaDAO {

	@Override
	public void create(RecepcionistaEntity entity) {
		final var sqlStatement = "INSERT INTO Recepcionista (identificador, tipoDocumento,identificacion,"
				+ "nombre, usuario,contraseñ,telefono,salario,gimnasio) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getTipoDocumentoDTO());
			preparedStatement.setObject(3, entity.getIdentificacion());
			preparedStatement.setObject(4, entity.getNombre());
			preparedStatement.setObject(5, entity.getUsuario());
			preparedStatement.setObject(6, entity.getConstraseña());
			preparedStatement.setObject(7, entity.getTelefono());
			preparedStatement.setObject(8, entity.getSalario());
			preparedStatement.setObject(9, entity.getGimnasioDTO());

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
	public List<RecepcionistaEntity> read(RecepcionistaEntity entity) {
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
	public void update(RecepcionistaEntity entity) {
		final var sqlStatement = "UPDATE Recepcionista SET nombre=?,usuario=?,telefono=?,salario=?, gimnasio=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(4, entity.getNombre());
			preparedStatement.setObject(5, entity.getUsuario());

			preparedStatement.setObject(7, entity.getTelefono());
			preparedStatement.setObject(8, entity.getSalario());
			preparedStatement.setObject(9, entity.getGimnasioDTO());

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
	public void delete(RecepcionistaEntity entity) {
		final var sqlStatement = "DELETE FROM Recepcionista WHERE Identificador = ? ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

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
		return "SELECT identificador, tipoDocumento,identificacion,\"\r\n"
				+ "				+ \"nombre, usuario,contraseñ,telefono,salario,gimnasio ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Recepcionista ";
	}

	@Override
	protected String prepareWhere(RecepcionistaEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}

			if (UtilObject.isEmpty(entity.getTipoDocumentoDTO())) {
				parameters.add(entity.getTipoDocumentoDTO());
				where.append(setWhere ? where() : and()).append(" tipoDocumneto=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getTelefono())) {
				parameters.add(entity.getTelefono());
				where.append(setWhere ? where() : and()).append(" telefono=? ");

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
	protected List<RecepcionistaEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<RecepcionistaEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new RecepcionistaEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getObject("tipoDocumento", TipoDocumentoEntity.class),
						resultSet.getString("identificacion"), resultSet.getString("nombre"),
						resultSet.getString("usuario"), resultSet.getString("contraseña"),
						resultSet.getString("telefono"), resultSet.getInt("salario"),
						resultSet.getObject("gimnasio", GimnasioEntity.class));
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
