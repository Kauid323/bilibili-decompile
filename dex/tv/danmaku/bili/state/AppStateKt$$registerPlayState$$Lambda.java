package tv.danmaku.bili.state;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class AppStateKt$$registerPlayState$$Lambda extends ProducerLambda<Unit> {
    public AppStateKt$$registerPlayState$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        return AppStateKt.registerPlayState(this);
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new AppStateKt$$registerPlayState$$Lambda(completion);
    }
}