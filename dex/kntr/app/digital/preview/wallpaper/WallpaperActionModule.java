package kntr.app.digital.preview.wallpaper;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.DigitalSpNameKt;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.image.ImageCard;
import kntr.app.digital.preview.save.Save_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.internal.BooleanSerializer;

/* compiled from: WallpaperActionModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "wallpaperSettingsShowed", "getWallpaperSettingsShowed", "()Z", "setWallpaperSettingsShowed", "(Z)V", "wallpaperSettingsShowed$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "wallpaperDialogService", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class WallpaperActionModule {
    public static final int $stable;
    private static final SerializableSharedPreferencesProperty wallpaperSettingsShowed$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WallpaperActionModule.class, "wallpaperSettingsShowed", "getWallpaperSettingsShowed()Z", 0))};
    public static final WallpaperActionModule INSTANCE = new WallpaperActionModule();

    private WallpaperActionModule() {
    }

    public final boolean getWallpaperSettingsShowed() {
        return ((Boolean) wallpaperSettingsShowed$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setWallpaperSettingsShowed(boolean z) {
        wallpaperSettingsShowed$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wallpaperSettingsShowed_delegate$lambda$0() {
        return false;
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(@BusinessCoroutineScope final CoroutineScope coroutineScope, final WallpaperSettingsDialogService wallpaperDialogService, final DigitalCardStateService cardStateService, final KomponentScope<? super Unit> komponentScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(wallpaperDialogService, "wallpaperDialogService");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        return new ActionModule<WallpaperAction>() { // from class: kntr.app.digital.preview.wallpaper.WallpaperActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<WallpaperAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(WallpaperAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<WallpaperAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                WallpaperActionModule.INSTANCE.setWallpaperSettingsShowed(true);
                boolean isImageCard = DigitalCardStateService.this.getCurrentCardItem().getData() instanceof ImageCard;
                if (WallpaperSetting_androidKt.getHasWallpaperDialog()) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WallpaperActionModule$provide$1$1(wallpaperDialogService, isImageCard, action, null), 3, (Object) null);
                } else if (!StringsKt.isBlank(action.getData().getDownloadVideoLink())) {
                    Save_androidKt.getSave().saveVideo(komponentScope, action.getData().getDownloadImageLink(), CollectionsKt.listOf(action.getData().getDownloadVideoLink()));
                } else {
                    Save_androidKt.getSave().saveImage(komponentScope, action.getData().getDownloadImageLink());
                }
            }
        };
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.app.digital.preview.wallpaper.WallpaperActionModule$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean wallpaperSettingsShowed_delegate$lambda$0;
                wallpaperSettingsShowed_delegate$lambda$0 = WallpaperActionModule.wallpaperSettingsShowed_delegate$lambda$0();
                return Boolean.valueOf(wallpaperSettingsShowed_delegate$lambda$0);
            }
        };
        wallpaperSettingsShowed$delegate = new SerializableSharedPreferencesProperty(DigitalSpNameKt.SP_NAME, false, BooleanSerializer.INSTANCE, "digital_card_wallpaper_settings_showed", initializer$iv, (Function2) null);
        $stable = 8;
    }
}