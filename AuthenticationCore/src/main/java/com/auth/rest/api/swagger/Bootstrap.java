package com.auth.rest.api.swagger;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {

    /**
     * 
     */

    private static final long serialVersionUID = -4076691977294740138L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Info info = new Info().title(" API DOC").description("This is  rest api server.  you can use the api key `special-key` to test the authorization filters.").termsOfService("http://.fr/terms/").contact(new Contact().email("admin@.fr"))
                .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        ServletContext context = config.getServletContext();
        Swagger swagger = new Swagger().info(info);
        swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
        swagger.securityDefinition("store_auth", new OAuth2Definition().scope("read:stores", "read your stores").scope("write:stores", "modify stores"));
        new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
    }
}
