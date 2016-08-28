package LetterCount;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Have the function LetterCount(str) take the str parameter
 * being passed and return the first word with the greatest 
 * number of repeated letters. For example: "Today, is the 
 * greatest day ever!" should return greatest because it has 
 * 2 e's (and 2 t's) and it comes before ever which also has 
 * 2 e's. If there are no words with repeating letters return 
 * -1. Words will be separated by spaces. 
 * Use the Parameter Testing feature in the box below to test 
 * your code with different arguments.
 * @author kai
 *
 */
public class LetterCountMain {
	
	 public static String LetterCount(String str) { 
		  
	      if(str.length()<=0) return "-1";
			  
			  String[] aa = str.split("\\s+");
			  int ll = aa.length;
			  int maxre = 1;
			  int mm_index = 0;
			  int repeat =0;
			  for(int i=0;i<ll;i++){
			      int la = aa[i].length();
			      String ls = aa[i];
			      int local = 0;
//			      if(la>1){//more than one element in i-th substring
			      HashMap<Character, Integer> mm = new HashMap<Character, Integer>();
			         
			        for(int j=0;j<la;j++){
			              mm.put(ls.charAt(j), 0);
			          }
			        if (mm.size() == la) {
						repeat++;
					}else{
				        for(int j=0;j<la;j++){
				              mm.put(ls.charAt(j), mm.get(ls.charAt(j))+1);
				          }

				        int maxx = 1;;
						for(Character c: mm.keySet()){
				              if(mm.get(c)>maxx ){
				                  maxx = mm.get(c);
				              }
				          }
				        if(maxx > maxre){
				        	maxre = maxx;
				            mm_index = i;
				        }
					}
//			      }
			      
			  }
			  if (repeat == ll) {
				return "-1";
			}else {
			    return aa[mm_index];
			}

	    
	  } 

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.print(LetterCount(s.nextLine())); 
	}
}
