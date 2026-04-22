package kntr.app.im.chat.ui.module.picture;

import androidx.compose.runtime.MutableState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.AnimationState;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.picture.PictureModuleKt$BiliImageWithLifecycleCount$1$1", f = "PictureModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureModuleKt$BiliImageWithLifecycleCount$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<AnimationState> $animationState$delegate;
    final /* synthetic */ Object $rememberKey;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureModuleKt$BiliImageWithLifecycleCount$1$1(Object obj, MutableState<AnimationState> mutableState, Continuation<? super PictureModuleKt$BiliImageWithLifecycleCount$1$1> continuation) {
        super(2, continuation);
        this.$rememberKey = obj;
        this.$animationState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureModuleKt$BiliImageWithLifecycleCount$1$1(this.$rememberKey, this.$animationState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AnimationState BiliImageWithLifecycleCount$lambda$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ILogger kLog = KLog_androidKt.getKLog();
                Object obj = this.$rememberKey;
                BiliImageWithLifecycleCount$lambda$1 = PictureModuleKt.BiliImageWithLifecycleCount$lambda$1(this.$animationState$delegate);
                kLog.d("PictureModule", "key=" + obj + ", state=" + BiliImageWithLifecycleCount$lambda$1);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}