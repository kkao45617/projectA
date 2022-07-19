package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class pageDTO {
	private int startpage;
	private int endpage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public pageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		
		this.endpage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startpage=endpage-9;
		
		int readend=(int)(Math.ceil(total*1.0)/cri.getAmount());
		
		if(endpage> readend) {
			endpage=readend;
		}
		
		//이전~다음 클릭버튼 생성
		this.prev=this.startpage>1;
		this.next=this.endpage<readend;
	}
}
