package kntr.app.upper.entrance.bubble2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble.UperCenterPlusBubbleInfo;
import kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy;
import kntr.app.upper.entrance.bubble2.bean.BubbleBean;
import kntr.app.upper.entrance.bubble2.service.BubbleBlacklistService;
import kntr.app.upper.entrance.bubble2.service.BubbleCouponService;
import kntr.app.upper.entrance.bubble2.service.BubbleTiredService;
import kntr.app.upper.entrance.bubble2.service.TiredResult;
import kntr.app.upper.entrance.bubble2.service.TiredType2;
import kntr.app.upper.entrance.bubble2.service.UperCenterPlusBubbleService;
import kntr.app.upper.entrance.utils.FeatureConfig;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.app.upper.entrance.utils.TrackUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: UperCenterPlusBubbleConcreteB.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0096@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J-\u0010\u001e\u001a\u00020\u00162#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0002J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002JX\u0010 \u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J.\u0010*\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010+\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u001a\u0010,\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110.\u0018\u00010-H\u0016J6\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u001dH\u0016J0\u00101\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b022\u0006\u0010\u0010\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u00105J6\u00106\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u000208072\u0006\u0010\u0010\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u00105R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lkntr/app/upper/entrance/bubble2/UperCenterPlusBubbleConcreteB;", "Lkntr/app/upper/entrance/bubble/UpperCenterPlusBubbleStrategy;", "<init>", "()V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "callbackList", "", "Lkotlin/Function1;", "Lkntr/app/upper/entrance/bubble/UperCenterPlusBubbleInfo;", "Lkotlin/ParameterName;", "name", "info", "", "bubbleInfo", "mid", "", "abExtra", "callBack", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldFetchBubbleInfo", "", "convertToBubbleInfo", "resource", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "text", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Text;", "fans", "", "checkRunning", "callbackResult", "exposure", "bubbleID", "strategyID", "resourceID", "textID", "interestScore", "", "hotScore", "isForce", "", "exposureRecom", "exposureRecomList", "textIDs", "", "", "checkRecomText", "availableTime", "selectBubbleByTired", "Lkotlin/Pair;", "bubbleBean", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "(Ljava/lang/String;Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectBubbleByTired2", "Lkotlin/Triple;", "Lkntr/app/upper/entrance/bubble2/service/TiredResult;", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UperCenterPlusBubbleConcreteB implements UpperCenterPlusBubbleStrategy {
    public static final Companion Companion = new Companion(null);
    private static final String RESOURCE_TYPE_FORCE = "强插供给";
    private static final String RESOURCE_TYPE_HOT = "热门兜底";
    private static final String RESOURCE_TYPE_INTEREST = "兴趣偏向";
    private final ReentrantLock lock = new ReentrantLock();
    private final List<Function1<UperCenterPlusBubbleInfo, Unit>> callbackList = new ArrayList();

    /* compiled from: UperCenterPlusBubbleConcreteB.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/upper/entrance/bubble2/UperCenterPlusBubbleConcreteB$Companion;", "", "<init>", "()V", "RESOURCE_TYPE_INTEREST", "", "RESOURCE_TYPE_HOT", "RESOURCE_TYPE_FORCE", "getResourceType", "resource", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "newInstance", "Lkntr/app/upper/entrance/bubble/UpperCenterPlusBubbleStrategy;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getResourceType(BubbleBean.Resource resource) {
            if (resource == null) {
                return "";
            }
            if (resource.forceValue()) {
                return UperCenterPlusBubbleConcreteB.RESOURCE_TYPE_FORCE;
            }
            if (resource.getInterestScore() > 0.0f) {
                return UperCenterPlusBubbleConcreteB.RESOURCE_TYPE_INTEREST;
            }
            return UperCenterPlusBubbleConcreteB.RESOURCE_TYPE_HOT;
        }

        public final UpperCenterPlusBubbleStrategy newInstance() {
            return new UperCenterPlusBubbleConcreteB();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0330  */
    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object bubbleInfo(String mid, String abExtra, Function1<? super UperCenterPlusBubbleInfo, Unit> function1, Continuation<? super Unit> continuation) {
        UperCenterPlusBubbleConcreteB$bubbleInfo$1 uperCenterPlusBubbleConcreteB$bubbleInfo$1;
        UperCenterPlusBubbleConcreteB$bubbleInfo$1 uperCenterPlusBubbleConcreteB$bubbleInfo$12;
        String str;
        Object obj;
        UperCenterPlusBubbleConcreteB$bubbleInfo$1 uperCenterPlusBubbleConcreteB$bubbleInfo$13;
        Object obj2;
        String abExtra2;
        Function1 callBack;
        String mid2;
        String code;
        String str2;
        UperCenterPlusBubbleInfo uperCenterPlusBubbleInfo;
        String code2;
        String abExtra3;
        String mid3;
        Function1 callBack2;
        String abExtra4;
        Object obj3;
        Throwable it;
        BubbleBean it2;
        TiredType2 tiredType;
        String mid4;
        int i;
        String code3;
        String code4;
        String mid5;
        int i2;
        BubbleBean.Resource resource;
        BubbleBean.Text text;
        String mid6;
        boolean isNullOrEmpty;
        String resourceId;
        String valueOf;
        String textId;
        BubbleBean.Bubble bubble;
        String bubbleId;
        String strategyId;
        List<BubbleBean.Resource> resourceList;
        String joinToString$default;
        BubbleBean.Bubble bubble2;
        if (continuation instanceof UperCenterPlusBubbleConcreteB$bubbleInfo$1) {
            uperCenterPlusBubbleConcreteB$bubbleInfo$1 = (UperCenterPlusBubbleConcreteB$bubbleInfo$1) continuation;
            if ((uperCenterPlusBubbleConcreteB$bubbleInfo$1.label & Integer.MIN_VALUE) != 0) {
                uperCenterPlusBubbleConcreteB$bubbleInfo$1.label -= Integer.MIN_VALUE;
                uperCenterPlusBubbleConcreteB$bubbleInfo$12 = uperCenterPlusBubbleConcreteB$bubbleInfo$1;
                Object $result = uperCenterPlusBubbleConcreteB$bubbleInfo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uperCenterPlusBubbleConcreteB$bubbleInfo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (FeatureConfig.INSTANCE.getTransferFlag()) {
                            str = "UperCenterPlusBubbleB";
                            obj = coroutine_suspended;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13 = uperCenterPlusBubbleConcreteB$bubbleInfo$12;
                            TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType2.START.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : mid, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
                        } else {
                            str = "UperCenterPlusBubbleB";
                            obj = coroutine_suspended;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13 = uperCenterPlusBubbleConcreteB$bubbleInfo$12;
                        }
                        if (!checkRunning(function1)) {
                            UperCenterPlusBubbleService uperCenterPlusBubbleService = UperCenterPlusBubbleService.INSTANCE;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$0 = mid;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$1 = SpillingKt.nullOutSpilledVariable(abExtra);
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13.label = 1;
                            obj2 = obj;
                            if (uperCenterPlusBubbleService.requestBubble$entrance_debug(mid, uperCenterPlusBubbleConcreteB$bubbleInfo$13) != obj2) {
                                abExtra2 = abExtra;
                                callBack = function1;
                                mid2 = mid;
                                break;
                            } else {
                                return obj2;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        Function1 callBack3 = (Function1) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$2;
                        abExtra2 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$1;
                        ResultKt.throwOnFailure($result);
                        callBack = callBack3;
                        str = "UperCenterPlusBubbleB";
                        obj2 = coroutine_suspended;
                        uperCenterPlusBubbleConcreteB$bubbleInfo$13 = uperCenterPlusBubbleConcreteB$bubbleInfo$12;
                        mid2 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$0;
                        break;
                    case 2:
                        int i3 = uperCenterPlusBubbleConcreteB$bubbleInfo$12.I$0;
                        abExtra3 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$3;
                        Function1 callBack4 = (Function1) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$2;
                        String abExtra5 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$1;
                        String mid7 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            code2 = abExtra5;
                            str2 = "UperCenterPlusBubbleB";
                            obj2 = coroutine_suspended;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13 = uperCenterPlusBubbleConcreteB$bubbleInfo$12;
                            uperCenterPlusBubbleInfo = null;
                            mid3 = mid7;
                            callBack = callBack4;
                        } catch (Throwable th) {
                            th = th;
                            code2 = abExtra5;
                            mid2 = mid7;
                            str2 = "UperCenterPlusBubbleB";
                            obj2 = coroutine_suspended;
                            uperCenterPlusBubbleConcreteB$bubbleInfo$13 = uperCenterPlusBubbleConcreteB$bubbleInfo$12;
                            uperCenterPlusBubbleInfo = null;
                            callBack = callBack4;
                            Result.Companion companion = Result.Companion;
                            callBack2 = callBack;
                            abExtra4 = code2;
                            obj3 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            it = Result.m2639exceptionOrNullimpl(obj3);
                            if (it != null) {
                            }
                            if (Result.m2643isSuccessimpl(obj3)) {
                            }
                            return Unit.INSTANCE;
                        }
                        try {
                            abExtra4 = code2;
                            mid2 = mid3;
                            callBack2 = callBack;
                            obj3 = Result.m2636constructorimpl((BubbleBean) $result);
                        } catch (Throwable th2) {
                            th = th2;
                            mid2 = mid3;
                            Result.Companion companion2 = Result.Companion;
                            callBack2 = callBack;
                            abExtra4 = code2;
                            obj3 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            it = Result.m2639exceptionOrNullimpl(obj3);
                            if (it != null) {
                            }
                            if (Result.m2643isSuccessimpl(obj3)) {
                            }
                            return Unit.INSTANCE;
                        }
                        it = Result.m2639exceptionOrNullimpl(obj3);
                        if (it != null) {
                            BubbleTiredService.INSTANCE.recordBubbleRequestEmpty(mid2);
                            callbackResult(uperCenterPlusBubbleInfo);
                            LogUtils.INSTANCE.e(str2, "requestBubble error", it);
                            TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType2.ERR.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : it.getMessage(), (r21 & 128) != 0 ? "" : mid2, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
                        }
                        if (Result.m2643isSuccessimpl(obj3)) {
                            it2 = (BubbleBean) obj3;
                            LogUtils.INSTANCE.i(str2, "requestBubble success, " + it2);
                            TiredType2 tiredType2 = TiredType2.SUCCESS;
                            if (FeatureConfig.INSTANCE.getTransferFlag()) {
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$0 = mid2;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$1 = SpillingKt.nullOutSpilledVariable(abExtra4);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$2 = SpillingKt.nullOutSpilledVariable(callBack2);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$3 = SpillingKt.nullOutSpilledVariable(abExtra3);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$4 = obj3;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$5 = it2;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$6 = SpillingKt.nullOutSpilledVariable(tiredType2);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$7 = SpillingKt.nullOutSpilledVariable("");
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.I$0 = 0;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.label = 3;
                                Object selectBubbleByTired2 = selectBubbleByTired2(mid2, it2, uperCenterPlusBubbleConcreteB$bubbleInfo$13);
                                if (selectBubbleByTired2 == obj2) {
                                    return obj2;
                                }
                                $result = selectBubbleByTired2;
                                mid5 = mid2;
                                i2 = 0;
                                code3 = abExtra3;
                                Triple tiredResult = (Triple) $result;
                                resource = (BubbleBean.Resource) tiredResult.getFirst();
                                text = (BubbleBean.Text) tiredResult.getSecond();
                                TiredResult tiredValue = (TiredResult) tiredResult.getThird();
                                tiredType = tiredValue.getType();
                                code4 = tiredValue.getMsg();
                                mid6 = mid5;
                                if (resource != null && (bubble2 = resource.getBubble()) != null) {
                                    UperCenterPlusBubbleService uperCenterPlusBubbleService2 = UperCenterPlusBubbleService.INSTANCE;
                                    BubbleBean.Bubble bubble3 = resource.getBubble();
                                    bubble2.setJumpUrl(uperCenterPlusBubbleService2.removeQueryParameter(bubble3 == null ? bubble3.getJumpUrl() : uperCenterPlusBubbleInfo, "resource_id"));
                                }
                                callbackResult(convertToBubbleInfo(resource, text, it2 == null ? it2.getFans() : 0L));
                                List<BubbleBean.Resource> resourceList2 = it2 == null ? it2.getResourceList() : null;
                                isNullOrEmpty = resourceList2 != null || resourceList2.isEmpty();
                                if (!isNullOrEmpty) {
                                    String strategyIdStr = (it2 == null || (resourceList = it2.getResourceList()) == null || (joinToString$default = CollectionsKt.joinToString$default(resourceList, "-", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.upper.entrance.bubble2.UperCenterPlusBubbleConcreteB$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj4) {
                                            CharSequence bubbleInfo$lambda$2$0;
                                            bubbleInfo$lambda$2$0 = UperCenterPlusBubbleConcreteB.bubbleInfo$lambda$2$0((BubbleBean.Resource) obj4);
                                            return bubbleInfo$lambda$2$0;
                                        }
                                    }, 30, (Object) null)) == null) ? "" : joinToString$default;
                                    BubbleBean.Bubble bubble4 = resource != null ? resource.getBubble() : null;
                                    String resourceType = bubble4 != null ? Companion.getResourceType(resource) : "";
                                    TrackUtils.INSTANCE.trackBubbleRequestInfo(tiredType.getValue(), strategyIdStr, (resource == null || (strategyId = resource.getStrategyId()) == null) ? "" : strategyId, (resource == null || (bubble = resource.getBubble()) == null || (bubbleId = bubble.getBubbleId()) == null) ? "" : bubbleId, (text == null || (textId = text.getTextId()) == null) ? "" : textId, (it2 == null || (valueOf = String.valueOf(it2.getRecommend())) == null) ? "" : valueOf, code4, mid6, (resource == null || (resourceId = resource.getResourceId()) == null) ? "" : resourceId, resourceType);
                                }
                            } else {
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$0 = mid2;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$1 = SpillingKt.nullOutSpilledVariable(abExtra4);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$2 = SpillingKt.nullOutSpilledVariable(callBack2);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$3 = SpillingKt.nullOutSpilledVariable(abExtra3);
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$4 = obj3;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$5 = it2;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$6 = tiredType2;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$7 = "";
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.I$0 = 0;
                                uperCenterPlusBubbleConcreteB$bubbleInfo$13.label = 4;
                                Object selectBubbleByTired = selectBubbleByTired(mid2, it2, uperCenterPlusBubbleConcreteB$bubbleInfo$13);
                                if (selectBubbleByTired == obj2) {
                                    return obj2;
                                }
                                tiredType = tiredType2;
                                $result = selectBubbleByTired;
                                mid4 = mid2;
                                i = 0;
                                code3 = abExtra3;
                                code4 = "";
                                Pair tiredResult2 = (Pair) $result;
                                resource = (BubbleBean.Resource) tiredResult2.getFirst();
                                text = (BubbleBean.Text) tiredResult2.getSecond();
                                mid6 = mid4;
                                if (resource != null) {
                                    UperCenterPlusBubbleService uperCenterPlusBubbleService22 = UperCenterPlusBubbleService.INSTANCE;
                                    BubbleBean.Bubble bubble32 = resource.getBubble();
                                    bubble2.setJumpUrl(uperCenterPlusBubbleService22.removeQueryParameter(bubble32 == null ? bubble32.getJumpUrl() : uperCenterPlusBubbleInfo, "resource_id"));
                                }
                                callbackResult(convertToBubbleInfo(resource, text, it2 == null ? it2.getFans() : 0L));
                                List<BubbleBean.Resource> resourceList22 = it2 == null ? it2.getResourceList() : null;
                                isNullOrEmpty = resourceList22 != null || resourceList22.isEmpty();
                                if (!isNullOrEmpty) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        i2 = uperCenterPlusBubbleConcreteB$bubbleInfo$12.I$0;
                        String str3 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$7;
                        TiredType2 tiredType22 = (TiredType2) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$6;
                        it2 = (BubbleBean) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$5;
                        Object obj4 = uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$4;
                        code3 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$3;
                        Function1 function12 = (Function1) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$2;
                        String str4 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$1;
                        mid5 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        uperCenterPlusBubbleInfo = null;
                        Triple tiredResult3 = (Triple) $result;
                        resource = (BubbleBean.Resource) tiredResult3.getFirst();
                        text = (BubbleBean.Text) tiredResult3.getSecond();
                        TiredResult tiredValue2 = (TiredResult) tiredResult3.getThird();
                        tiredType = tiredValue2.getType();
                        code4 = tiredValue2.getMsg();
                        mid6 = mid5;
                        if (resource != null) {
                        }
                        callbackResult(convertToBubbleInfo(resource, text, it2 == null ? it2.getFans() : 0L));
                        List<BubbleBean.Resource> resourceList222 = it2 == null ? it2.getResourceList() : null;
                        isNullOrEmpty = resourceList222 != null || resourceList222.isEmpty();
                        if (!isNullOrEmpty) {
                        }
                        return Unit.INSTANCE;
                    case 4:
                        i = uperCenterPlusBubbleConcreteB$bubbleInfo$12.I$0;
                        code4 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$7;
                        tiredType = (TiredType2) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$6;
                        it2 = (BubbleBean) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$5;
                        Object obj5 = uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$4;
                        code3 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$3;
                        Function1 function13 = (Function1) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$2;
                        String str5 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$1;
                        mid4 = (String) uperCenterPlusBubbleConcreteB$bubbleInfo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        uperCenterPlusBubbleInfo = null;
                        Pair tiredResult22 = (Pair) $result;
                        resource = (BubbleBean.Resource) tiredResult22.getFirst();
                        text = (BubbleBean.Text) tiredResult22.getSecond();
                        mid6 = mid4;
                        if (resource != null) {
                        }
                        callbackResult(convertToBubbleInfo(resource, text, it2 == null ? it2.getFans() : 0L));
                        List<BubbleBean.Resource> resourceList2222 = it2 == null ? it2.getResourceList() : null;
                        isNullOrEmpty = resourceList2222 != null || resourceList2222.isEmpty();
                        if (!isNullOrEmpty) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                code = BubbleTiredService.INSTANCE.checkBubbleRequest(mid2);
                if (Intrinsics.areEqual(code, TiredType2.SUCCESS.getValue())) {
                    LogUtils.INSTANCE.i(str, "no requestBubble");
                    callbackResult(null);
                    TrackUtils.INSTANCE.trackBubbleRequestInfo(code, (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : mid2, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
                    return Unit.INSTANCE;
                }
                str2 = str;
                uperCenterPlusBubbleInfo = null;
                try {
                    Result.Companion companion3 = Result.Companion;
                    BubbleTiredService.INSTANCE.clearExpireData(mid2);
                    UperCenterPlusBubbleService uperCenterPlusBubbleService3 = UperCenterPlusBubbleService.INSTANCE;
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$0 = mid2;
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$1 = SpillingKt.nullOutSpilledVariable(abExtra2);
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$2 = SpillingKt.nullOutSpilledVariable(callBack);
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.L$3 = SpillingKt.nullOutSpilledVariable(code);
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.I$0 = 0;
                    uperCenterPlusBubbleConcreteB$bubbleInfo$13.label = 2;
                    $result = uperCenterPlusBubbleService3.requestBubble$entrance_debug(mid2, uperCenterPlusBubbleConcreteB$bubbleInfo$13);
                } catch (Throwable th3) {
                    th = th3;
                    code2 = abExtra2;
                    abExtra3 = code;
                    Result.Companion companion22 = Result.Companion;
                    callBack2 = callBack;
                    abExtra4 = code2;
                    obj3 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                    it = Result.m2639exceptionOrNullimpl(obj3);
                    if (it != null) {
                    }
                    if (Result.m2643isSuccessimpl(obj3)) {
                    }
                    return Unit.INSTANCE;
                }
                if ($result == obj2) {
                    return obj2;
                }
                mid3 = mid2;
                code2 = abExtra2;
                abExtra3 = code;
                abExtra4 = code2;
                mid2 = mid3;
                callBack2 = callBack;
                obj3 = Result.m2636constructorimpl((BubbleBean) $result);
                it = Result.m2639exceptionOrNullimpl(obj3);
                if (it != null) {
                }
                if (Result.m2643isSuccessimpl(obj3)) {
                }
                return Unit.INSTANCE;
            }
        }
        uperCenterPlusBubbleConcreteB$bubbleInfo$1 = new UperCenterPlusBubbleConcreteB$bubbleInfo$1(this, continuation);
        uperCenterPlusBubbleConcreteB$bubbleInfo$12 = uperCenterPlusBubbleConcreteB$bubbleInfo$1;
        Object $result2 = uperCenterPlusBubbleConcreteB$bubbleInfo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uperCenterPlusBubbleConcreteB$bubbleInfo$12.label) {
        }
        code = BubbleTiredService.INSTANCE.checkBubbleRequest(mid2);
        if (Intrinsics.areEqual(code, TiredType2.SUCCESS.getValue())) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence bubbleInfo$lambda$2$0(BubbleBean.Resource str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String strategyId = str.getStrategyId();
        if (strategyId == null) {
            strategyId = "";
        }
        return strategyId;
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public boolean shouldFetchBubbleInfo(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        return UperCenterPlusBubbleService.INSTANCE.shouldFetchBubble$entrance_debug(mid);
    }

    private final UperCenterPlusBubbleInfo convertToBubbleInfo(BubbleBean.Resource resource, BubbleBean.Text text, long fans) {
        BubbleBean.Bubble bubbleInfo = resource != null ? resource.getBubble() : null;
        if (bubbleInfo == null || text == null) {
            return null;
        }
        String bubbleId = bubbleInfo.getBubbleId();
        String str = bubbleId == null ? "" : bubbleId;
        String title = text.getTitle();
        String str2 = title == null ? "" : title;
        String textId = text.getTextId();
        String str3 = textId == null ? "" : textId;
        String subtitle = text.getSubtitle();
        String str4 = subtitle == null ? "" : subtitle;
        String url = text.getUrl();
        String str5 = url == null ? "" : url;
        String jumpUrl = bubbleInfo.getJumpUrl();
        String str6 = jumpUrl == null ? "" : jumpUrl;
        String resourceId = resource.getResourceId();
        return new UperCenterPlusBubbleInfo(str, str2, str3, str4, str5, str6, "0", resourceId == null ? "" : resourceId, fans, resource.getInterestScore(), resource.getHotScore(), Companion.getResourceType(resource), resource.getForce());
    }

    private final boolean checkRunning(Function1<? super UperCenterPlusBubbleInfo, Unit> function1) {
        ReentrantLock lock$iv = this.lock;
        lock$iv.lock();
        try {
            this.callbackList.add(function1);
            int count = this.callbackList.size();
            return count > 1;
        } finally {
            lock$iv.unlock();
        }
    }

    private final void callbackResult(UperCenterPlusBubbleInfo info) {
        ReentrantLock lock$iv = this.lock;
        lock$iv.lock();
        try {
            Iterable $this$forEach$iv = this.callbackList;
            for (Object element$iv : $this$forEach$iv) {
                Function1 it = (Function1) element$iv;
                it.invoke(info);
            }
            this.callbackList.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            lock$iv.unlock();
        }
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public void exposure(String mid, String bubbleID, String strategyID, String resourceID, String textID, long fans, float interestScore, float hotScore, int isForce) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleTiredService.INSTANCE.exposure(mid, bubbleID, resourceID, textID, fans, interestScore, hotScore, isForce);
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public void exposureRecom(String mid, String strategyID, String resourceID, String textID) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleTiredService.INSTANCE.exposureRecom(mid, resourceID, textID);
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public void exposureRecomList(String mid, List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        BubbleTiredService.INSTANCE.exposureRecomList(mid, list);
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public String checkRecomText(String mid, String strategyID, String resourceID, List<String> list) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        return BubbleTiredService.INSTANCE.checkRecomTextList(mid, resourceID, list);
    }

    @Override // kntr.app.upper.entrance.bubble.UpperCenterPlusBubbleStrategy
    public long availableTime() {
        return BubbleTiredService.INSTANCE.getConfig().getBubbleAvailableTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0265  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x0245 -> B:94:0x0248). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0265 -> B:29:0x00d1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectBubbleByTired(String mid, BubbleBean bubbleBean, Continuation<? super Pair<BubbleBean.Resource, BubbleBean.Text>> continuation) {
        UperCenterPlusBubbleConcreteB$selectBubbleByTired$1 uperCenterPlusBubbleConcreteB$selectBubbleByTired$1;
        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB;
        BubbleBean.Text selectedText;
        Object obj;
        UperCenterPlusBubbleConcreteB$selectBubbleByTired$1 uperCenterPlusBubbleConcreteB$selectBubbleByTired$12;
        String mid2;
        BubbleBean bubbleBean2;
        BubbleBean.Resource selectedResource;
        List<BubbleBean.Resource> list;
        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB2;
        Object $result;
        List textList;
        Iterator<BubbleBean.Resource> it;
        Continuation $completion;
        BubbleBean.Resource resource;
        BubbleBean.Bubble bubble;
        Continuation $completion2;
        BubbleBean.Text text;
        BubbleBean.Text text2;
        if (continuation instanceof UperCenterPlusBubbleConcreteB$selectBubbleByTired$1) {
            uperCenterPlusBubbleConcreteB$selectBubbleByTired$1 = (UperCenterPlusBubbleConcreteB$selectBubbleByTired$1) continuation;
            if ((uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.label & Integer.MIN_VALUE) != 0) {
                uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.label -= Integer.MIN_VALUE;
                uperCenterPlusBubbleConcreteB = this;
                Object $result2 = uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                List<BubbleBean.Text> list2 = null;
                switch (uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        List<BubbleBean.Resource> resourceList = bubbleBean != null ? bubbleBean.getResourceList() : null;
                        List<BubbleBean.Resource> list3 = resourceList;
                        if (list3 == null || list3.isEmpty()) {
                            return new Pair(null, null);
                        }
                        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB3 = uperCenterPlusBubbleConcreteB;
                        selectedText = null;
                        Iterator<BubbleBean.Resource> it2 = resourceList.iterator();
                        List<BubbleBean.Resource> list4 = resourceList;
                        BubbleBean.Resource resource2 = null;
                        Object $result3 = $result2;
                        obj = coroutine_suspended;
                        Continuation $result4 = continuation;
                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired$1;
                        mid2 = mid;
                        bubbleBean2 = bubbleBean;
                        while (it2.hasNext()) {
                            BubbleBean.Resource resource3 = it2.next();
                            BubbleBean.Bubble bubble2 = resource3.getBubble();
                            textList = bubble2 != null ? bubble2.getText() : list2;
                            List list5 = textList;
                            if (list5 == null || list5.isEmpty()) {
                                $completion2 = $result4;
                            } else {
                                $completion2 = $result4;
                                if (BubbleTiredService.INSTANCE.checkStrategy(mid2, resource3.getResourceId(), resource3.getInterestScore(), resource3.forceValue())) {
                                    Iterator it3 = textList.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            Object next = it3.next();
                                            BubbleBean.Text it4 = (BubbleBean.Text) next;
                                            Iterator it5 = it3;
                                            $result = $result3;
                                            if (BubbleTiredService.INSTANCE.checkText(mid2, resource3.getResourceId(), it4.getTextId())) {
                                                text = next;
                                            } else {
                                                it3 = it5;
                                                $result3 = $result;
                                            }
                                        } else {
                                            $result = $result3;
                                            text = null;
                                        }
                                    }
                                    selectedText = text;
                                    if (selectedText == null) {
                                        BubbleTiredService.INSTANCE.clearStrategy(mid2, resource3.getResourceId());
                                        Iterator it6 = textList.iterator();
                                        while (true) {
                                            if (it6.hasNext()) {
                                                Object next2 = it6.next();
                                                BubbleBean.Text it7 = (BubbleBean.Text) next2;
                                                Iterator it8 = it6;
                                                if (BubbleTiredService.INSTANCE.checkText(mid2, resource3.getResourceId(), it7.getTextId())) {
                                                    text2 = next2;
                                                } else {
                                                    it6 = it8;
                                                }
                                            } else {
                                                text2 = null;
                                            }
                                        }
                                        BubbleBean.Text text3 = text2;
                                        if (text3 == null) {
                                            $result4 = $completion2;
                                            $result3 = $result;
                                            list2 = null;
                                        } else {
                                            selectedText = text3;
                                        }
                                    }
                                    if (!FeatureConfig.INSTANCE.getEnableCoupon()) {
                                        BubbleBean.Bubble bubble3 = resource3.getBubble();
                                        if (bubble3 != null && bubble3.getType() == 3) {
                                            $result4 = $completion2;
                                            $result3 = $result;
                                            list2 = null;
                                        }
                                    }
                                    if (FeatureConfig.INSTANCE.getEnableCoupon()) {
                                        BubbleCouponService bubbleCouponService = BubbleCouponService.INSTANCE;
                                        BubbleBean.Bubble bubble4 = resource3.getBubble();
                                        Integer boxInt = bubble4 != null ? Boxing.boxInt(bubble4.getType()) : null;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$0 = mid2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$1 = SpillingKt.nullOutSpilledVariable(bubbleBean2);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$3 = selectedText;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$4 = it2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$5 = resource3;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$6 = SpillingKt.nullOutSpilledVariable(bubble2);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$7 = SpillingKt.nullOutSpilledVariable(textList);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.label = 1;
                                        $result2 = bubbleCouponService.checkCouponValid(boxInt, mid2, uperCenterPlusBubbleConcreteB$selectBubbleByTired$12);
                                        if ($result2 == obj) {
                                            return obj;
                                        }
                                        $completion = $completion2;
                                        it = it2;
                                        uperCenterPlusBubbleConcreteB2 = uperCenterPlusBubbleConcreteB3;
                                        list = list4;
                                        selectedResource = resource2;
                                        resource = resource3;
                                        bubble = bubble2;
                                        if (((Boolean) $result2).booleanValue()) {
                                            $result4 = $completion;
                                            resource2 = selectedResource;
                                            list4 = list;
                                            $result3 = $result;
                                            it2 = it;
                                            uperCenterPlusBubbleConcreteB3 = uperCenterPlusBubbleConcreteB2;
                                            list2 = null;
                                            while (it2.hasNext()) {
                                            }
                                        } else {
                                            BubbleBlacklistService bubbleBlacklistService = BubbleBlacklistService.INSTANCE;
                                            String resourceId = resource.getResourceId();
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$0 = mid2;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$1 = SpillingKt.nullOutSpilledVariable(bubbleBean2);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$3 = selectedText;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$4 = it;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$5 = resource;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$6 = SpillingKt.nullOutSpilledVariable(bubble);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.L$7 = SpillingKt.nullOutSpilledVariable(textList);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired$12.label = 2;
                                            $result2 = bubbleBlacklistService.checkInBlacklist(mid2, resourceId, uperCenterPlusBubbleConcreteB$selectBubbleByTired$12);
                                            if ($result2 == obj) {
                                                return obj;
                                            }
                                            if (((Boolean) $result2).booleanValue()) {
                                                resource3 = resource;
                                                resource2 = resource3;
                                                return new Pair(resource2, selectedText);
                                            }
                                            $result4 = $completion;
                                            resource2 = selectedResource;
                                            list4 = list;
                                            $result3 = $result;
                                            it2 = it;
                                            uperCenterPlusBubbleConcreteB3 = uperCenterPlusBubbleConcreteB2;
                                            list2 = null;
                                            while (it2.hasNext()) {
                                            }
                                        }
                                    } else {
                                        resource2 = resource3;
                                        return new Pair(resource2, selectedText);
                                    }
                                }
                            }
                            $result4 = $completion2;
                            $result3 = $result3;
                            list2 = null;
                        }
                        return new Pair(resource2, selectedText);
                    case 1:
                        List textList2 = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$7;
                        BubbleBean.Bubble bubble5 = (BubbleBean.Bubble) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$6;
                        BubbleBean.Resource resource4 = (BubbleBean.Resource) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$5;
                        selectedText = (BubbleBean.Text) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$3;
                        selectedResource = null;
                        list = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$2;
                        String mid3 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        uperCenterPlusBubbleConcreteB2 = uperCenterPlusBubbleConcreteB;
                        $result = $result2;
                        textList = textList2;
                        it = (Iterator) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$4;
                        $completion = continuation;
                        resource = resource4;
                        mid2 = mid3;
                        bubble = bubble5;
                        obj = coroutine_suspended;
                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired$1;
                        bubbleBean2 = (BubbleBean) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$1;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    case 2:
                        List list6 = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$7;
                        bubble = (BubbleBean.Bubble) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$6;
                        resource = (BubbleBean.Resource) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$5;
                        BubbleBean.Text selectedText2 = (BubbleBean.Text) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$3;
                        String mid4 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        uperCenterPlusBubbleConcreteB2 = uperCenterPlusBubbleConcreteB;
                        $result = $result2;
                        it = (Iterator) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$4;
                        selectedText = selectedText2;
                        selectedResource = null;
                        list = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$2;
                        $completion = continuation;
                        mid2 = mid4;
                        obj = coroutine_suspended;
                        uperCenterPlusBubbleConcreteB$selectBubbleByTired$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired$1;
                        bubbleBean2 = (BubbleBean) uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.L$1;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uperCenterPlusBubbleConcreteB = this;
        uperCenterPlusBubbleConcreteB$selectBubbleByTired$1 = new UperCenterPlusBubbleConcreteB$selectBubbleByTired$1(uperCenterPlusBubbleConcreteB, continuation);
        Object $result22 = uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        List<BubbleBean.Text> list22 = null;
        switch (uperCenterPlusBubbleConcreteB$selectBubbleByTired$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0106  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x02e1 -> B:109:0x02ec). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0312 -> B:29:0x0100). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectBubbleByTired2(String mid, BubbleBean bubbleBean, Continuation<? super Triple<BubbleBean.Resource, BubbleBean.Text, TiredResult>> continuation) {
        UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1 uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1;
        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB;
        Object obj;
        List resourceList;
        Object $result;
        String mid2;
        BubbleBean bubbleBean2;
        Ref.ObjectRef tiredKey;
        BubbleBean.Text selectedText;
        BubbleBean.Resource selectedResource;
        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB2;
        List<BubbleBean.Text> list;
        Continuation continuation2;
        UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1 uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12;
        String msg;
        BubbleBean.Bubble bubble;
        Iterator<BubbleBean.Resource> it;
        Object obj2;
        TiredType2 type;
        BubbleBean.Resource resource;
        Object $result2;
        Continuation $completion;
        List<BubbleBean.Text> list2;
        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB3;
        Iterator<BubbleBean.Resource> it2;
        Continuation $completion2;
        Object $result3;
        BubbleBean.Resource selectedResource2;
        BubbleBean.Text text;
        Object obj3;
        if (continuation instanceof UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1) {
            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1 = (UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1) continuation;
            if ((uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.label & Integer.MIN_VALUE) != 0) {
                uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.label -= Integer.MIN_VALUE;
                uperCenterPlusBubbleConcreteB = this;
                Object $result4 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result4);
                        List resourceList2 = bubbleBean != null ? bubbleBean.getResourceList() : null;
                        List list3 = resourceList2;
                        if (list3 == null || list3.isEmpty()) {
                            return new Triple(null, null, new TiredResult(TiredType2.TIRED_STRATEGY, "供给列表为空"));
                        }
                        List<BubbleBean.Text> list4 = null;
                        TiredType2 type2 = TiredType2.SUCCESS;
                        UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB4 = uperCenterPlusBubbleConcreteB;
                        TiredType2 type3 = type2;
                        String msg2 = "";
                        Iterator<BubbleBean.Resource> it3 = resourceList2.iterator();
                        obj = coroutine_suspended;
                        BubbleBean.Resource selectedResource3 = null;
                        BubbleBean.Text selectedText2 = null;
                        resourceList = resourceList2;
                        UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1 uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1;
                        $result = $result4;
                        mid2 = mid;
                        bubbleBean2 = bubbleBean;
                        Continuation $result5 = continuation;
                        while (it3.hasNext()) {
                            BubbleBean.Resource resource2 = it3.next();
                            BubbleBean.Bubble bubble2 = resource2.getBubble();
                            list = bubble2 != null ? bubble2.getText() : list4;
                            Ref.ObjectRef tiredKey2 = new Ref.ObjectRef();
                            tiredKey2.element = resource2.getResourceId();
                            CharSequence charSequence = (CharSequence) tiredKey2.element;
                            if (charSequence == null || charSequence.length() == 0) {
                                $completion2 = $result5;
                                $result3 = $result;
                                tiredKey2.element = "bubble" + ((bubble2 == null || (r6 = bubble2.getBubbleId()) == null) ? "" : "");
                            } else {
                                $completion2 = $result5;
                                $result3 = $result;
                            }
                            List<BubbleBean.Text> list5 = list;
                            if (list5 == null || list5.isEmpty()) {
                                selectedResource2 = selectedResource3;
                            } else {
                                selectedResource2 = selectedResource3;
                                if (BubbleTiredService.INSTANCE.checkStrategy(mid2, (String) tiredKey2.element, resource2.getInterestScore(), resource2.forceValue())) {
                                    Iterator it4 = list.iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            Object next = it4.next();
                                            BubbleBean.Text it5 = (BubbleBean.Text) next;
                                            Iterator it6 = it4;
                                            if (BubbleTiredService.INSTANCE.checkText(mid2, (String) tiredKey2.element, it5.getTextId())) {
                                                text = next;
                                            } else {
                                                it4 = it6;
                                            }
                                        } else {
                                            text = null;
                                        }
                                    }
                                    BubbleBean.Text selectedText3 = text;
                                    selectedText2 = selectedText3;
                                    if (selectedText2 == null) {
                                        BubbleTiredService.INSTANCE.clearStrategy(mid2, (String) tiredKey2.element);
                                        Iterator it7 = list.iterator();
                                        while (true) {
                                            if (it7.hasNext()) {
                                                Object next2 = it7.next();
                                                BubbleBean.Text it8 = (BubbleBean.Text) next2;
                                                Iterator it9 = it7;
                                                if (BubbleTiredService.INSTANCE.checkText(mid2, (String) tiredKey2.element, it8.getTextId())) {
                                                    obj3 = next2;
                                                } else {
                                                    it7 = it9;
                                                }
                                            } else {
                                                obj3 = null;
                                            }
                                        }
                                        BubbleBean.Text text2 = (BubbleBean.Text) obj3;
                                        if (text2 == null) {
                                            $result5 = $completion2;
                                            $result = $result3;
                                            selectedResource3 = selectedResource2;
                                            list4 = null;
                                        } else {
                                            selectedText2 = text2;
                                        }
                                    }
                                    if (!FeatureConfig.INSTANCE.getEnableCoupon()) {
                                        BubbleBean.Bubble bubble3 = resource2.getBubble();
                                        if (bubble3 != null && bubble3.getType() == 3) {
                                            $result5 = $completion2;
                                            $result = $result3;
                                            selectedResource3 = selectedResource2;
                                            list4 = null;
                                        }
                                    }
                                    if (FeatureConfig.INSTANCE.getEnableCoupon()) {
                                        BubbleCouponService bubbleCouponService = BubbleCouponService.INSTANCE;
                                        BubbleBean.Bubble bubble4 = resource2.getBubble();
                                        Integer boxInt = bubble4 != null ? Boxing.boxInt(bubble4.getType()) : null;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$0 = mid2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$1 = SpillingKt.nullOutSpilledVariable(bubbleBean2);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$2 = SpillingKt.nullOutSpilledVariable(resourceList);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$3 = selectedText2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$4 = type3;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$5 = msg2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$6 = it3;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$7 = resource2;
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$8 = SpillingKt.nullOutSpilledVariable(bubble2);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$9 = SpillingKt.nullOutSpilledVariable(list);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.L$10 = SpillingKt.nullOutSpilledVariable(tiredKey2);
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13.label = 1;
                                        $result4 = bubbleCouponService.checkCouponValid(boxInt, mid2, uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13);
                                        if ($result4 == obj) {
                                            return obj;
                                        }
                                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13;
                                        obj2 = obj;
                                        it = it3;
                                        $result2 = $result3;
                                        selectedResource = selectedResource2;
                                        tiredKey = tiredKey2;
                                        continuation2 = $completion2;
                                        String str = msg2;
                                        selectedText = selectedText2;
                                        bubble = bubble2;
                                        uperCenterPlusBubbleConcreteB2 = uperCenterPlusBubbleConcreteB4;
                                        type = type3;
                                        resource = resource2;
                                        msg = str;
                                        if (((Boolean) $result4).booleanValue()) {
                                            Object $result6 = $result2;
                                            $result5 = continuation2;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12;
                                            obj = obj2;
                                            selectedText2 = selectedText;
                                            selectedResource3 = selectedResource;
                                            type3 = type;
                                            msg2 = msg;
                                            uperCenterPlusBubbleConcreteB4 = uperCenterPlusBubbleConcreteB2;
                                            list4 = null;
                                            it3 = it;
                                            $result = $result6;
                                            while (it3.hasNext()) {
                                            }
                                        } else {
                                            BubbleBlacklistService bubbleBlacklistService = BubbleBlacklistService.INSTANCE;
                                            Continuation continuation3 = continuation2;
                                            String resourceId = resource.getResourceId();
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$0 = mid2;
                                            Object $result7 = $result2;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$1 = SpillingKt.nullOutSpilledVariable(bubbleBean2);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$2 = SpillingKt.nullOutSpilledVariable(resourceList);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$3 = selectedText;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$4 = type;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$5 = msg;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$6 = it;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$7 = resource;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$8 = SpillingKt.nullOutSpilledVariable(bubble);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$9 = SpillingKt.nullOutSpilledVariable(list);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.L$10 = SpillingKt.nullOutSpilledVariable(tiredKey);
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12.label = 2;
                                            $result4 = bubbleBlacklistService.checkInBlacklist(mid2, resourceId, uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12);
                                            if ($result4 == obj2) {
                                                return obj2;
                                            }
                                            $completion = continuation3;
                                            obj = obj2;
                                            list2 = list;
                                            uperCenterPlusBubbleConcreteB3 = uperCenterPlusBubbleConcreteB2;
                                            it2 = it;
                                            $result = $result7;
                                            if (((Boolean) $result4).booleanValue()) {
                                                selectedText2 = selectedText;
                                                msg2 = msg;
                                                resource2 = resource;
                                                type3 = type;
                                                selectedResource3 = resource2;
                                                if (selectedResource3 == null) {
                                                    msg2 = "供给为空";
                                                    type3 = TiredType2.TIRED_STRATEGY;
                                                } else if (selectedText2 == null) {
                                                    msg2 = "文案为空";
                                                    type3 = TiredType2.TIRED_STRATEGY;
                                                }
                                                return new Triple(selectedResource3, selectedText2, new TiredResult(type3, msg2));
                                            }
                                            $result5 = $completion;
                                            uperCenterPlusBubbleConcreteB$selectBubbleByTired2$13 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12;
                                            selectedText2 = selectedText;
                                            selectedResource3 = selectedResource;
                                            type3 = type;
                                            msg2 = msg;
                                            it3 = it2;
                                            uperCenterPlusBubbleConcreteB4 = uperCenterPlusBubbleConcreteB3;
                                            list4 = null;
                                            while (it3.hasNext()) {
                                            }
                                        }
                                    } else {
                                        selectedResource3 = resource2;
                                        if (selectedResource3 == null) {
                                        }
                                        return new Triple(selectedResource3, selectedText2, new TiredResult(type3, msg2));
                                    }
                                }
                            }
                            $result5 = $completion2;
                            $result = $result3;
                            selectedResource3 = selectedResource2;
                            list4 = null;
                        }
                        if (selectedResource3 == null) {
                        }
                        return new Triple(selectedResource3, selectedText2, new TiredResult(type3, msg2));
                    case 1:
                        tiredKey = (Ref.ObjectRef) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$10;
                        BubbleBean.Bubble bubble5 = (BubbleBean.Bubble) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$8;
                        BubbleBean.Resource resource3 = (BubbleBean.Resource) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$7;
                        String msg3 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$5;
                        TiredType2 type4 = (TiredType2) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$4;
                        selectedText = (BubbleBean.Text) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$3;
                        selectedResource = null;
                        List resourceList3 = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$2;
                        mid2 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$0;
                        ResultKt.throwOnFailure($result4);
                        uperCenterPlusBubbleConcreteB2 = uperCenterPlusBubbleConcreteB;
                        list = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$9;
                        continuation2 = continuation;
                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1;
                        bubbleBean2 = (BubbleBean) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$1;
                        msg = msg3;
                        bubble = bubble5;
                        it = (Iterator) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$6;
                        obj2 = coroutine_suspended;
                        resourceList = resourceList3;
                        type = type4;
                        resource = resource3;
                        $result2 = $result4;
                        if (((Boolean) $result4).booleanValue()) {
                        }
                        break;
                    case 2:
                        tiredKey = (Ref.ObjectRef) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$10;
                        list2 = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$9;
                        bubble = (BubbleBean.Bubble) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$8;
                        resource = (BubbleBean.Resource) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$7;
                        String msg4 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$5;
                        type = (TiredType2) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$4;
                        BubbleBean.Text selectedText4 = (BubbleBean.Text) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$3;
                        List resourceList4 = (List) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$2;
                        String mid3 = (String) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$0;
                        ResultKt.throwOnFailure($result4);
                        uperCenterPlusBubbleConcreteB3 = uperCenterPlusBubbleConcreteB;
                        $completion = continuation;
                        mid2 = mid3;
                        obj = coroutine_suspended;
                        resourceList = resourceList4;
                        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$12 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1;
                        bubbleBean2 = (BubbleBean) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$1;
                        $result = $result4;
                        it2 = (Iterator) uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.L$6;
                        selectedText = selectedText4;
                        msg = msg4;
                        selectedResource = null;
                        if (((Boolean) $result4).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uperCenterPlusBubbleConcreteB = this;
        uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1 = new UperCenterPlusBubbleConcreteB$selectBubbleByTired2$1(uperCenterPlusBubbleConcreteB, continuation);
        Object $result42 = uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uperCenterPlusBubbleConcreteB$selectBubbleByTired2$1.label) {
        }
    }
}