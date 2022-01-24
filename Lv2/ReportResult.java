import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportResult {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Map<String, Boolean>> who_reported = new HashMap<>();
        Map<String, Integer> cnt_reported = new HashMap<>();
        Map<String, Boolean> forbidden = new HashMap<>();
        
        for(String list : report) {
        	String reporting = list.split(" ")[0];
        	String reported = list.split(" ")[1];
        	
        	// 이미 한번 신고한 경우 중복은 패스
        	if(!who_reported.containsKey(reporting) || !who_reported.get(reporting).containsKey(reported)) {
        		// 신고당한 횟수 늘리기
        		cnt_reported.put(reported, cnt_reported.get(reported) != null ? cnt_reported.get(reported)+1 : 1);
        		// 횟수가 k번 이상이면 forbidden에 추가
        		if(cnt_reported.get(reported) >= k) forbidden.put(reported, true);
        	}
        	
        	Map<String, Boolean> temp = getMap(who_reported.get(reporting) != null ? who_reported.get(reporting) : null,reported,true);
        	temp.put(reported, true);
        	who_reported.put(reporting, temp);

        }
   //     for(String s: who_reported.keySet()) {
     //   	System.out.println(s+" "+who_reported.get(s).keySet());
       // }
   
        for(int i=0; i<id_list.length; i++) {
        	answer[i] = 0;
        	Map<String,Boolean> reported = who_reported.get(id_list[i]) != null ? who_reported.get(id_list[i]) : null;
        	if(reported != null) {
	        	for(String s : reported.keySet()) {
	        		if(forbidden.get(s) == null) continue;
	        		else if(forbidden.get(s) == true) answer[i]++;
	        	}
	        	
        	}
        	System.out.print(answer[i] + " ");
        }
        
        return answer;
    }
    
    private static Map<String, Boolean> getMap(Map<String,Boolean> map,String reporting, Boolean isReported) {
    	if(map == null) map = new HashMap<String, Boolean>();
    	map.put(reporting, isReported);
    	return map;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		System.out.println(solution(id_list, report, k));
	}

}
