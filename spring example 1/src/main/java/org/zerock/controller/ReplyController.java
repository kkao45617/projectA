package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* �۾�      URL            HTTP���۹��
 * ��� : /replies/new  :  POST
 * ��ȸ : /replies/:rno    : GET
 * ���� : /replies/:rno   : DELETE
 * ���� : /replies/:rno   : PUT or PATCH
 * ������  : /replies/pages/:bno/:page   : GET
 */
@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	//Ŭ���̾�Ʈ���� �������� json, �������� Ŭ���̾�Ʈ string
	//{�Ӽ�:��, �Ӽ�: ��} --> @RequestBody
	//{bno:��, reply:��, replyer:��}
	@PostMapping(value = "/new", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	//{reply:"JS Test2", replyer:"tester2", bno:bnoValue}  
	//vo.setReply("JS Test2"), vo.setReplyer("tester2"), vo.setBno(10000)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVO----------- : " + vo);
		int insertCount = service.register(vo);
		
		if(insertCount == 1) {
			return new ResponseEntity<>("abc.........", HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/pages/{bno}/{page}", 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno, 
										@PathVariable("page") int page) {
		log.info("getList..............." + bno +  " : " + page);
		Criteria cri = new Criteria(page, 10);
		log.info("cri : " + cri);
		return new ResponseEntity<>(service.getReplyPage(cri, bno), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remvoe(@PathVariable("rno") Long rno)  {
		
		if(service.remove(rno) == 1 ) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@GetMapping(value = "/get/{rno}" ,produces = {MediaType.APPLICATION_JSON_VALUE,
																MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<ReplyVO> get(@PathVariable("rno")Long ron){
		return new ResponseEntity<ReplyVO>(service.get(ron), HttpStatus.OK);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}",  consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("rno")Long rno, @RequestBody ReplyVO vo){
		
		vo.setRno(rno);
		return service.modify(vo)==1? new ResponseEntity<String>("success",HttpStatus.OK) :
		new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
