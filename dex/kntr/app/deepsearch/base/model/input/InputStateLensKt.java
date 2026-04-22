package kntr.app.deepsearch.base.model.input;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputStateLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u0013\u0010\u001c\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0017\u0010\u001c\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 \"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 \"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00110\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010 \"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010 \"B\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010)\u001a\u0004\b\u000b\u0010*\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010)\u001a\u0004\b\u000f\u0010*\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00110\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010)\u001a\u0004\b\u0013\u0010*\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010)\u001a\u0004\b\u0014\u0010*\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00150\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010)\u001a\u0004\b\u0017\u0010*¨\u0006+"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/input/InputState;", "Lkntr/app/deepsearch/base/model/input/InputState$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/input/InputState$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/input/InputState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "initInput", RoomRecommendViewModel.EMPTY_CURSOR, "getInitInput$annotations", "getInitInput", "inputHolder", "Lkntr/app/deepsearch/base/model/input/InputStringHolder;", "getInputHolder$annotations", "getInputHolder", "maxInputLength", RoomRecommendViewModel.EMPTY_CURSOR, "getMaxInputLength$annotations", "getMaxInputLength", "isSending", RoomRecommendViewModel.EMPTY_CURSOR, "isSending$annotations", "isRefreshSessionId", "isRefreshSessionId$annotations", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "initInputNullable$annotations", "initInputNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "inputHolderNullable$annotations", "inputHolderNullable", "maxInputLengthNullable$annotations", "maxInputLengthNullable", "isSendingNullable$annotations", "isSendingNullable", "isRefreshSessionIdNullable$annotations", "isRefreshSessionIdNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputStateLensKt {
    public static /* synthetic */ void getInitInput$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInitInput$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInitInput$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void getInputHolder$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputHolder$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputHolder$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void getMaxInputLength$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMaxInputLength$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMaxInputLength$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void initInputNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void inputHolderNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isRefreshSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isRefreshSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isRefreshSessionId$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void isRefreshSessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isSending$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isSending$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isSending$annotations(InputState.Companion companion) {
    }

    public static /* synthetic */ void isSendingNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void maxInputLengthNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<InputState, InputState> getLens(InputState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, InputState>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$1
            public InputState get(InputState inputState) {
                InputState it = inputState;
                return it;
            }

            public InputState set(InputState inputState, InputState inputState2) {
                InputState it = inputState2;
                return it;
            }

            public InputState modify(InputState inputState, Function1<? super InputState, ? extends InputState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                return (InputState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<InputState, String> getInitInput(InputState.Companion $this$initInput) {
        Intrinsics.checkNotNullParameter($this$initInput, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, String>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$2
            public String get(InputState inputState) {
                InputState it = inputState;
                return it.getInitInput();
            }

            public InputState set(InputState inputState, String str) {
                String initInput = str;
                InputState it = inputState;
                return InputState.copy$default(it, initInput, null, 0, false, false, 30, null);
            }

            public InputState modify(InputState inputState, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                String initInput = (String) function1.invoke(it.getInitInput());
                InputState it2 = inputState;
                return InputState.copy$default(it2, initInput, null, 0, false, false, 30, null);
            }
        };
    }

    public static final BSimpleLens<InputState, InputStringHolder> getInputHolder(InputState.Companion $this$inputHolder) {
        Intrinsics.checkNotNullParameter($this$inputHolder, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, InputStringHolder>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$3
            public InputStringHolder get(InputState inputState) {
                InputState it = inputState;
                return it.getInputHolder();
            }

            public InputState set(InputState inputState, InputStringHolder inputStringHolder) {
                InputStringHolder inputHolder = inputStringHolder;
                InputState it = inputState;
                return InputState.copy$default(it, null, inputHolder, 0, false, false, 29, null);
            }

            public InputState modify(InputState inputState, Function1<? super InputStringHolder, ? extends InputStringHolder> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                InputStringHolder inputHolder = (InputStringHolder) function1.invoke(it.getInputHolder());
                InputState it2 = inputState;
                return InputState.copy$default(it2, null, inputHolder, 0, false, false, 29, null);
            }
        };
    }

    public static final BSimpleLens<InputState, Integer> getMaxInputLength(InputState.Companion $this$maxInputLength) {
        Intrinsics.checkNotNullParameter($this$maxInputLength, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, Integer>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$4
            public Integer get(InputState inputState) {
                InputState it = inputState;
                return Integer.valueOf(it.getMaxInputLength());
            }

            public InputState set(InputState inputState, Integer num) {
                int maxInputLength = num.intValue();
                InputState it = inputState;
                return InputState.copy$default(it, null, null, maxInputLength, false, false, 27, null);
            }

            public InputState modify(InputState inputState, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                int maxInputLength = ((Number) function1.invoke(Integer.valueOf(it.getMaxInputLength()))).intValue();
                InputState it2 = inputState;
                return InputState.copy$default(it2, null, null, maxInputLength, false, false, 27, null);
            }
        };
    }

    public static final BSimpleLens<InputState, Boolean> isSending(InputState.Companion $this$isSending) {
        Intrinsics.checkNotNullParameter($this$isSending, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, Boolean>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$5
            public Boolean get(InputState inputState) {
                InputState it = inputState;
                return Boolean.valueOf(it.isSending());
            }

            public InputState set(InputState inputState, Boolean bool) {
                boolean isSending = bool.booleanValue();
                InputState it = inputState;
                return InputState.copy$default(it, null, null, 0, isSending, false, 23, null);
            }

            public InputState modify(InputState inputState, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                boolean isSending = ((Boolean) function1.invoke(Boolean.valueOf(it.isSending()))).booleanValue();
                InputState it2 = inputState;
                return InputState.copy$default(it2, null, null, 0, isSending, false, 23, null);
            }
        };
    }

    public static final BSimpleLens<InputState, Boolean> isRefreshSessionId(InputState.Companion $this$isRefreshSessionId) {
        Intrinsics.checkNotNullParameter($this$isRefreshSessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputState, Boolean>() { // from class: kntr.app.deepsearch.base.model.input.InputStateLensKt$special$$inlined$invoke$6
            public Boolean get(InputState inputState) {
                InputState it = inputState;
                return Boolean.valueOf(it.isRefreshSessionId());
            }

            public InputState set(InputState inputState, Boolean bool) {
                boolean isRefreshSessionId = bool.booleanValue();
                InputState it = inputState;
                return InputState.copy$default(it, null, null, 0, false, isRefreshSessionId, 15, null);
            }

            public InputState modify(InputState inputState, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputState it = inputState;
                boolean isRefreshSessionId = ((Boolean) function1.invoke(Boolean.valueOf(it.isRefreshSessionId()))).booleanValue();
                InputState it2 = inputState;
                return InputState.copy$default(it2, null, null, 0, false, isRefreshSessionId, 15, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getInitInput(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInitInput(InputState.Companion));
    }

    public static final <T> BSimpleLens<T, InputStringHolder> getInputHolder(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputHolder(InputState.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getMaxInputLength(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMaxInputLength(InputState.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isSending(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isSending(InputState.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isRefreshSessionId(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isRefreshSessionId(InputState.Companion));
    }

    public static final <T> BNullableLens<T, String> initInputNullable(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInitInput(InputState.Companion));
    }

    public static final <T> BNullableLens<T, InputStringHolder> inputHolderNullable(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputHolder(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Integer> maxInputLengthNullable(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMaxInputLength(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isSendingNullable(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isSending(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isRefreshSessionIdNullable(BSimpleLens<T, InputState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isRefreshSessionId(InputState.Companion));
    }

    public static final <T> BNullableLens<T, String> getInitInput(BNullableLens<T, InputState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInitInput(InputState.Companion));
    }

    public static final <T> BNullableLens<T, InputStringHolder> getInputHolder(BNullableLens<T, InputState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputHolder(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getMaxInputLength(BNullableLens<T, InputState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMaxInputLength(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isSending(BNullableLens<T, InputState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isSending(InputState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isRefreshSessionId(BNullableLens<T, InputState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isRefreshSessionId(InputState.Companion));
    }
}