package kntr.base.dd.impl.internal.debugger;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.decide.DecisionMaker;
import kntr.base.dd.impl.internal.decide.Operator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: DDDebugger.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"debugString", "", "Lkntr/base/dd/impl/internal/decide/DecisionMaker$ProcessData;", "toMathOperatorString", "Lkntr/base/dd/impl/internal/decide/Operator;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDebuggerKt {

    /* compiled from: DDDebugger.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Operator.Compare.values().length];
            try {
                iArr[Operator.Compare.GreaterThan.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Operator.Compare.LessThan.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Operator.Compare.GreaterOrEqual.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Operator.Compare.LessOrEqual.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Operator.Compare.Equal.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Operator.Compare.NotEqual.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Operator.Compare.In.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Operator.Compare.NotIn.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Operator.Logic.values().length];
            try {
                iArr2[Operator.Logic.And.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr2[Operator.Logic.Or.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr2[Operator.Logic.Inver.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final /* synthetic */ String access$debugString(DecisionMaker.ProcessData $receiver) {
        return debugString($receiver);
    }

    public static final String debugString(DecisionMaker.ProcessData $this$debugString) {
        String inputValue;
        String result;
        String pName = $this$debugString.getPName();
        String pValue = $this$debugString.getPValue();
        if (pValue == null) {
            pValue = "";
        }
        String base = pName + "(" + pValue + ")";
        if ($this$debugString.getOp() == Operator.Custom.Bucket) {
            result = "[ " + base + " ] => " + ($this$debugString.getValue() ? "" : "未") + "命中分桶";
        } else {
            Operator op = $this$debugString.getOp();
            result = "[ " + base + " " + (op != null ? toMathOperatorString(op) : null) + " " + ($this$debugString.getInputValue() != null ? inputValue : "") + " ] => " + $this$debugString.getValue();
        }
        String extraMsg = $this$debugString.getExtraMsg();
        if (extraMsg == null || extraMsg.length() == 0) {
            return result;
        }
        return result + " [other message: " + $this$debugString.getExtraMsg() + "]";
    }

    private static final String toMathOperatorString(Operator $this$toMathOperatorString) {
        if ($this$toMathOperatorString instanceof Operator.Compare) {
            switch (WhenMappings.$EnumSwitchMapping$0[((Operator.Compare) $this$toMathOperatorString).ordinal()]) {
                case 1:
                    return ">";
                case 2:
                    return "<";
                case 3:
                    return "≥";
                case 4:
                    return "≤";
                case 5:
                    return "=";
                case 6:
                    return "!=";
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    return "in";
                case 8:
                    return "!in";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if ($this$toMathOperatorString instanceof Operator.Logic) {
            switch (WhenMappings.$EnumSwitchMapping$1[((Operator.Logic) $this$toMathOperatorString).ordinal()]) {
                case 1:
                    return "&&";
                case 2:
                    return "||";
                case 3:
                    return "!";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            return $this$toMathOperatorString.getRaw();
        }
    }
}