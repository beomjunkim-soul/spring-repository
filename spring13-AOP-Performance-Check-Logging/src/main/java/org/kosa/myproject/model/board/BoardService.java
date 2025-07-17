package org.kosa.myproject.model.board;

public class BoardService {
	public String find() {
		try {
			Thread.sleep(100);//0.1초 지연
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("core find post");
		return "게시물 정보";
	}
	public String findAllList() {
		try {
			Thread.sleep(700);//0.1초 지연
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("core findAll post");
		return "게시물 리스트 정보";
	}

}
