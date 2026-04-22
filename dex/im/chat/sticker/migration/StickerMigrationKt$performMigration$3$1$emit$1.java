package im.chat.sticker.migration;

import im.chat.sticker.migration.StickerMigrationKt$performMigration$3;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerMigration.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.chat.sticker.migration.StickerMigrationKt$performMigration$3$1", f = "StickerMigration.kt", i = {0}, l = {46}, m = "emit", n = {"it"}, s = {"L$0"}, v = 1)
public final class StickerMigrationKt$performMigration$3$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerMigrationKt$performMigration$3.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerMigrationKt$performMigration$3$1$emit$1(StickerMigrationKt$performMigration$3.AnonymousClass1<? super T> anonymousClass1, Continuation<? super StickerMigrationKt$performMigration$3$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Asset) null, (Continuation) this);
    }
}