<%@ tag body-content="scriptless" %>
<%@ attribute name="color" required="true" %>
<%@ attribute name="size" required="true" %>
<div style="color:${color};font-size:${size}px">
<jsp:doBody />
</div>
