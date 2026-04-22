package io.ktor.client.plugins;

import com.xiaomi.mipush.sdk.MiPushClient;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.KtorDsl;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: HttpPlainText.kt */
@KtorDsl
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\r\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00070\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u00060\u0004j\u0002`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/HttpPlainTextConfig;", "", "<init>", "()V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "quality", "", MiPushClient.COMMAND_REGISTER, "(Ljava/nio/charset/Charset;Ljava/lang/Float;)V", "", "charsets", "Ljava/util/Set;", "getCharsets$ktor_client_core", "()Ljava/util/Set;", "", "charsetQuality", "Ljava/util/Map;", "getCharsetQuality$ktor_client_core", "()Ljava/util/Map;", "sendCharset", "Ljava/nio/charset/Charset;", "getSendCharset", "()Ljava/nio/charset/Charset;", "setSendCharset", "(Ljava/nio/charset/Charset;)V", "responseCharsetFallback", "getResponseCharsetFallback", "setResponseCharsetFallback", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpPlainTextConfig {
    private Charset sendCharset;
    private final Set<Charset> charsets = new LinkedHashSet();
    private final Map<Charset, Float> charsetQuality = new LinkedHashMap();
    private Charset responseCharsetFallback = Charsets.UTF_8;

    public final Set<Charset> getCharsets$ktor_client_core() {
        return this.charsets;
    }

    public final Map<Charset, Float> getCharsetQuality$ktor_client_core() {
        return this.charsetQuality;
    }

    public static /* synthetic */ void register$default(HttpPlainTextConfig httpPlainTextConfig, Charset charset, Float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = null;
        }
        httpPlainTextConfig.register(charset, f2);
    }

    public final void register(Charset charset, Float quality) {
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        if (quality != null) {
            float it = quality.floatValue();
            double d2 = it;
            boolean z = false;
            if (0.0d <= d2 && d2 <= 1.0d) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        this.charsets.add(charset);
        if (quality == null) {
            this.charsetQuality.remove(charset);
        } else {
            this.charsetQuality.put(charset, quality);
        }
    }

    public final Charset getSendCharset() {
        return this.sendCharset;
    }

    public final void setSendCharset(Charset charset) {
        this.sendCharset = charset;
    }

    public final Charset getResponseCharsetFallback() {
        return this.responseCharsetFallback;
    }

    public final void setResponseCharsetFallback(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<set-?>");
        this.responseCharsetFallback = charset;
    }
}