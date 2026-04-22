package kntr.base.localization;

import android.app.LocaleManager;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.gripper.api.log.GLog;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZone;

/* compiled from: Localization.android.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0013\u001a\u00020\u0003H\u0003\u001a\b\u0010\u0014\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\u0017\u001a\u00020\u00012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0087@¢\u0006\u0002\u0010\u001a\"\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000b\u0010\r\"\u0014\u0010\u000f\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\"\u001b\u0010\u0011\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\r¨\u0006\u001b"}, d2 = {"applyLocale", "", "locale", "Lkntr/base/localization/Locale;", "getSystemLocale", "SystemTimeZone", "Lkotlinx/datetime/TimeZone;", "getSystemTimeZone", "()Lkotlinx/datetime/TimeZone;", "SystemTimeZone$delegate", "Lkotlin/Lazy;", "isHD", "", "()Z", "isHD$delegate", "enableLocalization", "getEnableLocalization", "isMainProcess", "isMainProcess$delegate", "getSystemLocaleAPI33", "getSystemLocaleAPI32", "setAppLocaleAPI33", "setAppLocaleAPI32", "initLocalization", "log", "Lcom/bilibili/gripper/api/log/GLog;", "(Lcom/bilibili/gripper/api/log/GLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Localization_androidKt {
    private static final Lazy SystemTimeZone$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization_androidKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            TimeZone SystemTimeZone_delegate$lambda$0;
            SystemTimeZone_delegate$lambda$0 = Localization_androidKt.SystemTimeZone_delegate$lambda$0();
            return SystemTimeZone_delegate$lambda$0;
        }
    });
    private static final Lazy isHD$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization_androidKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean isHD_delegate$lambda$0;
            isHD_delegate$lambda$0 = Localization_androidKt.isHD_delegate$lambda$0();
            return Boolean.valueOf(isHD_delegate$lambda$0);
        }
    });
    private static final Lazy isMainProcess$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization_androidKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean isMainProcess_delegate$lambda$0;
            isMainProcess_delegate$lambda$0 = Localization_androidKt.isMainProcess_delegate$lambda$0();
            return Boolean.valueOf(isMainProcess_delegate$lambda$0);
        }
    });

    public static final void applyLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        FoundationAlias.getFapp().getResources().getConfiguration().setLocale(locale.getPlatformLocale$localization_debug());
        if (Build.VERSION.SDK_INT >= 24) {
            android.os.LocaleList.setDefault(new android.os.LocaleList(locale.getPlatformLocale$localization_debug()));
        } else {
            java.util.Locale.setDefault(locale.getPlatformLocale$localization_debug());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            setAppLocaleAPI33(locale);
        } else {
            setAppLocaleAPI32(locale);
        }
    }

    public static final Locale getSystemLocale() {
        if (Build.VERSION.SDK_INT >= 33) {
            return getSystemLocaleAPI33();
        }
        return getSystemLocaleAPI32();
    }

    public static final TimeZone getSystemTimeZone() {
        return (TimeZone) SystemTimeZone$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeZone SystemTimeZone_delegate$lambda$0() {
        return TimeZone.Companion.currentSystemDefault();
    }

    private static final boolean isHD() {
        return ((Boolean) isHD$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isHD_delegate$lambda$0() {
        return Intrinsics.areEqual("android_hd", FoundationAlias.getFapps().getMetaData().getString("MOBI_APP"));
    }

    public static final boolean getEnableLocalization() {
        return !isHD();
    }

    public static final boolean isMainProcess() {
        return ((Boolean) isMainProcess$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMainProcess_delegate$lambda$0() {
        return ProcessUtils.isMainProcess();
    }

    private static final Locale getSystemLocaleAPI33() {
        android.os.LocaleList it;
        java.util.Locale it2;
        LocaleManager localeManager = (LocaleManager) FoundationAlias.getFapp().getSystemService(LocaleManager.class);
        if (localeManager != null && (it = localeManager.getSystemLocales()) != null) {
            if (it.isEmpty()) {
                it = null;
            }
            if (it != null && (it2 = it.get(0)) != null) {
                return new Locale(it2);
            }
        }
        return Locale.Companion.getCurrent$localization_debug();
    }

    private static final Locale getSystemLocaleAPI32() {
        return Locale.Companion.getCurrent$localization_debug();
    }

    private static final void setAppLocaleAPI33(Locale locale) {
        LocaleManager localeManager = (LocaleManager) FoundationAlias.getFapp().getSystemService(LocaleManager.class);
        if (localeManager != null) {
            localeManager.setApplicationLocales(new android.os.LocaleList(locale.getPlatformLocale$localization_debug()));
        }
    }

    private static final void setAppLocaleAPI32(Locale locale) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.create(new java.util.Locale[]{locale.getPlatformLocale$localization_debug()}));
    }

    @PreTrigger(awaitComplete = true, trigger = "OnCreate")
    public static final Object initLocalization(GLog log, Continuation<? super Unit> continuation) {
        String info = "sLocale: " + Localization.INSTANCE.getSYSTEM() + ", cLocale: " + Localization.INSTANCE.getCurrent();
        if (log != null) {
            log.i("initLocalization", info);
        } else {
            Boxing.boxInt(Log.d("initLocalization", info));
        }
        return Unit.INSTANCE;
    }
}