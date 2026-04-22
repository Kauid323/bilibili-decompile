package io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nullable;

public interface StreamListener {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface MessageProducer {
        @Nullable
        InputStream next();
    }

    void messagesAvailable(MessageProducer messageProducer);

    void onReady();
}