package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import im.session.IMState;
import im.session.model.IMSessionPageData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMSessionDataSourceServiceLike.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lim/session/service/IMSessionDataSourceServiceLike;", "", "load", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lim/session/model/IMSessionPageData;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "state", "Lim/session/IMState;", "loadCache", "", "loadNext", "loadNext-0E7RQCE", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lim/session/IMState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionDataSourceServiceLike {
    Flow<Result<IMSessionPageData>> load(KSessionPageType kSessionPageType, IMState iMState, boolean z);

    /* renamed from: loadNext-0E7RQCE  reason: not valid java name */
    Object mo3356loadNext0E7RQCE(KSessionPageType kSessionPageType, IMState iMState, Continuation<? super Result<IMSessionPageData>> continuation);
}