package ob.service.cosmeticsmanufacturer.web.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.UUID;

/**
 * Custom deserializer for UUID
 */
public class UUIDDeserializer extends StdDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return p.readValueAs(String.class);

    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

}
