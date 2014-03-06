package br.com.dojo.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.dojo.component.Player;
import br.com.dojo.util.DashBoard;

public class AwardKillerTest extends TestCase{

	public DashBoard dashBoard;
	
	@Before
	public void setUp() throws Exception {
		dashBoard = new DashBoard();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAwardKillerRoman() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/AwardKillerlog.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[3]);
		assertEquals(player, dashBoard.getMatch().getReportAwardKillers().get(0).getPlayer());
	}
	
	@Test
	public void testAwardKillerTwoSequence() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/AwardKillerlog-4.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[3]);
		assertEquals(player, dashBoard.getMatch().getReportAwardKillers().get(0).getPlayer());
	}
	
	@Test
	public void testAwardKiller60Seconds() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/AwardKillerlog-2.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[3]);
		assertEquals(player, dashBoard.getMatch().getReportAwardKillers().get(0).getPlayer());
	}
	
	@Test
	public void testAwardKillerWithout() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/AwardKillerlog-1.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[3]);
		assertTrue(dashBoard.getMatch().getReportAwardKillers().isEmpty());
	}
	
	@Test
	public void testAwardKillerWithout61Seconds() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/AwardKillerlog-3.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[3]);
		assertTrue(dashBoard.getMatch().getReportAwardKillers().isEmpty());
	}

}
