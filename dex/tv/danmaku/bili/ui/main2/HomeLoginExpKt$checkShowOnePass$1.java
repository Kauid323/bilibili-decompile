package tv.danmaku.bili.ui.main2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeLoginExp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePass$1", f = "HomeLoginExp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeLoginExpKt$checkShowOnePass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeFragmentV2 $this_checkShowOnePass;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLoginExpKt$checkShowOnePass$1(HomeFragmentV2 homeFragmentV2, Continuation<? super HomeLoginExpKt$checkShowOnePass$1> continuation) {
        super(2, continuation);
        this.$this_checkShowOnePass = homeFragmentV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeLoginExpKt$checkShowOnePass$1(this.$this_checkShowOnePass, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HomeLoginExpKt.checkShowOnePassLoginGuide(this.$this_checkShowOnePass, false);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}