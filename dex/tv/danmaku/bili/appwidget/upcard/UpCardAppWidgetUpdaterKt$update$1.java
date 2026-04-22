package tv.danmaku.bili.appwidget.upcard;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.api.AppWidgetHelperKt;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.utils.SpUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetUpdaterKt$update$1", f = "UpCardAppWidgetUpdater.kt", i = {0, 1}, l = {BR.cornerVisible, BR.countdownTrackEnabled, BR.cover, BR.coverUrl}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
public final class UpCardAppWidgetUpdaterKt$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $appStatus;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $updateReason;
    final /* synthetic */ int[] $widgetIds;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpCardAppWidgetUpdaterKt$update$1(Ref.IntRef intRef, String str, Context context, AppWidgetManager appWidgetManager, int[] iArr, Continuation<? super UpCardAppWidgetUpdaterKt$update$1> continuation) {
        super(2, continuation);
        this.$appStatus = intRef;
        this.$updateReason = str;
        this.$context = context;
        this.$appWidgetManager = appWidgetManager;
        this.$widgetIds = iArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> upCardAppWidgetUpdaterKt$update$1 = new UpCardAppWidgetUpdaterKt$update$1(this.$appStatus, this.$updateReason, this.$context, this.$appWidgetManager, this.$widgetIds, continuation);
        upCardAppWidgetUpdaterKt$update$1.L$0 = obj;
        return upCardAppWidgetUpdaterKt$update$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[Catch: Exception -> 0x001b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:12:0x0022, B:28:0x0084), top: B:46:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$launch;
        Object updateWidgetView;
        List list;
        Object updateWidgetView2;
        List list2;
        List list3;
        CoroutineScope $this$launch2;
        Object $result2;
        Object updateWidgetView3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$launch = (CoroutineScope) this.L$0;
                if (this.$appStatus.element != 0) {
                    this.label = 4;
                    updateWidgetView = UpCardAppWidgetUpdaterKt.updateWidgetView($this$launch, this.$context, this.$appWidgetManager, this.$widgetIds, null, this.$appStatus.element, (Continuation) this);
                    if (updateWidgetView == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                list = UpCardAppWidgetUpdaterKt.ALLOW_LOAD_LOCAL_DATA_LIST;
                if (list.contains(this.$updateReason)) {
                    UpCardWidgetData data = SpUtilKt.getLocalWidgetData(this.$context);
                    if (data == null) {
                        list2 = UpCardAppWidgetUpdaterKt.ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL;
                        list2.contains(this.$updateReason);
                    }
                    this.L$0 = $this$launch;
                    this.label = 1;
                    updateWidgetView2 = UpCardAppWidgetUpdaterKt.updateWidgetView($this$launch, this.$context, this.$appWidgetManager, this.$widgetIds, data, this.$appStatus.element, (Continuation) this);
                    if (updateWidgetView2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                list3 = UpCardAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                if (list3.contains(this.$updateReason)) {
                    Context applicationContext = this.$context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    this.L$0 = $this$launch;
                    this.label = 2;
                    Object upCardWidgetApiData = AppWidgetHelperKt.getUpCardWidgetApiData(applicationContext, (Continuation) this);
                    if (upCardWidgetApiData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$launch2 = $this$launch;
                    $result2 = $result;
                    $result = upCardWidgetApiData;
                    try {
                        UpCardWidgetData dataFromNet = (UpCardWidgetData) $result;
                        this.L$0 = null;
                        this.label = 3;
                        updateWidgetView3 = UpCardAppWidgetUpdaterKt.updateWidgetView($this$launch2, this.$context, this.$appWidgetManager, this.$widgetIds, dataFromNet, this.$appStatus.element, (Continuation) this);
                        if (updateWidgetView3 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        BLog.e("UpCardAppWidgetUpdater", "getUpCardWidgetApiData error", e);
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                list3 = UpCardAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                if (list3.contains(this.$updateReason)) {
                }
                return Unit.INSTANCE;
            case 2:
                CoroutineScope $this$launch3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$launch2 = $this$launch3;
                $result2 = $result;
                UpCardWidgetData dataFromNet2 = (UpCardWidgetData) $result;
                this.L$0 = null;
                this.label = 3;
                updateWidgetView3 = UpCardAppWidgetUpdaterKt.updateWidgetView($this$launch2, this.$context, this.$appWidgetManager, this.$widgetIds, dataFromNet2, this.$appStatus.element, (Continuation) this);
                if (updateWidgetView3 != coroutine_suspended) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}