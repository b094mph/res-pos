package com.res.util;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * MessageLoader class is used to load the properties of the message resource file.
 * This message will list all of the messages and labels that can be displayed on the UI.
 *  
 * @author bobby
 *
 */
@Component
public class MessageLoader {

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messages;

	public String getMessage(String key){
		if(StringUtils.isBlank(key)){
			return "";
		}else{
			return messages.getMessage(key, null, Locale.getDefault());
		}
	}
	
	public String getMessage(String key, String[] arguments){
		if(StringUtils.isBlank(key)){
			return "";
		}else{
			return messages.getMessage(key, arguments, Locale.getDefault());
		}
	}
	
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	
}
