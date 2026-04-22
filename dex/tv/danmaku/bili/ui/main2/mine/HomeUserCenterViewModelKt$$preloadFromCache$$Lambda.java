package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class HomeUserCenterViewModelKt$$preloadFromCache$$Lambda extends ProducerLambda<Unit> {
    public HomeUserCenterViewModelKt$$preloadFromCache$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        HomeUserCenterViewModelKt.preloadFromCache();
        return Unit.INSTANCE;
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new HomeUserCenterViewModelKt$$preloadFromCache$$Lambda(completion);
    }
}