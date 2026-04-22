package im.contact;

import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import im.contact.model.IMContactAction;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
import kotlin.Metadata;

/* compiled from: IMContactEmptyTabStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lim/contact/IMContactEmptyTabStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lim/contact/model/IMContactTab;", "Lim/contact/model/IMContactAction;", "<init>", "()V", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactEmptyTabStateMachine extends FlowReduxStateMachine<IMContactTab, IMContactAction> {
    public IMContactEmptyTabStateMachine() {
        super(IMContactTabData.Companion.getDEFAULT());
    }
}