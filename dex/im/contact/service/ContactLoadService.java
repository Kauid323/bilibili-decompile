package im.contact.service;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KContactsReq;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.contact.UtilsKt;
import im.contact.di.IMContactScope;
import im.contact.model.ContactsReply;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.api.KMossResponseHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: ContactLoadService.kt */
@IMContactScope
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lim/contact/service/ContactLoadService;", "", "<init>", "()V", "load", "Lkotlin/Result;", "Lim/contact/model/ContactsReply;", "tab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "paging", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "load-0E7RQCE$contact_debug", "(Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContactLoadService {
    /* renamed from: load-0E7RQCE$contact_debug$default  reason: not valid java name */
    public static /* synthetic */ Object m3159load0E7RQCE$contact_debug$default(ContactLoadService contactLoadService, KContactTabType kContactTabType, KPaginationParams kPaginationParams, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kContactTabType = (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            kPaginationParams = null;
        }
        return contactLoadService.m3160load0E7RQCE$contact_debug(kContactTabType, kPaginationParams, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019e  */
    /* renamed from: load-0E7RQCE$contact_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3160load0E7RQCE$contact_debug(KContactTabType tab, KPaginationParams paging, Continuation<? super Result<ContactsReply>> continuation) {
        ContactLoadService$load$1 contactLoadService$load$1;
        ContactLoadService$load$1 contactLoadService$load$12;
        KContactTabType tab2;
        KimMoss $this$iv;
        Object request$iv;
        SerializationStrategy reqSerializer$iv;
        DeserializationStrategy respSerializer$iv;
        CancellableContinuation cancellableContinuationImpl;
        KMossResponseHandler p3$iv;
        Object result;
        Object obj;
        Throwable it;
        if (continuation instanceof ContactLoadService$load$1) {
            contactLoadService$load$1 = (ContactLoadService$load$1) continuation;
            if ((contactLoadService$load$1.label & Integer.MIN_VALUE) != 0) {
                contactLoadService$load$1.label -= Integer.MIN_VALUE;
                contactLoadService$load$12 = contactLoadService$load$1;
                Object $result = contactLoadService$load$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (contactLoadService$load$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i(UtilsKt.TAG("Load"), "load tab: " + tab);
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$iv = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            try {
                                request$iv = new KContactsReq(tab, paging);
                                reqSerializer$iv = KContactsReq.Companion.serializer();
                                respSerializer$iv = ContactsReply.Companion.serializer();
                                contactLoadService$load$12.L$0 = tab;
                                contactLoadService$load$12.L$1 = SpillingKt.nullOutSpilledVariable(paging);
                                contactLoadService$load$12.L$2 = $this$iv;
                                contactLoadService$load$12.L$3 = request$iv;
                                contactLoadService$load$12.L$4 = contactLoadService$load$12;
                                contactLoadService$load$12.L$5 = reqSerializer$iv;
                                contactLoadService$load$12.L$6 = respSerializer$iv;
                                contactLoadService$load$12.I$0 = 0;
                                contactLoadService$load$12.I$1 = 0;
                                contactLoadService$load$12.I$2 = 0;
                                contactLoadService$load$12.I$3 = 0;
                                contactLoadService$load$12.I$4 = 0;
                                contactLoadService$load$12.label = 1;
                                Continuation uCont$iv$iv$iv = (Continuation) contactLoadService$load$12;
                                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv$iv$iv), 1);
                                cancellableContinuationImpl.initCancellability();
                                final CancellableContinuation it$iv$iv = cancellableContinuationImpl;
                                p3$iv = new KMossResponseHandler<ContactsReply>() { // from class: im.contact.service.ContactLoadService$load_0E7RQCE$lambda$0$$inlined$contacts$default$1
                                    private ContactsReply resp;

                                    public void onNext(ContactsReply contactsReply) {
                                        this.resp = contactsReply;
                                    }

                                    public void onCompleted() {
                                        if (it$iv$iv.isActive()) {
                                            Object result2 = this.resp;
                                            if (result2 != null) {
                                                Result.Companion companion2 = Result.Companion;
                                                it$iv$iv.resumeWith(Result.constructor-impl(result2));
                                                return;
                                            }
                                            Result.Companion companion3 = Result.Companion;
                                            it$iv$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", (Throwable) null))));
                                        }
                                    }

                                    public void onError(KMossException t) {
                                        KMossException kMossException;
                                        if (it$iv$iv.isActive()) {
                                            Continuation continuation2 = it$iv$iv;
                                            Result.Companion companion2 = Result.Companion;
                                            if (t != null) {
                                                kMossException = t;
                                            } else {
                                                kMossException = new KMossException("Unknown exception in kmoss coroutine", (Throwable) null);
                                            }
                                            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) kMossException)));
                                        }
                                    }
                                };
                            } catch (Throwable th) {
                                th = th;
                                tab2 = tab;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                JobKt.ensureActive(contactLoadService$load$12.getContext());
                                if (Result.isSuccess-impl(obj)) {
                                }
                                it = Result.exceptionOrNull-impl(obj);
                                if (it != null) {
                                }
                                return obj;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            $this$iv.contacts(request$iv, reqSerializer$iv, respSerializer$iv, p3$iv);
                            result = cancellableContinuationImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended((Continuation) contactLoadService$load$12);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            tab2 = tab;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(contactLoadService$load$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tab2 = tab;
                        try {
                            obj = Result.constructor-impl((ContactsReply) result);
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(contactLoadService$load$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(contactLoadService$load$12.getContext());
                        if (Result.isSuccess-impl(obj)) {
                            ContactsReply contactsReply = (ContactsReply) obj;
                            KLog_androidKt.getKLog().i(UtilsKt.TAG("Load"), "load success for tab " + tab2);
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            KLog_androidKt.getKLog().e(UtilsKt.TAG("Load"), "load failed on tab " + tab2, it);
                        }
                        return obj;
                    case 1:
                        int i2 = contactLoadService$load$12.I$4;
                        int i3 = contactLoadService$load$12.I$3;
                        int i4 = contactLoadService$load$12.I$2;
                        int i5 = contactLoadService$load$12.I$1;
                        int i6 = contactLoadService$load$12.I$0;
                        DeserializationStrategy deserializationStrategy = (DeserializationStrategy) contactLoadService$load$12.L$6;
                        SerializationStrategy serializationStrategy = (SerializationStrategy) contactLoadService$load$12.L$5;
                        ContactLoadService$load$1 contactLoadService$load$13 = (ContactLoadService$load$1) contactLoadService$load$12.L$4;
                        KContactsReq kContactsReq = (KContactsReq) contactLoadService$load$12.L$3;
                        KimMoss kimMoss = (KimMoss) contactLoadService$load$12.L$2;
                        KPaginationParams kPaginationParams = (KPaginationParams) contactLoadService$load$12.L$1;
                        tab2 = (KContactTabType) contactLoadService$load$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            result = $result;
                            obj = Result.constructor-impl((ContactsReply) result);
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion2222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(contactLoadService$load$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(contactLoadService$load$12.getContext());
                        if (Result.isSuccess-impl(obj)) {
                        }
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                        }
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        contactLoadService$load$1 = new ContactLoadService$load$1(this, continuation);
        contactLoadService$load$12 = contactLoadService$load$1;
        Object $result2 = contactLoadService$load$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (contactLoadService$load$12.label) {
        }
    }
}