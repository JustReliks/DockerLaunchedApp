package org.dockerlaunched;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class EnvConfig {

    @Value("env.property:NONE")
    private String envProperty;

}
