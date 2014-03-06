package br.com.dojo.report;

import br.com.dojo.component.Weapon;

public class ReportPerfectWeapon implements Comparable<ReportPerfectWeapon>{
	
	private String nickname;
	
	private Weapon<String> weapon;
	
	private int quantityUsed;

	public ReportPerfectWeapon() {
		super();
	}

	public ReportPerfectWeapon(String nickname, Weapon<String> weapon, int quantityUsed) {
		super();
		this.nickname = nickname;
		this.weapon = weapon;
		this.quantityUsed = quantityUsed;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Weapon<String> getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon<String> weapon) {
		this.weapon = weapon;
	}

	public int getQuantityUsed() {
		return quantityUsed;
	}

	public void setQuantityUsed(int quantityUsed) {
		this.quantityUsed = quantityUsed;
	}

	@Override
	public String toString() {
		return "ReportPerfectWeapon [nickname=" + nickname + ", weapon="
				+ weapon + ", quantityUsed=" + quantityUsed + "]";
	}

	public int compareTo(ReportPerfectWeapon o) {
		return new Integer(this.quantityUsed).compareTo(new Integer(o.getQuantityUsed()));
	}
	
}
