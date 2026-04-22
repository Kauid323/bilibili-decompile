package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.im.chat.core.model.InputBoxConfig;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: InputBox.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/ui/widget/InputBoxState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "inputBoxConfig", "getInputBoxConfig", "()Lkntr/app/im/chat/core/model/InputBoxConfig;", "setInputBoxConfig", "(Lkntr/app/im/chat/core/model/InputBoxConfig;)V", "inputBoxConfig$delegate", "Landroidx/compose/runtime/MutableState;", "Lkntr/app/im/chat/core/model/InputContent;", "inputBoxContent", "getInputBoxContent", "()Lkntr/app/im/chat/core/model/InputContent;", "setInputBoxContent", "(Lkntr/app/im/chat/core/model/InputContent;)V", "inputBoxContent$delegate", "valid", RoomRecommendViewModel.EMPTY_CURSOR, "getValid", "()Z", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InputBoxState {
    public static final int $stable = 0;
    private final MutableState inputBoxConfig$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState inputBoxContent$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public final InputBoxConfig getInputBoxConfig() {
        State $this$getValue$iv = this.inputBoxConfig$delegate;
        return (InputBoxConfig) $this$getValue$iv.getValue();
    }

    public final void setInputBoxConfig(InputBoxConfig inputBoxConfig) {
        MutableState $this$setValue$iv = this.inputBoxConfig$delegate;
        $this$setValue$iv.setValue(inputBoxConfig);
    }

    public final InputContent getInputBoxContent() {
        State $this$getValue$iv = this.inputBoxContent$delegate;
        return (InputContent) $this$getValue$iv.getValue();
    }

    public final void setInputBoxContent(InputContent inputContent) {
        MutableState $this$setValue$iv = this.inputBoxContent$delegate;
        $this$setValue$iv.setValue(inputContent);
    }

    public final boolean getValid() {
        return (getInputBoxConfig() == null || getInputBoxContent() == null) ? false : true;
    }
}