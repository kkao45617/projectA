console.log('reply module...')

var replyservice=(function(){
    //실행할 함수 정의하는 공간...
    function add(reply,callback){
        console.log('reply.......');
    }
    return{add:add};//함수를 객체로 만들어서 리턴

})();