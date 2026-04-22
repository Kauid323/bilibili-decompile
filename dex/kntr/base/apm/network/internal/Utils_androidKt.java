package kntr.base.apm.network.internal;

import com.bilibili.lib.foundation.FoundationAlias;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Utils.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"currentProcessName", "", "getCurrentProcessName", "()Ljava/lang/String;", "currentProcessName$delegate", "Lkotlin/Lazy;", "getAppLifecycle", "Lkntr/base/apm/network/internal/AppLifecycle;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Utils_androidKt {
    private static final Lazy currentProcessName$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.apm.network.internal.Utils_androidKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            String currentProcessName_delegate$lambda$0;
            currentProcessName_delegate$lambda$0 = Utils_androidKt.currentProcessName_delegate$lambda$0();
            return currentProcessName_delegate$lambda$0;
        }
    });

    public static final String getCurrentProcessName() {
        return (String) currentProcessName$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currentProcessName_delegate$lambda$0() {
        String packageName = FoundationAlias.getFapp().getPackageName();
        String processName = FoundationAlias.getFapps().getProcessName();
        return Intrinsics.areEqual(processName, packageName) ? "main" : StringsKt.startsWith$default(processName, new StringBuilder().append(packageName).append(":").toString(), false, 2, (Object) null) ? StringsKt.removePrefix(processName, packageName + ":") : processName;
    }

    public static final AppLifecycle getAppLifecycle() {
        return null;
    }
}