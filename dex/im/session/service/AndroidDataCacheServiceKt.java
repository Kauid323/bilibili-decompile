package im.session.service;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidDataCacheService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideAndroidDataCacheService", "Lim/session/service/IMSessionDataCacheService;", "app", "Landroid/app/Application;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AndroidDataCacheServiceKt {
    public static final IMSessionDataCacheService provideAndroidDataCacheService(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return new AndroidDataCacheService(app);
    }
}