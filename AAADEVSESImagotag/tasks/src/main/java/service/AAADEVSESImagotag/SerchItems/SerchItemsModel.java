package service.AAADEVSESImagotag.SerchItems;

import java.util.List;

import com.roobroo.bpm.model.BpmNode;
import com.roobroo.bpm.util.WFUtil;

public class SerchItemsModel extends BpmNode{

	private static final long serialVersionUID = 1L;
	public SerchItemsModel(String name, String id) {
		super(name, id);
	}
	
	private String domain;
	private String page;
	private String pageSize;
	private String ocpApimSubscriptionKey;
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getOcpApimSubscriptionKey() {
		return ocpApimSubscriptionKey;
	}
	public void setOcpApimSubscriptionKey(String ocpApimSubscriptionKey) {
		this.ocpApimSubscriptionKey = ocpApimSubscriptionKey;
	}
	
    @Override
    public boolean validateProperties(List<String> w, List<String> e) {
        boolean isValid = true;
        if ((!WFUtil.validateMapping(w, e, getDataInputAssociations(), "domain"))
                && (!WFUtil.validateEmptyProperty(domain, "domain", e))) {
        	e.add("No value assigned to domain");
            isValid = false;
         
        }
        if ((!WFUtil.validateMapping(w, e, getDataInputAssociations(), "ocpApimSubscriptionKey"))
                && (!WFUtil.validateEmptyProperty(ocpApimSubscriptionKey, "ocpApimSubscriptionKey", e))) {
        	e.add("No value assigned to ocpApimSubscriptionKey");
            isValid = false;
         
        }
        
        return super.validateProperties(w, e) && isValid;
        
	}
	
}
