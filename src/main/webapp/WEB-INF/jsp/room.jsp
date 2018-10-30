<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<form:form method="post" modelAttribute="room">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="roomName">Room name</form:label>
			<form:input path="roomName" type="text" class="form-control" required="required" />
			<form:errors path="roomName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="ac">A/C</form:label>
			<form:input path="ac" type="text" class="form-control" required="required" />
			<form:errors path="ac" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="creationDate">Creation date</form:label>
			<form:input path="creationDate" type="text" class="form-control" required="required" />
			<form:errors path="creationDate" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="available">Is available</form:label>
			<form:input path="available" type="text" class="form-control" required="required" />
			<form:errors path="available" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">OK</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>