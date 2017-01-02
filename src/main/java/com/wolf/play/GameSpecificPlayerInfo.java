package com.wolf.play;

import java.util.UUID;

public class GameSpecificPlayerInfo {

	UUID actionTarget;
	
	Boolean Living;
	
	Boolean isVampire;
	
	Boolean isSeer;

	public UUID getActionTarget() {
		return actionTarget;
	}

	public void setActionTarget(UUID actionTarget) {
		this.actionTarget = actionTarget;
	}

	public Boolean getLiving() {
		return Living;
	}

	public void setLiving(Boolean living) {
		Living = living;
	}

	public Boolean getIsVampire() {
		return isVampire;
	}

	public void setIsVampire(Boolean isVampire) {
		this.isVampire = isVampire;
	}

	public Boolean getIsSeer() {
		return isSeer;
	}

	public void setIsSeer(Boolean isSeer) {
		this.isSeer = isSeer;
	}
}
