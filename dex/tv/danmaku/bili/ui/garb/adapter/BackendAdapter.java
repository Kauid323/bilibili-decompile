package tv.danmaku.bili.ui.garb.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.CardNumberColorUtilKt;
import com.bili.digital.common.CardNumberGradientColor;
import com.bili.digital.common.data.CollectionBizType;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bili.digital.common.data.SpaceBannerTitle;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.TypeFaceHelper;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.IThumbnailSizeController;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbUrlTransformStrategyUtils;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.bean.bitmapTransform.NativeBlurBitmapTransform;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.IGenericProperties;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.holder.BackendViewHolder;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* compiled from: BackendAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bH\u0016J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ui/garb/adapter/BackendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContainerWidth", "", "mContainerHeight", "mRealCardSize", "getMRealCardSize", "()I", "setMRealCardSize", "(I)V", "mCollectedImageUrl", "", "getMCollectedImageUrl", "()Ljava/lang/String;", "setMCollectedImageUrl", "(Ljava/lang/String;)V", "cards", "", "Lcom/bili/digital/common/data/SpaceBannerItem;", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "updateContainerSize", "", "width", "height", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BackendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private List<SpaceBannerItem> cards;
    private final Context context;
    private String mCollectedImageUrl;
    private int mContainerHeight;
    private int mContainerWidth;
    private int mRealCardSize;

    public BackendAdapter() {
        this(null, 1, null);
    }

    public BackendAdapter(Context context) {
        this.context = context;
        this.cards = new ArrayList();
    }

    public /* synthetic */ BackendAdapter(Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context);
    }

    public final int getMRealCardSize() {
        return this.mRealCardSize;
    }

    public final void setMRealCardSize(int i) {
        this.mRealCardSize = i;
    }

    public final String getMCollectedImageUrl() {
        return this.mCollectedImageUrl;
    }

    public final void setMCollectedImageUrl(String str) {
        this.mCollectedImageUrl = str;
    }

    public final List<SpaceBannerItem> getCards() {
        return this.cards;
    }

    public final void setCards(List<SpaceBannerItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cards = list;
    }

    public final void updateContainerSize(int width, int height) {
        this.mContainerWidth = width;
        this.mContainerHeight = height;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return BackendViewHolder.Companion.create(parent);
    }

    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String it;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof BackendViewHolder) {
            final SpaceBannerItem card = this.cards.get(position);
            if (card.getBizType() == CollectionBizType.EMPTY) {
                ListExtentionsKt.invisible(((BackendViewHolder) holder).getBinding().nftCardContainer);
                return;
            }
            ListExtentionsKt.visible(((BackendViewHolder) holder).getBinding().nftCardContainer);
            boolean z = false;
            ((BackendViewHolder) holder).getBinding().nftCardImg.setVisibility(0);
            View view = ((BackendViewHolder) holder).getBinding().nftCardNoticeContainer;
            Intrinsics.checkNotNullExpressionValue(view, "nftCardNoticeContainer");
            View $this$isVisible$iv = view;
            SpaceBannerExtra extra = card.getExtra();
            boolean value$iv = extra != null && extra.getClickGuide();
            $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = ((BackendViewHolder) holder).getBinding().getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder thumbnailUrlTransformStrategy = ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(card.getCover()), R.drawable.collection_default_img, (ScaleType) null, 2, (Object) null).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.garb.adapter.BackendAdapter$onBindViewHolder$1
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageSet(ImageInfo imageInfo) {
                    Context context2;
                    Context context3;
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    if (imageInfo == null) {
                        return;
                    }
                    int imgWidth = imageInfo.getWidth();
                    int imgHeight = imageInfo.getHeight();
                    if (imgWidth >= imgHeight) {
                        Context ctx = holder.itemView.getContext();
                        ViewGroup.LayoutParams it2 = ((BackendViewHolder) holder).getBinding().nftCardImg.getLayoutParams();
                        if (it2 != null) {
                            RecyclerView.ViewHolder viewHolder = holder;
                            int defaultWidth = (int) DpUtils.dp2px(ctx, 171.0f);
                            int expectedHeight = (int) (((defaultWidth * imgHeight) * 1.0f) / imgWidth);
                            it2.height = expectedHeight;
                            ((BackendViewHolder) viewHolder).getBinding().nftCardImg.setLayoutParams(it2);
                        }
                        ((BackendViewHolder) holder).getBinding().nftCardImg.getGenericProperties().setRoundingParams(RoundingParams.Companion.fromCornersRadius(0.0f));
                        ((BackendViewHolder) holder).getBinding().nftCardBg.setVisibility(0);
                        context3 = this.context;
                        if (context3 != null) {
                            RecyclerView.ViewHolder viewHolder2 = holder;
                            SpaceBannerItem spaceBannerItem = card;
                            BiliImageView biliImageView = ((BackendViewHolder) viewHolder2).getBinding().nftCardBg;
                            Intrinsics.checkNotNullExpressionValue(biliImageView, "nftCardBg");
                            ImageExtentionKt.displayImage$default(biliImageView, spaceBannerItem.getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, new NativeBlurBitmapTransform(3, 20, (BitmapTransformation) null, 4, (DefaultConstructorMarker) null), false, 766, (Object) null);
                        }
                        ((BackendViewHolder) holder).getBinding().nftCardImg.setBackground((Drawable) null);
                        return;
                    }
                    Context ctx2 = holder.itemView.getContext();
                    ((BackendViewHolder) holder).getBinding().nftCardBg.setVisibility(4);
                    int defaultHeight = (int) DpUtils.dp2px(ctx2, 256.0f);
                    int defaultWidth2 = (int) DpUtils.dp2px(ctx2, 171.0f);
                    ViewGroup.LayoutParams it3 = ((BackendViewHolder) holder).getBinding().nftCardImg.getLayoutParams();
                    if (it3 != null) {
                        RecyclerView.ViewHolder viewHolder3 = holder;
                        it3.height = defaultHeight;
                        it3.width = defaultWidth2;
                        ((BackendViewHolder) viewHolder3).getBinding().nftCardImg.setLayoutParams(it3);
                    }
                    IGenericProperties genericProperties = ((BackendViewHolder) holder).getBinding().nftCardImg.getGenericProperties();
                    RoundingParams.Companion companion = RoundingParams.Companion;
                    context2 = this.context;
                    genericProperties.setRoundingParams(companion.fromCornersRadius(DpUtils.dp2px(context2, 10.0f)));
                    ((BackendViewHolder) holder).getBinding().nftCardImg.setBackgroundResource(R.drawable.app_collection_img_bg);
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                }
            }).thumbnailUrlTransformStrategy(ThumbUrlTransformStrategyUtils.stylingStrategy$default("space-header-bg", (IThumbnailSizeController) null, 2, (Object) null));
            BiliImageView biliImageView = ((BackendViewHolder) holder).getBinding().nftCardImg;
            Intrinsics.checkNotNullExpressionValue(biliImageView, "nftCardImg");
            thumbnailUrlTransformStrategy.into(biliImageView);
            Context it2 = this.context;
            if (it2 != null) {
                BiliImageView biliImageView2 = ((BackendViewHolder) holder).getBinding().nftCardMaskBackend;
                Intrinsics.checkNotNullExpressionValue(biliImageView2, "nftCardMaskBackend");
                String packageName = it2.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                ImageExtentionKt.displayImage$default(biliImageView2, BiliImageLoaderHelper.resourceToUri(packageName, R.drawable.bili_app_collection_backend_mask_white), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, new NativeBlurBitmapTransform(3, 100, (BitmapTransformation) null, 4, (DefaultConstructorMarker) null), false, 766, (Object) null);
            }
            AppCompatTextView appCompatTextView = ((BackendViewHolder) holder).getBinding().nftCardName;
            SpaceBannerTitle title = card.getTitle();
            appCompatTextView.setText(title != null ? title.getTitle() : null);
            AppCompatTextView appCompatTextView2 = ((BackendViewHolder) holder).getBinding().nftCardNo;
            SpaceBannerTitle title2 = card.getTitle();
            appCompatTextView2.setText(title2 != null ? title2.getSubTitle() : null);
            SpaceBannerTitle title3 = card.getTitle();
            String subTitle = title3 != null ? title3.getSubTitle() : null;
            if (!(subTitle == null || subTitle.length() == 0)) {
                AppCompatTextView appCompatTextView3 = ((BackendViewHolder) holder).getBinding().nftCardNo;
                SpaceBannerTitle title4 = card.getTitle();
                String subTitle2 = title4 != null ? title4.getSubTitle() : null;
                Intrinsics.checkNotNull(subTitle2);
                appCompatTextView3.setText(subTitle2);
                Typeface typeface = TypeFaceHelper.createFromAsset(((BackendViewHolder) holder).getBinding().getRoot().getContext(), "digital_id_num.ttf");
                ((BackendViewHolder) holder).getBinding().nftCardNo.setTypeface(typeface);
                SpaceBannerTitle title5 = card.getTitle();
                CardNumberGradientColor cardNumberGradientColor = title5 != null ? title5.getCardNumberGradientColor() : null;
                if (cardNumberGradientColor != null) {
                    TextView textView = ((BackendViewHolder) holder).getBinding().nftCardNo;
                    Intrinsics.checkNotNullExpressionValue(textView, "nftCardNo");
                    CardNumberColorUtilKt.setCardNumberGradientColor(textView, cardNumberGradientColor);
                } else {
                    ((BackendViewHolder) holder).getBinding().nftCardNo.setTextColor(-1);
                }
                ((BackendViewHolder) holder).getBinding().nftCardNoContainer.setVisibility(0);
                SpaceBannerTitle title6 = card.getTitle();
                String titleIcon = title6 != null ? title6.getTitleIcon() : null;
                if (!(titleIcon == null || titleIcon.length() == 0)) {
                    ((BackendViewHolder) holder).getBinding().nftCardBottomIcon.setVisibility(0);
                    BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
                    Context context2 = ((BackendViewHolder) holder).getBinding().getRoot().getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    ImageRequestBuilder with = biliImageLoader2.with(context2);
                    SpaceBannerTitle title7 = card.getTitle();
                    String titleIcon2 = title7 != null ? title7.getTitleIcon() : null;
                    Intrinsics.checkNotNull(titleIcon2);
                    ImageRequestBuilder url = with.url(titleIcon2);
                    BiliImageView biliImageView3 = ((BackendViewHolder) holder).getBinding().nftCardBottomIcon;
                    Intrinsics.checkNotNullExpressionValue(biliImageView3, "nftCardBottomIcon");
                    url.into(biliImageView3);
                } else {
                    ((BackendViewHolder) holder).getBinding().nftCardBottomIcon.setVisibility(8);
                }
            } else {
                ((BackendViewHolder) holder).getBinding().nftCardNoContainer.setVisibility(8);
            }
            AppCompatTextView appCompatTextView4 = ((BackendViewHolder) holder).getBinding().nftCardName;
            SpaceBannerTitle title8 = card.getTitle();
            appCompatTextView4.setText(title8 != null ? title8.getTitle() : null);
            SpaceBannerExtra extra2 = card.getExtra();
            if (extra2 != null && extra2.getCollectionCompleted()) {
                z = true;
            }
            if (z && (it = this.mCollectedImageUrl) != null) {
                BiliImageLoader biliImageLoader3 = BiliImageLoader.INSTANCE;
                Context context3 = ((BackendViewHolder) holder).getBinding().getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                ImageRequestBuilder url2 = biliImageLoader3.with(context3).url(it);
                BiliImageView biliImageView4 = ((BackendViewHolder) holder).getBinding().nftCardCollectedFlag;
                Intrinsics.checkNotNullExpressionValue(biliImageView4, "nftCardCollectedFlag");
                url2.into(biliImageView4);
            }
        }
    }

    public int getItemCount() {
        return this.cards.size();
    }

    public int getItemViewType(int position) {
        return 1;
    }
}