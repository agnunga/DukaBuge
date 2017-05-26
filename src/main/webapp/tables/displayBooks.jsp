<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.ag.model.Book"%> 

<div class="row">  
    <%if (request.getAttribute("data") != null) {

            List<Book> books = (List) request.getAttribute("data");
            Iterator<Book> i = books.iterator();
            while (i.hasNext()) {
                Book b = i.next();
    %>
    <div class="col-sm-3">
        <div  style="text-align: center; margin: 0px 5px 50px 5px; border: 1px solid grey; border-radius: 5px; padding: 10px;">
            <img src="images/home/product1.jpg" height="150" width="auto" alt="Image Loading..." />
            <h2>KSH <%=b.getPrice()%></h2>
            <h5>Name: <%=b.getTitle()%></h5>
            <h6>Author: <%=b.getAuthor()%></h6> 
            <a>
                <form action="shop" method="POST">
                    <input type="hidden" name="id" value="<%=b.getId()%>">
                    <input type="submit" value="Add to cart" name="submit" class="fa fa-shopping-cart">
                </form>
            </a>
        </div>
    </div>
    <%
        }
    } else {
    %>
    No books
    <%
        }
    %>
</div> 

