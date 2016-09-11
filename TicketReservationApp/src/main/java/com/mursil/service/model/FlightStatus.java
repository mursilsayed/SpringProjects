/**
 * 
 */
package com.mursil.service.model;


/**
 * Enum for representing the Different Status of Flight. 
 * 
 * @author Mursil
 *
 */
public enum FlightStatus {

	OK ("OK"), //Flight is Scheduled 
	C ("CANCELLED"), //Flight Cancelled
	D ("DELAYED");// Flight Delayed
	
	private final String name; 
	
    private FlightStatus(String s) {
        name = s;
    }
	
    public String value() {
        return name();
    }
    
    public String toString() {
        return this.name;
     }

    public static FlightStatus fromValue(String v) {
        return valueOf(v);
    }
}
