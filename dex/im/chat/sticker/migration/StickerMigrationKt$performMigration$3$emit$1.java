package im.chat.sticker.migration;

import host.R;
import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerMigration.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.chat.sticker.migration.StickerMigrationKt$performMigration$3", f = "StickerMigration.kt", i = {0, 0, 0}, l = {R.styleable.CameraView_cameraVideoCodec}, m = "emit", n = {"it", "totalCount", "failedCount"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class StickerMigrationKt$performMigration$3$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerMigrationKt$performMigration$3<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerMigrationKt$performMigration$3$emit$1(StickerMigrationKt$performMigration$3<? super T> stickerMigrationKt$performMigration$3, Continuation<? super StickerMigrationKt$performMigration$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = stickerMigrationKt$performMigration$3;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((AccountState.Logged) null, (Continuation) this);
    }
}