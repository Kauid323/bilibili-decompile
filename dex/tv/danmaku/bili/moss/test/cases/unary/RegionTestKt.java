package tv.danmaku.bili.moss.test.cases.unary;

import android.content.Context;
import com.bapis.bilibili.app.show.region.v1.RegionMoss;
import com.bapis.bilibili.app.show.region.v1.RegionReply;
import com.bapis.bilibili.app.show.region.v1.RegionReq;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.moss.MossTestKt;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: RegionTest.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"testRegionAsync", "", "context", "Landroid/content/Context;", "lang", "", "testRegionSync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RegionTestKt {
    public static /* synthetic */ void testRegionAsync$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "hans";
        }
        testRegionAsync(context, str);
    }

    public static final void testRegionAsync(Context context, String lang) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lang, "lang");
        RegionReq.Builder $this$testRegionAsync_u24lambda_u240 = RegionReq.newBuilder();
        $this$testRegionAsync_u24lambda_u240.setLang(lang);
        RegionReq regionReq = $this$testRegionAsync_u24lambda_u240.build();
        MossResponseHandler<RegionReply> mossResponseHandler = new MossResponseHandler<RegionReply>() { // from class: tv.danmaku.bili.moss.test.cases.unary.RegionTestKt$testRegionAsync$handler$1
            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onUpstreamAck(Long l) {
                MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(RegionReply value) {
                if (value == null) {
                    BLog.vfmt(MossTestKt.TAG, "Async onNext returns null.", new Object[0]);
                    return;
                }
                BLog.v(MossTestKt.TAG, "Async onNext, regionsCount=" + value.getRegionsCount() + FileUtils.HIDDEN_PREFIX);
            }

            public void onError(MossException t) {
                BLog.e(MossTestKt.TAG, "Async onError " + t);
            }

            public void onCompleted() {
                BLog.v(MossTestKt.TAG, "Async onCompleted");
            }
        };
        RegionMoss regionMoss = new RegionMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(regionReq);
        regionMoss.region(regionReq, mossResponseHandler);
    }

    public static /* synthetic */ void testRegionSync$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "hans";
        }
        testRegionSync(context, str);
    }

    public static final void testRegionSync(Context context, String lang) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lang, "lang");
        RegionReq.Builder $this$testRegionSync_u24lambda_u240 = RegionReq.newBuilder();
        $this$testRegionSync_u24lambda_u240.setLang(lang);
        RegionReq regionReq = $this$testRegionSync_u24lambda_u240.build();
        try {
            RegionMoss regionMoss = new RegionMoss(MossTestKt.hostByPolicy(), (int) BR.playerNickTextColor, (CallOptions) null, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(regionReq);
            RegionReply reply = regionMoss.executeRegion(regionReq);
            if (reply != null) {
                BLog.vfmt(MossTestKt.TAG, "Sync request regionsCount=%d.", Integer.valueOf(reply.getRegionsCount()));
            } else {
                BLog.vfmt(MossTestKt.TAG, "Sync request get null.", new Object[0]);
            }
        } catch (MossException e) {
            BLog.efmt(MossTestKt.TAG, "Sync request throwable=%s.", e.toPrintString());
        }
    }
}