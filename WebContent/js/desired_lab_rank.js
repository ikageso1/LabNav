<<<<<<< HEAD
var xmlHttpRequest1;
var xmlHttpRequest2;

function receive1() {
  if(xmlHttpRequest1.readyState == 4 && xmlHttpRequest1.status == 200) {
      //console.log(xmlHttpRequest.responseText);   
      var response = eval("(" + xmlHttpRequest1.responseText + ")");
      
      var loginState = response.login;
			if(loginState == "false"){
				location.href = "./loginfalse.html";
			}
  }
}


function receive2() {
  if(xmlHttpRequest2.readyState == 4 && xmlHttpRequest2.status == 200) {
      //console.log(xmlHttpRequest.responseText);   
      var response = eval("(" + xmlHttpRequest2.responseText + ")");
    
      var rateFirstElement = document.getElementById("rate_first");
      rateFirstElement.innerHTML = "<a href='"+ response.url1+"'>" + response.labName1 + "</a>";
			var firstImageElement = document.getElementById("first_img");
			firstImageElement.innerHTML = "<img alt='' src='"+ response.imageURL1+"'/>";
			var rateFirstElement2 = document.getElementById("rate_second");
      rateFirstElement2.innerHTML = "<a href='"+ response.url2+"'>" + response.labName2 + "</a>";
			var firstImageElement2 = document.getElementById("second_img");
			firstImageElement2.innerHTML = "<img alt='' src='"+ response.imageURL2+"'/>";
			var rateFirstElement3 = document.getElementById("rate_third");
      rateFirstElement3.innerHTML = "<a href='"+ response.url3+"'>" + response.labName3 + "</a>";
			var firstImageElement3 = document.getElementById("third_img");
			firstImageElement3.innerHTML = "<img alt='' src='"+ response.imageURL3+"'/>";
=======
var xmlHttpRequest;

function receive() {
  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
      //console.log(xmlHttpRequest.responseText);   
      var response = eval("(" + xmlHttpRequest.responseText + ")");
    
   
      var rateFirstElement = document.getElementById("rate_first");
      rateFirstElement.innerHTML = "<a href='"+ response.url+"'>" + response.labName + "</a>";
			var firstImageElement = document.getElementById("first_img");
			alert(response.labName);
			firstImageElement.innerHTML = "<img alt='' src='"+ response.imageURL+"'/>";

>>>>>>> FETCH_HEAD
  }
}

window.addEventListener("load", function() {
<<<<<<< HEAD
	var url = "ConfirmLoginServlet";
	xmlHttpRequest1 = new XMLHttpRequest();
	xmlHttpRequest1.onreadystatechange = receive1;
	xmlHttpRequest1.open("GET", url, true);
	xmlHttpRequest1.send(null); 

	var url = "RankingServlet";
	xmlHttpRequest2 = new XMLHttpRequest();
	xmlHttpRequest2.onreadystatechange = receive2;
	xmlHttpRequest2.open("GET", url, true);
	xmlHttpRequest2.send(null);
=======
	var url = "RankingServlet";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("GET", url, true);
	xmlHttpRequest.send(null);
>>>>>>> FETCH_HEAD
}, false);
