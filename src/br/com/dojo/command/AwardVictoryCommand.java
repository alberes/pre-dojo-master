package br.com.dojo.command;

import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.report.ReportAward;

/**
 * Jogadores que vencerem uma partida sem morrerem devem ganhar um "award"
 * @author A.M.
 */
public class AwardVictoryCommand implements Command {

	private ReportAward reportAward = null;
	
	public AwardVictoryCommand(){
		super();
	}
	
	/**
	 * @see Command
	 */
	public void execute(Match match) {
		reportAward = match.getReportAward();
		for (Player player : match.getPlayes().values()) {
			if (player.getKiller().size() == 0) {
				reportAward.getPlayers().add(player);
			}
		}
	}

	/**
	 * @see Command
	 */
	public void print() {
		System.out.println("\nAWARD - Ganhou a partida sem morrer");
		System.out.printf("%-15s", "Player");
		System.out.println("\n=========================================================");
		for(Player player:reportAward.getPlayers()){
			System.out.println(player.getNickname());
		}
		if(reportAward.getPlayers().isEmpty()){
			System.out.println("Nao houve jogador(es) que ganhou a partidade sem morrer.");
		}
	}	

}
