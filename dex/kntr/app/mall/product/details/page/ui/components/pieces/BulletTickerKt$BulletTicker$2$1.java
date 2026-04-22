package kntr.app.mall.product.details.page.ui.components.pieces;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.MutableIntState;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BulletTicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.pieces.BulletTickerKt$BulletTicker$2$1", f = "BulletTicker.kt", i = {0, 1, 2}, l = {57, 59, 68}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$LaunchedEffect", "$this$LaunchedEffect"}, s = {"L$0", "L$0", "L$0"}, v = 1)
public final class BulletTickerKt$BulletTicker$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $alpha;
    final /* synthetic */ List<BasicInfoFloor.BulletScreen.BulletItem> $bulletScreenList;
    final /* synthetic */ int $fadeMillis;
    final /* synthetic */ MutableIntState $index$delegate;
    final /* synthetic */ int $showMillis;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletTickerKt$BulletTicker$2$1(List<BasicInfoFloor.BulletScreen.BulletItem> list, int i, int i2, Animatable<Float, AnimationVector1D> animatable, MutableIntState mutableIntState, Continuation<? super BulletTickerKt$BulletTicker$2$1> continuation) {
        super(2, continuation);
        this.$bulletScreenList = list;
        this.$showMillis = i;
        this.$fadeMillis = i2;
        this.$alpha = animatable;
        this.$index$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> bulletTickerKt$BulletTicker$2$1 = new BulletTickerKt$BulletTicker$2$1(this.$bulletScreenList, this.$showMillis, this.$fadeMillis, this.$alpha, this.$index$delegate, continuation);
        bulletTickerKt$BulletTicker$2$1.L$0 = obj;
        return bulletTickerKt$BulletTicker$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c6 -> B:14:0x004a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        BulletTickerKt$BulletTicker$2$1 bulletTickerKt$BulletTicker$2$1;
        Object obj;
        CoroutineScope $this$LaunchedEffect;
        int BulletTicker_EUb7tLY$lambda$2;
        CoroutineScope $this$LaunchedEffect2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$bulletScreenList.size() <= 1) {
                    return Unit.INSTANCE;
                }
                bulletTickerKt$BulletTicker$2$1 = this;
                obj = coroutine_suspended;
                $this$LaunchedEffect = $this$LaunchedEffect2;
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                    bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                    bulletTickerKt$BulletTicker$2$1.label = 1;
                    if (DelayKt.delay(bulletTickerKt$BulletTicker$2$1.$showMillis - bulletTickerKt$BulletTicker$2$1.$fadeMillis, (Continuation) bulletTickerKt$BulletTicker$2$1) == obj) {
                        return obj;
                    }
                    bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                    bulletTickerKt$BulletTicker$2$1.label = 2;
                    if (Animatable.animateTo$default(bulletTickerKt$BulletTicker$2$1.$alpha, Boxing.boxFloat(0.0f), AnimationSpecKt.tween$default(bulletTickerKt$BulletTicker$2$1.$fadeMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) bulletTickerKt$BulletTicker$2$1, 12, (Object) null) == obj) {
                        return obj;
                    }
                    MutableIntState mutableIntState = bulletTickerKt$BulletTicker$2$1.$index$delegate;
                    BulletTicker_EUb7tLY$lambda$2 = BulletTickerKt.BulletTicker_EUb7tLY$lambda$2(bulletTickerKt$BulletTicker$2$1.$index$delegate);
                    mutableIntState.setIntValue((BulletTicker_EUb7tLY$lambda$2 + 1) % bulletTickerKt$BulletTicker$2$1.$bulletScreenList.size());
                    bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                    bulletTickerKt$BulletTicker$2$1.label = 3;
                    if (Animatable.animateTo$default(bulletTickerKt$BulletTicker$2$1.$alpha, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(bulletTickerKt$BulletTicker$2$1.$fadeMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) bulletTickerKt$BulletTicker$2$1, 12, (Object) null) == obj) {
                        return obj;
                    }
                    if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                bulletTickerKt$BulletTicker$2$1 = this;
                obj = coroutine_suspended;
                $this$LaunchedEffect = $this$LaunchedEffect2;
                bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                bulletTickerKt$BulletTicker$2$1.label = 2;
                if (Animatable.animateTo$default(bulletTickerKt$BulletTicker$2$1.$alpha, Boxing.boxFloat(0.0f), AnimationSpecKt.tween$default(bulletTickerKt$BulletTicker$2$1.$fadeMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) bulletTickerKt$BulletTicker$2$1, 12, (Object) null) == obj) {
                }
                MutableIntState mutableIntState2 = bulletTickerKt$BulletTicker$2$1.$index$delegate;
                BulletTicker_EUb7tLY$lambda$2 = BulletTickerKt.BulletTicker_EUb7tLY$lambda$2(bulletTickerKt$BulletTicker$2$1.$index$delegate);
                mutableIntState2.setIntValue((BulletTicker_EUb7tLY$lambda$2 + 1) % bulletTickerKt$BulletTicker$2$1.$bulletScreenList.size());
                bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                bulletTickerKt$BulletTicker$2$1.label = 3;
                if (Animatable.animateTo$default(bulletTickerKt$BulletTicker$2$1.$alpha, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(bulletTickerKt$BulletTicker$2$1.$fadeMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) bulletTickerKt$BulletTicker$2$1, 12, (Object) null) == obj) {
                }
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                bulletTickerKt$BulletTicker$2$1 = this;
                obj = coroutine_suspended;
                $this$LaunchedEffect = $this$LaunchedEffect2;
                MutableIntState mutableIntState22 = bulletTickerKt$BulletTicker$2$1.$index$delegate;
                BulletTicker_EUb7tLY$lambda$2 = BulletTickerKt.BulletTicker_EUb7tLY$lambda$2(bulletTickerKt$BulletTicker$2$1.$index$delegate);
                mutableIntState22.setIntValue((BulletTicker_EUb7tLY$lambda$2 + 1) % bulletTickerKt$BulletTicker$2$1.$bulletScreenList.size());
                bulletTickerKt$BulletTicker$2$1.L$0 = $this$LaunchedEffect;
                bulletTickerKt$BulletTicker$2$1.label = 3;
                if (Animatable.animateTo$default(bulletTickerKt$BulletTicker$2$1.$alpha, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(bulletTickerKt$BulletTicker$2$1.$fadeMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) bulletTickerKt$BulletTicker$2$1, 12, (Object) null) == obj) {
                }
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                bulletTickerKt$BulletTicker$2$1 = this;
                obj = coroutine_suspended;
                $this$LaunchedEffect = $this$LaunchedEffect2;
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}