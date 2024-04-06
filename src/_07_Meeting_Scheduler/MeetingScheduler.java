package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MeetingScheduler {
	/*
	 * Your task is to code a method to find a meeting time for two people
	 * given their schedules.
	 * 
	 * Code the method below so that it returns a Schedule object that contains
	 * all the times during the week that are in BOTH people's schedules. The
	 * Schedule class is included in this package.
	 * 
	 * Example:
	 * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
	 * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
	 * The returned HashMap should contain: Tuesday 14 and Monday 9
	 * 
	 * The returned Schedule object represents the times both people are
	 * available for a meeting.
	 * 
	 * Time availability is always at the top of the hour, so 9:30 is not valid
	 * Time availability always represents 1 hour
	 * Assume both schedules are in the same time zones
	 */
	public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
		Schedule times = new Schedule();
//		for (String i : person1.getSchedule().keySet()) {
//			for (int o = 0; o < person1.getSchedule().get(i).size(); o++) {
//				if (person2.getSchedule().get(i).contains(person1.getSchedule().get(i).get(o))) {
//					times.getSchedule().put(i, person1.getSchedule().get(i));
//					times.getSchedule().get(i).add(person1.getSchedule().get(i).get(o));
//				}
//			}
//		}
			for (Entry<String, ArrayList<Integer>> e1 : person1.getSchedule().entrySet()) {
				String s1 = e1.getKey();
				ArrayList<Integer> i1 = e1.getValue();
				for (Entry<String, ArrayList<Integer>> e2 : person2.getSchedule().entrySet()) {
					if (s1.equals(e2.getKey())) {
						ArrayList<Integer> time = new ArrayList<Integer>();
						for (int i = 0; i < i1.size(); i++) {
							if (e2.getValue().contains(i1.get(i))) {
								time.add(i1.get(i));
								
								times.getSchedule().put(s1, time);
							}
						}
					}
				}
			}
			
		return times;
	}
}
