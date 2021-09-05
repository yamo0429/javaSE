package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**注意此案例编码为UTF-8
/**注意此案例编码为UTF-8
/**注意此案例编码为UTF-8
 * 1. 准备
 * 		1. 四种花色    13张牌�?   嵌套
 * 2. 洗牌
 *     Collections.shuffle
 * 3. 发牌
 * 
 * 4. 看牌
 *
 */
public class PokerDemo {

	public static void main(String[] args) {

		ArrayList<String> pokers = new ArrayList<String>();

		String[] colors = { "红桃", "梅花", "方块", "黑桃" };
		String[] numbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };
		for (String color : colors) {
			for (String number : numbers) {
				String poker = color + number;
				pokers.add(poker);
			}
		}
		pokers.add("小☺");
		pokers.add("大☺");

		// 2.洗牌
		// System.out.println("origin�?" + pokers);
		Collections.shuffle(pokers);
		// System.out.println(pokers);

		// 3.发牌 3个人 底牌
		ArrayList<String> p1 = new ArrayList<String>();
		ArrayList<String> p2 = new ArrayList<String>();
		ArrayList<String> p3 = new ArrayList<String>();
		ArrayList<String> dp = new ArrayList<String>();

		for (int i = 0; i < pokers.size(); i++) {
			String poker = pokers.get(i);
			int y = i % 3;
			// 先发三张给底�?
			if (i < 3) {
				dp.add(poker);
			} else if (y == 1) {
				p1.add(poker);
			} else if (y == 2) {
				p2.add(poker);
			} else {
				p3.add(poker);
			}
		}

		lookPokers(p1);
		lookPokers(p2);
		lookPokers(p3);
		lookPokers(dp);
	}

	private static void lookPokers(ArrayList<String> p1) {
		Iterator<String> it = p1.iterator();
		while (it.hasNext()) {
			String poker = it.next();
			System.out.print(poker);
		}
		System.out.println();
	}
}
