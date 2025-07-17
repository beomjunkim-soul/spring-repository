package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class ProductService  {
	//공통 로그 컴포넌트를 사용하기 위해 객체 생성한다

	
	public void updatedProduct(String name, String maker, int price) {
		
		System.out.println(getClass().getName()+" core concern updateProduct");
	}
	
	public void findProductById(String id) {
		
		System.out.println(getClass().getName()+" core concern findProductById");
	}
	
	public void findProductByName(String name) {
		
		System.out.println(getClass().getName()+" core concern findProductByName");
	}
	 
	public void findProductListByMaker(String maker) {
		
		System.out.println(getClass().getName()+" core concern findProductListByMaker");
	}
	
}
