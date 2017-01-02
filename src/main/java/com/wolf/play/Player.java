package com.wolf.play;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wolf.play.enums.Gender;

@Document(collection = "player")
public class Player {
	
	private UUID uuid;

	private String address;
	
	private String number;
	
	private String name;
	
	private Gender gender;
	
	private Password password;
	
	private List<Notification> notifications;

	public List<Notification> getNotifications() {
		return notifications;
	}
	
	public void addNotification(Notification notification){
		this.notifications.add(notification);
	}
	
	public void addAllNotifications(List<Notification> notifications){
		this.notifications.addAll(notifications);
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
}
