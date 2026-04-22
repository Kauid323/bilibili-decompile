package kntr.app.digital.preview.usage;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.DigitalSpNameKt;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.serialization.internal.BooleanSerializer;

/* compiled from: AppWidgetActionModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/usage/AppWidgetActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "appWidgetBadgeShowed", "getAppWidgetBadgeShowed", "()Z", "setAppWidgetBadgeShowed", "(Z)V", "appWidgetBadgeShowed$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "router", "Lkntr/base/router/Router;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class AppWidgetActionModule {
    public static final int $stable;
    private static final SerializableSharedPreferencesProperty appWidgetBadgeShowed$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AppWidgetActionModule.class, "appWidgetBadgeShowed", "getAppWidgetBadgeShowed()Z", 0))};
    public static final AppWidgetActionModule INSTANCE = new AppWidgetActionModule();

    private AppWidgetActionModule() {
    }

    public final boolean getAppWidgetBadgeShowed() {
        return ((Boolean) appWidgetBadgeShowed$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setAppWidgetBadgeShowed(boolean z) {
        appWidgetBadgeShowed$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean appWidgetBadgeShowed_delegate$lambda$0() {
        return false;
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        return new ActionModule<AppWidgetAction>() { // from class: kntr.app.digital.preview.usage.AppWidgetActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<AppWidgetAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(AppWidgetAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<AppWidgetAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                AppWidgetActionModule.INSTANCE.setAppWidgetBadgeShowed(true);
                router.launch(UrisKt.toUri(action.getData().getLink()));
            }
        };
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.app.digital.preview.usage.AppWidgetActionModule$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean appWidgetBadgeShowed_delegate$lambda$0;
                appWidgetBadgeShowed_delegate$lambda$0 = AppWidgetActionModule.appWidgetBadgeShowed_delegate$lambda$0();
                return Boolean.valueOf(appWidgetBadgeShowed_delegate$lambda$0);
            }
        };
        appWidgetBadgeShowed$delegate = new SerializableSharedPreferencesProperty(DigitalSpNameKt.SP_NAME, false, BooleanSerializer.INSTANCE, "app_widget_enter_badge_showed", initializer$iv, (Function2) null);
        $stable = 8;
    }
}