package tv.danmaku.bili.auth.v2;

import bili.resource.account.R;
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
import tv.danmaku.bili.api.bean.CardTypeBean;

/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00070\u0002¢\u0006\u0002\b\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "Lkotlin/jvm/internal/EnhancedNullability;", "type", "Ltv/danmaku/bili/api/bean/CardTypeBean;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$onViewCreated$1$11", f = "BiliAuthFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$onViewCreated$1$11 extends SuspendLambda implements Function3<TintLinearLayout, CardTypeBean, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentAuthing2Binding $this_run;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliAuthFragmentV2$onViewCreated$1$11(FragmentAuthing2Binding fragmentAuthing2Binding, Continuation<? super BiliAuthFragmentV2$onViewCreated$1$11> continuation) {
        super(3, continuation);
        this.$this_run = fragmentAuthing2Binding;
    }

    public final Object invoke(TintLinearLayout tintLinearLayout, CardTypeBean cardTypeBean, Continuation<? super Unit> continuation) {
        BiliAuthFragmentV2$onViewCreated$1$11 biliAuthFragmentV2$onViewCreated$1$11 = new BiliAuthFragmentV2$onViewCreated$1$11(this.$this_run, continuation);
        biliAuthFragmentV2$onViewCreated$1$11.L$0 = cardTypeBean;
        return biliAuthFragmentV2$onViewCreated$1$11.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CardTypeBean type = (CardTypeBean) this.L$0;
                this.$this_run.tvCertTypeValue.setText(type.getName());
                this.$this_run.genderContainer.setVisibility(type.getGenderRequired() ? 0 : 8);
                this.$this_run.genderLine.setVisibility(type.getGenderRequired() ? 0 : 8);
                this.$this_run.birthContainer.setVisibility(type.getBirthdayRequired() ? 0 : 8);
                this.$this_run.birthLine.setVisibility(type.getBirthdayRequired() ? 0 : 8);
                if (type.getId() == CertType.RESIDENT_ID.getCardType()) {
                    this.$this_run.tvCardType.setText(R.string.account_global_string_425);
                    this.$this_run.editCard.setHint(R.string.account_global_string_298);
                } else {
                    this.$this_run.tvCardType.setText(R.string.account_global_string_484);
                    this.$this_run.editCard.setHint(R.string.account_global_string_491);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}