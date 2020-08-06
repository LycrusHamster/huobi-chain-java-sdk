package org.nervos.huobi.service.metadata;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import org.nervos.huobi.Huobi;
import org.nervos.muta.client.type.primitive.Metadata;

public class MetadataService {
    public static final String SERVICE_NAME = "metadata";
    public static final String METHOD_GET_METADATA = "get_metadata";
    private final Huobi huobi;

    public MetadataService(Huobi huobi) {
        this.huobi = huobi;
    }

    public Metadata getMetadata() throws IOException {
        Metadata metadata =
                huobi.queryService(
                        SERVICE_NAME, METHOD_GET_METADATA, new TypeReference<Metadata>() {});

        return metadata;
    }
}
