package com.br.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.board.controller.DTOs.BoardRequest;
import com.br.board.model.board.Board;
import com.br.board.model.board.BoardService;

@RestController
@RequestMapping("/controller/board")
@CrossOrigin
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @PostMapping
    public ResponseEntity<Board> create(@RequestBody BoardRequest request){
        Board board = boardService.create(request.build());
        return new ResponseEntity<Board>(board, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Board> findAll(){
        return boardService.findAll();
    }
    
    @GetMapping("/{id}")
    public Board findById(@PathVariable Long id){
        return boardService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody BoardRequest request){
        boardService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
