package video.biz.offline.base.infra.download.tasks;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.rank.view.ViewHolderUgcKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MediaTask.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"thirdPartFrom", "", "", "getThirdPartFrom", "(Ljava/lang/String;)Z", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaTaskKt {
    public static final /* synthetic */ boolean access$getThirdPartFrom(String $receiver) {
        return getThirdPartFrom($receiver);
    }

    public static final boolean getThirdPartFrom(String $this$thirdPartFrom) {
        boolean inner = StringsKt.startsWith$default($this$thirdPartFrom, "vupload", false, 2, (Object) null) || StringsKt.startsWith$default($this$thirdPartFrom, ViewHolderUgcKt.GOTO_BANGUMI, false, 2, (Object) null) || StringsKt.startsWith$default($this$thirdPartFrom, "movie", false, 2, (Object) null);
        return !inner;
    }
}