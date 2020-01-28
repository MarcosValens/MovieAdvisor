package com.openwebinars.movieadvisor.config;

import com.openwebinars.movieadvisor.filters.Error2HandleFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * En este proyecto de ejemplo hemos usado la configuración de Spring
 * vía JavaConfig. Esta clase es la que articula dicha configuración.
 * <p>
 * Está anotada con @Configuration, que indica que es una clase con
 * aspectos de configuración; @ComponentScan, que nos permite buscar
 * a través de uno o más paquetes si hay clases estereotipadas; y
 * por último con @PropertySource, que nos permite cargar un
 * fichero de propiedades, para inyectar sus valores, los cuales
 * podemos utilizar con la notación ${prop.from.propeties.files}
 * <p>
 * NOTA: En este clase hemos conjugado varios elementos. Cabe destacar
 * que las propiedades que aquí se cargan, se utilizan en otras clases.
 * ¿Por qué no cargarlas directamente allí? Cuando en un proyecto se
 * utilizan las properties en diferentes clases, tendemos a dispersar
 * la configuración. Un buen diseño podría ser algutinar dichos valores
 * en una o más clases, que sirvan como servicios de configuración.
 *
 * @author OpenWebinars
 */


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.openwebinars.movieadvisor")
@PropertySource("classpath:/movieadvisor.properties")
public class AppConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    public String file;

    @Value("${file.csv.separator}")
    public String separator;

    @Value("${file.csv.list_separator}")
    public String listSeparator;

    public String getFile() {
        return file;
    }

    public String getSeparator() {
        return separator;
    }

    public String getListSeparator() {
        return listSeparator;
    }

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Error2HandleFilter()).addPathPatterns("/**").excludePathPatterns("/login");
       /*registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");*/

    }
}
