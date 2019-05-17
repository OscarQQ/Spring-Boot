$(function(){
    submit_form();
})

function submit_form(){
    var user = {
                "email" : $('#exampleInputEmail1').val(),
                "password" : $('exampleInputPassword1').val()
    		}
    var request = JSON.stringify(user);
    alert(request);
    $.ajax({
        type: 'POST',
        contentType:"application/json",
        url:"/loginSys/signup",
        data: JSON.stringify(user),
        dataType:"json",
        cache:false,
        timeout:6000,
        success: function(result){
            alert(result);
            if(result == "success"){
                alert("success");
                $("#error").css("color","green");
                $("#error").html("success");
            }else{
                alert("fail");
                $("#error").css("color","red");
                $("#error").html("fail");
            }

        },
        error:function(e){
           alert("exception");
        }
    })


}


