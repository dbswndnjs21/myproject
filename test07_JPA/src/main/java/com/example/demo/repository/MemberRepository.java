package com.example.demo.repository;


import com.example.demo.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member); // db에 저장하기
    }

    public Member select(String id) {
        //find(Class<T> entityClass, Object primaryKey);
        // 여기서 id는 @Id가 붙은애를 가져다 쓰는거지 필드명 id가아님
        //
        return em.find(Member.class, id);
    }

    public void delete(String id) {
        Member member = em.find(Member.class, id);
        em.remove(member);
    }

    public Member update(Member member) {
        Member m = em.find(Member.class,member.getId());
        m.setAge(member.getAge());
        m.setPassword(member.getPassword());
        m.setEmail(member.getEmail());
        return m;
    // 업데이트 쿼리를 날리는게 아니고 객체 값이 바뀜
    }


    /*
        JPQL 사용하기
        - 대소문자 구분 : 엔티티와 속성은 대소문자를 구부한다
        SELECT, FROM, WHERE 같은 JPQL 키워드는 대소문자를 구분하지 않아도 된다
        - 엔티티 이름 :  JPQL에서 사용한 Member는 클래스명이 아니라 엔티티 명이다 -> 클래스명으로 사용하면 안된다는 소리
        엔티티명은 @Entity(name="adc")로 지정할 수 잇다. 엔티티명을 지정하지 않으면 클래스 명을 기본값으로 사용한다.
        - 별칭은 필수로 해야한다
    */

    public Long count1() {
        Query query = em.createQuery("select count(m) from Member m"); // from 뒤에 Member는 엔티티 객체 이름임
        Long cnt = (Long) query.getSingleResult();
        return cnt;
    }

    public Member selectList(){
        Query query = em.createQuery("select m from Member m"); // select 뒤에 m은 엔티티 전체 뽑아오기임
        return (Member) query.getSingleResult();
//      return List<Member> query.getResultList(); 도 가능 -> 데이터가 여러개일때
    }

    public int count2() {
        Query query = em.createNativeQuery("select count(*) from member",Integer.class);
        int cnt = (Integer) query.getSingleResult();
        return cnt;
    }
}
