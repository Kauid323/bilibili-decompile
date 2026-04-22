package kntr.app.im.chat.db.di;

import kntr.base.utils.foundation.AppDatabaseDirectory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: ChatDatabaseBuilderModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0003"}, d2 = {"provideChatDBBasePath", "Lkotlinx/io/files/Path;", "path", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseBuilderModuleKt {
    @ChatDatabaseDirectory
    public static final Path provideChatDBBasePath(@AppDatabaseDirectory Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path it = PathsKt.Path(path, new String[]{"im"});
        FileSystemJvmKt.SystemFileSystem.createDirectories(it, false);
        return it;
    }
}