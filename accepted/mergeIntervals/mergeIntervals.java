package mergeIntervals;

import java.util.List;

public class mergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() <= 0) {
			return intervals;
		}
		boolean isMerged = true; // If there is merging happened during one
									// iteration, then start the next iteration

		while (isMerged) {
			isMerged = false; // assuming there will be not merge
			for (int i = 0; i < intervals.size(); i++) {

				if (intervals.get(i).start == -1) {
					continue;
				}

				for (int j = i + 1; j < intervals.size(); j++) {
					// If the start of the current interval is marked -1, it is
					// a invalid interval or has been merged into another
					// interval
					if (intervals.get(j).start == -1) {
						continue;
					}
					if (intervals.get(i).end < intervals.get(j).start
							|| intervals.get(i).start > intervals.get(j).end) {
						continue; // non-overlapping happans
					}
					if (intervals.get(i).start < intervals.get(j).start
							&& intervals.get(i).end >= intervals.get(j).start
							&& intervals.get(i).end < intervals.get(j).end) {
						intervals.get(i).end = intervals.get(j).end;
						intervals.get(j).start = -1; // Mark this merged
														// interval
						isMerged = true;
					} else if (intervals.get(i).start > intervals.get(j).start
							&& intervals.get(i).start <= intervals.get(j).end
							&& intervals.get(i).end > intervals.get(j).end) {
						intervals.get(i).start = intervals.get(j).start;
						intervals.get(j).start = -1;
						isMerged = true;
					} else if (intervals.get(i).start < intervals.get(j).start
							&& intervals.get(i).end > intervals.get(j).end) {
						intervals.get(j).start = -1;
						isMerged = true;
					} else if (intervals.get(i).start >= intervals.get(j).start
							&& intervals.get(i).end <= intervals.get(j).end) {
						intervals.get(i).start = -1;
						isMerged = true;
						// The current interval has been merged, so it doesn't
						// exist anymore
						break;
					}
				}
			}
		}
		int times = 0;

		while (times < intervals.size()) {
			if (intervals.get(times).start == -1) {
				// if current element was marked, remove it from the list
				intervals.remove(times);
				// System.out.println("remove position:"+times+"\n"
				// +"start:"+intervals.get(times).start+"\n"+"end:"+intervals.get(times).end);
				// pointing index to the last one
				times = 0;

			} else {
				times++;
			}

		}
		return intervals;
	}
}
