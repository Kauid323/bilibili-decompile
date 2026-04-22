package tv.danmaku.bili.ui.pandora;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PandoraApiHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/pandora/PandoraApiHelper;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PandoraApiHelper {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final PandoraApi api;

    /* compiled from: PandoraApiHelper.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/pandora/PandoraApiHelper$Companion;", "", "<init>", "()V", "api", "Ltv/danmaku/bili/ui/pandora/PandoraApi;", "fetchDialogInfo", "", "context", "Landroid/content/Context;", LoginSceneProcessor.BIZ_KEY, "", "spmid", "callback", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/pandora/PandoraBean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void fetchDialogInfo(Context context, String business, String spmid, BiliApiDataCallback<PandoraBean> biliApiDataCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
            Intrinsics.checkNotNullParameter(spmid, "spmid");
            Intrinsics.checkNotNullParameter(biliApiDataCallback, "callback");
            try {
                PandoraApiHelper.api.fetchStatusForLogin(BiliAccounts.get(context).getAccessKey(), business, spmid).enqueue((Callback) biliApiDataCallback);
            } catch (Throwable th) {
            }
        }
    }

    static {
        Object createService = ServiceGenerator.createService(PandoraApi.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        api = (PandoraApi) createService;
    }
}