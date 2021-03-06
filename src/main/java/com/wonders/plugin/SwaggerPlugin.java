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
public class SwaggerPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 修改实体类
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Set<FullyQualifiedJavaType> set = new HashSet<FullyQualifiedJavaType>();
        set.add(new FullyQualifiedJavaType(Annotation.ApiModel.getClazz()));
        topLevelClass.addImportedTypes(set);
        topLevelClass.addAnnotation(Annotation.ApiModel.getAnnotation() + "(\"" + introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "\")");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
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
        // 追加ApiModelProperty注解
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.ApiModelProperty.getClazz()));
        field.addAnnotation(Annotation.ApiModelProperty.getAnnotation() + "(value=\"" + introspectedColumn.getRemarks() + "\",name=\"" + introspectedColumn.getJavaProperty() + "\")");
        // 追加长度验证注解
        String a = field.getType().getShortName();
        if (StringUtils.equals("String", a)) {
            topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.Length.getClazz()));
            field.addAnnotation(Annotation.Length.getAnnotation() + "(max = " + introspectedColumn.getLength() + ", message = \"" + introspectedColumn.getRemarks() + "名长度最长为" + introspectedColumn.getLength() + "\")");
        }
        // 追加日期格式化注解
        if (introspectedColumn.getJdbcTypeName() == "TIMESTAMP") {
            field.addAnnotation(Annotation.JsonFormat.getAnnotation() + "(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone=\"GMT+8\")");
            topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.JsonFormat.getClazz()));
        }
        // tinyint数据（Byte）转换成（Integer）类型
        if (StringUtils.equals("Byte", a)) {
            field.setType(new FullyQualifiedJavaType("java.lang.Integer"));
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


}
