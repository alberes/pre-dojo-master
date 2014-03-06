package br.com.dojo.report;

import java.util.ArrayList;
import java.util.List;

import br.com.dojo.component.Player;

public class ReportAward{
	
	private List<Player> players;

	public ReportAward() {
		super();
		this.players = new ArrayList<Player>();
	}

	public List<Player> getPlayers() {
		return players;
	}

}
