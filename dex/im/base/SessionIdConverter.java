package im.base;

import com.bapis.bilibili.app.im.v1.KSessionId;
import im.base.model.SessionId;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: SessionIdConverter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lim/base/SessionIdConverter;", "ID", "Lim/base/model/SessionId;", "", "kType", "Lkotlin/reflect/KClass;", "Lcom/bapis/bilibili/app/im/v1/KSessionId$IId;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "convertToSessionId", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)Lim/base/model/SessionId;", "convertToKSessionId", "id", "(Lim/base/model/SessionId;)Lcom/bapis/bilibili/app/im/v1/KSessionId;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionIdConverter<ID extends SessionId> {
    KSessionId convertToKSessionId(ID id);

    ID convertToSessionId(KSessionId kSessionId);

    KClass<? extends KSessionId.IId> getKType();

    KClass<? extends SessionId> getType();
}