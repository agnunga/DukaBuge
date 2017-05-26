<%@page import="com.ag.type.OrderStatus"%>
<%@page import="com.ag.model.Order"%>
<%@page import="com.ag.model.Book"%>
<%@page import="com.ag.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<div class="col-xs-12"> 
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr> 
                    <th>ID</th>
                    <th>Customer</th>
                    <th>Total</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>  
                <%if (request.getAttribute("data") != null) {
                        List<Order> orders = (List) request.getAttribute("data");
                        int i = 0;
                        if (orders != null || !orders.isEmpty()) {
                            Iterator<Order> iterator = orders.iterator();
                            while (iterator.hasNext()) {
                                Order order = iterator.next();
                                User user = order.getUser();
                                String cancel = "";
                                if (order.getStatus() == OrderStatus.CANCELLED || order.getStatus() == OrderStatus.COMPLETED) {
                                    cancel = "disabled";
                                }
                %>
                <tr>
                    <td><%=order.getId()%></td>
                    <td><%=user.getName()%></td> 
                    <td><%=order.getAmount()%></td>
                    <td><%=order.getStatus()%></td>
                    <td>
                        <a>
                            <form action="./view_orders" method="POST">
                                <input type="hidden" name="id" value="<%=order.getId()%>">
                                <input type="hidden" name="index" value="<%=i%>">
                                <input type="submit" value="CANCEL" name="submit" class="btn btn-danger <%= cancel%>">                                
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
</div>
