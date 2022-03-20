import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParkingFee {
    public List<Integer> solution(int[] fees, String[] records) throws ParseException {
        List<Integer> answer = new ArrayList<>();
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        String time, inout, carNum;

        Map<String, String> info_inout = new HashMap<>();
        Map<String, Long> info_time = new TreeMap<>();
        
        for(String record:records) {
        	String[] split = record.split(" ");
        	time = split[0];
        	carNum = split[1];
        	inout = split[2];
        	
        	if(inout.equals("IN")) {
        		info_inout.put(carNum, time);
        	} else {
        		String outTime = info_inout.remove(carNum);
        		long parkingTime = calcDiffTime(time, outTime);
        		info_time.put(carNum, info_time.getOrDefault(carNum, (long)0)+parkingTime);
        	}
        }

        // 출차내역 없을 경우

       	Set<String> keys = info_inout.keySet();
        for(String key:keys) {
        	String inTime = info_inout.get(key);
        	long parkingTime = calcDiffTime(inTime, "23:59");
        	info_time.put(key, info_time.getOrDefault(key, (long)0)+parkingTime);
        		
        }
        
		 
        for(Long t:info_time.values()) {
        	System.out.println(t);
        	answer.add(calcFee(t,basicTime,basicFee,unitTime,unitFee));
        }
        
        return answer;
    }
    
    // 시간 차 구하는 함수
    private long calcDiffTime(String inTime, String outTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date time1 = format.parse(inTime);
		Date time2 = format.parse(outTime);
		long diff = (time2.getTime() - time1.getTime())/60000;
		
		return diff>=0?diff:-diff;
    }
    
    // 시간으로 요금 계산하는 함수
    private int calcFee(long time2, int basicTime, int basicFee, int unitTime, int unitFee) {
    	int time = (int)time2;
    	if(time<=basicTime) return basicFee;
    	double fee = 0;
    	double mid = Math.ceil((time-basicTime)/(double)unitTime);
    	fee = basicFee + mid*unitFee;

    	return (int)fee;
    }
    

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		ParkingFee pf = new ParkingFee();
		pf.solution(fees, records);
	}

}
