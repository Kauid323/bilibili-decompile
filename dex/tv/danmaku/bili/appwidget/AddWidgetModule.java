package tv.danmaku.bili.appwidget;

import com.bilibili.app.history.di.AutoAddWidgetInterface;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: AddWidgetModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/appwidget/AddWidgetModule;", "", "<init>", "()V", "provideAutoAddWidget", "Lcom/bilibili/app/history/di/AutoAddWidgetInterface;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Module
public final class AddWidgetModule {
    public static final int $stable = 0;

    @Provides
    public final AutoAddWidgetInterface provideAutoAddWidget() {
        return new AutoAddWidget();
    }
}