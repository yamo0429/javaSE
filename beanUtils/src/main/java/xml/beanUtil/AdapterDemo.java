package xml.beanUtil;

import java.util.ArrayList;

/**
 * @author spy
 *
 */
public class AdapterDemo {
		public static void main(String[] args) {
			//有一个MP3
			MP3 mp3 = new MP3();
			mp3.addSong("天空之城");
			mp3.addSong("风居住的街道");
			
			//有一个25的耳机
			Headphone25 headphone25 = new Headphone25() {
				
				@Override
				public void playBy25(String song) {
					System.out.println(song + "被播放了");
				}
			};
			/**
			 * 买一个适配器，可以进行25接口到35接口的转换
			 */
			HeadPhoneAdater headPhoneAdater = new HeadPhoneAdater(headphone25);
			
			mp3.loopPlay(headPhoneAdater);
		}

}

/**
		 * 在现实生活中，耳机有3.5毫米和2.5毫米两种标准；
			有一个MP3，具有使用实现了3.5毫米耳机接口的功能；(没地方买！！！)
			
			有一个耳机，实现的是2.5毫米的接口；(AKG！！！)
			
			表示两种耳机标准的接口分别如下图所示：
 *
 */
//表示3.5毫米的耳机接口
interface Headphone35{
	//使用35毫米接口播放音乐
	public void playBy35(String song);
}

//表示2.5毫米的耳机接口
interface Headphone25{
	///使用25毫米接口播放音乐
	public void playBy25(String song);
}

class MP3{//表示MP3
	private ArrayList<String> songs = new ArrayList<>();//表示Mp3中保存的歌曲
	//MP3的添加歌曲的功能
	public void addSong(String song){
		songs.add(song);
	}
	//表示MP3使用3.5毫米的耳机接口，循环播放歌曲
	public void loopPlay(Headphone35 hd){
		//循环遍历获取MP3中保存的歌曲
		for (int i = 0; i < songs.size(); i++) {
			//通过接口使用耳机播放音乐
			hd.playBy35(songs.get(i));
		}
	}
}

/**
 * 买一个适配器：符合35规范（实现），但是内部可以接入25的耳机（传参）
 * 	1. 适配器：MP3（35) 和 耳机（25）之间的转换
 *  2. 有25接口的耳机
 *  3. 有MP3
 *
 */
class HeadPhoneAdater implements Headphone35{
	
	Headphone25 head25;
	
	public HeadPhoneAdater(Headphone25 head25) {
		this.head25 = head25;
	}
	/**
	 * 进行方法转接
	 * 就是将播放35接口音乐的方法，转到25接口上
	 */
	@Override
	public void playBy35(String song) {
		head25.playBy25(song);
	}
	
}
//class HeadPhoneAdater extends MP3 implements Headphone35{
//	
//	Headphone25 head25;
//	
//	public HeadPhoneAdater(Headphone25 head25) {
//		this.head25 = head25;
//	}
//	/**
//	 * 进行方法转接
//	 * 就是将播放35接口音乐的方法，转到25接口上
//	 */
//	@Override
//	public void playBy35(String song) {
//		head25.playBy25(song);
//	}
//	
//}
