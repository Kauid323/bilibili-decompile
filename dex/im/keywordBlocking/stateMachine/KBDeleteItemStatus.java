package im.keywordBlocking.stateMachine;

import im.keywordBlocking.KBListItem;
import kotlin.Metadata;

/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "", "item", "Lim/keywordBlocking/KBListItem;", "getItem", "()Lim/keywordBlocking/KBListItem;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatusFinish;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatusIdle;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatusLoading;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface KBDeleteItemStatus {
    KBListItem getItem();
}