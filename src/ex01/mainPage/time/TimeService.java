package ex01.mainPage.time;

import java.text.SimpleDateFormat;

public class TimeService {
	public String getTime() {
		// 현재시간을 초 단위로 가져온다.
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		SimpleDateFormat s = 
				new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		String ss = s.format(time);
		System.out.println(ss);
		return ss;
	}
}
