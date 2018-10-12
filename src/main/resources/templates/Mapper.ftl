<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.dao.${table_name}DAO">

    <resultMap id="${table_name}DTOResultMap" type="${package_name}.model.${table_name}DTO">
        <#if model_column ?exists>
            <#list model_column as model>
                <#if model.isKey ?? && model.isKey=1>
                <id column="${model.changeColumnName}" property="${model.changeColumnName}" jdbcType="${model.columnType?upper_case}" />
                <#else>
                <result column="${model.changeColumnName}" property="${model.changeColumnName}" jdbcType="${model.columnType?upper_case}" />
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

    <select id="findDTOById" parameterType="String" resultMap="${table_name}DTOResultMap">
        <include refid="findDtoSql"></include>
        <where>
            <include refid="parameterSql"></include>
        </where>
    </select>

    <select id="find${table_name}Page" parameterType="${package_name}.model.${table_name}DTO" resultMap="${table_name}DTOResultMap">
        <include refid="findDtoSql" />
        <where>
            <include refid="parameterSql"></include>
        </where>
    </select>

</mapper>