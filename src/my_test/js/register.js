function register_func(){
	var userId = $("#userId").val();
	var password = $("#password").val();
	var email = $("#mail").val();
 
	var url = "/project/LoginServlet";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("POST", url, true);
	xmlHttpRequest.send(userId);
	xmlHttpRequest.send(password);
	xmlHttpRequest.send(email);
}

function receive() {
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		//console.log(xmlHttpRequest.responseText);   
		var response = eval("(" + xmlHttpRequest.responseText + ")");
		var answerElement = document.getElementById("output");
		answerElement.innerHTML = response.answer;
		if(response. == "false"){
			var errlog = "<div class='alert alert-danger' role='alert'>";
			errlog += "Error: Your login information is incorrect.";
			errlog +=  "</div>";

		}
	}
}

$("#register").click(register_func);

