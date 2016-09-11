/**
 * 
 */
package com.mursilsayed;

import java.util.UUID;

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
	
	public String getServerID()
	{
		
		return uid.toString();
	}

}
