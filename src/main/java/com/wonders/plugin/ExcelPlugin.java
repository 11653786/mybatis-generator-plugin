package com.wonders.plugin;

import com.wonders.enums.Annotation;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tyang swaggerPlugin
 */
public class ExcelPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }


    /**
     * 实体类字段
     *
     * @param field
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 生成注释
        fieldAnnotation(field, introspectedColumn.getRemarks());
        // 追加ApiModelProperty注解
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.EXCEL.getClazz()));
        field.addAnnotation(Annotation.EXCEL.getAnnotation() + "(name=\"" + introspectedColumn.getRemarks() + "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


    /**
     * 属性注释生成
     *
     * @param field
     * @param explain
     */
    public static void fieldAnnotation(Field field, String explain) {
        // 生成注释
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(explain);
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
        // 生成注释结束
    }
}
