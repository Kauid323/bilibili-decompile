package io.ktor.http;

import faceverify.q;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ContentDisposition.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", q.KEY_RES_9_KEY, "value", "encodeContentDispositionAttribute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentDispositionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodeContentDispositionAttribute(String key, String value) {
        if (Intrinsics.areEqual(key, ContentDisposition.Parameters.FileNameAsterisk)) {
            boolean z = true;
            if (StringsKt.startsWith(value, "utf-8''", true)) {
                return value;
            }
            String $this$all$iv = value;
            int i2 = 0;
            while (true) {
                if (i2 >= $this$all$iv.length()) {
                    break;
                }
                char element$iv = $this$all$iv.charAt(i2);
                if (!CodecsKt.getATTRIBUTE_CHARACTERS().contains(Character.valueOf(element$iv))) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                return value;
            }
            String encodedValue = CodecsKt.percentEncode(value, CodecsKt.getATTRIBUTE_CHARACTERS());
            return "utf-8''" + encodedValue;
        }
        return value;
    }
}