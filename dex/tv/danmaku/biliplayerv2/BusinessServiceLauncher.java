package tv.danmaku.biliplayerv2;

import android.os.Looper;
import android.os.MessageQueue;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IPlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.business.ServiceElement;
import tv.danmaku.biliplayerv2.service.business.StartMode;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BusinessServiceLauncher.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerv2/BusinessServiceLauncher;", "", "mPlayerServiceManager", "Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;", "<init>", "(Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;)V", "mPendingStartServices", "", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "mPendingServiceIdleHandler", "Landroid/os/MessageQueue$IdleHandler;", "launch", "", "serviceElements", "", "Ltv/danmaku/biliplayerv2/service/business/ServiceElement;", "release", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BusinessServiceLauncher {
    private final MessageQueue.IdleHandler mPendingServiceIdleHandler;
    private final List<PlayerServiceManager.ServiceDescriptor<?>> mPendingStartServices;
    private final IPlayerServiceManager mPlayerServiceManager;

    public BusinessServiceLauncher(IPlayerServiceManager mPlayerServiceManager) {
        Intrinsics.checkNotNullParameter(mPlayerServiceManager, "mPlayerServiceManager");
        this.mPlayerServiceManager = mPlayerServiceManager;
        this.mPendingStartServices = new LinkedList();
        this.mPendingServiceIdleHandler = new MessageQueue.IdleHandler() { // from class: tv.danmaku.biliplayerv2.BusinessServiceLauncher$$ExternalSyntheticLambda0
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean mPendingServiceIdleHandler$lambda$0;
                mPendingServiceIdleHandler$lambda$0 = BusinessServiceLauncher.mPendingServiceIdleHandler$lambda$0(BusinessServiceLauncher.this);
                return mPendingServiceIdleHandler$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mPendingServiceIdleHandler$lambda$0(BusinessServiceLauncher this$0) {
        Iterable $this$forEach$iv = this$0.mPendingStartServices;
        for (Object element$iv : $this$forEach$iv) {
            PlayerServiceManager.ServiceDescriptor it = (PlayerServiceManager.ServiceDescriptor) element$iv;
            this$0.mPlayerServiceManager.startService(it);
        }
        return false;
    }

    public final void launch(List<ServiceElement> list) {
        Iterable serviceElements = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(serviceElements, "serviceElements");
        Iterable $this$forEach$iv = serviceElements;
        for (Object element$iv : $this$forEach$iv) {
            ServiceElement it = (ServiceElement) element$iv;
            if (it.getStartMode() == StartMode.Immediately) {
                this.mPlayerServiceManager.startService(it.getDescriptor());
            } else if (it.getStartMode() == StartMode.Normal) {
                this.mPendingStartServices.add(it.getDescriptor());
            }
        }
        Iterable $this$forEach$iv2 = this.mPendingStartServices;
        if (!((Collection) $this$forEach$iv2).isEmpty()) {
            Looper.myQueue().addIdleHandler(this.mPendingServiceIdleHandler);
        }
    }

    public final void release() {
        Looper.myQueue().removeIdleHandler(this.mPendingServiceIdleHandler);
    }
}