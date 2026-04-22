package kntr.common.photonic.aphro.ui.preview.save;

import android.app.Activity;
import android.net.Uri;
import java.io.OutputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.foundation.AppDirectory;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.io.CoreKt;
import kotlinx.io.JvmCoreKt;
import kotlinx.io.RawSink;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaveImageManager.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.save.SaveImageManager$saveImage$2", f = "SaveImageManager.android.kt", i = {0, 0, 0, 0, 0, 0}, l = {ConstantsKt.DAY_CONTENT_PREVIEW_ROW_HEIGHT}, m = "invokeSuspend", n = {"$this$async", "tempFile", "it", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-SaveImageManager$saveImage$2$result$1", "$i$a$-use-SaveImageManager$saveImage$2$result$1$2"}, s = {"L$0", "L$1", "L$5", "I$0", "I$1", "I$2"}, v = 1)
public final class SaveImageManager$saveImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ Activity $platformContext;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveImageManager$saveImage$2(Activity activity, Asset asset, Continuation<? super SaveImageManager$saveImage$2> continuation) {
        super(2, continuation);
        this.$platformContext = activity;
        this.$asset = asset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> saveImageManager$saveImage$2 = new SaveImageManager$saveImage$2(this.$platformContext, this.$asset, continuation);
        saveImageManager$saveImage$2.L$0 = obj;
        return saveImageManager$saveImage$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object result;
        Object m2636constructorimpl;
        Path tempFile;
        Activity activity;
        Asset asset;
        AutoCloseable buffered;
        RawSink it;
        Object reader;
        OutputStream outputStream;
        RawSink asSink;
        RawSink buffered2;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tempFile = PathsKt.Path(AppDirectory.INSTANCE.getCacheDirectory(), new String[]{"im", "download", Uuid.Companion.random().toString()});
                    activity = this.$platformContext;
                    asset = this.$asset;
                    Result.Companion companion = Result.Companion;
                    Path it2 = tempFile.getParent();
                    if (it2 != null) {
                        FileSystemJvmKt.SystemFileSystem.createDirectories(it2, false);
                    }
                    buffered = CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.sink(tempFile, false));
                    it = (Sink) buffered;
                    this.L$0 = $this$async;
                    this.L$1 = tempFile;
                    this.L$2 = activity;
                    this.L$3 = asset;
                    this.L$4 = buffered;
                    this.L$5 = it;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.label = 1;
                    reader = asset.reader(this);
                    if (reader != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$2;
                    int i2 = this.I$1;
                    int i3 = this.I$0;
                    it = (Sink) this.L$5;
                    buffered = (AutoCloseable) this.L$4;
                    asset = (Asset) this.L$3;
                    activity = (Activity) this.L$2;
                    tempFile = (Path) this.L$1;
                    ResultKt.throwOnFailure($result);
                    reader = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ((Source) reader).transferTo(it);
            AutoCloseableKt.closeFinally(buffered, (Throwable) null);
            Uri uri = SaveImageManager_androidKt.access$createImageUri(activity, asset.getMimeType(), StringsKt.substringAfterLast$default(asset.getIdentifier(), ".", (String) null, 2, (Object) null));
            outputStream = uri != null ? activity.getContentResolver().openOutputStream(uri) : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (outputStream == null || (asSink = JvmCoreKt.asSink(outputStream)) == null || (buffered2 = CoreKt.buffered(asSink)) == null) {
            throw new Exception("Failed to create image uri in MediaStore");
        }
        RawSink rawSink = (AutoCloseable) buffered2;
        long transferTo = CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(tempFile)).transferTo((Sink) rawSink);
        AutoCloseableKt.closeFinally(rawSink, (Throwable) null);
        result = Result.m2636constructorimpl(Boxing.boxLong(transferTo));
        JobKt.ensureActive(getContext());
        try {
            Result.Companion companion3 = Result.Companion;
            FileSystemJvmKt.SystemFileSystem.delete(tempFile, false);
            Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Result.m2636constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m2643isSuccessimpl(result)) {
            Result.Companion companion5 = Result.Companion;
            ((Number) result).longValue();
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
        } else {
            m2636constructorimpl = Result.m2636constructorimpl(result);
        }
        return Result.m2635boximpl(m2636constructorimpl);
    }
}