import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JComboBox;

public class SchedulerWindow {
	private Calendar1 calendar = new Calendar1();
	private JFrame frame;
	private JLabel MonthLabel;
	private JLabel DayLabel;
	private JLabel TimeLabel;
	private JLabel DurationLabel;
	private JLabel TitleLabel;
	private JLabel lblScheduler;
	private JCheckBox AMchkbx;
	private JCheckBox PMchkbx;
	private Button EntrApptBttn;
	private Button RmvApptBttn;
	private Button VwApptsBttn;
	private JComboBox<String> DurationsList;
	private JComboBox<String> TimesList;
	private JComboBox<String> MonthsList;
	private JComboBox<String> DaysList;
	private String[] TimeOptionsArray = { null, "8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7" };
	private String[] DurationOptionsArray = { null, ".5", "1", "1.5", "2", "2.5", "3", "3.5", "4" };
	private String[] MonthOptionsArray = { null, "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	private String[] daysList = { null, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws duplicateMeetingException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedulerWindow window = new SchedulerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SchedulerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Create the labels for the frame
		 */
		lblScheduler = new JLabel("Scheduler");
		TitleLabel = new JLabel("Enter Info to Book or Remove an Appointment");
		MonthLabel = new JLabel("Month");
		DayLabel = new JLabel("Day");
		TimeLabel = new JLabel("Time");
		DurationLabel = new JLabel("Duration (in half hour increments)");
		/**
		 * Create the lists for the frame
		 */
		MonthsList = new JComboBox<String>(MonthOptionsArray);
		DaysList = new JComboBox<String>(daysList);
		TimesList = new JComboBox<String>(TimeOptionsArray);
		DurationsList = new JComboBox<String>(DurationOptionsArray);
		/**
		 * Create the check boxes for the frame
		 */
		AMchkbx = new JCheckBox("AM");
		PMchkbx = new JCheckBox("PM");
		/**
		 * Create Enter Appointment button, and action listener
		 */
		EntrApptBttn = new Button("Enter Appointment");
		EntrApptBttn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (DaysList.getSelectedItem() == null || TimesList.getSelectedItem() == null
						|| DurationsList.getSelectedItem() == null || MonthsList.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Missing field(s)");
					return;
				}
				if (AMchkbx.isSelected() && PMchkbx.isSelected()) {
					JOptionPane.showMessageDialog(null, "Select AM or PM, not both");
					return;
				}
				if (!AMchkbx.isSelected() && !PMchkbx.isSelected()) {
					JOptionPane.showMessageDialog(null, "Missing field(s)");
					return;
				}
				String AMPM = "PM";
				if (AMchkbx.isSelected()) {
					AMPM = "AM";
				}
				int numDays = Integer.parseInt((String) DaysList.getSelectedItem());
				int time = Integer.parseInt((String) TimesList.getSelectedItem());
				double dur = Double.parseDouble((String) DurationsList.getSelectedItem());
				Appt Appt1 = new Appt(AMPM, MonthsList.getSelectedIndex(), numDays, time, dur);

				try {
					calendar.AddMeeting(Appt1);
				} catch (duplicateMeetingException e) {
					JOptionPane.showMessageDialog(null, "Meeting already exists!");
					return;

				}

				JOptionPane.showMessageDialog(null, "You scheduled your meeting for " + MonthsList.getSelectedItem()
						+ " " + numDays + ", at " + time + AMPM + " for " + dur + " hours");

			}
		});

		/**
		 * Create Remove Appointment button, and action listener
		 */
		RmvApptBttn = new Button("Remove Appointment");
		RmvApptBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DaysList.getSelectedItem() == null || TimesList.getSelectedItem() == null
						|| DurationsList.getSelectedItem() == null || MonthsList.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Missing field!");
					return;
				}
				if (AMchkbx.isSelected() && PMchkbx.isSelected()) {
					JOptionPane.showMessageDialog(null, "Select AM or PM, not both");
					return;
				}
				if (!AMchkbx.isSelected() && !PMchkbx.isSelected()) {
					JOptionPane.showMessageDialog(null, "Missing field!");
					return;
				}
				String AMPM = "PM";
				if (AMchkbx.isSelected()) {
					AMPM = "AM";
				}
				int numDays = Integer.parseInt((String) DaysList.getSelectedItem());
				int time = Integer.parseInt((String) TimesList.getSelectedItem());
				double dur = Double.parseDouble((String) DurationsList.getSelectedItem());
				Appt Appt1 = new Appt(AMPM, MonthsList.getSelectedIndex(), numDays, time, dur);

				try {
					calendar.RemoveMeeting(Appt1);
				} catch (EmptyListException e) {
					JOptionPane.showMessageDialog(null, "Meeting doesn't exist!");
					return;
				}

				JOptionPane.showMessageDialog(null, "You removed your meeting for " + MonthsList.getSelectedItem() + " "
						+ numDays + ", at " + time + AMPM + " for " + dur + " hours");
			}
		});

		/**
		 * Create Display Appointments button, and action listener
		 */
		VwApptsBttn = new Button("View All Appointments");
		VwApptsBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (calendar.meetings.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No meetings scheduled");
					return;
				}
				displayAppts(calendar);
			}
		});

		/**
		 * Create the frame and add all labels, lists, check boxes, and buttons
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new MigLayout("", "[44px][][30px,grow][6px][6px][][][6px][6px][59px]", "[23px][][][][][][][][][grow]"));
		frame.getContentPane().add(lblScheduler, "cell 0 0 2 1,growx,aligny center");
		frame.getContentPane().add(TitleLabel, "flowx,cell 2 0 8 1,alignx center");
		frame.getContentPane().add(MonthLabel, "cell 0 1,alignx left,aligny center");
		frame.getContentPane().add(DayLabel, "cell 0 2");
		frame.getContentPane().add(TimeLabel, "cell 0 3");
		frame.getContentPane().add(DurationLabel, "cell 0 4");
		frame.getContentPane().add(MonthsList, "cell 2 1");
		frame.getContentPane().add(DaysList, "cell 2 2,growx");
		frame.getContentPane().add(TimesList, "cell 2 3,growx");
		frame.getContentPane().add(DurationsList, "cell 2 4,growx");
		frame.getContentPane().add(AMchkbx, "cell 5 3");
		frame.getContentPane().add(PMchkbx, "cell 6 3");
		frame.getContentPane().add(EntrApptBttn, "flowx,cell 0 6 10 1,grow");
		frame.getContentPane().add(RmvApptBttn, "cell 0 7 10 1,growx");
		frame.getContentPane().add(VwApptsBttn, "cell 0 8 10 1,grow");
	}

	/**
	 * Method to display all appointments in a new frame
	 */
	public static void displayAppts(Calendar1 calendar) {
		calendar.apptSort();
		List list1 = new List();
		JFrame frame = new JFrame("Appointments");
		for (Appt item : calendar.meetings) {
			list1.add("Appointment Scheduled: " + item.toString());
		}
		list1.setBackground(Color.lightGray);
		frame.add(list1);
		frame.pack();
		frame.setVisible(true);
	}

}
