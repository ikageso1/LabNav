var xmlHttpRequest3;

function receive3() {
  if(xmlHttpRequest3.readyState == 4 && xmlHttpRequest3.status == 200) {
      //console.log(xmlHttpRequest.responseText);   
      var response = eval("(" + xmlHttpRequest3.responseText + ")");
      
      var loginState = response.login;
			if(loginState == "false"){
				location.href = "./loginfalse.html";
			}
  }

window.addEventListener("load", function() {
	var url = "GetAverageServlet";
	xmlHttpRequest3 = new XMLHttpRequest();
	var element = getElementById("labName");
	alert(element.value);
	xmlHttpRequest3.onreadystatechange = receive1;
	xmlHttpRequest3.open("GET", url, true);
	xmlHttpRequest3.send(null); 
}, false);
