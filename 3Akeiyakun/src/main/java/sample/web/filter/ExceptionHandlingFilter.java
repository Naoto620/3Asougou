/*----------------------------------------------------------
 * 演習番号    ：仕様書演習
 * クラス名    ：ExceptionHandlingFilter
 * 作成日      ：2026/06/17
 * 作成者      ：tarou/SYS
 *----------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *----------------------------------------------------------
 */

package sample.web.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebFilter;

/**
 *
 * @author tarou/SYS 2026/06/17
 */
@WebFilter("/*")
public class ExceptionHandlingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        try {

            chain.doFilter(request, response);

        } catch (Throwable e) {

            e.printStackTrace();

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/error.jsp");

            dispatcher.forward(request, response);

        }
    }

    @Override
    public void destroy() {
    }


}
