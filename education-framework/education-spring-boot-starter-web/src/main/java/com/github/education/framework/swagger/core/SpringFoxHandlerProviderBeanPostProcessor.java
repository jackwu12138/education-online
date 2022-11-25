package com.github.education.framework.swagger.core;

import cn.hutool.core.util.ReflectUtil;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 解决 SpringFox 与 SpringBoot 2.6.x 不兼容的问题
 *
 * @author jackwu
 */
@Slf4j
public class SpringFoxHandlerProviderBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        boolean modify = (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) &&
                defaultListableBeanFactory.containsBean(beanName);
        if (modify) {
            customizeSpringfoxHandlerMappings(bean);
        }
        return bean;
    }

    @SneakyThrows
    @SuppressWarnings({"unchecked"})
    private void customizeSpringfoxHandlerMappings(Object bean) {
        Field handlerMappingsField = bean.getClass().getDeclaredField("handlerMappings");
        ReflectUtil.setAccessible(handlerMappingsField);
        List<RequestMappingInfoHandlerMapping> handlerMappings =
                (List<RequestMappingInfoHandlerMapping>) handlerMappingsField.get(bean);
        List<RequestMappingInfoHandlerMapping> tmpHandlerMappings =
                handlerMappings.stream().
                        filter(mapping -> Objects.isNull(mapping.getPatternParser()))
                        .collect(Collectors.toList());
        handlerMappings.clear();
        handlerMappings.addAll(tmpHandlerMappings);
    }
}
