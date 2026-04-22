package kntr.app.tribee.publish.di;

import com.bilibili.lib.foundation.FoundationAlias;
import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: TribeeDraftDirModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/tribee/publish/di/TribeeDraftDirModule;", "", "<init>", "()V", "provideDraftBaseDir", "Lkotlinx/io/files/Path;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeeDraftDirModule {
    public static final TribeeDraftDirModule INSTANCE = new TribeeDraftDirModule();

    private TribeeDraftDirModule() {
    }

    @Provides
    @TribeeDraftBaseDir
    public final Path provideDraftBaseDir() {
        String path = FoundationAlias.getFapp().getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return PathsKt.Path(path, new String[]{"tribee", "draft"});
    }
}