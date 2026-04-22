package tv.danmaku.bili.ui.videospace;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.TalkbackUtilsKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.playerbizcommon.features.hardware.HardwareService;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.DisplayOrientation;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IPlayerServiceManager;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.ScreenOrientationDelegate;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthorFullscreenWidget.kt */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0016\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorFullscreenWidget;", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mHardwareServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Lcom/bilibili/playerbizcommon/features/hardware/HardwareService;", "mDisplayOrientation", "Ltv/danmaku/biliplayerv2/DisplayOrientation;", "mVideoPlayEventListener", "tv/danmaku/bili/ui/videospace/AuthorFullscreenWidget$mVideoPlayEventListener$1", "Ltv/danmaku/bili/ui/videospace/AuthorFullscreenWidget$mVideoPlayEventListener$1;", "init", "", "updateIcon", "onWidgetActive", "onWidgetInactive", "bindPlayerContainer", "playerContainer", "onClick", "v", "Landroid/view/View;", "isInMultiWindowMode", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorFullscreenWidget extends TintImageView implements IControlWidget, View.OnClickListener {
    private static final String TAG = "PlayerFullscreenWidget";
    private DisplayOrientation mDisplayOrientation;
    private final PlayerServiceManager.Client<HardwareService> mHardwareServiceClient;
    private PlayerContainer mPlayerContainer;
    private final AuthorFullscreenWidget$mVideoPlayEventListener$1 mVideoPlayEventListener;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public /* synthetic */ Object bindToView(Continuation continuation) {
        Object bindToView$suspendImpl;
        bindToView$suspendImpl = IControlWidget.CC.bindToView$suspendImpl(this, continuation);
        return bindToView$suspendImpl;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public /* synthetic */ boolean getMembersInjector() {
        return IControlWidget.CC.$default$getMembersInjector(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1] */
    public AuthorFullscreenWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHardwareServiceClient = new PlayerServiceManager.Client<>();
        this.mDisplayOrientation = DisplayOrientation.LANDSCAPE;
        this.mVideoPlayEventListener = new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1
            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onAllVideoCompleted() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, String str) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, str);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveSucceed() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoCompleted(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, currentVideoPointer, currentVideoPointer2, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetChanged(int i) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetWillChange() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoStart(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoItemStart(CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
                AuthorFullscreenWidget.this.updateIcon();
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoSetChanged() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
                AuthorFullscreenWidget.this.updateIcon();
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1] */
    public AuthorFullscreenWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHardwareServiceClient = new PlayerServiceManager.Client<>();
        this.mDisplayOrientation = DisplayOrientation.LANDSCAPE;
        this.mVideoPlayEventListener = new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1
            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onAllVideoCompleted() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, String str) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, str);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveSucceed() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoCompleted(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, currentVideoPointer, currentVideoPointer2, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetChanged(int i) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetWillChange() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoStart(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoItemStart(CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
                AuthorFullscreenWidget.this.updateIcon();
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoSetChanged() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
                AuthorFullscreenWidget.this.updateIcon();
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1] */
    public AuthorFullscreenWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHardwareServiceClient = new PlayerServiceManager.Client<>();
        this.mDisplayOrientation = DisplayOrientation.LANDSCAPE;
        this.mVideoPlayEventListener = new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget$mVideoPlayEventListener$1
            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onAllVideoCompleted() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, String str) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, str);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveSucceed() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoCompleted(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, currentVideoPointer, currentVideoPointer2, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetChanged(int i) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetWillChange() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoStart(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoItemStart(CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
                AuthorFullscreenWidget.this.updateIcon();
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onVideoSetChanged() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
                AuthorFullscreenWidget.this.updateIcon();
            }
        };
        init();
    }

    private final void init() {
        TalkbackUtilsKt.setViewContentDescription((View) this, "展开全屏");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIcon() {
        IVideosPlayDirectorService videoPlayDirectorService;
        Video curVideo;
        int resId;
        Video.PlayableParams videoItem;
        Video.DisplayParams displayParams;
        IVideosPlayDirectorService videoPlayDirectorService2;
        PlayerContainer playerContainer = this.mPlayerContainer;
        DisplayOrientation displayOrientation = null;
        PlayerDataSource dataSource = (playerContainer == null || (videoPlayDirectorService2 = playerContainer.getVideoPlayDirectorService()) == null) ? null : videoPlayDirectorService2.getPlayerDataSource();
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null || (videoPlayDirectorService = playerContainer2.getVideoPlayDirectorService()) == null || (curVideo = videoPlayDirectorService.getCurrentVideo()) == null) {
            return;
        }
        if (dataSource != null && (videoItem = dataSource.getVideoItem(curVideo, curVideo.getCurrentIndex())) != null && (displayParams = videoItem.getDisplayParams()) != null) {
            displayOrientation = displayParams.getDisplayOrientation();
        }
        this.mDisplayOrientation = displayOrientation;
        if (this.mDisplayOrientation == DisplayOrientation.VERTICAL) {
            resId = R.drawable.ic_player_portrait_ver_fullscreen_bold;
        } else {
            resId = R.drawable.ic_player_portrait_fullscreen_bold;
        }
        Drawable drawableCompat = ContextCompat.getDrawable(getContext(), resId);
        if (drawableCompat != null) {
            setImageDrawable(drawableCompat);
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public void onWidgetActive() {
        IPlayerServiceManager playerServiceManager;
        IVideosPlayDirectorService videoPlayDirectorService;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (videoPlayDirectorService = playerContainer.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService.addVideoPlayEventListener(this.mVideoPlayEventListener);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (playerServiceManager = playerContainer2.getPlayerServiceManager()) != null) {
            playerServiceManager.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mHardwareServiceClient);
        }
        setOnClickListener(this);
        updateIcon();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public void onWidgetInactive() {
        IPlayerServiceManager playerServiceManager;
        IVideosPlayDirectorService videoPlayDirectorService;
        setOnClickListener(null);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (videoPlayDirectorService = playerContainer.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService.removeVideoPlayEventListener(this.mVideoPlayEventListener);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (playerServiceManager = playerContainer2.getPlayerServiceManager()) != null) {
            playerServiceManager.unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mHardwareServiceClient);
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        IControlContainerService controlContainerService;
        ScreenOrientationDelegate screenOrientationDelegate;
        IControlContainerService controlContainerService2;
        if (isInMultiWindowMode()) {
            ToastHelper.showToastShort(getContext(), getContext().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_278));
            return;
        }
        BLog.i(TAG, "click player orientation fullscreen");
        if (this.mDisplayOrientation == DisplayOrientation.VERTICAL) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null || (controlContainerService2 = playerContainer.getControlContainerService()) == null) {
                return;
            }
            controlContainerService2.switchTo(ControlContainerType.VERTICAL_FULLSCREEN);
            return;
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (controlContainerService = playerContainer2.getControlContainerService()) != null && (screenOrientationDelegate = controlContainerService.getScreenOrientationDelegate()) != null) {
            screenOrientationDelegate.switchOrientation(0);
        }
    }

    private final boolean isInMultiWindowMode() {
        if (Build.VERSION.SDK_INT >= 24) {
            Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(getContext());
            return findActivityOrNull != null ? findActivityOrNull.isInMultiWindowMode() : false;
        }
        return false;
    }

    /* compiled from: AuthorFullscreenWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorFullscreenWidget$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}