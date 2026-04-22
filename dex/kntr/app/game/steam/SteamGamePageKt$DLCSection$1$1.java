package kntr.app.game.steam;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamGamePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamGamePageKt$DLCSection$1$1", f = "SteamGamePage.kt", i = {}, l = {1309}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SteamGamePageKt$DLCSection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $isRefreshing$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $rotateAnim;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamGamePageKt$DLCSection$1$1(Animatable<Float, AnimationVector1D> animatable, State<Boolean> state, Continuation<? super SteamGamePageKt$DLCSection$1$1> continuation) {
        super(2, continuation);
        this.$rotateAnim = animatable;
        this.$isRefreshing$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamGamePageKt$DLCSection$1$1(this.$rotateAnim, this.$isRefreshing$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean DLCSection$lambda$0;
        SteamGamePageKt$DLCSection$1$1 steamGamePageKt$DLCSection$1$1;
        boolean DLCSection$lambda$02;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DLCSection$lambda$0 = SteamGamePageKt.DLCSection$lambda$0(this.$isRefreshing$delegate);
                if (DLCSection$lambda$0) {
                    steamGamePageKt$DLCSection$1$1 = this;
                    while (DLCSection$lambda$02) {
                        steamGamePageKt$DLCSection$1$1.label = 1;
                        if (Animatable.animateTo$default(steamGamePageKt$DLCSection$1$1.$rotateAnim, Boxing.boxFloat(((Number) steamGamePageKt$DLCSection$1$1.$rotateAnim.getValue()).floatValue() + 360.0f), AnimationSpecKt.tween$default(1500, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) steamGamePageKt$DLCSection$1$1, 12, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                steamGamePageKt$DLCSection$1$1 = this;
                while (DLCSection$lambda$02) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}