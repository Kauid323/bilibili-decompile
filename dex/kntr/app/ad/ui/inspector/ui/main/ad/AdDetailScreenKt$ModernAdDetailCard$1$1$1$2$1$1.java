package kntr.app.ad.ui.inspector.ui.main.ad;

import androidx.compose.runtime.MutableState;
import kntr.app.live.room.multivideo.poll.LivePollConnection;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdDetailScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1", f = "AdDetailScreen.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $copied$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1(MutableState<Boolean> mutableState, Continuation<? super AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$copied$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1(this.$copied$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean ModernAdDetailCard$lambda$0$0$3$1$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ModernAdDetailCard$lambda$0$0$3$1$1 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$1(this.$copied$delegate);
                if (ModernAdDetailCard$lambda$0$0$3$1$1) {
                    this.label = 1;
                    if (DelayKt.delay((long) LivePollConnection.DEFAULT_INTERVAL, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$2(this.$copied$delegate, false);
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$2(this.$copied$delegate, false);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}