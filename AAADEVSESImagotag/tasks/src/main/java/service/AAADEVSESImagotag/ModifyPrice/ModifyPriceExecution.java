package service.AAADEVSESImagotag.ModifyPrice;

import org.json.JSONObject;

import service.AAADEVSESImagotag.HttpsMethods.PostSES_imagotag;

import com.avaya.app.entity.Instance;
import com.avaya.app.entity.NodeInstance;
import com.avaya.workflow.logger.Logger;
import com.avaya.workflow.logger.LoggerFactory;
import com.roobroo.bpm.model.BpmNode;

public class ModifyPriceExecution extends NodeInstance{
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ModifyPriceExecution.class);
	
	public ModifyPriceExecution(Instance instance, BpmNode node) {
		super(instance, node);
		
	}
	
	public Object execute() throws Exception{
		
		JSONObject json = new JSONObject();
		ModifyPriceModel modifyPriceModel = (ModifyPriceModel)getNode();
		
		String domain = (String)get("domain");
		if(domain == null || domain.isEmpty()){
			domain = modifyPriceModel.getDomain();
		}
		String ocpApimSubscriptionKey = (String)get("ocpApimSubscriptionKey");
		if(ocpApimSubscriptionKey == null || ocpApimSubscriptionKey.isEmpty()){
			ocpApimSubscriptionKey = modifyPriceModel.getOcpApimSubscriptionKey();
		}
		String myId = (String)get("idItem");
		if(myId == null || myId.isEmpty()){
			myId = modifyPriceModel.getIdItem();
		}
		String price = (String)get("price");
		if(price == null || price.isEmpty()){
			price = modifyPriceModel.getPrice();
		}
		String name = (String)get("name");
		if(name == null || name.isEmpty()){
			name = modifyPriceModel.getName();
		}
		
		PostSES_imagotag request = new PostSES_imagotag();
		json = request.postModifyItem(domain, ocpApimSubscriptionKey, myId, price, name);
		
		return json;
	}
}
