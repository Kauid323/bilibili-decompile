package im.session.di;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.Module;
import dagger.Provides;
import im.session.IMSessionStateMachine;
import im.session.IMSessionViewModel;
import im.session.IMSessionViewModelImpl;
import im.session.observer.IMSessionEventObserver;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSessionViewModelModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\rH\u0007¨\u0006\u0010"}, d2 = {"Lim/session/di/IMSessionViewModelModule;", "", "<init>", "()V", "provideViewModel", "Lim/session/IMSessionViewModel;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateMachine", "Lim/session/IMSessionStateMachine;", "observers", "", "Lim/session/observer/IMSessionEventObserver;", "Lkotlin/jvm/JvmSuppressWildcards;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class IMSessionViewModelModule {
    public static final IMSessionViewModelModule INSTANCE = new IMSessionViewModelModule();

    private IMSessionViewModelModule() {
    }

    @Provides
    public final IMSessionViewModel provideViewModel(KSessionPageType pageType, @IMSessionCoroutineScope CoroutineScope scope, IMSessionStateMachine stateMachine, Set<IMSessionEventObserver> set) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(set, "observers");
        return new IMSessionViewModelImpl(pageType, scope, stateMachine, set);
    }
}