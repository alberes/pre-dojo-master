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

public class RankingTest extends TestCase{

	public DashBoard dashBoard;
	@Before
	public void setUp() throws Exception {
		dashBoard = new DashBoard();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatchNotNull() throws NumberFormatException, ParseException, IOException {
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/log.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[0]);
		assertNotNull(dashBoard.getMatch());
	}
	
	@Test
	public void testRankNotNull() throws NumberFormatException, ParseException, IOException {
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/log.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[0]);
		assertNotNull(dashBoard.getMatch().getReportRankings());
	}
	
	@Test
	public void testRankRoman() throws NumberFormatException, ParseException, IOException {
		Player player = new Player();
		player.setNickname("Roman");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/log.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[0]);
		assertEquals(player.getNickname(), dashBoard.getMatch().getReportRankings().get(0).getNickname());
	}

}
