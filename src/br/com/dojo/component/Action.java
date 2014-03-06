package br.com.dojo.component;

import java.util.Date;

/**
 * Acoes executadas do jogo
 * @author A.M.
 */
public class Action implements Comparable<Action>{
	
	private Date timeAction;
	
	private Player player;
	
	private Player target;
	
	private Weapon<String> weapon;

	public Action() {
		super();
	}

	public Date getTimeAction() {
		return timeAction;
	}

	public void setTimeAction(Date timeAction) {
		this.timeAction = timeAction;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	public Weapon<String> getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon<String> weapon) {
		this.weapon = weapon;
	}

	public int compareTo(Action o) {
		return this.timeAction.compareTo(o.getTimeAction());
	}

	@Override
	public String toString() {
		return "Action [timeAction=" + timeAction + ", player=" + player
				+ ", target=" + target + ", weapon=" + weapon + "]";
	}

}
