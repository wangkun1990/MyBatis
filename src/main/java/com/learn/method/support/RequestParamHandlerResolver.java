package com.learn.method.support;

import com.alibaba.fastjson.JSON;
import com.learn.method.support.annotation.RequestParam;
import com.learn.tools.ValidationUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class RequestParamHandlerResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(RequestParam.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServletServerHttpRequest servletServerHttpRequest = new ServletServerHttpRequest(
                webRequest.getNativeRequest(HttpServletRequest.class));
        MediaType mediaType = servletServerHttpRequest.getHeaders().getContentType();
        Charset charset = mediaType != null ? mediaType.getCharset() : Charset.forName("UTF-8");
        // 获取请求数据
        String requestBody = FileCopyUtils
                .copyToString(new InputStreamReader(servletServerHttpRequest.getBody(), charset));
        // 获取注解对象
        RequestParam requestParam = parameter.getParameterAnnotation(RequestParam.class);

        // 获取请求参数MbfBody
        Object paramObj = JSON.parseObject(requestBody, requestParam.type());

        // 校验入参
        if (requestParam.validate()) {
            ValidationUtils.validate(paramObj);
        }
        return paramObj;
    }
}
