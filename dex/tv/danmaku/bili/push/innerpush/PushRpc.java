package tv.danmaku.bili.push.innerpush;

import com.alibaba.fastjson.JSON;
import com.bapis.bilibili.broadcast.message.bgroup.AppEvent;
import com.bapis.bilibili.broadcast.message.bgroup.AppEventMessage;
import com.bapis.bilibili.broadcast.message.bgroup.BGroupMoss;
import com.bapis.bilibili.broadcast.message.push.PushUpStreamMoss;
import com.bapis.bilibili.broadcast.message.push.UpStreamMessage;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.GeneratedMessageLite;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: PushRpc.kt */
@Metadata(d1 = {"\u0000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0017\u001aL\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0017\u001aN\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0017H\u0007\u001a\u0016\u0010(\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*\"!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b \u0010\t\"\u000e\u0010\"\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&*D\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00030\u00022\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00030\u0002¨\u0006+"}, d2 = {"ServiceGenerator", "T", "Lkotlin/Function1;", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/google/protobuf/Empty;", "pushUp", "Ltv/danmaku/bili/push/innerpush/UploadStreamRpc;", "Lcom/bapis/bilibili/broadcast/message/push/UpStreamMessage;", "getPushUp", "()Ltv/danmaku/bili/push/innerpush/UploadStreamRpc;", "pushUp$delegate", "Lkotlin/Lazy;", "pushUpStreamForFilter", "", "taskId", "", "reason", "job", "", "bid", "msgSource", "serverFilterReason", InnerPushReceiverKt.KEY_EXTRA, "", "pushUpStreamForClick", "gesture", "", "pushUpStream", "type", "Ltv/danmaku/bili/push/innerpush/PushUpType;", "appEvent", "Lcom/bapis/bilibili/broadcast/message/bgroup/AppEventMessage;", "getAppEvent", "appEvent$delegate", "APP_EVENT_ENABLE_KEY", "appEventReportEnable", "", "getAppEventReportEnable", "()Z", "appEventReportEnable$delegate", "appEventStream", "Ltv/danmaku/bili/push/innerpush/AppEventType;", "(Ltv/danmaku/bili/push/innerpush/AppEventType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushRpc {
    private static final String APP_EVENT_ENABLE_KEY = "innerpush.enable_app_event_upload";
    private static final Lazy pushUp$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.PushRpc$$ExternalSyntheticLambda0
        public final Object invoke() {
            UploadStreamRpc pushUp_delegate$lambda$0;
            pushUp_delegate$lambda$0 = PushRpc.pushUp_delegate$lambda$0();
            return pushUp_delegate$lambda$0;
        }
    });
    private static final Lazy appEvent$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.PushRpc$$ExternalSyntheticLambda1
        public final Object invoke() {
            UploadStreamRpc appEvent_delegate$lambda$0;
            appEvent_delegate$lambda$0 = PushRpc.appEvent_delegate$lambda$0();
            return appEvent_delegate$lambda$0;
        }
    });
    private static final Lazy appEventReportEnable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.PushRpc$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean appEventReportEnable_delegate$lambda$0;
            appEventReportEnable_delegate$lambda$0 = PushRpc.appEventReportEnable_delegate$lambda$0();
            return Boolean.valueOf(appEventReportEnable_delegate$lambda$0);
        }
    });

    /* compiled from: PushRpc.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PushUpType.values().length];
            try {
                iArr[PushUpType.TYPE_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PushUpType.TYPE_ACK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PushUpType.TYPE_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PushUpType.TYPE_SHOW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PushUpType.TYPE_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AppEventType.values().length];
            try {
                iArr2[AppEventType.OnLaunch.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[AppEventType.OnBackground.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[AppEventType.OnForeground.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[AppEventType.OnBackHomepage.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void pushUpStream(String str, PushUpType pushUpType, long j, long j2, String str2) {
        Intrinsics.checkNotNullParameter(pushUpType, "type");
        pushUpStream$default(str, pushUpType, j, j2, str2, null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadStreamRpc<UpStreamMessage> getPushUp() {
        return (UploadStreamRpc) pushUp$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadStreamRpc pushUp_delegate$lambda$0() {
        return UploadStreamRpc.Companion.create("pushUpStream", new Function1() { // from class: tv.danmaku.bili.push.innerpush.PushRpc$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                MossResponseHandler pushUp_delegate$lambda$0$0;
                pushUp_delegate$lambda$0$0 = PushRpc.pushUp_delegate$lambda$0$0((MossResponseHandler) obj);
                return pushUp_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MossResponseHandler pushUp_delegate$lambda$0$0(MossResponseHandler it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new PushUpStreamMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).pushUpStream(it);
    }

    public static final void pushUpStreamForFilter(String taskId, String reason, long job, long bid, String msgSource, String serverFilterReason, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("reason", reason == null ? "" : reason);
        boolean z = false;
        if (!(map == null || map.isEmpty())) {
            map2.put(InnerPushReceiverKt.KEY_EXTRA, JSON.toJSONString(map));
        }
        String str = serverFilterReason;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (!z) {
            map2.put("server_filter_reason", serverFilterReason);
        }
        pushUpStream(taskId, PushUpType.TYPE_FILTER, job, bid, msgSource, map2);
    }

    public static final void pushUpStreamForClick(String taskId, int gesture, long job, long bid, String msgSource, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("gesture", String.valueOf(gesture));
        if (!(map == null || map.isEmpty())) {
            map2.put(InnerPushReceiverKt.KEY_EXTRA, JSON.toJSONString(map));
        }
        pushUpStream(taskId, PushUpType.TYPE_CLICK, job, bid, msgSource, map2);
    }

    public static /* synthetic */ void pushUpStream$default(String str, PushUpType pushUpType, long j, long j2, String str2, Map map, int i, Object obj) {
        pushUpStream(str, pushUpType, j, j2, str2, (i & 32) != 0 ? null : map);
    }

    public static final void pushUpStream(String taskId, PushUpType type, long job, long bid, String msgSource, Map<String, String> map) {
        UpStreamMessage.Type type2;
        Intrinsics.checkNotNullParameter(type, "type");
        UpStreamMessage.Builder builder = UpStreamMessage.newBuilder();
        builder.setTaskid(taskId == null ? "" : taskId);
        builder.setTimestamp(ServerClock.unreliableNow());
        boolean z = false;
        if (!(map == null || map.isEmpty())) {
            builder.setExtra(JSON.toJSONString(map));
        }
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                type2 = UpStreamMessage.Type.TYPE_UNKNOWN;
                break;
            case 2:
                type2 = UpStreamMessage.Type.TYPE_ACK;
                break;
            case 3:
                type2 = UpStreamMessage.Type.TYPE_FILTER;
                break;
            case 4:
                type2 = UpStreamMessage.Type.TYPE_SHOW;
                break;
            case 5:
                type2 = UpStreamMessage.Type.TYPE_CLICK;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        builder.setType(type2);
        builder.setJob(job);
        builder.setBid(bid);
        String str = msgSource;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (!z) {
            builder.setMsgSource(msgSource);
        }
        UpStreamMessage message = builder.build();
        BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new PushRpc$pushUpStream$1(message, null), 3, (Object) null);
    }

    private static final UploadStreamRpc<AppEventMessage> getAppEvent() {
        return (UploadStreamRpc) appEvent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadStreamRpc appEvent_delegate$lambda$0() {
        return UploadStreamRpc.Companion.create("appEventStream", new Function1() { // from class: tv.danmaku.bili.push.innerpush.PushRpc$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                MossResponseHandler appEvent_delegate$lambda$0$0;
                appEvent_delegate$lambda$0$0 = PushRpc.appEvent_delegate$lambda$0$0((MossResponseHandler) obj);
                return appEvent_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MossResponseHandler appEvent_delegate$lambda$0$0(MossResponseHandler it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new BGroupMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).appEventStream(it);
    }

    private static final boolean getAppEventReportEnable() {
        return ((Boolean) appEventReportEnable$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean appEventReportEnable_delegate$lambda$0() {
        return Intrinsics.areEqual(ConfigManager.Companion.ab().get(APP_EVENT_ENABLE_KEY, false), true);
    }

    public static final Object appEventStream(AppEventType type, Continuation<? super Unit> continuation) {
        AppEvent type2;
        if (!getAppEventReportEnable()) {
            return Unit.INSTANCE;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1:
                type2 = AppEvent.AppEventColdStart;
                break;
            case 2:
                type2 = AppEvent.AppEventInvisible;
                break;
            case 3:
                type2 = AppEvent.AppEventVisible;
                break;
            case 4:
                type2 = AppEvent.AppEventHomePage;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        UploadStreamRpc<AppEventMessage> appEvent = getAppEvent();
        GeneratedMessageLite build = AppEventMessage.newBuilder().setTimestamp(System.currentTimeMillis()).setEventType(type2).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        Object send = appEvent.send(build, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }
}