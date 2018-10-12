package ${package_name}.dao;

import ${package_name}.model.${table_name}DTO;
import org.springframework.stereotype.Component;
/**
* 描述：${table_annotation} 服务Dao接口
* @author ${author}
* @date ${date}
*/
@Component
public interface ${table_name}DAO {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    ${table_name}DTO findDTOById(String id)throws Exception;

    ${table_name}DTO create${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

    void delete${table_name}(String id) throws Exception;

    ${table_name}DTO update${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

}