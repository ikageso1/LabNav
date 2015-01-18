function addList(){
	var labElement = document.getElementById("labList");
	var isAssigned = document.getElementById("assigned").checked;
	var i;
	if(isAssigned){
		var labList = ["自然言語処理研究室","交通情報学研究室","知能情報基礎研究室"];
	
		var str = "<label class='col-sm-2 control-label'></label>"
			+ "<div class='col-sm-10'>"
		  + "<select class='form-control' name='assignedLab'>";
		for( i=0;i<labList.length;i++){
			str += "<option value="+String(i)+">"+labList[i]+"</option>";
		}
		 str += "</select>" + "</div>";
	   labElement.innerHTML = str;
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
