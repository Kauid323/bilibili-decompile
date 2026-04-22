package tv.danmaku.biliplayerv2;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IPlayerShareInterceptor;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.share.SharableObject;

/* compiled from: PlayerSharingBundle.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0007J#\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "", "<init>", "()V", "mSharableObjects", "", "", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "mBundle", "Landroid/os/Bundle;", "mConsumerInterceptor", "Ltv/danmaku/biliplayerv2/service/IPlayerShareInterceptor;", "setInterceptorByConsumer", "", "interceptor", "getAndRemoveInterceptor", "putSharableObject", "key", "obj", "getSharableObject", "T", "needRemoved", "", "(Ljava/lang/String;Z)Ljava/lang/Object;", "getPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "sharedObject", "getBundle", "value", "Ltv/danmaku/biliplayerv2/PlayerSharedState;", "playerSharedState", "getPlayerSharedState", "()Ltv/danmaku/biliplayerv2/PlayerSharedState;", "setPlayerSharedState", "(Ltv/danmaku/biliplayerv2/PlayerSharedState;)V", "clearAll", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerSharingBundle {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SHARE_KEEP_RENDER = "key_share_keep_render";
    private IPlayerShareInterceptor mConsumerInterceptor;
    private final Map<String, SharableObject> mSharableObjects = new HashMap();
    private final Bundle mBundle = new Bundle();

    public final void setInterceptorByConsumer(IPlayerShareInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.mConsumerInterceptor = interceptor;
    }

    public final IPlayerShareInterceptor getAndRemoveInterceptor() {
        IPlayerShareInterceptor interceptor = this.mConsumerInterceptor;
        this.mConsumerInterceptor = null;
        return interceptor;
    }

    public final void putSharableObject(String key, SharableObject obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.mSharableObjects.put(key, obj);
    }

    public static /* synthetic */ Object getSharableObject$default(PlayerSharingBundle playerSharingBundle, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return playerSharingBundle.getSharableObject(str, z);
    }

    public final <T> T getSharableObject(String key, boolean needRemoved) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, SharableObject> map = this.mSharableObjects;
        return (T) (needRemoved ? map.remove(key) : map.get(key));
    }

    public static /* synthetic */ Video.PlayableParams getPlayableParams$default(PlayerSharingBundle playerSharingBundle, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return playerSharingBundle.getPlayableParams(z);
    }

    public final Video.PlayableParams getPlayableParams(boolean needRemoved) {
        return (Video.PlayableParams) getSharableObject("key_share_player_playable_params", needRemoved);
    }

    public final boolean sharedObject(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mSharableObjects.get(key) != null;
    }

    public final Bundle getBundle() {
        return this.mBundle;
    }

    public final void setPlayerSharedState(PlayerSharedState value) {
        this.mBundle.putParcelable(PlayerSharedState.class.getName(), value);
    }

    public final PlayerSharedState getPlayerSharedState() {
        return (PlayerSharedState) PlayerSharingBundleKt.getParcelableCompat(this.mBundle, PlayerSharedState.class.getName(), PlayerSharedState.class);
    }

    public final void clearAll() {
        this.mSharableObjects.clear();
        this.mBundle.clear();
    }

    /* compiled from: PlayerSharingBundle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerSharingBundle$Companion;", "", "<init>", "()V", "KEY_SHARE_KEEP_RENDER", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}