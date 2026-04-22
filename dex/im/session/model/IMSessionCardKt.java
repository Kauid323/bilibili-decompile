package im.session.model;

import com.bapis.bilibili.app.im.v1.KOperationContent;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionOperation;
import com.xiaomi.mipush.sdk.Constants;
import im.session.IMActionClearSessionUnread;
import im.session.IMActionSessionDelete;
import im.session.IMActionSessionPin;
import im.session.IMActionUnBlockSession;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionCard.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u0015\u0010\t\u001a\u00020\n*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"updatePinState", "Lcom/bapis/bilibili/app/im/v1/KSessionOperation;", "isPinned", "", "toOperations", "", "Lim/session/model/IMSessionCardOperation;", "card", "Lim/session/model/IMSessionCard;", "stringId", "", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getStringId", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)Ljava/lang/String;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionCardKt {
    public static final KSessionOperation updatePinState(KSessionOperation $this$updatePinState, boolean isPinned) {
        Intrinsics.checkNotNullParameter($this$updatePinState, "<this>");
        KOperationContent pin = $this$updatePinState.getPin();
        KOperationContent copy$default = pin != null ? KOperationContent.copy$default(pin, !isPinned, (String) null, 2, (Object) null) : null;
        KOperationContent unpin = $this$updatePinState.getUnpin();
        return KSessionOperation.copy$default($this$updatePinState, copy$default, unpin != null ? KOperationContent.copy$default(unpin, isPinned, (String) null, 2, (Object) null) : null, (KOperationContent) null, (KOperationContent) null, (KOperationContent) null, 28, (Object) null);
    }

    public static final List<IMSessionCardOperation> toOperations(KSessionOperation $this$toOperations, IMSessionCard card) {
        List result = new ArrayList();
        KOperationContent it = $this$toOperations.getUnblock();
        if (it != null && it.getShow()) {
            result.add(new IMSessionCardOperation(IMSessionCardOperationType.UNBLOCK, it.getText(), new IMActionUnBlockSession(card)));
        }
        KOperationContent it2 = $this$toOperations.getClearUnread();
        if (it2 != null && it2.getShow()) {
            result.add(new IMSessionCardOperation(IMSessionCardOperationType.CLEAR_UNREAD, it2.getText(), new IMActionClearSessionUnread(card)));
        }
        KOperationContent it3 = $this$toOperations.getPin();
        if (it3 != null && it3.getShow()) {
            result.add(new IMSessionCardOperation(IMSessionCardOperationType.PIN, it3.getText(), new IMActionSessionPin(card)));
        }
        KOperationContent it4 = $this$toOperations.getUnpin();
        if (it4 != null && it4.getShow()) {
            result.add(new IMSessionCardOperation(IMSessionCardOperationType.UNPIN, it4.getText(), new IMActionSessionPin(card)));
        }
        KOperationContent it5 = $this$toOperations.getDelete();
        if (it5 != null && it5.getShow()) {
            result.add(new IMSessionCardOperation(IMSessionCardOperationType.DELETE, it5.getText(), new IMActionSessionDelete(card)));
        }
        return CollectionsKt.toList(result);
    }

    public static final String getStringId(KSessionId $this$stringId) {
        Intrinsics.checkNotNullParameter($this$stringId, "<this>");
        KSessionId.KPrivateId id = $this$stringId.getId();
        if (id instanceof KSessionId.KPrivateId) {
            return "private-" + id.getValue().getTalkerUid();
        } else if (id instanceof KSessionId.KGroupId) {
            return "group-" + ((KSessionId.KGroupId) id).getValue().getGroupId();
        } else if (id instanceof KSessionId.KFoldId) {
            return "fold-" + ((KSessionId.KFoldId) id).getValue().getType().getName();
        } else if (id instanceof KSessionId.KSystemId) {
            return "system";
        } else {
            if (id instanceof KSessionId.KCustomerId) {
                long shopType = ((KSessionId.KCustomerId) id).getValue().getShopType();
                return "customer-" + shopType + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((KSessionId.KCustomerId) id).getValue().getShopId();
            }
            return $this$stringId.toString();
        }
    }
}