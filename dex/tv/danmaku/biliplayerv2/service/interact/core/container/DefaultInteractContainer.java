package tv.danmaku.biliplayerv2.service.interact.core.container;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DefaultInteractContainer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/container/DefaultInteractContainer;", "Ltv/danmaku/biliplayerv2/service/interact/core/container/IInteractContainer;", "<init>", "()V", "showDanmaku", "", "hideDanmaku", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultInteractContainer implements IInteractContainer {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DefaultInteractContainer";

    @Override // tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer
    public void showDanmaku() {
        BLog.d(TAG, "call show danmaku with [DefaultInteractContainer]");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer
    public void hideDanmaku() {
        BLog.d(TAG, "call hide danmaku with [DefaultInteractContainer]");
    }

    /* compiled from: DefaultInteractContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/container/DefaultInteractContainer$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}