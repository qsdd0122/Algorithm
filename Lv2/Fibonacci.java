
public class Fibonacci {
    public int solution(int n) {
        return fibonacci(n);
    }
    
    private int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return (fibonacci(n-2)+fibonacci(n-1))%1234567;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.solution(n));
	}

}
