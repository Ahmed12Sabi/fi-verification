
<head>
  <title>${name}
</head>
<body>
  <h1>${name}</h1>
  <table class="table">
  	<thead>
  		<tr>
  			<th> Employee First Name</th>
  			<th> Employee Last Name</th>
  			<th> Employee Email</th>
  		</tr>
  	</thead>
  	<tbody>
  			<td th:text="${name}"></td>
  			<td th:text="${address}}"></td>
  			<td th:text="${mobile}}"></td>
  	</tbody>
  </table>
</body>
</html>