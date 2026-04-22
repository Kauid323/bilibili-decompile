package tv.danmaku.biliplayerv2.injection;

import dagger.MembersInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ServiceInjectorByPlayerContainer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/injection/PlayerServiceMembersInjectorWrapper;", "T", "", "injector", "Ldagger/MembersInjector;", "<init>", "(Ldagger/MembersInjector;)V", "injectMembers", "", "any", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerServiceMembersInjectorWrapper<T> {
    private final MembersInjector<T> injector;

    public PlayerServiceMembersInjectorWrapper(MembersInjector<T> membersInjector) {
        Intrinsics.checkNotNullParameter(membersInjector, "injector");
        this.injector = membersInjector;
    }

    public final void injectMembers(Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        if (any != null) {
            this.injector.injectMembers(any);
            return;
        }
        BLog.w("PlayerServiceMembersInjectorWrapper", "widget is not instance of " + any.getClass());
    }
}