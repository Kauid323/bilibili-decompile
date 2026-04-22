package tv.danmaku.bili.moss.test.cases.unary.rest;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Check.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u0004H\u0001¨\u0006\u0006"}, d2 = {"checkEqual", "", "this", "Lcom/google/protobuf/GeneratedMessageLite;", "Lcom/bilibili/lib/moss/api/ProtoMessage;", "other", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheckKt {
    public static final void checkEqual(GeneratedMessageLite<?, ?> generatedMessageLite, GeneratedMessageLite<?, ?> generatedMessageLite2) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(generatedMessageLite, "this");
        Intrinsics.checkNotNullParameter(generatedMessageLite2, "other");
        if (Intrinsics.areEqual(generatedMessageLite, generatedMessageLite2)) {
            byte[] thisData = generatedMessageLite.toByteArray();
            byte[] otherData = generatedMessageLite2.toByteArray();
            if (!Arrays.equals(thisData, otherData)) {
                throw new IllegalStateException("Check proto equals failed");
            }
            return;
        }
        throw new IllegalStateException("Check proto equals failed");
    }
}