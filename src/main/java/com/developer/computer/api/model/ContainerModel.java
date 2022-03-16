package com.developer.computer.api.model;

import javax.validation.constraints.Size;

public class ContainerModel {

	@Size(min=5, max= 20,message="origin cannot be less than 5 and more than 20 characters.")
	private String origin;
	
	@Size(min=5, max= 20,message="destination cannot be less than 5 and more than 20 characters.")
	private String destination;
	private int containerSize;
	
	@Size(min=1, max= 100,message="quantity cannot be less than 1 and more than 100 characters.")
	private int quantity;
	private Container ContainerType;
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Container getContainerType() {
		return ContainerType;
	}
	public void setContainerType(Container containerType) {
		ContainerType = containerType;
	}
}
