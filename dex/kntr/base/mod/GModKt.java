package kntr.base.mod;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* compiled from: GMod.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"path", "Lkotlinx/io/files/Path;", "Lkntr/base/mod/ModBundle;", "getCache", "Lkntr/base/mod/GMod;", "pool", "", "mod", "mod_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GModKt {
    public static final Path path(ModBundle $this$path) {
        Intrinsics.checkNotNullParameter($this$path, "<this>");
        return PathsJvmKt.Path($this$path.getFilePath());
    }

    public static final ModBundle getCache(GMod $this$getCache, String pool, String mod) {
        Intrinsics.checkNotNullParameter($this$getCache, "<this>");
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(mod, "mod");
        return (ModBundle) BuildersKt.runBlocking$default((CoroutineContext) null, new GModKt$getCache$1($this$getCache, pool, mod, null), 1, (Object) null);
    }
}