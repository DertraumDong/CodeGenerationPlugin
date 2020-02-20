<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.dao.${table_name}DAO">

    <resultMap id="${table_name}DTOResultMap" type="${package_name}.model.${table_name}DTO">
        <#if model_column ?exists>
            <#list model_column as model>
                <#if model.isKey ?? && model.isKey=1>
                <id column="${model.changeColumnName}" property="${model.changeColumnName}" jdbcType="${model.columnType?upper_case}" />
                <#else>
                <result column="${model.changeColumnName}" property="${model.changeColumnName}" jdbcType="${model.columnType?upper_case}"/>
                </#if>
            </#list>
        </#if>
    </resultMap>

    <sql id="findDtoSql">
        select * from  ${table_name_small}
    </sql>

    <sql id="parameterSql">
        <#if model_column ?exists>
            <#list model_column as model>
        <if test="${model.changeColumnName} != null">
            AND ${model.changeColumnName} =  ${r'#{'+ model.changeColumnName +'}' }
        </if>
            </#list>
        </#if>
    </sql>

    <sql id="sortSql">
        <if test="sortName != null">
            ORDER BY ${r'#{sortName}'}  ${r'#{sortRule}'}
        </if>
        <#if model_column ?exists>
            <#list model_column as model>
                <#if model.isKey ?? && model.isKey=1>
                <if test="sortName == null">
                    ORDER BY ${model.changeColumnName} ASC
                </if>
                </#if>
            </#list>
        </#if>
    </sql>

    <select id="findDTOById" parameterType="String" resultMap="${table_name}DTOResultMap">
        <include refid="findDtoSql"></include>
        <where>
            <include refid="parameterSql"></include>
        </where>
        <include refid="sortSql"></include>
    </select>

    <select id="selectAll" parameterType="${package_name}.model.${table_name}" resultMap="${table_name}DTOResultMap" >
        <include refid="findDtoSql"></include>
        <where>
            <include refid="parameterSql"></include>
        </where>
        <include refid="sortSql"></include>
    </select>

</mapper>