package kntr.app.ad.domain.click.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.common.utils.TimeKt;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.action.ActionDispatcher;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.inspector.AdInspectorManager;
import kntr.app.ad.domain.inspector.core.work.IStage;
import kntr.app.ad.domain.macrosubst.AdMacroSubst;
import kntr.app.ad.domain.report.AdReportHub;
import kntr.app.ad.domain.track.AdTrack;
import kntr.app.ad.domain.track.AdTrackCommonParams;
import kntr.app.ad.domain.track.AdTrackEvent;
import kntr.app.ad.domain.track.IAdTrackCommonParams;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportFee;
import kntr.app.ad.protocol.report.IReportMMA;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickContext.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020#J\u0016\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u001e\u00104\u001a\u00020 2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u000106J+\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002092\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020 \u0018\u000101¢\u0006\u0002\b3H\u0016J+\u0010;\u001a\u00020 2\u0006\u00108\u001a\u00020<2\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020 \u0018\u000101¢\u0006\u0002\b3H\u0016J\u001a\u0010=\u001a\u00020 2\u0010\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010?H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010,2\b\u0010A\u001a\u0004\u0018\u00010,J\u0018\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020O2\b\u0010A\u001a\u0004\u0018\u00010,J\u0018\u0010P\u001a\u00020 2\u0006\u0010N\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SJ*\u0010T\u001a\u00020 2\u0006\u0010N\u001a\u00020U2\b\u0010A\u001a\u0004\u0018\u00010,2\u0010\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010?R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R!\u00100\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020 \u0018\u000101¢\u0006\u0002\b3X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010ER\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bJ\u0010K¨\u0006W"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkntr/app/ad/domain/click/IClickContext;", "service", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkntr/app/ad/domain/click/ClickService;)V", "getService", "()Lkntr/app/ad/domain/click/ClickService;", "hasShowSystemCallUpDialog", RoomRecommendViewModel.EMPTY_CURSOR, "getHasShowSystemCallUpDialog", "()Z", "setHasShowSystemCallUpDialog", "(Z)V", "hasDialogCancelJump", "getHasDialogCancelJump", "setHasDialogCancelJump", "isDoubleJumping", "setDoubleJumping", "isDlSucCallUping", "setDlSucCallUping", "hasJumped", "getHasJumped", "setHasJumped", "hasJumpedToThirdApp", "getHasJumpedToThirdApp", "setHasJumpedToThirdApp", "isValidClick", "setValidClick", "isInstalled", "setInstalled", "reset", RoomRecommendViewModel.EMPTY_CURSOR, "dispatchers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionDispatcher;", "addActionDispatcher", "dispatcher", "dispatchActionResult", "context", "actionResult", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getReportParams", "()Ljava/util/Map;", "solidifyHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "solidifyReportParams", "params", RoomRecommendViewModel.EMPTY_CURSOR, "reportUi", "event", "Lkntr/app/ad/domain/click/internal/ActionUiEvent;", "extraHandler", "reportFee", "Lkntr/app/ad/domain/click/internal/ActionFeeEvent;", "reportMMA", "urls", RoomRecommendViewModel.EMPTY_CURSOR, "macroSubst", "url", "stage", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "getStage", "()Lkntr/app/ad/domain/inspector/core/work/IStage;", "stage$delegate", "Lkotlin/Lazy;", "trackParams", "Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "getTrackParams", "()Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "trackParams$delegate", "trackClick", "result", "Lkntr/app/ad/domain/click/internal/ClickTrackResult;", "trackWxCallUp", "Lkntr/app/ad/domain/click/internal/WxProgramCallUpTrackResult;", "wxProgramInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "trackAppCallUp", "Lkntr/app/ad/domain/click/internal/AppCallUpTrackResult;", "openWhiteList", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickContext implements IClickContext {
    private final List<ActionDispatcher> dispatchers;
    private boolean hasDialogCancelJump;
    private boolean hasJumped;
    private boolean hasJumpedToThirdApp;
    private boolean hasShowSystemCallUpDialog;
    private boolean isDlSucCallUping;
    private boolean isDoubleJumping;
    private boolean isInstalled;
    private boolean isValidClick;
    private final Map<String, Object> reportParams;
    private final ClickService service;
    private Function1<? super IReportExtraHandler, Unit> solidifyHandler;
    private final Lazy stage$delegate;
    private final Lazy trackParams$delegate;

    public ClickContext(ClickService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        this.dispatchers = new ArrayList();
        this.reportParams = new LinkedHashMap();
        this.stage$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.click.internal.ClickContext$$ExternalSyntheticLambda1
            public final Object invoke() {
                IStage stage_delegate$lambda$0;
                stage_delegate$lambda$0 = ClickContext.stage_delegate$lambda$0(ClickContext.this);
                return stage_delegate$lambda$0;
            }
        });
        this.trackParams$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.click.internal.ClickContext$$ExternalSyntheticLambda2
            public final Object invoke() {
                IAdTrackCommonParams trackParams_delegate$lambda$0;
                trackParams_delegate$lambda$0 = ClickContext.trackParams_delegate$lambda$0(ClickContext.this);
                return trackParams_delegate$lambda$0;
            }
        });
    }

    public final ClickService getService() {
        return this.service;
    }

    public final boolean getHasShowSystemCallUpDialog() {
        return this.hasShowSystemCallUpDialog;
    }

    public final void setHasShowSystemCallUpDialog(boolean z) {
        this.hasShowSystemCallUpDialog = z;
    }

    public final boolean getHasDialogCancelJump() {
        return this.hasDialogCancelJump;
    }

    public final void setHasDialogCancelJump(boolean z) {
        this.hasDialogCancelJump = z;
    }

    public final boolean isDoubleJumping() {
        return this.isDoubleJumping;
    }

    public final void setDoubleJumping(boolean z) {
        this.isDoubleJumping = z;
    }

    public final boolean isDlSucCallUping() {
        return this.isDlSucCallUping;
    }

    public final void setDlSucCallUping(boolean z) {
        this.isDlSucCallUping = z;
    }

    public final boolean getHasJumped() {
        return this.hasJumped;
    }

    public final void setHasJumped(boolean z) {
        this.hasJumped = z;
    }

    public final boolean getHasJumpedToThirdApp() {
        return this.hasJumpedToThirdApp;
    }

    public final void setHasJumpedToThirdApp(boolean z) {
        this.hasJumpedToThirdApp = z;
    }

    public final boolean isValidClick() {
        return this.isValidClick;
    }

    public final void setValidClick(boolean z) {
        this.isValidClick = z;
    }

    public final boolean isInstalled() {
        return this.isInstalled;
    }

    public final void setInstalled(boolean z) {
        this.isInstalled = z;
    }

    public final void reset() {
        this.hasShowSystemCallUpDialog = false;
        this.hasDialogCancelJump = false;
        this.isDoubleJumping = false;
        this.isDlSucCallUping = false;
        this.hasJumped = false;
        this.reportParams.clear();
    }

    public final void addActionDispatcher(ActionDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatchers.add(dispatcher);
    }

    public final void dispatchActionResult(ClickContext context, ActionResult actionResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionResult, "actionResult");
        Iterable $this$forEach$iv = this.dispatchers;
        for (Object element$iv : $this$forEach$iv) {
            ActionDispatcher it = (ActionDispatcher) element$iv;
            it.onActionResult(context, actionResult);
        }
    }

    public final Map<String, Object> getReportParams() {
        return this.reportParams;
    }

    public final void solidifyReportParams(final Map<String, ? extends Object> map) {
        this.reportParams.put("is_click_v3", "1");
        this.solidifyHandler = new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickContext$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit solidifyReportParams$lambda$0;
                solidifyReportParams$lambda$0 = ClickContext.solidifyReportParams$lambda$0(ClickContext.this, map, (IReportExtraHandler) obj);
                return solidifyReportParams$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit solidifyReportParams$lambda$0(ClickContext this$0, Map $params, IReportExtraHandler iReportExtraHandler) {
        Intrinsics.checkNotNullParameter(iReportExtraHandler, "<this>");
        Map $this$forEach$iv = this$0.service.getGlobalReportParams();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String k = element$iv.getKey();
                Object v = element$iv.getValue();
                iReportExtraHandler.put(k, v);
            }
        }
        for (Map.Entry element$iv2 : this$0.reportParams.entrySet()) {
            String k2 = element$iv2.getKey();
            Object v2 = element$iv2.getValue();
            iReportExtraHandler.put(k2, v2);
        }
        if ($params != null) {
            for (Map.Entry element$iv3 : $params.entrySet()) {
                String k3 = (String) element$iv3.getKey();
                Object v3 = element$iv3.getValue();
                iReportExtraHandler.put(k3, v3);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.click.IClickContext
    public void reportUi(ActionUiEvent event, final Function1<? super IReportExtraHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.service.shouldReportUI(event.getValue())) {
            IReportUI.CC.event$default(AdReportHub.Companion.getUi(), event.getValue(), this.service.getReportable(), false, null, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickContext$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit reportUi$lambda$0;
                    reportUi$lambda$0 = ClickContext.reportUi$lambda$0(ClickContext.this, function1, (IReportExtraHandler) obj);
                    return reportUi$lambda$0;
                }
            }, 12, null);
            Logger_androidKt.getAdLog().d("KAdClick", "    >> reportUi: " + event.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportUi$lambda$0(ClickContext this$0, Function1 $extraHandler, IReportExtraHandler $this$event) {
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        Function1<? super IReportExtraHandler, Unit> function1 = this$0.solidifyHandler;
        if (function1 != null) {
            function1.invoke($this$event);
        }
        if ($extraHandler != null) {
            $extraHandler.invoke($this$event);
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.click.IClickContext
    public void reportFee(ActionFeeEvent event, final Function1<? super IReportExtraHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.service.shouldReportFee(event.getValue())) {
            IReportFee.CC.event$default(AdReportHub.Companion.getFee(), event.getValue(), this.service.getReportable(), false, null, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickContext$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit reportFee$lambda$0;
                    reportFee$lambda$0 = ClickContext.reportFee$lambda$0(ClickContext.this, function1, (IReportExtraHandler) obj);
                    return reportFee$lambda$0;
                }
            }, 12, null);
            Logger_androidKt.getAdLog().d("KAdClick", "    >> reportFee: " + event.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportFee$lambda$0(ClickContext this$0, Function1 $extraHandler, IReportExtraHandler $this$event) {
        Intrinsics.checkNotNullParameter($this$event, "$this$event");
        Function1<? super IReportExtraHandler, Unit> function1 = this$0.solidifyHandler;
        if (function1 != null) {
            function1.invoke($this$event);
        }
        if ($extraHandler != null) {
            $extraHandler.invoke($this$event);
        }
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.click.IClickContext
    public void reportMMA(List<String> list) {
        if (this.service.shouldReportThird(list)) {
            IReportMMA.CC.click$default(AdReportHub.Companion.getMma(), this.service.getReportable(), list, this.service.getMotion(), false, null, null, 56, null);
            Logger_androidKt.getAdLog().d("KAdClick", "    >> reportMMA: " + list);
        }
    }

    public final String macroSubst(String url) {
        String str = url;
        return str == null || str.length() == 0 ? url : AdMacroSubst.Companion.process(url, this.service.getReportable(), String.valueOf(TimeKt.getCurrentTimeMillis()), this.service.getMotion());
    }

    public final IStage getStage() {
        return (IStage) this.stage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IStage stage_delegate$lambda$0(ClickContext this$0) {
        AdInspectorManager adInspectorManager = AdInspectorManager.INSTANCE;
        IReportable reportable = this$0.service.getReportable();
        return adInspectorManager.getInteractingStage(reportable != null ? reportable.getAdCb() : null);
    }

    private final IAdTrackCommonParams getTrackParams() {
        return (IAdTrackCommonParams) this.trackParams$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAdTrackCommonParams trackParams_delegate$lambda$0(ClickContext this$0) {
        IReportable it = this$0.service.getReportable();
        if (it != null) {
            return new AdTrackCommonParams(it.getRequestId(), it.getResourceId(), String.valueOf(it.getSourceId()), it.getCreativeId(), RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR);
        }
        return AdTrackCommonParams.Empty;
    }

    public final void trackClick(ClickTrackResult result, String url) {
        Intrinsics.checkNotNullParameter(result, "result");
        AdTrack.INSTANCE.track(AdTrackEvent.CLICK, getTrackParams(), MapsKt.mapOf(new Pair[]{TuplesKt.to("code", result.getCode()), TuplesKt.to("desc", result.getDesc()), TuplesKt.to("url", url)}));
    }

    public final void trackWxCallUp(WxProgramCallUpTrackResult result, AdWxProgramInfo wxProgramInfo) {
        Intrinsics.checkNotNullParameter(result, "result");
        AdTrack adTrack = AdTrack.INSTANCE;
        AdTrackEvent adTrackEvent = AdTrackEvent.WX_CALL_UP;
        IAdTrackCommonParams trackParams = getTrackParams();
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("code", result.getCode());
        pairArr[1] = TuplesKt.to("desc", result.getDesc());
        pairArr[2] = TuplesKt.to("org_id", wxProgramInfo != null ? wxProgramInfo.getOrgId() : null);
        pairArr[3] = TuplesKt.to("name", wxProgramInfo != null ? wxProgramInfo.getName() : null);
        pairArr[4] = TuplesKt.to("path", wxProgramInfo != null ? wxProgramInfo.getPath() : null);
        adTrack.track(adTrackEvent, trackParams, MapsKt.mapOf(pairArr));
    }

    public final void trackAppCallUp(AppCallUpTrackResult result, String url, List<String> list) {
        Intrinsics.checkNotNullParameter(result, "result");
        AdTrack adTrack = AdTrack.INSTANCE;
        AdTrackEvent adTrackEvent = AdTrackEvent.APP_CALL_UP;
        IAdTrackCommonParams trackParams = getTrackParams();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("code", result.getCode());
        pairArr[1] = TuplesKt.to("desc", result.getDesc());
        pairArr[2] = TuplesKt.to("url", url);
        pairArr[3] = TuplesKt.to("white_list", list != null ? list.toString() : null);
        adTrack.track(adTrackEvent, trackParams, MapsKt.mapOf(pairArr));
    }
}