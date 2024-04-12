package main.backend;

import java.util.ArrayList;

public class Schedule {
	
	String title = "";
	ArrayList<Activity> activities = new ArrayList<Activity>();

	public void addActivity() {
		activities.add(new Activity());
	}

	public int numActivities() {
		return activities.size();
	}
	
	public Activity getActivity(int index) {
		return activities.get(index);
	}
	
	public int getIndexOfLastActivity() {
		return activities.size() - 1;
	}
}
