package br.com.dojo.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.dojo.component.Player;
import br.com.dojo.util.DashBoard;
import junit.framework.TestCase;

public class AwardVictoryTest extends TestCase {

	public DashBoard dashBoard;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		dashBoard = new DashBoard();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRoman() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Awardlog.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[2]);
		assertEquals(player, dashBoard.getMatch().getReportAward().getPlayers().get(0));		
	}
	
	@Test
	public void testWithoutAward() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Awardlog-1.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[2]);
		assertTrue(dashBoard.getMatch().getReportAward().getPlayers().isEmpty());		
	}
	
	@Test
	public void testTwoAward() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Awardlog-2.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[2]);
		assertEquals("Roman e Winner", dashBoard.getMatch().getReportAward().getPlayers().size(), 2);		
	}
	
	@Test
	public void testTwoAwardRomanAndWinner() throws NumberFormatException, ParseException, IOException {
		Player roman = new Player();
		roman.setNickname("Roman");
		Player winner = new Player();
		winner.setNickname("Winner");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Awardlog-2.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[2]);
		for(Player player : dashBoard.getMatch().getReportAward().getPlayers()){
			assertTrue(player.equals(roman) || player.equals(winner));
		}
	}

}
