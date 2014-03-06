package br.com.dojo.command;

import java.util.Collections;
import java.util.List;

import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.report.ReportRanking;

/**
 * ranking de cada partida, com a quantidade assassinatos e a quantidade de mortes de cada jogador
 * @author A.M.
 */
public class RankingCommand implements Command {

	private List<ReportRanking> reportRankings = null;
	
	public RankingCommand(){
		super();
	}
	
	/**
	 * @see Command
	 */
	public void execute(Match match) {
		reportRankings = match.getReportRankings();
		for (Player player : match.getPlayes().values()) {			
			ReportRanking resume = new ReportRanking(player.getNickname(), player.getTargets().size(), player.getKiller().size());
			reportRankings.add(resume);
		}		
		Collections.sort(reportRankings);
	}

	/**
	 * @see Command
	 */
	public void print() {
		System.out.println("\nRanking");
		System.out.printf("%-15s \t %-15s \t %-15s", "Player", "Target", "Death");
		System.out.println("\n=========================================================");
		for(ReportRanking ranking: reportRankings){
			System.out.printf("%-15s \t %6d \t %13d\n", ranking.getNickname(), ranking.getTotal(), ranking.getDeath());
		}		
	}
	
	

}
