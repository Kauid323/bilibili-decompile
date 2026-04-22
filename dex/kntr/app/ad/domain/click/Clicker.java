package kntr.app.ad.domain.click;

import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.domain.click.internal.ActionUiExtra;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.ClickInspector;
import kntr.app.ad.domain.click.internal.ClickReport;
import kntr.app.ad.domain.click.internal.ClickRequest;
import kntr.app.ad.domain.click.internal.ClickTrack;
import kntr.app.ad.domain.click.internal.ClickTrackResult;
import kntr.app.ad.domain.click.internal.action.ActionChain;
import kntr.app.ad.domain.click.internal.action.ActionChainBuilder;
import kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001fJ4\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tRn\u0010\n\u001ab\u0012^\u0012\\\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010j\b\u0012\u0004\u0012\u00020\u000f`\u00130\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkntr/app/ad/domain/click/Clicker;", RoomRecommendViewModel.EMPTY_CURSOR, "service", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkntr/app/ad/domain/click/ClickService;)V", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "getContext$click_debug", "()Lkntr/app/ad/domain/click/internal/ClickContext;", "steps", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/Pair;", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/ClickArg;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "chain", "Lkntr/app/ad/domain/click/internal/action/ActionChain;", "click", "request", "Lkntr/app/ad/domain/click/internal/ClickRequest;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "click$click_debug", "(Lkntr/app/ad/domain/click/internal/ClickRequest;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "innerClick", "(Lkntr/app/ad/domain/click/internal/ClickRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "degradeToUrl", "canOpenWx", "canOpenULink", "url", "(Lkntr/app/ad/domain/click/internal/ClickRequest;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequest", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Clicker {
    private final ActionChain chain;
    private final ClickContext context;
    private final List<Pair<Function1<ClickArg, ActionParam>, Function3<ActionParam, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>>> steps;

    public Clicker(ClickService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        ClickContext $this$context_u24lambda_u240 = new ClickContext(service);
        $this$context_u24lambda_u240.addActionDispatcher(ClickReport.INSTANCE);
        if (service.getReportable() != null) {
            $this$context_u24lambda_u240.addActionDispatcher(ClickInspector.INSTANCE);
            $this$context_u24lambda_u240.addActionDispatcher(ClickTrack.INSTANCE);
        }
        this.context = $this$context_u24lambda_u240;
        ActionChainBuilder $this$steps_u24lambda_u240 = new ActionChainBuilder();
        ActionChainBuilderKt.addDefault($this$steps_u24lambda_u240);
        this.steps = $this$steps_u24lambda_u240.build$click_debug(this.context);
        this.chain = new ActionChain(this.steps);
    }

    public final ClickContext getContext$click_debug() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object click$click_debug$default(Clicker clicker, ClickRequest clickRequest, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return clicker.click$click_debug(clickRequest, map, continuation);
    }

    public final Object click$click_debug(ClickRequest request, Map<String, ? extends Object> map, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new Clicker$click$2(this, map, request, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x052a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0573  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ee  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x03ca -> B:172:0x0569). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x0474 -> B:137:0x047d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x0564 -> B:172:0x0569). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x02dd -> B:172:0x0569). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object innerClick(ClickRequest request, Continuation<? super Boolean> continuation) {
        Continuation<? super Boolean> clicker$innerClick$1;
        Clicker clicker;
        ClickArg arg;
        Ref.ObjectRef current;
        ClickRequest request2;
        Clicker clicker2;
        String dlSucCallUpUrl;
        Object obj;
        Object $result;
        Ref.ObjectRef current2;
        ClickRequest request3;
        String dlSucCallUpUrl2;
        Object obj2;
        Object $result2;
        Clicker clicker3;
        String dlSucCallUpUrl3;
        Ref.ObjectRef current3;
        ClickRequest request4;
        Object obj3;
        Object $result3;
        boolean mainResult;
        String dlSucCallUpUrl4;
        Ref.ObjectRef current4;
        ClickRequest request5;
        Clicker clicker4;
        String dlSucCallUpUrl5;
        Ref.ObjectRef current5;
        Object obj4;
        Object $result4;
        Ref.ObjectRef current6;
        ClickRequest request6;
        Clicker clicker5;
        Clicker clicker6;
        String dlSucCallUpUrl6;
        Ref.ObjectRef current7;
        Object obj5;
        Object $result5;
        ClickRequest request7;
        Clicker clicker7;
        Ref.ObjectRef current8;
        boolean minorResult;
        Function0<Unit> onAnswered$click_debug;
        Ref.ObjectRef current9;
        String dlSucCallUpUrl7;
        String callUpUrl;
        String callUpUrl2;
        Function0<Unit> onStart$click_debug;
        Object degradeToUrl$default;
        ClickArg arg2;
        Function0<Unit> onLost$click_debug;
        if (continuation instanceof Clicker$innerClick$1) {
            clicker$innerClick$1 = (Clicker$innerClick$1) continuation;
            if ((clicker$innerClick$1.label & Integer.MIN_VALUE) != 0) {
                clicker$innerClick$1.label -= Integer.MIN_VALUE;
                Object $result6 = clicker$innerClick$1.result;
                Object $result7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (clicker$innerClick$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result6);
                        Ref.ObjectRef current10 = new Ref.ObjectRef();
                        ClickRequest request8 = request;
                        current10.element = request8;
                        ClickContext clickContext = this.context;
                        ClickTrackResult clickTrackResult = ClickTrackResult.Click;
                        ClickRequest clickRequest = (ClickRequest) current10.element;
                        clickContext.trackClick(clickTrackResult, (clickRequest == null || (arg = clickRequest.getArg()) == null) ? null : arg.getJumpUrl());
                        clicker = this;
                        if (current10.element != null) {
                            String dlSucCallUpUrl8 = ((ClickRequest) current10.element).getArg().getDlSucCallUpUrl();
                            String str = dlSucCallUpUrl8;
                            if ((str == null || StringsKt.isBlank(str)) || !UtilsKt.isSchemeString(dlSucCallUpUrl8)) {
                                clicker2 = clicker;
                                request4 = request8;
                                current9 = current10;
                                dlSucCallUpUrl7 = dlSucCallUpUrl8;
                                callUpUrl = ((ClickRequest) current9.element).getArg().getCallUpUrl();
                                if (!(callUpUrl != null || StringsKt.isBlank(callUpUrl)) || clicker2.context.getHasShowSystemCallUpDialog()) {
                                    callUpUrl2 = ((ClickRequest) current9.element).getArg().getCallUpUrl();
                                    if (callUpUrl2 != null || StringsKt.isBlank(callUpUrl2)) {
                                        clicker2.context.getStage().info("callUpUrl为空");
                                    }
                                    if (clicker2.context.getHasShowSystemCallUpDialog()) {
                                        clicker2.context.getStage().info("已经显示过系统弹窗，不再执行callUpUrl");
                                    }
                                    onStart$click_debug = ((ClickRequest) current9.element).getOnStart$click_debug();
                                    if (onStart$click_debug != null) {
                                        onStart$click_debug.invoke();
                                    }
                                    clicker2.context.getStage().info("🔥 执行jumpUrl");
                                    ClickRequest clickRequest2 = (ClickRequest) current9.element;
                                    clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                    clicker$innerClick$1.L$1 = current9;
                                    clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl7);
                                    clicker$innerClick$1.label = 2;
                                    Clicker clicker8 = clicker2;
                                    degradeToUrl$default = degradeToUrl$default(clicker2, clickRequest2, true, false, null, clicker$innerClick$1, 12, null);
                                    if (degradeToUrl$default != $result7) {
                                        return $result7;
                                    }
                                    request3 = request4;
                                    clicker = clicker8;
                                    Object obj6 = $result7;
                                    $result2 = $result6;
                                    $result6 = degradeToUrl$default;
                                    current2 = current9;
                                    dlSucCallUpUrl2 = dlSucCallUpUrl7;
                                    obj2 = obj6;
                                    if (!((Boolean) $result6).booleanValue()) {
                                        Function0<Unit> onAnswered$click_debug2 = ((ClickRequest) current2.element).getOnAnswered$click_debug();
                                        if (onAnswered$click_debug2 != null) {
                                            onAnswered$click_debug2.invoke();
                                        }
                                        clicker.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current2.element).getArg().getJumpUrl());
                                        return Boxing.boxBoolean(true);
                                    }
                                    $result6 = $result2;
                                    $result7 = obj2;
                                    current10 = current2;
                                    request8 = request3;
                                    onLost$click_debug = ((ClickRequest) current10.element).getOnLost$click_debug();
                                    if (onLost$click_debug != null) {
                                        onLost$click_debug.invoke();
                                    }
                                    current10.element = ((ClickRequest) current10.element).getDowngrade();
                                    clicker.context.getStage().info("进入下一级降级");
                                    if (current10.element != null) {
                                        Clicker clicker9 = clicker;
                                        clicker9.context.getStage().error("点击失败");
                                        ClickContext clickContext2 = clicker9.context;
                                        ClickTrackResult clickTrackResult2 = ClickTrackResult.NoReact;
                                        ClickRequest clickRequest3 = (ClickRequest) current10.element;
                                        clickContext2.trackClick(clickTrackResult2, (clickRequest3 == null || (arg2 = clickRequest3.getArg()) == null) ? null : arg2.getJumpUrl());
                                        return Boxing.boxBoolean(false);
                                    }
                                } else {
                                    Function0<Unit> onStart$click_debug2 = ((ClickRequest) current9.element).getOnStart$click_debug();
                                    if (onStart$click_debug2 != null) {
                                        onStart$click_debug2.invoke();
                                    }
                                    if (((ClickRequest) current9.element).getArg().getEnableDoubleJump()) {
                                        clicker2.context.getStage().info("-- 双跳模式中 --");
                                        clicker2.context.setDoubleJumping(true);
                                        clicker2.context.getReportParams().put(ActionUiExtra.IS_DOUBLE_LINK_OPENED.getValue(), "1");
                                        if (KDevice.INSTANCE.getDeviceType() == DeviceType.iOS) {
                                            clicker2.context.getStage().info("🔥 callUpUrl");
                                            clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                            clicker$innerClick$1.L$1 = current9;
                                            clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl7);
                                            clicker$innerClick$1.label = 3;
                                            Object executeRequest = clicker2.executeRequest((ClickRequest) current9.element, clicker$innerClick$1);
                                            if (executeRequest == $result7) {
                                                return $result7;
                                            }
                                            clicker3 = clicker2;
                                            current3 = current9;
                                            dlSucCallUpUrl3 = dlSucCallUpUrl7;
                                            obj3 = $result7;
                                            $result3 = $result6;
                                            $result6 = executeRequest;
                                            boolean mainResult2 = ((Boolean) $result6).booleanValue();
                                            if (!clicker3.context.getHasDialogCancelJump()) {
                                                mainResult = mainResult2;
                                                minorResult = true;
                                                current4 = current3;
                                                request5 = request4;
                                                if (mainResult) {
                                                }
                                                onAnswered$click_debug = ((ClickRequest) current4.element).getOnAnswered$click_debug();
                                                if (onAnswered$click_debug != null) {
                                                }
                                                clicker3.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current4.element).getArg().getJumpUrl());
                                                return Boxing.boxBoolean(true);
                                            }
                                            clicker3.context.getStage().info("🔥 执行jumpUrl");
                                            ClickRequest clickRequest4 = (ClickRequest) current3.element;
                                            clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                            clicker$innerClick$1.L$1 = current3;
                                            clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl3);
                                            clicker$innerClick$1.Z$0 = mainResult2;
                                            clicker$innerClick$1.I$0 = 0;
                                            clicker$innerClick$1.label = 4;
                                            Clicker clicker10 = clicker3;
                                            Ref.ObjectRef current11 = current3;
                                            Object degradeToUrl$default2 = degradeToUrl$default(clicker3, clickRequest4, false, false, null, clicker$innerClick$1, 12, null);
                                            if (degradeToUrl$default2 == obj3) {
                                                return obj3;
                                            }
                                            dlSucCallUpUrl4 = dlSucCallUpUrl3;
                                            request5 = request4;
                                            clicker3 = clicker10;
                                            current4 = current11;
                                            mainResult = mainResult2;
                                            $result6 = degradeToUrl$default2;
                                            if (((Boolean) $result6).booleanValue()) {
                                                minorResult = false;
                                                if (mainResult) {
                                                }
                                                onAnswered$click_debug = ((ClickRequest) current4.element).getOnAnswered$click_debug();
                                                if (onAnswered$click_debug != null) {
                                                }
                                                clicker3.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current4.element).getArg().getJumpUrl());
                                                return Boxing.boxBoolean(true);
                                            }
                                            mainResult2 = mainResult;
                                            dlSucCallUpUrl3 = dlSucCallUpUrl4;
                                            current3 = current4;
                                            request4 = request5;
                                            mainResult = mainResult2;
                                            minorResult = true;
                                            current4 = current3;
                                            request5 = request4;
                                            if (!mainResult || minorResult) {
                                                onAnswered$click_debug = ((ClickRequest) current4.element).getOnAnswered$click_debug();
                                                if (onAnswered$click_debug != null) {
                                                    onAnswered$click_debug.invoke();
                                                }
                                                clicker3.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current4.element).getArg().getJumpUrl());
                                                return Boxing.boxBoolean(true);
                                            }
                                            $result6 = $result3;
                                            $result7 = obj3;
                                            current10 = current4;
                                            request8 = request5;
                                            clicker = clicker3;
                                            onLost$click_debug = ((ClickRequest) current10.element).getOnLost$click_debug();
                                            if (onLost$click_debug != null) {
                                            }
                                            current10.element = ((ClickRequest) current10.element).getDowngrade();
                                            clicker.context.getStage().info("进入下一级降级");
                                            if (current10.element != null) {
                                            }
                                        } else {
                                            clicker2.context.getStage().info("🔥 执行callUpUrl");
                                            clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                            clicker$innerClick$1.L$1 = current9;
                                            clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl7);
                                            clicker$innerClick$1.label = 5;
                                            Object executeRequest2 = clicker2.executeRequest((ClickRequest) current9.element, clicker$innerClick$1);
                                            if (executeRequest2 == $result7) {
                                                return $result7;
                                            }
                                            clicker4 = clicker2;
                                            current5 = current9;
                                            dlSucCallUpUrl5 = dlSucCallUpUrl7;
                                            obj4 = $result7;
                                            $result4 = $result6;
                                            $result6 = executeRequest2;
                                            if (!((Boolean) $result6).booleanValue()) {
                                                Function0<Unit> onAnswered$click_debug3 = ((ClickRequest) current5.element).getOnAnswered$click_debug();
                                                if (onAnswered$click_debug3 != null) {
                                                    onAnswered$click_debug3.invoke();
                                                }
                                                clicker4.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current5.element).getArg().getCallUpUrl());
                                                return Boxing.boxBoolean(true);
                                            }
                                            clicker4.context.getStage().info("🔥 执行jumpUrl");
                                            ClickRequest clickRequest5 = (ClickRequest) current5.element;
                                            clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                            clicker$innerClick$1.L$1 = current5;
                                            clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl5);
                                            clicker$innerClick$1.label = 6;
                                            Clicker clicker11 = clicker4;
                                            Ref.ObjectRef current12 = current5;
                                            Object degradeToUrl$default3 = degradeToUrl$default(clicker4, clickRequest5, false, false, null, clicker$innerClick$1, 12, null);
                                            if (degradeToUrl$default3 == obj4) {
                                                return obj4;
                                            }
                                            request6 = request4;
                                            clicker5 = clicker11;
                                            current6 = current12;
                                            $result6 = degradeToUrl$default3;
                                            if (!((Boolean) $result6).booleanValue()) {
                                                Function0<Unit> onAnswered$click_debug4 = ((ClickRequest) current6.element).getOnAnswered$click_debug();
                                                if (onAnswered$click_debug4 != null) {
                                                    onAnswered$click_debug4.invoke();
                                                }
                                                clicker5.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current6.element).getArg().getJumpUrl());
                                                return Boxing.boxBoolean(true);
                                            }
                                            $result6 = $result4;
                                            $result7 = obj4;
                                            current10 = current6;
                                            request8 = request6;
                                            clicker = clicker5;
                                            onLost$click_debug = ((ClickRequest) current10.element).getOnLost$click_debug();
                                            if (onLost$click_debug != null) {
                                            }
                                            current10.element = ((ClickRequest) current10.element).getDowngrade();
                                            clicker.context.getStage().info("进入下一级降级");
                                            if (current10.element != null) {
                                            }
                                        }
                                    } else {
                                        clicker2.context.setDoubleJumping(false);
                                        clicker2.context.getReportParams().put(ActionUiExtra.IS_DOUBLE_LINK_OPENED.getValue(), AdSearchSubCardType.CARD_TYPE_NONE);
                                        clicker2.context.getStage().info("🔥 执行callUpUrl");
                                        clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                        clicker$innerClick$1.L$1 = current9;
                                        clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl7);
                                        clicker$innerClick$1.label = 7;
                                        Object executeRequest3 = clicker2.executeRequest((ClickRequest) current9.element, clicker$innerClick$1);
                                        if (executeRequest3 == $result7) {
                                            return $result7;
                                        }
                                        clicker6 = clicker2;
                                        current7 = current9;
                                        dlSucCallUpUrl6 = dlSucCallUpUrl7;
                                        obj5 = $result7;
                                        $result5 = $result6;
                                        $result6 = executeRequest3;
                                        if (!((Boolean) $result6).booleanValue()) {
                                            Function0<Unit> onAnswered$click_debug5 = ((ClickRequest) current7.element).getOnAnswered$click_debug();
                                            if (onAnswered$click_debug5 != null) {
                                                onAnswered$click_debug5.invoke();
                                            }
                                            clicker6.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current7.element).getArg().getCallUpUrl());
                                            return Boxing.boxBoolean(true);
                                        }
                                        clicker6.context.getStage().info("🔥 执行jumpUrl");
                                        ClickRequest clickRequest6 = (ClickRequest) current7.element;
                                        clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                        clicker$innerClick$1.L$1 = current7;
                                        clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl6);
                                        clicker$innerClick$1.label = 8;
                                        Clicker clicker12 = clicker6;
                                        Ref.ObjectRef current13 = current7;
                                        Object degradeToUrl$default4 = degradeToUrl$default(clicker6, clickRequest6, false, false, null, clicker$innerClick$1, 12, null);
                                        if (degradeToUrl$default4 == obj5) {
                                            return obj5;
                                        }
                                        request7 = request4;
                                        clicker7 = clicker12;
                                        current8 = current13;
                                        $result6 = degradeToUrl$default4;
                                        if (!((Boolean) $result6).booleanValue()) {
                                            Function0<Unit> onAnswered$click_debug6 = ((ClickRequest) current8.element).getOnAnswered$click_debug();
                                            if (onAnswered$click_debug6 != null) {
                                                onAnswered$click_debug6.invoke();
                                            }
                                            clicker7.context.trackClick(ClickTrackResult.Success, ((ClickRequest) current8.element).getArg().getJumpUrl());
                                            return Boxing.boxBoolean(true);
                                        }
                                        $result6 = $result5;
                                        $result7 = obj5;
                                        current10 = current8;
                                        request8 = request7;
                                        clicker = clicker7;
                                        onLost$click_debug = ((ClickRequest) current10.element).getOnLost$click_debug();
                                        if (onLost$click_debug != null) {
                                        }
                                        current10.element = ((ClickRequest) current10.element).getDowngrade();
                                        clicker.context.getStage().info("进入下一级降级");
                                        if (current10.element != null) {
                                        }
                                    }
                                }
                            } else {
                                clicker.context.getStage().info("🔥 执行dlSucCallUpUrl");
                                Function0<Unit> onStart$click_debug3 = ((ClickRequest) current10.element).getOnStart$click_debug();
                                if (onStart$click_debug3 != null) {
                                    onStart$click_debug3.invoke();
                                }
                                clicker.context.setDlSucCallUping(true);
                                ClickRequest clickRequest7 = (ClickRequest) current10.element;
                                clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request8);
                                clicker$innerClick$1.L$1 = current10;
                                clicker$innerClick$1.L$2 = dlSucCallUpUrl8;
                                clicker$innerClick$1.label = 1;
                                Clicker clicker13 = clicker;
                                Object degradeToUrl = clicker.degradeToUrl(clickRequest7, false, true, dlSucCallUpUrl8, clicker$innerClick$1);
                                if (degradeToUrl == $result7) {
                                    return $result7;
                                }
                                clicker2 = clicker13;
                                dlSucCallUpUrl = dlSucCallUpUrl8;
                                Object obj7 = $result7;
                                $result = $result6;
                                $result6 = degradeToUrl;
                                request2 = request8;
                                current = current10;
                                obj = obj7;
                                if (!((Boolean) $result6).booleanValue()) {
                                    Function0<Unit> onAnswered$click_debug7 = ((ClickRequest) current.element).getOnAnswered$click_debug();
                                    if (onAnswered$click_debug7 != null) {
                                        onAnswered$click_debug7.invoke();
                                    }
                                    clicker2.context.trackClick(ClickTrackResult.Success, dlSucCallUpUrl);
                                    return Boxing.boxBoolean(true);
                                }
                                clicker2.context.setDlSucCallUping(false);
                                $result6 = $result;
                                $result7 = obj;
                                dlSucCallUpUrl7 = dlSucCallUpUrl;
                                current9 = current;
                                request4 = request2;
                                callUpUrl = ((ClickRequest) current9.element).getArg().getCallUpUrl();
                                if (callUpUrl != null || StringsKt.isBlank(callUpUrl)) {
                                }
                                callUpUrl2 = ((ClickRequest) current9.element).getArg().getCallUpUrl();
                                if (callUpUrl2 != null || StringsKt.isBlank(callUpUrl2)) {
                                }
                                if (clicker2.context.getHasShowSystemCallUpDialog()) {
                                }
                                onStart$click_debug = ((ClickRequest) current9.element).getOnStart$click_debug();
                                if (onStart$click_debug != null) {
                                }
                                clicker2.context.getStage().info("🔥 执行jumpUrl");
                                ClickRequest clickRequest22 = (ClickRequest) current9.element;
                                clicker$innerClick$1.L$0 = SpillingKt.nullOutSpilledVariable(request4);
                                clicker$innerClick$1.L$1 = current9;
                                clicker$innerClick$1.L$2 = SpillingKt.nullOutSpilledVariable(dlSucCallUpUrl7);
                                clicker$innerClick$1.label = 2;
                                Clicker clicker82 = clicker2;
                                degradeToUrl$default = degradeToUrl$default(clicker2, clickRequest22, true, false, null, clicker$innerClick$1, 12, null);
                                if (degradeToUrl$default != $result7) {
                                }
                            }
                        }
                        break;
                    case 1:
                        String dlSucCallUpUrl9 = (String) clicker$innerClick$1.L$2;
                        current = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request2 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker2 = this;
                        dlSucCallUpUrl = dlSucCallUpUrl9;
                        obj = $result7;
                        $result = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 2:
                        String dlSucCallUpUrl10 = (String) clicker$innerClick$1.L$2;
                        current2 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request3 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker = this;
                        dlSucCallUpUrl2 = dlSucCallUpUrl10;
                        obj2 = $result7;
                        $result2 = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 3:
                        String dlSucCallUpUrl11 = (String) clicker$innerClick$1.L$2;
                        ClickRequest request9 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker3 = this;
                        dlSucCallUpUrl3 = dlSucCallUpUrl11;
                        current3 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request4 = request9;
                        obj3 = $result7;
                        $result3 = $result6;
                        boolean mainResult22 = ((Boolean) $result6).booleanValue();
                        if (!clicker3.context.getHasDialogCancelJump()) {
                        }
                        break;
                    case 4:
                        int i = clicker$innerClick$1.I$0;
                        mainResult = clicker$innerClick$1.Z$0;
                        dlSucCallUpUrl4 = (String) clicker$innerClick$1.L$2;
                        current4 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request5 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker3 = this;
                        obj3 = $result7;
                        $result3 = $result6;
                        if (((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 5:
                        String dlSucCallUpUrl12 = (String) clicker$innerClick$1.L$2;
                        ClickRequest request10 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker4 = this;
                        dlSucCallUpUrl5 = dlSucCallUpUrl12;
                        current5 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request4 = request10;
                        obj4 = $result7;
                        $result4 = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 6:
                        String dlSucCallUpUrl13 = (String) clicker$innerClick$1.L$2;
                        current6 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request6 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker5 = this;
                        dlSucCallUpUrl5 = dlSucCallUpUrl13;
                        obj4 = $result7;
                        $result4 = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 7:
                        String dlSucCallUpUrl14 = (String) clicker$innerClick$1.L$2;
                        ClickRequest request11 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker6 = this;
                        dlSucCallUpUrl6 = dlSucCallUpUrl14;
                        current7 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request4 = request11;
                        obj5 = $result7;
                        $result5 = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    case 8:
                        String dlSucCallUpUrl15 = (String) clicker$innerClick$1.L$2;
                        current8 = (Ref.ObjectRef) clicker$innerClick$1.L$1;
                        request7 = (ClickRequest) clicker$innerClick$1.L$0;
                        ResultKt.throwOnFailure($result6);
                        clicker7 = this;
                        dlSucCallUpUrl6 = dlSucCallUpUrl15;
                        obj5 = $result7;
                        $result5 = $result6;
                        if (!((Boolean) $result6).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        clicker$innerClick$1 = new Clicker$innerClick$1(this, continuation);
        Object $result62 = clicker$innerClick$1.result;
        Object $result72 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (clicker$innerClick$1.label) {
        }
    }

    static /* synthetic */ Object degradeToUrl$default(Clicker clicker, ClickRequest clickRequest, boolean z, boolean z2, String str, Continuation continuation, int i, Object obj) {
        boolean z3;
        String str2;
        if ((i & 4) == 0) {
            z3 = z2;
        } else {
            z3 = false;
        }
        if ((i & 8) == 0) {
            str2 = str;
        } else {
            str2 = clickRequest.getArg().getJumpUrl();
        }
        return clicker.degradeToUrl(clickRequest, z, z3, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object degradeToUrl(ClickRequest request, boolean canOpenWx, boolean canOpenULink, String url, Continuation<? super Boolean> continuation) {
        ClickArg copy;
        copy = r0.copy((r36 & 1) != 0 ? r0.wxInfo : canOpenWx ? request.getArg().getWxInfo() : null, (r36 & 2) != 0 ? r0.callUpUrl : url, (r36 & 4) != 0 ? r0.jumpUrl : null, (r36 & 8) != 0 ? r0.cancelUrl : null, (r36 & 16) != 0 ? r0.enableCallUpCancelToJumpUrl : false, (r36 & 32) != 0 ? r0.enableDoubleJump : false, (r36 & 64) != 0 ? r0.useAdWeb : false, (r36 & 128) != 0 ? r0.openWhiteList : null, (r36 & 256) != 0 ? r0.downloadWhiteList : null, (r36 & 512) != 0 ? r0.dlSucCallUpUrl : null, (r36 & 1024) != 0 ? r0.enableAppStore : false, (r36 & 2048) != 0 ? r0.enableAppDownload : false, (r36 & 4096) != 0 ? r0.clickUrls : null, (r36 & 8192) != 0 ? r0.universalApp : canOpenULink ? request.getArg().getUniversalApp() : null, (r36 & 16384) != 0 ? r0.appStorePriority : 0, (r36 & 32768) != 0 ? r0.storeLink : null, (r36 & 65536) != 0 ? r0.downloadUrlType : 0, (r36 & 131072) != 0 ? request.getArg().isFirstJump : false);
        ClickRequest degradeRequest = request.copy(copy);
        return executeRequest(degradeRequest, continuation);
    }

    private static final ClickArg executeRequest$processUrls(ClickArg $this$executeRequest_u24processUrls, Clicker this$0) {
        ClickArg copy;
        String it = this$0.context.macroSubst($this$executeRequest_u24processUrls.getCallUpUrl());
        String processUrl = it != null ? this$0.context.getService().processUrl(it) : null;
        String it2 = this$0.context.macroSubst($this$executeRequest_u24processUrls.getJumpUrl());
        String processUrl2 = it2 != null ? this$0.context.getService().processUrl(it2) : null;
        String it3 = this$0.context.macroSubst($this$executeRequest_u24processUrls.getCancelUrl());
        String processUrl3 = it3 != null ? this$0.context.getService().processUrl(it3) : null;
        AdWxProgramInfo it4 = $this$executeRequest_u24processUrls.getWxInfo();
        copy = $this$executeRequest_u24processUrls.copy((r36 & 1) != 0 ? $this$executeRequest_u24processUrls.wxInfo : it4 != null ? AdWxProgramInfo.copy$default(it4, null, null, this$0.context.macroSubst(it4.getPath()), 3, null) : null, (r36 & 2) != 0 ? $this$executeRequest_u24processUrls.callUpUrl : processUrl, (r36 & 4) != 0 ? $this$executeRequest_u24processUrls.jumpUrl : processUrl2, (r36 & 8) != 0 ? $this$executeRequest_u24processUrls.cancelUrl : processUrl3, (r36 & 16) != 0 ? $this$executeRequest_u24processUrls.enableCallUpCancelToJumpUrl : false, (r36 & 32) != 0 ? $this$executeRequest_u24processUrls.enableDoubleJump : false, (r36 & 64) != 0 ? $this$executeRequest_u24processUrls.useAdWeb : false, (r36 & 128) != 0 ? $this$executeRequest_u24processUrls.openWhiteList : null, (r36 & 256) != 0 ? $this$executeRequest_u24processUrls.downloadWhiteList : null, (r36 & 512) != 0 ? $this$executeRequest_u24processUrls.dlSucCallUpUrl : null, (r36 & 1024) != 0 ? $this$executeRequest_u24processUrls.enableAppStore : false, (r36 & 2048) != 0 ? $this$executeRequest_u24processUrls.enableAppDownload : false, (r36 & 4096) != 0 ? $this$executeRequest_u24processUrls.clickUrls : null, (r36 & 8192) != 0 ? $this$executeRequest_u24processUrls.universalApp : null, (r36 & 16384) != 0 ? $this$executeRequest_u24processUrls.appStorePriority : 0, (r36 & 32768) != 0 ? $this$executeRequest_u24processUrls.storeLink : null, (r36 & 65536) != 0 ? $this$executeRequest_u24processUrls.downloadUrlType : 0, (r36 & 131072) != 0 ? $this$executeRequest_u24processUrls.isFirstJump : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeRequest(ClickRequest request, Continuation<? super Boolean> continuation) {
        return this.chain.proceed(executeRequest$processUrls(request.getArg(), this), continuation);
    }
}