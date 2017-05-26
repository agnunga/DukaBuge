<%@page import="com.ag.model.other.Author"%>
<%@page import="com.ag.model.Catalog"%>
<%@page import="java.util.List"%>
<%@page import="com.ag.model.other.Publisher"%>
<form action="add_book" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-sm-3">Book Title: </label>
        <div class="col-sm-9">
            <input type="text" name="title" class="form-control"/>
        </div><!-- End of col-sm-9 -->
    </div><!-- End of form group -->
    <div class="form-group">
        <label class="control-label col-sm-3">ISBN Number: </label>
        <div class="col-sm-9">
            <input type="text" name="isbn" class="form-control"/>
        </div><!-- End of col-sm-9 -->
    </div><!-- End of form group -->
    <div class="form-group">
        <label class="control-label col-sm-3">Description: </label>
        <div class="col-sm-9">
            <input type="text" name="description" class="form-control"/>
        </div><!-- End of col-sm-9 -->
    </div><!-- End of form group -->
    <div class="form-group">
        <label class="control-label col-sm-3"></label>
        <div class="col-sm-9">
            <select class="form-control" name="author">
                <option>Select Author</option>
                <%
                    List<Author> a_list = (List<Author>) request.getAttribute("authors");
                    for (Author a : a_list) {
                %>
                <option value="<%=a.getId()%>"><%=a.getName()%></option>
                <% } %>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3"></label>
        <div class="col-sm-9">
            <select class="form-control" name="catalog">
                <option>Select Category</option>
                <%
                    List<Catalog> catalogs = (List) request.getAttribute("catalogs");
                    for (Catalog c : catalogs) {
                %>
                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <% } %>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3"></label>
        <div class="col-sm-9">
            <select class="form-control" name="publisher">
                <option>Select Publisher</option>
                <%
                    List<Publisher> p_list = (List<Publisher>) request.getAttribute("publishers");
                    for (Publisher p : p_list) {
                %>
                <option value="<%=p.getId()%>"><%=p.getName()%></option>
                <% }%>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-3">Publication Date: </label>
        <div class="col-sm-9">
            <input type="text" name="pdate" class="form-control"/>
        </div><!-- End of col-sm-9 -->
    </div><!-- End of form group -->
    <div class="form-group">
        <label class="control-label col-sm-3"></label>
        <div class="col-sm-9">
            <input type="submit"value="Add Book"class="btn pull-right"style="background-color: #1b6d85;color: white;"/>
        </div><!-- End of col-sm-9 -->
    </div><!-- End of form group -->
</form>
