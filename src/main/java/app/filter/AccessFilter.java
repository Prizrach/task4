package app.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "AccessFilter", urlPatterns = {"/orderServlet", "/billServlet"})
public class AccessFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) req).getSession();

        if(req.getParameter("login")!=null && req.getParameter("login")!="" ){
            session.setAttribute("login",req.getParameter("login"));
        }

        if(req.getParameter("acceptTerms")!=null){
            session.setAttribute("acceptTerms",req.getParameter("acceptTerms"));
        }

        if (session.getAttribute("login")==null || session.getAttribute("acceptTerms")==null){
           ((HttpServletResponse) resp).sendError(401);
        }else {
            chain.doFilter(req, resp);
        }
//        if ((((HttpServletRequest) req).getSession().getAttribute("userName") == null &&
//                req.getParameter("userName") == null || ((HttpServletRequest) req).getSession().getAttribute("userName") == null &&
//                req.getParameter("userName").equals("") ||
//                (req.getParameter("acceptTerms") == null &&
//                        ((HttpServletRequest) req).getSession().getAttribute("acceptTerms") == null))) {
//            ((HttpServletResponse) resp).sendError(401);
//        } else {
//            ((HttpServletRequest) req).getSession().setAttribute("acceptTerms", "accepted");
//            chain.doFilter(req, resp);
//        }
    }

    @Override
    public void destroy() {

    }
}
