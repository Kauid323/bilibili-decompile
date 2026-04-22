package kntr.app.im.chat.module.localPicture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalPictureModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.module.localPicture.LocalPictureModule", f = "LocalPictureModule.kt", i = {}, l = {33}, m = "rebuildModule", n = {}, s = {}, v = 1)
public final class LocalPictureModule$rebuildModule$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPictureModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPictureModule$rebuildModule$1(LocalPictureModule localPictureModule, Continuation<? super LocalPictureModule$rebuildModule$1> continuation) {
        super(continuation);
        this.this$0 = localPictureModule;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rebuildModule((Continuation) this);
    }
}