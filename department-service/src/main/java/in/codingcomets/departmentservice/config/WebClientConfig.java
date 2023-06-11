package in.codingcomets.departmentservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import in.codingcomets.departmentservice.client.EmployeeClient;

@Configuration
public class WebClientConfig {

	@Autowired
	public LoadBalancedExchangeFilterFunction filterFunction;
	
	@Bean
	public WebClient employeeWebClient() {
		return WebClient
				.builder()
				.filter(filterFunction)
				.baseUrl("http://employee-service/")
				.build();
	}
	
	@Bean
	public EmployeeClient employeeClient() {
		HttpServiceProxyFactory serviceFactory = HttpServiceProxyFactory
				.builder()
				.clientAdapter(WebClientAdapter.forClient(employeeWebClient()))
				.build();
		return serviceFactory.createClient(EmployeeClient.class);
	}
}
