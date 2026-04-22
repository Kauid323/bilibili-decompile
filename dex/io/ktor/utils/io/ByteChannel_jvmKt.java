package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;

/* compiled from: ByteChannel.jvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"", "DEVELOPMENT_MODE_KEY", "Ljava/lang/String;", "", "getDEVELOPMENT_MODE", "()Z", "DEVELOPMENT_MODE", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteChannel_jvmKt {
    private static final String DEVELOPMENT_MODE_KEY = "io.ktor.development";

    public static final boolean getDEVELOPMENT_MODE() {
        String property = System.getProperty(DEVELOPMENT_MODE_KEY);
        return property != null && Boolean.parseBoolean(property);
    }
}