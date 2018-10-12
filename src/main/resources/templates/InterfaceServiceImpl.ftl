package ${package_name}.service.impl;
import ${package_name}.model.${table_name};
import ${package_name}.service.I${table_name}Service;
import ${package_name}.dao.${table_name}DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package_name}.model.${table_name}DTO;
import java.util.List;

/**
* 描述：${table_annotation} 服务实现层
* @author ${author}
* @date ${date}
*/
@Service
public class ${table_name}ServiceImpl implements I${table_name}Service {

    @Autowired
    private ${table_name}DAO ${table_name?uncap_first}DAO;

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    @Override
    public ${table_name}DTO findDTOById(String id) throws Exception {
        ${table_name}DTO ${table_name?uncap_first}DTO = ${table_name?uncap_first}DAO.findDTOById(id);
        return ${table_name?uncap_first}DTO;
    }

    /**
    * 描述：根据条件查询User
    * @param ${table_name?lower_case}
    */
    @Override
    public List<${table_name}> selectAll(${table_name} ${table_name?lower_case}){
        List<${table_name}> ${table_name?lower_case}List = ${table_name?uncap_first}DAO.selectAll(${table_name?lower_case});
        return ${table_name?lower_case}List;
    }
}

