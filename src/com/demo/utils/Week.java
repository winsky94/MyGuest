package com.demo.utils;

/**
 * @author 严顺宽
 */
public enum Week {
	Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

	public static Week getWeek(String weekDay) {
		switch (weekDay) {
		case "Sunday":
			return Week.Sunday;
		case "Monday":
			return Week.Monday;
		case "Tuesday":
			return Week.Tuesday;
		case "Wednesday":
			return Week.Wednesday;
		case "Thursday":
			return Week.Thursday;
		case "Friday":
			return Week.Friday;
		case "Saturday":
			return Week.Saturday;
		}
		return null;
	}

	public static Week getWeek(int number) {
		switch (number) {
		case 0:
			return Week.Sunday;
		case 1:
			return Week.Monday;
		case 2:
			return Week.Tuesday;
		case 3:
			return Week.Wednesday;
		case 4:
			return Week.Thursday;
		case 5:
			return Week.Friday;
		case 6:
			return Week.Saturday;
		}
		return null;
	}

	public static int getNum(Week week) {
		switch (week) {
		case Sunday:
			return 0;
		case Monday:
			return 1;
		case Tuesday:
			return 2;
		case Wednesday:
			return 3;
		case Thursday:
			return 4;
		case Friday:
			return 5;
		case Saturday:
			return 6;
		default:
			return -1;
		}
	}

	public static String toString(Week week) {
		switch (week) {
		case Sunday:
			return "Sunday";
		case Monday:
			return "Monday";
		case Tuesday:
			return "Tuesday";
		case Wednesday:
			return "Wednesday";
		case Thursday:
			return "Thursday";
		case Friday:
			return "Friday";
		case Saturday:
			return "Saturday";
		default:
			return null;
		}
	}
}
