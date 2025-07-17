package org.kosa.myproject;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring10LoggingInstApplication implements CommandLineRunner{
	private static final Logger logger=LoggerFactory.getLogger(Spring10LoggingInstApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Spring10LoggingInstApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		testLogging();
		String id = "java";
		id="spring";//test 위해 다른 아이디를 입력한다
		simulateLoginService(id);
	}
	private void testLogging() {
		//가장 낮은 단계도 테스트
		logger.debug("trace: 매우 상세한 실행 과정");// debug 레벨로 설정 
		logger.info("debug: 디버깅을 위한 정보");
		logger.warn("info: 일반 정보");
		logger.error("warn: 주의가 필요한 상황");
		// 가장 낮은 단계도 테스트 
		logger.trace("error: 오류가 발생했습니다");
	}
	private void simulateLoginService(String id) {
		/*
		 * {}을 이용한 파라미터 바인딩 -> String을 + 하는 것보다 성능상 훨씬 유리
		 * 내부적으로 StringBuider 를 이용, 또한 실행 로깅 레벨이 아니면 문자열 결합하지 않음
		 */
		logger.info("사용자 로그인시도:{} 메세지{}",id,"logging study");
		if(id.equals("java")) {
			//db에서 조회해옴
			String role="CafeManager";
			logger.info("사용자가 {} (역할:{}) 로그인 성공",id,role);
			
		}else {
			logger.warn("사용자{}로그인 실패",id);
		}
		//////////////logger.error()///////////////////////
		try {
			riskOperation();
		}catch(Exception e) {
			//e.printStackTrace(); //정보가 지속되지 않음
			logger.error("작업 중 오류 발생:{}",e.getMessage(),e);
		}
	}
	public void riskOperation() {
		logger.debug("위험 작업 시작");
		//테스트를 위해 의도적으로 예외 발생
		throw new RuntimeException("예상치 못한 오류가 발생했습니다");
	}
	
}









