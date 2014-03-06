package br.com.dojo.report;

public class ReportRanking implements Comparable<ReportRanking>{
	
	private String nickname;
	
	private Integer total;
	
	private Integer death;
	
	public ReportRanking() {
		super();
	}

	public ReportRanking(String nickname, Integer total, Integer death) {
		super();
		this.nickname = nickname;
		this.total = total;
		this.death = death;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getDeath() {
		return death;
	}

	public void setDeath(Integer death) {
		this.death = death;
	}

	public int compareTo(ReportRanking o) {
		return this.death.compareTo(o.getDeath());
	}

	@Override
	public String toString() {
		return "ReportResume [nickname=" + nickname + ", total=" + total
				+ ", death=" + death + "]";
	}

}
