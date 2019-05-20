

$( document ).ready(function() {

	// SUBMIT FORM
    $("#userinfo").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});


    function ajaxPost(){

    	// PREPARE FORM DATA
    	var formData = {
    		email : $("#exampleInputEmail1").val(),
    		password :  $("#exampleInputPassword1").val()
    	}
    	alert(formData);
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "/signup",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

    	// Reset FormData after Posting
    	resetData();

    }

    function resetData(){
    	$("#exampleInputEmail1").val("");
    	$("#exampleInputPassword1").val("");
    }
})



