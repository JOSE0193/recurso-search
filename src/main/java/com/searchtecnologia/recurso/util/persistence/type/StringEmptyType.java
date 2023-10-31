package com.searchtecnologia.recurso.util.persistence.type;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class StringEmptyType implements UserType<String> {

    public static final StringEmptyType INSTANCE = new StringEmptyType();

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<String> returnedClass() {
        return String.class;
    }

    @Override
    public boolean equals(String value1, String value2) {
        return Objects.equals(value1, value2);
    }

    @Override
    public int hashCode(String value) {
        return Objects.hashCode(value);
    }

    @Override
    public String nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws SQLException {
        String columnValue = rs.getString(position);
        if (rs.wasNull()) columnValue = null;
        return columnValue;
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, String value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        ps.setString(index, Objects.isNull(value) ? " " : value);
    }

    @Override
    public String deepCopy(String value) {
        return String.valueOf(value);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(String value) {
        return deepCopy(value);
    }

    @Override
    public String assemble(Serializable cached, Object owner) {
        return deepCopy((String) cached);
    }
}
