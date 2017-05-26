<%@page import="com.ag.model.Book"%>
<%@page import="com.ag.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<div class="col-xs-12"> 
    <div class="box-body">
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
                <%if (request.getAttribute("data") != null) {
                        List<Book> books = (List) request.getAttribute("data");
                        int i = 0;
                        if (books != null || !books.isEmpty()) {
                            Iterator<Book> iterator = books.iterator();
                            while (iterator.hasNext()) {
                                Book book = iterator.next();
                %>
                <tr>
                    <td><%=book.getTitle()%></td>
                    <td><%=book.getAuthor()%></td>
                    <td><%=book.getISBN()%></td>
                    <td><%=book.getPrice()%></td> 
                    <td>
                        <a>
                            <form action="./view_cart" method="POST">
                                <input type="hidden" name="id" value="<%=book.getId()%>">
                                <input type="hidden" name="index" value="<%=i%>">
                                <input type="submit" value="Remove" name="submit" class="btn btn-danger btn-xs icon-trash">                                
                            </form>
                        </a>
                    </td>
                </tr>
                <%
                        i++;
                    }
                } else {
                %>
                No record!
                <%
                    }
                } else {
                %>
                No data!
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                </tr>
            </tfoot>
        </table>
    </div>
    <div style="text-align: center;">
        <a style="float: right;">
            <form action="./checkout" method="POST"> 
                <input type="submit" value="Check Out" name="submit" class="btn btn-danger btn-xs icon-trash">                                
            </form> 
        </a>
    </div>
</div>
