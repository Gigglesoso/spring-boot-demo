package cst.entity;
/**
 * 返回到前台的信息实体
 * @author Administrator
 *
 * @param <T>
 */
public class ReturnData<T> {
	//状态码，0为请求成功，其他均失败
	private Integer code;
	//返回的附加信息
	private String msg;
	//要返回的数据
	private T data;
	
	private Integer pages;
	//无参构造
	public ReturnData() {}
	
	//有参构造
	public ReturnData(int code,String msg,T t){
		this.code=code;
		this.msg=msg;
		this.data=t;
	}
	public ReturnData(int code,String msg,T t,int pages){
		this.code=code;
		this.msg=msg;
		this.data=t;
		this.pages=pages;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "ReturnData [code=" + code + ", msg=" + msg + ", data=" + data + ", pages=" + pages + "]";
	}
}
