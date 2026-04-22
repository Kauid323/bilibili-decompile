package tv.danmaku.bili.push.pushsetting;

import android.content.Intent;
import android.os.Build;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.module.main.pushsetting.PushGuidanceService;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: PushGuidanceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/PushGuidanceImpl;", "Lcom/bilibili/module/main/pushsetting/PushGuidanceService;", "<init>", "()V", "openSettingPage", "", "updateServerSetting", "types", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushGuidanceImpl implements PushGuidanceService {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PushGuidanceImpl";

    public void openSettingPage() {
        BLog.i(TAG, "openPushSetting, open clicked");
        Intent intent = new Intent();
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", FoundationAlias.getFapp().getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", FoundationAlias.getFapp().getPackageName());
            intent.putExtra("app_uid", FoundationAlias.getFapp().getApplicationInfo().uid);
        }
        FoundationAlias.getFapp().startActivity(intent);
    }

    public void updateServerSetting(String types) {
        Intrinsics.checkNotNullParameter(types, "types");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new PushGuidanceImpl$updateServerSetting$1(types, null), 3, (Object) null);
    }

    /* compiled from: PushGuidanceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/PushGuidanceImpl$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}