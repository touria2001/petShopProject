
/*function order( ){
	
	document.getElementById("form-id").submit();
}*/

document.getElementById("id1").addEventListener("click", function (){
	document.getElementById("quant").value = document.getElementById("quantity").value;

	if(document.getElementById("orderUser").value.localeCompare("") == 0) {
		alert("you have to be connected");
	} else {
	document.getElementById("form-id").submit();	}
});


/*function GBP(e){	

	e.preventDefault();
 

	if(document.getElementById("devise").textContent == "$"){
		document.getElementById("devise").textContent= "GBP";
		var s = document.getElementById("total").textContent;
		var x = s/1.34;
		document.getElementById("total").textContent = Math.round(x * 100) / 100;
	}else if(document.getElementById("devise").textContent == "EUR"){
		document.getElementById("devise").textContent= "GBP";
		var s = document.getElementById("total").textContent;
		var x = s*0.84;
		document.getElementById("total").textContent = Math.round(x * 100) / 100;
	}else{
		
	}
}*/






