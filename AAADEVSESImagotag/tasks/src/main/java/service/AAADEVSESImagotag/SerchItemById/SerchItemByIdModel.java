package service.AAADEVSESImagotag.SerchItemById;

import java.util.List;

import com.roobroo.bpm.model.BpmNode;
import com.roobroo.bpm.util.WFUtil;

public class SerchItemByIdModel extends BpmNode{

	private static final long serialVersionUID = 1L;
	
	public SerchItemByIdModel(String name, String id) {
		super(name, id);
	}
	private String myId;
	private String domain;
	private String ocpApimSubscriptionKey;

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getOcpApimSubscriptionKey() {
		return ocpApimSubscriptionKey;
	}
	public void setOcpApimSubscriptionKey(String ocpApimSubscriptionKey) {
		this.ocpApimSubscriptionKey = ocpApimSubscriptionKey;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	
}
