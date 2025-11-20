<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/cart.css">
</head>
<body>
    <h1>Your cart</h1>

    <c:if test="${empty cart}">
        <p>Your cart is empty.</p>
    </c:if>

    <c:if test="${not empty cart}">
        <table>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cart}">
                <tr>
                    <td>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="code" value="${item.product.code}">
                            <input type="text" name="quantity" value="${item.quantity}" size="5">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>${item.product.description}</td>
                    <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                    <td>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="removeCode" value="${item.product.code}">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>

    <form action="cart" method="post">
        <input type="hidden" name="action" value="continue">
        <input type="submit" value="Continue Shopping">
    </form>
    <br>
    <form action="cart" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Checkout">
    </form>
</body>
</html>