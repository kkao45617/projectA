package com.springbook.diz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.boardVO;

@Repository
public class boardDAOspring {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	//private final String board_inster="insert into BOARD(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String board_inster="insert into BOARD(seq, title, writer, content) values(?,?,?,?)";

	private final String board_update = "update board set title=? , content =? where seq=?";
	private final String board_delete = "delete board where seq=?";
	private final String board_get = "select * from board where seq=?";
	private final String board_list = "select * from board order by seq desc";
	
	public void insertboard(boardVO vo) {
		System.out.println("------>insert board 扁瓷 贸府");
		jdbctemplate.update(board_inster,vo.getSeq(),vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void updateboard(boardVO vo) {
		System.out.println("-------->updateboard 扁瓷 贸府");
		jdbctemplate.update(board_update,vo.getTitle(),vo.getWriter(),vo.getContent());
		
	}
	public void deleteboard(boardVO vo) {
		System.out.println("---->delete board 扁瓷贸府");
		jdbctemplate.update(board_delete,vo.getSeq());
	}
	public boardVO getboard(boardVO vo) {
		System.out.println("--->getboard 贸府");
		Object[] args = {vo.getSeq()};
		return jdbctemplate.queryForObject(board_get, args, new boardrowmapper());
	}
	
	public List<boardVO> getboardlist(boardVO vo) {
		System.out.println("--->boardlist 贸府");
		return jdbctemplate.query(board_list,  new boardrowmapper());
	}
	
}
class boardrowmapper implements RowMapper<boardVO>{

	public boardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		boardVO vo = new boardVO();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setWriter(rs.getString("writer"));
		vo.setRegdate(rs.getDate("regdate"));
		vo.setCnt(rs.getInt("cnt"));
		
		return vo;
	}
	
}