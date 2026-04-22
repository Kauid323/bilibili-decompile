package tv.danmaku.bili.ui.garb.model;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.BR;

/* compiled from: GarbApiService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbApiHelper;", "", "<init>", "()V", "sApi", "Ltv/danmaku/bili/ui/garb/model/GarbApiService;", "getSApi", "()Ltv/danmaku/bili/ui/garb/model/GarbApiService;", "sApi$delegate", "Lkotlin/Lazy;", "fetchGarb", "", "accessKey", "", "isFreeTheme", "", "cb", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/garb/model/GarbData;", "unloadGarb", "context", "Landroid/content/Context;", "Ljava/lang/Void;", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbApiHelper {
    public static final GarbApiHelper INSTANCE = new GarbApiHelper();
    private static final Lazy sApi$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.model.GarbApiHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            GarbApiService sApi_delegate$lambda$0;
            sApi_delegate$lambda$0 = GarbApiHelper.sApi_delegate$lambda$0();
            return sApi_delegate$lambda$0;
        }
    });

    private GarbApiHelper() {
    }

    private final GarbApiService getSApi() {
        return (GarbApiService) sApi$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GarbApiService sApi_delegate$lambda$0() {
        return (GarbApiService) ServiceGenerator.createService(GarbApiService.class);
    }

    public final void fetchGarb(String accessKey, boolean isFreeTheme, BiliApiDataCallback<GarbData> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(biliApiDataCallback, "cb");
        getSApi().fetchGarb(accessKey, isFreeTheme ? 1 : 0).enqueue((Callback) biliApiDataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unloadGarb$default(GarbApiHelper garbApiHelper, Context context, BiliApiDataCallback biliApiDataCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            biliApiDataCallback = null;
        }
        garbApiHelper.unloadGarb(context, biliApiDataCallback);
    }

    public final void unloadGarb(Context context, BiliApiDataCallback<Void> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        getSApi().unloadGarb(BiliAccounts.get(context).getAccessKey(), "skin").enqueue((Callback) biliApiDataCallback);
    }
}