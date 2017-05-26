<%@page import="com.ag.model.Order"%>
<%@page import="com.ag.model.Book"%>
<%@page import="com.ag.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<div class="col-xs-12"> 
    <div class="box-body">
        <%if (request.getAttribute("data") != null) {
                Order order = (Order) request.getAttribute("data");
                User user = order.getUser();
                List<Book> books = order.getBooks();
                int i = 0;
        %>

        <h3>Order ID : <%=order.getId()%></h3>
        <h3>Customer Name : <%=user.getName()%></h3>
        <h3>Order Total : <%=order.getAmount()%></h3>
        <h3>Order Status : <%=order.getStatus()%></h3>

        <%
            if (request.getAttribute("data_orderedBooks") != null) {
                books = (List) request.getAttribute("data_orderedBooks");
            }
            if (!books.isEmpty()) {
        %>
        <h2>Ordered Books</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr> 
                    <th>Title</th>
                    <th>Author</th>
                    <th>ISBN</th>
                    <th>Price</th> 
                </tr>
            </thead>
            <tbody>  
                <%
                    Iterator<Book> iterator = books.iterator();
                    while (iterator.hasNext()) {
                        Book book = iterator.next();
                %>
                <tr>
                    <td><%=book.getTitle()%></td>
                    <td><%=book.getAuthor()%></td>
                    <td><%=book.getISBN()%></td>
                    <td><%=book.getPrice()%></td> 
                 </tr>
                <%
                        i++;
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                </tr>
            </tfoot>
        </table>
        <%
        } else {
        %>
        Books list empty!
        <%
            }
        } else { %>
        No data!
        <% }%>
    </div>
    <div style="text-align: center;">
        <a style="float: right;">
            <form action="./checkout" method="POST"> 
                <input type="submit" value="Check Out" name="submit" class="btn btn-danger btn-xs icon-trash">                                
            </form> 
        </a>
    </div>
</div>
