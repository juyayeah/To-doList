package board;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String tdText;
	private Date tdDate;
	
	public BoardVO(int bno, String tdText, Date tdDate) {
		this.bno = bno;
		this.tdText = tdText;
		this.tdDate = tdDate;
	}

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTdText() {
		return tdText;
	}

	public void setTdText(String tdText) {
		this.tdText = tdText;
	}

	public Date getTdDate() {
		return tdDate;
	}

	public void setTdDate(Date tdDate) {
		this.tdDate = tdDate;
	}
	
	
}
