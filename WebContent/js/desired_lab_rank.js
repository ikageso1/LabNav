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
			
			var popFirstElement = document.getElementById("pop_first");
      popFirstElement.innerHTML = "<a href='"+ response.pUrl1+"'>" + response.pLabName1 + "</a>";
			var popFirstImageElement = document.getElementById("pop_first_img");
			popFirstImageElement.innerHTML = "<img alt='' src='"+ response.pImageURL1+"'/>";
			var popFirstElement2 = document.getElementById("pop_second");
      popFirstElement2.innerHTML = "<a href='"+ response.pUrl2+"'>" + response.pLabName2 + "</a>";
			var popFirstImageElement2 = document.getElementById("pop_second_img");
			popFirstImageElement2.innerHTML = "<img alt='' src='"+ response.pImageURL2+"'/>";
			var popFirstElement3 = document.getElementById("pop_third");
      popFirstElement3.innerHTML = "<a href='"+ response.pUrl3+"'>" + response.pLabName3 + "</a>";
			var popFirstImageElement3 = document.getElementById("pop_third_img");
			popFirstImageElement3.innerHTML = "<img alt='' src='"+ response.pImageURL3+"'/>";

			var satiFirstElement = document.getElementById("sati_first");
      satiFirstElement.innerHTML = "<a href='"+ response.sUrl1+"'>" + response.sLabName1 + "</a>";
			var satiFirstImageElement = document.getElementById("sati_first_img");
			satiFirstImageElement.innerHTML = "<img alt='' src='"+ response.sImageURL1+"'/>";
			var satiFirstElement2 = document.getElementById("sati_second");
      satiFirstElement2.innerHTML = "<a href='"+ response.sUrl2+"'>" + response.sLabName2 + "</a>";
			var satiFirstImageElement2 = document.getElementById("sati_second_img");
			satiFirstImageElement2.innerHTML = "<img alt='' src='"+ response.sImageURL2+"'/>";
			var satiFirstElement3 = document.getElementById("sati_third");
      satiFirstElement3.innerHTML = "<a href='"+ response.sUrl3+"'>" + response.sLabName3 + "</a>";
			var satiFirstImageElement3 = document.getElementById("sati_third_img");
			satiFirstImageElement3.innerHTML = "<img alt='' src='"+ response.sImageURL3+"'/>";


  }
}

window.addEventListener("load", function() {
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
}, false);
