package kntr.common.language.settings;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.Translation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: LanguageSettingsService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"mLanguageSettingsService", "Lkntr/common/language/settings/LanguageSettingsService;", "getMLanguageSettingsService", "()Lkntr/common/language/settings/LanguageSettingsService;", "mLanguageSettingsService$delegate", "Lkotlin/Lazy;", "applyLanguageSettings", "", "locale", "Lkntr/base/localization/Locale;", "translate", "", "language-settings_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LanguageSettingsServiceKt {
    private static final Lazy mLanguageSettingsService$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.language.settings.LanguageSettingsServiceKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            LanguageSettingsService mLanguageSettingsService_delegate$lambda$0;
            mLanguageSettingsService_delegate$lambda$0 = LanguageSettingsServiceKt.mLanguageSettingsService_delegate$lambda$0();
            return mLanguageSettingsService_delegate$lambda$0;
        }
    });

    private static final LanguageSettingsService getMLanguageSettingsService() {
        return (LanguageSettingsService) mLanguageSettingsService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LanguageSettingsService mLanguageSettingsService_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((LanguageSettingsEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(LanguageSettingsEntryPoint.class))).getLanguageSettingsService();
    }

    public static /* synthetic */ void applyLanguageSettings$default(Locale locale, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Localization.INSTANCE.getCurrent();
        }
        if ((i & 2) != 0) {
            z = Translation.INSTANCE.getUserEnabled();
        }
        applyLanguageSettings(locale, z);
    }

    public static final void applyLanguageSettings(Locale locale, boolean translate) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Locale appLocale = Localization.INSTANCE.getCurrent();
        boolean appTranslationEnabled = Translation.INSTANCE.getUserEnabled();
        if (Intrinsics.areEqual(appLocale, locale) && appTranslationEnabled == translate) {
            return;
        }
        Localization.INSTANCE.setCurrent(locale);
        Translation.INSTANCE.setUserEnabled(translate);
        getMLanguageSettingsService().reloadApp();
    }
}