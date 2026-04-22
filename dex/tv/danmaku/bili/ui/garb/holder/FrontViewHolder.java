package tv.danmaku.bili.ui.garb.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bili.digital.common.data.CardMetaInfo;
import com.bili.digital.common.data.CollectionBizType;
import com.bili.digital.common.data.CollectionItemType;
import com.bili.digital.common.data.SpaceBannerItemAnimation;
import com.bili.digital.common.data.SpaceBannerItemCardExtra;
import com.bili.digital.common.data.SpaceBannerItemContent;
import com.bili.digital.common.data.SpaceBannerItemForUI;
import com.bili.digital.common.data.SpaceBannerItemImage;
import com.bili.digital.common.data.SpaceBannerItemMusic;
import com.bili.digital.common.data.SpaceBannerItemMusicAlbum;
import com.bili.digital.common.data.SpaceBannerTitle;
import com.bili.digital.common.player.DigitalCard;
import com.bili.digital.common.player.DigitalCardPlayerCompleteCallback;
import com.bili.digital.common.player.DigitalCardPlayerManager;
import com.bili.digital.common.player.DigitalCardPlayerPanel;
import com.bili.digital.common.player.DigitalCardProgressCallback;
import com.bili.digital.common.player.VideoParams;
import com.bili.digital.common.ui.MusicNftManager;
import com.bilibili.app.authorspace.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.inline.card.IInlineCard;
import com.bilibili.inline.card.IInlineCardData;
import com.bilibili.inline.card.IInlinePlayItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.databinding.BiliAppViewHolderCollectionFrontBinding;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.ui.garb.NftCardVideoRoundFrameLayout;
import tv.danmaku.bili.ui.garb.SmeltVideoController;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: FrontViewHolder.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00019\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001eJ\u0006\u0010(\u001a\u00020!J\u0006\u0010)\u001a\u00020!J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001eJ\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.J\u0016\u0010/\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020!J\u000e\u00102\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010;\u001a\u00020!J\u000e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u001eJ\u000e\u0010>\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001eJ\u001e\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0006\u001a\u00020\u0007JM\u0010D\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020A2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020C\u0018\u0001042\b\b\u0002\u0010F\u001a\u00020.2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I¢\u0006\u0002\u0010JR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006L"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/FrontViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionFrontBinding;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "uamVideoController", "Ltv/danmaku/bili/ui/garb/SmeltVideoController;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionFrontBinding;Lcom/bili/digital/common/player/VideoParams;Ltv/danmaku/bili/ui/garb/SmeltVideoController;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionFrontBinding;", "getVideoParams", "()Lcom/bili/digital/common/player/VideoParams;", "getUamVideoController", "()Ltv/danmaku/bili/ui/garb/SmeltVideoController;", "mMusicNftManager", "Lcom/bili/digital/common/ui/MusicNftManager;", "getMMusicNftManager", "()Lcom/bili/digital/common/ui/MusicNftManager;", "mMusicNftManager$delegate", "Lkotlin/Lazy;", "playerCard", "Lcom/bilibili/inline/card/IInlineCard;", "Lcom/bili/digital/common/player/DigitalCardPlayerPanel;", "getPlayerCard", "()Lcom/bilibili/inline/card/IInlineCard;", "setPlayerCard", "(Lcom/bilibili/inline/card/IInlineCard;)V", "mData", "Lcom/bili/digital/common/data/SpaceBannerItemForUI;", "onVideoComplete", "Lkotlin/Function0;", "", "getOnVideoComplete", "()Lkotlin/jvm/functions/Function0;", "setOnVideoComplete", "(Lkotlin/jvm/functions/Function0;)V", "bindData", "item", "onViewDetachedFromWindow", "onViewAttachedToWindow", "showGyroView", "card", "switchVideoSound", "isShowIcon", "", "setVideoSound", "mute", "hideVideoView", "checkToResetPlayerCard", "mMusicList", "", "Lcom/bili/digital/common/data/SpaceBannerItemMusic;", "mMusicIndex", "", "mMusicCompleteCallback", "tv/danmaku/bili/ui/garb/holder/FrontViewHolder$mMusicCompleteCallback$1", "Ltv/danmaku/bili/ui/garb/holder/FrontViewHolder$mMusicCompleteCallback$1;", "playNextMusic", "showMusicAnimation", "data", "refreshMuteState", "playUamVideo", "uniqueId", "", "videoUrl", "", "playVideo", "videoList", "isMute", "playOnce", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bili/digital/common/player/DigitalCardPlayerCompleteCallback;", "(Lcom/bili/digital/common/data/SpaceBannerItemForUI;JLjava/util/List;ZLjava/lang/Boolean;Lcom/bili/digital/common/player/DigitalCardPlayerCompleteCallback;)V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FrontViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "DigitalCardDetailViewHolder";
    private static Boolean globalMute;
    private final BiliAppViewHolderCollectionFrontBinding binding;
    private SpaceBannerItemForUI mData;
    private final FrontViewHolder$mMusicCompleteCallback$1 mMusicCompleteCallback;
    private int mMusicIndex;
    private List<SpaceBannerItemMusic> mMusicList;
    private final Lazy mMusicNftManager$delegate;
    private Function0<Unit> onVideoComplete;
    private IInlineCard<DigitalCardPlayerPanel> playerCard;
    private final SmeltVideoController uamVideoController;
    private final VideoParams videoParams;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v8, types: [tv.danmaku.bili.ui.garb.holder.FrontViewHolder$mMusicCompleteCallback$1] */
    public FrontViewHolder(BiliAppViewHolderCollectionFrontBinding binding, VideoParams videoParams, SmeltVideoController uamVideoController) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(uamVideoController, "uamVideoController");
        this.binding = binding;
        this.videoParams = videoParams;
        this.uamVideoController = uamVideoController;
        this.mMusicNftManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda0
            public final Object invoke() {
                MusicNftManager mMusicNftManager_delegate$lambda$0;
                mMusicNftManager_delegate$lambda$0 = FrontViewHolder.mMusicNftManager_delegate$lambda$0();
                return mMusicNftManager_delegate$lambda$0;
            }
        });
        MusicNftManager mMusicNftManager = getMMusicNftManager();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        mMusicNftManager.init(context, this.binding.musicNftCoverGroup, false);
        this.mMusicCompleteCallback = new DigitalCardPlayerCompleteCallback() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$mMusicCompleteCallback$1
            public void onCardPlayCompleted() {
                FrontViewHolder.this.playNextMusic();
            }
        };
    }

    public final BiliAppViewHolderCollectionFrontBinding getBinding() {
        return this.binding;
    }

    public final VideoParams getVideoParams() {
        return this.videoParams;
    }

    public final SmeltVideoController getUamVideoController() {
        return this.uamVideoController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicNftManager mMusicNftManager_delegate$lambda$0() {
        return new MusicNftManager();
    }

    public final MusicNftManager getMMusicNftManager() {
        return (MusicNftManager) this.mMusicNftManager$delegate.getValue();
    }

    public final IInlineCard<DigitalCardPlayerPanel> getPlayerCard() {
        return this.playerCard;
    }

    public final void setPlayerCard(IInlineCard<DigitalCardPlayerPanel> iInlineCard) {
        this.playerCard = iInlineCard;
    }

    public final Function0<Unit> getOnVideoComplete() {
        return this.onVideoComplete;
    }

    public final void setOnVideoComplete(Function0<Unit> function0) {
        this.onVideoComplete = function0;
    }

    public final void bindData(SpaceBannerItemForUI item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.mData = item;
    }

    public final void onViewDetachedFromWindow() {
        SpaceBannerItemImage image;
        List gyroscope;
        SpaceBannerItemForUI spaceBannerItemForUI = this.mData;
        SpaceBannerItemForUI spaceBannerItemForUI2 = null;
        if (spaceBannerItemForUI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            spaceBannerItemForUI = null;
        }
        SpaceBannerItemContent item = spaceBannerItemForUI.getBanner().getItem();
        if ((item != null ? item.getItemType() : null) == CollectionItemType.VIDEO) {
            hideVideoView();
            this.videoParams.getPlayerManager().stopPlay();
        } else {
            SpaceBannerItemForUI spaceBannerItemForUI3 = this.mData;
            if (spaceBannerItemForUI3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                spaceBannerItemForUI3 = null;
            }
            SpaceBannerItemContent item2 = spaceBannerItemForUI3.getBanner().getItem();
            if ((item2 != null ? item2.getItemType() : null) == CollectionItemType.MUSIC_NFT) {
                hideVideoView();
                getMMusicNftManager().reset();
                this.videoParams.getPlayerManager().stopPlay();
            } else {
                SpaceBannerItemForUI spaceBannerItemForUI4 = this.mData;
                if (spaceBannerItemForUI4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                    spaceBannerItemForUI4 = null;
                }
                SpaceBannerItemContent item3 = spaceBannerItemForUI4.getBanner().getItem();
                if ((item3 != null ? item3.getItemType() : null) == CollectionItemType.IMAGE) {
                    SpaceBannerItemForUI spaceBannerItemForUI5 = this.mData;
                    if (spaceBannerItemForUI5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mData");
                        spaceBannerItemForUI5 = null;
                    }
                    SpaceBannerItemContent item4 = spaceBannerItemForUI5.getBanner().getItem();
                    boolean z = false;
                    if (item4 != null && (image = item4.getImage()) != null && (gyroscope = image.getGyroscope()) != null && !gyroscope.isEmpty()) {
                        z = true;
                    }
                    if (z) {
                        this.binding.nftCardGyro.onDestroy();
                    }
                }
            }
        }
        SpaceBannerItemForUI spaceBannerItemForUI6 = this.mData;
        if (spaceBannerItemForUI6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
        } else {
            spaceBannerItemForUI2 = spaceBannerItemForUI6;
        }
        refreshMuteState(spaceBannerItemForUI2);
    }

    public final void onViewAttachedToWindow() {
        SpaceBannerItemImage image;
        List gyroscope;
        SpaceBannerItemForUI spaceBannerItemForUI;
        SpaceBannerItemAnimation animation;
        SpaceBannerItemCardExtra cardExtra;
        CardMetaInfo cardMetaInfo;
        SpaceBannerItemCardExtra cardExtra2;
        CardMetaInfo cardMetaInfo2;
        SpaceBannerItemForUI spaceBannerItemForUI2 = this.mData;
        SpaceBannerItemForUI spaceBannerItemForUI3 = null;
        if (spaceBannerItemForUI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            spaceBannerItemForUI2 = null;
        }
        SpaceBannerItemContent item = spaceBannerItemForUI2.getBanner().getItem();
        boolean z = false;
        boolean hasSmelted = (item == null || (cardExtra2 = item.getCardExtra()) == null || (cardMetaInfo2 = cardExtra2.getCardMetaInfo()) == null) ? false : cardMetaInfo2.getHasSmelted();
        SpaceBannerItemForUI spaceBannerItemForUI4 = this.mData;
        if (spaceBannerItemForUI4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            spaceBannerItemForUI4 = null;
        }
        SpaceBannerItemContent item2 = spaceBannerItemForUI4.getBanner().getItem();
        String smeltDynamicUrl = (item2 == null || (cardExtra = item2.getCardExtra()) == null || (cardMetaInfo = cardExtra.getCardMetaInfo()) == null || (smeltDynamicUrl = cardMetaInfo.getSmeltDynamicUrl()) == null) ? "" : "";
        if (hasSmelted) {
            if (smeltDynamicUrl.length() > 0) {
                SpaceBannerItemForUI spaceBannerItemForUI5 = this.mData;
                if (spaceBannerItemForUI5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                    spaceBannerItemForUI5 = null;
                }
                playUamVideo(spaceBannerItemForUI5.getUniqueId(), smeltDynamicUrl, this.uamVideoController);
            }
        }
        SpaceBannerItemForUI spaceBannerItemForUI6 = this.mData;
        if (spaceBannerItemForUI6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            spaceBannerItemForUI6 = null;
        }
        SpaceBannerItemContent item3 = spaceBannerItemForUI6.getBanner().getItem();
        if ((item3 != null ? item3.getItemType() : null) == CollectionItemType.VIDEO) {
            SpaceBannerItemForUI spaceBannerItemForUI7 = this.mData;
            if (spaceBannerItemForUI7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                spaceBannerItemForUI = null;
            } else {
                spaceBannerItemForUI = spaceBannerItemForUI7;
            }
            SpaceBannerItemForUI spaceBannerItemForUI8 = this.mData;
            if (spaceBannerItemForUI8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                spaceBannerItemForUI8 = null;
            }
            long uniqueId = spaceBannerItemForUI8.getUniqueId();
            SpaceBannerItemForUI spaceBannerItemForUI9 = this.mData;
            if (spaceBannerItemForUI9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                spaceBannerItemForUI9 = null;
            }
            SpaceBannerItemContent item4 = spaceBannerItemForUI9.getBanner().getItem();
            playVideo$default(this, spaceBannerItemForUI, uniqueId, (item4 == null || (animation = item4.getAnimation()) == null) ? null : animation.getAnimationVideoUrls(), false, null, new DigitalCardPlayerCompleteCallback() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$onViewAttachedToWindow$1
                public void onCardPlayCompleted() {
                    Function0<Unit> onVideoComplete = FrontViewHolder.this.getOnVideoComplete();
                    if (onVideoComplete != null) {
                        onVideoComplete.invoke();
                    }
                }
            }, 16, null);
        } else {
            SpaceBannerItemForUI spaceBannerItemForUI10 = this.mData;
            if (spaceBannerItemForUI10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                spaceBannerItemForUI10 = null;
            }
            SpaceBannerItemContent item5 = spaceBannerItemForUI10.getBanner().getItem();
            if ((item5 != null ? item5.getItemType() : null) == CollectionItemType.MUSIC_NFT) {
                SpaceBannerItemForUI spaceBannerItemForUI11 = this.mData;
                if (spaceBannerItemForUI11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                    spaceBannerItemForUI11 = null;
                }
                showMusicAnimation(spaceBannerItemForUI11);
            } else {
                SpaceBannerItemForUI spaceBannerItemForUI12 = this.mData;
                if (spaceBannerItemForUI12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                    spaceBannerItemForUI12 = null;
                }
                SpaceBannerItemContent item6 = spaceBannerItemForUI12.getBanner().getItem();
                if ((item6 != null ? item6.getItemType() : null) == CollectionItemType.IMAGE) {
                    SpaceBannerItemForUI spaceBannerItemForUI13 = this.mData;
                    if (spaceBannerItemForUI13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mData");
                        spaceBannerItemForUI13 = null;
                    }
                    SpaceBannerItemContent item7 = spaceBannerItemForUI13.getBanner().getItem();
                    if (item7 != null && (image = item7.getImage()) != null && (gyroscope = image.getGyroscope()) != null && !gyroscope.isEmpty()) {
                        z = true;
                    }
                    if (z) {
                        SpaceBannerItemForUI spaceBannerItemForUI14 = this.mData;
                        if (spaceBannerItemForUI14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mData");
                            spaceBannerItemForUI14 = null;
                        }
                        showGyroView(spaceBannerItemForUI14);
                    }
                }
            }
        }
        SpaceBannerItemForUI spaceBannerItemForUI15 = this.mData;
        if (spaceBannerItemForUI15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
        } else {
            spaceBannerItemForUI3 = spaceBannerItemForUI15;
        }
        refreshMuteState(spaceBannerItemForUI3);
    }

    public final void showGyroView(SpaceBannerItemForUI card) {
        SpaceBannerItemImage image;
        List it;
        Intrinsics.checkNotNullParameter(card, "card");
        this.binding.nftCardGyro.setVisibility(0);
        SpaceBannerItemContent item = card.getBanner().getItem();
        if (item != null && (image = item.getImage()) != null && (it = image.getGyroscope()) != null && !this.binding.nftCardGyro.configWithGyro(this.binding.nftCardGyro.getWidth(), this.binding.nftCardGyro.getHeight(), it, new GyroRoundedView.GyroViewCallBack() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$showGyroView$1$1
            public void notifyImgLoadSuc(boolean suc) {
                FrontViewHolder.this.getBinding().nftCardGyro.setVisibility(suc ? 0 : 8);
            }

            public void notifyGyroReport(float roll, float pitch, float yaw) {
            }
        })) {
            this.binding.nftCardGyro.setVisibility(8);
        }
    }

    public final void switchVideoSound(boolean isShowIcon) {
        boolean z;
        if (globalMute == null) {
            z = false;
        } else {
            Boolean bool = globalMute;
            Intrinsics.checkNotNull(bool);
            z = !bool.booleanValue();
        }
        globalMute = Boolean.valueOf(z);
        Boolean bool2 = globalMute;
        Intrinsics.checkNotNull(bool2);
        setVideoSound(isShowIcon, bool2.booleanValue());
    }

    public final void setVideoSound(boolean isShowIcon, boolean mute) {
        globalMute = Boolean.valueOf(mute);
        if (isShowIcon) {
            this.binding.nftHeaderVideoSound.setVisibility(0);
            if (mute) {
                this.binding.nftHeaderVideoSound.setImageResource(R.drawable.ic_sound_off);
            } else {
                this.binding.nftHeaderVideoSound.setImageResource(R.drawable.ic_sound_on);
            }
            this.videoParams.getPlayerManager().setMute(mute);
            return;
        }
        this.binding.nftHeaderVideoSound.setVisibility(8);
    }

    public final void hideVideoView() {
        this.binding.nftCardVideo.setVisibility(8);
    }

    public final void checkToResetPlayerCard(SpaceBannerItemForUI card) {
        CharSequence charSequence;
        IInlineCardData cardData;
        IInlinePlayItem inlinePlayerItem;
        Intrinsics.checkNotNullParameter(card, "card");
        if (this.playerCard != null) {
            String str = "digital_card_" + card.getUniqueId();
            IInlineCard<DigitalCardPlayerPanel> iInlineCard = this.playerCard;
            if (iInlineCard == null || (cardData = iInlineCard.getCardData()) == null || (inlinePlayerItem = cardData.getInlinePlayerItem()) == null) {
                charSequence = null;
            } else {
                charSequence = inlinePlayerItem.getInlineLogDescription();
            }
            if (!Intrinsics.areEqual(str, charSequence)) {
                this.playerCard = null;
            }
        }
    }

    public final void playNextMusic() {
        SpaceBannerItemForUI spaceBannerItemForUI;
        if (this.mMusicList == null) {
            return;
        }
        this.mMusicIndex++;
        int i = this.mMusicIndex;
        List<SpaceBannerItemMusic> list = this.mMusicList;
        if (i > (list != null ? list.size() : 0)) {
            this.mMusicIndex = 0;
        }
        SpaceBannerItemForUI spaceBannerItemForUI2 = this.mData;
        SpaceBannerItemForUI spaceBannerItemForUI3 = null;
        if (spaceBannerItemForUI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            spaceBannerItemForUI = null;
        } else {
            spaceBannerItemForUI = spaceBannerItemForUI2;
        }
        SpaceBannerItemForUI spaceBannerItemForUI4 = this.mData;
        if (spaceBannerItemForUI4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
        } else {
            spaceBannerItemForUI3 = spaceBannerItemForUI4;
        }
        long uniqueId = spaceBannerItemForUI3.getUniqueId();
        List<SpaceBannerItemMusic> list2 = this.mMusicList;
        Intrinsics.checkNotNull(list2);
        playVideo(spaceBannerItemForUI, uniqueId, CollectionsKt.listOf(list2.get(this.mMusicIndex).getSourceUrl()), false, true, this.mMusicCompleteCallback);
        getMMusicNftManager().playNext(true, new Function0() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit playNextMusic$lambda$0;
                playNextMusic$lambda$0 = FrontViewHolder.playNextMusic$lambda$0(FrontViewHolder.this);
                return playNextMusic$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playNextMusic$lambda$0(FrontViewHolder this$0) {
        MusicNftManager mMusicNftManager = this$0.getMMusicNftManager();
        List<SpaceBannerItemMusic> list = this$0.mMusicList;
        Intrinsics.checkNotNull(list);
        mMusicNftManager.loadSmallTurntableImage(list.get(this$0.mMusicIndex).getMusicCover());
        return Unit.INSTANCE;
    }

    public final void showMusicAnimation(final SpaceBannerItemForUI data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SpaceBannerItemContent item = data.getBanner().getItem();
        if ((item != null ? item.getItemType() : null) == CollectionItemType.MUSIC_NFT) {
            SpaceBannerItemContent item2 = data.getBanner().getItem();
            SpaceBannerItemMusicAlbum musicAlbum = item2 != null ? item2.getMusicAlbum() : null;
            if ((musicAlbum != null ? musicAlbum.getMusics() : null) != null && !musicAlbum.getMusics().isEmpty()) {
                final SpaceBannerItemMusic music = (SpaceBannerItemMusic) musicAlbum.getMusics().get(0);
                getMMusicNftManager().show();
                MusicNftManager mMusicNftManager = getMMusicNftManager();
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                mMusicNftManager.loadCover(context, musicAlbum.getAlbumCover(), musicAlbum.getVinylUrl(), music.getMusicCover(), new Function1() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit showMusicAnimation$lambda$0;
                        showMusicAnimation$lambda$0 = FrontViewHolder.showMusicAnimation$lambda$0(FrontViewHolder.this, data, music, ((Boolean) obj).booleanValue());
                        return showMusicAnimation$lambda$0;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showMusicAnimation$lambda$0(final FrontViewHolder this$0, final SpaceBannerItemForUI $data, final SpaceBannerItemMusic $music, boolean success) {
        if (success) {
            this$0.binding.nftCardContainer.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    FrontViewHolder.showMusicAnimation$lambda$0$0(FrontViewHolder.this, $data, $music);
                }
            }, 100L);
        } else {
            this$0.getMMusicNftManager().hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMusicAnimation$lambda$0$0(FrontViewHolder this$0, SpaceBannerItemForUI $data, SpaceBannerItemMusic $music) {
        this$0.getMMusicNftManager().reset();
        this$0.getMMusicNftManager().startEntranceAnimation((Function0) null);
        this$0.getMMusicNftManager().startLoopAnimation();
        this$0.playVideo($data, $data.getUniqueId(), CollectionsKt.listOf($music.getSourceUrl()), false, true, this$0.mMusicCompleteCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (((r0 == null || (r0 = r0.getAnimation()) == null || r0.isSilence()) ? false : true) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if ((r0 != null ? r0.getItemType() : null) == com.bili.digital.common.data.CollectionItemType.MUSIC_NFT) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r5.binding.nftHeaderVideoSound.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (tv.danmaku.bili.ui.garb.holder.FrontViewHolder.globalMute != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0 = tv.danmaku.bili.ui.garb.holder.FrontViewHolder.globalMute;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        tv.danmaku.bili.ui.garb.holder.FrontViewHolder.globalMute = r0;
        r0 = tv.danmaku.bili.ui.garb.holder.FrontViewHolder.globalMute;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        setVideoSound(true, r0.booleanValue());
        r5.binding.nftHeaderVideoSound.setOnClickListener(new tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda6(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshMuteState(SpaceBannerItemForUI card) {
        Intrinsics.checkNotNullParameter(card, "card");
        SpaceBannerItemContent item = card.getBanner().getItem();
        if ((item != null ? item.getItemType() : null) == CollectionItemType.VIDEO) {
            SpaceBannerItemContent item2 = card.getBanner().getItem();
        }
        if (card.getBanner().getBizType() == CollectionBizType.NFT) {
            SpaceBannerItemContent item3 = card.getBanner().getItem();
        }
        this.binding.nftHeaderVideoSound.setVisibility(8);
    }

    public final void playUamVideo(long uniqueId, String videoUrl, SmeltVideoController uamVideoController) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(uamVideoController, "uamVideoController");
        final UAMView uamVideoView = this.binding.nftCardSmeltVideo;
        Intrinsics.checkNotNullExpressionValue(uamVideoView, "nftCardSmeltVideo");
        uamVideoController.play(videoUrl, String.valueOf(uniqueId), new Function1() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit playUamVideo$lambda$0;
                playUamVideo$lambda$0 = FrontViewHolder.playUamVideo$lambda$0(uamVideoView, (String) obj);
                return playUamVideo$lambda$0;
            }
        }, new Function0() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit playUamVideo$lambda$1;
                playUamVideo$lambda$1 = FrontViewHolder.playUamVideo$lambda$1(uamVideoView, this);
                return playUamVideo$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playUamVideo$lambda$0(final UAMView $uamVideoView, final String path) {
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        View $this$isVisible$iv = (View) $uamVideoView;
        $this$isVisible$iv.setVisibility(0);
        $uamVideoView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.holder.FrontViewHolder$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                FrontViewHolder.playUamVideo$lambda$0$0($uamVideoView, path);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playUamVideo$lambda$0$0(UAMView $uamVideoView, String $path) {
        $uamVideoView.setLoop((int) FlowControlConfig.RETRY_MAX_TIMES);
        $uamVideoView.startPlay($path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playUamVideo$lambda$1(UAMView $uamVideoView, FrontViewHolder this$0) {
        $uamVideoView.setVisibility(4);
        if (this$0.playerCard != null) {
            NftCardVideoRoundFrameLayout nftCardVideoRoundFrameLayout = this$0.binding.nftCardVideo;
            Intrinsics.checkNotNullExpressionValue(nftCardVideoRoundFrameLayout, "nftCardVideo");
            View $this$isVisible$iv = (View) nftCardVideoRoundFrameLayout;
            $this$isVisible$iv.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void playVideo$default(FrontViewHolder frontViewHolder, SpaceBannerItemForUI spaceBannerItemForUI, long j, List list, boolean z, Boolean bool, DigitalCardPlayerCompleteCallback digitalCardPlayerCompleteCallback, int i, Object obj) {
        frontViewHolder.playVideo(spaceBannerItemForUI, j, list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : bool, (i & 32) != 0 ? null : digitalCardPlayerCompleteCallback);
    }

    public final void playVideo(SpaceBannerItemForUI card, long uniqueId, List<String> list, boolean isMute, Boolean playOnce, DigitalCardPlayerCompleteCallback callback) {
        boolean booleanValue;
        SpaceBannerItemAnimation animation;
        SpaceBannerItemAnimation animation2;
        SpaceBannerItemAnimation animation3;
        SpaceBannerItemCardExtra cardExtra;
        CardMetaInfo cardMetaInfo;
        Intrinsics.checkNotNullParameter(card, "card");
        SpaceBannerItemContent item = card.getBanner().getItem();
        if ((item != null ? item.getItemType() : null) != CollectionItemType.VIDEO) {
            if (card.getBanner().getBizType() == CollectionBizType.NFT) {
                SpaceBannerItemContent item2 = card.getBanner().getItem();
                if ((item2 != null ? item2.getItemType() : null) != CollectionItemType.MUSIC_NFT) {
                    return;
                }
            } else {
                return;
            }
        }
        List<String> list2 = list;
        int i = 0;
        if (list2 == null || list2.isEmpty()) {
            BLog.w("NftCardDialog", "play video failed, " + uniqueId + ", cause video list empty");
            return;
        }
        SpaceBannerItemContent item3 = card.getBanner().getItem();
        if ((item3 == null || (cardExtra = item3.getCardExtra()) == null || (cardMetaInfo = cardExtra.getCardMetaInfo()) == null || !cardMetaInfo.getHasSmelted()) ? false : true) {
            this.binding.nftCardVideo.setVisibility(4);
        } else {
            ListExtentionsKt.visible((View) this.binding.nftCardVideo);
        }
        NftCardVideoRoundFrameLayout nftCardVideoRoundFrameLayout = this.binding.nftCardVideo;
        Intrinsics.checkNotNullExpressionValue(nftCardVideoRoundFrameLayout, "nftCardVideo");
        DigitalCardPlayerManager playerManager = this.videoParams.getPlayerManager();
        SpaceBannerItemContent item4 = card.getBanner().getItem();
        boolean z = (item4 == null || (animation3 = item4.getAnimation()) == null || !animation3.getShowProgressBar()) ? false : true;
        Video.DisplayParams $this$playVideo_u24lambda_u240 = new Video.DisplayParams();
        SpaceBannerTitle title = card.getBanner().getTitle();
        $this$playVideo_u24lambda_u240.setTitle((title == null || (r6 = title.getTitle()) == null) ? "" : "");
        $this$playVideo_u24lambda_u240.setCover(card.getBanner().getCover());
        if (globalMute == null) {
            booleanValue = true;
        } else {
            Boolean bool = globalMute;
            Intrinsics.checkNotNull(bool);
            booleanValue = bool.booleanValue();
        }
        SpaceBannerItemContent item5 = card.getBanner().getItem();
        int trialDuration = (item5 == null || (animation2 = item5.getAnimation()) == null) ? -1 : animation2.getTrialDuration();
        SpaceBannerItemContent item6 = card.getBanner().getItem();
        if (item6 != null && (animation = item6.getAnimation()) != null) {
            i = animation.getDuration();
        }
        IInlineCard<DigitalCardPlayerPanel> digitalCard = new DigitalCard<>((ViewGroup) nftCardVideoRoundFrameLayout, uniqueId, list, playerManager, z, (DigitalCardProgressCallback) null, trialDuration, i, $this$playVideo_u24lambda_u240, booleanValue, playOnce, callback, (AspectRatio) null, (Function1) null, 12320, (DefaultConstructorMarker) null);
        this.videoParams.getPlayerManager().startPlay(digitalCard, true);
        this.videoParams.getPlayerManager().hideBufferingView();
        this.playerCard = digitalCard;
    }

    /* compiled from: FrontViewHolder.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/FrontViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/garb/holder/FrontViewHolder;", "parent", "Landroid/view/ViewGroup;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "uamVideoController", "Ltv/danmaku/bili/ui/garb/SmeltVideoController;", "TAG", "", "globalMute", "", "getGlobalMute", "()Ljava/lang/Boolean;", "setGlobalMute", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FrontViewHolder create(ViewGroup parent, VideoParams videoParams, SmeltVideoController uamVideoController) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(videoParams, "videoParams");
            Intrinsics.checkNotNullParameter(uamVideoController, "uamVideoController");
            BiliAppViewHolderCollectionFrontBinding binding = BiliAppViewHolderCollectionFrontBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
            return new FrontViewHolder(binding, videoParams, uamVideoController);
        }

        public final Boolean getGlobalMute() {
            return FrontViewHolder.globalMute;
        }

        public final void setGlobalMute(Boolean bool) {
            FrontViewHolder.globalMute = bool;
        }
    }
}