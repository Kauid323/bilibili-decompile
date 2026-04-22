package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: platformUtil.kt */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform $this$presentableDescription) {
        Intrinsics.checkNotNullParameter($this$presentableDescription, "<this>");
        return CollectionsKt.joinToString$default($this$presentableDescription.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}