package ra.academy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("number1"));
        double num2 = Double.parseDouble(request.getParameter("number2"));
        String operator = request.getParameter("operator");
        String action = request.getParameter("action");
        String error = "";
        double result = 0;
        if(action!= null){
            switch (action){
                case "BACK":
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                    break;
                case "Calculator":
                    try {
                        result = Calculator.calculate(num1,num2,operator);
                        request.setAttribute("result",result);
                        request.setAttribute("operator",operator);
                        request.setAttribute("num1",num1);
                        request.setAttribute("num2",num2);
                        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request,response);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        error = e.getMessage();
                        request.setAttribute("error",error);
                        request.setAttribute("operator",operator);
                        request.setAttribute("num1",num1);
                        request.setAttribute("num2",num2);
                        request.getRequestDispatcher("/index.jsp").forward(request,response);
                    }
                    break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}