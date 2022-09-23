import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();

        for(String r : records){
            String[] record = r.split(" ");
            if(record[2].equals("IN")){
                String[] inTime = record[0].split(":");
                int car = Integer.parseInt(record[1]);
                int inMinute = (Integer.parseInt(inTime[0]) * 60) + Integer.parseInt(inTime[1]);
                inMap.put(car, inMinute);
                if(!timeMap.containsKey(car)){
                    timeMap.put(car, 0);
                }

            }else{ //record[2].equals("OUT")
                int car = Integer.parseInt(record[1]);
                String[] outTime = record[0].split(":");
                int outMinute = (Integer.parseInt(outTime[0]) * 60) + Integer.parseInt(outTime[1]);
                int totalTime = timeMap.get(car) + outMinute-inMap.get(car);
                timeMap.put(car, totalTime);
                inMap.remove(car);
            }
        }

        //출차시간 안찍힌 차량
        if(!inMap.isEmpty()){
            Iterator<Integer> keys = inMap.keySet().iterator();
            while(keys.hasNext()){
                int car = keys.next();
                int totalTime = timeMap.get(car) + 1439-inMap.get(car);
                timeMap.put(car, totalTime); //23:59 -> 1439m

            }
        }

        int[] carArr = new int[timeMap.size()];
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        Iterator<Integer> cars = timeMap.keySet().iterator();
        while(cars.hasNext()){
            int car = cars.next();
            carArr[idx] = car;
            idx++;
        }
        Arrays.sort(carArr);
        for(int i=0; i<carArr.length; i++){
            int time = timeMap.get(carArr[i]);
            if(time > fees[0]){
                int extraTime = (time - fees[0]) / fees[2];
                if((time-fees[0]) % fees[2] != 0) extraTime++;
                answer[i] = fees[1] + (extraTime * fees[3]);
            }else{ //time<=fees[0]
                answer[i] = fees[1];
            }
        }


        return answer;
    }
}