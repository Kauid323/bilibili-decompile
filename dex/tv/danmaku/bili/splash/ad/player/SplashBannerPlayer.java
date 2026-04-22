package tv.danmaku.bili.splash.ad.player;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.player.dataprovider.SplashPlayableParamsV2;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;
import tv.danmaku.video.bilicardplayer.player.PlayerExtraConfiguration;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: SplashBannerPlayer.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\r\u0010)\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010*J\u001c\u0010/\u001a\u00020\r2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020\r0\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010\u0018R\u0011\u0010-\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b.\u0010\u0018¨\u00062"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;", "", "fragment", "Landroidx/fragment/app/Fragment;", "container", "Landroid/view/ViewGroup;", "localVideoUri", "", "cid", "", "avid", "onInitPlayerReporter", "Lkotlin/Function1;", "", "onRegisterStateCallback", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Ljava/lang/String;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getContainer", "()Landroid/view/ViewGroup;", "getLocalVideoUri", "()Ljava/lang/String;", "getCid", "()J", "getAvid", "token", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "playerScene", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene;", "SIZE_IGNORE_MODEL_CHANGE", "", "monitorJob", "Lkotlinx/coroutines/Job;", "value", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "task", "getTask", "()Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "play", "stop", "sharePlayer", "()Ljava/lang/Integer;", "currentPosition", "getCurrentPosition", "duration", "getDuration", "takeSnapshot", "onCaptured", "Landroid/graphics/Bitmap;", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashBannerPlayer {
    public static final int $stable = 8;
    private final int SIZE_IGNORE_MODEL_CHANGE;
    private final long avid;
    private final long cid;
    private final ViewGroup container;
    private final Fragment fragment;
    private final String localVideoUri;
    private Job monitorJob;
    private BiliCardPlayerScene playerScene;
    private BiliCardPlayerScene.CardPlayTask task;
    private BiliCardPlayerScene.CardPlayTask.Token token;

    public SplashBannerPlayer(Fragment fragment, ViewGroup container, String localVideoUri, long cid, long avid, Function1<? super SplashBannerPlayer, Unit> function1, Function1<? super SplashBannerPlayer, Unit> function12) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(localVideoUri, "localVideoUri");
        Intrinsics.checkNotNullParameter(function1, "onInitPlayerReporter");
        Intrinsics.checkNotNullParameter(function12, "onRegisterStateCallback");
        this.fragment = fragment;
        this.container = container;
        this.localVideoUri = localVideoUri;
        this.cid = cid;
        this.avid = avid;
        this.SIZE_IGNORE_MODEL_CHANGE = -3;
        this.task = BiliCardPlayerScene.CardPlayTask.Companion.obtain();
        function1.invoke(this);
        function12.invoke(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SplashBannerPlayer(Fragment fragment, ViewGroup viewGroup, String str, long j, long j2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, viewGroup, str, r7, r9, function1, function12);
        long j3;
        long j4;
        if ((i & 8) == 0) {
            j3 = j;
        } else {
            j3 = 0;
        }
        if ((i & 16) == 0) {
            j4 = j2;
        } else {
            j4 = 0;
        }
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final String getLocalVideoUri() {
        return this.localVideoUri;
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final BiliCardPlayerScene.CardPlayTask getTask() {
        return this.task;
    }

    public final void play() {
        BiliCardPlayerScene.CardPlayTask task = this.task;
        if (task == null) {
            return;
        }
        task.setContainer(this.container).setShowWhenFirstRender(true).setMute(true).setNetworkToastEnable(false).setCommonResolveTaskProvider(GAdCoreKt.getGAdPlayer().getResolveTaskProvider()).addPlayableParams(new SplashPlayableParamsV2(this.cid, this.avid, this.localVideoUri));
        BiliCardPlayerScene $this$play_u24lambda_u240 = BiliCardPlayerManager.INSTANCE.with(this.fragment);
        PlayerExtraConfiguration $this$play_u24lambda_u240_u240 = new PlayerExtraConfiguration();
        $this$play_u24lambda_u240_u240.setKeepRender(true);
        $this$play_u24lambda_u240.setPlayerExtraConfiguration($this$play_u24lambda_u240_u240);
        this.playerScene = $this$play_u24lambda_u240;
        BiliCardPlayerScene scene = this.playerScene;
        if (scene == null) {
            return;
        }
        BiliCardPlayerScene.CardPlayTask.Token $this$play_u24lambda_u241 = scene.commit(task);
        $this$play_u24lambda_u241.hideBufferingView();
        $this$play_u24lambda_u241.setAspectRatio(AspectRatio.RATIO_CENTER_CROP);
        this.token = $this$play_u24lambda_u241;
        this.fragment.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.splash.ad.player.SplashBannerPlayer$play$3
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
                SplashBannerPlayer.this.getFragment().getLifecycle().removeObserver((LifecycleObserver) this);
                SplashBannerPlayer.this.stop();
            }
        });
    }

    public final void stop() {
        Job job = this.monitorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.monitorJob = null;
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            token.stop();
        }
        BiliCardPlayerScene biliCardPlayerScene = this.playerScene;
        if (biliCardPlayerScene != null) {
            biliCardPlayerScene.release();
        }
        this.playerScene = null;
        this.task = null;
    }

    public final Integer sharePlayer() {
        BiliCardPlayerScene biliCardPlayerScene = this.playerScene;
        if (biliCardPlayerScene != null) {
            Integer valueOf = Integer.valueOf(biliCardPlayerScene.prepareForShare(true));
            int it = valueOf.intValue();
            if (it > 0) {
                return valueOf;
            }
            return null;
        }
        return null;
    }

    public final long getCurrentPosition() {
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            return token.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            return token.getDuration();
        }
        return 0L;
    }

    public final void takeSnapshot(Function1<? super Bitmap, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onCaptured");
        LifecycleOwner activity = this.fragment.getActivity();
        CoroutineScope scope = activity != null ? LifecycleOwnerKt.getLifecycleScope(activity) : null;
        if (this.token != null) {
            boolean z = false;
            if (scope != null && CoroutineScopeKt.isActive(scope)) {
                z = true;
            }
            if (z) {
                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SplashBannerPlayer$takeSnapshot$1(function1, this, null), 3, (Object) null);
                return;
            }
        }
        function1.invoke((Object) null);
    }
}