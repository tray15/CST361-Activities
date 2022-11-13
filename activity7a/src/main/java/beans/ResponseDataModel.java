package beans;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel extends ResponseModel {
	private Album data;
	
	public ResponseDataModel() {
		super();
	}
	public ResponseDataModel(int status, String message, Album data) {
		super();
		this.data = data;
	}
	public Album getData() {
		return data;
	}
	public void setData(Album data) {
		this.data = data;
	}
}
