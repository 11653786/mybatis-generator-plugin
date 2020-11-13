package com.wonders.enums;

/**
 * 开发公司：青岛海豚数据技术有限公司
 * 版权：青岛海豚数据技术有限公司
 * <p>
 * Annotation
 *
 * @author 刘志强
 * @created Create Time: 2019/1/16
 */
public enum Annotation {
    Mapper("@Mapper", "org.apache.ibatis.annotations.Mapper"),
    ApiModel("@ApiModel", "io.swagger.annotations.ApiModel"),
    ApiModelProperty("@ApiModelProperty", "io.swagger.annotations.ApiModelProperty"),
    Length("@Length", "org.hibernate.validator.constraints.Length"),
    JsonFormat("@JsonFormat", "com.fasterxml.jackson.annotation.JsonFormat"),
    EXCEL("@Excel", "com.wonders.his.common.annotation.Excel");
    private String annotation;

    private String clazz;
    Annotation(String annotation, String clazz) {
        this.annotation = annotation;
        this.clazz = clazz;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getClazz() {
        return clazz;
    }
}
