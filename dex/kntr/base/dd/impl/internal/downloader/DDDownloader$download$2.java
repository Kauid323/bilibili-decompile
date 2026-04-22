package kntr.base.dd.impl.internal.downloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.UtilsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDownloader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.downloader.DDDownloader$download$2", f = "DDDownloader.kt", i = {0, 0}, l = {32}, m = "invokeSuspend", n = {"fs", "filePath"}, s = {"L$0", "L$1"}, v = 1)
public final class DDDownloader$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ String $totalMD5;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DDDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDDownloader$download$2(String str, String str2, String str3, DDDownloader dDDownloader, Continuation<? super DDDownloader$download$2> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$totalMD5 = str2;
        this.$url = str3;
        this.this$0 = dDDownloader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DDDownloader$download$2(this.$path, this.$totalMD5, this.$url, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    FileSystem fs = FileSystemJvmKt.SystemFileSystem;
                    Path filePath = PathsJvmKt.Path(this.$path);
                    if (!fs.exists(filePath)) {
                        Path dir = filePath.getParent();
                        if (dir == null) {
                            throw new IllegalArgumentException(this.$path + " has empty parent.");
                        }
                        fs.createDirectories(dir, false);
                    } else if (this.$totalMD5 != null && Intrinsics.areEqual(this.$totalMD5, UtilsKt.md5File(filePath.toString()))) {
                        DDConst.INSTANCE.logD(this.$url + " already download.");
                        Result.Companion companion = Result.Companion;
                        return Result.m2635boximpl(Result.m2636constructorimpl(Unit.INSTANCE));
                    } else {
                        FileSystem.-CC.delete$default(fs, filePath, false, 2, (Object) null);
                        DDConst.INSTANCE.logD("the file to be downloaded already exists, but its MD5 value cannot be verified.");
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(fs);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(filePath);
                    this.label = 1;
                    if (DDDownloader_androidKt.mDownload(this.this$0, this.$url, this.$path, (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    Path path = (Path) this.L$1;
                    FileSystem fileSystem = (FileSystem) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String expected = this.$totalMD5;
            if (expected != null) {
                String md5 = UtilsKt.md5File(this.$path);
                if (!StringsKt.equals(expected, md5, true)) {
                    throw new IllegalStateException("MD5 mismatch: expected " + expected + ", got " + md5);
                }
            }
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Exception e) {
            Result.Companion companion3 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(e));
        }
        return Result.m2635boximpl(m2636constructorimpl);
    }
}