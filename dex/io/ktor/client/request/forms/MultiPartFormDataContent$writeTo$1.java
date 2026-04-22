package io.ktor.client.request.forms;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FormDataContent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6}, l = {119, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 121, TbsListener.ErrorCode.PV_UPLOAD_ERROR, TbsListener.ErrorCode.SDCARD_HAS_BACKUP, 134, 137, 141, 141, 141}, m = "writeTo", n = {"this", "channel", "part", "this", "channel", "part", "this", "channel", "part", "this", "channel", "this", "channel", "this", "channel", "channel"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
public final class MultiPartFormDataContent$writeTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiPartFormDataContent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPartFormDataContent$writeTo$1(MultiPartFormDataContent multiPartFormDataContent, Continuation<? super MultiPartFormDataContent$writeTo$1> continuation) {
        super(continuation);
        this.this$0 = multiPartFormDataContent;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeTo(null, (Continuation) this);
    }
}