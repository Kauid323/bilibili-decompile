package kntr.app.upper.entrance.bubble;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.ab.AppLaunchAB;
import kntr.app.upper.entrance.ab.AppLaunchABConfig;
import kntr.app.upper.entrance.ab.AppLaunchABManager;
import kntr.app.upper.entrance.bubble2.UperCenterPlusBubbleConcreteB;
import kntr.app.upper.entrance.utils.LogUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: UperCenterPlusBubbleManager.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000fJ\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00182\u0006\u0010\f\u001a\u00020\u0005J9\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b0\u000fJV\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J4\u0010'\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J*\u0010(\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u001a\u0010)\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050+\u0018\u00010*J<\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010*J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lkntr/app/upper/entrance/bubble/UperCenterPlusBubbleManager;", "", "<init>", "()V", "TAG", "", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "strategy", "Lkntr/app/upper/entrance/bubble/UpperCenterPlusBubbleStrategy;", "bubbleInfo", "", "mid", "abExtra", "callBack", "Lkotlin/Function1;", "Lkntr/app/upper/entrance/bubble/UperCenterPlusBubbleInfo;", "Lkotlin/ParameterName;", "name", "info", "checkAb", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldFetchInColdStart", "Lkotlin/Pair;", "isAbChild", "callback", "exposure", "bubbleID", "strategyID", "resourceID", "textID", "fans", "", "interestScore", "", "hotScore", "isForce", "", "exposureRecom", "exposureRecomList", "textIDs", "", "", "checkRecomText", "availableTime", "cancel", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UperCenterPlusBubbleManager {
    private static final String TAG = "UperCenterPlusBubble";
    private static UpperCenterPlusBubbleStrategy strategy;
    public static final UperCenterPlusBubbleManager INSTANCE = new UperCenterPlusBubbleManager();
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus((CoroutineExceptionHandler) new UperCenterPlusBubbleManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));

    private UperCenterPlusBubbleManager() {
    }

    public final void bubbleInfo(String mid, String abExtra, Function1<? super UperCenterPlusBubbleInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(abExtra, "abExtra");
        Intrinsics.checkNotNullParameter(function1, "callBack");
        BuildersKt.launch$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new UperCenterPlusBubbleManager$bubbleInfo$1(mid, abExtra, function1, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpperCenterPlusBubbleStrategy strategy() {
        if (strategy == null) {
            strategy = UperCenterPlusBubbleConcreteB.Companion.newInstance();
        }
        return strategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkAb(String mid, String abExtra, Continuation<? super Boolean> continuation) {
        UperCenterPlusBubbleManager$checkAb$1 uperCenterPlusBubbleManager$checkAb$1;
        Object abAsyncWithTimeout$entrance_debug$default;
        if (continuation instanceof UperCenterPlusBubbleManager$checkAb$1) {
            uperCenterPlusBubbleManager$checkAb$1 = (UperCenterPlusBubbleManager$checkAb$1) continuation;
            if ((uperCenterPlusBubbleManager$checkAb$1.label & Integer.MIN_VALUE) != 0) {
                uperCenterPlusBubbleManager$checkAb$1.label -= Integer.MIN_VALUE;
                Object $result = uperCenterPlusBubbleManager$checkAb$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uperCenterPlusBubbleManager$checkAb$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AppLaunchABManager appLaunchABManager = AppLaunchABManager.INSTANCE;
                        AppLaunchAB center_plus_bubble = AppLaunchABConfig.INSTANCE.getCENTER_PLUS_BUBBLE();
                        uperCenterPlusBubbleManager$checkAb$1.L$0 = SpillingKt.nullOutSpilledVariable(mid);
                        uperCenterPlusBubbleManager$checkAb$1.L$1 = SpillingKt.nullOutSpilledVariable(abExtra);
                        uperCenterPlusBubbleManager$checkAb$1.label = 1;
                        abAsyncWithTimeout$entrance_debug$default = AppLaunchABManager.abAsyncWithTimeout$entrance_debug$default(appLaunchABManager, center_plus_bubble, mid, abExtra, 0L, uperCenterPlusBubbleManager$checkAb$1, 8, null);
                        if (abAsyncWithTimeout$entrance_debug$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        String str = (String) uperCenterPlusBubbleManager$checkAb$1.L$1;
                        String str2 = (String) uperCenterPlusBubbleManager$checkAb$1.L$0;
                        ResultKt.throwOnFailure($result);
                        abAsyncWithTimeout$entrance_debug$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String abResult = (String) abAsyncWithTimeout$entrance_debug$default;
                LogUtils.INSTANCE.i(TAG, "requestBubble checkAb " + abResult);
                return Boxing.boxBoolean(AppLaunchABConfig.INSTANCE.getCENTER_PLUS_BUBBLE().is1(abResult));
            }
        }
        uperCenterPlusBubbleManager$checkAb$1 = new UperCenterPlusBubbleManager$checkAb$1(this, continuation);
        Object $result2 = uperCenterPlusBubbleManager$checkAb$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uperCenterPlusBubbleManager$checkAb$1.label) {
        }
        String abResult2 = (String) abAsyncWithTimeout$entrance_debug$default;
        LogUtils.INSTANCE.i(TAG, "requestBubble checkAb " + abResult2);
        return Boxing.boxBoolean(AppLaunchABConfig.INSTANCE.getCENTER_PLUS_BUBBLE().is1(abResult2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        if ((r5 != null ? r5.shouldFetchBubbleInfo(r7) : false) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Boolean, Boolean> shouldFetchInColdStart(String mid) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        String abCache = AppLaunchABManager.INSTANCE.fetchAbCache$entrance_debug(AppLaunchABConfig.INSTANCE.getCENTER_PLUS_BUBBLE(), mid);
        boolean bubbleEnable = true;
        boolean abEnable = abCache == null;
        if (abCache == null) {
            bubbleEnable = false;
        } else {
            boolean hit = AppLaunchABConfig.INSTANCE.getCENTER_PLUS_BUBBLE().is1(abCache);
            if (hit) {
                UpperCenterPlusBubbleStrategy strategy2 = strategy();
            }
            bubbleEnable = false;
        }
        return new Pair<>(Boolean.valueOf(abEnable), Boolean.valueOf(bubbleEnable));
    }

    public final void isAbChild(String mid, String abExtra, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(abExtra, "abExtra");
        Intrinsics.checkNotNullParameter(function1, "callback");
        BuildersKt.launch$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new UperCenterPlusBubbleManager$isAbChild$1(mid, abExtra, function1, null), 3, (Object) null);
    }

    public final void exposure(String mid, String bubbleID, String strategyID, String resourceID, String textID, long fans, float interestScore, float hotScore, int isForce) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "exposure, bubbleID=" + bubbleID + ", strategyID=" + strategyID + ",resourceID=" + resourceID + ", " + textID + ", isForce=" + isForce);
        UpperCenterPlusBubbleStrategy upperCenterPlusBubbleStrategy = strategy;
        if (upperCenterPlusBubbleStrategy != null) {
            upperCenterPlusBubbleStrategy.exposure(mid, bubbleID, strategyID, resourceID, textID, fans, interestScore, hotScore, isForce);
        }
    }

    public final void exposureRecom(boolean isAbChild, String mid, String strategyID, String resourceID, String textID) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "exposureRecom:isAbChild=" + isAbChild + ",strategyID=" + strategyID + ",resourceID=" + resourceID + ",  textID=" + textID);
        UpperCenterPlusBubbleStrategy strategy2 = strategy();
        if (strategy2 != null) {
            strategy2.exposureRecom(mid, strategyID, resourceID, textID);
        }
    }

    public final void exposureRecomList(String mid, List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "exposureRecomList:textIDs=" + list);
        UpperCenterPlusBubbleStrategy upperCenterPlusBubbleStrategy = strategy;
        if (upperCenterPlusBubbleStrategy != null) {
            upperCenterPlusBubbleStrategy.exposureRecomList(mid, list);
        }
    }

    public final String checkRecomText(boolean isAbChild, String mid, String strategyID, String resourceID, List<String> list) {
        Intrinsics.checkNotNullParameter(mid, "mid");
        LogUtils.INSTANCE.i(TAG, "checkRecomText:isAbChild=" + isAbChild + ",strategyID=" + strategyID + ", resourceID=" + resourceID + ", textIDs=" + list);
        UpperCenterPlusBubbleStrategy strategy2 = strategy();
        if (strategy2 != null) {
            return strategy2.checkRecomText(mid, strategyID, resourceID, list);
        }
        return null;
    }

    public final long availableTime() {
        UpperCenterPlusBubbleStrategy upperCenterPlusBubbleStrategy = strategy;
        if (upperCenterPlusBubbleStrategy != null) {
            return upperCenterPlusBubbleStrategy.availableTime();
        }
        return 0L;
    }

    public final void cancel() {
        CoroutineScopeKt.cancel$default(ioScope, (CancellationException) null, 1, (Object) null);
    }
}