package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            String name = ck[1].getValue();
            if (!name.equals("") || name != null) {
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + name);
            }
        } else {
            out.print("<font color=red>Please login first</font>");
            request.getRequestDispatcher("login.html").include(request,
                    response);
        }
        out.close();
    }
}