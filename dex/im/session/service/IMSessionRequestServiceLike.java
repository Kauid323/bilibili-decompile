package im.session.service;

import im.session.model.IMSessionPageData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IMSessionRequestServiceLike.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lim/session/service/IMSessionRequestServiceLike;", "", "load", "Lim/session/model/IMSessionPageData;", "param", "Lim/session/service/IMSessionRequestParam;", "(Lim/session/service/IMSessionRequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionRequestServiceLike {
    Object load(IMSessionRequestParam iMSessionRequestParam, Continuation<? super IMSessionPageData> continuation);
}