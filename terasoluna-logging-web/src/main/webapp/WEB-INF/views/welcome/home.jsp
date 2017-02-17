<div id="wrapper">
    <h1>Hello world!</h1>
    <p>The time on the server is ${serverTime}.</p>
</div>
<div>
    <h3><a href="${pageContext.request.contextPath}/register">New User</a></h3>
    <table>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Address</th>

        <c:forEach var="user" items="${users}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/modify?userId=${user.userId}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/delete?userId=${user.userId}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>