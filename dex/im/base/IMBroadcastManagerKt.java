package im.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMBroadcastManager.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "provideIMBroadcastManager", "Lim/base/IMBroadcastManager;", "platformService", "Lim/base/IMBroadCastPlatformService;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMBroadcastManagerKt {
    public static final String TAG = "Broadcast";

    public static final IMBroadcastManager provideIMBroadcastManager(IMBroadCastPlatformService platformService) {
        Intrinsics.checkNotNullParameter(platformService, "platformService");
        return new IMBroadcastManager(platformService);
    }
}