package net.htmlonline.actions.servlet.api;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

public class Requests extends ActionSupport implements ServletRequestAware, ServletContextAware {
    private HttpServletRequest request; // 接口注入方式
    private ServletContext servletContext;

    @Override
    public String execute() throws Exception {
        // 方式 - 接耦合方式

        // actionContext对象获取
        ActionContext context = ActionContext.getContext();


        // 获取参数
        HttpParameters map = context.getParameters();
        System.out.println(map);

        // 向域中存入数据
        context.put("reqName", "reqValue"); //request.setAttribute()
        context.getSession().put("sessName", "sessValue"); // session.setAttribute()
        context.getApplication().put("appName", "appValue"); // application.setAttribute()

        return NONE;
    }

    public String origin() {
        // 方式 二 原生 api
        HttpServletRequest request = ServletActionContext.getRequest();

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key :
                parameterMap.keySet()) {
            String[] value = parameterMap.get(key);
            System.out.println(key + ":::: " + Arrays.toString(value));
        }


        return NONE;
    }

    public String interfaceMethod() {

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        Object aaa = servletContext.getAttribute("aaa");

        return NONE;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
