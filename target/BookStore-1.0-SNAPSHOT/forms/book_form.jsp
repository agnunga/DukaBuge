<%@page import="com.ag.model.Catalog"%>
<%@page import="java.util.List"%>
<form class="well form-horizontal" action="add_book" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Add Book</legend>
        <div class="form-group">
            <label class="col-md-4 control-label">Catalog </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <select class="form-control" name="catalog">
                        <option>Select Catalog</option>
                        <%
                            List<Catalog> catalogs = (List) request.getAttribute("catalogs");
                            for (Catalog catalog : catalogs) {
                        %>
                        <option value="<%=catalog.getId()%>"><%=catalog.getName()%></option>
                        <% }%>
                    </select>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">ISBN </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="isbn" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Author </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="author" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Publisher </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="publisher" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Title </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="title" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Description </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="description" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Edition </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="edition" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Price </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="price" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning">
                    Add <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
