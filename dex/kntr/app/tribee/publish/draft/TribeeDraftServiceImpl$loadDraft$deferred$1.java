package kntr.app.tribee.publish.draft;

import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.serialization.json.Json;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeDraftServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.draft.TribeeDraftServiceImpl$loadDraft$deferred$1", f = "TribeeDraftServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeDraftServiceImpl$loadDraft$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TribeeDraftContent>, Object> {
    final /* synthetic */ TribeeInfo $tribeeInfo;
    int label;
    final /* synthetic */ TribeeDraftServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeDraftServiceImpl$loadDraft$deferred$1(TribeeDraftServiceImpl tribeeDraftServiceImpl, TribeeInfo tribeeInfo, Continuation<? super TribeeDraftServiceImpl$loadDraft$deferred$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeDraftServiceImpl;
        this.$tribeeInfo = tribeeInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeDraftServiceImpl$loadDraft$deferred$1(this.this$0, this.$tribeeInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TribeeDraftContent> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Json this_$iv;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Path path = this.this$0.getDraftPath$core_debug(this.$tribeeInfo);
                if (!FileSystemJvmKt.SystemFileSystem.exists(path)) {
                    KLog_androidKt.getKLog().i("TribeeDraft", "Draft not found in " + this.$tribeeInfo);
                    return null;
                }
                Source source = (AutoCloseable) CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(path));
                TribeeDraftServiceImpl tribeeDraftServiceImpl = this.this$0;
                TribeeInfo tribeeInfo = this.$tribeeInfo;
                try {
                    Source source2 = source;
                    String content = Utf8Kt.readString(source2);
                    this_$iv = tribeeDraftServiceImpl.json;
                    this_$iv.getSerializersModule();
                    Object decodeFromString = this_$iv.decodeFromString(TribeeDraftContent.Companion.serializer(), content);
                    TribeeDraftContent tribeeDraftContent = (TribeeDraftContent) decodeFromString;
                    KLog_androidKt.getKLog().i("TribeeDraft", "Load draft in " + tribeeInfo + " with string count " + content.length());
                    TribeeDraftContent it = (TribeeDraftContent) decodeFromString;
                    TribeeDraftContent tribeeDraftContent2 = new TribeeDraftContent(it.getTribeeInfo(), it.getOpusContent(), it.getSendToFollowing(), it.getSelectedCategoryId());
                    AutoCloseableKt.closeFinally(source, (Throwable) null);
                    return tribeeDraftContent2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(source, th);
                        throw th2;
                    }
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}