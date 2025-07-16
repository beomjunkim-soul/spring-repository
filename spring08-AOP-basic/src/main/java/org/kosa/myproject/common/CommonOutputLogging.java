package org.kosa.myproject.common;

public class CommonOutputLogging {
	public void log(String className,String methodName) {
		//더 복잡한 작업이 있다고 가정
		System.out.println("**cross cuting concern**"+className+"***"+methodName);
	}

}
