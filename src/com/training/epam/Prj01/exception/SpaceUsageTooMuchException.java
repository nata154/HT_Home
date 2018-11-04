package com.training.epam.Prj01.exception;

public class SpaceUsageTooMuchException extends Exception{

	private static final long serialVersionUID = 1L;

	public SpaceUsageTooMuchException(String e) {
		super(e);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
