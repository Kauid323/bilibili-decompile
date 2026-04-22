package kntr.app.ad.domain.click.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0000\"\u001a\u0010\b\u001a\u0004\u0018\u00010\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"isIMax", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "isBiliNative", "isH5", "isInOpenWhiteList", "whiteList", RoomRecommendViewModel.EMPTY_CURSOR, "schemePrefix", "getSchemePrefix", "(Ljava/lang/String;)Ljava/lang/String;", "isSchemeString", "findFirstSuitableWhileApk", "Lkntr/app/ad/common/model/AdWhiteApk;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilsKt {
    public static final boolean isIMax(String $this$isIMax) {
        Intrinsics.checkNotNullParameter($this$isIMax, "<this>");
        return StringsKt.startsWith$default($this$isIMax, "bilibili://ad/page/imax", false, 2, (Object) null);
    }

    public static final boolean isBiliNative(String $this$isBiliNative) {
        Intrinsics.checkNotNullParameter($this$isBiliNative, "<this>");
        return StringsKt.startsWith$default($this$isBiliNative, "bilibili://", false, 2, (Object) null);
    }

    public static final boolean isH5(String $this$isH5) {
        Intrinsics.checkNotNullParameter($this$isH5, "<this>");
        return (StringsKt.startsWith$default($this$isH5, "http://", false, 2, (Object) null) || StringsKt.startsWith$default($this$isH5, "https://", false, 2, (Object) null)) && !StringsKt.endsWith$default($this$isH5, ".apk", false, 2, (Object) null);
    }

    public static final boolean isInOpenWhiteList(String $this$isInOpenWhiteList, List<String> list) {
        String prefix;
        String it;
        Intrinsics.checkNotNullParameter($this$isInOpenWhiteList, "<this>");
        List<String> list2 = list;
        if ((list2 == null || list2.isEmpty()) || (prefix = getSchemePrefix($this$isInOpenWhiteList)) == null) {
            return false;
        }
        List<String> $this$any$iv = list;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it2 = (String) element$iv;
            if (StringsKt.equals(prefix, it2, true) || Intrinsics.areEqual(it2, "*")) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    public static final String getSchemePrefix(String $this$schemePrefix) {
        int index;
        Intrinsics.checkNotNullParameter($this$schemePrefix, "<this>");
        if (isSchemeString($this$schemePrefix) && (index = StringsKt.indexOf$default($this$schemePrefix, "://", 0, false, 6, (Object) null)) != -1) {
            String substring = $this$schemePrefix.substring(0, index);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return null;
    }

    public static final boolean isSchemeString(String $this$isSchemeString) {
        Intrinsics.checkNotNullParameter($this$isSchemeString, "<this>");
        String lowercase = $this$isSchemeString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowercase, "toLowerCase(...)");
        return (StringsKt.startsWith$default(lowercase, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(lowercase, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(lowercase, "bilibili://", false, 2, (Object) null) || !StringsKt.contains$default(lowercase, "://", false, 2, (Object) null)) ? false : true;
    }

    public static final AdWhiteApk findFirstSuitableWhileApk(List<AdWhiteApk> list) {
        AdWhiteApk apk;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<AdWhiteApk> it = list.iterator();
        do {
            if (!it.hasNext()) {
                return null;
            }
            apk = it.next();
        } while (Intrinsics.areEqual("*", apk != null ? apk.getUrl() : null));
        return apk;
    }
}