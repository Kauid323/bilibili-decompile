package kntr.app.im.chat.sticker.service;

import im.base.IMLog;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.common.photonic.Asset;
import kntr.common.photonic.MimeType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.datetime.Clock;
import kotlinx.io.RawSink;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$saveStickerIntoFileSystem$2", f = "StickerManagerService.kt", i = {0, 0, 0, 0}, l = {157}, m = "invokeSuspend", n = {"sink", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-StickerManagerServiceImpl$saveStickerIntoFileSystem$2$1", "$i$a$-use-StickerManagerServiceImpl$saveStickerIntoFileSystem$2$1$2"}, s = {"L$5", "I$0", "I$1", "I$2"}, v = 1)
public final class StickerManagerServiceImpl$saveStickerIntoFileSystem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends StickerEntity>>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ long $mid;
    final /* synthetic */ MimeType $mimeType;
    final /* synthetic */ Path $savePath;
    final /* synthetic */ Asset $sticker;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$saveStickerIntoFileSystem$2(Path path, Asset asset, String str, long j2, MimeType mimeType, Continuation<? super StickerManagerServiceImpl$saveStickerIntoFileSystem$2> continuation) {
        super(2, continuation);
        this.$savePath = path;
        this.$sticker = asset;
        this.$fileName = str;
        this.$mid = j2;
        this.$mimeType = mimeType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerServiceImpl$saveStickerIntoFileSystem$2(this.$savePath, this.$sticker, this.$fileName, this.$mid, this.$mimeType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<StickerEntity>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable th;
        Object obj;
        Asset asset;
        RawSink sink;
        Object reader;
        RawSink rawSink;
        String str;
        Path path;
        MimeType mimeType;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Path path2 = this.$savePath;
                        asset = this.$sticker;
                        String str2 = this.$fileName;
                        long j3 = this.$mid;
                        MimeType mimeType2 = this.$mimeType;
                        Result.Companion companion = Result.Companion;
                        FileSystemJvmKt.SystemFileSystem.delete(path2, false);
                        Path it = path2.getParent();
                        if (it != null) {
                            FileSystemJvmKt.SystemFileSystem.createDirectories(it, false);
                        }
                        RawSink rawSink2 = (AutoCloseable) FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, path2, false, 2, (Object) null);
                        sink = rawSink2;
                        this.L$0 = path2;
                        this.L$1 = asset;
                        this.L$2 = str2;
                        this.L$3 = mimeType2;
                        this.L$4 = rawSink2;
                        this.L$5 = sink;
                        this.J$0 = j3;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 1;
                        reader = asset.reader(this);
                        if (reader != coroutine_suspended) {
                            rawSink = rawSink2;
                            str = str2;
                            path = path2;
                            mimeType = mimeType2;
                            j2 = j3;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = this.I$2;
                        int i2 = this.I$1;
                        int i3 = this.I$0;
                        long j4 = this.J$0;
                        sink = (RawSink) this.L$5;
                        AutoCloseable autoCloseable = (AutoCloseable) this.L$4;
                        MimeType mimeType3 = (MimeType) this.L$3;
                        String str3 = (String) this.L$2;
                        asset = (Asset) this.L$1;
                        Path path3 = (Path) this.L$0;
                        ResultKt.throwOnFailure($result);
                        reader = $result;
                        rawSink = autoCloseable;
                        str = str3;
                        path = path3;
                        mimeType = mimeType3;
                        j2 = j4;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            try {
                ((Source) reader).transferTo(sink);
                AutoCloseableKt.closeFinally(rawSink, (Throwable) null);
                IMLog.Companion.i("StickerSaver", "Sticker saved successfully to " + path);
                obj = Result.constructor-impl(new StickerEntity(str, Clock.System.INSTANCE.now(), j2, asset.getResolution(), mimeType));
                JobKt.ensureActive(getContext());
                return Result.box-impl(obj);
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}