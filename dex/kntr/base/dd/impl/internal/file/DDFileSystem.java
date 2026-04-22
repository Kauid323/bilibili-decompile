package kntr.base.dd.impl.internal.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.UtilsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.io.files.PathsKt;

/* compiled from: DDFileSystem.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\t\"\u00020\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0006JF\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00032\u001e\u0010\u0018\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0086@¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkntr/base/dd/impl/internal/file/DDFileSystem;", "", "root", "", "<init>", "(Ljava/lang/String;)V", "Lkotlinx/io/files/Path;", "path", "parts", "", "([Ljava/lang/String;)Lkotlinx/io/files/Path;", "exists", "", "readZipData", "dst", "removeItem", "", "list", "", "dir", "patch", "old", "target", "totalMD5", "patchFetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/io/files/Path;Lkotlinx/io/files/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logI", "msg", "logE", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDFileSystem {
    private final Path root;

    public DDFileSystem(String root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = PathsJvmKt.Path(root);
    }

    public final Path path(String... parts) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        return PathsKt.Path(this.root, (String[]) Arrays.copyOf(parts, parts.length));
    }

    public final boolean exists(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return FileSystemJvmKt.SystemFileSystem.exists(path);
    }

    public final String readZipData(Path dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Path dir = dst.getParent();
        if (dir != null) {
            FileSystem fs = FileSystemJvmKt.SystemFileSystem;
            Path unzipDir = PathsKt.Path(dir, new String[]{"unzip"});
            DDFileSystemKt.deleteRecursivelySafe(fs, unzipDir);
            Object unzip = UtilsKt.unzip(dst.toString(), unzipDir.toString());
            Throwable e = Result.m2639exceptionOrNullimpl(unzip);
            if (e != null) {
                logE("unzip has exception " + e.getMessage());
                return null;
            }
            Unit unit = (Unit) unzip;
            return DDFileSystemKt.readString(fs, (Path) CollectionsKt.firstOrNull(fs.list(unzipDir)));
        }
        return null;
    }

    public final void removeItem(Path dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        DDFileSystemKt.deleteRecursivelySafe(FileSystemJvmKt.SystemFileSystem, dst);
    }

    public final List<String> list(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Iterable $this$map$iv = FileSystemJvmKt.SystemFileSystem.list(dir);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Path it = (Path) item$iv$iv;
            destination$iv$iv.add(it.getName());
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object patch(Path old, Path target, String totalMD5, Function1<? super Continuation<? super Path>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        DDFileSystem$patch$1 dDFileSystem$patch$1;
        String totalMD52;
        Object invoke;
        String newFilePath;
        Path patchFilePath;
        Path old2 = old;
        if (continuation instanceof DDFileSystem$patch$1) {
            dDFileSystem$patch$1 = (DDFileSystem$patch$1) continuation;
            if ((dDFileSystem$patch$1.label & Integer.MIN_VALUE) != 0) {
                dDFileSystem$patch$1.label -= Integer.MIN_VALUE;
                Object $result = dDFileSystem$patch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDFileSystem$patch$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        FileSystem fs = FileSystemJvmKt.SystemFileSystem;
                        if (!fs.exists(old2)) {
                            logI("use patch but old file " + old2 + " not exists.");
                            return Boxing.boxBoolean(false);
                        }
                        String newFilePath2 = target.toString();
                        dDFileSystem$patch$1.L$0 = old2;
                        dDFileSystem$patch$1.L$1 = SpillingKt.nullOutSpilledVariable(target);
                        totalMD52 = totalMD5;
                        dDFileSystem$patch$1.L$2 = totalMD52;
                        dDFileSystem$patch$1.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                        dDFileSystem$patch$1.L$4 = SpillingKt.nullOutSpilledVariable(fs);
                        dDFileSystem$patch$1.L$5 = newFilePath2;
                        dDFileSystem$patch$1.label = 1;
                        invoke = function1.invoke(dDFileSystem$patch$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        newFilePath = newFilePath2;
                        break;
                    case 1:
                        newFilePath = (String) dDFileSystem$patch$1.L$5;
                        FileSystem fileSystem = (FileSystem) dDFileSystem$patch$1.L$4;
                        Function1 function12 = (Function1) dDFileSystem$patch$1.L$3;
                        totalMD52 = (String) dDFileSystem$patch$1.L$2;
                        Path path = (Path) dDFileSystem$patch$1.L$1;
                        old2 = (Path) dDFileSystem$patch$1.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                patchFilePath = (Path) invoke;
                if (patchFilePath != null) {
                    return Boxing.boxBoolean(false);
                }
                Object patch$default = UtilsKt.patch$default(old2.toString(), newFilePath, patchFilePath.toString(), false, 8, null);
                Throwable e = Result.m2639exceptionOrNullimpl(patch$default);
                if (e != null) {
                    logE("bspath has exception " + e.getMessage() + ".");
                    return Boxing.boxBoolean(false);
                }
                Unit unit = (Unit) patch$default;
                String md5 = UtilsKt.md5File(newFilePath);
                boolean it = StringsKt.equals(totalMD52, md5, true);
                if (!it) {
                    logE("after patch, new file md5 mismatch: expected " + totalMD52 + ", got " + md5);
                }
                return Boxing.boxBoolean(it);
            }
        }
        dDFileSystem$patch$1 = new DDFileSystem$patch$1(this, continuation);
        Object $result2 = dDFileSystem$patch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDFileSystem$patch$1.label) {
        }
        patchFilePath = (Path) invoke;
        if (patchFilePath != null) {
        }
    }

    private final void logI(String msg) {
        DDConst.INSTANCE.logI(msg);
    }

    private final void logE(String msg) {
        DDConst.logE$default(DDConst.INSTANCE, msg, null, 2, null);
    }
}