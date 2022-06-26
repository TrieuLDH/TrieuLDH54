/*
 * package filters;
 * 
 * import java.io.IOException; import javax.servlet.Filter; import
 * javax.servlet.FilterChain; import javax.servlet.FilterConfig; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.annotation.WebFilter;
 * import javax.servlet.http.HttpFilter;
 * 
 *//**
	 * Servlet Filter implementation class UTF8Filter
	 */
/*
 * @WebFilter(filterName="utf8_filter", urlPatterns= { "/users/*",
 * "/products/*", "/categories/*", "/cart/*", }) public class UTF8Filter extends
 * HttpFilter implements Filter {
 * 
 *//**
	 * @see HttpFilter#HttpFilter()
	 */
/*
 * public UTF8Filter() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see Filter#destroy()
	 */
/*
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 *//**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
/*
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException { // TODO
 * Auto-generated method stub // place your code here
 * 
 * // pass the request along the filter chain if(request.getCharacterEncoding()
 * == null) { request.setCharacterEncoding("UTF-8"); }
 * System.out.println("UTF-8"); chain.doFilter(request, response); }
 * 
 *//**
	 * @see Filter#init(FilterConfig)
	 *//*
		 * public void init(FilterConfig fConfig) throws ServletException { // TODO
		 * Auto-generated method stub }
		 * 
		 * }
		 */