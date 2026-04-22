package im.session.observer;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import im.base.IMLog;
import im.session.log.LogTagKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionEventObserver.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lim/session/observer/DefaultSessionObserverModule;", "", "<init>", "()V", "provideDefaultSessionObserver", "Lim/session/observer/IMSessionEventObserver;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class DefaultSessionObserverModule {
    public static final DefaultSessionObserverModule INSTANCE = new DefaultSessionObserverModule();

    private DefaultSessionObserverModule() {
    }

    @Provides
    @IntoSet
    public final IMSessionEventObserver provideDefaultSessionObserver() {
        return new IMSessionEventObserver() { // from class: im.session.observer.DefaultSessionObserverModule$provideDefaultSessionObserver$1
            @Override // im.session.observer.IMSessionEventObserver
            public void onPageInitialed(KSessionPageType pageType) {
                Intrinsics.checkNotNullParameter(pageType, "pageType");
                IMLog.Companion.i(LogTagKt.SessionLogTag, "页面初始化(onPageInitialed): " + pageType);
            }

            @Override // im.session.observer.IMSessionEventObserver
            public void onPageFirstLoaded(KSessionPageType pageType) {
                Intrinsics.checkNotNullParameter(pageType, "pageType");
                IMLog.Companion.i(LogTagKt.SessionLogTag, "页面首次加载(onPageFirstLoaded): " + pageType);
            }

            @Override // im.session.observer.IMSessionEventObserver
            public void onPageClosed(KSessionPageType pageType) {
                Intrinsics.checkNotNullParameter(pageType, "pageType");
                IMLog.Companion.i(LogTagKt.SessionLogTag, "会话页关闭(onPageClosed): " + pageType);
            }
        };
    }
}