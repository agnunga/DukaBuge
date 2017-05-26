<%@page import="com.ag.beanI.BookBeanI"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.ag.model.Book"%>
<%@page import="java.util.List"%>
<jsp:include page="./assets/header.jsp"/> 
<jsp:include page="./assets/message.jsp"/> 
<div class="row">
    <div class="col-md-3">
        <jsp:include page="./assets/category_nav.jsp"/>
    </div>
    <div class="col-md-9">
        <jsp:include page="./tables/displayBooks.jsp"/>
    </div>
</div>
<jsp:include page="./assets/footer.jsp"/>