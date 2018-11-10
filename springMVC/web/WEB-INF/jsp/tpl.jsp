<html>
<head>
    <title>in.html</title>
</head>
<body>

<h1>template.html</h1>

<h2>test binding map</h2>
<form action="/obj">

    <input type="text" name="obj.a"><br>
    <input type="text" name="obj.b"><br>
    <input type="text" name="obj.c"><br>

    <button>提交</button>

</form>

<hr>

<form action="/list" method="post">
    <input type="text" name="list[0]">
    <input type="text" name="list[0]">
    <input type="text" name="list[0]">
    <button>submit</button>
</form>

<hr>

<form action="/list2" method="post">
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
        </tfoot>
        <tbody>
        <tr>
            <td><input name="users[0].firstName" value="aaa" /></td>
            <td><input name="users[0].lastName" value="bbb" /></td>
        </tr>
        <tr>
            <td><input name="users[1].firstName" value="ccc" /></td>
            <td><input name="users[1].lastName" value="ddd" /></td>
        </tr>
        <tr>
            <td><input name="users[2].firstName" value="eee" /></td>
            <td><input name="users[2].lastName" value="fff" /></td>
        </tr>
        </tbody>
    </table>
    <button>submit</button>
</form>

</body>
</html>
