package com.mursilsayed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@ManagedResource
public class TestDecryptor {
	
	@Value("${test.encrypted.property}")
	String propertyValue;
	

	@ManagedOperation
	public String readEncryptedProperty()
	{
		return this.propertyValue;
	}
}
