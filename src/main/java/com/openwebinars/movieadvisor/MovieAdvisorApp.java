package com.openwebinars.movieadvisor;

import com.openwebinars.movieadvisor.config.HibernateConfig;
import com.openwebinars.movieadvisor.filters.ErrorHandleFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.openwebinars.movieadvisor.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Clase principal del programa.
 * <p>
 * Tan solo carga el contexto a partir de la clase de configuración.
 * Tras esto, lanza el componente que ejecuta realmente el ciclo
 * del programa.
 *
 * @author Openwebinars
 */
/*public class MovieAdvisorApp {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MovieAdvisorRunApp runApp = appContext.getBean(MovieAdvisorRunApp.class);
		
		runApp.run(args);
		
		((AnnotationConfigApplicationContext) appContext).close();

	}

}*/
public class MovieAdvisorApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

   /* protected Filter[] getServletFilters() {
        return new Filter[]{new ErrorHandleFilter()};
    }*/
}