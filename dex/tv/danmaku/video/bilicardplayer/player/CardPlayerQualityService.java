package tv.danmaku.video.bilicardplayer.player;

import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.VodIndex;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IPlayerSourceObserver;
import tv.danmaku.biliplayerv2.service.IVideoQualityProvider;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.utils.MediaItemBuilderExtKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: CardPlayerQualityService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\n\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardPlayerQualityService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mDesireQuality", "", "mMaxQuality", "mPlayerSourceObserver", "tv/danmaku/video/bilicardplayer/player/CardPlayerQualityService$mPlayerSourceObserver$1", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerQualityService$mPlayerSourceObserver$1;", "mPlayerStateObserver", "tv/danmaku/video/bilicardplayer/player/CardPlayerQualityService$mPlayerStateObserver$1", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerQualityService$mPlayerStateObserver$1;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "updatePlayIndex", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "setDesireQuality", "setMaxQuality", "getExpectedLimitedQualityLocally", "getDesireQuality", "onStop", "bindPlayerContainer", "playerContainer", "switchToQuality", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardPlayerQualityService implements IPlayerService {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_CARD_PLAYER_QUALITY = 32;
    private static final String TAG = "CardPlayerQualityService";
    private PlayerContainer mPlayerContainer;
    private int mDesireQuality = -1;
    private int mMaxQuality = -1;
    private final CardPlayerQualityService$mPlayerSourceObserver$1 mPlayerSourceObserver = new IPlayerSourceObserver() { // from class: tv.danmaku.video.bilicardplayer.player.CardPlayerQualityService$mPlayerSourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerSourceObserver
        public /* synthetic */ void onAudioSourceChanged(boolean z, int i, int i2, boolean z2) {
            IPlayerSourceObserver.CC.$default$onAudioSourceChanged(this, z, i, i2, z2);
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerSourceObserver
        public /* synthetic */ void onRecommendVideoSourceStarted(int i) {
            IPlayerSourceObserver.CC.$default$onRecommendVideoSourceStarted(this, i);
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerSourceObserver
        public void onSourceChanged(boolean success, int oldQuality, int newQuality, boolean fromAuto) {
            if (success) {
                CardPlayerQualityService.this.updatePlayIndex(newQuality);
            } else {
                PlayerLog.i("CardPlayerQualityService", "on source changed quality:" + newQuality + " fail");
            }
        }
    };
    private final CardPlayerQualityService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.video.bilicardplayer.player.CardPlayerQualityService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            int i;
            int i2;
            PlayerContainer playerContainer;
            int targetQuality;
            PlayerContainer playerContainer2;
            int i3;
            PlayerContainer playerContainer3;
            int i4;
            int i5;
            int i6;
            PlayerContainer playerContainer4;
            int i7;
            int i8;
            if (state == 3) {
                i = CardPlayerQualityService.this.mMaxQuality;
                if (i != -1) {
                    i2 = CardPlayerQualityService.this.mDesireQuality;
                    PlayerContainer playerContainer5 = null;
                    if (i2 == 0) {
                        playerContainer2 = CardPlayerQualityService.this.mPlayerContainer;
                        if (playerContainer2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainer2 = null;
                        }
                        int currentQuality = playerContainer2.getPlayerCoreService().getCurrentQuality();
                        i3 = CardPlayerQualityService.this.mMaxQuality;
                        if (currentQuality <= i3) {
                            i8 = CardPlayerQualityService.this.mMaxQuality;
                            BLog.i("CardPlayerQualityService", "target quality: " + i8 + "， current quality:" + currentQuality + ", do nothing...");
                            return;
                        }
                        playerContainer3 = CardPlayerQualityService.this.mPlayerContainer;
                        if (playerContainer3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainer3 = null;
                        }
                        boolean currentAutoState = playerContainer3.getPlayerCoreService().getDashAuto();
                        if (currentAutoState) {
                            i6 = CardPlayerQualityService.this.mMaxQuality;
                            BLog.i("CardPlayerQualityService", "target auto quality, set max quality: " + i6);
                            playerContainer4 = CardPlayerQualityService.this.mPlayerContainer;
                            if (playerContainer4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                                playerContainer4 = null;
                            }
                            IPlayerCoreService playerCoreService = playerContainer4.getPlayerCoreService();
                            i7 = CardPlayerQualityService.this.mMaxQuality;
                            IPlayerCoreService.CC.switchAutoQuality$default(playerCoreService, 0, i7, 1, null);
                            return;
                        }
                        i4 = CardPlayerQualityService.this.mMaxQuality;
                        BLog.i("CardPlayerQualityService", "target quality:" + i4 + ", current quality:" + currentQuality + ", switching...");
                        CardPlayerQualityService cardPlayerQualityService = CardPlayerQualityService.this;
                        i5 = CardPlayerQualityService.this.mMaxQuality;
                        cardPlayerQualityService.switchToQuality(i5);
                        return;
                    }
                    playerContainer = CardPlayerQualityService.this.mPlayerContainer;
                    if (playerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer5 = playerContainer;
                    }
                    IPlayerCoreService playerCoreService2 = playerContainer5.getPlayerCoreService();
                    int currentQuality2 = playerCoreService2.getCurrentQuality();
                    targetQuality = CardPlayerQualityService.this.getExpectedLimitedQualityLocally();
                    if (currentQuality2 <= targetQuality) {
                        BLog.i("CardPlayerQualityService", "target quality:" + targetQuality + ", current quality:" + currentQuality2 + ", do nothing...");
                        return;
                    }
                    BLog.i("CardPlayerQualityService", "target quality:" + targetQuality + ", current quality:" + currentQuality2 + ", switching...");
                    CardPlayerQualityService.this.switchToQuality(targetQuality);
                }
            }
        }
    };

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        Intrinsics.checkNotNullParameter(playerSharingType, "sharingType");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onCollectSharedParams(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    /* compiled from: CardPlayerQualityService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardPlayerQualityService$Companion;", "", "<init>", "()V", "DEFAULT_CARD_PLAYER_QUALITY", "", "TAG", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().addPlayerSourceObserver(this.mPlayerSourceObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getPlayerCoreService().registerState(this.mPlayerStateObserver, 3);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getVideoPlayDirectorService().setVideoQualityProvider(new IVideoQualityProvider() { // from class: tv.danmaku.video.bilicardplayer.player.CardPlayerQualityService$onStart$1
            @Override // tv.danmaku.biliplayerv2.service.IVideoQualityProvider
            public /* synthetic */ int[] getRecommendStartQualityRange() {
                return IVideoQualityProvider.CC.$default$getRecommendStartQualityRange(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideoQualityProvider
            public int getExpectedQuality(IVideoQualityProvider.ResolveFrom from) {
                int expectedLimitedQualityLocally;
                Intrinsics.checkNotNullParameter(from, "from");
                expectedLimitedQualityLocally = CardPlayerQualityService.this.getExpectedLimitedQualityLocally();
                return expectedLimitedQualityLocally;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlayIndex(int quality) {
        VodIndex vodIndex;
        PlayerContainer playerContainer = this.mPlayerContainer;
        ArrayList playIndexList = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        MediaResource mediaResource = playerContainer.getPlayerCoreService().getMediaResource();
        if (mediaResource != null && (vodIndex = mediaResource.mVodIndex) != null) {
            playIndexList = vodIndex.mVodList;
        }
        if (playIndexList == null || playIndexList.isEmpty()) {
            return;
        }
        int size = playIndexList.size();
        for (int i = 0; i < size; i++) {
            if (quality == ((PlayIndex) playIndexList.get(i)).mQuality) {
                mediaResource.setResolvedIndex(i);
                return;
            }
        }
    }

    public final void setDesireQuality(int quality) {
        this.mDesireQuality = quality;
        if (this.mDesireQuality == 0 && this.mMaxQuality == -1) {
            BLog.i(TAG, "set auto should set max");
        }
    }

    public final void setMaxQuality(int quality) {
        this.mMaxQuality = quality;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getExpectedLimitedQualityLocally() {
        if (this.mMaxQuality == -1) {
            if (this.mDesireQuality <= 0) {
                return 32;
            }
            return this.mDesireQuality;
        } else if (this.mDesireQuality == 0) {
            return 32;
        } else {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            int currentQuality = playerContainer.getPlayerCoreService().getCurrentQuality();
            int desireQuality = this.mDesireQuality > 0 ? this.mDesireQuality : 32;
            int i = this.mMaxQuality;
            return currentQuality > 0 ? Math.min(i, Math.min(desireQuality, currentQuality)) : Math.min(i, desireQuality);
        }
    }

    public final int getDesireQuality() {
        return this.mDesireQuality;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().removePlayerSourceObserver(this.mPlayerSourceObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        playerContainer2.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchToQuality(int quality) {
        PlayIndex playIndex;
        PlayerContainer playerContainer;
        PlayerContainer playerContainer2;
        Object element$iv;
        boolean z;
        if (quality <= 0) {
            BLog.i(TAG, "quality error");
            return;
        }
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        IPlayerCoreService playerCoreService = playerContainer3.getPlayerCoreService();
        MediaResource mediaResource = playerCoreService.getMediaResource();
        if (mediaResource == null) {
            BLog.e(TAG, "mediaResource is null, can't switch quality");
            return;
        }
        PlayIndex currentPlayIndex = mediaResource.getPlayIndex();
        Iterable iterable = mediaResource.mVodIndex.mVodList;
        boolean attributeMismatch = false;
        if (iterable != null) {
            Iterable $this$firstOrNull$iv = iterable;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    PlayIndex it2 = (PlayIndex) element$iv;
                    if (it2.mQuality == quality && (it2.isPlayable() || playerCoreService.supportQuality(it2.mQuality))) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            playIndex = (PlayIndex) element$iv;
        } else {
            playIndex = null;
        }
        PlayIndex targetPlayIndex = playIndex;
        if (targetPlayIndex == null) {
            BLog.e(TAG, "targetPlayIndex is null, can't switch quality");
            return;
        }
        boolean supportSwitch = playerCoreService.supportQuality(quality);
        if (currentPlayIndex != null && currentPlayIndex.attribute != targetPlayIndex.attribute) {
            attributeMismatch = true;
        }
        BLog.i(TAG, "supportSwitch:" + supportSwitch + ", attributeMismatch:" + attributeMismatch);
        if (!supportSwitch || attributeMismatch) {
            mediaResource.setResolvedIndex(mediaResource.mVodIndex.mVodList.indexOf(targetPlayIndex));
            PlayerContainer playerContainer4 = this.mPlayerContainer;
            if (playerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer4 = null;
            }
            MediaItemParams.Builder itemParamsBuilder = MediaItemBuilderExtKt.getMediaItemParamsBuilder(playerContainer4, mediaResource);
            int currentPosition = playerCoreService.getCurrentPosition();
            PlayerContainer playerContainer5 = this.mPlayerContainer;
            if (playerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer5 = null;
            }
            Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector((IPlayerContainer) playerContainer5).getCurrentPlayableParams();
            MediaItemParams.Builder $this$switchToQuality_u24lambda_u241 = MediaItemBuilderExtKt.applyPlayableParams(itemParamsBuilder, playableParams);
            $this$switchToQuality_u24lambda_u241.setStartPosition(playerCoreService.interceptSeekTarget(currentPosition));
            if (playableParams != null) {
                PlayerContainer playerContainer6 = this.mPlayerContainer;
                if (playerContainer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                } else {
                    playerContainer = playerContainer6;
                }
                IMediaItemParamsInterceptor mediaItemSettingInterceptor = playerContainer.getVideoPlayDirectorService().getMediaItemSettingInterceptor();
                if (mediaItemSettingInterceptor != null) {
                    mediaItemSettingInterceptor.interceptMediaItemParams(playableParams, $this$switchToQuality_u24lambda_u241, true);
                }
            }
            playerCoreService.setMediaResource(mediaResource, true, itemParamsBuilder.build());
            return;
        }
        PlayerContainer playerContainer7 = this.mPlayerContainer;
        if (playerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        } else {
            playerContainer2 = playerContainer7;
        }
        playerContainer2.getPlayerCoreService().switchQuality(quality);
    }
}