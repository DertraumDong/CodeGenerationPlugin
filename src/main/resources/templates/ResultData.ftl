package ${package_name}.model;

/**
* ResultData
* @author DerTraum
* @date ${date}
*/
public class ResultData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer SUCCESS = 200;
	public static final Integer FAILURE = 300;

	private Integer code;
	private String 	desc;
	private Object 	data;


	public ResultData() {
	}

	public ResultData(Object data) {
		this.data = data;
	}

	public static ResultData SUCCESS() {
		ResultData re = new ResultData();
		re.setCode(SUCCESS);
		re.setDesc("操作成功");
		return re;
	}

	public static ResultData FAILURE() {
		ResultData re = new ResultData();
		re.setCode(FAILURE);
		re.setDesc("操作失败");
		return re;
	}

	public static ResultData SUCCESS(Object data) {
		ResultData re = new ResultData();
		re.setCode(SUCCESS);
		re.setDesc("操作成功");
		re.setData(data);
		return re;
	}

	public static ResultData FAILURE(Object data) {
		ResultData re = new ResultData();
		re.setCode(FAILURE);
		re.setDesc("操作失败");
		re.setData(data);
		return re;
	}

	public static ResultData SUCCESS(String desc, Object data) {
		ResultData re = new ResultData();
		re.setCode(SUCCESS);
		re.setDesc(desc);
		re.setData(data);
		return re;
	}

	public static ResultData FAILURE(String desc, Object data) {
		ResultData re = new ResultData();
		re.setCode(FAILURE);
		re.setDesc(desc);
		re.setData(data);
		return re;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}