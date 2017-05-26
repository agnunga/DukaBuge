<jsp:include page="./assets/header.jsp"/> 
<jsp:include page="./assets/message.jsp"/> 
<%if (session.getAttribute("user_c") == null) {
        out.print("To place an order, you must be logged in.");
    }%>
<jsp:include page="./tables/viewCartTable.jsp"/>
<jsp:include page="./assets/footer.jsp"/>