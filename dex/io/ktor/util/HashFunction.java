package io.ktor.util;

import kotlin.Metadata;

/* compiled from: HashFunction.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/HashFunction;", "", "", "input", "", "offset", "length", "", "update", "([BII)V", "digest", "()[B", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HashFunction {
    byte[] digest();

    void update(byte[] bArr, int i, int i2);

    /* compiled from: HashFunction.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void update$default(HashFunction hashFunction, byte[] bArr, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            hashFunction.update(bArr, i, i2);
        }
    }
}