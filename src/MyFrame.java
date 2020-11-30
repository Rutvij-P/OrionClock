import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	
	Calendar calender;						// We will be using a-lot of Calendar for our a little clock
	SimpleDateFormat tformat;				// Used for setting the time	
	SimpleDateFormat horizonformat;			// Used for setting the day
	SimpleDateFormat dateformat;			// Used for setting date
	JLabel tlabel;							// Used for the settings of time layout
	JLabel horizonlabel;					// Used for the settings of day layout
	JLabel datelabel;						// Used for the settings of date layout
	String horizon;							// Used as variable to store and display as
	String date;							// Used as variable to store and display as
	String t;								// Used as variable to store and display as
	String quote;							// Used as variable to store and display as
	/*
	 * This will act as our main decisive parameters to integrate the vision of clock to a java program.
	 * We will be setting our time to show precise seconds that will follow real-time system.
	 * Then we will use a catch block to try and keep our seconds to follow up with our real-time.
	 * */
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 			
		this.setTitle("Orion Clock Program");				// Sets title
		this.setLayout(new FlowLayout());					// Sets the way of layout
		this.setSize(350,200);								// Sets the length and width of parameters
		this.setResizable(false);							// Disabling the feature to resize for now

		tformat = new SimpleDateFormat("hh:mm:ss a");			// Basic structure on how to display time precisely
		horizonformat = new SimpleDateFormat("EEEE");			// Structure format on displaying the day
		dateformat = new SimpleDateFormat("MMMMM dd, yyyy");	// Basic structure on how to display the date 
		
		tlabel = new JLabel();
		tlabel.setFont(new Font("Verdana",Font.PLAIN,45));		// Setting font in my Clock
		tlabel.setForeground(new Color(0xFFFF00));				// Setting foreground color
		tlabel.setBackground(new Color(0x9900FF));				// Setting background color
		tlabel.setOpaque(true);
		
		horizonlabel = new JLabel();
		horizonlabel.setFont(new Font("TimesRoman",Font.BOLD,30));		// Setting font for my display for day	
		horizonlabel.setForeground(new Color(0xFFFF00));				// Setting foreground color
		horizonlabel.setBackground(new Color(0x9900FF));				// Setting background color
		horizonlabel.setOpaque(true);
	
		
		datelabel = new JLabel();
		datelabel.setFont(new Font("TimesRoman",Font.BOLD,25));			// Setting font for my display of date
		datelabel.setForeground(new Color(0xFFFF00));					// Setting foreground color
		datelabel.setBackground(new Color(0x9900FF));					// Setting background
		datelabel.setOpaque(true);
		
		this.add(tlabel);			// This adds our time to the panel of display
		this.add(horizonlabel);		// This adds our day to the panel of display
		this.add(datelabel);		// This adds our date to the panel of display
		this.setVisible(true);		// This will display all the previous added display options on our Layout

		setTime();
	}
	
	public void setTime() {
		t = tformat.format(Calendar.getInstance().getTime());					// This will use Calendar import to get the real-time data about the time from your device
		tlabel.setText(t);
		horizon = horizonformat.format(Calendar.getInstance().getTime());		// This will use the Calendar to access the present day from your device
		horizonlabel.setText(horizon);
		date = dateformat.format(Calendar.getInstance().getTime());				// This will use the Calendar import to access the present date from your device
		datelabel.setText(date);

		try {
			Thread.sleep(1000);								// This will refresh the thread at 1000 millisecond to constantly keep our second clock ticking
		} catch (InterruptedException e) {					// Surrounded my previous statement with a try and catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
