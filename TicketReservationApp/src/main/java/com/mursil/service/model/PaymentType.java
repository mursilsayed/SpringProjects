/**
 * 
 */
package com.mursil.service.model;

/**
 * Enum for representing different payment types for ticket. 
 * 
 * @author Mursil
 *
 */
public enum PaymentType {
	
	PUR ("PURCHASED"), //Ticket is purchased by the customer
	REF ("REFUND"), //Full Refund of Ticket. 
	PREF ("PARTIAL_REFUND"); // Partial Refund of Ticket
	
	private final String name; 
	
    private PaymentType(String s) {
        name = s;
    }
	
    public String value() {
        return name();
    }
    
    public String toString() {
        return this.name;
     }

    public static PaymentType fromValue(String v) {
        return valueOf(v);
    }

}
