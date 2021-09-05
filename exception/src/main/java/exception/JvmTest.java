package exception;

import org.junit.Test;

public class JvmTest {
	@Test
	public void JvmTest() {
		int[] array = {1,2};
		int i = getElement(array);
		System.out.println(i+6);
	}

	private static int getElement(int[] array) {
		//java.lang.ArrayIndexOutOfBoundsException 数组索引越界异常
		int i = array[4];
		return i;
	}
}
