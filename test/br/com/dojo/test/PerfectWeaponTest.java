package br.com.dojo.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.dojo.component.Weapon;
import br.com.dojo.report.ReportPerfectWeapon;
import br.com.dojo.util.DashBoard;

public class PerfectWeaponTest extends TestCase{

	public DashBoard dashBoard;
	
	@Before
	public void setUp() throws Exception {
		dashBoard = new DashBoard();
	}


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPerfectWeaponM16() throws NumberFormatException, ParseException, IOException {
		Weapon<String> weapon = new Weapon<String>();
		weapon.setName("M16");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/PerfectWeaponlog.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[1]);
		assertEquals(weapon, dashBoard.getMatch().getReportPerfectWeapons().get(0).getWeapon());
	}
	
	@Test
	public void testPerfectWeaponQuantityM16AK15() throws NumberFormatException, ParseException, IOException {
		Weapon<String> weapon = new Weapon<String>();
		weapon.setName("M16");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/PerfectWeaponlog-1.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[1]);
		assertEquals("M16 e AK15 ", dashBoard.getMatch().getReportPerfectWeapons().size(), 2);
	}
	
	@Test
	public void testPerfectWeaponListM16AK15() throws NumberFormatException, ParseException, IOException {
		Weapon<String> m16 = new Weapon<String>();
		m16.setName("M16");
		Weapon<String> ak15 = new Weapon<String>();
		ak15.setName("AK15");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/PerfectWeaponlog-1.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[1]);
		for(ReportPerfectWeapon reportPerfectWeapon:dashBoard.getMatch().getReportPerfectWeapons()){			
			assertTrue(reportPerfectWeapon.getWeapon().equals(m16) ||
					reportPerfectWeapon.getWeapon().equals(ak15));
		}
	}
	
	@Test
	public void testPerfectWeaponTwoTimesM16() throws NumberFormatException, ParseException, IOException {
		Weapon<String> weapon = new Weapon<String>();
		weapon.setName("M16");
		File log = new File("/home/afng/workspace-pre-dojo-master/arquivos/logs/test/PerfectWeaponlog-2.txt");
		dashBoard.readLog(log);
		dashBoard.show(DashBoard.options[1]);
		assertEquals(weapon, dashBoard.getMatch().getReportPerfectWeapons().get(0).getWeapon());
	}

}
