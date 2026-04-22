package tv.danmaku.bili.ui.garb.adapter;

import android.graphics.drawable.GradientDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.baseres.R;
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
import tv.danmaku.bili.ui.garb.holder.CollectionAllViewHolder;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionAllAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$onBindViewHolder$2$1$1", f = "CollectionAllAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CollectionAllAdapter$onBindViewHolder$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $background;
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionAllAdapter$onBindViewHolder$2$1$1(RecyclerView.ViewHolder viewHolder, int i, Continuation<? super CollectionAllAdapter$onBindViewHolder$2$1$1> continuation) {
        super(2, continuation);
        this.$holder = viewHolder;
        this.$background = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionAllAdapter$onBindViewHolder$2$1$1(this.$holder, this.$background, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                GradientDrawable bottomBg = new GradientDrawable();
                bottomBg.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f)});
                bottomBg.setColor(this.$background);
                ((CollectionAllViewHolder) this.$holder).getBinding().collectionAllCardBottomBg.setBackground(bottomBg);
                GradientDrawable bottomMaskBg = new GradientDrawable();
                bottomMaskBg.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f), DpUtils.dp2px(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext(), 5.0f)});
                bottomMaskBg.setColor(((CollectionAllViewHolder) this.$holder).getBinding().getRoot().getContext().getResources().getColor(R.color.black_alpha40));
                ((CollectionAllViewHolder) this.$holder).getBinding().collectionAllCardBottomBgMask.setBackground(bottomMaskBg);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}