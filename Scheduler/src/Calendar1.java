import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Calendar1 {

	ArrayList<Appt> meetings;

	public Calendar1() {
		meetings = new ArrayList<Appt>();
	}

	public void AddMeeting(Appt meeting) throws duplicateMeetingException {
		if (this.meetings.isEmpty()) {
			this.meetings.add(meeting);
			return;
		}
		for (int i = 0; i < this.meetings.size(); i++) {
			if (meeting.Months == this.meetings.get(i).getMonths()) {
				for (int b = 0; b < this.meetings.size(); b++) {
					if (meeting.Days == this.meetings.get(b).getDays()) {
						for (int e = 0; e < this.meetings.size(); e++) {
							if (meeting.timeStart == this.meetings.get(e).getTimeStart()) {
								for (int m = 0; m < this.meetings.size(); m++) {
									if (meeting.AMorPM.equals(this.meetings.get(e).getAMorPM())) {
										throw new duplicateMeetingException();
									}
								}
							}
						}
					}
				}

			}
		}

		this.meetings.add(meeting);
	}

	public void RemoveMeeting(Appt meeting) throws EmptyListException {

		if (this.meetings.isEmpty()) {
			throw new EmptyListException();
		}

		for (int i = 0; i < this.meetings.size(); i++) {
			if (meeting.Months == this.meetings.get(i).getMonths()) {
				for (int b = 0; b < this.meetings.size(); b++) {
					if (meeting.Days == this.meetings.get(b).getDays()) {
						for (int e = 0; e < this.meetings.size(); e++) {
							if (meeting.timeStart == this.meetings.get(e).getTimeStart()) {
								for (int m = 0; m < this.meetings.size(); m++) {
									if (meeting.AMorPM.equals(this.meetings.get(e).getAMorPM())) {
										this.meetings.remove(e);
										return;
									}
								}

							}
						}

					}
				}
			}
		}
		throw new EmptyListException();
	}

	public String toString() {
		return meetings.toString();
	}

	public void apptSort() {
		{
			Collections.sort(this.meetings, Comparator.comparing(Appt::getMonths).thenComparing(Appt::getDays)
					.thenComparing(Appt::getTimeStart));
		}

//			int n = this.meetings.size();
//			for (int i = 0; i < n - 1; i++)
//				for (int j = 0; j < n - i - 1; j++)
//					if (this.meetings.get(j).getMonths() > this.meetings.get(j + 1).getMonths()) {
//						Appt temp = this.meetings.get(j);
//						this.meetings.set(j, this.meetings.get(j + 1));
//						this.meetings.set(j + 1, temp);
//					}
//		}

	}

}
