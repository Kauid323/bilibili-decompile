package im.setting;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lim/setting/IMSettingPageState;", "", "routerState", "Lkntr/base/router/Router;", "onAction", "Lim/setting/IMSettingActionHandler;", "<init>", "(Lkntr/base/router/Router;Lim/setting/IMSettingActionHandler;)V", "eventHandler", "Lim/setting/IMSettingEventHandler;", "getEventHandler", "()Lim/setting/IMSettingEventHandler;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingPageState {
    public static final int $stable = 0;
    private final IMSettingEventHandler eventHandler;

    public IMSettingPageState(final Router routerState, IMSettingActionHandler onAction) {
        Intrinsics.checkNotNullParameter(routerState, "routerState");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.eventHandler = new IMSettingEventHandler(new IMSettingRouteHandler() { // from class: im.setting.IMSettingPageState$eventHandler$1
            @Override // im.setting.IMSettingRouteHandler
            public final Object invoke(Uri url, Continuation<? super Unit> continuation) {
                routerState.launch(url);
                return Unit.INSTANCE;
            }
        }, onAction);
    }

    public final IMSettingEventHandler getEventHandler() {
        return this.eventHandler;
    }
}