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

  }
}

window.addEventListener("load", function() {
	var url = "RankingServlet";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("GET", url, true);
	xmlHttpRequest.send(null);
}, false);
