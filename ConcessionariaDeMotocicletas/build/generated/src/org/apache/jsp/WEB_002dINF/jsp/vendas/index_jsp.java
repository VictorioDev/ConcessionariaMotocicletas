package org.apache.jsp.WEB_002dINF.jsp.vendas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_t_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_t_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_t_import_url_nobody.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      if (_jspx_meth_t_import_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h3>Vendas</h3>\r\n");
      out.write("\r\n");
      out.write("<a href=\"#\" class=\"btn btn-primary\">Nova venda</a>\r\n");
      out.write("\r\n");
      out.write("<form method=\"GET\">\r\n");
      out.write("    <div class=\"container-fluid mt-2\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-5\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <input type=\"text\" id=\"search\" name=\"search\" class=\"form-control col-md-10\" placeholder=\"Digite a sua busca...\">\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-sm btn-secondary col-md-2\">Buscar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<table class=\"table table-responsive table-hover table-striped mt-2\">\r\n");
      out.write("    <thead>\r\n");
      out.write("        <th>#</th>\r\n");
      out.write("        <th>Cliente</th>\r\n");
      out.write("        <th>Motocicleta</th>\r\n");
      out.write("        <th>Data</th>\r\n");
      out.write("        <th>Valor</th>\r\n");
      out.write("        <th>Ações</th>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>1</td>\r\n");
      out.write("            <td>LUCIANO DE ABREU CARVALHO JUNIOR</td>\r\n");
      out.write("            <td>HONDA CB150 PRETA</td>\r\n");
      out.write("            <td>28/03/2018</td>\r\n");
      out.write("            <td>R$29.000,00</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Visualizar</a>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Editar</a>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Remover</a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>2</td>\r\n");
      out.write("            <td>VICTORIO APARECIDO ZANSAVIO</td>\r\n");
      out.write("            <td>HORNET 1500CC PRETA</td>\r\n");
      out.write("            <td>22/03/2018</td>\r\n");
      out.write("            <td>R$75.500,00</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Visualizar</a>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Editar</a>\r\n");
      out.write("                <a href=\"#\" class=\"btn btn-sm btn-secondary\">Remover</a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<p>Listando 1 de 1 registros.</p>\r\n");
      out.write("\r\n");
      if (_jspx_meth_t_import_1(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_t_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_t_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_t_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_t_import_0.setPageContext(_jspx_page_context);
    _jspx_th_t_import_0.setParent(null);
    _jspx_th_t_import_0.setUrl("../templates/header.jsp");
    int[] _jspx_push_body_count_t_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_t_import_0 = _jspx_th_t_import_0.doStartTag();
      if (_jspx_th_t_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_t_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_t_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_t_import_0.doFinally();
      _jspx_tagPool_t_import_url_nobody.reuse(_jspx_th_t_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_t_import_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_t_import_1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_t_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_t_import_1.setPageContext(_jspx_page_context);
    _jspx_th_t_import_1.setParent(null);
    _jspx_th_t_import_1.setUrl("../templates/footer.jsp");
    int[] _jspx_push_body_count_t_import_1 = new int[] { 0 };
    try {
      int _jspx_eval_t_import_1 = _jspx_th_t_import_1.doStartTag();
      if (_jspx_th_t_import_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_t_import_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_t_import_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_t_import_1.doFinally();
      _jspx_tagPool_t_import_url_nobody.reuse(_jspx_th_t_import_1);
    }
    return false;
  }
}
