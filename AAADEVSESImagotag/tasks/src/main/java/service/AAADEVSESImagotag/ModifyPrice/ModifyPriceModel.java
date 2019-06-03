package service.AAADEVSESImagotag.ModifyPrice;

import com.roobroo.bpm.model.BpmNode;

public class ModifyPriceModel extends BpmNode{

	public ModifyPriceModel(String name, String id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private String domain;
	private String ocpApimSubscriptionKey;
	private String idItem;
	private String price;
	private String name;
	
	
	
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
