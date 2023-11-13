<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/view/access/head.jsp"></jsp:include>
</head>
<body>
<h1 class="p-3">Simple Calculator
</h1>
<br/>
<div class="border border-2 mx-5 w-50 p-5">
    <form action="/CalculatorServlet" method="get">
        <p class="fs-2">Calculator</p>
        <div class="mt-2">
            <lable for="so1">First Operand</lable>
            <input type="number" name="number1" id="so1" value="${num1!=null?num1:""}">
        </div>
        <div class="mt-2">
            <lable for="operator">Operator</lable>
            <select type="text" name="operator" id="operator">
                <option value="+" ${operator=="+"?"selected": ""}>Addition</option>
                <option value="-" ${operator=="-"?"selected": ""}>Subtraction</option>
                <option value="*" ${operator=="*"?"selected": ""}>Multiplication</option>
                <option value="/" ${operator=="/"?"selected": ""}>Division</option>
            </select>
        </div>
        <div class="mt-2">
            <lable for="so2">Second Operand</lable>
            <input type="number" name="number2" id="so2" value="${num2!=null?num2:""}">
        </div>
        <c:if test="${!error.isEmpty()}">
            <p class="text-danger">${error}</p>
        </c:if>
        <input type="submit" value="Calculator" name="action" class="mt-2 ms-5">
    </form>
</div>
<jsp:include page="/view/access/footer.jsp"></jsp:include>
</body>
</html>