
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulter</title>
<link rel="stylesheet" href="bootstrap/3.3.7/css/bootstrap.min.css">
<script src="ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
		margin-top : 250px;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body>
<div class="login-form">
    <form action="searchDate" method="get">
        <h2 class="text-center">Consulter la meteo du:</h2>       
        
            Jour<select name="jour" >
		<%for (int i = 1;i<31;i++){
			%> <option> <%=i%>
		<%}%>
		</select>
       
        
             Mois<select name="mois" >
		<%for (int j = 1;j<13;j++){
			%> <option> <%=j%>
		<%}%>
		</select>
        
		
             Annee<select name="annee" >
		<%for (int k = 2019;k<2021;k++){
			%> <option> <%=k%>
		<%}%>
		</select><hr>
        
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Consulter</button>
        </div>
            
    </form>
    <p class="text-center"><a href="index.jsp">Retour a la page de connection</a></p>
</div>
</body>
</html>                                		                            