package com.wenable.priya.beans;

public class Token {
	
	private String jwtoken;

	public Token(String jwtoken) {
		super();
		this.jwtoken = jwtoken;
	}

	public String getJwtoken() {
		return jwtoken;
	}

	public void setJwtoken(String jwtoken) {
		this.jwtoken = jwtoken;
	}

	@Override
	public String toString()
	{
		return jwtoken;
	}


}
