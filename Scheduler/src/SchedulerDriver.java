
public class SchedulerDriver {
	public static void main(String[] args)  throws duplicateMeetingException {
		
		Calendar1 test = new Calendar1();
		Appt test1 = new Appt();
		Appt test2 = new Appt();
		Appt test3 = new Appt();
		test1.Months=1;
		test2.Months=1;
		test3.Months=1;
		test1.timeStart=4;
		test2.timeStart=5;
		test3.timeStart=1;

		
		
		test.AddMeeting(test3);
		test.AddMeeting(test2);
		test.AddMeeting(test1);
		
		test.apptSort();
	}

}
