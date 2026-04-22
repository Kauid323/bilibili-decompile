package tv.danmaku.bili.moss.test.cases.stream;

import android.content.Context;
import bili.resource.homepage.R;
import com.bapis.bilibili.broadcast.v1.PushMessageResp;
import com.bapis.bilibili.broadcast.v1.PushMoss;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossBroadcast;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.Empty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: AppPushTest.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG_APPPUSH", "", "testAppPushRegisterAsync", "", "context", "Landroid/content/Context;", "testAppPushRegisterSync", "testAppPushUnregisterAsync", "testAppPushUnregisterSync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppPushTestKt {
    private static final String TAG_APPPUSH = "moss.brdcst.apppush";

    public static final void testAppPushRegisterAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Empty emptyReq = Empty.newBuilder().build();
        PushMoss pushMoss = new PushMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(emptyReq);
        pushMoss.watchMessage(emptyReq, new MossResponseHandler<PushMessageResp>() { // from class: tv.danmaku.bili.moss.test.cases.stream.AppPushTestKt$testAppPushRegisterAsync$1
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

            public void onNext(PushMessageResp value) {
                if (value != null) {
                    BLog.v("moss.brdcst.apppush", "Async onNext.");
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e("moss.brdcst.apppush", "Async onError " + t + FileUtils.HIDDEN_PREFIX);
                }
            }

            public void onCompleted() {
                BLog.v("moss.brdcst.apppush", "onCompleted.");
            }
        });
    }

    public static final void testAppPushRegisterSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHelper.showToastShort(context, R.string.homepage_global_string_156);
    }

    public static final void testAppPushUnregisterAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(PushMoss.Companion.getWatchMessageMethod());
    }

    public static final void testAppPushUnregisterSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(PushMoss.Companion.getWatchMessageMethod());
    }
}