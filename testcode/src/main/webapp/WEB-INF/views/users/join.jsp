<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="/resources/js/login.find.join.js"></script>
<style type="text/css">
* {
   font-family: 'yg-jalnan', cursive
}
@font-face {
   font-family: 'yg-jalnan';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}
body {
   background-color: #f5f6f7;
}
select {
   width: 85px;
   height: 25px;
   outline: none;
   background: #f5f6f7;
   border: 1px solid #999;
}
a {
   color: black;
   text-decoration: none;
}
.main {
   text-align: center;
   margin-top: 20px;
}
input {
   cursor: pointer
}
/*회원가입 부분*/
.main-signup {
   text-align: center;
   width: 360px;
   margin: auto;
}
.overLap {
   text-align: center;
   width: 90px;
   border-radius: 10px;
   border: solid 1px #dadada;
   float:right;
   margin-top: 5px;
   cursor: pointer;
   background-color: #337ab7;
   color: #fff;
}
h3 {
   margin: 10px 0px 8px;
   text-align: left;
   font-size: 14px;
}
.signup-input {
   display: flex;
   /* margin: 0px 10px 8px 10px; */
   padding: 5px;
   border: solid 1px #dadada;
   background: #fff;
   cursor: pointer;
   border-radius: 15px;
}
.signup-input-c {
   display: flex;
   /* margin: 0px 10px 8px 10px; */
   padding: 5px;
   border: solid 1px #dadada;
   background: #f5f6f7;
   cursor: pointer;
}
.signup-input-c input {
   background: #f5f6f7;
}
#signup-id, #signup-pw, #signup-pww {
   height: 25px;
   border: none;
   outline: none;
   width: 100%;
}
.signup-at {
   color: rgb(150, 150, 150);
   font-size: 15px;
   margin-top: 8px;
}
.signup-input-birth {
   display: block;
   position: relative;
   width: 100%;
   height: 40px;
   border: solid 1px #dadada;
   padding: 5px;
   background: #fff;
   box-sizing: border-box;
   border-radius: 15px;
}
#signup-birth-yy, #signup-birth-mm, #signup-birth-dd {
   width: 90px;
   height: 25px;
   border: none;
   outline: none;
}
#checkquestion {
   width: 200px;
   height: 40px;
   border: 1px solid #dadada;
   outline: none;
   float: left;
   background-color: white;
   border-radius: 15px;
}
#signup-name, #signup-nickname, #signup-gender, #signup-email,
   #signup-phone, #signup-answer {
   width: 100%;
   height: 25px;
   border: none;
   outline: none;
}
#signup-gender {
   background-color: white;
}
#signup-birth-mm {
   background-color: white;
}
.choice span {
   margin-top: 20px;
   color: rgb(150, 150, 150);
   font-size: 13px;
}
/*회원가입버튼*/
#signup-btn {
   margin: 20px 0px 40px 0px;
   width: 360px;
   line-height: 55px;
   height: 55px;
   background-color: #337ab7;
   border: none;
   color: #fff;
   font-size: 18px;
   outline: none;
   cursor: pointer;
   border-radius: 15px;
}
</style>
<link rel="stylesheet" href="/resources/style.css">
<script src="/resources/js/login.js"></script>

</head>

<body>
   <div class="main-signup">
      <!--웹페이지 상단-->
      <header>
         <!--LOGO-->
         <h2>
            <a href="/home.do">여행가기 좋은 날</a>
         </h2>
      </header>

      <!--회원가입 부분-->
      <form method="post" action="join.do" name="joinfrm">
         <section class="signup-wrap">

            <div>
               <!--아이디,비번,비번재확인-->

               <h3>&nbsp;아이디</h3>
               <span class="signup-input"> 
               <input id="signup-id" name="userId" type="text"></input> 
               <input id="reid" name="reid" type="hidden"></input> 
               <span class="signup-at"></span>
               </span>
               <button class="overLap" type="button" onclick="idCheck()" name="checkId" class="checkId">중복확인</button>

               <h3>&nbsp;비밀번호</h3>
               <span class="signup-input"> <input id="signup-pw"
                  name="userPass" type="password"></input> <span class="pw-lock"></span>
               </span>

               <h3>&nbsp;비밀번호 재확인</h3>
               <span class="signup-input"> <input id="signup-pww"
                  name="signPass" type="password"></input> <span class="pww-lock"></span>
               </span>

            </div>

            <div style="margin-top: 10px;">
               <!--이름,생년월일,성별,이메일-->
               <h3>&nbsp;이름</h3>
               <span class="signup-input"> <input id="signup-name"
                  name="userName" type="text"></input>
               </span>
               <h3>&nbsp;닉네임</h3>
               <span class="signup-input"> 
               	<input id="signup-nickname" name="nickName" type="text">
               </span>
               <h3>&nbsp;이메일</h3>
               <span class="signup-input"> <input id="signup-email"
                  name="email" type="text"></input>
               </span>
               <h3>&nbsp;생년월일</h3>
               <span style="display: flex;"> <span
                  class="signup-input-birth"> <input id="signup-birth-yy"
                     name="birth" type="text" placeholder="년(4자)"></input>
               </span> <span class="signup-input-birth" style="margin-left: 10px;">
                     <select id="signup-birth-mm" class="selectbox" name="birth"
                     onchange="">
                        <option value="month">월</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                  </select>
               </span> <span class="signup-input-birth" style="margin-left: 10px;">
                     <input id="signup-birth-dd" name="birth" type="text"
                     placeholder="일"></input>
               </span>
               </span>

               <h3>&nbsp;성별</h3>
               <span class="signup-input"> <select id="signup-gender"
                  class="selectbox" name="gender" onchange="">
                     <option value="gender">성별</option>
                     <option value="남성">남자</option>
                     <option value="여성">여자</option>
               </select>
               </span>
               <div style="margin-top: 10px;">
                  <!--전화번호-->
                  <h3>&nbsp;전화번호</h3>
                  <div style="display: flex;">
                     <span class="signup-input"
                        style="width: 100%; margin: 10px 0px 0px 0px"> <input
                        id="signup-phone" name="phone" type="text" placeholder="전화번호 입력"></input>
                     </span>
                  </div>
               </div>
               <span class="choice">
                  <h3>&nbsp;본인 확인 질문</h3> <select id="checkquestion"
                  class="selectbox" name="question"">
                     <option value="select">&nbsp;질문을 선택하세요.</option>
                     <option value="초등학교">&nbsp;초등학교 이름은?</option>
                     <option value="중학교">&nbsp;중학교 이름은?</option>
                     <option value="고등학교">&nbsp;고등학교 이름은?</option>
                     <option value="첫 휴대전화">&nbsp;처음 산 휴대전화 기종은?</option>
                     <option value="첫 자동차">&nbsp;처음 산 자동차 기종은?</option>
                     <option value="다시 태어난다면">&nbsp;다시 태어난다면?</option>
               </select>
               </span> <span class="signup-input"> <input id="signup-answer"
                  name="answer" type="text" placeholder="본인 확인 질문"></input>
               </span>
            </div>
            <!--가입하기-->
            <input type="submit" id="signup-btn" value="회원가입"
               onclick="return checkJoin()">
         </section>
      </form>
   </div>
</body>
</html>