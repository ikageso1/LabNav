var xmlHttpRequest2;

function receive2() {
  if(xmlHttpRequest2.readyState == 4 && xmlHttpRequest2.status == 200) {
      //console.log(xmlHttpRequest.responseText);   
      var response = eval("(" + xmlHttpRequest2.responseText + ")");
      
      var loginState = response.login;
			if(loginState == "false"){
				location.href = "./loginfalse.html";
			}
  }
}

window.addEventListener("load", function() {
	var url = "ConfirmLoginServlet";
	xmlHttpRequest2 = new XMLHttpRequest();
	xmlHttpRequest2.onreadystatechange = receive2;
	xmlHttpRequest2.open("GET", url, true);
	xmlHttpRequest2.send(null);
}, false);
