package com.example.demo.service;


import com.example.demo.domain.Board;
import com.example.demo.domain.BoardRepository;
import com.example.demo.web.BoardRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    //신규 입력/업데이트
    public Long save(BoardRequest boardRequest){
        Board board = new Board();
        //화면으로부터 입력받은(BoardRequest)를 Board 엔티티로 옮기기
        BeanUtils.copyProperties(boardRequest, board);
        board = boardRepository.save(board);
        return board.getId();
    }
    //모든항목 조회 단 id로 디센딩
    public List<Board> findAllByOrderByIdDesc(){
        return boardRepository.findAllByOrderByIdDesc();
    }
    //id에 의한 조회
    public Board findBoardById(Long id){
        return boardRepository.findBoardById(id);
    }
    //id로 삭제
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

}
