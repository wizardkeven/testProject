package xiaomi;

import java.util.Arrays;
import java.util.Random;

public class xiaomiMonkeyAlgo {

	public static void main(String[] args) {
		int t_n = 10;
		int max_step = 3;
		int t_step = 4;
		int[] bananas = new int[t_n + 1];
		// int[] bananas = {0, 5, 6, 6, 2, 5, 5, 5, 4, 5, 3};
		int[] b_index = new int[t_n + 1];
		bananas[0] = 0;
		b_index[0] = 0;
		Random r = new Random();
		for (int i = 1; i < bananas.length; i++) {
			bananas[i] = r.nextInt(10);
			// bananas[i] =1;
			b_index[i] = i;
		}
		// System.out.println("Bnanas: "+bananas);
		// for (int i : bananas) {
		System.out.println(Arrays.toString(bananas));
		System.out.println(Arrays.toString(b_index));
		// }
		int[][] f = new int[bananas.length][t_step+1];
		getMaxBanana(bananas, max_step, t_step, bananas.length-1,f);
		for (int i = 0; i < f.length; i++) {
//			for (int j = 0; j < f[i].length; j++) {
				System.out.println(bananas[i]+Arrays.toString(f[i]));
//			}
		}
		System.out.println("Max bananas: " + f[bananas.length-1][t_step]);

	}

	// 森林里有一排树，数量为n， 第i棵树上有a[i]个香蕉(1<= i <=n, a[i] >=0).
	// 有一只猴子，一开始在第0棵树上（这棵树上没有香蕉）。这只猴子每次仅能向右跳[1,r]棵树，每次到一棵树上，他都会把树上的香蕉
	// 吃完。猴子到达最后一棵树的时候跳跃次数必须小于等于k(k <= n),求猴子最多能吃多少香蕉。（保证猴子k步能跳到终点）
	// @r 猴子每次最多能像由跳的步数
	// @k 猴子最多能跳的次数	public static int MonkeyEatMaxBananas(int[] a, int r, int k) {
	public static int getMaxBanana(int[] a, int r, int k, int nth,int[][] f) {

		if (k <= 0)
			return 0;
		if (nth<=0) {
			return 0;
		}
		if (nth <= r && k ==1){
			f[nth][k] = a[nth];
			return nth;
		}
		
		int max_step = r;
//		if (k == 1 && nth - r > 0) {
////			System.err.println("Step error");
//			return nth;
//		}else if (k == 1) {
//			f[nth][k] = a[nth-1];
//			return nth;
//		}else 
		{
			
			
			if(nth -r > r*(k-1)) return nth;
//			max_step = r;
			for (int i = r-1; i > 0; i--) {
				int s1 = getMaxBanana(a, r, k-1, nth-i, f);
				int s2 = getMaxBanana(a, r, k-1, nth-max_step, f);
//				if (s1>0 || s2 >0) {
					if(f[s1][k-1] > f[s2][k-1])
						max_step = i;
//				}
			}
			try{
				f[nth][k] =  f[nth-max_step][k-1] +a[nth];
			}catch(ArrayIndexOutOfBoundsException e){
				System.err.println("current nth: "+nth+"\n"+"max_step:"+max_step+"\n"+"k:"+k+"\n"+e.getMessage() );
			}
			
		}

//		System.out.println(k + "-th step at:" + (nth - max_step) + "-th tree. f[i][j]:"+f[nth][k]);
		return nth-max_step;
	}

}
