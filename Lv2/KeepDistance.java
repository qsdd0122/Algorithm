import java.util.*;
public class KeepDistance {
    public static int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        String[][] new_places = new String[7][7];
        
        for(int i=0; i<places.length; i++) {
        	// 배열 index out을 방지하기 위해 배열 크기 늘리기
        	new_places[i][0] = "111111";
        	new_places[i][6] = "111111";
    		
        	for(int j=1; j<=places[0].length; j++) {
        		StringBuilder sb = new StringBuilder();
        		sb.append("1");
        		sb.append(places[i][j-1]);
        		sb.append("1");
        		new_places[i][j] = sb.toString();
        	}
        }
        
        for(int i=0; i<places.length; i++) {
        	
        	Map<Object, Boolean> map = new HashMap<>();
    		
        	for(int j=1; j<=places[0].length; j++) {
        		
        		for(int k=1; k<=5; k++) {
        			/* P의 사방에 있는 O의 위치가 겹칠경우 거리두기를 지키고 있지 않음을 이용 */
        			char select = new_places[i][j].charAt(k);
        			if(select == 'P') {
	        			//오른쪽
	        			if(new_places[i][j].charAt(k+1) == 'O') {
	        				Location loc = new Location(j,k+1);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			//아래쪽
	        			if(new_places[i][j+1].charAt(k) == 'O') {
	        				Location loc = new Location(j+1,k);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			//왼쪽
	        			if(new_places[i][j].charAt(k-1) == 'O') {
	        				Location loc = new Location(j,k-1);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc , true);
	        			}
	        			//위쪽
	        			if(new_places[i][j-1].charAt(k) == 'O') {
	        				Location loc = new Location(j-1,k);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			
	        			// 바로 옆이 P인 경우
	        			if(new_places[i][j].charAt(k+1) == 'P' || new_places[i][j+1].charAt(k) == 'P' || new_places[i][j].charAt(k-1) == 'P' || new_places[i][j-1].charAt(k) == 'P') {
	        				answer[i] = 0; 
	        			}
        			}
        		}
        	}
        }
        
        return answer;
    }
	
    // 위치 정보를 담고있는 오브젝트 클래스
	private static class Location {
		int x;
		int y;
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.x ^ this.y;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(((Location)obj).x == x && ((Location)obj).y == y) return true;
			else return false;
		}
	}
	
	// map에 키가 존재하는지 체크
	private static int check(Map<Object,Boolean> map, Object o) {
		Boolean isExist = map.containsKey(o);
		if(isExist == true) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = {{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(places);
	}
}
