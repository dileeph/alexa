package com.example.alexa;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

@Component
public class DefaultSpeechlet implements Speechlet {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultSpeechlet.class);
	@Autowired
	private Map<String, IntentHandler> handlerMap;
	
	@Override
	public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
		LOG.debug(intentRequest.getIntent().getName());
		final Intent intent = intentRequest.getIntent();

        if (intent == null) {
            throw new SpeechletException("No intent found");
        }
		String intentName = intentRequest.getIntent().getName();
		if(StringUtils.isNotEmpty(intentName) && handlerMap.containsKey(StringUtils.lowerCase(intentName))){
			handlerMap.get(StringUtils.lowerCase(intentName)).onIntent(intentRequest, session);
		}else{
			throw new SpeechletException("No such intent");
		}
		
		
		return null;
	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSessionEnded(SessionEndedRequest arg0, Session arg1) throws SpeechletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSessionStarted(SessionStartedRequest arg0, Session arg1) throws SpeechletException {
		// TODO Auto-generated method stub

	}

}
