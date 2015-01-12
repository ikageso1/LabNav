$("#aid").text('半角英数で入力してください。');
var pass = $(':password[name="password"]').val();
var repass = $(':password[name="password"]').val();
var mail = $(':text[name="mail"]').val();
var remail = $(':text[name="remail"]').val();
	
jQuery("#userId input:text").on('click blur keydown keyup keypress change',function(){
    var userid = $(':text[name="userId"]').val();
    if(userid.match(/[^0-9A-Za-z]+/)){
	$("#alertid").text('半角英数で入力してください。');
    }else{
	$("#alertid").text('おｋ');
    }
});