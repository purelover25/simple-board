package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;//Entity생성시간 가져오기
import org.springframework.data.jpa.domain.support.AuditingEntityListener;//Entity생성 리스너

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //Board 클래스를 엔티티클래스로 지정
@EntityListeners(AuditingEntityListener.class) //엔티티 생성시점 체크
@NoArgsConstructor // 파라미터 없는 생성자 자동 생성(기본생성자 생성) board(){}
@Getter//Getter 자동생성
@Setter//Setter자동생성
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String author;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(length = 500)
    private String content;
    @CreatedDate//시스템시간 호출
    private LocalDateTime createdAt;//@EntityListeners와 함께 쓰여 Entity생성시간 출력
}
