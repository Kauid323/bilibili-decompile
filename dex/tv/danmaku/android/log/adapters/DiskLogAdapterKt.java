package tv.danmaku.android.log.adapters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: DiskLogAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"EVENT", "", "toDay", "", "getToDay", "(Ljava/lang/String;)Ljava/lang/String;", "validDates", "Lkotlin/Function1;", "Ljava/io/File;", "", "getValidDates", "(I)Lkotlin/jvm/functions/Function1;", "formattedDate", "kotlin.jvm.PlatformType", "", "fmt", "Ljava/text/SimpleDateFormat;", "blog_android_release"}, k = 2, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DiskLogAdapterKt {
    public static final int EVENT = -1;

    public static final String formattedDate(long $this$formattedDate, SimpleDateFormat fmt) {
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        return fmt.format(Long.valueOf($this$formattedDate));
    }

    public static /* synthetic */ String formattedDate$default(long j, SimpleDateFormat simpleDateFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            ThreadResource threadResource = DiskLogAdapter.Companion.getLocal$blog_android_release().get();
            Intrinsics.checkNotNull(threadResource);
            simpleDateFormat = threadResource.getFmt();
        }
        return formattedDate(j, simpleDateFormat);
    }

    public static final Function1<File, Boolean> getValidDates(int $this$validDates) {
        ThreadResource threadResource = DiskLogAdapter.Companion.getLocal$blog_android_release().get();
        Intrinsics.checkNotNull(threadResource);
        SimpleDateFormat fmt = threadResource.getFmt();
        Calendar c = Calendar.getInstance();
        Iterable $this$map$iv = RangesKt.until(0, $this$validDates);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        IntIterator it = $this$map$iv.iterator();
        while (it.hasNext()) {
            it.nextInt();
            String formattedDate = formattedDate(c.getTimeInMillis(), fmt);
            Intrinsics.checkNotNullExpressionValue(formattedDate, "formattedDate(...)");
            String toDay = getToDay(formattedDate);
            c.add(5, -1);
            destination$iv$iv.add(toDay);
            fmt = fmt;
        }
        final List l = (List) destination$iv$iv;
        return new Function1<File, Boolean>() { // from class: tv.danmaku.android.log.adapters.DiskLogAdapterKt$validDates$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(File f) {
                Intrinsics.checkNotNullParameter(f, "f");
                String name = f.getName();
                Iterable $this$any$iv = l;
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it2 = $this$any$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object element$iv = it2.next();
                        String it3 = (String) element$iv;
                        Intrinsics.checkNotNull(name);
                        if (StringsKt.startsWith$default(name, it3, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        };
    }

    public static final String getToDay(String $this$toDay) {
        Intrinsics.checkNotNullParameter($this$toDay, "<this>");
        String substring = $this$toDay.substring(0, StringsKt.indexOf$default($this$toDay, ' ', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}