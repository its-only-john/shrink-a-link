$(document).ready(function() {
	$("button").click(function() {
	if($("#urlinput").val()!==""){
	$.ajax({
			type : 'POST',
			url : '/shortenurl',
			data : JSON.stringify({
				"full_url" : $("#urlinput").val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
			console.log(data);
				$("#shorturltext").html(data.short_url).attr("href", data.full_url).attr("target","_blank");
				 $("#short_show").css("display", "block");
			}
		});
	}else{alert("Full url must not be empty");}
		
	});
});