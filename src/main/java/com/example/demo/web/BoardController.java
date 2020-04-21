package com.example.demo.web;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;
    //신규등록
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody BoardRequest boardRequest){
        try{
            Long ret = boardService.save(boardRequest);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.OK);
        }
    }

    //전체조회
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<List<Board>> findAll(){
        return new ResponseEntity<>(boardService.findAllByOrderByIdDesc(),HttpStatus.OK);
    }

    //id로 조회
    @RequestMapping(value="/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Board> findBoardById(@PathVariable("id") Long id){
        return new ResponseEntity<>(boardService.findBoardById(id), HttpStatus.OK);
    }

    //id로 삭제
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try{
            boardService.delete(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error", HttpStatus.OK);
        }
    }

    //업데이트
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody BoardRequest boardRequest){
        boardService.save(boardRequest);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
