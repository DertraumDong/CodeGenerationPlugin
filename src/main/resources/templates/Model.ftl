package ${package_name}.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
public class ${table_name} extends BaseModel {


<#if model_column ?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
        <#if (model.columnType == 'char' || model.columnType == 'varchar' || model.columnType == 'tinytext' || model.columnType == 'text' || model.columnType == 'mediumtext' || model.columnType == 'longtext' || model.columnType == 'enum' || model.columnType == 'set' )>
    private String ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'int' || model.columnType == 'mediumint' )>
    private Integer ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'bigint')>
    private Long ${model.changeColumnName};
        </#if>
        <#if model.columnType == 'tinyint' >
    private Byte ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'tinyblob' || model.columnType == 'blob' ||  model.columnType == 'mediumblob' ||  model.columnType == 'longblob' ||  model.columnType == 'binary' ||  model.columnType == 'varbinary' ||  model.columnType == 'geometry')>
    private byte[] ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'decimal')>
    private BigDecimal ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'double')>
    private Double ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'float')>
    private Float ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'bit')>
    private Boolean ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'smallint')>
    private Short ${model.changeColumnName};
        </#if>
        <#if (model.columnType == 'point' || model.columnType == 'linestring' || model.columnType == 'polygon' || model.columnType == 'multipoint' || model.columnType == 'multilinestring' || model.columnType == 'multipolygon' || model.columnType == 'geometrycollection' || model.columnType == 'json' )>
    private Object ${model.changeColumnName};
        </#if>
        <#if model.columnType == 'date' || model.columnType == 'time' || model.columnType == 'year' || model.columnType == 'timestamp' || model.columnType == 'datetime'>
    private Date ${model.changeColumnName};
        </#if>
    </#list>
</#if>

<#if model_column ??>
    <#list model_column as model>

        <#if (model.columnType == 'char' || model.columnType == 'varchar' || model.columnType == 'tinytext' || model.columnType == 'text' || model.columnType == 'mediumtext' || model.columnType == 'longtext' || model.columnType == 'enum' || model.columnType == 'set' )>
    public String get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(String ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'int' || model.columnType == 'mediumint' )>
    public Integer get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Integer ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'bigint')>
    public Long get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Long ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if model.columnType == 'tinyint' >
    public Byte get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Byte ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if model.columnType == 'tinyblob' || model.columnType == 'blob' ||  model.columnType == 'mediumblob' ||  model.columnType == 'longblob' ||  model.columnType == 'binary' ||  model.columnType == 'varbinary' ||  model.columnType == 'geometry'>
    public byte[] get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(byte[] ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'decimal')>
    public BigDecimal get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(BigDecimal ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'double')>
    public Double get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Double ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'float')>
    public Float get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Float ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'bit')>
    public Boolean get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Boolean ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'smallint')>
    public Short get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Short ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if (model.columnType == 'point' || model.columnType == 'linestring' || model.columnType == 'polygon' || model.columnType == 'multipoint' || model.columnType == 'multilinestring' || model.columnType == 'multipolygon' || model.columnType == 'geometrycollection' || model.columnType == 'json' )>
    public Object get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Object ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
        <#if model.columnType == 'date' || model.columnType == 'time' || model.columnType == 'year' || model.columnType == 'timestamp' || model.columnType == 'datetime'>
    public Date get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName};
    }

    public void set${model.changeColumnName?cap_first}(Date ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
        </#if>
    </#list>
</#if>

}