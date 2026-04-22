package tv.danmaku.bili.ui.garb.digital.base.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.common.gyroscope.model.NftGyroAttribute;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.okretro.BiliApiDataCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.BiliCardDetail;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.Content;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.biliplayerv2.NewPlayerUtilsKt;

/* compiled from: DigitalCardDetailAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mActionId", "", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "isHalfScreen", "", "<init>", "(ILcom/bili/digital/common/player/VideoParams;Z)V", "getVideoParams", "()Lcom/bili/digital/common/player/VideoParams;", "mContainerWidth", "mContainerHeight", "mCards", "", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "value", "cards", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "updateContainerSize", "", "width", "height", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private final boolean isHalfScreen;
    private final int mActionId;
    private List<DigitalCardDetailRenderData> mCards;
    private int mContainerHeight;
    private int mContainerWidth;
    private final VideoParams videoParams;

    /* compiled from: DigitalCardDetailAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NftType.values().length];
            try {
                iArr[NftType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NftType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DigitalCardDetailAdapter(int mActionId, VideoParams videoParams, boolean isHalfScreen) {
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        this.mActionId = mActionId;
        this.videoParams = videoParams;
        this.isHalfScreen = isHalfScreen;
        this.mCards = new ArrayList();
    }

    public final VideoParams getVideoParams() {
        return this.videoParams;
    }

    public final List<DigitalCardDetailRenderData> getCards() {
        return this.mCards;
    }

    public final void setCards(List<DigitalCardDetailRenderData> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.mCards = list;
    }

    public final void updateContainerSize(int width, int height) {
        this.mContainerWidth = width;
        this.mContainerHeight = height;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return DigitalCardDetailViewHolder.Companion.create(parent, this.videoParams);
    }

    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DigitalCardDetailViewHolder) {
            DigitalCardDetailRenderData card = this.mCards.get(position);
            if (this.isHalfScreen) {
                int holderHeight = this.mContainerHeight;
                int holderWidth = (this.mContainerHeight * 2) / 3;
                if (card.getHeight() > 0 && card.getWidth() > 0) {
                    holderHeight = (int) (holderWidth * ((card.getHeight() * 1.0f) / card.getWidth()));
                }
                ViewGroup.LayoutParams it = ((DigitalCardDetailViewHolder) holder).getMRootView().getLayoutParams();
                if (it != null) {
                    it.height = holderHeight;
                    it.width = holderWidth;
                    ((DigitalCardDetailViewHolder) holder).getMRootView().setLayoutParams(it);
                }
            } else {
                Context ctx = ((DigitalCardDetailViewHolder) holder).getMCardImg().getContext();
                int cardHeight = ScreenUtil.dip2px(ctx, 393.0f);
                int cardWidth = (cardHeight * 2) / 3;
                if (card.getHeight() > 0 && card.getWidth() > 0 && card.getWidth() > card.getHeight()) {
                    cardWidth = ScreenUtil.dip2px(ctx, 263.0f);
                    cardHeight = (int) (cardWidth * ((card.getHeight() * 1.0f) / card.getWidth()));
                } else if (card.getHeight() > 0 && card.getWidth() > 0) {
                    cardWidth = (int) (cardHeight * ((card.getWidth() * 1.0f) / card.getHeight()));
                }
                ViewGroup.LayoutParams it2 = ((DigitalCardDetailViewHolder) holder).getMRootView().getLayoutParams();
                if (it2 != null) {
                    it2.height = cardHeight;
                    it2.width = cardWidth;
                    ((DigitalCardDetailViewHolder) holder).getMRootView().setLayoutParams(it2);
                }
            }
            boolean z = true;
            if (card.getImgUrl().length() > 0) {
                ((DigitalCardDetailViewHolder) holder).getMCardImg().setVisibility(0);
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Context context = ((DigitalCardDetailViewHolder) holder).getMCardImg().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                ImageRequestBuilder enableAutoPlayAnimation$default = ImageRequestBuilder.enableAutoPlayAnimation$default(ImageRequestBuilder.enableAnimate$default(biliImageLoader.with(context).url(card.getImgUrl()).useOrigin(), true, (Boolean) null, 2, (Object) null), true, false, 2, (Object) null);
                ScaleType scaleType = ScaleType.FIT_CENTER;
                Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
                enableAutoPlayAnimation$default.actualImageScaleType(scaleType).into(((DigitalCardDetailViewHolder) holder).getMCardImg());
            } else {
                ((DigitalCardDetailViewHolder) holder).getMCardImg().setVisibility(8);
            }
            View background = ((DigitalCardDetailViewHolder) holder).getBackground();
            GradientDrawable $this$onBindViewHolder_u24lambda_u242 = new GradientDrawable();
            $this$onBindViewHolder_u24lambda_u242.setColor(Color.parseColor("#26FFFFFF"));
            $this$onBindViewHolder_u24lambda_u242.setCornerRadius(NewPlayerUtilsKt.toFloatPx(14.0f));
            background.setBackground($this$onBindViewHolder_u24lambda_u242);
            String frameImg = card.getFrameImg();
            if (!(frameImg == null || frameImg.length() == 0)) {
                ((DigitalCardDetailViewHolder) holder).getStroke().setVisibility(0);
                BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
                Context context2 = ((DigitalCardDetailViewHolder) holder).getStroke().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                biliImageLoader2.with(context2).url(card.getFrameImg()).into(((DigitalCardDetailViewHolder) holder).getStroke());
            } else {
                ((DigitalCardDetailViewHolder) holder).getStroke().setVisibility(8);
            }
            String leftTopTagImg = card.getLeftTopTagImg();
            if (leftTopTagImg != null && leftTopTagImg.length() != 0) {
                z = false;
            }
            if (!z) {
                ((DigitalCardDetailViewHolder) holder).getBadge().setVisibility(0);
                BiliImageLoader biliImageLoader3 = BiliImageLoader.INSTANCE;
                Context context3 = ((DigitalCardDetailViewHolder) holder).getBadge().getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                ImageRequestBuilder url = biliImageLoader3.with(context3).url(card.getLeftTopTagImg());
                ScaleType scaleType2 = ScaleType.FIT_START;
                Intrinsics.checkNotNullExpressionValue(scaleType2, "FIT_START");
                url.actualImageScaleType(scaleType2).into(((DigitalCardDetailViewHolder) holder).getBadge());
            } else {
                ((DigitalCardDetailViewHolder) holder).getBadge().setVisibility(8);
            }
            switch (WhenMappings.$EnumSwitchMapping$0[card.getType().ordinal()]) {
                case 1:
                    if (card.getHasGained()) {
                        if (card.getGyroscope() != null) {
                            List<NftGyroAttribute> gyroscope = card.getGyroscope();
                            Intrinsics.checkNotNull(gyroscope);
                            if (!gyroscope.isEmpty()) {
                                List<NftGyroAttribute> gyroscope2 = card.getGyroscope();
                                Intrinsics.checkNotNull(gyroscope2);
                                ((DigitalCardDetailViewHolder) holder).loadGyro(gyroscope2);
                                return;
                            }
                        }
                        if (card.getNeedRequest()) {
                            BiliNftApiManager.INSTANCE.loadDLCCardDetail(this.mActionId, card.getCardTypeId(), new BiliApiDataCallback<BiliCardDetail>() { // from class: tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailAdapter$onBindViewHolder$4
                                public void onDataSuccess(BiliCardDetail data) {
                                    CardTypeInfo cardTypeInfo;
                                    Content content;
                                    BiliNftImage image;
                                    List gyroData = (data == null || (cardTypeInfo = data.getCardTypeInfo()) == null || (content = cardTypeInfo.getContent()) == null || (image = content.getImage()) == null) ? null : image.getGyroscope();
                                    if (data == null || gyroData == null) {
                                        onError(new Exception("接口下发数据为空"));
                                        return;
                                    }
                                    BLog.d("NftCardRecyclerView", "load card detail api success");
                                    ((DigitalCardDetailViewHolder) holder).loadGyro(gyroData);
                                }

                                public void onError(Throwable t) {
                                    BLog.e("NftCardRecyclerView", "load card detail err, cause " + (t != null ? t.getMessage() : null));
                                }
                            });
                            return;
                        } else {
                            ((DigitalCardDetailViewHolder) holder).getMCardGyro().setVisibility(8);
                            return;
                        }
                    }
                    ((DigitalCardDetailViewHolder) holder).getMCardGyro().setVisibility(8);
                    return;
                case 2:
                    ((DigitalCardDetailViewHolder) holder).getMCardGyro().setVisibility(8);
                    ((DigitalCardDetailViewHolder) holder).checkToResetPlayerCard(card);
                    return;
                default:
                    ((DigitalCardDetailViewHolder) holder).getMCardGyro().setVisibility(8);
                    return;
            }
        }
    }

    public int getItemCount() {
        return this.mCards.size();
    }

    public int getItemViewType(int position) {
        return 1;
    }
}