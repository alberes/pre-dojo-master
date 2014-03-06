package br.com.dojo.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dojo.report.ReportAward;
import br.com.dojo.report.ReportAwardKiller;
import br.com.dojo.report.ReportPerfectWeapon;
import br.com.dojo.report.ReportRanking;
import br.com.dojo.report.ReportStreak;

/**
 * Classe que representa o jogo
 * @author A.M.
 */
public class Match {
	
	private Date startDate;
	
	private Long id;
	
	private Map<String, Player> playes;
	
	private Date finishDate;
	
	private List<ReportAwardKiller> reportAwardKillers;
	
	private ReportAward reportAward;
	
	private List<ReportPerfectWeapon> reportPerfectWeapons;

	private List<ReportRanking> reportRankings;
	
	private ReportStreak reportStreak;
	
	public Match() {
		super();
		this.playes = new HashMap<String,Player>();
		this.reportAwardKillers = new ArrayList<ReportAwardKiller>();
		this.reportAward = new ReportAward();
		this.reportPerfectWeapons = new ArrayList<ReportPerfectWeapon>();
		this.reportRankings = new ArrayList<ReportRanking>();
		this.reportStreak = new ReportStreak();
	}

	public Match(Date startDate, Long id, Date finishDate) {
		super();
		this.startDate = startDate;
		this.id = id;
		this.finishDate = finishDate;
	}

	/**
	 * Data de inicio do jogo
	 * @return Date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Data de inicio do jogo
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Identificador do jogo
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Identificador do jogo
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Jogadores que participaram do jogo
	 * @return playes
	 */
	public Map<String,Player> getPlayes() {
		return playes;
	}

	/**
	 * Data final do jogo
	 * @return finishDate
	 */
	public Date getFinishDate() {
		return finishDate;
	}

	/**
	 * Data final do jogo
	 * @param finishDate
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	public List<ReportAwardKiller> getReportAwardKillers() {
		return reportAwardKillers;
	}

	public ReportAward getReportAward() {
		return reportAward;
	}

	public List<ReportPerfectWeapon> getReportPerfectWeapons() {
		return reportPerfectWeapons;
	}

	public List<ReportRanking> getReportRankings() {
		return reportRankings;
	}

	public ReportStreak getReportStreak() {
		return reportStreak;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Match [startDate = " + startDate + ", id = " + id + ", finishDate = "
				+ finishDate + "]";
	}

}
