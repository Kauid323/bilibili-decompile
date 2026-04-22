package tv.danmaku.bili.ui.theme;

import com.bilibili.lib.gripper.api.internal.ProducerLambda;
import com.bilibili.moduleservice.main.ThemeService;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class ThemeServiceImplKt$$themeServiceProducer$$Lambda extends ProducerLambda<ThemeService> {
    public ThemeServiceImplKt$$themeServiceProducer$$Lambda(Continuation<?> completion) {
        super(completion);
    }

    protected Object invokeProducer() {
        return ThemeServiceImplKt.themeServiceProducer();
    }

    @Nonnull
    public Continuation<Unit> create(@Nonnull Continuation<?> completion) {
        return new ThemeServiceImplKt$$themeServiceProducer$$Lambda(completion);
    }
}