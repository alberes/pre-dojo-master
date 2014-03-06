package br.com.dojo.report;

import java.util.ArrayList;
import java.util.List;

import br.com.dojo.component.Action;
import br.com.dojo.component.Player;

public class ReportStreak {
	
	private Player player;
	
	private List<Action> targets;

	public ReportStreak() {
		super();
		this.targets = new ArrayList<Action>();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Action> getTargets() {
		return targets;
	}

	public void setTargets(List<Action> targets) {
		this.targets = targets;
	}	

}
