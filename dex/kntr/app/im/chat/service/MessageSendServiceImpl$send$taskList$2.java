package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.atomicfu.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSendServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class MessageSendServiceImpl$send$taskList$2 extends FunctionReferenceImpl implements Function0<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSendServiceImpl$send$taskList$2(Object obj) {
        super(0, obj, AtomicLong.class, "getAndIncrement", "getAndIncrement()J", 0);
    }

    /* renamed from: invoke */
    public final Long m1583invoke() {
        return Long.valueOf(((AtomicLong) this.receiver).getAndIncrement());
    }
}