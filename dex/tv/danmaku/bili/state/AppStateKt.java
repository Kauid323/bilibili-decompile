package tv.danmaku.bili.state;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.gripper.api.PreTrigger;
import com.bilibili.module.state.PlayState;
import com.bilibili.module.state.PlayStateUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.ijk.media.player.IPlayerManager;
import tv.danmaku.ijk.media.player.IjkPlayerManager;

/* compiled from: AppState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"registerPlayState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppStateKt {
    @PreTrigger(trigger = "OnPrivacyAllowed")
    public static final Object registerPlayState(Continuation<? super Unit> continuation) {
        BLog.i("InnerPush", "registerPlayState");
        boolean enable = Intrinsics.areEqual(DeviceDecision.INSTANCE.dd("dd.inner_push_register_play_state", "1"), "1");
        if (!enable) {
            BLog.i("InnerPush", "registerPlayState disabled");
            return Unit.INSTANCE;
        }
        final PlayStateUpdater playStateUpdater = (PlayStateUpdater) BLRouter.get$default(BLRouter.INSTANCE, PlayStateUpdater.class, (String) null, 2, (Object) null);
        IjkPlayerManager.getInstance().registerListener(new IPlayerManager.OnPlayerActivityChangeListener() { // from class: tv.danmaku.bili.state.AppStateKt$$ExternalSyntheticLambda0
            public final void onPlayerActivityChange(boolean z) {
                AppStateKt.registerPlayState$lambda$0(playStateUpdater, z);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerPlayState$lambda$0(PlayStateUpdater $playStateUpdater, boolean isPlaying) {
        BLog.i("InnerPush", "registerPlayState state change, isPlaying = " + isPlaying);
        PlayState info = (PlayState) (isPlaying ? PlayState.PLAYING.INSTANCE : PlayState.IDLE.INSTANCE);
        if ($playStateUpdater != null) {
            $playStateUpdater.update(info);
        }
    }
}