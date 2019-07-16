<%@page import = "controller.*,DAO.*,service.*,model.*"%>
<%@page import = "java.sql.Timestamp" %>

    <% Timestamp dt = (Timestamp) request.getAttribute("date");%>   
	<% Region[] regs = (Region[]) request.getAttribute("regs");%>
    <% Prevision[] prevs = (Prevision[]) request.getAttribute("prevs");
		if(prevs.length==0){
			out.println("aucun resultat");
		}else{
			%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Results</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-1 sidenav">
      <br><h4>Meteorologie</h4><br>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="searchPrevDate.jsp">Home</a></li>
       
      </ul><br>
      
    </div>

    <div class="col-sm-9">
	<h1>Les previsions pour la journee du <%=dt.toString()%> </h1><br>			
		<%}%> 
       
		
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">temperature max.(C)</th>
									<th class="cell100 column2">temperature min.(C)</th>
									<th class="cell100 column3">temperature moyenne(C)</th>
									<th class="cell100 column4">matin</th>
									<th class="cell100 column5">apres-midi</th>
									<th class="cell100 column6">region</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
						<%
							PrevisionDAO pdao = new PrevisionDAO();
						%>
						<% for(int i=0;i<prevs.length;i++){
								String[] desc = pdao.split(prevs[i].getDescPrevision(),":");
						%>
							<tbody>
								<tr class="row100 body">
									<td class="cell100 column1"><span class="label label-danger"><% out.println(prevs[i].getTempMax()); %></span></td>
									<td class="cell100 column2"><span class="label label-primary"><% out.println(prevs[i].getTempMin()); %></span></td>
									<td class="cell100 column3"><span class="badge"><% out.println((prevs[i].getTempMax()-prevs[i].getTempMin())/2); %></span></td>
									<td class="cell100 column4"><span class="badge"><% out.println(desc[1]); %></span></td>
									<td class="cell100 column5"><span class="badge"><% out.println(desc[3]); %></span></td>
									<td class="cell100 column6"><span class="badge"><% out.println(regs[i].getNomRegion()); %></span></td>	
								</tr>
						<%}%>
							</tbody>
						</table>
					</div>
				</div> 
			</div>
		
	
	</div>	  
   </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
			
		
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>

<!-- Mirrored from www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_blog&stacked=h by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 30 Sep 2017 14:29:08 GMT -->
</html>
