package service.AAADEVSESImagotag.SerchItemById;

import org.json.JSONObject;

import service.AAADEVSESImagotag.HttpsMethods.GetSES_imagotag;

import com.avaya.app.entity.Instance;
import com.avaya.app.entity.NodeInstance;
import com.avaya.workflow.logger.Logger;
import com.avaya.workflow.logger.LoggerFactory;
import com.roobroo.bpm.model.BpmNode;

public class SerchItemByIdExecution extends NodeInstance {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(SerchItemByIdExecution.class);
	
	public SerchItemByIdExecution(Instance instance, BpmNode node) {
		super(instance, node);
		
	}
	
	public Object execute() throws Exception{
		JSONObject json = new JSONObject();
		SerchItemByIdModel serchItemByModel = (SerchItemByIdModel)getNode();
		
		String domain = (String)get("domain");
		if(domain == null || domain.isEmpty()){
			domain = serchItemByModel.getDomain();
		}
		
		String ocpApimSubscriptionKey = (String)get("ocpApimSubscriptionKey");
		if(ocpApimSubscriptionKey == null || ocpApimSubscriptionKey.isEmpty()){
			ocpApimSubscriptionKey = serchItemByModel.getOcpApimSubscriptionKey();
		}
		
		String id = (String)get("myId");
		if(id == null || id.isEmpty()){
			id = serchItemByModel.getMyId();
		}
		
		GetSES_imagotag request = new GetSES_imagotag();
		json = request.getItemById(id, ocpApimSubscriptionKey, domain);
		
		return json;
	}
	
}
