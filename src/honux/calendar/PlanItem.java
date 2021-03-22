/**
 * 
 */
package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String people = "";

	public static Date getDateFromString(String strDate) {
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
		this.planDate = getDateFromString(strDate);
		this.detail = detail;
	}
	
	public Date getPlanDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		people += name + ", ";
	}
}