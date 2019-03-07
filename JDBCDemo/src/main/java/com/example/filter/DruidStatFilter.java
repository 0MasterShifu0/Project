package com.example.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 配置监控拦截器
 * druid监控拦截器
 * @ClassName: DruidStatFilter
 * @author ppx
 * @date 2018年5月26日 上午11:37:40
 */


@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)  //配置StatView的Servlet：Filter的实现类：过滤不需要监控的后缀
public class DruidStatFilter extends WebStatFilter {

}
