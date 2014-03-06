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

public class StreakTest extends TestCase {

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
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Streaklog.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[4]);
		assertEquals(player, dashBoard.getMatch().getReportStreak().getPlayer());	
	}
	
	@Test
	public void testRoman2() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Streaklog-3.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[4]);
		assertEquals(player, dashBoard.getMatch().getReportStreak().getPlayer());	
	}
	
	@Test
	public void testRomanAndWinner() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Winner");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Streaklog-2.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[4]);
		assertEquals(player, dashBoard.getMatch().getReportStreak().getPlayer());	
	}
	
	@Test
	public void testRomanWonWinner() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/Streaklog-4.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[4]);
		assertEquals(player, dashBoard.getMatch().getReportStreak().getPlayer());	
	}

}
