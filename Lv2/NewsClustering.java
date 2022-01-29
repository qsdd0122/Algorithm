import java.util.*;

public class NewsClustering {
    public static int solution(String str1, String str2) {
        int answer = 0;
        List<String> arr_str1 = new ArrayList<>();
        List<String> arr_str2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        //str1 split
        for(int i=0; i<str1.length()-1;i++) {
        	//특수문자가 포함 되어 있지 않은 경우
        	if(String.valueOf(str1.charAt(i)).matches("[a-zA-Z]") && String.valueOf(str1.charAt(i+1)).matches("[a-zA-Z]")) {
        		arr_str1.add(str1.substring(i, i+2).toUpperCase());
        	}
        }
        // str2 split
        for(int i=0; i<str2.length()-1;i++) {
        	//특수문자가 포함 되어 있지 않은 경우
        	if(String.valueOf(str2.charAt(i)).matches("[a-zA-Z]") && String.valueOf(str2.charAt(i+1)).matches("[a-zA-Z]")) {
        		arr_str2.add(str2.substring(i, i+2).toUpperCase());
        	}
        }
        
        // 교집합
        inter = intersection(arr_str1, arr_str2);
        
        // 합집합
        union = union(arr_str1, arr_str2, inter);
        
        if(union.size() == 0) return 65536;
        
        return inter.size()*65536/union.size();
    }
    
    // 합집합 구하기
    private static <T> ArrayList<T> union(List<T> arr1, List<T> arr2, List<T> inter){
    	ArrayList<T> arr = new ArrayList<>();
    	for(int i=0;i<inter.size();i++) {
    		arr1.remove(inter.get(i));
    	}
    	for(int i=0;i<inter.size();i++) {
    		arr2.remove(inter.get(i));
    	}
    	arr.addAll(inter);
    	arr.addAll(arr1);
    	arr.addAll(arr2);
    	
    	return arr;
    }
    
    // 교집합 구하기
    private static <T> ArrayList<T> intersection(List<T> arr1, List<T> arr2){
    	ArrayList<T> arr = new ArrayList<>();
    	arr.addAll(arr1);
    	arr.retainAll(arr2);
    	
    	return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		System.out.println(solution(str1,str2));
	}

}
