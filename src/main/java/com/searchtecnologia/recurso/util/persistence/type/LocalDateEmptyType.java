package com.searchtecnologia.recurso.util.persistence.type;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Optional;

public class LocalDateEmptyType implements UserType<LocalDate> {

    public static final LocalDateEmptyType INSTANCE = new LocalDateEmptyType();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<LocalDate> returnedClass() {
        return LocalDate.class;
    }

    @Override
    public boolean equals(LocalDate value1, LocalDate value2) {
        return Objects.equals(value1, value2);
    }

    @Override
    public int hashCode(LocalDate value) {
        return Objects.hashCode(value);
    }

    @Override
    public LocalDate nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws SQLException {
        String columnValue = rs.getString(position);
        if (StringUtils.isBlank(columnValue)) return null;
        try {
            return LocalDate.parse(columnValue, FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, LocalDate value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        ps.setString(index, Objects.isNull(value) ? " " : FORMATTER.format(value));
    }

    @Override
    public LocalDate deepCopy(LocalDate value) {
        return Optional.ofNullable(value).map(LocalDate::from).orElse(null);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(LocalDate value) {
        return deepCopy(value);
    }

    @Override
    public LocalDate assemble(Serializable cached, Object owner) {
        return deepCopy((LocalDate) cached);
    }
}