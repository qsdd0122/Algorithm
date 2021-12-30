import java.util.*;

class OpenChat {
     public static ArrayList<String> solution(String[] record) {
        String[] answer = {};
        
        ArrayList<String> arr = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String s : record) {
        	String[] arr_split = s.split(" ");

            if(arr_split[0].equals("Enter")){
            	map.put(arr_split[1], arr_split[2]);
            	
            } else if(arr_split[0].equals("Change")){
            	map.put(arr_split[1], arr_split[2]);
            }
            
        }
       
        for(String s : record) {
        	String[] arr_split = s.split(" ");
        	if(arr_split[0].equals("Enter")){
            	arr.add(printScript(arr_split[0],map.get(arr_split[1])));
            	
            } else if(arr_split[0].equals("Leave")) {
            	arr.add(printScript(arr_split[0],map.get(arr_split[1])));
            } else continue;
        }
        
        
        
        return arr;
    }
    
    private static String printScript(String enter, String nickname) {
    	if(enter.equals("Enter")) return nickname+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
    	else return nickname+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";
    }
}