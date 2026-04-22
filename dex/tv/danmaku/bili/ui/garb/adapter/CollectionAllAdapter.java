package tv.danmaku.bili.ui.garb.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.CardNumberColorUtilKt;
import com.bili.digital.common.CardNumberGradientColor;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bili.digital.common.data.SpaceBannerTitle;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.droid.TypeFaceHelper;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.ExposureLayoutInfoReceiver;
import com.bilibili.framework.exposure.core.collecter.ViewExposureLayoutInfoCollectorKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.IThumbnailSizeController;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbUrlTransformStrategyUtils;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ExposeFactory;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.holder.CollectionAllViewHolder;

/* compiled from: CollectionAllAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Ltv/danmaku/bili/ui/garb/adapter/CollectionAllAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "isMe", "", "<init>", "(Landroidx/lifecycle/Lifecycle;Z)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "()Z", "mData", "", "Lcom/bili/digital/common/data/SpaceBannerItem;", "exposureentries", "Lcom/bilibili/framework/exposure/core/ExposureEntry;", "mCollectedImageUrl", "", "getMCollectedImageUrl", "()Ljava/lang/String;", "setMCollectedImageUrl", "(Ljava/lang/String;)V", "updateData", "", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private List<? extends ExposureEntry> exposureentries;
    private final boolean isMe;
    private final Lifecycle lifecycle;
    private String mCollectedImageUrl;
    private List<SpaceBannerItem> mData;

    public CollectionAllAdapter(Lifecycle lifecycle, boolean isMe) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.lifecycle = lifecycle;
        this.isMe = isMe;
    }

    public /* synthetic */ CollectionAllAdapter(Lifecycle lifecycle, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycle, (i & 2) != 0 ? true : z);
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final String getMCollectedImageUrl() {
        return this.mCollectedImageUrl;
    }

    public final void setMCollectedImageUrl(String str) {
        this.mCollectedImageUrl = str;
    }

    public final void updateData(List<SpaceBannerItem> list) {
        ArrayList arrayList;
        this.mData = list;
        Iterable iterable = this.mData;
        if (iterable == null) {
            arrayList = null;
        } else {
            Iterable $this$map$iv = iterable;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final SpaceBannerItem it = (SpaceBannerItem) item$iv$iv;
                destination$iv$iv.add(ExposeFactory.INSTANCE.newExposureEntry(new Function0() { // from class: tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit updateData$lambda$0$0;
                        updateData$lambda$0$0 = CollectionAllAdapter.updateData$lambda$0$0(it, this);
                        return updateData$lambda$0$0;
                    }
                }));
            }
            arrayList = (List) destination$iv$iv;
        }
        this.exposureentries = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateData$lambda$0$0(SpaceBannerItem $it, CollectionAllAdapter this$0) {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("id", $it.getItemId());
        pairArr[1] = TuplesKt.to(AuthResultCbHelper.ARGS_STATE, this$0.isMe ? "1" : "0");
        Neurons.reportExposure$default(false, "sqzz.dressing-collection.card.0.show", MapsKt.mapOf(pairArr), (List) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CollectionAllViewHolder.Companion.create(parent);
    }

    public int getItemCount() {
        if (this.mData != null) {
            List<SpaceBannerItem> list = this.mData;
            Intrinsics.checkNotNull(list);
            return list.size();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0265  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        boolean z;
        String title;
        SpaceBannerExtra extra;
        SpaceBannerExtra extra2;
        SpaceBannerTitle title2;
        boolean z2;
        SpaceBannerTitle title3;
        SpaceBannerTitle title4;
        String titleIcon;
        SpaceBannerTitle title5;
        SpaceBannerTitle title6;
        String subTitle;
        ExposureLayoutInfoReceiver exposureLayoutInfoReceiver;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CollectionAllViewHolder) {
            List<SpaceBannerItem> list = this.mData;
            final SpaceBannerItem data = list != null ? list.get(position) : null;
            List<? extends ExposureEntry> list2 = this.exposureentries;
            if (list2 != null && (exposureLayoutInfoReceiver = (ExposureEntry) list2.get(position)) != null) {
                View root = ((CollectionAllViewHolder) holder).getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewExposureLayoutInfoCollectorKt.setExposureLayoutInfoReceiver(root, exposureLayoutInfoReceiver);
            }
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder builder = ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(data != null ? data.getCover() : null), R.drawable.collection_default_img, (ScaleType) null, 2, (Object) null).thumbnailUrlTransformStrategy(ThumbUrlTransformStrategyUtils.stylingStrategy$default("space-header-bg", (IThumbnailSizeController) null, 2, (Object) null));
            BiliImageView biliImageView = ((CollectionAllViewHolder) holder).getBinding().collectionAllCardImg;
            Intrinsics.checkNotNullExpressionValue(biliImageView, "collectionAllCardImg");
            builder.into(biliImageView);
            boolean z3 = true;
            if (data != null && (title6 = data.getTitle()) != null && (subTitle = title6.getSubTitle()) != null) {
                if (!(subTitle.length() == 0)) {
                    z = true;
                    if (!z) {
                        AppCompatTextView appCompatTextView = ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderNo;
                        String subTitle2 = (data == null || (title5 = data.getTitle()) == null) ? null : title5.getSubTitle();
                        Intrinsics.checkNotNull(subTitle2);
                        appCompatTextView.setText(subTitle2);
                        ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderNo.setTypeface(TypeFaceHelper.createFromAsset(((CollectionAllViewHolder) holder).getBinding().getRoot().getContext(), "digital_id_num.ttf"));
                        SpaceBannerTitle title7 = data.getTitle();
                        CardNumberGradientColor cardNumberGradientColor = title7 != null ? title7.getCardNumberGradientColor() : null;
                        if (cardNumberGradientColor != null) {
                            TextView textView = ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderNo;
                            Intrinsics.checkNotNullExpressionValue(textView, "collectionAllHeaderNo");
                            CardNumberColorUtilKt.setCardNumberGradientColor(textView, cardNumberGradientColor);
                        } else {
                            ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderNo.setTextColor(-1);
                        }
                        ((CollectionAllViewHolder) holder).getBinding().collectionAllCardNoContainer.setVisibility(0);
                        if (data != null && (title4 = data.getTitle()) != null && (titleIcon = title4.getTitleIcon()) != null) {
                            if (!(titleIcon.length() == 0)) {
                                z2 = true;
                                if (!z2) {
                                    ((CollectionAllViewHolder) holder).getBinding().collectionAllCardBottomIcon.setVisibility(0);
                                    BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
                                    Context context2 = ((CollectionAllViewHolder) holder).getBinding().getRoot().getContext();
                                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                    ImageRequestBuilder with = biliImageLoader2.with(context2);
                                    String titleIcon2 = (data == null || (title3 = data.getTitle()) == null) ? null : title3.getTitleIcon();
                                    Intrinsics.checkNotNull(titleIcon2);
                                    ImageRequestBuilder url = with.url(titleIcon2);
                                    BiliImageView biliImageView2 = ((CollectionAllViewHolder) holder).getBinding().collectionAllCardBottomIcon;
                                    Intrinsics.checkNotNullExpressionValue(biliImageView2, "collectionAllCardBottomIcon");
                                    url.into(biliImageView2);
                                } else {
                                    ((CollectionAllViewHolder) holder).getBinding().collectionAllCardBottomIcon.setVisibility(8);
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                        }
                    } else {
                        ((CollectionAllViewHolder) holder).getBinding().collectionAllCardNoContainer.setVisibility(8);
                    }
                    String title8 = (data != null || (title2 = data.getTitle()) == null || (title8 = title2.getTitle()) == null) ? "" : "";
                    if (!(data == null && (extra2 = data.getExtra()) != null && extra2.getCollectionCompleted())) {
                        if (title8.length() >= 7) {
                            String substring = title8.substring(0, 7);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            title = substring + "...";
                        }
                        title = title8;
                    } else {
                        if (title8.length() >= 11) {
                            String substring2 = title8.substring(0, 11);
                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                            title = substring2 + "...";
                        }
                        title = title8;
                    }
                    ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderName.setText(title);
                    BuildersKt.launch$default(LifecycleKt.getCoroutineScope(this.lifecycle), (CoroutineContext) null, (CoroutineStart) null, new CollectionAllAdapter$onBindViewHolder$2(data, holder, this, null), 3, (Object) null);
                    ((CollectionAllViewHolder) holder).getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CollectionAllAdapter.onBindViewHolder$lambda$1(data, holder, this, view);
                        }
                    });
                    if (data != null || (extra = data.getExtra()) == null || !extra.getCollectionCompleted()) {
                        z3 = false;
                    }
                    if (!z3) {
                        ((CollectionAllViewHolder) holder).getBinding().collectionAllCardCollectedFlag.setVisibility(0);
                        String it = this.mCollectedImageUrl;
                        if (it != null) {
                            BiliImageLoader biliImageLoader3 = BiliImageLoader.INSTANCE;
                            Context context3 = ((CollectionAllViewHolder) holder).getBinding().getRoot().getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            ImageRequestBuilder url2 = biliImageLoader3.with(context3).url(it);
                            BiliImageView biliImageView3 = ((CollectionAllViewHolder) holder).getBinding().collectionAllCardCollectedFlag;
                            Intrinsics.checkNotNullExpressionValue(biliImageView3, "collectionAllCardCollectedFlag");
                            url2.into(biliImageView3);
                            return;
                        }
                        return;
                    }
                    ((CollectionAllViewHolder) holder).getBinding().collectionAllCardCollectedFlag.setVisibility(8);
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (data != null) {
            }
            if (!(data == null && (extra2 = data.getExtra()) != null && extra2.getCollectionCompleted())) {
            }
            ((CollectionAllViewHolder) holder).getBinding().collectionAllHeaderName.setText(title);
            BuildersKt.launch$default(LifecycleKt.getCoroutineScope(this.lifecycle), (CoroutineContext) null, (CoroutineStart) null, new CollectionAllAdapter$onBindViewHolder$2(data, holder, this, null), 3, (Object) null);
            ((CollectionAllViewHolder) holder).getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.CollectionAllAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionAllAdapter.onBindViewHolder$lambda$1(data, holder, this, view);
                }
            });
            if (data != null) {
            }
            z3 = false;
            if (!z3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SpaceBannerItem $data, RecyclerView.ViewHolder $holder, CollectionAllAdapter this$0, View it) {
        SpaceBannerExtra extra;
        String it2;
        if ($data != null && (extra = $data.getExtra()) != null && (it2 = extra.getDetailJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_all");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, ((CollectionAllViewHolder) $holder).getBinding().getRoot().getContext());
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("btn", "0");
            pairArr[1] = TuplesKt.to("id", $data.getItemId());
            pairArr[2] = TuplesKt.to(AuthResultCbHelper.ARGS_STATE, this$0.isMe ? "1" : "0");
            Neurons.reportClick(false, "sqzz.dressing-collection.card.0.click", MapsKt.mapOf(pairArr));
        }
    }
}