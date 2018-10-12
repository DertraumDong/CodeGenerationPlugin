package ${package_name}.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
public class ${table_name} implements java.io.Serializable {

<#if model_column ?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
        <#if (model.columnType = 'varchar' || model.columnType = 'text')>
    private String ${model.changeColumnName?cap_first};

        </#if>
        <#if model.columnType = 'timestamp' >
    private Date ${model.changeColumnName?cap_first};

        </#if>
        <#if (model.columnType = 'decimal')>
    private BigDecimal ${model.changeColumnName?cap_first};

        </#if>
    </#list>
</#if>

<#if model_column ??>
    <#list model_column as model>
        <#if (model.columnType = 'varchar' || model.columnType = 'text')>
    public String get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName?cap_first};
    }

    public void set${model.changeColumnName?cap_first}(String ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName?cap_first} = ${model.changeColumnName?cap_first};
    }
        </#if>
        <#if model.columnType = 'timestamp' >
    public Date get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName?cap_first};
    }

    public void set${model.changeColumnName?cap_first}(Date ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName?cap_first} = ${model.changeColumnName?cap_first};
    }
        </#if>

        <#if (model.columnType = 'decimal')>
    public BigDecimal get${model.changeColumnName?cap_first}() {
        return this.${model.changeColumnName?cap_first};
    }

    public void set${model.changeColumnName?cap_first}(BigDecimal ${model.changeColumnName?cap_first}) {
        this.${model.changeColumnName?cap_first} = ${model.changeColumnName?cap_first};
    }

        </#if>
    </#list>
</#if>

}