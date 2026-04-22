package im.keywordBlocking.stateMachine;

import dagger.assisted.AssistedFactory;
import im.keywordBlocking.KBListItem;
import im.keywordBlocking.di.KBScope;
import kotlin.Metadata;

/* compiled from: KBChildStateMachineBuilder.kt */
@KBScope
@AssistedFactory
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "", "build", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine;", "item", "Lim/keywordBlocking/KBListItem;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface KBDeleteItemStateMachineBuilder {
    KBDeleteItemStateMachine build(KBListItem kBListItem);
}