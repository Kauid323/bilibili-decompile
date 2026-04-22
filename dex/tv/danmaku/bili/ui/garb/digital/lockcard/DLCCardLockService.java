package tv.danmaku.bili.ui.garb.digital.lockcard;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.DigitalJsCallHandler;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;

/* compiled from: DLCCardLockService.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u001a\u0018\u00010#R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/DLCCardLockService;", "", "context", "Landroid/content/Context;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "service", "Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "handler", "Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "cardLockScope", "cardStatusChangedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "cardLockStatus", "getCardLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "createLockModel", "Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateLockModel;", "createCardLockComponent", "Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateCardLockUIComponent;", "renderCardLock", "", "cardLockComposeView", "Landroidx/compose/ui/platform/ComposeView;", "actId", "cardId", "cardTypeId", "cardNo", "", "cardStatusChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardLockService {
    public static final int $stable = 8;
    private CoroutineScope cardLockScope;
    private final MutableStateFlow<Pair<Long, CardLockStatus>> cardStatusChangedFlow;
    private final CreateCardLockUIComponent createCardLockComponent;
    private final CreateLockModel createLockModel;
    private final DigitalJsCallHandler handler;

    public DLCCardLockService(Context context, CoroutineScope lifecycleScope, DLCApiService service, DigitalJsCallHandler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        this.handler = handler;
        this.cardStatusChangedFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.createLockModel = new CreateLockModel(context, service, this.cardStatusChangedFlow, lifecycleScope);
        this.createCardLockComponent = new CreateCardLockUIComponent(this.createLockModel, new UnlockCardDialogService());
        if (lifecycleScope == null) {
            return;
        }
        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new DLCCardLockService$special$$inlined$awaitCancel$1(null, this), 3, (Object) null);
    }

    public /* synthetic */ DLCCardLockService(Context context, CoroutineScope coroutineScope, DLCApiService dLCApiService, DigitalJsCallHandler digitalJsCallHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, coroutineScope, dLCApiService, (i & 8) != 0 ? null : digitalJsCallHandler);
    }

    public final CardLockStatus getCardLockStatus() {
        Pair pair = (Pair) this.cardStatusChangedFlow.getValue();
        if (pair != null) {
            return (CardLockStatus) pair.getSecond();
        }
        return null;
    }

    public static /* synthetic */ void renderCardLock$default(DLCCardLockService dLCCardLockService, ComposeView composeView, long j, CardLockStatus cardLockStatus, long j2, long j3, String str, Function1 function1, int i, Object obj) {
        Function1 function12;
        if ((i & 64) == 0) {
            function12 = function1;
        } else {
            function12 = null;
        }
        dLCCardLockService.renderCardLock(composeView, j, cardLockStatus, j2, j3, str, function12);
    }

    public final void renderCardLock(ComposeView cardLockComposeView, long actId, CardLockStatus cardLockStatus, long cardId, long cardTypeId, String cardNo, Function1<? super CardLockStatus, Unit> function1) {
        Intrinsics.checkNotNullParameter(cardLockComposeView, "cardLockComposeView");
        Intrinsics.checkNotNullParameter(cardLockStatus, "cardLockStatus");
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        this.cardStatusChangedFlow.setValue((Object) null);
        CoroutineScope coroutineScope = this.cardLockScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.cardLockScope = scope;
        CoroutineScope coroutineScope2 = this.cardLockScope;
        if (coroutineScope2 != null) {
            BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new DLCCardLockService$renderCardLock$1(this, function1, null), 3, (Object) null);
        }
        final Function3 uiComponent = this.createCardLockComponent.invoke(cardLockStatus, actId, cardId, cardTypeId, cardNo, scope);
        View $this$isVisible$iv = (View) cardLockComposeView;
        $this$isVisible$iv.setVisibility(0);
        cardLockComposeView.setContent(ComposableLambdaKt.composableLambdaInstance(228819985, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit renderCardLock$lambda$0;
                renderCardLock$lambda$0 = DLCCardLockService.renderCardLock$lambda$0(uiComponent, (Composer) obj, ((Integer) obj2).intValue());
                return renderCardLock$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderCardLock$lambda$0(final Function3 $uiComponent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C78@2852L167,78@2842L177:DLCCardLockService.kt#fsh0na");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228819985, $changed, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService.renderCardLock.<anonymous> (DLCCardLockService.kt:78)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1149147081, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit renderCardLock$lambda$0$0;
                    renderCardLock$lambda$0$0 = DLCCardLockService.renderCardLock$lambda$0$0($uiComponent, (Composer) obj, ((Integer) obj2).intValue());
                    return renderCardLock$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderCardLock$lambda$0$0(Function3 $uiComponent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C79@2870L135:DLCCardLockService.kt#fsh0na");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1149147081, $changed, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService.renderCardLock.<anonymous>.<anonymous> (DLCCardLockService.kt:79)");
            }
            $uiComponent.invoke(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(3)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}