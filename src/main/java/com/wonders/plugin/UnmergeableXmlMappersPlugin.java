package com.wonders.plugin;


import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 修复mybatis生成mapper.xml时会重复的问题
 *
 * @author DangerShi
 * @date 2020/5/7
 */
public class UnmergeableXmlMappersPlugin extends PluginAdapter {
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field isMergeable = GeneratedXmlFile.class.getDeclaredField("isMergeable");
            isMergeable.setAccessible(true);
            isMergeable.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
