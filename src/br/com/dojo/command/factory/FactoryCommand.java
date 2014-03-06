package br.com.dojo.command.factory;

import java.util.Properties;

import br.com.dojo.command.Command;

/**
 * Singleton para criar as instancias das classes derivadas do Command
 * @author A.M.
 */
public class FactoryCommand {
	
	private Properties mappings = null;
	
	private static FactoryCommand instance = null;
	
	private FactoryCommand(){
		mappings = new Properties();
		mappings.put("RankingCommand", "br.com.dojo.command.RankingCommand");	
		mappings.put("PerfectWeaponCommand", "br.com.dojo.command.PerfectWeaponCommand");
		mappings.put("AwardVictoryCommand", "br.com.dojo.command.AwardVictoryCommand");
		mappings.put("AwardKillerCommand", "br.com.dojo.command.AwardKillerCommand");
		mappings.put("StreakCommand", "br.com.dojo.command.StreakCommand");
	}
	
	public static FactoryCommand getInstance(){
		if(instance == null){
			synchronized (FactoryCommand.class) {
				if(instance == null){
					instance = new FactoryCommand();					
				}
			}
		}			
		return instance;
	}
	
	/**
	 * Caso nao seja encontrado sera retornado nulo.
	 * @param command
	 * @return
	 */
	public Command getCommand(String command) {
		Command cmd = null;
			try {
				cmd = (Command)Class.forName(this.mappings.getProperty(command)).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		return cmd;
	}
	

}
