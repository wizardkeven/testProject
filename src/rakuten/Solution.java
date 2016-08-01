package rakuten;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public double solution(int x1, int y1, int r1, int x2, int y2, int r2) {
    	DecimalFormat dFormat = new DecimalFormat("#.####");
    	dFormat.setRoundingMode(RoundingMode.DOWN);
    	double dis_center = Double.parseDouble(dFormat.format(Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2))));
    	int R,r;
    	if (r1>r2) {
			R=r1;
			r= r2;
		}else {
			R=r2;
			r=r1;
		}
    	if ((dis_center>=r1+r2)|| dis_center<R-r) {
			return 0.0;
		}
    	


    	double area1 = r*r*Math.acos((dis_center*dis_center+r*r -R*R)/(2*dis_center*r));
    	double area2 = R*R*Math.acos((dis_center*dis_center+R*R-r*r)/(2*dis_center*R));
    	double area3 = 0.5*Math.sqrt((-dis_center+r+R)*(dis_center+r-R)*(dis_center-r+R)*(dis_center+r+R));
    	double intersection = area1+area2-area3;
    	
    	String ss = dFormat.format(intersection);
		return Double.parseDouble(ss);
    }
}

