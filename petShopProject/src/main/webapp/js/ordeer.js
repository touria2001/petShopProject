
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


function show() {
	alert(document.getElementById("image_productName").textContent);
		document.getElementById("image_productName").append("ffffffffffffffff");

	/*document.getElementById("image_productName").append("<span class=\"title_icon\"><img  src="+document.getElementById("image_specials").src+
	" alt=\"\" title=\"\" /></span>"+document.getElementById("productName_specials").textContent);
	document.getElementById("image_productName").append("ffffffffffffffff");*/
}