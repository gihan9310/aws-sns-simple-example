package lk.gihanz.sns.controllers;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@RestController
@RequestMapping("/sns")
public class SNSController {

    @Autowired
    private AmazonSNSClient amazonSNSClient;
    private static String TOPICS_SNS="arn:aws:sns:us-east-1:302667632397:my-sns-topic";

    @GetMapping(value = "/subscribe/{email}")
    public String subscribSNSTopic(@PathVariable("email") String email){
        SubscribeRequest request = new SubscribeRequest(TOPICS_SNS,"email",email);
        amazonSNSClient.subscribe(request);
        return "Check Your Email................";
    }


    @GetMapping(value = "/publish/{msg}")
    public String publishTopic(@PathVariable("msg") String msg){

        PublishRequest request= new PublishRequest(TOPICS_SNS ,msg,"GIHAN IS WONDERFUL DEVELOPER");
        amazonSNSClient.publish(request);

        return "Message Published";
    }
}
