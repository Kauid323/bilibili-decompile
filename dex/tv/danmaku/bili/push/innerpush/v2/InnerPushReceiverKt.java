package tv.danmaku.bili.push.innerpush.v2;

import android.content.Context;
import android.content.Intent;
import com.bapis.bilibili.broadcast.v1.PageBlackList;
import com.bapis.bilibili.broadcast.v1.PageView;
import com.bapis.bilibili.broadcast.v1.PushMessageResp;
import com.bapis.bilibili.broadcast.v1.PushMoss;
import com.bapis.bilibili.broadcast.v1.TargetResource;
import com.bilibili.comm.bbc.service.BbcClientManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.module.main.innerpush.BizParams;
import com.bilibili.module.main.innerpush.InnerPush;
import com.google.gson.Gson;
import com.google.protobuf.Empty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.broadcast.moss.BroadcastBizConfig;
import tv.danmaku.bili.push.innerpush.PushRpc;
import tv.danmaku.bili.push.innerpush.PushUpType;

/* compiled from: InnerPushReceiver.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"registerInnerPushReceiver", "", "context", "Landroid/content/Context;", "appPushMossEnabled", "", "getPushIntentAction", "", "appPushWithMoss", "toJson", "value", "Lcom/bapis/bilibili/broadcast/v1/PushMessageResp;", "getTargetResource", "Lcom/bilibili/module/main/innerpush/BizParams;", "getPageBlackList", "", "getPageViewList", "TAG", "KEY_EXTRA", "APP_INNER_PUSH_OP_CODE", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushReceiverKt {
    private static final int APP_INNER_PUSH_OP_CODE = 1008;
    public static final String KEY_EXTRA = "extra";
    private static final String TAG = "InnerPushReceiver";

    public static final void registerInnerPushReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (appPushMossEnabled()) {
            BLog.i(TAG, "Register broadcast receiver with moss stream.");
            appPushWithMoss(context);
            return;
        }
        BLog.i(TAG, "Register broadcast receiver with bbc.");
        InnerPushReceiver receiver = new InnerPushReceiver(context);
        BbcClientManager.register((int) APP_INNER_PUSH_OP_CODE, receiver);
    }

    private static final boolean appPushMossEnabled() {
        boolean all = BroadcastBizConfig.Companion.enabled();
        Object obj = ConfigManager.Companion.ab().get("grpc_stream_biz_app_push", true);
        Intrinsics.checkNotNull(obj);
        boolean push = ((Boolean) obj).booleanValue();
        return all && push;
    }

    public static final String getPushIntentAction(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageName() + ".push.appinnerpush.broadcast";
    }

    private static final void appPushWithMoss(final Context context) {
        Empty e = Empty.newBuilder().build();
        PushMoss pushMoss = new PushMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(e);
        pushMoss.watchMessage(e, new MossResponseHandler<PushMessageResp>() { // from class: tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt$appPushWithMoss$1
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
                String json;
                if (value != null) {
                    BLog.i("InnerPushReceiver", "OnNext with taskId" + value.getTaskid());
                    PushRpc.pushUpStream(value.getTaskid(), PushUpType.TYPE_ACK, value.getJob(), value.getBid(), value.getMsgSource(), value.getMetadataMap());
                    Intent i = new Intent(InnerPushReceiverKt.getPushIntentAction(context));
                    i.setPackage(context.getPackageName());
                    json = InnerPushReceiverKt.toJson(value);
                    i.putExtra(InnerPushReceiverKt.KEY_EXTRA, json);
                    context.sendBroadcast(i);
                }
            }

            public void onError(MossException t) {
                if (t != null) {
                    BLog.efmt("InnerPushReceiver", t.toPrintString(), new Object[0]);
                }
            }

            public void onCompleted() {
                BLog.i("InnerPushReceiver", "onCompleted");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toJson(PushMessageResp value) {
        try {
            int bid = value.getBid();
            String taskid = value.getTaskid();
            String title = value.getTitle();
            String summary = value.getSummary();
            String img = value.getImg();
            String link = value.getLink();
            long duration = value.getDuration();
            long expire = value.getExpire();
            List<String> pageBlackList = getPageBlackList(value);
            List<String> pageViewList = getPageViewList(value);
            BizParams targetResource = getTargetResource(value);
            int number = value.getImageFrame().getNumber();
            int number2 = value.getImageMarker().getNumber();
            long job = value.getJob();
            int level = value.getLevel();
            boolean query = value.getQuery();
            InnerPush innerPush = new InnerPush(bid, value.getType().getNumber(), title, summary, link, duration, expire, img, taskid, value.getDisplayType().getNumber(), value.getPureImg(), value.getPopType().getNumber(), pageBlackList, pageViewList, targetResource, number, number2, job, value.getMsgSource(), value.getHideArrow(), value.getReserve(), value.getMetadataMap(), 0, level, query, 0L, value.getExtra(), value.getMsgType().getNumber(), 33554432, (DefaultConstructorMarker) null);
            return new Gson().toJson(innerPush);
        } catch (Throwable e) {
            BLog.e(TAG, e.toString());
            return null;
        }
    }

    private static final BizParams getTargetResource(PushMessageResp value) {
        TargetResource resource = value.getTargetResource();
        if (resource == null) {
            return null;
        }
        return new BizParams(String.valueOf(resource.getType().getNumber()), resource.getResourceMap());
    }

    private static final List<String> getPageBlackList(PushMessageResp value) {
        List data = value.getPageBlackListList();
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        List $this$map$iv = data;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PageBlackList it = (PageBlackList) item$iv$iv;
            destination$iv$iv.add(it.getId());
        }
        return (List) destination$iv$iv;
    }

    private static final List<String> getPageViewList(PushMessageResp value) {
        List data = value.getPageViewList();
        if (data == null) {
            data = CollectionsKt.emptyList();
        }
        List $this$map$iv = data;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PageView it = (PageView) item$iv$iv;
            destination$iv$iv.add(it.getId());
        }
        return (List) destination$iv$iv;
    }
}