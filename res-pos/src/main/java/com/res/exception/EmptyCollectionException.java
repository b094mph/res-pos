package com.res.exception;

/**
 * Exception for empty collection
 * @author bobby
 *
 */
public class EmptyCollectionException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyCollectionException(){
		super();
	}
	
	public EmptyCollectionException(String msg){
		super(msg);
	}
}
