package com.jrochette.deckofcards.api.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;

@Component
@Order(1)
public class RequestLoggerFilter implements Filter {
  private static Logger logger = LoggerFactory.getLogger(RequestLoggerFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    logger.info("Request log - {} {}", req.getMethod(), req.getRequestURI());
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}
