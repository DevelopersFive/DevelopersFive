package com.co.udea.mintic.developersFive.services;



import com.co.udea.mintic.developersFive.DevelopersFiveApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer  extends SpringBootServletInitializer {

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(DevelopersFiveApplication.class);
        }

    }

