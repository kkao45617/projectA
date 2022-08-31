var tv= new Object();
    tv.color="white";
    tv.price=3000;
    tv.info=function(){
        document.write("tv색상 : "+this.color,"<br>");
        document.write("tv 가격 : "+this.price,"<br>");
    
    };
    var car ={
        color:"black",
        price:5000,
        info:function(){
            document.write("차색상 : "+this.color,"<br>");
            document.write("차가격 : "+this.price,"<br>");
        }
    };

    tv.info();
    car.info();
    car.test ="test";

    document.write(car.test);
    var d1 = new Array();
    d1[0]=30;
    d1[1]="따르릉";
    d1[2]=true;

    var d2 = new Array(30,"따르릉",true);

    var d3 = [30,"따르릉",true];

    for(let i=0; i<d1.length; i++){
        document.write(d1[i]+",");
    }
    document.write("<br>");

    for(i in d2){
        document.write(d2[i]+",");
    }
    document.write("<hr>");

    let arr_1 = new Array("사당","살려줘","배고파","옥수수","초당");
    let arr_2 = new Array("사탕","따짜","마셔","마셔","죽어","먹고")

    result = arr_1.shift();
    console.log("밀었을때 : "+result);
    console.log("arr_1 : "+arr_1)

    console.log(arr_1);
    var result = arr_1.join("-");
    console.log(result);

    result = arr_1.concat(arr_2);
    console.log(result);

    function foo(){
        var str="hello";
        if(true){
            var str="bye";
            console.log(str);
        }
        console.log(str);
    }
    foo();