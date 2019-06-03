package service.AAADEVSESImagotag.SerchItems;

import org.json.JSONObject;
import service.AAADEVSESImagotag.HttpsMethods.GetSES_imagotag;
import com.avaya.app.entity.Instance;
import com.avaya.app.entity.NodeInstance;
import com.roobroo.bpm.model.BpmNode;
import com.avaya.workflow.logger.*;


public class SerchItemsExecution extends NodeInstance {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(SerchItemsExecution.class);

	public SerchItemsExecution(Instance instance, BpmNode node) {
		super(instance, node);
	}

	public Object execute() throws Exception {
		JSONObject json = new JSONObject();
		SerchItemsModel serchItemsModel = (SerchItemsModel)getNode();
		
		String domain = (String) get("domain");
		if(domain == null || domain.isEmpty()){
			domain = serchItemsModel.getDomain();
		}
		String page = (String) get("page");
		if(page == null || page.isEmpty()){
			page = serchItemsModel.getPage();
			if(page == null || page.isEmpty()){
				page = "1";
			}
		}
		String pageSize = (String) get("pageSize");
		if(pageSize == null || pageSize.isEmpty()){
			pageSize = serchItemsModel.getPageSize();
			if(pageSize == null || pageSize.isEmpty()){
				pageSize = "50";
			}
		}	
		String ocpApimSubscriptionKey = (String) get("ocpApimSubscriptionKey");
		if(ocpApimSubscriptionKey == null || ocpApimSubscriptionKey.isEmpty()){
			ocpApimSubscriptionKey = serchItemsModel.getOcpApimSubscriptionKey();
		}
		
		GetSES_imagotag request = new GetSES_imagotag();
		json = request.getSerchItems(domain, page, pageSize, ocpApimSubscriptionKey);
				
		
		return json;
    }
	
}
