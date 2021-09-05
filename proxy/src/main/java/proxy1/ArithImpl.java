package proxy1;

public class ArithImpl implements ArithInt {
	@Override
	public void sum(int x, int y) {
		int sum = x + y;
		System.out.println(sum);
	}
	@Override
	public void minus(int x, int y) {
		int minus = x - y;
		System.out.println(minus);
	}
	@Override
	public void multiply(int x, int y) {
		int multiply = x * y;
		System.out.println(multiply);
	}
	@Override
	public void divide(int x, int y) {
		int divide = x / y;
		System.out.println(divide);
	}
	@Override
	public int sum2(int x, int y) {
		System.out.println(x+ y);
		return x + y;
	}

}
