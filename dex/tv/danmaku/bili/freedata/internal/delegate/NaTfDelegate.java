package tv.danmaku.bili.freedata.internal.delegate;

import com.bilibili.api.BiliConfig;
import com.bilibili.gripper.api.buvid.GBuvid;
import com.bilibili.gripper.api.foundation.GFoundation;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.tf.LogLevel;
import com.bilibili.lib.tf.TfDelegate;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import com.bilibili.nativelibrary.LibBili;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.freedata.internal.config.TfConfig;
import tv.danmaku.bili.freedata.internal.ipc.brdcst.TfSyncModelsReceiverKt;

/* compiled from: TfDelegate.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001eH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Ltv/danmaku/bili/freedata/internal/delegate/NaTfDelegate;", "Lcom/bilibili/lib/tf/TfDelegate;", "buvidService", "Lcom/bilibili/gripper/api/buvid/GBuvid;", "f", "Lcom/bilibili/gripper/api/foundation/GFoundation;", "<init>", "(Lcom/bilibili/gripper/api/buvid/GBuvid;Lcom/bilibili/gripper/api/foundation/GFoundation;)V", "getBuvidService", "()Lcom/bilibili/gripper/api/buvid/GBuvid;", "setBuvidService", "(Lcom/bilibili/gripper/api/buvid/GBuvid;)V", "getF", "()Lcom/bilibili/gripper/api/foundation/GFoundation;", "setF", "(Lcom/bilibili/gripper/api/foundation/GFoundation;)V", "withCommonParams", "", "raw", "getBuvid", "isDirectBvcConvertEnabled", "", "maybeSyncModels", "", "log", "level", "Lcom/bilibili/lib/tf/LogLevel;", AppConfig.HOST_TAG, "message", "params", "", "url", "Lokhttp3/HttpUrl;", "addParams", "network-ignet-ctr_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NaTfDelegate extends TfDelegate {
    private GBuvid buvidService;
    private GFoundation f;

    public NaTfDelegate(GBuvid buvidService, GFoundation f) {
        Intrinsics.checkNotNullParameter(buvidService, "buvidService");
        Intrinsics.checkNotNullParameter(f, "f");
        this.buvidService = buvidService;
        this.f = f;
        TfSyncModelsReceiverKt.registerSyncModelReceiver();
    }

    public final GBuvid getBuvidService() {
        return this.buvidService;
    }

    public final GFoundation getF() {
        return this.f;
    }

    public final void setBuvidService(GBuvid gBuvid) {
        Intrinsics.checkNotNullParameter(gBuvid, "<set-?>");
        this.buvidService = gBuvid;
    }

    public final void setF(GFoundation gFoundation) {
        Intrinsics.checkNotNullParameter(gFoundation, "<set-?>");
        this.f = gFoundation;
    }

    public String withCommonParams(String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        try {
            HttpUrl url = HttpUrl.parse(raw);
            Intrinsics.checkNotNull(url);
            Map params = params(url);
            HttpUrl signed = url.newBuilder().encodedQuery(LibBili.signQuery(MapsKt.plus(params, addParams())).toString()).build();
            String httpUrl = signed.toString();
            Intrinsics.checkNotNull(httpUrl);
            return httpUrl;
        } catch (Exception e) {
            TfLog.Companion.e("tf.app.delegate", String.valueOf(e));
            return "";
        }
    }

    public String getBuvid() {
        return this.buvidService.getBuvid();
    }

    public boolean isDirectBvcConvertEnabled() {
        Boolean transformBvcDirectEnabled = TfConfig.INSTANCE.getTransformBvcDirectEnabled();
        if (transformBvcDirectEnabled != null) {
            return transformBvcDirectEnabled.booleanValue();
        }
        return true;
    }

    public void maybeSyncModels() {
        TfSyncModelsReceiverKt.syncModels();
    }

    public void log(LogLevel level, String tag, String message) {
        int i;
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(message, "message");
        TfLog.Companion companion = TfLog.Companion;
        TfLog.Companion companion2 = TfLog.Companion;
        switch (NaTfDelegate$log$$inlined$logLevel$1$wm$TfLog$Companion$WhenMappings.$EnumSwitchMapping$0[level.ordinal()]) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 8;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        companion.log(i, tag, message);
    }

    private final Map<String, String> params(HttpUrl url) {
        int n = url.querySize();
        Map map = new LinkedHashMap();
        for (int i = 0; i < n; i++) {
            try {
                map.put(url.queryParameterName(i), url.queryParameterValue(i));
            } catch (Throwable t) {
                BLog.e("tf.app.delegate", "Add params exception " + t);
            }
        }
        return map;
    }

    private final Map<String, String> addParams() {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("platform", "android");
        pairArr[1] = TuplesKt.to("mobi_app", BiliConfig.getMobiApp());
        pairArr[2] = TuplesKt.to("appkey", BiliConfig.getAppKey());
        pairArr[3] = TuplesKt.to("build", String.valueOf(FoundationAlias.getFapps().getInternalVersionCode()));
        pairArr[4] = TuplesKt.to("channel", BiliConfig.getChannel());
        String accessKey = BiliConfig.getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        pairArr[5] = TuplesKt.to("access_key", accessKey);
        pairArr[6] = TuplesKt.to("c_locale", BiliConfig.getCurrentLocale());
        pairArr[7] = TuplesKt.to("s_locale", BiliConfig.getSystemLocale());
        return MapsKt.mapOf(pairArr);
    }
}