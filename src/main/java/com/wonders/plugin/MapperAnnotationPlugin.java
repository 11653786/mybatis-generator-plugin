package com.wonders.plugin;

import com.wonders.enums.Annotation;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: GuiRunning 郭贵荣
 * @Description: 自定义注释生成
 * @Date: 2018/7/14 0:57
 */
public class MapperAnnotationPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 修改mapper接口
     *
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Set<FullyQualifiedJavaType> set = new HashSet<FullyQualifiedJavaType>();
        set.add(new FullyQualifiedJavaType(Annotation.Mapper.getClazz()));
        interfaze.addImportedTypes(set);
        interfaze.addAnnotation(Annotation.Mapper.getAnnotation());
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }
}