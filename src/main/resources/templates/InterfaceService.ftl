package ${package_name}.service;

import ${package_name}.model.${table_name};
import ${package_name}.model.${table_name}DTO;
import java.util.List;

/**
* 描述：${table_annotation} 服务实现层接口
* @author ${author}
* @date ${date}
*/
public interface I${table_name}Service {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    ${table_name}DTO findDTOById(String id)throws Exception;

    /**
    * 描述：根据条件查询User
    * @param ${table_name?lower_case}
    */
    public List<${table_name}> selectAll(${table_name} ${table_name?lower_case});

}