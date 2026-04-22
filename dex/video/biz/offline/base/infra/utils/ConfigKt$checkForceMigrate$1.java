package video.biz.offline.base.infra.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.P2P;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Config.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.utils.ConfigKt", f = "Config.kt", i = {0, 0, 0, 0}, l = {281}, m = "checkForceMigrate", n = {"block", "map", P2P.KEY_EXT_P2P_BUVID, "targetVersion"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class ConfigKt$checkForceMigrate$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigKt$checkForceMigrate$1(Continuation<? super ConfigKt$checkForceMigrate$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConfigKt.checkForceMigrate(null, (Continuation) this);
    }
}