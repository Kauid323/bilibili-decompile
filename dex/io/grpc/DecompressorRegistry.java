package io.grpc;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import io.grpc.Codec;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class DecompressorRegistry {
    static final Joiner ACCEPT_ENCODING_JOINER = Joiner.on(',');
    private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);
    private final byte[] advertisedDecompressors;
    private final Map<String, DecompressorInfo> decompressors;

    public static DecompressorRegistry emptyInstance() {
        return new DecompressorRegistry();
    }

    public static DecompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public DecompressorRegistry with(Decompressor d2, boolean advertised) {
        return new DecompressorRegistry(d2, advertised, this);
    }

    private DecompressorRegistry(Decompressor d2, boolean advertised, DecompressorRegistry parent) {
        String encoding = d2.getMessageEncoding();
        Preconditions.checkArgument(!encoding.contains(Constants.ACCEPT_TIME_SEPARATOR_SP), "Comma is currently not allowed in message encoding");
        int newSize = parent.decompressors.size();
        Map<String, DecompressorInfo> newDecompressors = new LinkedHashMap<>(parent.decompressors.containsKey(d2.getMessageEncoding()) ? newSize : newSize + 1);
        for (DecompressorInfo di : parent.decompressors.values()) {
            String previousEncoding = di.decompressor.getMessageEncoding();
            if (!previousEncoding.equals(encoding)) {
                newDecompressors.put(previousEncoding, new DecompressorInfo(di.decompressor, di.advertised));
            }
        }
        newDecompressors.put(encoding, new DecompressorInfo(d2, advertised));
        this.decompressors = Collections.unmodifiableMap(newDecompressors);
        this.advertisedDecompressors = ACCEPT_ENCODING_JOINER.join(getAdvertisedMessageEncodings()).getBytes(Charset.forName("US-ASCII"));
    }

    private DecompressorRegistry() {
        this.decompressors = new LinkedHashMap(0);
        this.advertisedDecompressors = new byte[0];
    }

    public Set<String> getKnownMessageEncodings() {
        return this.decompressors.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getRawAdvertisedMessageEncodings() {
        return this.advertisedDecompressors;
    }

    public Set<String> getAdvertisedMessageEncodings() {
        Set<String> advertisedDecompressors = new HashSet<>(this.decompressors.size());
        for (Map.Entry<String, DecompressorInfo> entry : this.decompressors.entrySet()) {
            if (entry.getValue().advertised) {
                advertisedDecompressors.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(advertisedDecompressors);
    }

    @Nullable
    public Decompressor lookupDecompressor(String messageEncoding) {
        DecompressorInfo info = this.decompressors.get(messageEncoding);
        if (info != null) {
            return info.decompressor;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DecompressorInfo {
        final boolean advertised;
        final Decompressor decompressor;

        DecompressorInfo(Decompressor decompressor, boolean advertised) {
            this.decompressor = (Decompressor) Preconditions.checkNotNull(decompressor, "decompressor");
            this.advertised = advertised;
        }
    }
}