package kntr.app.tribee.publish.di;

import dagger.internal.Factory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.io.files.Path;

/* compiled from: TribeeDraftDirModule_ProvideDraftBaseDirFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/di/TribeeDraftDirModule_ProvideDraftBaseDirFactory;", "Ldagger/internal/Factory;", "Lkotlinx/io/files/Path;", "<init>", "()V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDraftDirModule_ProvideDraftBaseDirFactory implements Factory<Path> {
    public static final Companion Companion = new Companion(null);
    private static final TribeeDraftDirModule_ProvideDraftBaseDirFactory INSTANCE = new TribeeDraftDirModule_ProvideDraftBaseDirFactory();

    public Path get() {
        return Companion.provideDraftBaseDir();
    }

    /* compiled from: TribeeDraftDirModule_ProvideDraftBaseDirFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/tribee/publish/di/TribeeDraftDirModule_ProvideDraftBaseDirFactory$Companion;", "", "<init>", "()V", "INSTANCE", "Lkntr/app/tribee/publish/di/TribeeDraftDirModule_ProvideDraftBaseDirFactory;", "create", "provideDraftBaseDir", "Lkotlinx/io/files/Path;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeDraftDirModule_ProvideDraftBaseDirFactory create() {
            return TribeeDraftDirModule_ProvideDraftBaseDirFactory.INSTANCE;
        }

        @JvmStatic
        public final Path provideDraftBaseDir() {
            return TribeeDraftDirModule.INSTANCE.provideDraftBaseDir();
        }
    }

    @JvmStatic
    public static final TribeeDraftDirModule_ProvideDraftBaseDirFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final Path provideDraftBaseDir() {
        return Companion.provideDraftBaseDir();
    }
}