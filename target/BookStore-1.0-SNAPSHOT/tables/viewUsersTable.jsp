<%@page import="com.ag.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<div class="col-xs-12"> 
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr> 
                    <th>Name</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Role</th> 
                </tr>
            </thead>
            <tbody>  
                <%
                    List<User> users = (List) request.getAttribute("data");
                    if (users == null || users.size() < 1) {
                        out.print(" Null eb");
                    } else {
                        Iterator<User> iterator = users.iterator();
                        while (iterator.hasNext()) {
                            User user = iterator.next();
                %>
                <tr>
                    <td><%=user.getName()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getUsername()%></td>
                    <td><%=user.getRole()%></td>
                    <td>
                        <a href="update_employee?id=<%=user.getId()%>">
                            <button class="btn btn-warning btn-xs icon-edit">Edit</button>
                        </a>
                    </td>
                    <td>
                        <a href="delete_employee?id=<%=user.getId()%>">
                            <button class="btn btn-danger btn-xs icon-trash">Delete</button>
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
