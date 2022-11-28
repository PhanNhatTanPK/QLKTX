<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master-Layout"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<decorator:head />
</head>
<body>
	<!--Lower Header Section -->
	<div class="container">
		<div id="gototop"></div>
		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
		<decorator:body />
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
	</div>
	<!-- /container -->
</body>
</html>