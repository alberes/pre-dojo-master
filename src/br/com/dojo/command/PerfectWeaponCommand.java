package br.com.dojo.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dojo.component.Action;
import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.report.ReportPerfectWeapon;

/**
 * Descobrir a arma preferida (a que mais matou) do vencedor
 * @author A.M.
 */
public class PerfectWeaponCommand implements Command {
	
	private List<ReportPerfectWeapon> reportPerfectWeapons = null;
	
	public PerfectWeaponCommand(){
		super();
	}
	/**
	 * 
	 * Descobrir a arma preferida (a que mais matou) do vencedor
	 * Em caso de empate sera utilizada a sequencia
	 */
	/**
	 * @see Command
	 */
	public void execute(Match match) {
		reportPerfectWeapons = match.getReportPerfectWeapons();
		List<ReportPerfectWeapon> weaponsListTmp = new ArrayList<ReportPerfectWeapon>();
		Map<String, ReportPerfectWeapon> weapons = new HashMap<String, ReportPerfectWeapon>();
		Player playerWinner = match.getPlayes().values().iterator().next();
		
		for (Player player : match.getPlayes().values()) {
			if(playerWinner.getKiller().size() > player.getKiller().size()){
				playerWinner = player;
			}else if(playerWinner.getKiller().size() == player.getKiller().size()
					&& playerWinner.getTargets().size() < player.getTargets().size()){
				playerWinner = player;
			}
		}
				
		for (Action action : playerWinner.getTargets()) {
			ReportPerfectWeapon report = weapons.get(action.getWeapon().getName());
			if (report == null) {
				report = new ReportPerfectWeapon();
				report.setNickname(playerWinner.getNickname());
				report.setWeapon(action.getWeapon());
				report.setQuantityUsed(report.getQuantityUsed() + 1);
				weapons.put(report.getWeapon().getName(), report);
			} else {
				report.setQuantityUsed(report.getQuantityUsed() + 1);
			}
		}
		
		// Identificar a arma perfeita
		for (ReportPerfectWeapon report : weapons.values()) {
			weaponsListTmp.add(report);
		}
		
		Collections.sort(weaponsListTmp);
		
		ReportPerfectWeapon report = weaponsListTmp.get(weaponsListTmp.size() - 1);
		for(int i = weaponsListTmp.size() - 1; i >= 0; i--){
			ReportPerfectWeapon r = weaponsListTmp.get(i);
			if(report.getQuantityUsed() == r.getQuantityUsed()){
				this.reportPerfectWeapons.add(r);
			}else{
				break;
			}
		}
	}

	/**
	 * @see Command
	 */
	public void print() {
		System.out.println("\nArma Perfeita");
		System.out.printf("%-15s \t %-15s \t %-15s", "Player", "Weapon", "Quantity");
		System.out.println("\n=========================================================");
		for(ReportPerfectWeapon reportPerfectWeapon: reportPerfectWeapons){
			System.out.printf("%-15s \t %-15s \t %8d\n", reportPerfectWeapon.getNickname(), reportPerfectWeapon.getWeapon().getName(), reportPerfectWeapon.getQuantityUsed());
		}
	}

}
