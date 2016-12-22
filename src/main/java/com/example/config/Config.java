package com.example.config;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import com.example.alexa.DefaultSpeechlet;

@Configuration
public class Config {
	@Value("classpath:alexa.properties")
	private Resource alexaPropsResource;

	@Autowired
	private DefaultSpeechlet defaultSpeechlet;
	
	@Bean
	public ServletRegistrationBean speechletServlet() throws IOException {
		final Properties props = new Properties(System.getProperties());
        try (InputStream propsIn = alexaPropsResource.getInputStream()) {
            props.load(propsIn);
            System.setProperties(props);
        }
		SpeechletServlet speechletServlet = new SpeechletServlet();
		speechletServlet.setSpeechlet(defaultSpeechlet);
		ServletRegistrationBean registration = new ServletRegistrationBean(speechletServlet, "/alexa/*");
		return registration;
	}
}
