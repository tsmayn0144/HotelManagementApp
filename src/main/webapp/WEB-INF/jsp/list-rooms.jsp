<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your rooms are</caption>
			<thead>
				<tr>
					<th>Room name</th>
					<th>A/C</th>
					<th>Creation date</th>
					<th>Is it available?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rooms}" var="room">
					<tr>
						<td>${room.roomName}</td>
						<td>${room.ac}</td>
						<td><fmt:formatDate value="${room.creationDate}" pattern="dd/MM/yyyy"/></td>
						<td>${room.available}</td>
						<td><a type="button" class="btn btn-success" href="/update-room?id=${room.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-room?id=${room.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<a class="button" href="/add-room">Add a room</a>
		</div>
	</div>
	
<%@ include file="common/footer.jspf" %>