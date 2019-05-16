$(function(){
    submit_form();
})

function submit_form(){
    alert("hi");
    var search = {};
    search["email"] = $('#exampleInputEmail1').val();
    $.ajax({
        type: 'POST',
        contentType:"application/json",
        url:"/loginSys/signup",
        data:JSON.stringify(search),
        dataType:'json',
        cache:false,
        timeout:6000,
        success: function(data){
            document.getElementById("error").innerHTML =
            data.msg;
        },
        error:function(e){
            document.getElementById("error").innerHTML =
                        data.msg;
        }
    })


}


