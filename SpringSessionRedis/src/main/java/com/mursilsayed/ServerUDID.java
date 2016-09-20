/**
 * 
 */
package com.mursilsayed;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Mursil
 *
 */
@Service
public class ServerUDID {
	private UUID uid;
	
	public ServerUDID(){
		uid =  UUID.randomUUID();
		
	}
	
	@Cacheable("serverDetails")
	public String getServerID()
	{
		
		return uid.toString();
	}
	
	@Cacheable(cacheNames="serverDetails")
	public String getServerName(String name)
	{
		return uid.toString()+name;
	}
	
	
	

}
