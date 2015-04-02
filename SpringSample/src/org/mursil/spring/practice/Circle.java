package org.mursil.spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class Circle implements Shape {

	private Point centre;
	
	@Autowired
	private MessageSource msgSource;
	
	
	
	public MessageSource getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(MessageSource msgSource) {
		this.msgSource = msgSource;
	}

	public Point getCentre() {
		return centre;
	}

	//@Autowired
	//@Qualifier("circleRelated")
	@Resource
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		//System.out.println(this.msgSource.getMessage("greeting",null,"No Message Found",null));
		
		System.out.println(this.msgSource.getMessage("interleaved.msg",new Object[]{centre.getX(),centre.getY()},"No Message Found",null));
		
		
		
	}
	
	@PreDestroy
	public void onDestroy()  {
		System.out.println("Circle: @PreDestroy");
		
	}
	

	@PostConstruct
	public void OnInitCircle() 
	{
		System.out.println("Circle: @PostConstruct");
	}
	
	

}
