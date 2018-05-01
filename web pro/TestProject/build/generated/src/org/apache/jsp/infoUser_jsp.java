package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class infoUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <title>Profile User</title>\r\n");
      out.write("        <style>\r\n");
      out.write("\r\n");
      out.write("            .flex-container {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                padding: 15px;\r\n");
      out.write("                flex: 1 100%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .font-heading{\r\n");
      out.write("                background-color:lightgray;\r\n");
      out.write("                padding-top: 3px;\r\n");
      out.write("                padding-bottom: 3px;\r\n");
      out.write("                padding-left: 10px;\r\n");
      out.write("                padding-right: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .font-context{\r\n");
      out.write("                background-color:whitesmoke;\r\n");
      out.write("                padding-top: 3px;\r\n");
      out.write("                padding-bottom: 3px;\r\n");
      out.write("                padding-left: 10px;\r\n");
      out.write("                padding-right: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            @media all and (min-width: 768px) {\r\n");
      out.write("                .nav {text-align:left;-webkit-flex: 1 auto;flex:1 auto;-webkit-order:1;order:1;}\r\n");
      out.write("                .article {-webkit-flex:5 0px;flex:5 0px;-webkit-order:2;order:2;}\r\n");
      out.write("                footer {-webkit-order:3;order:3;}\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"flex-container\">\r\n");
      out.write("            <h1>ข้อมูลส่วนตัว</h1> <br>\r\n");
      out.write("            <img src=\"profile.gif\" class=\"img-rounded\" alt=\"Cinque Terre\" width=\"150\" height=\"150\"> \r\n");
      out.write("        </div><br>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <!-- Here starts the navbar -->\r\n");
      out.write("            <div class=\"col-md-3\">\r\n");
      out.write("                <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                    <li class=\"active\"><a href=\"#\">ข้อมูลส่วนตัว</a></li>\r\n");
      out.write("                    <li><a href=\"BookServlet\">สัญญาการจอง</a></li>\r\n");
      out.write("                    <li><a href=\"RentServlet\">สัญญาการเช่า</a></li>\r\n");
      out.write("                    <li><a href=\"#\">ดูค่าใช้จ่ายรายเดือน</a></li>\r\n");
      out.write("                    <li><a href=\"payment.html\">อัพโหลดหลักฐานการชำระเงิน</a></li>  \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Here end the navbar -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-2\">\r\n");
      out.write("                <div class=\"font-heading\">\r\n");
      out.write("                    <p><b>ชื่อ-นามสกุล</b></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"font-context\">\r\n");
      out.write("                    ");

                        out.println(session.getAttribute("name"));
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><br><br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-2\">\r\n");
      out.write("                <div class=\"font-heading\">\r\n");
      out.write("                    <p><b>ชื่อผู้ใช้งาน</b></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"font-context\">\r\n");
      out.write("                     ");

                        out.println(session.getAttribute("username"));
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><br><br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-2\">\r\n");
      out.write("                <div class=\"font-heading\">\r\n");
      out.write("                    <p><b>เพศ</b></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"font-context\">\r\n");
      out.write("                    ");

                        out.println(session.getAttribute("gender"));
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><br><br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-2\">\r\n");
      out.write("                <div class=\"font-heading\">\r\n");
      out.write("                    <p><b>เบอร์โทรศัพท์</b></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"font-context\">\r\n");
      out.write("                    ");

                        out.println(session.getAttribute("phone"));
                    
      out.write("                </div>\r\n");
      out.write("            </div><br><br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-2\">\r\n");
      out.write("                <div class=\"font-heading\">\r\n");
      out.write("                    <p><b>ที่อยู่</b></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-5\">\r\n");
      out.write("                <div class=\"font-context\">\r\n");
      out.write("                     ");

                        out.println(session.getAttribute("address"));
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><br><br>\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
