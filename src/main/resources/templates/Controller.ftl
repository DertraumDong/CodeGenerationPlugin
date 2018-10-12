package ${package_name}.controller;
import ${package_name}.service.I${table_name}Service;
import ${package_name}.model.${table_name};
import ${package_name}.model.${table_name}DTO;
import ${package_name}.model.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


/**
* 描述：${table_annotation}控制层
* @author ${author}
* @date ${date}
* @version V1.0
*/
@RestController
@RequestMapping("/${table_name?lower_case}")
public class ${table_name}Controller {

    @Autowired
    private I${table_name}Service ${table_name?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    * @param id  ${table_annotation}id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData findById(@PathVariable("id") String id)throws Exception {
        ${table_name}DTO ${table_name?uncap_first}DTO = ${table_name?uncap_first}Service.findDTOById(id);
        return new ResultData(${table_name?uncap_first}DTO);
    }


}