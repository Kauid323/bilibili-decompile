package tv.danmaku.bili.appwidget;

import com.bilibili.app.history.di.AutoAddWidgetInterface;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddWidgetModule_ProvideAutoAddWidgetFactory implements Factory<AutoAddWidgetInterface> {
    private final AddWidgetModule module;

    private AddWidgetModule_ProvideAutoAddWidgetFactory(AddWidgetModule module) {
        this.module = module;
    }

    /* renamed from: get */
    public AutoAddWidgetInterface m672get() {
        return provideAutoAddWidget(this.module);
    }

    public static AddWidgetModule_ProvideAutoAddWidgetFactory create(AddWidgetModule module) {
        return new AddWidgetModule_ProvideAutoAddWidgetFactory(module);
    }

    public static AutoAddWidgetInterface provideAutoAddWidget(AddWidgetModule instance) {
        return (AutoAddWidgetInterface) Preconditions.checkNotNullFromProvides(instance.provideAutoAddWidget());
    }
}