package kntr.common.photonic.gallery.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLogKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GalleryLog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/common/photonic/gallery/internal/GalleryLog;", "", "<init>", "()V", "TAG", "", "d", "", "tag", "log", "Lkotlin/Function0;", "i", "w", "e", "", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GalleryLog {
    public static final int $stable = 0;
    public static final GalleryLog INSTANCE = new GalleryLog();
    private static final String TAG = "Gallery";

    private GalleryLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d$lambda$0(String $log) {
        return $log;
    }

    public final void d(String tag, final String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        KLogKt.d(KLog_androidKt.getKLog(), "Gallery-" + tag, new Function0() { // from class: kntr.common.photonic.gallery.internal.GalleryLog$$ExternalSyntheticLambda0
            public final Object invoke() {
                String d$lambda$0;
                d$lambda$0 = GalleryLog.d$lambda$0(log);
                return d$lambda$0;
            }
        });
    }

    public final void d(String tag, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(function0, "log");
        KLogKt.d(KLog_androidKt.getKLog(), tag, function0);
    }

    public final void i(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        KLog_androidKt.getKLog().i("Gallery-" + tag, log);
    }

    public final void w(String tag, String log) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        KLog_androidKt.getKLog().w("Gallery-" + tag, log);
    }

    public static /* synthetic */ void e$default(GalleryLog galleryLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        galleryLog.e(str, str2, th);
    }

    public final void e(String tag, String log, Throwable e) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        KLog_androidKt.getKLog().e("Gallery-" + tag, log, e);
    }
}