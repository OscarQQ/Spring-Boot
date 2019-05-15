window.onload = function(){
    var p = document.getElementById('error');

    document.getElementById("ajax").onclick = function(){

    var request = new XMLHttpRequest();
    var url = "assets/hello.txt";
    request.open("GET",url);
    request.send(null);

    request.onreadystatechange = function(){
        if(request.readyState == 4){
            if(request.status == 304 || request.status == 200)
                p.innerHTML = request.responseText;
        }
    }
    return false;

    }
}