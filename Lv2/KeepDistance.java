import java.util.*;
public class KeepDistance {
    public static int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        String[][] new_places = new String[7][7];
        
        for(int i=0; i<places.length; i++) {
        	// �迭 index out�� �����ϱ� ���� �迭 ũ�� �ø���
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
        			/* P�� ��濡 �ִ� O�� ��ġ�� ��ĥ��� �Ÿ��α⸦ ��Ű�� ���� ������ �̿� */
        			char select = new_places[i][j].charAt(k);
        			if(select == 'P') {
	        			//������
	        			if(new_places[i][j].charAt(k+1) == 'O') {
	        				Location loc = new Location(j,k+1);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			//�Ʒ���
	        			if(new_places[i][j+1].charAt(k) == 'O') {
	        				Location loc = new Location(j+1,k);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			//����
	        			if(new_places[i][j].charAt(k-1) == 'O') {
	        				Location loc = new Location(j,k-1);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc , true);
	        			}
	        			//����
	        			if(new_places[i][j-1].charAt(k) == 'O') {
	        				Location loc = new Location(j-1,k);
	        				if(check(map, loc) == 1) answer[i] = 0;
	        				else map.put(loc, true);
	        			}
	        			
	        			// �ٷ� ���� P�� ���
	        			if(new_places[i][j].charAt(k+1) == 'P' || new_places[i][j+1].charAt(k) == 'P' || new_places[i][j].charAt(k-1) == 'P' || new_places[i][j-1].charAt(k) == 'P') {
	        				answer[i] = 0; 
	        			}
        			}
        		}
        	}
        }
        
        return answer;
    }
	
    // ��ġ ������ ����ִ� ������Ʈ Ŭ����
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
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

	}
	
	// map�� Ű�� �����ϴ��� üũ
	private static int check(Map<Object,Boolean> map, Object o) {
		Boolean isExist = map.containsKey(o);
		System.out.println(isExist+" "+((Location)o).getX()+" "+((Location)o).getY());
		if(isExist == true) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = {{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(places);
	}
}
