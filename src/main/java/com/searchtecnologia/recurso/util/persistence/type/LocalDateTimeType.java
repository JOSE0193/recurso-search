package com.searchtecnologia.recurso.util.persistence.type;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LocalDateTimeType implements UserType<LocalDateTime>{

    public static final LocalDateTimeType INSTANCE = new LocalDateTimeType();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<LocalDateTime> returnedClass() {
        return LocalDateTime.class;
    }

    @Override
    public boolean equals(LocalDateTime value1, LocalDateTime value2) {
        return Objects.equals(value1, value2);
    }

    @Override
    public int hashCode(LocalDateTime value) {
        return Objects.hashCode(value);
    }

    @Override
    public LocalDateTime nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws SQLException {
        String columnValue = rs.getString(position);
        if (StringUtils.isBlank(columnValue)) columnValue = null;
        return LocalDateTime.parse(columnValue, FORMATTER);
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, LocalDateTime value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (Objects.isNull(value)) {
            ps.setNull(index, Types.VARCHAR);
        } else {
            ps.setString(index, FORMATTER.format(value));
        }
    }

    @Override
    public LocalDateTime deepCopy(LocalDateTime value) {
        return LocalDateTime.from(value);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(LocalDateTime value) {
        return deepCopy(value);
    }

    @Override
    public LocalDateTime assemble(Serializable cached, Object owner) {
        return deepCopy((LocalDateTime) cached);
    }

}
