package tv.danmaku.bili.auth.v2;

import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\u00070\u0002¢\u0006\u0002\b\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "Lkotlin/jvm/internal/EnhancedNullability;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$1$9", f = "BiliAuthFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$onViewCreated$1$9 extends SuspendLambda implements Function3<TintImageView, Boolean, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthFragmentV2$onViewCreated$1$9(Continuation<? super BiliAuthFragmentV2$onViewCreated$1$9> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TintImageView tintImageView, boolean z, Continuation<? super Unit> continuation) {
        BiliAuthFragmentV2$onViewCreated$1$9 biliAuthFragmentV2$onViewCreated$1$9 = new BiliAuthFragmentV2$onViewCreated$1$9(continuation);
        biliAuthFragmentV2$onViewCreated$1$9.L$0 = tintImageView;
        biliAuthFragmentV2$onViewCreated$1$9.Z$0 = z;
        return biliAuthFragmentV2$onViewCreated$1$9.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((TintImageView) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                TintImageView tintImageView = (TintImageView) this.L$0;
                boolean it = this.Z$0;
                tintImageView.setVisibility(it ? 0 : 8);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}