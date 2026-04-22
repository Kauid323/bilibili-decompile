package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Localization.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", "", "getLanguageFamilyFallback", "Lkntr/base/localization/Locale;", "locale", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalizationKt {
    private static final String TAG = "Localization";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x006b, code lost:
        if (r0.equals("mn") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0085, code lost:
        if (r0.equals("ii") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x009f, code lost:
        if (r0.equals("eu") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00a9, code lost:
        if (r0.equals("ca") != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00b2, code lost:
        if (r0.equals("bo") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00b6, code lost:
        r0 = kntr.base.localization.Locale.Companion.getSIMPLIFIED_CHINESE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00c3, code lost:
        if (r0.equals("an") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00c7, code lost:
        r0 = kntr.base.localization.Locale.Companion.getSPANISH();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0015, code lost:
        if (r0.equals("yue") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x001f, code lost:
        if (r0.equals("wuu") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0029, code lost:
        if (r0.equals("nan") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0032, code lost:
        if (r0.equals("hsn") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x003b, code lost:
        if (r0.equals("hak") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0044, code lost:
        if (r0.equals("gan") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x004d, code lost:
        if (r0.equals("ast") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0057, code lost:
        if (r0.equals("za") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0061, code lost:
        if (r0.equals("ug") == false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Locale getLanguageFamilyFallback(Locale locale) {
        Locale fallbackLocale;
        String language = locale.getLanguage();
        switch (language.hashCode()) {
            case 3117:
                break;
            case 3149:
                break;
            case 3166:
                break;
            case 3248:
                break;
            case 3301:
                if (language.equals("gl")) {
                    fallbackLocale = Locale.Companion.getPORTUGUESE();
                    break;
                }
                fallbackLocale = null;
                break;
            case 3360:
                break;
            case 3459:
                if (language.equals("lo")) {
                    fallbackLocale = Locale.Companion.getTHAI();
                    break;
                }
                fallbackLocale = null;
                break;
            case 3489:
                break;
            case 3730:
                break;
            case 3879:
                break;
            case 96898:
                break;
            case 102100:
                break;
            case 103058:
                break;
            case 103619:
                break;
            case 108827:
                break;
            case 118103:
                break;
            case 120009:
                break;
            default:
                fallbackLocale = null;
                break;
        }
        if (fallbackLocale != null) {
            Locale it = fallbackLocale;
            if (Localization.INSTANCE.getSUPPORTED_LIST().contains(it)) {
                return fallbackLocale;
            }
            return null;
        }
        return null;
    }
}