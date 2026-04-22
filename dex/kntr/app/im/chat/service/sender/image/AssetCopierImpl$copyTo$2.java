package kntr.app.im.chat.service.sender.image;

import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.RawSink;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetCopier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.AssetCopierImpl$copyTo$2", f = "AssetCopier.kt", i = {0, 0}, l = {53}, m = "invokeSuspend", n = {"sink", "$i$a$-use-AssetCopierImpl$copyTo$2$contentLength$1"}, s = {"L$1", "I$0"}, v = 1)
public final class AssetCopierImpl$copyTo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LocalImageAsset>, Object> {
    final /* synthetic */ Path $target;
    final /* synthetic */ Asset $this_copyTo;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetCopierImpl$copyTo$2(Path path, Asset asset, Continuation<? super AssetCopierImpl$copyTo$2> continuation) {
        super(2, continuation);
        this.$target = path;
        this.$this_copyTo = asset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetCopierImpl$copyTo$2(this.$target, this.$this_copyTo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LocalImageAsset> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AutoCloseable sink$default;
        RawSink sink;
        Object reader;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    sink$default = FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, this.$target, false, 2, (Object) null);
                    Asset asset = this.$this_copyTo;
                    sink = (RawSink) sink$default;
                    this.L$0 = sink$default;
                    this.L$1 = sink;
                    this.I$0 = 0;
                    this.label = 1;
                    reader = asset.reader(this);
                    if (reader != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    RawSink sink2 = (RawSink) this.L$1;
                    sink$default = (AutoCloseable) this.L$0;
                    ResultKt.throwOnFailure($result);
                    sink = sink2;
                    reader = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long contentLength = ((Source) reader).transferTo(sink);
            AutoCloseableKt.closeFinally(sink$default, (Throwable) null);
            return new LocalImageAsset(this.$target, ContentSizeKt.bytes(Boxing.boxLong(contentLength)), this.$this_copyTo.getMimeType(), this.$this_copyTo.getResolution(), this.$this_copyTo.getOrientation(), null);
        } finally {
        }
    }
}