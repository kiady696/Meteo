<%@page import = "controller.*,DAO.*,service.*,model.*"%>
<%@page import = "java.sql.Timestamp" %>

    <% Timestamp dt = (Timestamp) request.getAttribute("date");%>   
	<% Region[] regs = (Region[]) request.getAttribute("regs");%>
    <% Prevision[] prevs = (Prevision[]) request.getAttribute("prevs");
		if(prevs.length==0){
			out.println("aucun resultat");
		}else{
			%><td><h1>Les previsions pour la journee du <%=dt.toString()%> </h1></td>			
		<%}%> 

	
	
	<div>
		
						<table class="table table-striped">
							
							
							<% for(int i=0;i<prevs.length;i++){ %>
							<tr>
							
								<td><% out.println("tempMax: "+prevs[i].getTempMax()+" tempMin: "+prevs[i].getTempMin() );%> </td>
									
								<td><% out.println(" les previsions seront :"+prevs[i].getDescPrevision()); %></td>
								
								<td> <% out.println(" region :"+regs[i].getNomRegion()); %> </td>
								
							</tr>
							
									
							<% } %>
						</table>
	</div>
	
	