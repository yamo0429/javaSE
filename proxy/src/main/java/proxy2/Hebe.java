package proxy2;

public class Hebe implements SuperStar {

	@Override
	public void sing(int money) {
		System.out.println("hebe 唱了小幸运！");
		System.out.println("赚了" + money);
		System.out.println("----------------------------");
	}

	@Override
	public void liveShow(int money) {
		System.out.println("hebe 参加 running man！");
		System.out.println("赚了" + money);

	}

	@Override
	public void sleep() {
		System.out.println("很累了，开始睡觉..... Zzzzzzz~~~~");
	}

}
