package com.example.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.example.alexa.IntentHandler;

@Component("yesintent")
public class YesIntent implements IntentHandler {
	private static final Logger LOG = LoggerFactory.getLogger(YesIntent.class);

	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session) {
		// TODO Auto-generated method stub
		LOG.info("{} , {}", request, session);
		return null;
	}

}
