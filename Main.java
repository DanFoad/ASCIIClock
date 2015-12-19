/**
 * Displays an ASCII clock representation of the current time
 * @author Dan Foad
 * @version 0.0.1
 */

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask {
	
	/**
	 * Whether colon between numbers is currently visible
	 */
	public boolean colonFlash = false;
	
	/**
	 * Gets run every n seconds as defined by a Timer object
	 */
	@Override
	public void run() {
		LocalTime time = LocalTime.now(); // Get current time
		
		// Print out current time as ASCII representation
		printTime(time.getHour(), time.getMinute(), time.getSecond());
		
	}
	
	/**
	 * Prints an ASCII representation of the current time
	 * @param hour	int to hold current hour
	 * @param min	int to hold current minute
	 * @param sec	int to hold current second
	 */
	public void printTime(int hour, int min, int sec) {
		String colon[] = new String[7]; // Colon representation
			
		if (colonFlash) { // If colon should be visible
			colon[0] = "  ";
			colon[1] = "88";
			colon[2] = "88";
			colon[3] = "  ";
			colon[4] = "88";
			colon[5] = "88";
			colon[6] = "  ";
		} else { // If colon should be invisible
			colon[0] = "  ";
			colon[1] = "  ";
			colon[2] = "  ";
			colon[3] = "  ";
			colon[4] = "  ";
			colon[5] = "  ";
			colon[6] = "  ";
		}
		
		colonFlash = !colonFlash; // Toggle colonFlash every refresh cycle
		
		// Variables to hold digit representations
		String hour1[], hour2[], min1[], min2[], sec1[], sec2[];
		
		// Convert each digit to ASCII representation
		hour2 = digitToASCII(hour % 10); // Mod10 gets last digit only
		hour1 = digitToASCII(hour / 10); // Div10 gets second+ digits
		
		min2 = digitToASCII(min % 10);
		min1 = digitToASCII(min / 10);
		
		sec2 = digitToASCII(sec % 10);
		sec1 = digitToASCII(sec / 10);
		
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"); // Clear-screen hack
		
		// Print out representation line-by-line
		for (int i = 0; i < colon.length; i++) {
			System.out.println(hour1[i] + "  " + hour2[i] + "  " + colon[i] + "  " + min1[i] + "  " + min2[i] + "  " + colon[i] + "  " + sec1[i] + "  " + sec2[i]);
		}
	}
	
	/**
	 * Convert single digit to ASCII representation
	 * @param digit	int to convert to representation
	 * @return String[] holding ASCII representation
	 */
	public String[] digitToASCII(int digit) {
		String rep[] = new String[7]; // Digit representation as String array
		
		// Convert each digit to its ASCII representation
		switch(digit) {
			case 0:
				rep[0] = " 88888 ";
				rep[1] = "88   88";
				rep[2] = "88   88";
				rep[3] = "88   88";
				rep[4] = "88   88";
				rep[5] = "88   88";
				rep[6] = " 88888 ";
				break;
			case 1:
				rep[0] = "     88";
				rep[1] = "    888";
				rep[2] = "     88";
				rep[3] = "     88";
				rep[4] = "     88";
				rep[5] = "     88";
				rep[6] = "     88";
				break;
			case 2:
				rep[0] = " 88888 ";
				rep[1] = "88   88";
				rep[2] = "     88";
				rep[3] = "   88  ";
				rep[4] = "  88   ";
				rep[5] = " 88    ";
				rep[6] = "8888888";
				break;
			case 3:
				rep[0] = " 88888 ";
				rep[1] = "88   88";
				rep[2] = "     88";
				rep[3] = "   88  ";
				rep[4] = "    88 ";
				rep[5] = "88   88";
				rep[6] = " 88888 ";
				break;
			case 4:
				rep[0] = "88   88";
				rep[1] = "88   88";
				rep[2] = "88   88";
				rep[3] = "8888888";
				rep[4] = "     88";
				rep[5] = "     88";
				rep[6] = "     88";
				break;
			case 5:
				rep[0] = "8888888";
				rep[1] = "88     ";
				rep[2] = "88     ";
				rep[3] = "888888 ";
				rep[4] = "     88";
				rep[5] = "     88";
				rep[6] = "888888 ";
				break;
			case 6:
				rep[0] = "  8888 ";
				rep[1] = " 88    ";
				rep[2] = "88     ";
				rep[3] = "888888 ";
				rep[4] = "88   88";
				rep[5] = "88   88";
				rep[6] = " 88888 ";
				break;
			case 7:
				rep[0] = "8888888";
				rep[1] = "     88";
				rep[2] = "    88 ";
				rep[3] = "   88  ";
				rep[4] = "  88   ";
				rep[5] = "  88   ";
				rep[6] = "  88   ";
				break;
			case 8:
				rep[0] = " 88888 ";
				rep[1] = "88   88";
				rep[2] = "88   88";
				rep[3] = " 88888 ";
				rep[4] = "88   88";
				rep[5] = "88   88";
				rep[6] = " 88888 ";
				break;
			case 9:
				rep[0] = " 888888";
				rep[1] = "88   88";
				rep[2] = "88   88";
				rep[3] = " 888888";
				rep[4] = "     88";
				rep[5] = "     88";
				rep[6] = "     88";
				break;
		}
		
		return rep;
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer(); // Timer object to control clock
		timer.schedule(new Main(), 0, 500); // Refresh every 500 milliseconds
		
		return;
	}
	
}
