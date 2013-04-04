<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<script>
	var shortName = '<c:out value="${item.shortName}"></c:out>';
	var large = '<c:out value="${item.price.large}"></c:out>';
</script>

<script type="text/javascript" src="js/orderJson.js"></script>