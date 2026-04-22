package kntr.app.appwidget.guide;

import androidx.fragment.app.FragmentActivity;
import com.bapis.bilibili.app.show.mixture.v1.KGuideTip;
import com.bapis.bilibili.app.show.mixture.v1.KUpItem;
import com.bapis.bilibili.app.show.mixture.v1.KWidgetGuideReply;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.appwidget.guide.GuideState;
import kntr.app.appwidget.guide.model.WidgetGuidePopupParams;
import kntr.app.appwidget.guide.service.AppWidgetGuideServiceKt;
import kntr.app.appwidget.guide.utils.AppWidgetManager_androidKt;
import kntr.app.appwidget.guide.utils.ReportHelperKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AppWidgetGuideHolder.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010 J\u0017\u0010!\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\"R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/appwidget/guide/AppWidgetGuideHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/appwidget/guide/GuideState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "currentState", "getCurrentState", "()Lkntr/app/appwidget/guide/GuideState;", "showGuide", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Landroidx/fragment/app/FragmentActivity;", "Lkntr/app/appwidget/guide/PlatformContext;", "component", RoomRecommendViewModel.EMPTY_CURSOR, "spmid", "upperMid", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "offset", "duration", "outsideTouchable", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.AID, "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;JIIJZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeGuide", "(Landroidx/fragment/app/FragmentActivity;)V", "Companion", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppWidgetGuideHolder {
    private static final String TAG = "AppWidgetGuideHolder";
    private final MutableStateFlow<GuideState> _stateFlow = StateFlowKt.MutableStateFlow(GuideState.Idle.INSTANCE);
    private final StateFlow<GuideState> stateFlow = FlowKt.asStateFlow(this._stateFlow);
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public final StateFlow<GuideState> getStateFlow() {
        return this.stateFlow;
    }

    private final GuideState getCurrentState() {
        return (GuideState) this.stateFlow.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showGuide(FragmentActivity context, String component, String spmid, long upperMid, int type, int offset, long duration, boolean outsideTouchable, long aid, Continuation<? super Unit> continuation) {
        AppWidgetGuideHolder$showGuide$1 appWidgetGuideHolder$showGuide$1;
        long upperMid2;
        int type2;
        int offset2;
        long duration2;
        boolean outsideTouchable2;
        long aid2;
        Object obj;
        final String spmid2;
        FragmentActivity context2;
        String component2;
        final KWidgetGuideReply reply;
        KGuideTip it;
        String str;
        KWidgetGuideReply reply2;
        String spmid3;
        int type3;
        long duration3;
        boolean outsideTouchable3;
        long aid3;
        if (continuation instanceof AppWidgetGuideHolder$showGuide$1) {
            appWidgetGuideHolder$showGuide$1 = (AppWidgetGuideHolder$showGuide$1) continuation;
            if ((appWidgetGuideHolder$showGuide$1.label & Integer.MIN_VALUE) != 0) {
                appWidgetGuideHolder$showGuide$1.label -= Integer.MIN_VALUE;
                Object $result = appWidgetGuideHolder$showGuide$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (appWidgetGuideHolder$showGuide$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!AppWidgetManager_androidKt.checkAddAppWidgetRequest(context, component)) {
                            KLog_androidKt.getKLog().i(TAG, "startGuide > appwidget not support or added");
                            this._stateFlow.setValue(GuideState.NoGuide.INSTANCE);
                            return Unit.INSTANCE;
                        }
                        appWidgetGuideHolder$showGuide$1.L$0 = context;
                        appWidgetGuideHolder$showGuide$1.L$1 = SpillingKt.nullOutSpilledVariable(component);
                        appWidgetGuideHolder$showGuide$1.L$2 = spmid;
                        upperMid2 = upperMid;
                        appWidgetGuideHolder$showGuide$1.J$0 = upperMid2;
                        appWidgetGuideHolder$showGuide$1.I$0 = type;
                        appWidgetGuideHolder$showGuide$1.I$1 = offset;
                        appWidgetGuideHolder$showGuide$1.J$1 = duration;
                        appWidgetGuideHolder$showGuide$1.Z$0 = outsideTouchable;
                        appWidgetGuideHolder$showGuide$1.J$2 = aid;
                        appWidgetGuideHolder$showGuide$1.label = 1;
                        Object widgetGuide = AppWidgetGuideServiceKt.getWidgetGuide(spmid, type, upperMid, aid, appWidgetGuideHolder$showGuide$1);
                        if (widgetGuide != coroutine_suspended) {
                            type2 = type;
                            offset2 = offset;
                            duration2 = duration;
                            outsideTouchable2 = outsideTouchable;
                            aid2 = aid;
                            obj = widgetGuide;
                            spmid2 = spmid;
                            context2 = context;
                            component2 = component;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        long aid4 = appWidgetGuideHolder$showGuide$1.J$2;
                        boolean outsideTouchable4 = appWidgetGuideHolder$showGuide$1.Z$0;
                        duration2 = appWidgetGuideHolder$showGuide$1.J$1;
                        offset2 = appWidgetGuideHolder$showGuide$1.I$1;
                        type2 = appWidgetGuideHolder$showGuide$1.I$0;
                        upperMid2 = appWidgetGuideHolder$showGuide$1.J$0;
                        spmid2 = (String) appWidgetGuideHolder$showGuide$1.L$2;
                        component2 = (String) appWidgetGuideHolder$showGuide$1.L$1;
                        ResultKt.throwOnFailure($result);
                        aid2 = aid4;
                        obj = $result;
                        outsideTouchable2 = outsideTouchable4;
                        context2 = (FragmentActivity) appWidgetGuideHolder$showGuide$1.L$0;
                        break;
                    case 2:
                        int i = appWidgetGuideHolder$showGuide$1.I$2;
                        aid3 = appWidgetGuideHolder$showGuide$1.J$2;
                        outsideTouchable3 = appWidgetGuideHolder$showGuide$1.Z$0;
                        long duration4 = appWidgetGuideHolder$showGuide$1.J$1;
                        int i2 = appWidgetGuideHolder$showGuide$1.I$1;
                        type3 = appWidgetGuideHolder$showGuide$1.I$0;
                        long j2 = appWidgetGuideHolder$showGuide$1.J$0;
                        List list = (List) appWidgetGuideHolder$showGuide$1.L$6;
                        WidgetGuidePopupParams widgetGuidePopupParams = (WidgetGuidePopupParams) appWidgetGuideHolder$showGuide$1.L$5;
                        KGuideTip kGuideTip = (KGuideTip) appWidgetGuideHolder$showGuide$1.L$4;
                        KWidgetGuideReply reply3 = (KWidgetGuideReply) appWidgetGuideHolder$showGuide$1.L$3;
                        String spmid4 = (String) appWidgetGuideHolder$showGuide$1.L$2;
                        String str2 = (String) appWidgetGuideHolder$showGuide$1.L$1;
                        FragmentActivity fragmentActivity = (FragmentActivity) appWidgetGuideHolder$showGuide$1.L$0;
                        ResultKt.throwOnFailure($result);
                        str = "follow";
                        reply2 = reply3;
                        spmid3 = spmid4;
                        duration3 = duration4;
                        ReportHelperKt.reportGuideBannerShow(spmid3, str);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                reply = (KWidgetGuideReply) obj;
                ReportHelperKt.reportAutoAddGuideRequest(spmid2, "follow", reply == null ? reply.getCode() : 0, AppWidgetGuideServiceKt.show(reply) ? 1 : 0);
                if (AppWidgetGuideServiceKt.show(reply)) {
                    this._stateFlow.setValue(GuideState.NoGuide.INSTANCE);
                    return Unit.INSTANCE;
                } else if (reply == null || (it = reply.getTip()) == null) {
                    AppWidgetGuideHolder $this$showGuide_u24lambda_u241 = this;
                    $this$showGuide_u24lambda_u241._stateFlow.setValue(GuideState.NoGuide.INSTANCE);
                    return Unit.INSTANCE;
                } else {
                    str = "follow";
                    Iterable upItems = it.getUpItems();
                    int type4 = type2;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(upItems, 10));
                    Iterable $this$mapTo$iv$iv = upItems;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        KUpItem item = (KUpItem) item$iv$iv;
                        destination$iv$iv.add(item.getIcon());
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    List avatars = (List) destination$iv$iv;
                    long upperMid3 = upperMid2;
                    WidgetGuidePopupParams params = new WidgetGuidePopupParams(avatars, it.getTitle(), it.getSubtitle(), outsideTouchable2, offset2, duration2, ((int) it.getStyle()) == 2, (int) it.getStyle(), new Function1() { // from class: kntr.app.appwidget.guide.AppWidgetGuideHolder$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit showGuide$lambda$0$1;
                            showGuide$lambda$0$1 = AppWidgetGuideHolder.showGuide$lambda$0$1(spmid2, this, ((Boolean) obj2).booleanValue());
                            return showGuide$lambda$0$1;
                        }
                    }, new Function0() { // from class: kntr.app.appwidget.guide.AppWidgetGuideHolder$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit showGuide$lambda$0$2;
                            showGuide$lambda$0$2 = AppWidgetGuideHolder.showGuide$lambda$0$2(spmid2, this, reply);
                            return showGuide$lambda$0$2;
                        }
                    });
                    appWidgetGuideHolder$showGuide$1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                    appWidgetGuideHolder$showGuide$1.L$1 = SpillingKt.nullOutSpilledVariable(component2);
                    appWidgetGuideHolder$showGuide$1.L$2 = spmid2;
                    appWidgetGuideHolder$showGuide$1.L$3 = SpillingKt.nullOutSpilledVariable(reply);
                    appWidgetGuideHolder$showGuide$1.L$4 = SpillingKt.nullOutSpilledVariable(it);
                    appWidgetGuideHolder$showGuide$1.L$5 = SpillingKt.nullOutSpilledVariable(params);
                    appWidgetGuideHolder$showGuide$1.L$6 = SpillingKt.nullOutSpilledVariable(avatars);
                    appWidgetGuideHolder$showGuide$1.J$0 = upperMid3;
                    appWidgetGuideHolder$showGuide$1.I$0 = type4;
                    appWidgetGuideHolder$showGuide$1.I$1 = offset2;
                    appWidgetGuideHolder$showGuide$1.J$1 = duration2;
                    appWidgetGuideHolder$showGuide$1.Z$0 = outsideTouchable2;
                    long aid5 = aid2;
                    appWidgetGuideHolder$showGuide$1.J$2 = aid5;
                    appWidgetGuideHolder$showGuide$1.I$2 = 0;
                    appWidgetGuideHolder$showGuide$1.label = 2;
                    if (PlatformContext_androidKt.showGuidePopup(context2, params, appWidgetGuideHolder$showGuide$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    reply2 = reply;
                    spmid3 = spmid2;
                    type3 = type4;
                    duration3 = duration2;
                    outsideTouchable3 = outsideTouchable2;
                    aid3 = aid5;
                    ReportHelperKt.reportGuideBannerShow(spmid3, str);
                    return Unit.INSTANCE;
                }
            }
        }
        appWidgetGuideHolder$showGuide$1 = new AppWidgetGuideHolder$showGuide$1(this, continuation);
        Object $result2 = appWidgetGuideHolder$showGuide$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (appWidgetGuideHolder$showGuide$1.label) {
        }
        reply = (KWidgetGuideReply) obj;
        ReportHelperKt.reportAutoAddGuideRequest(spmid2, "follow", reply == null ? reply.getCode() : 0, AppWidgetGuideServiceKt.show(reply) ? 1 : 0);
        if (AppWidgetGuideServiceKt.show(reply)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGuide$lambda$0$1(String $spmid, AppWidgetGuideHolder this$0, boolean report) {
        if (report) {
            ReportHelperKt.reportGuideBannerClick($spmid, "follow", 2);
        }
        this$0._stateFlow.setValue(GuideState.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGuide$lambda$0$2(String $spmid, AppWidgetGuideHolder this$0, KWidgetGuideReply $reply) {
        ReportHelperKt.reportGuideBannerClick($spmid, "follow", 1);
        this$0._stateFlow.setValue(new GuideState.PerformAction($reply.getGuideItem()));
        return Unit.INSTANCE;
    }

    public final void closeGuide(FragmentActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getCurrentState() instanceof GuideState.NoGuide) {
            return;
        }
        PlatformContext_androidKt.closeGuidePopup(context);
        this._stateFlow.setValue(GuideState.NoGuide.INSTANCE);
    }

    /* compiled from: AppWidgetGuideHolder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/appwidget/guide/AppWidgetGuideHolder$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}