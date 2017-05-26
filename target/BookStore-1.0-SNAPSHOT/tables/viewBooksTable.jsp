<%@page import="com.ag.model.Catalog"%>
<%@page import="com.ag.model.Book"%> 
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
                    <th>Publisher</th> 
                    <th>Price</th> 
                    <th>Edition</th> 
                    <th>Catalog</th> 
                    <th>Status</th> 
                    <th>Description</th>  
                </tr>
            </thead>
            <tbody>  
                <%
                    List<Book> books = (List) request.getAttribute("data");
                    if (books == null || books.size() < 1) {
                        out.print(" Null eb");
                    } else {
                        Iterator<Book> iterator = books.iterator();
                        while (iterator.hasNext()) {
                            Book book = iterator.next();
                            Catalog catalog = book.getCatalog();
                %>
                <tr>
                    <td><%=book.getTitle()%></td> 
                    <td><%=book.getAuthor()%></td> 
                    <td><%=book.getISBN()%></td> 
                    <td><%=book.getPublisher()%></td> 
                    <td><%=book.getPrice()%></td> 
                    <td><%=book.getEdition()%></td> 
                    <td><%= catalog.getName()%></td> 
                    <td><%=book.getStatus()%></td> 
                    <td><%=book.getDescription()%></td> 
                    <td>
                        <a>
                            <form action="shop" method="POST">
                                <input type="hidden" name="id" value="<%=book.getId()%>">
                                <input type="submit" value="Add to cart" name="submit" class="fa fa-shopping-cart">
                            </form>
                        </a>
                    </td>
                    <td>
                        <a>
                            <form action="shop" method="POST">
                                <input type="hidden" name="id" value="<%=book.getId()%>">
                                <input type="submit" value="Add to cart" name="submit" class="fa fa-shopping-cart">
                            </form>
                        </a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                </tr>
            </tfoot>
        </table>
    </div>
</div>
