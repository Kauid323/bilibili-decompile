package kntr.base.dd.impl.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.bspatch.BspatchKt;
import kntr.base.utils.crypto.MD5_androidKt;
import kntr.base.utils.zip.ZipKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004\u001a\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"patch", "Lkotlin/Result;", "", "oldFilePath", "", "newFilePath", "patchFilePath", "overWrite", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "unzip", "src", "target", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "md5String", "string", "md5File", "path", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    public static /* synthetic */ Object patch$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return patch(str, str2, str3, z);
    }

    public static final Object patch(String oldFilePath, String newFilePath, String patchFilePath, boolean overWrite) {
        Intrinsics.checkNotNullParameter(oldFilePath, "oldFilePath");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(patchFilePath, "patchFilePath");
        return BspatchKt.patch(oldFilePath, newFilePath, patchFilePath, overWrite);
    }

    public static final Object unzip(String src, String target) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(target, "target");
        return ZipKt.unzip$default(src, target, false, 4, null);
    }

    public static final String md5String(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return MD5_androidKt.encryptMd5(string);
    }

    public static final String md5File(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return MD5_androidKt.encryptFileMd5(path);
    }
}