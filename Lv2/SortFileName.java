import java.util.*;
public class SortFileName {
    public List<String> solution(String[] files) {
        List<splitName> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        
        for(String file:files) {
        	StringBuilder head = new StringBuilder();
        	StringBuilder number = new StringBuilder();
        	StringBuilder tail = new StringBuilder();
        	
        	for(char c:file.toCharArray()) {
        		String s = String.valueOf(c);
        		if(!s.matches("[0-9]") && number.toString().equals("")) head.append(s);
        		if(s.matches("[0-9]") && tail.toString().equals("")) number.append(s);
        		if(!s.matches("[0-9]") && !number.toString().equals("")) tail.append(s);
        	}
        	list.add(new splitName(head.toString(),number.toString(),tail.toString()));
        }
        
        Collections.sort(list);
        for(splitName cn:list) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(cn.head);
        	sb.append(cn.number);
        	sb.append(cn.tail);
        	System.out.println(cn.head+" "+cn.number+" "+cn.tail);
        	answer.add(sb.toString());
        }
        
        return answer;
    }
    
    class splitName implements Comparable<splitName> {
    	int index;
    	String head;
    	String number;
    	String tail;
    	
		public splitName(String head, String number, String tail) {
			super();
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		@Override
		public int compareTo(splitName o) {
			// TODO Auto-generated method stub
			int k = head.toLowerCase().compareTo(((splitName)o).head.toLowerCase());
			//head 같을경우
			if(k == 0) {
				if(Integer.parseInt(number) > Integer.parseInt(((splitName)o).number)) k = 1;
				else if(Integer.parseInt(number) < Integer.parseInt(((splitName)o).number)) k = -1;
				else k = 0;
			}
			return k;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"foo.a-s.d122.zip", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"};
		SortFileName sortFileName = new SortFileName();
		System.out.println(sortFileName.solution(files));
	}
}
