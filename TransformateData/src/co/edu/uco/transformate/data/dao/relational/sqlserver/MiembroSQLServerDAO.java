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
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.SQLServerDAOMessage;
import co.edu.uco.transformate.data.dao.MiembroDAO;
import co.edu.uco.transformate.data.dao.relational.SQLDAO;

import co.edu.uco.transformate.entities.MembresiaEntity;
import co.edu.uco.transformate.entities.MiembroEntity;
import co.edu.uco.transformate.entities.ObjetivoEntrenamientoEntity;
import co.edu.uco.transformate.entities.PruebaFisicaEntity;

import co.edu.uco.transformate.entities.TipoDocumentoEntity;
import co.edu.uco.transformate.entities.TipoMiembroEntity;

public class MiembroSQLServerDAO extends SQLDAO<MiembroEntity> implements MiembroDAO {

	@Override
	public void create(MiembroEntity entity) {
		final var sqlStatement = "INSERT INTO Miembro (MembresiaEntity membresiaEntity, UUID identificador, String nombre,\r\n"
				+ "			TipoDocumentoEntity tipoDocumentoEntity, String identificacion, LocalDate fechaNacimiento, String correo,\r\n"
				+ "			String telefono, PruebaFisicaEntity prueba, ObjetivoEntrenamientoEntity objetivo,\r\n "
				+ "			TipoMiembroEntity tipoMiembroEntity) ";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getMembresiaDTO());
			preparedStatement.setObject(2, entity.getIdentificador());
			preparedStatement.setObject(3, entity.getNombre());
			preparedStatement.setObject(4, entity.getTipoDocumentoDTO());
			preparedStatement.setObject(5, entity.getIdentificacion());
			preparedStatement.setObject(6, entity.getFechaNacimiento());
			preparedStatement.setObject(7, entity.getCorreo());

			preparedStatement.setObject(8, entity.getTelefono());
			preparedStatement.setObject(9, entity.getPrueba());
			preparedStatement.setObject(10, entity.getObjetivo());
			preparedStatement.setObject(11, entity.getTipoMiembroDTO());

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
	public List<MiembroEntity> read(MiembroEntity entity) {
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
	public void update(MiembroEntity entity) {
		final var sqlStatement = "UPDATE Miembro SET membresia=?,nombre=?,tipoDocumento=?,identificacion=?,correo=?,tipoMiembro=? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getMembresiaDTO());

			preparedStatement.setObject(3, entity.getNombre());
			preparedStatement.setObject(4, entity.getTipoDocumentoDTO());
			preparedStatement.setObject(5, entity.getIdentificacion());
			preparedStatement.setObject(6, entity.getFechaNacimiento());
			preparedStatement.setObject(7, entity.getCorreo());

			preparedStatement.setObject(8, entity.getTelefono());
			preparedStatement.setObject(9, entity.getPrueba());
			preparedStatement.setObject(10, entity.getObjetivo());
			preparedStatement.setObject(11, entity.getTipoMiembroDTO());

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
		return "SELECT MembresiaEntity membresiaEntity, UUID identificador, String nombre,\\r\\n\"\r\n"
				+ "				+ \"			TipoDocumentoEntity tipoDocumentoEntity, String identificacion, LocalDate fechaNacimiento, String correo,\\r\\n\"\r\n"
				+ "				+ \"			String telefono, PruebaFisicaEntity prueba, ObjetivoEntrenamientoEntity objetivo,\\r\\n \"\r\n"
				+ "				+ \"			TipoMiembroEntity tipoMiembroEntity";
	}

	@Override
	protected String prepareFrom() {
		return "FROM Miembro ";
	}

	@Override
	protected String prepareWhere(MiembroEntity entity, List<Object> parameters) {
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			
			if (UtilObject.isEmpty(entity.getMembresiaDTO())) {
				parameters.add(entity.getMembresiaDTO());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
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
			if (UtilObject.isEmpty(entity.getIdentificacion())) {
				parameters.add(entity.getIdentificacion());
				where.append(setWhere ? where() : and()).append(" tipoDocumneto=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getTelefono())) {
				parameters.add(entity.getTelefono());
				where.append(setWhere ? where() : and()).append(" telefono=? ");

			}
			if (UtilObject.isEmpty(entity.getPrueba())) {
				parameters.add(entity.getPrueba());
				where.append(setWhere ? where() : and()).append(" tipoDocumneto=? ");
				setWhere = false;
			}
			if (UtilObject.isEmpty(entity.getObjetivo())) {
				parameters.add(entity.getObjetivo());
				where.append(setWhere ? where() : and()).append(" tipoDocumneto=? ");
				setWhere = false;
			}
			
			if (UtilObject.isEmpty(entity.getTipoMiembroDTO())) {
				parameters.add(entity.getTipoMiembroDTO());
				where.append(setWhere ? where() : and()).append(" tipoDocumneto=? ");
				setWhere = false;
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
	protected List<MiembroEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<MiembroEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				final var entityTmp = new MiembroEntity(resultSet.getObject("membresia", MembresiaEntity.class),
						resultSet.getObject("identificador", UUID.class), resultSet.getString("nombre"),
						resultSet.getObject("tipoDocumento", TipoDocumentoEntity.class),
						resultSet.getString("identificacion"), resultSet.getObject("fechaNacimiento", LocalDate.class),
						resultSet.getString("correo"), resultSet.getString("telefono"),
						resultSet.getObject("prueba", PruebaFisicaEntity.class),
						resultSet.getObject("objetivo", ObjetivoEntrenamientoEntity.class),
						resultSet.getObject("tipoMiembro", TipoMiembroEntity.class));
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
