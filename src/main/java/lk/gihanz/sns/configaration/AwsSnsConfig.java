package lk.gihanz.sns.configaration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Configuration
public class AwsSnsConfig {

    @Bean
    @Primary
    public AmazonSNSClient amazonSNSClient(){
       return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAUM6DFR4GWA3XAFQ3","ytP6IUV2jIOPnYABjQZdcZa0+cnRDoS5IQuy7eGL"))).build();
    }

}
