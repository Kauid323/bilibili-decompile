package tv.danmaku.biliplayerv2.service.business;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommonBusinessServiceConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/business/ServiceElement;", "", "descriptor", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "startMode", "Ltv/danmaku/biliplayerv2/service/business/StartMode;", "<init>", "(Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;Ltv/danmaku/biliplayerv2/service/business/StartMode;)V", "getDescriptor", "()Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "getStartMode", "()Ltv/danmaku/biliplayerv2/service/business/StartMode;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ServiceElement {
    private final PlayerServiceManager.ServiceDescriptor<?> descriptor;
    private final StartMode startMode;

    public ServiceElement(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor, StartMode startMode) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(startMode, "startMode");
        this.descriptor = serviceDescriptor;
        this.startMode = startMode;
    }

    public /* synthetic */ ServiceElement(PlayerServiceManager.ServiceDescriptor serviceDescriptor, StartMode startMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serviceDescriptor, (i & 2) != 0 ? StartMode.Normal : startMode);
    }

    public final PlayerServiceManager.ServiceDescriptor<?> getDescriptor() {
        return this.descriptor;
    }

    public final StartMode getStartMode() {
        return this.startMode;
    }
}