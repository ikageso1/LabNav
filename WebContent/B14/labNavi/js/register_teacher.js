window.addEventListener("load",function(){
				var labElement = document.getElementById("lab");
				var i;
				var labList = ["自然言語処理研究室","交通情報学研究室","知能情報基礎研究室"];
				for( i=0;i<labList.length;i++){
					var inputElement = document.createElement("option");	
				  inputElement.setAttribute("value",String(i));
				  inputElement.innerHTML = labList[i];	
					labElement.appendChild(inputElement);
				}	
},false);
