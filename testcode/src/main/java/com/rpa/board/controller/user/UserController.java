package com.rpa.board.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpa.board.domain.UserVO;
import com.rpa.board.service.UserService;
import com.trip.api.KakaoProfile;
import com.trip.api.OAuthToken;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/users/*")
public class UserController {
	private UserService service;
	
	@GetMapping("login.do")
	public String loginView() {
		log.info("-------login Page---------");
		return "users/login";
	}
	
	@PostMapping("login.do")
	public String login(Model model, UserVO vo, HttpSession session) {
		log.info("-------login 실행---------");
		UserVO user = service.login(vo);
		log.info(user);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/home.do";
		}
		model.addAttribute("message", "잘못된 회원정보입니다.");
		return "users/login";
	}
	
	@GetMapping("join.do")
	public String joinView() {
		log.info("-------join Page---------");
		return "users/join";
	}
	
	@PostMapping("join.do")
	public String join(UserVO vo) {
		log.info("-------join---------");
		log.info(vo.getUserName());
		String birth = vo.getBirth();
		log.info(birth);
		birth = birth.replace(",", "");
		log.info(birth);
		if(birth.length() < 8) {
			birth = birth.substring(0, 6) + 0 + birth.substring(6);
			log.info(birth);
			vo.setBirth(birth);
		}
		vo.setBirth(birth);
		service.register(vo);
		log.info("-------- user insert ------------");
		return "redirect:/users/login.do";
	}
	
	@RequestMapping("idFind.do")
	public String idFindView() {
		log.info("-------idFind Page---------");
		return "users/idFind";
	}
	
	@GetMapping("idFindList.do")
	public String idFind(Model model, UserVO vo) {
		log.info("------- idFind ---------");
		List<UserVO> list = service.idList(vo);
		log.info(list.isEmpty());
		
		model.addAttribute("list", list);
		
		if(list.isEmpty() == true) {
			model.addAttribute("list", null);
		}
		return "users/userIncludes/idFindList";
	}
	
	@RequestMapping("pwFind.do")
	public String pwFindView() {
		log.info("-------pwFind Page---------");
		return "users/pwFind";
	}
	
	@RequestMapping("passwordFind.do")
	public String pwFind(Model model, UserVO vo) {
		log.info("------- passwordFind ---------");
		UserVO user = service.findPassword(vo);
		UserVO rightId = service.getId(vo);
		
		model.addAttribute("user", user);
		model.addAttribute("id", rightId);
		
		return "users/userIncludes/findPassword";
	}
	
	
	@RequestMapping("list.do")
	public String list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getUserList());
		return "users/list";
	}
	
	@RequestMapping("mypage.do")
	public String mypage(Model model) {
		log.info("-------- mypage -----------");
		return "users/mypage";
	}
	
	@GetMapping("withdraw.do")
	public String withdraw(UserVO vo, HttpSession session) {
		log.info(vo.getUserNum());
		service.remove(vo.getUserNum());
		session.invalidate();
		return "redirect:/home.do";
	}
	@GetMapping("modify.do")
	public String modifyPage() {
		log.info("------ modifyPage ------");
		return "users/modify";
	}
	
	@PostMapping("modify.do")
	public String modify(UserVO vo, HttpSession session) {
		log.info(vo);
		service.modify(vo);
		
		UserVO user = service.get(vo.getUserNum());
		session.setAttribute("user", user);
		return "users/mypage";
	}
	
	@GetMapping("/kakaoLogin.do")
	public String kakaoCallback(String code, HttpSession session) {
		
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "accbd8d322bc5b0248a5ea6eb444cd28");
		params.add("redirect_uri", "http://localhost:8081/users/kakaoLogin.do");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				new HttpEntity<>(params ,headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
				ResponseEntity<String> response = rt.exchange(
						"https://kauth.kakao.com/oauth/token",
						HttpMethod.POST,
						kakaoTokenRequest,
						String.class
				);
				
				// Gson, Json Simple, ObjectMapper
				ObjectMapper objectMapper = new ObjectMapper();
				OAuthToken oauthToken = null;
				try {
					oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			
			RestTemplate rt2 = new RestTemplate();
			
			// HttpHeader 오브젝트 생성
			HttpHeaders headers2 = new HttpHeaders();
			headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
			headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
			HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = 
					new HttpEntity<>(headers2);
			
			// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
			ResponseEntity<String> response2 = rt2.exchange(
					"https://kapi.kakao.com/v2/user/me",
					HttpMethod.POST,
					kakaoProfileRequest2,
					String.class
			);
			System.out.println(response2.getBody());
			
			ObjectMapper objectMapper2 = new ObjectMapper();
			KakaoProfile kakaoProfile = null;
			try {
				kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			log.info("카카오 아이디(번호) : " + kakaoProfile.getId());
			log.info("이메일 : " + kakaoProfile.getKakao_account().getEmail());
			
			UserVO user = new UserVO();
			
			user.setUserId(kakaoProfile.getKakao_account().getEmail() + "_" +kakaoProfile.getId());
			user.setUserName(kakaoProfile.getProperties().getNickname());
			user.setEmail(kakaoProfile.getKakao_account().getEmail());
			user.setUserPass("kakaopass");
			user.setNickName(kakaoProfile.getProperties().getNickname());
			
			if(kakaoProfile.getKakao_account().getGender() == null) {
				user.setGender("비공개");
			} else if(kakaoProfile.getKakao_account().getGender().equals("female")) {
				user.setGender("여성");
			} else if(kakaoProfile.getKakao_account().getGender().equals("male")) {
				user.setGender("남성");
			}
			
			
			if (service.getId(user) == null) {
				service.registerToKakao(user);
			}
			
			user = service.login(user);
			
			session.setAttribute("user", user);
			
			log.info(user.getAdmin());
			
		return "redirect:/home.do";
	}
}