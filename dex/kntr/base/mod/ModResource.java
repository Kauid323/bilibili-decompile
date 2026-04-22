package kntr.base.mod;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlinx.io.files.Path;

/* compiled from: KMod.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/base/mod/ModResource;", "", "poolName", "", "getPoolName", "()Ljava/lang/String;", "modName", "getModName", "path", "Lkotlinx/io/files/Path;", "getPath", "()Lkotlinx/io/files/Path;", AppKey.VERSION, "", "getVersion$annotations", "()V", "getVersion", "()J", "region", "getRegion$annotations", "getRegion", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ModResource {

    /* compiled from: KMod.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getRegion$annotations() {
        }

        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    String getModName();

    Path getPath();

    String getPoolName();

    String getRegion();

    long getVersion();
}