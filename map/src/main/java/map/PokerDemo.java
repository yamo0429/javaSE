package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PokerDemo {
	
	public static void main(String[] args) {
		//1.准备一副牌
		HashMap<Integer,String> pokerMap = new HashMap<Integer, String>();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		String[] colors = {"♠","♥","♣","♦"};
		String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		//对牌面数字进行排序
		int i = 0;
		for (String number : numbers) {
			for (String color : colors) {
				String poker = color + number;
				
				pokerMap.put(i, poker);
				numList.add(i);
				i ++;
			}
		}
		
		pokerMap.put(52, "小☺");
		numList.add(52);
		pokerMap.put(53, "大☺");
		numList.add(53);
		
		//2.洗牌
		Collections.shuffle(numList);
		
		//3.发牌
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		ArrayList<Integer> dp = new ArrayList<Integer>();
		for (int j = 0; j < numList.size(); j++) {
			Integer num = numList.get(j);
			int k = j % 3;
			if(j < 3){
				dp.add(num);
			}else if(k == 1){
				p1.add(num);
			}else if(k == 2){
				p2.add(num);
			}else{
				p3.add(num);
			}
		}
		//4. 排序
		Collections.sort(p1);
		Collections.sort(p2);
		Collections.sort(p3);
		Collections.sort(dp);
		
		//5.看牌
//		lookPoker(pokerMap,p1);
//		lookPoker(pokerMap,p2);
//		lookPoker(pokerMap,p3);
		lookPoker(pokerMap,p1,p2,p3,dp);
		
	}
	private static void lookPoker(HashMap<Integer, String> pokerMap,
			ArrayList<Integer>... players) {
		for (ArrayList<Integer> player : players) {
			for (Integer num : player) {
				String poker = pokerMap.get(num);
				System.out.print(poker + " ");
			}
			System.out.println();
		}
	}

	private static void lookPoker1(HashMap<Integer, String> pokerMap,
			ArrayList<Integer> p1) {
		for (Integer num : p1) {
			String poker = pokerMap.get(num);
			System.out.print(poker + " ");
		}
		System.out.println();
	}
}
