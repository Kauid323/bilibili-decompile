package tv.danmaku.bili.ui.splash.event;

import android.content.Context;
import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.event.EventSplashStorage$loadEventSplashData$1", f = "EventSplashStorage.kt", i = {}, l = {DynModuleType.module_manga_cover_pic_content_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class EventSplashStorage$loadEventSplashData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSplashStorage$loadEventSplashData$1(Context context, Continuation<? super EventSplashStorage$loadEventSplashData$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventSplashStorage$loadEventSplashData$1(this.$ctx, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                EventSplashStorage.INSTANCE.downloadBirthRes();
                Context context = this.$ctx;
                Intrinsics.checkNotNull(context);
                this.label = 1;
                Object eventSplashList = EventSplashServiceKt.getEventSplashList(context, (Continuation) this);
                if (eventSplashList != coroutine_suspended) {
                    $result = eventSplashList;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        com.bilibili.lib.arch.lifecycle.Resource response = (com.bilibili.lib.arch.lifecycle.Resource) $result;
        EventSplashDataList result = response != null ? (EventSplashDataList) response.getData() : null;
        if (result != null) {
            EventSplashStorage.INSTANCE.cacheEventSplashResource(result);
            EventSplashStorage.INSTANCE.setLocalEventSplashData(result);
            return Unit.INSTANCE;
        }
        BLog.i("[EventSplash]EventSplashStorage", "get event list failed status:" + (response != null ? response.getStatus() : null), response != null ? response.getError() : null);
        return Unit.INSTANCE;
    }
}