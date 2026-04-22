package tv.danmaku.bili.ui.videospace.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import com.bilibili.app.authorspace.ui.widget.AuthorSpaceHeaderPlayerContainer;
import com.bilibili.app.provider.UtilKt;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.videospace.AuthorSpaceFansWallPlayerFragment;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.utils.NavigationHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: AuthorSpaceHeaderPlayerRouteService.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000fH\u0016J2\u0010+\u001a\u00020,2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0019H\u0016J\u0018\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u00100\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u0002012\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u0002012\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u00106\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0010\u00107\u001a\u00020\u00112\u0006\u00104\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Ltv/danmaku/bili/ui/videospace/router/AuthorSpaceHeaderPlayerRouteService;", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService;", "<init>", "()V", "mAuthorSpaceHeaderPlayer", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer;", "mAuthorSpaceFansWallPlayerFragment", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment;", "mModel", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderVideoModel;", "mVideoContainer", "Landroid/view/ViewGroup;", "mOriginSystemUI", "", "mMuteState", "", "prepare", "", "videoContainer", "uri", "Landroid/net/Uri;", "urlList", "", "", "observer", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "exitMiniWindow", "isDirectUrl", "isLooping", "isHideLoading", "isMiniWindowShowing", "pause", "forHeader", "resume", "playNext", "url", "release", "seekTo", "progress", "setMuteState", "mute", "setFullScreenState", "fullScreen", "createFansWallPlayer", "Landroidx/fragment/app/Fragment;", "callbacks", "setViewPortOffset", "offset", "registerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterProgressObserver", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "setPlayerStateListener", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$IPlayerStateListener;", "resetPlayerStateListener", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named("author_space_header_player")
public final class AuthorSpaceHeaderPlayerRouteService implements IAuthorSpaceHeaderPlayerService {
    public static final int $stable = 8;
    private AuthorSpaceFansWallPlayerFragment mAuthorSpaceFansWallPlayerFragment;
    private AuthorSpaceHeaderPlayer mAuthorSpaceHeaderPlayer;
    private AuthorSpaceHeaderVideoModel mModel;
    private boolean mMuteState = true;
    private int mOriginSystemUI;
    private ViewGroup mVideoContainer;

    public void prepare(ViewGroup videoContainer, Uri uri, List<String> list, final IAuthorSpaceHeaderPlayerService.RenderObserver observer, boolean exitMiniWindow, boolean isDirectUrl, boolean isLooping, boolean isHideLoading) {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer;
        Context it;
        Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Context context = videoContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mOriginSystemUI = UtilKt.requireFragmentActivity(context).getWindow().getDecorView().getSystemUiVisibility();
        release();
        Context context2 = videoContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        AuthorSpaceHeaderVideoModel model = (AuthorSpaceHeaderVideoModel) new ViewModelProvider(UtilKt.requireFragmentActivity(context2)).get(AuthorSpaceHeaderVideoModel.class);
        model.extractUri(uri, isDirectUrl);
        this.mModel = model;
        this.mVideoContainer = videoContainer;
        ViewGroup viewGroup = this.mVideoContainer;
        this.mAuthorSpaceHeaderPlayer = (viewGroup == null || (it = viewGroup.getContext()) == null) ? null : new AuthorSpaceHeaderPlayer(it);
        ViewGroup it2 = this.mVideoContainer;
        if (it2 != null && (authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer) != null) {
            authorSpaceHeaderPlayer.createAndPrepareNormalPlayer(list, it2, new IAuthorSpaceHeaderPlayerService.RenderObserver() { // from class: tv.danmaku.bili.ui.videospace.router.AuthorSpaceHeaderPlayerRouteService$prepare$2$1
                public void onVideoRenderStart(float videoRatio) {
                    AuthorSpaceHeaderPlayerRouteService.this.setFullScreenState(false);
                    observer.onVideoRenderStart(videoRatio);
                }

                public void onAudioRenderStart() {
                    observer.onAudioRenderStart();
                }

                public void onVideoPlayerRelease() {
                    observer.onVideoPlayerRelease();
                }
            }, exitMiniWindow, isLooping, isHideLoading);
        }
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer2 = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer2 != null) {
            authorSpaceHeaderPlayer2.setAspectRatio(AspectRatio.RATIO_ADJUST_CONTENT);
        }
    }

    public boolean isMiniWindowShowing() {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer != null) {
            return authorSpaceHeaderPlayer.isMiniWindowShowing();
        }
        return false;
    }

    public void pause(boolean forHeader) {
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.onPause();
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.pause();
        }
    }

    public void resume(boolean forHeader) {
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.onResume();
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.resume();
        }
    }

    public void playNext(String url, boolean forHeader) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.playNext(url);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.updateDataSource(url);
        }
    }

    public void release() {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer != null) {
            authorSpaceHeaderPlayer.releaseNormalPlayer();
        }
        this.mAuthorSpaceFansWallPlayerFragment = null;
    }

    public void seekTo(int progress, boolean forHeader) {
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.seekTo(progress);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.seekTo(progress);
        }
    }

    public void setMuteState(boolean mute, boolean forHeader) {
        this.mMuteState = mute;
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.setMuteState(mute);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.setMuteState(mute);
        }
    }

    public void setFullScreenState(boolean fullScreen) {
        Window window;
        View decorView;
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        boolean z = false;
        if (authorSpaceHeaderPlayer != null) {
            authorSpaceHeaderPlayer.setMuteState(!fullScreen && this.mMuteState);
        }
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer2 = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer2 != null) {
            authorSpaceHeaderPlayer2.setControllerEnable(fullScreen);
        }
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer3 = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer3 != null) {
            authorSpaceHeaderPlayer3.enableScreenGravity(fullScreen);
        }
        if (fullScreen) {
            NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
            ViewGroup viewGroup = this.mVideoContainer;
            navigationHelper.hideNavigationImmersive(UtilKt.findActivityOrNull(viewGroup != null ? viewGroup.getContext() : null));
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer4 = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer4 != null) {
                authorSpaceHeaderPlayer4.exitAllMiniFloatWindow();
            }
        } else {
            ViewGroup viewGroup2 = this.mVideoContainer;
            FragmentActivity findFragmentActivityOrNull = UtilKt.findFragmentActivityOrNull(viewGroup2 != null ? viewGroup2.getContext() : null);
            if (findFragmentActivityOrNull != null && (window = findFragmentActivityOrNull.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.setSystemUiVisibility(this.mOriginSystemUI);
            }
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer5 = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer5 != null && authorSpaceHeaderPlayer5.getPlayerState() == 5) {
                z = true;
            }
            if (z && !isMiniWindowShowing()) {
                resume(true);
            }
        }
        ViewGroup viewGroup3 = this.mVideoContainer;
        ViewParent parent = viewGroup3 != null ? viewGroup3.getParent() : null;
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.bilibili.app.authorspace.ui.widget.AuthorSpaceHeaderPlayerContainer");
        ((AuthorSpaceHeaderPlayerContainer) parent).setInterceptTouchEvent(!fullScreen);
    }

    public Fragment createFansWallPlayer(String uri, List<String> list, boolean isLooping, IAuthorSpaceHeaderPlayerService.RenderObserver callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.mAuthorSpaceFansWallPlayerFragment = new AuthorSpaceFansWallPlayerFragment();
        AuthorSpaceFansWallPlayerFragment $this$createFansWallPlayer_u24lambda_u240 = this.mAuthorSpaceFansWallPlayerFragment;
        if ($this$createFansWallPlayer_u24lambda_u240 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", uri);
            bundle.putBoolean("is_looping", isLooping);
            $this$createFansWallPlayer_u24lambda_u240.setArguments(bundle);
            $this$createFansWallPlayer_u24lambda_u240.setMObserver(callbacks);
            $this$createFansWallPlayer_u24lambda_u240.setMCdnUrlList(list);
        }
        Fragment fragment = this.mAuthorSpaceFansWallPlayerFragment;
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type tv.danmaku.bili.ui.videospace.AuthorSpaceFansWallPlayerFragment");
        return fragment;
    }

    public void setViewPortOffset(int offset, boolean forHeader) {
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.setViewPortOffset(offset);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.setViewPortOffset(offset);
        }
    }

    public void registerProgressObserver(PlayerProgressObserver observer, boolean forHeader) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.registerProgressObserver(observer);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.registerProgressObserver(observer);
        }
    }

    public void unregisterProgressObserver(PlayerProgressObserver observer, boolean forHeader) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.unregisterProgressObserver(observer);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.unregisterProgressObserver(observer);
        }
    }

    public void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener, boolean forHeader) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.addVideoPlayEventListener(listener);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.addVideoPlayEventListener(listener);
        }
    }

    public void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener, boolean forHeader) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (forHeader) {
            AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
            if (authorSpaceHeaderPlayer != null) {
                authorSpaceHeaderPlayer.removeVideoPlayEventListener(listener);
                return;
            }
            return;
        }
        AuthorSpaceFansWallPlayerFragment authorSpaceFansWallPlayerFragment = this.mAuthorSpaceFansWallPlayerFragment;
        if (authorSpaceFansWallPlayerFragment != null) {
            authorSpaceFansWallPlayerFragment.removeVideoPlayEventListener(listener);
        }
    }

    public void setPlayerStateListener(IAuthorSpaceHeaderPlayerService.IPlayerStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer != null) {
            authorSpaceHeaderPlayer.setPlayerStateListener(listener);
        }
    }

    public void resetPlayerStateListener() {
        AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer = this.mAuthorSpaceHeaderPlayer;
        if (authorSpaceHeaderPlayer != null) {
            authorSpaceHeaderPlayer.resetPlayerStateListener();
        }
    }
}