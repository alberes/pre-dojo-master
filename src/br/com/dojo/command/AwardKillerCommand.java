package br.com.dojo.command;

import java.util.Date;
import java.util.List;

import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.report.ReportAwardKiller;

/**
 * Jogadores que matarem 5 vezes em 1 minuto devem ganhar um "award"
 * @author A.M
 *
 */
public class AwardKillerCommand implements Command {
	
	List<ReportAwardKiller>  reportAwardKillers;
	
	public AwardKillerCommand(){
		super();
	}
	
	/**
	 * @see Command
	 */
	public void execute(Match match) {
		reportAwardKillers = match.getReportAwardKillers();
		// Navegar por todos os competidores
		for (Player player : match.getPlayes().values()) {
			// Caso tenha mais de 4 acoes verificar se existe
			if (player.getTargets().size() > 4) {
				// Verificar se existe 5 acoes com menos de 1 minuto
				// Acao corrente
				for (int i = 0; i < player.getTargets().size(); i++) {
					Date datePrevious = player.getTargets().get(i).getTimeAction();
					//Controle para verificar a sequencia de alvos em menos de 1 minuto
					//Comeca com 1 que e a data comparada com as demais
					int count = 1;
					// Proximas acoes para calcular o intervalos com as proximas
					// datas
					for (int j = i + 1; j < player.getTargets().size(); j++) {
						Date dateNext = player.getTargets().get(j).getTimeAction();
						// Calculo da data anterior com a proxima data
						long time = (dateNext.getTime() - datePrevious.getTime()) / 1000;
						if (time <= 60) {
							++count;
						}else {
							break;
						}
					}
					
					if(count > 4){
						// Jogador com 5 ou mais em menos de 1 minuto
						ReportAwardKiller reportKillerWard = new ReportAwardKiller();
						reportKillerWard.setPlayer(player);
						reportAwardKillers.add(reportKillerWard);
						break;
					}
				}
			}
		}
	}

	/**
	 * @see Command
	 */
	public void print() {
		System.out.println("\n\nAWARD KILLER");
		System.out.printf("%-15s", "Player");
		System.out.println("\n=========================================================");
		for(ReportAwardKiller report: reportAwardKillers){
			System.out.printf("%-15s\n", report.getPlayer().getNickname());
		}
		if(reportAwardKillers.size() == 0){
			System.out.println("Nao houve AWARD KILLER na partida.");
		}
	}

}
