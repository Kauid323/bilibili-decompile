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
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.CardNumberColorUtilKt;
import com.bili.digital.common.CardNumberGradientColor;
import com.bili.digital.common.data.CardMetaInfo;
import com.bili.digital.common.data.CollectionBizType;
import com.bili.digital.common.data.CollectionItemType;
import com.bili.digital.common.data.SpaceBannerExtra;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bili.digital.common.data.SpaceBannerItemCardExtra;
import com.bili.digital.common.data.SpaceBannerItemContent;
import com.bili.digital.common.data.SpaceBannerItemForUI;
import com.bili.digital.common.data.SpaceBannerItemMusicAlbum;
import com.bili.digital.common.data.SpaceBannerTitle;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.bililive.uam.view.UAMView;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.R;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;
import tv.danmaku.bili.ui.garb.SmeltVideoController;
import tv.danmaku.bili.ui.garb.api.CollectionReporterHelper;
import tv.danmaku.bili.ui.garb.holder.FrontViewHolder;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* compiled from: FrontAdapter.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BR\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\rH\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00064"}, d2 = {"Ltv/danmaku/bili/ui/garb/adapter/FrontAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "isMe", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onVideoItemPlayCompleted", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "index", "", "<init>", "(Landroid/content/Context;Lcom/bili/digital/common/player/VideoParams;Ljava/lang/Boolean;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Boolean;", "mCollectedImageUrl", "", "getMCollectedImageUrl", "()Ljava/lang/String;", "setMCollectedImageUrl", "(Ljava/lang/String;)V", "mContainerWidth", "mContainerHeight", "mCards", "", "Lcom/bili/digital/common/data/SpaceBannerItemForUI;", "smeltVideoController", "Ltv/danmaku/bili/ui/garb/SmeltVideoController;", "value", "cards", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "updateContainerSize", "width", "height", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FrontAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final Boolean isMe;
    private final Lifecycle lifecycle;
    private List<SpaceBannerItemForUI> mCards;
    private String mCollectedImageUrl;
    private int mContainerHeight;
    private int mContainerWidth;
    private final Function1<Integer, Unit> onVideoItemPlayCompleted;
    private final SmeltVideoController smeltVideoController;
    private final VideoParams videoParams;

    /* compiled from: FrontAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CollectionBizType.values().length];
            try {
                iArr[CollectionBizType.GARB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CollectionBizType.DIGITAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CollectionBizType.NFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CollectionItemType.values().length];
            try {
                iArr2[CollectionItemType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[CollectionItemType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[CollectionItemType.MUSIC_NFT.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrontAdapter(Context context, VideoParams videoParams, Boolean isMe, Lifecycle lifecycle, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(function1, "onVideoItemPlayCompleted");
        this.context = context;
        this.videoParams = videoParams;
        this.isMe = isMe;
        this.lifecycle = lifecycle;
        this.onVideoItemPlayCompleted = function1;
        this.mCards = new ArrayList();
        this.smeltVideoController = new SmeltVideoController();
        this.lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter.1
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onStop(this, lifecycleOwner);
            }

            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
                FrontAdapter.this.smeltVideoController.release();
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ FrontAdapter(Context context, VideoParams videoParams, Boolean bool, Lifecycle lifecycle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, videoParams, r4, lifecycle, function1);
        Context context2;
        Boolean bool2;
        if ((i & 1) == 0) {
            context2 = context;
        } else {
            context2 = null;
        }
        if ((i & 4) == 0) {
            bool2 = bool;
        } else {
            bool2 = null;
        }
    }

    public final String getMCollectedImageUrl() {
        return this.mCollectedImageUrl;
    }

    public final void setMCollectedImageUrl(String str) {
        this.mCollectedImageUrl = str;
    }

    public final List<SpaceBannerItemForUI> getCards() {
        return this.mCards;
    }

    public final void setCards(List<SpaceBannerItemForUI> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.mCards = list;
    }

    public final void updateContainerSize(int width, int height) {
        this.mContainerWidth = width;
        this.mContainerHeight = height;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return FrontViewHolder.Companion.create(parent, this.videoParams, this.smeltVideoController);
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x04a1, code lost:
        if (((r6 == null || (r6 = r6.getAnimation()) == null || r6.isSilence()) ? false : true) == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04c1, code lost:
        if ((r6 != null ? r6.getItemType() : null) == com.bili.digital.common.data.CollectionItemType.MUSIC_NFT) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04c3, code lost:
        ((tv.danmaku.bili.ui.garb.holder.FrontViewHolder) r32).getBinding().nftHeaderVideoSound.setVisibility(0);
        ((tv.danmaku.bili.ui.garb.holder.FrontViewHolder) r32).getBinding().nftHeaderVideoSound.setOnClickListener(new tv.danmaku.bili.ui.garb.adapter.FrontAdapter$$ExternalSyntheticLambda2(r32));
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0293  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Context it;
        SpaceBannerItem banner;
        boolean z;
        SpaceBannerItem banner2;
        SpaceBannerItem banner3;
        String str;
        SpaceBannerItemContent item;
        CollectionItemType itemType;
        SpaceBannerItemMusicAlbum musicAlbum;
        String it2;
        SpaceBannerItem banner4;
        SpaceBannerExtra extra;
        SpaceBannerExtra extra2;
        SpaceBannerTitle title;
        String title2;
        boolean z2;
        SpaceBannerTitle title3;
        SpaceBannerTitle title4;
        String titleIcon;
        SpaceBannerTitle title5;
        SpaceBannerTitle title6;
        String subTitle;
        SpaceBannerItemCardExtra cardExtra;
        CardMetaInfo cardMetaInfo;
        SpaceBannerItemCardExtra cardExtra2;
        CardMetaInfo cardMetaInfo2;
        SpaceBannerItemCardExtra cardExtra3;
        CardMetaInfo cardMetaInfo3;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof FrontViewHolder) {
            final SpaceBannerItemForUI card = this.mCards.get(position);
            ((FrontViewHolder) holder).bindData(card);
            if (BuildConfig.DEBUG) {
                ((FrontViewHolder) holder).getBinding().debugText.setVisibility(0);
                TextView textView = ((FrontViewHolder) holder).getBinding().debugText;
                switch (WhenMappings.$EnumSwitchMapping$0[card.getBanner().getBizType().ordinal()]) {
                    case 1:
                        str2 = "装扮";
                        break;
                    case 2:
                        str2 = "收藏集";
                        break;
                    case 3:
                        str2 = "藏品";
                        break;
                    default:
                        str2 = "bizType=" + card.getBanner().getBizType();
                        break;
                }
                textView.setText(str2);
            }
            ((FrontViewHolder) holder).setOnVideoComplete(new Function0() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onBindViewHolder$lambda$0;
                    onBindViewHolder$lambda$0 = FrontAdapter.onBindViewHolder$lambda$0(FrontAdapter.this, position);
                    return onBindViewHolder$lambda$0;
                }
            });
            ((FrontViewHolder) holder).getBinding().nftCardImg.setVisibility(0);
            SpaceBannerItemContent item2 = card.getBanner().getItem();
            boolean hasSmelted = (item2 == null || (cardExtra3 = item2.getCardExtra()) == null || (cardMetaInfo3 = cardExtra3.getCardMetaInfo()) == null) ? false : cardMetaInfo3.getHasSmelted();
            SpaceBannerItemContent item3 = card.getBanner().getItem();
            String str3 = "";
            String badgeUrl = (item3 == null || (cardExtra2 = item3.getCardExtra()) == null || (cardMetaInfo2 = cardExtra2.getCardMetaInfo()) == null || (badgeUrl = cardMetaInfo2.getSmeltTagUrl()) == null) ? "" : "";
            SpaceBannerItemContent item4 = card.getBanner().getItem();
            String smeltDynamicUrl = (item4 == null || (cardExtra = item4.getCardExtra()) == null || (cardMetaInfo = cardExtra.getCardMetaInfo()) == null || (smeltDynamicUrl = cardMetaInfo.getSmeltDynamicUrl()) == null) ? "" : "";
            UAMView uamVideoView = ((FrontViewHolder) holder).getBinding().nftCardSmeltVideo;
            Intrinsics.checkNotNullExpressionValue(uamVideoView, "nftCardSmeltVideo");
            final Context ctx = holder.itemView.getContext();
            if (!StringsKt.isBlank(badgeUrl)) {
                ((FrontViewHolder) holder).getBinding().nftCardBadge.setVisibility(0);
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Intrinsics.checkNotNull(ctx);
                ImageRequestBuilder useOrigin = biliImageLoader.with(ctx).url(badgeUrl).useOrigin();
                BiliImageView biliImageView = ((FrontViewHolder) holder).getBinding().nftCardBadge;
                Intrinsics.checkNotNullExpressionValue(biliImageView, "nftCardBadge");
                useOrigin.into(biliImageView);
            } else {
                ((FrontViewHolder) holder).getBinding().nftCardBadge.setVisibility(8);
            }
            BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
            Context context = ((FrontViewHolder) holder).getBinding().getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder with = biliImageLoader2.with(context);
            SpaceBannerItem banner5 = card.getBanner();
            ImageRequestBuilder thumbnailUrlTransformStrategy = ImageRequestBuilder.placeholderImageResId$default(with.url(banner5 != null ? banner5.getCover() : null), R.drawable.collection_default_img, (ScaleType) null, 2, (Object) null).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter$onBindViewHolder$2
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
                    Context context4;
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    if (imageInfo == null) {
                        return;
                    }
                    int imgWidth = imageInfo.getWidth();
                    int imgHeight = imageInfo.getHeight();
                    if (imgWidth >= imgHeight) {
                        int expectedHeight = 0;
                        ViewGroup.LayoutParams it3 = ((FrontViewHolder) holder).getBinding().nftCardImg.getLayoutParams();
                        if (it3 != null) {
                            Context context5 = ctx;
                            RecyclerView.ViewHolder viewHolder = holder;
                            expectedHeight = (int) (((((int) DpUtils.dp2px(context5, 180.0f)) * imgHeight) * 1.0f) / imgWidth);
                            it3.height = expectedHeight;
                            ((FrontViewHolder) viewHolder).getBinding().nftCardImg.setLayoutParams(it3);
                        }
                        ViewGroup.LayoutParams layoutParams = ((FrontViewHolder) holder).getBinding().nftCardGyro.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = expectedHeight;
                        }
                        ViewGroup.LayoutParams layoutParams2 = ((FrontViewHolder) holder).getBinding().nftCardVideo.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = expectedHeight;
                        }
                        ((FrontViewHolder) holder).getBinding().nftCardVideo.setRadius(0.0f);
                        ((FrontViewHolder) holder).getBinding().nftCardImg.getGenericProperties().setRoundingParams(RoundingParams.Companion.fromCornersRadius(0.0f));
                        ((FrontViewHolder) holder).getBinding().nftCardBg.setVisibility(0);
                        context4 = this.context;
                        if (context4 != null) {
                            RecyclerView.ViewHolder viewHolder2 = holder;
                            SpaceBannerItemForUI spaceBannerItemForUI = card;
                            BiliImageView biliImageView2 = ((FrontViewHolder) viewHolder2).getBinding().nftCardBg;
                            Intrinsics.checkNotNullExpressionValue(biliImageView2, "nftCardBg");
                            ImageExtentionKt.displayImage$default(biliImageView2, spaceBannerItemForUI.getBanner().getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, new NativeBlurBitmapTransform(3, 20, (BitmapTransformation) null, 4, (DefaultConstructorMarker) null), false, 766, (Object) null);
                        }
                        ((FrontViewHolder) holder).getBinding().nftCardImg.setBackground((Drawable) null);
                        ((FrontViewHolder) holder).getBinding().nftCardGyro.setBackground((Drawable) null);
                        ((FrontViewHolder) holder).getBinding().nftCardVideo.setBackground(null);
                        return;
                    }
                    ((FrontViewHolder) holder).getBinding().nftCardBg.setVisibility(4);
                    int defaultHeight = (int) DpUtils.dp2px(ctx, 270.0f);
                    int defaultWidth = (int) DpUtils.dp2px(ctx, 180.0f);
                    ViewGroup.LayoutParams it4 = ((FrontViewHolder) holder).getBinding().nftCardImg.getLayoutParams();
                    if (it4 != null) {
                        RecyclerView.ViewHolder viewHolder3 = holder;
                        it4.height = defaultHeight;
                        it4.width = defaultWidth;
                        ((FrontViewHolder) viewHolder3).getBinding().nftCardImg.setLayoutParams(it4);
                    }
                    ViewGroup.LayoutParams layoutParams3 = ((FrontViewHolder) holder).getBinding().nftCardGyro.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = defaultHeight;
                    }
                    ViewGroup.LayoutParams layoutParams4 = ((FrontViewHolder) holder).getBinding().nftCardGyro.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.width = defaultWidth;
                    }
                    ViewGroup.LayoutParams layoutParams5 = ((FrontViewHolder) holder).getBinding().nftCardVideo.getLayoutParams();
                    if (layoutParams5 != null) {
                        layoutParams5.height = defaultHeight;
                    }
                    ViewGroup.LayoutParams layoutParams6 = ((FrontViewHolder) holder).getBinding().nftCardVideo.getLayoutParams();
                    if (layoutParams6 != null) {
                        layoutParams6.width = defaultWidth;
                    }
                    NftCardVideoRoundFrameLayout nftCardVideoRoundFrameLayout = ((FrontViewHolder) holder).getBinding().nftCardVideo;
                    context2 = this.context;
                    nftCardVideoRoundFrameLayout.setRadius(DpUtils.dp2px(context2, 10.0f));
                    IGenericProperties genericProperties = ((FrontViewHolder) holder).getBinding().nftCardImg.getGenericProperties();
                    RoundingParams.Companion companion = RoundingParams.Companion;
                    context3 = this.context;
                    genericProperties.setRoundingParams(companion.fromCornersRadius(DpUtils.dp2px(context3, 10.0f)));
                    ((FrontViewHolder) holder).getBinding().nftCardImg.setBackgroundResource(R.drawable.app_collection_img_bg);
                    ((FrontViewHolder) holder).getBinding().nftCardGyro.setBackgroundResource(R.drawable.app_collection_img_bg);
                    ((FrontViewHolder) holder).getBinding().nftCardVideo.setBackgroundResource(R.drawable.app_collection_img_bg);
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                }
            }).thumbnailUrlTransformStrategy(ThumbUrlTransformStrategyUtils.stylingStrategy$default("space-header-bg", (IThumbnailSizeController) null, 2, (Object) null));
            BiliImageView biliImageView2 = ((FrontViewHolder) holder).getBinding().nftCardImg;
            Intrinsics.checkNotNullExpressionValue(biliImageView2, "nftCardImg");
            thumbnailUrlTransformStrategy.into(biliImageView2);
            if (hasSmelted) {
                View view = ((FrontViewHolder) holder).getBinding().nftCardSmeltImg;
                Intrinsics.checkNotNullExpressionValue(view, "nftCardSmeltImg");
                View $this$isVisible$iv = view;
                $this$isVisible$iv.setVisibility(0);
                BiliImageLoader biliImageLoader3 = BiliImageLoader.INSTANCE;
                Intrinsics.checkNotNull(ctx);
                ImageRequestBuilder with2 = biliImageLoader3.with(ctx);
                SpaceBannerItem banner6 = card.getBanner();
                ImageRequestBuilder url = with2.url(banner6 != null ? banner6.getCover() : null);
                BiliImageView biliImageView3 = ((FrontViewHolder) holder).getBinding().nftCardSmeltImg;
                Intrinsics.checkNotNullExpressionValue(biliImageView3, "nftCardSmeltImg");
                url.into(biliImageView3);
            } else {
                View view2 = ((FrontViewHolder) holder).getBinding().nftCardSmeltImg;
                Intrinsics.checkNotNullExpressionValue(view2, "nftCardSmeltImg");
                View $this$isVisible$iv2 = view2;
                $this$isVisible$iv2.setVisibility(8);
            }
            if (hasSmelted) {
                if (smeltDynamicUrl.length() > 0) {
                    ((FrontViewHolder) holder).playUamVideo(card.getUniqueId(), smeltDynamicUrl, this.smeltVideoController);
                    it = this.context;
                    if (it != null) {
                        BiliImageView biliImageView4 = ((FrontViewHolder) holder).getBinding().nftCardMaskBackend;
                        Intrinsics.checkNotNullExpressionValue(biliImageView4, "nftCardMaskBackend");
                        String packageName = it.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                        ImageExtentionKt.displayImage$default(biliImageView4, BiliImageLoaderHelper.resourceToUri(packageName, R.drawable.bili_app_collection_backend_mask_white), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, new NativeBlurBitmapTransform(3, 80, (BitmapTransformation) null, 4, (DefaultConstructorMarker) null), false, 766, (Object) null);
                    }
                    banner = card.getBanner();
                    if (banner != null && (title6 = banner.getTitle()) != null && (subTitle = title6.getSubTitle()) != null) {
                        if (!(subTitle.length() != 0)) {
                            z = true;
                            if (z) {
                                Typeface typeface = TypeFaceHelper.createFromAsset(((FrontViewHolder) holder).getBinding().getRoot().getContext(), "digital_id_num.ttf");
                                ((FrontViewHolder) holder).getBinding().nftCardNo.setTypeface(typeface);
                                AppCompatTextView appCompatTextView = ((FrontViewHolder) holder).getBinding().nftCardNo;
                                SpaceBannerItem banner7 = card.getBanner();
                                String subTitle2 = (banner7 == null || (title5 = banner7.getTitle()) == null) ? null : title5.getSubTitle();
                                Intrinsics.checkNotNull(subTitle2);
                                appCompatTextView.setText(subTitle2);
                                SpaceBannerTitle title7 = card.getBanner().getTitle();
                                CardNumberGradientColor cardNumberGradientColor = title7 != null ? title7.getCardNumberGradientColor() : null;
                                if (cardNumberGradientColor != null) {
                                    TextView textView2 = ((FrontViewHolder) holder).getBinding().nftCardNo;
                                    Intrinsics.checkNotNullExpressionValue(textView2, "nftCardNo");
                                    CardNumberColorUtilKt.setCardNumberGradientColor(textView2, cardNumberGradientColor);
                                } else {
                                    ((FrontViewHolder) holder).getBinding().nftCardNo.setTextColor(-1);
                                }
                                ((FrontViewHolder) holder).getBinding().nftCardNoContainer.setVisibility(0);
                                SpaceBannerItem banner8 = card.getBanner();
                                if (banner8 != null && (title4 = banner8.getTitle()) != null && (titleIcon = title4.getTitleIcon()) != null) {
                                    if (!(titleIcon.length() == 0)) {
                                        z2 = true;
                                        if (!z2) {
                                            ((FrontViewHolder) holder).getBinding().nftCardBottomIcon.setVisibility(0);
                                            BiliImageLoader biliImageLoader4 = BiliImageLoader.INSTANCE;
                                            Context context2 = ((FrontViewHolder) holder).getBinding().getRoot().getContext();
                                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                            ImageRequestBuilder with3 = biliImageLoader4.with(context2);
                                            SpaceBannerItem banner9 = card.getBanner();
                                            String titleIcon2 = (banner9 == null || (title3 = banner9.getTitle()) == null) ? null : title3.getTitleIcon();
                                            Intrinsics.checkNotNull(titleIcon2);
                                            ImageRequestBuilder url2 = with3.url(titleIcon2);
                                            BiliImageView biliImageView5 = ((FrontViewHolder) holder).getBinding().nftCardBottomIcon;
                                            Intrinsics.checkNotNullExpressionValue(biliImageView5, "nftCardBottomIcon");
                                            url2.into(biliImageView5);
                                        } else {
                                            ((FrontViewHolder) holder).getBinding().nftCardBottomIcon.setVisibility(8);
                                        }
                                    }
                                }
                                z2 = false;
                                if (!z2) {
                                }
                            } else {
                                ((FrontViewHolder) holder).getBinding().nftCardNoContainer.setVisibility(8);
                            }
                            banner2 = card.getBanner();
                            if (banner2 != null && (title = banner2.getTitle()) != null && (title2 = title.getTitle()) != null) {
                                str3 = title2;
                            }
                            String title8 = str3;
                            banner3 = card.getBanner();
                            if (banner3 == null && (extra2 = banner3.getExtra()) != null && extra2.getCollectionCompleted()) {
                                if (title8.length() >= 7) {
                                    String substring = title8.substring(0, 7);
                                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                    str = substring + "...";
                                }
                                str = title8;
                            } else {
                                if (title8.length() >= 11) {
                                    String substring2 = title8.substring(0, 11);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    str = substring2 + "...";
                                }
                                str = title8;
                            }
                            String title9 = str;
                            View view3 = ((FrontViewHolder) holder).getBinding().nftCardNoticeContainer;
                            Intrinsics.checkNotNullExpressionValue(view3, "nftCardNoticeContainer");
                            View $this$isVisible$iv3 = view3;
                            SpaceBannerExtra extra3 = card.getBanner().getExtra();
                            boolean value$iv = extra3 == null && extra3.getClickGuide();
                            $this$isVisible$iv3.setVisibility(value$iv ? 0 : 8);
                            ((FrontViewHolder) holder).getBinding().nftCardName.setText(title9);
                            ((FrontViewHolder) holder).getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter$$ExternalSyntheticLambda1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view4) {
                                    FrontAdapter.onBindViewHolder$lambda$2(card, holder, this, position, view4);
                                }
                            });
                            item = card.getBanner().getItem();
                            if ((item != null ? item.getItemType() : null) == CollectionItemType.VIDEO) {
                                SpaceBannerItemContent item5 = card.getBanner().getItem();
                            }
                            if (card.getBanner().getBizType() == CollectionBizType.NFT) {
                                SpaceBannerItemContent item6 = card.getBanner().getItem();
                            }
                            ((FrontViewHolder) holder).getBinding().nftHeaderVideoSound.setVisibility(8);
                            SpaceBannerItemContent item7 = card.getBanner().getItem();
                            itemType = item7 != null ? item7.getItemType() : null;
                            switch (itemType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[itemType.ordinal()]) {
                                case 1:
                                    ((FrontViewHolder) holder).hideVideoView();
                                    ((FrontViewHolder) holder).getBinding().musicNftCoverGroup.setVisibility(8);
                                    break;
                                case 2:
                                    ((FrontViewHolder) holder).getBinding().nftCardGyro.setVisibility(8);
                                    ((FrontViewHolder) holder).getBinding().musicNftCoverGroup.setVisibility(8);
                                    ((FrontViewHolder) holder).checkToResetPlayerCard(card);
                                    break;
                                case 3:
                                    ((FrontViewHolder) holder).getBinding().nftCardGyro.setVisibility(8);
                                    ((FrontViewHolder) holder).getBinding().nftCardImg.setVisibility(8);
                                    SpaceBannerItemContent item8 = card.getBanner().getItem();
                                    if (item8 != null && (musicAlbum = item8.getMusicAlbum()) != null && (it2 = musicAlbum.getAlbumCover()) != null) {
                                        BiliImageView biliImageView6 = ((FrontViewHolder) holder).getBinding().nftCardBg;
                                        Intrinsics.checkNotNullExpressionValue(biliImageView6, "nftCardBg");
                                        ImageExtentionKt.displayImage$default(biliImageView6, it2, (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, new NativeBlurBitmapTransform(3, 20, (BitmapTransformation) null, 4, (DefaultConstructorMarker) null), false, 766, (Object) null);
                                    }
                                    ((FrontViewHolder) holder).checkToResetPlayerCard(card);
                                    break;
                                default:
                                    ((FrontViewHolder) holder).getBinding().nftCardGyro.setVisibility(8);
                                    break;
                            }
                            banner4 = card.getBanner();
                            if (banner4 == null && (extra = banner4.getExtra()) != null && extra.getCollectionCompleted()) {
                                ((FrontViewHolder) holder).getBinding().nftCardCollectedFlag.setVisibility(0);
                                String it3 = this.mCollectedImageUrl;
                                if (it3 != null) {
                                    BiliImageLoader biliImageLoader5 = BiliImageLoader.INSTANCE;
                                    Context context3 = ((FrontViewHolder) holder).getBinding().getRoot().getContext();
                                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                                    ImageRequestBuilder url3 = biliImageLoader5.with(context3).url(it3);
                                    BiliImageView biliImageView7 = ((FrontViewHolder) holder).getBinding().nftCardCollectedFlag;
                                    Intrinsics.checkNotNullExpressionValue(biliImageView7, "nftCardCollectedFlag");
                                    url3.into(biliImageView7);
                                    return;
                                }
                                return;
                            }
                            ((FrontViewHolder) holder).getBinding().nftCardCollectedFlag.setVisibility(8);
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    banner2 = card.getBanner();
                    if (banner2 != null) {
                        str3 = title2;
                    }
                    String title82 = str3;
                    banner3 = card.getBanner();
                    if (banner3 == null && (extra2 = banner3.getExtra()) != null && extra2.getCollectionCompleted()) {
                    }
                    String title92 = str;
                    View view32 = ((FrontViewHolder) holder).getBinding().nftCardNoticeContainer;
                    Intrinsics.checkNotNullExpressionValue(view32, "nftCardNoticeContainer");
                    View $this$isVisible$iv32 = view32;
                    SpaceBannerExtra extra32 = card.getBanner().getExtra();
                    if (extra32 == null) {
                    }
                    $this$isVisible$iv32.setVisibility(value$iv ? 0 : 8);
                    ((FrontViewHolder) holder).getBinding().nftCardName.setText(title92);
                    ((FrontViewHolder) holder).getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            FrontAdapter.onBindViewHolder$lambda$2(card, holder, this, position, view4);
                        }
                    });
                    item = card.getBanner().getItem();
                    if ((item != null ? item.getItemType() : null) == CollectionItemType.VIDEO) {
                    }
                    if (card.getBanner().getBizType() == CollectionBizType.NFT) {
                    }
                    ((FrontViewHolder) holder).getBinding().nftHeaderVideoSound.setVisibility(8);
                    SpaceBannerItemContent item72 = card.getBanner().getItem();
                    if (item72 != null) {
                    }
                    switch (itemType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[itemType.ordinal()]) {
                    }
                    banner4 = card.getBanner();
                    if (banner4 == null && (extra = banner4.getExtra()) != null && extra.getCollectionCompleted()) {
                    }
                }
            }
            uamVideoView.setVisibility(4);
            it = this.context;
            if (it != null) {
            }
            banner = card.getBanner();
            if (banner != null) {
                if (!(subTitle.length() != 0)) {
                }
            }
            z = false;
            if (z) {
            }
            banner2 = card.getBanner();
            if (banner2 != null) {
            }
            String title822 = str3;
            banner3 = card.getBanner();
            if (banner3 == null && (extra2 = banner3.getExtra()) != null && extra2.getCollectionCompleted()) {
            }
            String title922 = str;
            View view322 = ((FrontViewHolder) holder).getBinding().nftCardNoticeContainer;
            Intrinsics.checkNotNullExpressionValue(view322, "nftCardNoticeContainer");
            View $this$isVisible$iv322 = view322;
            SpaceBannerExtra extra322 = card.getBanner().getExtra();
            if (extra322 == null) {
            }
            $this$isVisible$iv322.setVisibility(value$iv ? 0 : 8);
            ((FrontViewHolder) holder).getBinding().nftCardName.setText(title922);
            ((FrontViewHolder) holder).getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.adapter.FrontAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    FrontAdapter.onBindViewHolder$lambda$2(card, holder, this, position, view4);
                }
            });
            item = card.getBanner().getItem();
            if ((item != null ? item.getItemType() : null) == CollectionItemType.VIDEO) {
            }
            if (card.getBanner().getBizType() == CollectionBizType.NFT) {
            }
            ((FrontViewHolder) holder).getBinding().nftHeaderVideoSound.setVisibility(8);
            SpaceBannerItemContent item722 = card.getBanner().getItem();
            if (item722 != null) {
            }
            switch (itemType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[itemType.ordinal()]) {
            }
            banner4 = card.getBanner();
            if (banner4 == null && (extra = banner4.getExtra()) != null && extra.getCollectionCompleted()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0(FrontAdapter this$0, int $position) {
        this$0.onVideoItemPlayCompleted.invoke(Integer.valueOf($position));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(SpaceBannerItemForUI $card, RecyclerView.ViewHolder $holder, FrontAdapter this$0, int $position, View it) {
        String it2;
        SpaceBannerExtra extra = $card.getBanner().getExtra();
        if (extra != null && (it2 = extra.getDetailJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "carousel");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, ((FrontViewHolder) $holder).getBinding().getRoot().getContext());
            CollectionReporterHelper collectionReporterHelper = CollectionReporterHelper.INSTANCE;
            SpaceBannerItem banner = $card.getBanner();
            collectionReporterHelper.reportCollectionTopClick(banner != null ? banner.getItemId() : null, this$0.isMe, String.valueOf($position + 1), "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(RecyclerView.ViewHolder $holder, View it) {
        ((FrontViewHolder) $holder).switchVideoSound(true);
    }

    public int getItemCount() {
        return this.mCards.size();
    }

    public int getItemViewType(int position) {
        return 1;
    }
}