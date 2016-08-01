package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class mainTest {

	public static void main(String[] args) {
		List li = new ArrayList<Interval>();
		li.add(new Interval(1,4));
		li.add(new Interval(0,2));
		li.add(new Interval(3,5));
		mergeIntervals mm = new mergeIntervals();
		List output = mm.merge(li);
		for (int i = 0; i < output.size(); i++) {
			System.out.println("start:"+((Interval)output.get(i)).start);
			System.out.println("end:"+((Interval)output.get(i)).end);
		}
		
	}

}
