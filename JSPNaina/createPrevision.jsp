

<form action="insert" method="post">  
	idPrevision:<input type="text" name="idPrevision"/><br/><br/>  
	
	 
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
		</select>
		
	DescriptionPrevision:<input type="text" name="descPrevision"/><br/><br/>  
	
	tempMax<select name="tempMax" >
			<%for (int l = 0;l<41;l++){
				%> <option> <%=l%>
			<%}%>
			</select> 	
	
	tempMIN<select name="tempMin" >
			<%for (int d= 0;d<41;d++){
				%> <option> <%=d%>
			<%}%>
			</select> 	
	
	idRegion:<input type="text" name="idRegion"/><br/><br/>  
	
	<input type="submit" value="insert"/>
</form>  