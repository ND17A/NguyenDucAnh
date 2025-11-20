<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
    <h1>CD List</h1>
    <table>
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tr>
            <td>86 (the band) - True Life Songs and Pictures</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="productCode" value="86">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The first CD</td>
            <td>$12.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="productCode" value="pf01">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Paddlefoot - The second CD</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="productCode" value="pf02">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>Joe Rut - Genuine Wood Grained Finish</td>
            <td>$14.95</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="productCode" value="jr01">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>