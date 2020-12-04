package com.wonders.resolver;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author tyang
 */
public class OracleNumberResolver implements JavaTypeResolver {
    protected List<String> warnings;
    protected Properties properties = new Properties();
    protected Context context;
    protected boolean forceBigDecimals;
    protected Map<Integer, OracleNumberResolver.JdbcTypeInformation> typeMap = new HashMap();

    public OracleNumberResolver() {
        this.typeMap.put(2003, new OracleNumberResolver.JdbcTypeInformation("ARRAY", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-5, new OracleNumberResolver.JdbcTypeInformation("BIGINT", new FullyQualifiedJavaType(Long.class.getName())));
        this.typeMap.put(-2, new OracleNumberResolver.JdbcTypeInformation("BINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(-7, new OracleNumberResolver.JdbcTypeInformation("BIT", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(2004, new OracleNumberResolver.JdbcTypeInformation("BLOB", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(16, new OracleNumberResolver.JdbcTypeInformation("BOOLEAN", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(1, new OracleNumberResolver.JdbcTypeInformation("CHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2005, new OracleNumberResolver.JdbcTypeInformation("CLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(70, new OracleNumberResolver.JdbcTypeInformation("DATALINK", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(91, new OracleNumberResolver.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(3, new OracleNumberResolver.JdbcTypeInformation("DECIMAL", new FullyQualifiedJavaType(BigDecimal.class.getName())));
        this.typeMap.put(2001, new OracleNumberResolver.JdbcTypeInformation("DISTINCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(8, new OracleNumberResolver.JdbcTypeInformation("DOUBLE", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(6, new OracleNumberResolver.JdbcTypeInformation("FLOAT", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(4, new OracleNumberResolver.JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2000, new OracleNumberResolver.JdbcTypeInformation("JAVA_OBJECT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-16, new OracleNumberResolver.JdbcTypeInformation("LONGNVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-4, new OracleNumberResolver.JdbcTypeInformation("LONGVARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(-1, new OracleNumberResolver.JdbcTypeInformation("LONGVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-15, new OracleNumberResolver.JdbcTypeInformation("NCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2011, new OracleNumberResolver.JdbcTypeInformation("NCLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-9, new OracleNumberResolver.JdbcTypeInformation("NVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(0, new OracleNumberResolver.JdbcTypeInformation("NULL", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(2, new OracleNumberResolver.JdbcTypeInformation("NUMERIC", new FullyQualifiedJavaType(BigDecimal.class.getName())));
        this.typeMap.put(1111, new OracleNumberResolver.JdbcTypeInformation("OTHER", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(7, new OracleNumberResolver.JdbcTypeInformation("REAL", new FullyQualifiedJavaType(Float.class.getName())));
        this.typeMap.put(2006, new OracleNumberResolver.JdbcTypeInformation("REF", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(5, new OracleNumberResolver.JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Short.class.getName())));
        this.typeMap.put(2002, new OracleNumberResolver.JdbcTypeInformation("STRUCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(92, new OracleNumberResolver.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(93, new OracleNumberResolver.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(-6, new OracleNumberResolver.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Byte.class.getName())));
        this.typeMap.put(-3, new OracleNumberResolver.JdbcTypeInformation("VARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(12, new OracleNumberResolver.JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.forceBigDecimals = StringUtility.isTrue(properties.getProperty("forceBigDecimals"));
    }

    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        FullyQualifiedJavaType answer = null;
        OracleNumberResolver.JdbcTypeInformation jdbcTypeInformation = (OracleNumberResolver.JdbcTypeInformation) this.typeMap.get(introspectedColumn.getJdbcType());
        if (jdbcTypeInformation != null) {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
            answer = this.overrideDefaultType(introspectedColumn, answer);
        }
        return answer;
    }

    protected FullyQualifiedJavaType overrideDefaultType(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer = defaultType;
        switch (column.getJdbcType()) {
            case -7:
                answer = this.calculateBitReplacement(column, defaultType);
                break;
            case 2:
                //number类型
                answer = this.calculateBigDecimalReplacement(column, defaultType);
                break;
            case 3:
                //decimal类型
                answer = this.calculateBigDecimalReplacement(column, defaultType);
                break;
        }
        return answer;
    }

    protected FullyQualifiedJavaType calculateBitReplacement(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer;
        if (column.getLength() > 1) {
            answer = new FullyQualifiedJavaType("byte[]");
        } else {
            answer = defaultType;
        }

        return answer;
    }

    protected FullyQualifiedJavaType calculateBigDecimalReplacement(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer;
        if (column.getScale() < 1 && column.getLength() <= 20 && !this.forceBigDecimals) {
            if (column.getLength() > 9) {
                answer = new FullyQualifiedJavaType(Long.class.getName());
            } else if (column.getLength() > 4) {
                answer = new FullyQualifiedJavaType(Integer.class.getName());
            } else {
                answer = new FullyQualifiedJavaType(Long.class.getName());
            }
        } else {
            answer = defaultType;
        }

        return answer;
    }

    @Override
    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        String answer = null;
        OracleNumberResolver.JdbcTypeInformation jdbcTypeInformation = (OracleNumberResolver.JdbcTypeInformation) this.typeMap.get(introspectedColumn.getJdbcType());
        if (jdbcTypeInformation != null) {
            answer = jdbcTypeInformation.getJdbcTypeName();
        }

        return answer;
    }

    @Override
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    public static class JdbcTypeInformation {
        private String jdbcTypeName;
        private FullyQualifiedJavaType fullyQualifiedJavaType;

        public JdbcTypeInformation(String jdbcTypeName, FullyQualifiedJavaType fullyQualifiedJavaType) {
            this.jdbcTypeName = jdbcTypeName;
            this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        }

        public String getJdbcTypeName() {
            return this.jdbcTypeName;
        }

        public FullyQualifiedJavaType getFullyQualifiedJavaType() {
            return this.fullyQualifiedJavaType;
        }
    }
}
