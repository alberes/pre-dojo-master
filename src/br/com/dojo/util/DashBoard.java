package br.com.dojo.util;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.dojo.command.Command;
import br.com.dojo.command.factory.FactoryCommand;
import br.com.dojo.component.Action;
import br.com.dojo.component.Match;
import br.com.dojo.component.Player;
import br.com.dojo.component.Weapon;

/**
 * Painel que apresenta as acoes do jogo
 * @author A.M.
 */
public class DashBoard {
	
	private Map<String, Match> matchs;
	
	private Match match;
	
	public static final String options[] = {"RankingCommand", "PerfectWeaponCommand", "AwardVictoryCommand", "AwardKillerCommand", "StreakCommand"};
		
	public DashBoard(){
		super();
		this.matchs = new HashMap<String, Match>();
	}
	
	/**
	 * Carrega na memoria a sequencia do(s) jogo(s).
	 * 
	 * @param logFile
	 * @throws ParseException
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void readLog(File logFile) throws ParseException, NumberFormatException, IOException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Player target = null;
		Player player = null;
		Action action = null;
		
		matchs.clear();
		
		BufferedReader bf = new BufferedReader(new FileReader(logFile));
		String log = null;
		
		try{
			while((log = bf.readLine()) != null){	
				String[] line = log.split(" ");
				if ("New".equals(line[3]) && "match".equals(line[4]) && "started".equals(line[7])) {
					match = new Match();
					match.setStartDate(df.parse(line[0] + " " + line[1]));
					match.setId(new Long(line[5]));
					matchs.put(match.getId().toString(), match);
				} else if ("Match".equals(line[3]) && "ended".equals(line[6])) {
					match.setFinishDate(df.parse(line[0] + " " + line[1]));
				} else {
					String nickname = line[3];
					//Acoes realizados pelo player <WORLD> devem ser desconsiderados.
					if(!"<WORLD>".equals(nickname)){
						player = match.getPlayes().get(nickname);
						if (player == null) {
							player = new Player();
							player.setNickname(line[3]);
		
							action = new Action();
							action.setTimeAction(df.parse(line[0] + " " + line[1]));
							action.setPlayer(player);
							action.setWeapon(new Weapon<String>(line[7]));
							player.getTargets().add(action);
		
							match.getPlayes().put(player.getNickname(), player);
						} else {
							action = new Action();
							action.setTimeAction(df.parse(line[0] + " " + line[1]));
							action.setPlayer(player);
							action.setWeapon(new Weapon<String>(line[7]));
							player.getTargets().add(action);
						}
		
						target = match.getPlayes().get(line[5]);
						if (target == null) {
							target = new Player();
							target.setNickname(line[5]);
							target.getKiller().add(player);					
							match.getPlayes().put(target.getNickname(), target);
						} else {
							target.getKiller().add(player);
						}
						action.setTarget(target);
					}
				}
			}
		}finally{
			bf.close();
		}
	}
	
	/**
	 * Apresenta 
	 * 1 - Rank
	 * 2 - Arma perfeita do ganhador
	 * 3 - Maior sequencia efetuado por um jogador (streak) sem morrer na partida
	 * 4 - Jogadores que venceram sem morrer (award)
	 * 5 - Jogadores que mataram 5 ou mais em menos de um minuto (award)
	 */
	public void show(){
		Set<String> idMatches = null;		
		String idMatch = null;
		Match match = null;
		
		
		
		idMatches = this.matchs.keySet();
		
		if(idMatches.isEmpty()){
			System.out.println("Nao foram encontrados combates");
		}else if(idMatches.size() == 1){
			idMatch = idMatches.iterator().next();
		}else{
			Console console = System.console();
			System.out.printf("Foram encontrados %d\n", idMatches.size());
			for(String id: idMatches){
				System.out.printf("ID: %s\n", id);
			}		
			idMatch = console.readLine("Digite o identificador do combate: ");
		}
		
		match = this.matchs.get(idMatch);
		
		if(match == null){
			System.out.printf("Nao foi encontrado o combate com id %s", idMatch);
		}else{
			//Executa todas as acoes da luta e apresenta na tela
			for(String option:DashBoard.options){
				this.show(option);
			}
		}
	}
	
	public void show(String option){
		Command command = FactoryCommand.getInstance().getCommand(option);
		command.execute(match);
		command.print();
	}
	
	public Match getMatch(){
		return this.match;
	}
	
	public static void main(String[] args) throws Exception {
		
		if(args.length == 0){
			throw new IllegalArgumentException("Nao foi passado o arquivo de log no parametro.");
		}
		
		File log = new File(args[0]);
		
		if(!log.isFile()){
			throw new IllegalArgumentException("Arquivo invalido e/ou nao encontrado.");
		}
		
		DashBoard dashBoard = new DashBoard();
		dashBoard.readLog(log);
		dashBoard.show();		
	}

}
