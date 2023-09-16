    package com.example.tx.configuration;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Profile;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;
    import org.springframework.web.servlet.config.annotation.EnableWebMvc;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    @EnableWebMvc
    @Profile("development")
    public class DevCorsConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080") // Adjust the development frontend URL
                    .allowedMethods("*")
                    .allowCredentials(true)
                    .allowedHeaders("*")
                    .maxAge(3600);
        }
    }