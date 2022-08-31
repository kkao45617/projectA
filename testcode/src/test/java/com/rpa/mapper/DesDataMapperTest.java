package com.rpa.mapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rap.board.mapper.DesDataMapper;
import com.rpa.board.domain.DesDataDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DesDataMapperTest {
	@Autowired
	private DesDataMapper mapper;
	
	@Test
	public void testInsert() throws IOException {
        try {
			Document doc = Jsoup.connect("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"
					+ "?serviceKey=sWi23NfHCswD2JLkVzlAjWdx84T9hH%2B4%2BgYdeHg5rakMR397CZtjr1hoq8Mo56LMzSCjxrlMzLEkI0Bi%2FwFQ0Q%3D%3D&pageNo=1&numOfRows=900&MobileApp=AppTest&MobileOS=ETC&arrange=B&cat1=&contentTypeId=12&listYN=Y").get();
			Elements all = doc.select("item");
			Elements el = doc.getElementsByAttribute("firstimage");
			
//			Elements row = doc.select("item");
//			for(Element row2 : row){
//				Iterator<Element> it = row2.getElementsByTag("title").iterator();
//				while(it.hasNext()) {
//					String title = it.next().text();
//					System.out.println(title);
//					}
//				} 
			Elements eltitle = all.select("title");
			Elements eladdress = all.select("addr1");
			Elements elfirstImg = all.select("firstimage");
			Elements elsecondImg = all.select("firstimage2");
			Elements elmapX = all.select("mapx");
			Elements elmapY = all.select("mapy");
			
			for(int i=0; i<800; i++) {
				
				String htmlTmp = all.get(i).html();
				if (!(htmlTmp.contains("firstimage"))) {
					Element elImg = new Element("firstimage");
					elfirstImg.add(i, elImg);
					System.out.println("noimage");
				}
				if (!(htmlTmp.contains("firstimage2"))) {
					Element elImg = new Element("firstimage2");
					elsecondImg.add(i, elImg);
					System.out.println("noimage2");
				}
				
				String title = eltitle.get(i).text();
				String address = eladdress.get(i).text();
				String firstImg = elfirstImg.get(i).text();
				String secondImg = elsecondImg.get(i).text();
				String mapX = elmapX.get(i).text();
				String mapY = elmapY.get(i).text();
				
				
				System.out.println("��ȣ : " + (i+1));
				
				DesDataDTO dto = new DesDataDTO();
				dto.setDestinationTitle(title);
				dto.setDestinationAddress(address);
				dto.setDestinationFirstImg(firstImg);
				dto.setDestinationSecondImg(secondImg);
				dto.setDestinationMapX(mapX);
				dto.setDestinationMapY(mapY);
				
				
				System.out.println(dto.getDestinationTitle());
				System.out.println(dto.getDestinationAddress());
				System.out.println(dto.getDestinationFirstImg());
				System.out.println(dto.getDestinationSecondImg());
				System.out.println(dto.getDestinationMapX());
				System.out.println(dto.getDestinationMapY());
				mapper.insert(dto);
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}