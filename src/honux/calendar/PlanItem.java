package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	private Date planDate;
	private String detail;
	private String people = "";

	public static Date getDateOrNullFromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 생성 중 오류가 발생했습니다.");
		}
		return date;
	}
	
	/**
	 * @param planDate
	 * @param detail
	 */
	public PlanItem(String strDate, String detail) {
		this.planDate = getDateOrNullFromString(strDate);
		this.detail = detail;
	}
	
	
	/**
	 * @return the plandDate
	 */
	public Date getPlanDate() {
		return planDate;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void addPeople(String name) {
		people += name + ", ";
	}

	/**
	 * @return
	 */
	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate + "," + "\"" + detail + "\"" + "\n";
	}
}