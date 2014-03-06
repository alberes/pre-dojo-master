package br.com.dojo.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.dojo.component.Action;
import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.report.ReportStreak;

/**
 * Identificar a maior sequência de assassinatos efetuadas por
 * um jogador (streak) sem morrer, dentro da partida;
 * Criterio de desempate sera a primeira sequencia executada
 * @author A.M.
 */
public class StreakCommand implements Command {

	private ReportStreak reportStreak = null;
	
	public StreakCommand(){
		super();
	}
	
	/**
	 * @see Command
	 */
	public void execute(Match match) {
		reportStreak = match.getReportStreak();
		List<Action> actions = new ArrayList<Action>();
		Player playerKiller = null;
		int count, position, positionEnd, quantity = 0, j;
		position = 0;
		positionEnd = 0;
				
		for(Player player: match.getPlayes().values()){
			actions.addAll(player.getTargets());
		}
		
		//Ordena pela data da acao executada no jogo
		Collections.sort(actions);		
		
		for(int i = 0; i < actions.size(); i++){
			Action action = actions.get(i);
			playerKiller = action.getPlayer();			
			count = 0;
			for(j = i; j < actions.size(); j++){
				if(playerKiller.equals(actions.get(j).getPlayer())){
					count++;
				}else{
					i = --j;
					break;
				}
			}
			if(count > quantity){
				quantity = count;
				position = i;
				positionEnd = i + quantity - 1;
			}
			
		}
		
		reportStreak.setPlayer(actions.get(position).getPlayer());
		for(int i = position; i <= positionEnd; i++){
			reportStreak.getTargets().add(actions.get(i));
		}
	}

	/**
	 * @see Command
	 */
	public void print() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.out.println("\nStreak - Maior sequencia na partida sem morrer");
		System.out.printf("%s matou", reportStreak.getPlayer().getNickname());
		System.out.println("\n======================================================");
		System.out.printf("%-15s \t %-15s \t %-15s\n", "Date", "Target", "Weapon");
		for(Action action: reportStreak.getTargets()){
			System.out.printf("%s \t %4s \t %19s\n", df.format(action.getTimeAction()), action.getTarget().getNickname(),
					action.getWeapon().getName());
		}
	}

}
