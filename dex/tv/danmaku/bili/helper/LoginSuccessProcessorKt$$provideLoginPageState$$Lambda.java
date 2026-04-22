package tv.danmaku.bili.helper;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import com.bilibili.login.LoginPageStateHolder;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class LoginSuccessProcessorKt$$provideLoginPageState$$Lambda extends ProducerLambda<LoginPageStateHolder> {
    public LoginSuccessProcessorKt$$provideLoginPageState$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        return LoginSuccessProcessorKt.provideLoginPageState();
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new LoginSuccessProcessorKt$$provideLoginPageState$$Lambda(completion);
    }
}