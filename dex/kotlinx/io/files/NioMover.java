package kotlinx.io.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileSystemJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017¨\u0006\t"}, d2 = {"Lkotlinx/io/files/NioMover;", "Lkotlinx/io/files/Mover;", "<init>", "()V", "move", "", "source", "Lkotlinx/io/files/Path;", "destination", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NioMover implements Mover {
    @Override // kotlinx.io.files.Mover
    @AnimalSnifferIgnore
    public void move(Path source, Path destination) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!source.getFile$kotlinx_io_core().exists()) {
            throw new FileNotFoundException("Source file does not exist: " + source.getFile$kotlinx_io_core());
        }
        try {
            Files.move(source.getFile$kotlinx_io_core().toPath(), destination.getFile$kotlinx_io_core().toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (Throwable e) {
            if (!(e instanceof IOException)) {
                throw new IOException("Move failed", e);
            }
            throw e;
        }
    }
}