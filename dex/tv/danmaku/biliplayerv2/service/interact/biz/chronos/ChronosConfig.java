package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosConfig;", "", "<init>", "()V", "chronosScene", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "getChronosScene", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "setChronosScene", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;)V", "chronosBiz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "getChronosBiz", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "setChronosBiz", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;)V", "layerSupportSurfaceView", "", "getLayerSupportSurfaceView", "()Z", "setLayerSupportSurfaceView", "(Z)V", "chronosUseSurfaceView", "getConfig", "key", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosConfig {
    private boolean layerSupportSurfaceView;
    private ChronosScene chronosScene = ChronosScene.SCENE_UNKNOWN;
    private ChronosBiz chronosBiz = ChronosBiz.BIZ_UNKNOWM;

    public final ChronosScene getChronosScene() {
        return this.chronosScene;
    }

    public final void setChronosScene(ChronosScene chronosScene) {
        Intrinsics.checkNotNullParameter(chronosScene, "<set-?>");
        this.chronosScene = chronosScene;
    }

    public final ChronosBiz getChronosBiz() {
        return this.chronosBiz;
    }

    public final void setChronosBiz(ChronosBiz chronosBiz) {
        Intrinsics.checkNotNullParameter(chronosBiz, "<set-?>");
        this.chronosBiz = chronosBiz;
    }

    public final boolean getLayerSupportSurfaceView() {
        return this.layerSupportSurfaceView;
    }

    public final void setLayerSupportSurfaceView(boolean z) {
        this.layerSupportSurfaceView = z;
    }

    public final boolean chronosUseSurfaceView() {
        return this.layerSupportSurfaceView;
    }

    public final boolean getConfig(String key) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, "$enable_dfm_feature$") || (bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), key, (Object) null, 2, (Object) null)) == null) {
            return true;
        }
        return bool.booleanValue();
    }
}