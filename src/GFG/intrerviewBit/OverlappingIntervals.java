package intrerviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class OverlappingIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// sort with the start time of interval
		intervals.sort((a, b) -> {
			// if (a.start <= b.start) {
			// return 0;
			// } else {
			// return 1;
			// }
			return a.start - b.start;
		});

		final Stack<Interval> s = new Stack();
		// take two elements ,overlap and put them in stack
		s.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			// we call merge overlap start of second <= end of first
			if (intervals.get(i).start <= s.peek().end) {
				s.push(mergeOverlap(s.pop(), intervals.get(i)));
			} else {
				s.push(intervals.get(i));
			}

		}
		intervals.clear();
		intervals = (ArrayList<Interval>) s.stream().collect(Collectors.toList());
		return intervals;
	}

	Interval mergeOverlap(Interval a, Interval b) {
		if (b.end >= a.end) {
			return new Interval(a.start, b.end);
		} else {
			return new Interval(a.start, a.end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)
		final OverlappingIntervals o = new OverlappingIntervals();
		System.out.println(o.merge(new ArrayList<Interval>(Arrays.asList(o.new Interval(1, 10), o.new Interval(3, 8),
				o.new Interval(2, 9), o.new Interval(4, 7), o.new Interval(5, 6), o.new Interval(6, 6)))));

	}

}
