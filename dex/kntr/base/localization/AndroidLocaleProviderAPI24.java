package kntr.base.localization;

import java.util.ArrayList;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformLocale.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkntr/base/localization/AndroidLocaleProviderAPI24;", "Lkntr/base/localization/PlatformLocaleProvider;", "<init>", "()V", "lastAndroidLocaleList", "Landroid/os/LocaleList;", "lastLocaleList", "Lkntr/base/localization/LocaleList;", "current", "getCurrent", "()Lkntr/base/localization/LocaleList;", "fetchLocales", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class AndroidLocaleProviderAPI24 implements PlatformLocaleProvider {
    public static final AndroidLocaleProviderAPI24 INSTANCE = new AndroidLocaleProviderAPI24();
    private static android.os.LocaleList lastAndroidLocaleList;
    private static LocaleList lastLocaleList;

    private AndroidLocaleProviderAPI24() {
    }

    @Override // kntr.base.localization.PlatformLocaleProvider
    public LocaleList getCurrent() {
        return fetchLocales();
    }

    private final LocaleList fetchLocales() {
        android.os.LocaleList androidLocaleList = android.os.LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(androidLocaleList, "getDefault(...)");
        LocaleList it = lastLocaleList;
        if (it == null || androidLocaleList != lastAndroidLocaleList) {
            int size = androidLocaleList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                int position = i;
                java.util.Locale locale = androidLocaleList.get(position);
                Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
                arrayList.add(new Locale(locale));
            }
            LocaleList localeList = new LocaleList(arrayList);
            lastAndroidLocaleList = androidLocaleList;
            lastLocaleList = localeList;
            return localeList;
        }
        return it;
    }
}