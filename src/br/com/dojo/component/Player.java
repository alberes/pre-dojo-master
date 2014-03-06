package br.com.dojo.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Jogador do jogo
 * @author afng
 *
 */
public class Player {
	
	private String nickname;
	
	private List<Action> targets;
	
	private List<Player> killer;
	
	public Player(){
		super();
		this.killer = new ArrayList<Player>();
	}

	/**
	 * Nome que identifica do jogador
	 * @return
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Nome que identifica o jogador
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Alvos atingidos do jogador
	 * @return targets
	 */
	public List<Action> getTargets() {
		if(this.targets == null){
			this.targets = new ArrayList<Action>();
		}
		return targets;
	}

	/**
	 * Alvos atingidos do jogador
	 * @param targets
	 */
	public void setTargets(List<Action> targets) {
		this.targets = targets;
	}	

	/**
	 * Jogadores que mataram o jogador
	 * @return killer
	 */
	public List<Player> getKiller() {
		return killer;
	}

	/**
	 * Jogadores que mataram o jogador
	 * @param killer
	 */
	public void setKiller(List<Player> killer) {
		this.killer = killer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [nickname = " + nickname + "]";
	}

	

}