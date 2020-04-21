package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    //findBy + 조회할 키 값 지정, 여기서는 Entity컬럼명 Author로 검색
    public Board findByAuthor(String author);
    //order by를 키값으로 하기 위해 findAll뒤에 ByOrderBy + 키 + Asc/Desc 지정
    public List<Board> findAllByOrderByIdDesc();
    //findBy 키워드로 Entity의 id값 조회
    public Board findBoardById(Long id);
}