<div>
    <h1>New/Edit</h1>
    <form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="userForm">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form:hidden path="userId" />
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form:form>
</div>