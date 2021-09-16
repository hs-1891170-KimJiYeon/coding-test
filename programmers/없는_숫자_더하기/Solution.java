class Soultion{

    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i<10; i++){
            list.add(i);
        }
        for(int n : numbers){
            list.remove(Integer.valueOf(n));
        }
        int sum = 0;
        for(int n: list){
            System.out.println(n);
            sum += n;
        }

        return sum;
    }


}
