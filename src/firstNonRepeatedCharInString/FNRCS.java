package firstNonRepeatedCharInString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FNRCS {

	public static void main(String[] args) {
//		System.out.println(findChar("yellow"));
//		System.out.println(findChar("tooth"));
//		System.out.println(findChar("coco"));
		System.out.println(findCharInPlace("yellow"));
		System.out.println(findCharInPlace("tooth"));
		System.out.println(findCharInPlace("coco"));
		System.out.println(findCharInPlace("copco"));
	}
	
	public static String findChar(String s) {
		String ans = null;
		Map<Character, Integer> sMap = new LinkedHashMap<Character, Integer>();
		for(char c: s.toCharArray()){
			if(!sMap.containsKey(c)){
				sMap.put(c, 1);
			}else{
				sMap.put(c, sMap.get(c)+1);
			}
		}
		for(Entry<Character, Integer> en: sMap.entrySet()){
			if(en.getValue()==1) return en.getKey().toString();
		}
		return ans;
	}
	public static String findCharInPlace(String s){
		int len = s.length();
		if(len <= 0) return null;
//		String ans = "";
		boolean repeated = false;
		for(int i=0;i<s.length();i++){
			repeated = false;
			int j=0;
			for(;j<s.length();j++){
				if(j!=i&&s.charAt(j)==s.charAt(i)){
					repeated = true;
					break;
				}
			}
			if(!repeated)
				return s.charAt(i)+"";
		}
		
		return  "";
	}
}
