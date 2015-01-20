var xmlHttpRequest;

function receive() {
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
	    var response = xmlHttpRequest.responseText;
		
	    var outputElement = document.getElementById("r");
	    outputElement.innerHTML = response;
	}
}

window.addEventListener("load", function(){
    var loc = location.href;
    var url =  ""; 
    xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = receive;
    xmlHttpRequest.open("POST",url , true);
    xmlHttpRequest.send(loc);
    receive();
},false);