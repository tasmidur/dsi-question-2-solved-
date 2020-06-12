<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div class="wrapper fadeInDown">
<div id="formContent">
    <div class="fadeIn first">
        Sign In
    </div>
    <form id="loginform">
        <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="Username" value="admin@admin.com">
        <p id="user-error"></p>
        <input type="text" id="password" class="fadeIn third" name="password" placeholder="password" value="123456789">
        <p id="pass-error"></p>
        <input type="button" class="fadeIn fourth" id="signinbtn" value="Log In">
    </form>
</div>
</div>
<script>
    $(document).ready(function () {
        $("#user-error").hide();
        $("#pass-error").hide();
        $("#status-msg").hide();


        $("#signinbtn").click(function () {
            let username=$("#userName").val();
            let password=$("#password").val();
            if(validateUser(username)&&password!==""){
                $.ajax({
                    url:"/",
                    method:"POST",
                    data:{
                        username:username,
                        password:password
                    },
                    beforeSend: function() {
                        $("#signinbtn").val("Processing....");
                    },
                    success:function (res) {
                        $("#signinbtn").val("Log In");

                        if(res){
                            window.location.href="/success"

                        }else{
                            window.location.href="/not-success"

                        }
                    }
                })
            }else{
                if(password===""){
                    error_msg("pass-error");
                }
                if(!validateUser(username)){
                    error_msg("user-error");
                }
                if(password===""&& !validateUser(username)){
                    error_msg("user-error");
                    error_msg("pass-error");
                }
            }


        });


    });
    function validateUser(user) {
        var userReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return ( user.length > 0 && userReg.test(user));
    }
    function error_msg(id) {
        let error_msg="";
        if(id==="pass-error"){
            error_msg="Enter Valid Password";
        }
        if(id==="user-error"){
            error_msg="Enter Valid Username";
        }
        $("#"+id).text(error_msg);
        $("#"+id).show();
        setTimeout(function () {
            $("#"+id).hide();
        },5000);
    }
</script>
</body>
</html>




