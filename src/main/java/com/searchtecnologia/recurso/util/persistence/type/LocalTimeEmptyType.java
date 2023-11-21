package com.searchtecnologia.recurso.util.persistence.type;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Optional;

public class LocalTimeEmptyType implements UserType<LocalTime> {

    public static final LocalTimeEmptyType INSTANCE = new LocalTimeEmptyType();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HHmmss");

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<LocalTime> returnedClass() {
        return LocalTime.class;
    }

    @Override
    public boolean equals(LocalTime value1, LocalTime value2) {
        return Objects.equals(value1, value2);
    }

    @Override
    public int hashCode(LocalTime value) {
        return Objects.hashCode(value);
    }

    @Override
    public LocalTime nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws SQLException {
        String columnValue = rs.getString(position);
        if (StringUtils.isBlank(columnValue)) return null;
        try {
            return LocalTime.parse(columnValue, FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, LocalTime value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        ps.setString(index, Objects.isNull(value) ? " " : FORMATTER.format(value));
    }

    @Override
    public LocalTime deepCopy(LocalTime value) {
        return Optional.ofNullable(value).map(LocalTime::from).orElse(null);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(LocalTime value) {
        return deepCopy(value);
    }

    @Override
    public LocalTime assemble(Serializable cached, Object owner) {
        return deepCopy((LocalTime) cached);
    }

}
