<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="templates/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="templates/navbar.jsp"></c:import>
<form:form class="form-horizontal" action="send" commandName="mailDetails" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Send Mail To Member</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Text Input</label>
  <div class="controls">
    <form:input path="mailTo" placeholder="To" class="input-large" />
    <p class="help-block">help</p>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="subject">Subject:</label>
  <div class="controls">
  
    <form:input path="mailSubject" placeholder="Subject" class="input-xlarge" />
    <p class="help-block">help</p>
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="message">Message:</label>
  <div class="controls">                     
    <form:textarea path="mailMessage"/>
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="send"></label>
  <div class="controls">
    <button id="send" name="send" class="btn btn-inverse" type="submit">Send</button>
  </div>
</div>

</fieldset>
</form:form>

</body>
<c:import url="templates/javascripts.jsp"></c:import>
</html>