package tv.danmaku.bili.appwidget.hotlist;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModelKt;
import tv.danmaku.bili.appwidget.hotlist.moss.HotListMossKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotListAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.HotListAppWidgetUpdaterKt$update$1", f = "HotListAppWidgetUpdater.kt", i = {0}, l = {100, BR.constraintSetModifier, BR.comment, BR.content}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class HotListAppWidgetUpdaterKt$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $appStatus;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $updateReason;
    final /* synthetic */ int[] $widgetIds;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotListAppWidgetUpdaterKt$update$1(Ref.IntRef intRef, String str, Context context, AppWidgetManager appWidgetManager, int[] iArr, Continuation<? super HotListAppWidgetUpdaterKt$update$1> continuation) {
        super(2, continuation);
        this.$appStatus = intRef;
        this.$updateReason = str;
        this.$context = context;
        this.$appWidgetManager = appWidgetManager;
        this.$widgetIds = iArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hotListAppWidgetUpdaterKt$update$1 = new HotListAppWidgetUpdaterKt$update$1(this.$appStatus, this.$updateReason, this.$context, this.$appWidgetManager, this.$widgetIds, continuation);
        hotListAppWidgetUpdaterKt$update$1.L$0 = obj;
        return hotListAppWidgetUpdaterKt$update$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$launch;
        Object updateWidgetView;
        List list;
        CoroutineScope $this$launch2;
        HotListWidgetModel data;
        Object updateWidgetView2;
        List list2;
        List list3;
        Context context;
        Object $result2;
        int[] iArr;
        AppWidgetManager appWidgetManager;
        CoroutineScope coroutineScope;
        Object updateWidgetView3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$launch = (CoroutineScope) this.L$0;
                if (this.$appStatus.element != 0) {
                    this.label = 4;
                    updateWidgetView = HotListAppWidgetUpdaterKt.updateWidgetView($this$launch, this.$context, this.$appWidgetManager, this.$widgetIds, null, this.$appStatus.element, (Continuation) this);
                    if (updateWidgetView == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                list = HotListAppWidgetUpdaterKt.ALLOW_LOAD_LOCAL_DATA_LIST;
                if (!list.contains(this.$updateReason)) {
                    $this$launch2 = $this$launch;
                    list3 = HotListAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                    if (list3.contains(this.$updateReason)) {
                    }
                    return Unit.INSTANCE;
                }
                HotListWidgetModel data2 = HotListWidgetModelKt.getLastWidgetData(this.$context);
                if (data2 == null) {
                    list2 = HotListAppWidgetUpdaterKt.ALLOW_LOAD_DEFAULT_IF_LOCAL_NULL;
                    if (list2.contains(this.$updateReason)) {
                        data = HotListWidgetModelKt.getDefaultWidgetData();
                        this.L$0 = $this$launch;
                        this.label = 1;
                        updateWidgetView2 = HotListAppWidgetUpdaterKt.updateWidgetView($this$launch, this.$context, this.$appWidgetManager, this.$widgetIds, data, this.$appStatus.element, (Continuation) this);
                        if (updateWidgetView2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$launch2 = $this$launch;
                        list3 = HotListAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                        if (list3.contains(this.$updateReason)) {
                            context = this.$context;
                            AppWidgetManager appWidgetManager2 = this.$appWidgetManager;
                            int[] iArr2 = this.$widgetIds;
                            this.L$0 = $this$launch2;
                            this.L$1 = context;
                            this.L$2 = appWidgetManager2;
                            this.L$3 = iArr2;
                            this.label = 2;
                            Object hostListData = HotListMossKt.getHostListData(this.$context, (Continuation) this);
                            if (hostListData == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result2 = $result;
                            $result = hostListData;
                            iArr = iArr2;
                            CoroutineScope coroutineScope2 = $this$launch2;
                            appWidgetManager = appWidgetManager2;
                            coroutineScope = coroutineScope2;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            updateWidgetView3 = HotListAppWidgetUpdaterKt.updateWidgetView(coroutineScope, context, appWidgetManager, iArr, (HotListWidgetModel) $result, this.$appStatus.element, (Continuation) this);
                            if (updateWidgetView3 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                data = data2;
                this.L$0 = $this$launch;
                this.label = 1;
                updateWidgetView2 = HotListAppWidgetUpdaterKt.updateWidgetView($this$launch, this.$context, this.$appWidgetManager, this.$widgetIds, data, this.$appStatus.element, (Continuation) this);
                if (updateWidgetView2 == coroutine_suspended) {
                }
                $this$launch2 = $this$launch;
                list3 = HotListAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                if (list3.contains(this.$updateReason)) {
                }
                return Unit.INSTANCE;
            case 1:
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$launch2 = $this$launch;
                list3 = HotListAppWidgetUpdaterKt.ALLOW_LOAD_REMOTE_DATA_LIST;
                if (list3.contains(this.$updateReason)) {
                }
                return Unit.INSTANCE;
            case 2:
                context = (Context) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                iArr = (int[]) this.L$3;
                $result2 = $result;
                appWidgetManager = (AppWidgetManager) this.L$2;
                coroutineScope = coroutineScope3;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                updateWidgetView3 = HotListAppWidgetUpdaterKt.updateWidgetView(coroutineScope, context, appWidgetManager, iArr, (HotListWidgetModel) $result, this.$appStatus.element, (Continuation) this);
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