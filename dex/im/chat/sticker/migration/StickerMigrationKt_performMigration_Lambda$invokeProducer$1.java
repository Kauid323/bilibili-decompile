package im.chat.sticker.migration;

import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerMigrationKt_performMigration_Lambda.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.chat.sticker.migration.StickerMigrationKt_performMigration_Lambda", f = "StickerMigrationKt_performMigration_Lambda.kt", i = {}, l = {R.styleable.CameraView_cameraVideoBitRate}, m = "invokeProducer", n = {}, s = {}, v = 1)
public final class StickerMigrationKt_performMigration_Lambda$invokeProducer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerMigrationKt_performMigration_Lambda this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerMigrationKt_performMigration_Lambda$invokeProducer$1(StickerMigrationKt_performMigration_Lambda stickerMigrationKt_performMigration_Lambda, Continuation<? super StickerMigrationKt_performMigration_Lambda$invokeProducer$1> continuation) {
        super(continuation);
        this.this$0 = stickerMigrationKt_performMigration_Lambda;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invokeProducer((Continuation) this);
    }
}