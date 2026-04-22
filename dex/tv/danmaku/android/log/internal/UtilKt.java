package tv.danmaku.android.log.internal;

import android.content.Context;
import android.os.Process;
import com.bilibili.droid.ProcessUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.MainRouteUris;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a#\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a#\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\u0010\u0013\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u000bH\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"pidStr", "", "getPidStr", "()Ljava/lang/String;", "pidStr$delegate", "Lkotlin/Lazy;", "blogProcess", "Landroid/content/Context;", "getBlogProcess", "(Landroid/content/Context;)Ljava/lang/String;", "find2Power", "", "makeZipFile", "Ljava/io/File;", "context", "time", "", "(Ljava/io/File;Landroid/content/Context;Ljava/lang/Long;)Ljava/io/File;", "shortProc", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/Long;)Ljava/io/File;", "toName", "blog_android_release"}, k = 2, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class UtilKt {
    private static final Lazy pidStr$delegate = LazyKt.lazy(new Function0<String>() { // from class: tv.danmaku.android.log.internal.UtilKt$pidStr$2
        public final String invoke() {
            return new StringBuilder().append('(').append(Process.myPid()).append(')').toString();
        }
    });

    public static final String getBlogProcess(Context $this$blogProcess) {
        String str;
        Intrinsics.checkNotNullParameter($this$blogProcess, "<this>");
        String p = ProcessUtils.myProcName($this$blogProcess);
        if (Intrinsics.areEqual(p, $this$blogProcess.getPackageName())) {
            return MainRouteUris.MODULE_MAIN;
        }
        Intrinsics.checkNotNull(p);
        int offset = StringsKt.lastIndexOf$default(p, ':', 0, false, 6, (Object) null);
        if (offset >= 0) {
            String substring = p.substring(offset + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = substring;
        } else {
            str = p;
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public static final String getPidStr() {
        return (String) pidStr$delegate.getValue();
    }

    public static final File makeZipFile(File $this$makeZipFile, Context context, Long time) {
        Intrinsics.checkNotNullParameter($this$makeZipFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return makeZipFile($this$makeZipFile, getBlogProcess(context), time);
    }

    public static final File makeZipFile(File $this$makeZipFile, String shortProc, Long time) {
        Intrinsics.checkNotNullParameter($this$makeZipFile, "<this>");
        Intrinsics.checkNotNullParameter(shortProc, "shortProc");
        return new File($this$makeZipFile, (time != null ? String.valueOf(TimeUnit.MILLISECONDS.toDays(time.longValue())) : "all") + '-' + shortProc + ".zip");
    }

    public static final String toName(int $this$toName) {
        switch ($this$toName) {
            case -1:
                return "EVENT";
            case 0:
            case 1:
            default:
                return "UNKNOWN";
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "F";
        }
    }

    public static final int find2Power(int $this$find2Power) {
        int n = $this$find2Power | ($this$find2Power >> 1);
        int n2 = n | (n >> 2);
        int n3 = n2 | (n2 >> 4);
        int n4 = n3 | (n3 >> 8);
        return (n4 | (n4 >> 16)) + 1;
    }
}