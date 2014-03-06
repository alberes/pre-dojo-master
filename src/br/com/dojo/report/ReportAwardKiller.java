package br.com.dojo.report;

import br.com.dojo.component.Player;

public class ReportAwardKiller{
	
	private Player player;

	public ReportAwardKiller() {
		super();
	}

	public ReportAwardKiller(Player player) {
		this();
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
