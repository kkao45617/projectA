var courseService = (function() {
		
    function like(num, callback, error) {
        console.log("likes...................");

        $.ajax({
            type:"patch",
            url:"/course/" + num,
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    } //end like
    
    function desList(num, callback, error){
        console.log("get...................");
        $.getJSON("/course/page/" + num + ".json",
            function(data){
                if(callback) {
                    callback(data);
                }
            }).fail(function(xhr, status, err){
                if(error) {
                    error(err);
                }
            });
    } //end for desList
    return {
        desList : desList,
        like : like
    }; // 함수를 객체로 만들어서 리턴
})();