package br.com.dojo.command;

import br.com.dojo.component.Match;

/** 
 * Resume a execucao do jogo
 * @author A.M.
 *
 */
public interface Command {
	
	/**
	 * Indentifica execucao do jogo
	 * @param match
	 */
	public void execute(Match match);
	
	/**
	 * Imprime o resumo da execucao do jogo
	 */
	public void print();

}
