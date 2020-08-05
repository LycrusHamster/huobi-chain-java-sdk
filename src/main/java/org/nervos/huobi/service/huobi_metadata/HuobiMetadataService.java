package org.nervos.huobi.service.huobi_metadata;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import lombok.Getter;
import org.nervos.huobi.Huobi;
import org.nervos.huobi.service.huobi_metadata.type.UpdateMetadataPayload;
import org.nervos.muta.client.type.primitive.Metadata;

@Getter
public class HuobiMetadataService {
    public static final String SERVICE_NAME = "metadata";
    public static final String METHOD_GET_METADATA = "get_metadata";
    public static final String METHOD_UPDATE_METADATA = "update_metadata";
    private final Huobi huobi;

    public HuobiMetadataService(Huobi huobi) {
        this.huobi = huobi;
    }

    public Metadata getMetadata() throws IOException {
        Metadata metadata =
                huobi.queryService(
                        SERVICE_NAME, METHOD_GET_METADATA, new TypeReference<Metadata>() {});

        return metadata;
    }

    public void update_metadata(UpdateMetadataPayload updateMetadataPayload) throws IOException {
        huobi.sendTransactionAndPollResult(
                SERVICE_NAME,
                METHOD_UPDATE_METADATA,
                updateMetadataPayload,
                new TypeReference<Void>() {});
    }
}
