package tv.danmaku.bili.auth.v2;

import com.bilibili.app.auth.databinding.FragmentAuthing2Binding;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\u00070\u0002¢\u0006\u0002\b\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "Lkotlin/jvm/internal/EnhancedNullability;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$1$4", f = "BiliAuthFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$onViewCreated$1$4 extends SuspendLambda implements Function3<TintLinearLayout, Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentAuthing2Binding $this_run;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliAuthFragmentV2$onViewCreated$1$4(FragmentAuthing2Binding fragmentAuthing2Binding, Continuation<? super BiliAuthFragmentV2$onViewCreated$1$4> continuation) {
        super(3, continuation);
        this.$this_run = fragmentAuthing2Binding;
    }

    public final Object invoke(TintLinearLayout tintLinearLayout, boolean z, Continuation<? super Unit> continuation) {
        BiliAuthFragmentV2$onViewCreated$1$4 biliAuthFragmentV2$onViewCreated$1$4 = new BiliAuthFragmentV2$onViewCreated$1$4(this.$this_run, continuation);
        biliAuthFragmentV2$onViewCreated$1$4.Z$0 = z;
        return biliAuthFragmentV2$onViewCreated$1$4.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((TintLinearLayout) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                boolean it = this.Z$0;
                this.$this_run.certTypeContainer.setClickable(it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}