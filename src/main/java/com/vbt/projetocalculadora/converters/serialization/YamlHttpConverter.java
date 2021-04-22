package com.vbt.projetocalculadora.converters.serialization;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

/**
 * @apiNote
 * Método converssor para Media Type do tipo YAML
 */

public final class YamlHttpConverter extends AbstractJackson2HttpMessageConverter {

    public YamlHttpConverter() {
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }

}
