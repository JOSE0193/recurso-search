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
import java.util.Objects;

public class LocalTimeType implements UserType<LocalTime> {

    public static final LocalTimeType INSTANCE = new LocalTimeType();
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
        if (StringUtils.isBlank(columnValue)) columnValue = null;
        return LocalTime.parse(columnValue, FORMATTER);
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, LocalTime value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (Objects.isNull(value)) {
            ps.setNull(index, Types.VARCHAR);
        } else {
            ps.setString(index, FORMATTER.format(value));
        }
    }

    @Override
    public LocalTime deepCopy(LocalTime value) {
        return LocalTime.from(value);
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