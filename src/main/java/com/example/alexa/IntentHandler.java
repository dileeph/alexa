package com.example.alexa;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;

public interface IntentHandler {

	public SpeechletResponse onIntent(IntentRequest request, Session session);
}
