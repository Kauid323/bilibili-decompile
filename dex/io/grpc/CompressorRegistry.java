package io.grpc;

import com.google.common.base.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import io.grpc.Codec;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public final class CompressorRegistry {
    private static final CompressorRegistry DEFAULT_INSTANCE = new CompressorRegistry(new Codec.Gzip(), Codec.Identity.NONE);
    private final ConcurrentMap<String, Compressor> compressors = new ConcurrentHashMap();

    public static CompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CompressorRegistry newEmptyInstance() {
        return new CompressorRegistry(new Compressor[0]);
    }

    CompressorRegistry(Compressor... cs) {
        for (Compressor c : cs) {
            this.compressors.put(c.getMessageEncoding(), c);
        }
    }

    @Nullable
    public Compressor lookupCompressor(String compressorName) {
        return this.compressors.get(compressorName);
    }

    public void register(Compressor c) {
        String encoding = c.getMessageEncoding();
        Preconditions.checkArgument(!encoding.contains(Constants.ACCEPT_TIME_SEPARATOR_SP), "Comma is currently not allowed in message encoding");
        this.compressors.put(encoding, c);
    }
}