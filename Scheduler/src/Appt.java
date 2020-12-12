
public class Appt {

	String AMorPM;
	int Months;
	int Days;
	int timeStart;
	double duration;

	public Appt() {
		this.AMorPM = "";
		this.Months = 0;
		this.Days = 0;
		this.timeStart = 0;
		this.duration = 0;
	}

	public Appt(String AmPM, int month, int days, int time, double duration) {
		this.AMorPM = AmPM;
		this.Months = month;
		this.Days = days;
		this.timeStart = time;
		this.duration = duration;

	}

	/**
	 * @return the aMorPM
	 */
	public String getAMorPM() {
		return AMorPM;
	}

	/**
	 * @param aMorPM the aMorPM to set
	 */
	public void setAMorPM(String aMorPM) {
		AMorPM = aMorPM;
	}

	/**
	 * @return the months
	 */
	public int getMonths() {
		return Months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(int months) {
		Months = months;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return Days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		Days = days;
	}

	/**
	 * @return the timeStart
	 */
	public int getTimeStart() {
		return timeStart;
	}

	/**
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		String mntTxt = null;
		switch (Months) {
		case 1:
			mntTxt = "January";
			break;
		case 2:
			mntTxt = "February";
			break;
		case 3:
			mntTxt = "March";
			break;
		case 4:
			mntTxt = "April";
			break;
		case 5:
			mntTxt = "May";
			break;
		case 6:
			mntTxt = "June";
			break;
		case 7:
			mntTxt = "July";
			break;
		case 8:
			mntTxt = "August";
			break;
		case 9:
			mntTxt = "September";
			break;
		case 10:
			mntTxt = "October";
			break;
		case 11:
			mntTxt = "November";
			break;
		case 12:
			mntTxt = "December";
			break;
		}
		String daysSuff=null;
		if (Days >= 11 && Days <= 13) {
	        daysSuff = "th";
	    }
	    switch (Days % 10) {
	        case 1:  daysSuff = "st";
	        case 2:  daysSuff = "nd";
	        case 3:  daysSuff = "rd";
	        default: daysSuff = "th";
	    }

		return mntTxt + " " + Days + daysSuff + "\t" + " at " +  timeStart + AMorPM + "\t" + " for "
				+ duration + " hours";
	}

}
