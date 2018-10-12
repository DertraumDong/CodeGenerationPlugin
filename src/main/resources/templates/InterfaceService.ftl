package ${package_name}.service;
import ${package_name}.model.${table_name};
import ${package_name}.model.${table_name}DTO;
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

}