package tv.danmaku.bili.ui.garb.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.data.CollectionBizType;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.garb.holder.CollectionAllViewHolder;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* compiled from: CollectionAllAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$onBindViewHolder$2", f = "CollectionAllAdapter.kt", i = {1}, l = {BR.containerVisible, BR.content}, m = "invokeSuspend", n = {BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND}, s = {"I$0"}, v = 1)
final class CollectionAllAdapter$onBindViewHolder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpaceBannerItem $data;
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CollectionAllAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionAllAdapter$onBindViewHolder$2(SpaceBannerItem spaceBannerItem, RecyclerView.ViewHolder viewHolder, CollectionAllAdapter collectionAllAdapter, Continuation<? super CollectionAllAdapter$onBindViewHolder$2> continuation) {
        super(2, continuation);
        this.$data = spaceBannerItem;
        this.$holder = viewHolder;
        this.this$0 = collectionAllAdapter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionAllAdapter$onBindViewHolder$2(this.$data, this.$holder, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object $result;
        String cover;
        final CollectionAllAdapter collectionAllAdapter;
        boolean z;
        Object pageColor;
        final RecyclerView.ViewHolder viewHolder;
        final SpaceBannerItem spaceBannerItem;
        int background;
        Object $result2;
        int total;
        final String spaceHeaderJumpUrl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                $result = obj;
                SpaceBannerItem spaceBannerItem2 = this.$data;
                if (spaceBannerItem2 != null && (cover = spaceBannerItem2.getCover()) != null) {
                    RecyclerView.ViewHolder viewHolder2 = this.$holder;
                    collectionAllAdapter = this.this$0;
                    SpaceBannerItem spaceBannerItem3 = this.$data;
                    z = false;
                    Context context = viewHolder2.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    Lifecycle lifecycle = collectionAllAdapter.getLifecycle();
                    this.L$0 = viewHolder2;
                    this.L$1 = collectionAllAdapter;
                    this.L$2 = spaceBannerItem3;
                    this.label = 1;
                    pageColor = ((CollectionAllViewHolder) viewHolder2).getPageColor(cover, context, lifecycle, this);
                    if (pageColor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewHolder = viewHolder2;
                    spaceBannerItem = spaceBannerItem3;
                    background = ((Number) pageColor).intValue();
                    this.L$0 = viewHolder;
                    this.L$1 = collectionAllAdapter;
                    this.L$2 = spaceBannerItem;
                    this.I$0 = background;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new CollectionAllAdapter$onBindViewHolder$2$1$1(viewHolder, background, null), this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    SpaceBannerExtra extra = spaceBannerItem.getExtra();
                    total = extra == null ? extra.getTotal() : 0;
                    SpaceBannerExtra extra2 = spaceBannerItem.getExtra();
                    int owned = extra2 == null ? extra2.getOwned() : 0;
                    SpaceBannerExtra extra3 = spaceBannerItem.getExtra();
                    spaceHeaderJumpUrl = (extra3 != null || (spaceHeaderJumpUrl = extra3.getSpaceHeaderJumpUrl()) == null) ? "" : "";
                    if (StringsKt.isBlank(spaceHeaderJumpUrl) && spaceBannerItem.getBizType() == CollectionBizType.DIGITAL && total > 0) {
                        CollectionAllViewHolder collectionAllViewHolder = (CollectionAllViewHolder) viewHolder;
                        collectionAllViewHolder.getBinding().collectionAllHeaderCount.setVisibility(8);
                        collectionAllViewHolder.getBinding().collectionAllHeaderBadge.setVisibility(0);
                        collectionAllViewHolder.getBinding().badgeTitle.setText("已收集" + owned + "/" + total);
                        GradientDrawable badgeBg = new GradientDrawable();
                        float dp12 = DpUtils.dp2px(collectionAllViewHolder.getBinding().getRoot().getContext(), 12.0f);
                        badgeBg.setCornerRadii(new float[]{dp12, dp12, 0.0f, 0.0f, 0.0f, 0.0f, dp12, dp12});
                        badgeBg.setColor(background);
                        collectionAllViewHolder.getBinding().collectionAllHeaderBadge.setBackground(badgeBg);
                        collectionAllViewHolder.getBinding().collectionAllHeaderBadge.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$onBindViewHolder$2$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CollectionAllAdapter$onBindViewHolder$2.invokeSuspend$lambda$0$0(spaceHeaderJumpUrl, viewHolder, spaceBannerItem, collectionAllAdapter, view);
                            }
                        });
                    } else {
                        CollectionAllViewHolder collectionAllViewHolder2 = (CollectionAllViewHolder) viewHolder;
                        collectionAllViewHolder2.getBinding().collectionAllHeaderBadge.setVisibility(8);
                        if (total != 0) {
                            if ((spaceBannerItem.getBizType() == CollectionBizType.GARB || spaceBannerItem.getBizType() == CollectionBizType.NFT) && owned > 1) {
                                collectionAllViewHolder2.getBinding().collectionAllHeaderCount.setVisibility(0);
                                collectionAllViewHolder2.getBinding().collectionAllHeaderCount.setText(String.valueOf(owned));
                            } else {
                                collectionAllViewHolder2.getBinding().collectionAllHeaderCount.setVisibility(8);
                            }
                        } else {
                            collectionAllViewHolder2.getBinding().collectionAllHeaderCount.setVisibility(0);
                            collectionAllViewHolder2.getBinding().collectionAllHeaderCount.setText(owned + "/" + total);
                        }
                    }
                }
                Object $result3 = Unit.INSTANCE;
                return $result3;
            case 1:
                $result = obj;
                spaceBannerItem = (SpaceBannerItem) this.L$2;
                collectionAllAdapter = (CollectionAllAdapter) this.L$1;
                viewHolder = (RecyclerView.ViewHolder) this.L$0;
                ResultKt.throwOnFailure($result);
                z = false;
                pageColor = $result;
                background = ((Number) pageColor).intValue();
                this.L$0 = viewHolder;
                this.L$1 = collectionAllAdapter;
                this.L$2 = spaceBannerItem;
                this.I$0 = background;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new CollectionAllAdapter$onBindViewHolder$2$1$1(viewHolder, background, null), this) != coroutine_suspended) {
                }
                break;
            case 2:
                $result2 = obj;
                background = this.I$0;
                spaceBannerItem = (SpaceBannerItem) this.L$2;
                collectionAllAdapter = (CollectionAllAdapter) this.L$1;
                viewHolder = (RecyclerView.ViewHolder) this.L$0;
                ResultKt.throwOnFailure($result2);
                SpaceBannerExtra extra4 = spaceBannerItem.getExtra();
                if (extra4 == null) {
                }
                SpaceBannerExtra extra22 = spaceBannerItem.getExtra();
                if (extra22 == null) {
                }
                SpaceBannerExtra extra32 = spaceBannerItem.getExtra();
                if (extra32 != null) {
                    break;
                }
                if (StringsKt.isBlank(spaceHeaderJumpUrl)) {
                    break;
                }
                CollectionAllViewHolder collectionAllViewHolder22 = (CollectionAllViewHolder) viewHolder;
                collectionAllViewHolder22.getBinding().collectionAllHeaderBadge.setVisibility(8);
                if (total != 0) {
                }
                Object $result32 = Unit.INSTANCE;
                return $result32;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0$0(String $spaceHeaderJumpUrl, RecyclerView.ViewHolder $holder, SpaceBannerItem $data, CollectionAllAdapter this$0, View it) {
        SpaceNftUtils.INSTANCE.routeWithMap($spaceHeaderJumpUrl, (Map) null, ((CollectionAllViewHolder) $holder).getBinding().getRoot().getContext());
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("btn", "1");
        pairArr[1] = TuplesKt.to("id", $data.getItemId());
        pairArr[2] = TuplesKt.to(AuthResultCbHelper.ARGS_STATE, this$0.isMe() ? "1" : "0");
        Neurons.reportClick(false, "sqzz.dressing-collection.card.0.click", MapsKt.mapOf(pairArr));
    }
}