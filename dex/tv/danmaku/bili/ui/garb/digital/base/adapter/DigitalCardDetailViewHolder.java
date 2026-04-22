package tv.danmaku.bili.ui.garb.digital.base.adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.player.DigitalCard;
import com.bili.digital.common.player.DigitalCardDisplayParams;
import com.bili.digital.common.player.DigitalCardPlayerHelper;
import com.bili.digital.common.player.DigitalCardPlayerPanel;
import com.bili.digital.common.player.VideoParams;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.common.gyroscope.model.NftGyroAttribute;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.inline.card.IInlineCard;
import com.bilibili.inline.card.IInlineCardData;
import com.bilibili.inline.card.IInlinePlayItem;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;

/* compiled from: DigitalCardDetailViewHolder.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+J\u0006\u0010-\u001a\u00020)J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200J0\u00103\u001a\u00020)2\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u0002052\u000e\u00106\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010+2\b\b\u0002\u00107\u001a\u000208J\u0006\u00109\u001a\u00020)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "<init>", "(Landroid/view/View;Lcom/bili/digital/common/player/VideoParams;)V", "getVideoParams", "()Lcom/bili/digital/common/player/VideoParams;", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "mCardImg", "Lcom/bilibili/lib/image2/view/BiliImageView;", "getMCardImg", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "mCardGyro", "Lcom/bilibili/app/common/gyroscope/view/GyroRoundedView;", "getMCardGyro", "()Lcom/bilibili/app/common/gyroscope/view/GyroRoundedView;", "stroke", "getStroke", "badge", "getBadge", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "getBackground", "()Landroid/view/View;", "mCardVideoGroup", "Ltv/danmaku/bili/ui/garb/NftCardVideoRoundFrameLayout;", "getMCardVideoGroup", "()Ltv/danmaku/bili/ui/garb/NftCardVideoRoundFrameLayout;", "playerCard", "Lcom/bilibili/inline/card/IInlineCard;", "Lcom/bili/digital/common/player/DigitalCardPlayerPanel;", "getPlayerCard", "()Lcom/bilibili/inline/card/IInlineCard;", "setPlayerCard", "(Lcom/bilibili/inline/card/IInlineCard;)V", "loadGyro", "", "data", "", "Lcom/bilibili/app/common/gyroscope/model/NftGyroAttribute;", "hideVideoView", "checkToResetPlayerCard", "card", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "playingVideoList", "", "playVideo", "cardId", "", "videoList", "isMute", "", "startPlay", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "DigitalCardDetailViewHolder";
    private final View background;
    private final BiliImageView badge;
    private final GyroRoundedView mCardGyro;
    private final BiliImageView mCardImg;
    private final NftCardVideoRoundFrameLayout mCardVideoGroup;
    private final ViewGroup mRootView;
    private IInlineCard<DigitalCardPlayerPanel> playerCard;
    private List<String> playingVideoList;
    private final BiliImageView stroke;
    private final VideoParams videoParams;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalCardDetailViewHolder(View itemView, VideoParams videoParams) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        this.videoParams = videoParams;
        View findViewById = itemView.findViewById(R.id.nft_card_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mRootView = (ViewGroup) findViewById;
        BiliImageView findViewById2 = itemView.findViewById(R.id.nft_card_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mCardImg = findViewById2;
        GyroRoundedView findViewById3 = itemView.findViewById(R.id.nft_card_gyro);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mCardGyro = findViewById3;
        BiliImageView findViewById4 = itemView.findViewById(R.id.stroke);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.stroke = findViewById4;
        BiliImageView findViewById5 = itemView.findViewById(R.id.badge_top_left);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.badge = findViewById5;
        View findViewById6 = itemView.findViewById(R.id.nft_card_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.background = findViewById6;
        View findViewById7 = itemView.findViewById(R.id.nft_card_video);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mCardVideoGroup = (NftCardVideoRoundFrameLayout) findViewById7;
        this.playingVideoList = CollectionsKt.emptyList();
    }

    public final VideoParams getVideoParams() {
        return this.videoParams;
    }

    public final ViewGroup getMRootView() {
        return this.mRootView;
    }

    public final BiliImageView getMCardImg() {
        return this.mCardImg;
    }

    public final GyroRoundedView getMCardGyro() {
        return this.mCardGyro;
    }

    public final BiliImageView getStroke() {
        return this.stroke;
    }

    public final BiliImageView getBadge() {
        return this.badge;
    }

    public final View getBackground() {
        return this.background;
    }

    public final NftCardVideoRoundFrameLayout getMCardVideoGroup() {
        return this.mCardVideoGroup;
    }

    public final IInlineCard<DigitalCardPlayerPanel> getPlayerCard() {
        return this.playerCard;
    }

    public final void setPlayerCard(IInlineCard<DigitalCardPlayerPanel> iInlineCard) {
        this.playerCard = iInlineCard;
    }

    public final void loadGyro(List<NftGyroAttribute> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        BLog.d("DigitalCardDetailViewHolder", "loadGyro!");
        Application application = BiliContext.application();
        Context ctx = application != null ? application.getBaseContext() : null;
        this.mCardGyro.setVisibility(0);
        boolean result = this.mCardGyro.configWithGyro(ScreenUtil.dip2px(ctx, 263.0f), ScreenUtil.dip2px(ctx, 393.0f), list, new GyroRoundedView.GyroViewCallBack() { // from class: tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailViewHolder$loadGyro$result$1
            public void notifyImgLoadSuc(boolean suc) {
                BLog.d("DigitalCardDetailViewHolder", "load success ? " + suc);
            }

            public void notifyGyroReport(float roll, float pitch, float yaw) {
            }
        });
        BLog.d("DigitalCardDetailViewHolder", "config gyro success ?" + result);
    }

    public final void hideVideoView() {
        this.mCardVideoGroup.setVisibility(8);
    }

    public final void checkToResetPlayerCard(DigitalCardDetailRenderData card) {
        CharSequence charSequence;
        IInlineCardData cardData;
        IInlinePlayItem inlinePlayerItem;
        Intrinsics.checkNotNullParameter(card, "card");
        if (this.playerCard != null) {
            String str = "digital_card_" + card.getCardId();
            IInlineCard<DigitalCardPlayerPanel> iInlineCard = this.playerCard;
            if (iInlineCard == null || (cardData = iInlineCard.getCardData()) == null || (inlinePlayerItem = cardData.getInlinePlayerItem()) == null) {
                charSequence = null;
            } else {
                charSequence = inlinePlayerItem.getInlineLogDescription();
            }
            if (!Intrinsics.areEqual(str, charSequence)) {
                this.mCardVideoGroup.setVisibility(8);
                this.playerCard = null;
            }
        }
    }

    public static /* synthetic */ void playVideo$default(DigitalCardDetailViewHolder digitalCardDetailViewHolder, DigitalCardDetailRenderData digitalCardDetailRenderData, long j, List list, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        digitalCardDetailViewHolder.playVideo(digitalCardDetailRenderData, j, list, z2);
    }

    public final void playVideo(DigitalCardDetailRenderData card, long cardId, List<String> list, boolean isMute) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.getType() == NftType.VIDEO) {
            List<String> list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                ListExtentionsKt.visible((View) this.mCardVideoGroup);
                if (this.playerCard == null || !Intrinsics.areEqual(this.playingVideoList, list)) {
                    DigitalCardPlayerHelper.DigitalCardPlayerBuilder prepare = DigitalCardPlayerHelper.INSTANCE.prepare((ViewGroup) this.mCardVideoGroup, cardId, list, this.videoParams.getPlayerManager());
                    DLCPlayModel play = card.getPlay();
                    DigitalCardPlayerHelper.DigitalCardPlayerBuilder enablePlayerWidget = prepare.enablePlayerWidget(play != null && play.getShowProgressBar());
                    DigitalCardDisplayParams $this$playVideo_u24lambda_u240 = new DigitalCardDisplayParams();
                    String name = card.getName();
                    if (name == null) {
                        name = "";
                    }
                    $this$playVideo_u24lambda_u240.setTitle(name);
                    $this$playVideo_u24lambda_u240.setCover(card.getImgUrl());
                    Unit unit = Unit.INSTANCE;
                    DigitalCardPlayerHelper.DigitalCardPlayerBuilder cardMute = enablePlayerWidget.setNotificationDisplayParams($this$playVideo_u24lambda_u240).setCardMute(isMute);
                    DLCPlayModel play2 = card.getPlay();
                    int trialDuration = play2 != null ? play2.getTrialDuration() : -1;
                    DLCPlayModel play3 = card.getPlay();
                    this.playerCard = cardMute.setTrialDuration(trialDuration, play3 != null ? play3.getDuration() : 0).setPlayProgressCallback(this.videoParams.getVideoProgressCallback()).generatePlayCard();
                }
                DigitalCard digitalCard = this.playerCard;
                if (digitalCard != null) {
                    digitalCard.setCardMute(isMute);
                    this.videoParams.getPlayerManager().startPlay(digitalCard, true);
                    this.videoParams.getPlayerManager().hideBufferingView();
                }
                this.playingVideoList = list;
            }
        }
    }

    public final void startPlay() {
        IInlineCard it = this.playerCard;
        if (it != null) {
            this.videoParams.getPlayerManager().startPlay(it, true);
        }
    }

    /* compiled from: DigitalCardDetailViewHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailViewHolder;", "parent", "Landroid/view/ViewGroup;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DigitalCardDetailViewHolder create(ViewGroup parent, VideoParams videoParams) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(videoParams, "videoParams");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.bili_app_view_holder_nft_card_for_detail, parent, false);
            Intrinsics.checkNotNull(view);
            return new DigitalCardDetailViewHolder(view, videoParams);
        }
    }
}