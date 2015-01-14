function addList(){
	var labElement = document.getElementById("labList");
	var isAssigned = document.getElementById("assigned").checked;
	var i;
	if(isAssigned){
		var labList = ["自然言語処理研究室","交通情報学研究室","知能情報基礎研究室"];
		var selectElement = document.createElement("select");
		for( i=0;i<labList.length;i++){
			selectElement.setAttribute("name","研究室"); 
			var inputElement = document.createElement("option");
			inputElement.setAttribute("value",String(i));
			inputElement.innerHTML = labList[i];
			selectElement.appendChild(inputElement);
		}
		labElement.appendChild(selectElement);
	}
	else{
		var child = labElement.childNodes;
		var i;
		for(i=0;i<child.length;i++){
			labElement.removeChild(child[i+1]);
		}
	}

}

window.addEventListener("load",function(){
				var check = document.getElementById("assigned");
				check.addEventListener("click",addList,false);
},false);
