package kntr.app.deepsearch.base.model.input;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InputState.kt */
@Lens
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00032\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 H\u0007J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J;\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012¨\u0006-"}, d2 = {"Lkntr/app/deepsearch/base/model/input/InputState;", RoomRecommendViewModel.EMPTY_CURSOR, "initInput", RoomRecommendViewModel.EMPTY_CURSOR, "inputHolder", "Lkntr/app/deepsearch/base/model/input/InputStringHolder;", "maxInputLength", RoomRecommendViewModel.EMPTY_CURSOR, "isSending", RoomRecommendViewModel.EMPTY_CURSOR, "isRefreshSessionId", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/input/InputStringHolder;IZZ)V", "getInitInput", "()Ljava/lang/String;", "getInputHolder", "()Lkntr/app/deepsearch/base/model/input/InputStringHolder;", "getMaxInputLength", "()I", "()Z", "input", "getInput", "showCursor", "getShowCursor", "senderStatus", "Lkntr/app/deepsearch/base/model/input/SenderStatus;", "getSenderStatus", "()Lkntr/app/deepsearch/base/model/input/SenderStatus;", "currentLength", "getCurrentLength", "updateInput", "versionModifier", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InputState {
    public static final Companion Companion = new Companion(null);
    private final String initInput;
    private final String input;
    private final InputStringHolder inputHolder;
    private final boolean isRefreshSessionId;
    private final boolean isSending;
    private final int maxInputLength;

    public InputState() {
        this(null, null, 0, false, false, 31, null);
    }

    public static /* synthetic */ InputState copy$default(InputState inputState, String str, InputStringHolder inputStringHolder, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inputState.initInput;
        }
        if ((i2 & 2) != 0) {
            inputStringHolder = inputState.inputHolder;
        }
        InputStringHolder inputStringHolder2 = inputStringHolder;
        if ((i2 & 4) != 0) {
            i = inputState.maxInputLength;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = inputState.isSending;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = inputState.isRefreshSessionId;
        }
        return inputState.copy(str, inputStringHolder2, i3, z3, z2);
    }

    public final String component1() {
        return this.initInput;
    }

    public final InputStringHolder component2() {
        return this.inputHolder;
    }

    public final int component3() {
        return this.maxInputLength;
    }

    public final boolean component4() {
        return this.isSending;
    }

    public final boolean component5() {
        return this.isRefreshSessionId;
    }

    public final InputState copy(String str, InputStringHolder inputStringHolder, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "initInput");
        Intrinsics.checkNotNullParameter(inputStringHolder, "inputHolder");
        return new InputState(str, inputStringHolder, i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputState) {
            InputState inputState = (InputState) obj;
            return Intrinsics.areEqual(this.initInput, inputState.initInput) && Intrinsics.areEqual(this.inputHolder, inputState.inputHolder) && this.maxInputLength == inputState.maxInputLength && this.isSending == inputState.isSending && this.isRefreshSessionId == inputState.isRefreshSessionId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.initInput.hashCode() * 31) + this.inputHolder.hashCode()) * 31) + this.maxInputLength) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSending)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRefreshSessionId);
    }

    public String toString() {
        String str = this.initInput;
        InputStringHolder inputStringHolder = this.inputHolder;
        int i = this.maxInputLength;
        boolean z = this.isSending;
        return "InputState(initInput=" + str + ", inputHolder=" + inputStringHolder + ", maxInputLength=" + i + ", isSending=" + z + ", isRefreshSessionId=" + this.isRefreshSessionId + ")";
    }

    public InputState(String initInput, InputStringHolder inputHolder, int maxInputLength, boolean isSending, boolean isRefreshSessionId) {
        Intrinsics.checkNotNullParameter(initInput, "initInput");
        Intrinsics.checkNotNullParameter(inputHolder, "inputHolder");
        this.initInput = initInput;
        this.inputHolder = inputHolder;
        this.maxInputLength = maxInputLength;
        this.isSending = isSending;
        this.isRefreshSessionId = isRefreshSessionId;
        this.input = this.inputHolder.getInput();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ InputState(String str, InputStringHolder inputStringHolder, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? new InputStringHolder(str, null, 0L, 6, null) : inputStringHolder, (i2 & 4) != 0 ? 500 : i, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
        str = (i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str;
    }

    public final String getInitInput() {
        return this.initInput;
    }

    public final InputStringHolder getInputHolder() {
        return this.inputHolder;
    }

    public final int getMaxInputLength() {
        return this.maxInputLength;
    }

    public final boolean isSending() {
        return this.isSending;
    }

    public final boolean isRefreshSessionId() {
        return this.isRefreshSessionId;
    }

    public final String getInput() {
        return this.input;
    }

    public final boolean getShowCursor() {
        return this.input.length() > 0;
    }

    public final SenderStatus getSenderStatus() {
        if (this.isRefreshSessionId) {
            return SenderStatus.SESSION_LOADING;
        }
        if (this.isSending) {
            return SenderStatus.STOP_ACTION;
        }
        if (this.input.length() <= this.maxInputLength && !StringsKt.isBlank(this.input)) {
            return SenderStatus.SEND_ALLOW;
        }
        return SenderStatus.SEND_DISALLOW;
    }

    public final int getCurrentLength() {
        return this.input.length();
    }

    /* compiled from: InputState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/input/InputState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputState updateInput$default(InputState inputState, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kntr.app.deepsearch.base.model.input.InputState$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    long updateInput$lambda$0;
                    updateInput$lambda$0 = InputState.updateInput$lambda$0(((Long) obj2).longValue());
                    return Long.valueOf(updateInput$lambda$0);
                }
            };
        }
        return inputState.updateInput(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long updateInput$lambda$0(long it) {
        return it;
    }

    public final InputState updateInput(String input, Function1<? super Long, Long> function1) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(function1, "versionModifier");
        return copy$default(this, null, new InputStringHolder(input, null, ((Number) function1.invoke(Long.valueOf(this.inputHolder.getVersion()))).longValue(), 2, null), 0, false, false, 29, null);
    }
}