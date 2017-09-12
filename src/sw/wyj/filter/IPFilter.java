package sw.wyj.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.IP;


public class IPFilter implements Filter {
    protected FilterConfig config;
    protected String IP;
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {

        this.config = config;
        IP = config.getInitParameter("IP");
               if (IP == null){
                IP = "";}
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        String usrIP = request.getRemoteAddr();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Fail.jsp");
        if (usrIP.equals(IP)) {
            dispatcher.forward(request,response);
        } else {
         chain.doFilter(request,response);
        }
    }



}
