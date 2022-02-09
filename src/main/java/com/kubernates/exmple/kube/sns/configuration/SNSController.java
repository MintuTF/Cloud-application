package com.kubernates.exmple.kube.sns.configuration;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class SNSController {

    @Autowired
    private AmazonSNSClient snsClient;

    private String ARP= "arn:aws:sns:us-east-1:666783077966:MyFirst_SNS_TOPIC";
    @GetMapping("sub/{email}")
    public String emailSubscriber(@PathVariable("email") String email){
        SubscribeRequest request=new SubscribeRequest(ARP,"email",email);
        snsClient.subscribe(request);
        return "sucessfuly subscribe";
    }
    @GetMapping("pub/{msg}")
    public String emailPublisher(@PathVariable String msg){

        PublishRequest publishRequest= new PublishRequest(ARP,msg,"auto sns");
        snsClient.publish(publishRequest);

        return "sucessfuly published";

    }
}
