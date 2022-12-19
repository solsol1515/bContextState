import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpManagedMain {
	
	public static void main(String[] args) {
		
		// 1299 사번의 홍길숙님 정보 입력하기
		
		// 1. 엔티티 매니저 팩토리 생성 (persistence와 연결됨)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextstate");
		// 2. 엔티티 매니저
		EntityManager em = emf.createEntityManager();
		// 4-1. 엔티티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			// 3. 엔티티 생성
			/*
			EmpVO emp = new EmpVO();
			emp.setName("홍동이");
			emp.setEmpno(1297);
			
			// 4-2. 트랜잭션 처리
			tx.begin();
			em.persist(emp); */
			
			EmpVO emp1 = em.find(EmpVO.class,1297);
			System.out.println("검색 결과: "+emp1);
			
			EmpVO emp2 = em.find(EmpVO.class,1298);
			System.out.println("검색 결과: "+emp2);
			
			if(emp1 == emp2) System.out.println("동일 객체");		// 동일객체
			else System.out.println("다른 객체");
			
			tx.commit();
			
		}catch(Exception ex) {
			System.out.println("예외: "+ex.getMessage());
		}finally {
			em.close();
			emf.close();
		}
		
	}
}
