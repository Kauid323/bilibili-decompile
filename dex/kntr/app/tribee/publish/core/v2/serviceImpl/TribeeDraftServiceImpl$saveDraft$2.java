package kntr.app.tribee.publish.core.v2.serviceImpl;

import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.service.TribeeDraftContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.common.ouro.core.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.serialization.BinaryFormat;

/* compiled from: TribeeDraftServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.TribeeDraftServiceImpl$saveDraft$2", f = "TribeeDraftServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeDraftServiceImpl$saveDraft$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TribeeDraftContent $content;
    final /* synthetic */ TribeeInfo $tribeeInfo;
    int label;
    final /* synthetic */ TribeeDraftServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeDraftServiceImpl$saveDraft$2(TribeeDraftServiceImpl tribeeDraftServiceImpl, TribeeInfo tribeeInfo, TribeeDraftContent tribeeDraftContent, Continuation<? super TribeeDraftServiceImpl$saveDraft$2> continuation) {
        super(2, continuation);
        this.this$0 = tribeeDraftServiceImpl;
        this.$tribeeInfo = tribeeInfo;
        this.$content = tribeeDraftContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeDraftServiceImpl$saveDraft$2(this.this$0, this.$tribeeInfo, this.$content, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Path path = this.this$0.getDraftPath$core_debug(this.$tribeeInfo);
                    if (this.$content == null) {
                        KLog_androidKt.getKLog().i("TribeeDraft", "Delete draft in " + this.$tribeeInfo);
                        FileSystemJvmKt.SystemFileSystem.delete(path, false);
                        KLog_androidKt.getKLog().i("TribeeDraft", "Finished deleting draft in " + this.$tribeeInfo);
                    } else {
                        KLog_androidKt.getKLog().i("TribeeDraft", "Save new draft in " + this.$tribeeInfo);
                        Path it = path.getParent();
                        if (it != null) {
                            FileSystemJvmKt.SystemFileSystem.createDirectories(it, false);
                        }
                        BinaryFormat $this$encodeToByteArray$iv = SerializationUtilsKt.getOuroProtoBuf();
                        Object value$iv = this.$content;
                        $this$encodeToByteArray$iv.getSerializersModule();
                        byte[] draftContent = $this$encodeToByteArray$iv.encodeToByteArray(TribeeDraftContent.Companion.serializer(), value$iv);
                        Sink sink = (AutoCloseable) CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.sink(path, false));
                        Sink sink2 = sink;
                        Sink.-CC.write$default(sink2, draftContent, 0, 0, 6, (Object) null);
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(sink, (Throwable) null);
                        ILogger kLog = KLog_androidKt.getKLog();
                        TribeeInfo tribeeInfo = this.$tribeeInfo;
                        kLog.i("TribeeDraft", "Finish saving draft in " + tribeeInfo + " with string count " + draftContent.length);
                    }
                } catch (Exception e) {
                    KLog_androidKt.getKLog().e("TribeeDraft", "Fail to save draft in " + this.$tribeeInfo, e);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}