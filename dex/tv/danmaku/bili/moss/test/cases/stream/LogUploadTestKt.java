package tv.danmaku.bili.moss.test.cases.stream;

import android.content.Context;
import bili.resource.homepage.R;
import com.bapis.bilibili.broadcast.v1.AddParams;
import com.bapis.bilibili.broadcast.v1.LaserLogUploadResp;
import com.bapis.bilibili.broadcast.v1.LaserMoss;
import com.bapis.bilibili.broadcast.v1.Test2Moss;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.BusinessException;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossBroadcast;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.moss.utils.SampleKt;
import com.google.protobuf.Empty;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: LogUploadTest.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\t\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\"\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"TAG", "", "testBoadcastStartSync", "", "context", "Landroid/content/Context;", "testBroadcastStartAsync", "testBoadcastStopSync", "testBroadcastStopAsync", "testLogUploadWatchAsync", "testLogUploadWatchSync", "testLogUploadUnwatchAsync", "testLogUploadUnwatchSync", "reqHandler", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/broadcast/v1/AddParams;", "getReqHandler", "()Lcom/bilibili/lib/moss/api/MossResponseHandler;", "setReqHandler", "(Lcom/bilibili/lib/moss/api/MossResponseHandler;)V", "MIN", "", "getMIN", "()I", "setMIN", "(I)V", "MAX", "getMAX", "setMAX", "map", "", "", "getMap", "()Ljava/util/Map;", "testLogUploadAddRegisterAsync", "testLogUploadAddRegisterSync", "testLogUploadAddUnregisterAsync", "testLogUploadAddUnregisterSync", "testLogUploadAddAsync", "testLogUploadAddSync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LogUploadTestKt {
    private static int MIN = 0;
    private static final String TAG = "moss.brdcst.logupload";
    private static MossResponseHandler<AddParams> reqHandler;
    private static int MAX = 19;
    private static final Map<Long, AddParams> map = new LinkedHashMap();

    public static final void testBoadcastStartSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.start();
    }

    public static final void testBroadcastStartAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.start();
    }

    public static final void testBoadcastStopSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.stop();
    }

    public static final void testBroadcastStopAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.stop();
    }

    public static final void testLogUploadWatchAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Empty emptyReq = Empty.newBuilder().build();
        LaserMoss laserMoss = new LaserMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(emptyReq);
        laserMoss.watchLogUploadEvent(emptyReq, new MossResponseHandler<LaserLogUploadResp>() { // from class: tv.danmaku.bili.moss.test.cases.stream.LogUploadTestKt$testLogUploadWatchAsync$1
            public /* synthetic */ void onHeaders(Map map2) {
                MossResponseHandler.-CC.$default$onHeaders(this, map2);
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

            public void onNext(LaserLogUploadResp value) {
                if (value != null) {
                    BLog.v("moss.brdcst.logupload", "Async onNext, taskId=" + value.getTaskid() + FileUtils.HIDDEN_PREFIX);
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e("moss.brdcst.logupload", "Async onError " + t + FileUtils.HIDDEN_PREFIX);
                }
            }

            public void onCompleted() {
                BLog.v("moss.brdcst.logupload", "onCompleted.");
            }
        });
    }

    public static final void testLogUploadWatchSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHelper.showToastShort(context, R.string.homepage_global_string_156);
    }

    public static final void testLogUploadUnwatchAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(LaserMoss.Companion.getWatchLogUploadEventMethod());
    }

    public static final void testLogUploadUnwatchSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(LaserMoss.Companion.getWatchLogUploadEventMethod());
    }

    public static final MossResponseHandler<AddParams> getReqHandler() {
        return reqHandler;
    }

    public static final void setReqHandler(MossResponseHandler<AddParams> mossResponseHandler) {
        reqHandler = mossResponseHandler;
    }

    public static final int getMIN() {
        return MIN;
    }

    public static final void setMIN(int i) {
        MIN = i;
    }

    public static final int getMAX() {
        return MAX;
    }

    public static final void setMAX(int i) {
        MAX = i;
    }

    public static final Map<Long, AddParams> getMap() {
        return map;
    }

    public static final void testLogUploadAddRegisterAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        reqHandler = new Test2Moss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).test(new MossResponseHandler<Empty>() { // from class: tv.danmaku.bili.moss.test.cases.stream.LogUploadTestKt$testLogUploadAddRegisterAsync$1
            public /* synthetic */ void onHeaders(Map map2) {
                MossResponseHandler.-CC.$default$onHeaders(this, map2);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            public void onNext(Empty value) {
                if (value != null) {
                    BLog.v("moss.brdcst.logupload", "Async add onNext, value=" + value + FileUtils.HIDDEN_PREFIX);
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.e("moss.brdcst.logupload", "Async add onError " + t + FileUtils.HIDDEN_PREFIX);
                }
                BusinessException it = t instanceof BusinessException ? (BusinessException) t : null;
                if (it != null) {
                    BLog.e("moss.brdcst.logupload", "It's biz error code=" + it.getCode() + ", message=" + it.getMessage());
                }
            }

            public void onCompleted() {
                BLog.v("moss.brdcst.logupload", "onCompleted add.");
            }

            public void onUpstreamAck(Long token) {
                AddParams send = LogUploadTestKt.getMap().get(token);
                BLog.d("moss.brdcst.logupload", "onUpstreamAck token=" + token + ", send=" + send);
            }
        });
    }

    public static final void testLogUploadAddRegisterSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHelper.showToastShort(context, R.string.homepage_global_string_156);
    }

    public static final void testLogUploadAddUnregisterAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(Test2Moss.Companion.getTestMethod());
    }

    public static final void testLogUploadAddUnregisterSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MossBroadcast.unregister(Test2Moss.Companion.getTestMethod());
    }

    public static final void testLogUploadAddAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int a = SampleKt.randInt(MIN, MAX);
        int b = SampleKt.randInt(MIN, MAX);
        AddParams addParams = AddParams.newBuilder().setA(a).setB(b).build();
        MossResponseHandler it = reqHandler;
        if (it != null) {
            Intrinsics.checkNotNull(addParams);
            long token = it.onNextForAck(addParams);
            map.put(Long.valueOf(token), addParams);
            BLog.v(TAG, "Add a=" + a + ", b=" + b + ", token=" + token);
        }
    }

    public static final void testLogUploadAddSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHelper.showToastShort(context, R.string.homepage_global_string_156);
    }
}