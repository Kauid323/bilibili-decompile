package kntr.app.im.chat.ui.module.localPicture;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntRect;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$LocalImage$3$1$1", f = "LocalPictureModule.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LocalPictureModuleKt$LocalImage$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function3<ImageSource, IntRect, Continuation<? super Unit>, Object>> $click;
    final /* synthetic */ IntRect $frameInWindow;
    final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPictureModuleKt$LocalImage$3$1$1(State<? extends Function3<? super ImageSource, ? super IntRect, ? super Continuation<? super Unit>, ? extends Object>> state, IntRect intRect, MutableState<ImageSource> mutableState, Continuation<? super LocalPictureModuleKt$LocalImage$3$1$1> continuation) {
        super(2, continuation);
        this.$click = state;
        this.$frameInWindow = intRect;
        this.$imageSource$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalPictureModuleKt$LocalImage$3$1$1(this.$click, this.$frameInWindow, this.$imageSource$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ImageSource LocalImage_MMVEmd4$lambda$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LocalImage_MMVEmd4$lambda$3 = LocalPictureModuleKt.LocalImage_MMVEmd4$lambda$3(this.$imageSource$delegate);
                IntRect intRect = this.$frameInWindow;
                this.label = 1;
                if (((Function3) this.$click.getValue()).invoke(LocalImage_MMVEmd4$lambda$3, intRect, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}