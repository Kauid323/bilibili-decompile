package kntr.base.dd.impl.internal.decide;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.base.dd.impl.internal.decide.Operator;
import kntr.base.dd.impl.internal.decide.comparator.DDComparator;
import kntr.base.dd.impl.internal.decide.comparator.DDTimeStampComparator;
import kntr.base.dd.impl.internal.decide.comparator.DDVersionComparator;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.model.DDNodeOperationConfig;
import kntr.base.dd.impl.internal.property.IPropertyCenter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DecisionMaker.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0003 !\"B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001aJ\u001c\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionMaker;", "", "propertyCenter", "Lkntr/base/dd/impl/internal/property/IPropertyCenter;", "verbose", "", "<init>", "(Lkntr/base/dd/impl/internal/property/IPropertyCenter;Z)V", "props", "", "", "Lkntr/base/dd/impl/internal/decide/DecisionMaker$Prop;", "_process", "", "Lkntr/base/dd/impl/internal/decide/DecisionMaker$ProcessData;", "usedProps", "", "getUsedProps", "()Ljava/util/Set;", "process", "", "getProcess", "()Ljava/util/List;", "decide", "Lkntr/base/dd/impl/internal/decide/DecisionMaker$Result;", "node", "Lkntr/base/dd/impl/internal/model/DDNode;", "needTrack", "track", "getProp", "name", "extra", "Result", "ProcessData", "Prop", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DecisionMaker {
    private final List<ProcessData> _process;
    private final IPropertyCenter propertyCenter;
    private final Map<String, Prop> props;
    private final boolean verbose;

    public DecisionMaker(IPropertyCenter propertyCenter, boolean verbose) {
        Intrinsics.checkNotNullParameter(propertyCenter, "propertyCenter");
        this.propertyCenter = propertyCenter;
        this.verbose = verbose;
        this.props = new LinkedHashMap();
        this._process = new ArrayList();
    }

    public /* synthetic */ DecisionMaker(IPropertyCenter iPropertyCenter, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPropertyCenter, (i & 2) != 0 ? false : z);
    }

    /* compiled from: DecisionMaker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionMaker$Result;", "", "hit", "", "value", "", "canCache", "<init>", "(ZLjava/lang/String;Z)V", "getHit", "()Z", "getCanCache", "getValue", "()Ljava/lang/String;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Result {
        private final boolean canCache;
        private final boolean hit;
        private final String value;

        public Result(boolean hit, String value, boolean canCache) {
            this.hit = hit;
            this.canCache = canCache;
            this.value = this.hit ? value : null;
        }

        public final boolean getHit() {
            return this.hit;
        }

        public final boolean getCanCache() {
            return this.canCache;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: DecisionMaker.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionMaker$ProcessData;", "", "value", "", "pName", "", "pValue", "op", "Lkntr/base/dd/impl/internal/decide/Operator;", "inputValue", "extraMsg", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lkntr/base/dd/impl/internal/decide/Operator;Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Z", "getPName", "()Ljava/lang/String;", "getPValue", "getOp", "()Lkntr/base/dd/impl/internal/decide/Operator;", "getInputValue", "getExtraMsg", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ProcessData {
        private final String extraMsg;
        private final String inputValue;
        private final Operator op;
        private final String pName;
        private final String pValue;
        private final boolean value;

        public static /* synthetic */ ProcessData copy$default(ProcessData processData, boolean z, String str, String str2, Operator operator, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = processData.value;
            }
            if ((i & 2) != 0) {
                str = processData.pName;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = processData.pValue;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                operator = processData.op;
            }
            Operator operator2 = operator;
            if ((i & 16) != 0) {
                str3 = processData.inputValue;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                str4 = processData.extraMsg;
            }
            return processData.copy(z, str5, str6, operator2, str7, str4);
        }

        public final boolean component1() {
            return this.value;
        }

        public final String component2() {
            return this.pName;
        }

        public final String component3() {
            return this.pValue;
        }

        public final Operator component4() {
            return this.op;
        }

        public final String component5() {
            return this.inputValue;
        }

        public final String component6() {
            return this.extraMsg;
        }

        public final ProcessData copy(boolean z, String str, String str2, Operator operator, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "pName");
            return new ProcessData(z, str, str2, operator, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProcessData) {
                ProcessData processData = (ProcessData) obj;
                return this.value == processData.value && Intrinsics.areEqual(this.pName, processData.pName) && Intrinsics.areEqual(this.pValue, processData.pValue) && Intrinsics.areEqual(this.op, processData.op) && Intrinsics.areEqual(this.inputValue, processData.inputValue) && Intrinsics.areEqual(this.extraMsg, processData.extraMsg);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.value) * 31) + this.pName.hashCode()) * 31) + (this.pValue == null ? 0 : this.pValue.hashCode())) * 31) + (this.op == null ? 0 : this.op.hashCode())) * 31) + (this.inputValue == null ? 0 : this.inputValue.hashCode())) * 31) + (this.extraMsg != null ? this.extraMsg.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.value;
            String str = this.pName;
            String str2 = this.pValue;
            Operator operator = this.op;
            String str3 = this.inputValue;
            return "ProcessData(value=" + z + ", pName=" + str + ", pValue=" + str2 + ", op=" + operator + ", inputValue=" + str3 + ", extraMsg=" + this.extraMsg + ")";
        }

        public ProcessData(boolean value, String pName, String pValue, Operator op, String inputValue, String extraMsg) {
            Intrinsics.checkNotNullParameter(pName, "pName");
            this.value = value;
            this.pName = pName;
            this.pValue = pValue;
            this.op = op;
            this.inputValue = inputValue;
            this.extraMsg = extraMsg;
        }

        public /* synthetic */ ProcessData(boolean z, String str, String str2, Operator operator, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : operator, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
        }

        public final boolean getValue() {
            return this.value;
        }

        public final String getPName() {
            return this.pName;
        }

        public final String getPValue() {
            return this.pValue;
        }

        public final Operator getOp() {
            return this.op;
        }

        public final String getInputValue() {
            return this.inputValue;
        }

        public final String getExtraMsg() {
            return this.extraMsg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecisionMaker.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionMaker$Prop;", "", "name", "", "value", "cacheable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "getCacheable", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Prop {
        private final boolean cacheable;
        private final String name;
        private final String value;

        public static /* synthetic */ Prop copy$default(Prop prop, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = prop.name;
            }
            if ((i & 2) != 0) {
                str2 = prop.value;
            }
            if ((i & 4) != 0) {
                z = prop.cacheable;
            }
            return prop.copy(str, str2, z);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.value;
        }

        public final boolean component3() {
            return this.cacheable;
        }

        public final Prop copy(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new Prop(str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Prop) {
                Prop prop = (Prop) obj;
                return Intrinsics.areEqual(this.name, prop.name) && Intrinsics.areEqual(this.value, prop.value) && this.cacheable == prop.cacheable;
            }
            return false;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.cacheable);
        }

        public String toString() {
            String str = this.name;
            String str2 = this.value;
            return "Prop(name=" + str + ", value=" + str2 + ", cacheable=" + this.cacheable + ")";
        }

        public Prop(String name, String value, boolean cacheable) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = value;
            this.cacheable = cacheable;
        }

        public final String getName() {
            return this.name;
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean getCacheable() {
            return this.cacheable;
        }
    }

    public final Set<String> getUsedProps() {
        Iterable $this$map$iv = this.props.values();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Prop it = (Prop) item$iv$iv;
            destination$iv$iv.add(it.getName());
        }
        return CollectionsKt.toSet((List) destination$iv$iv);
    }

    public final List<ProcessData> getProcess() {
        return this._process;
    }

    public final Result decide(DDNode node) {
        Object obj;
        DDVersionComparator dDVersionComparator;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(node, "node");
        String value = node.getValue();
        Operator operator = OperatorKt.parseOperator(node.getOperator());
        boolean z = true;
        if (operator == null) {
            if (value == null) {
                throw new IllegalStateException("both the operator and the value are nil.".toString());
            }
            return new Result(true, value, true);
        } else if (operator instanceof Operator.Logic) {
            DDNode left = node.getLeft();
            if (left == null) {
                throw new IllegalStateException("operator in [and, or, inver], but left is nil".toString());
            }
            if (operator == Operator.Logic.And) {
                DDNode right = node.getRight();
                if (right == null) {
                    throw new IllegalStateException("operator is and, but right is nil".toString());
                }
                Result lv = decide(left);
                if (!lv.getHit()) {
                    return new Result(false, value == null ? lv.getValue() : value, lv.getCanCache());
                }
                Result rv = decide(right);
                boolean hit = rv.getHit();
                if (value == null) {
                    str2 = lv.getValue();
                    if (str2 == null) {
                        str2 = rv.getValue();
                    }
                } else {
                    str2 = value;
                }
                if (!lv.getCanCache() || !rv.getCanCache()) {
                    z = false;
                }
                return new Result(hit, str2, z);
            }
            Result lv2 = decide(left);
            if (operator == Operator.Logic.Inver) {
                return new Result(true ^ lv2.getHit(), value == null ? lv2.getValue() : value, lv2.getCanCache());
            }
            DDNode right2 = node.getRight();
            if (lv2.getHit() || right2 == null) {
                return new Result(lv2.getHit(), value == null ? lv2.getValue() : value, lv2.getCanCache());
            }
            Result rv2 = decide(right2);
            boolean hit2 = rv2.getHit();
            if (value == null) {
                str = rv2.getValue();
                if (str == null) {
                    str = lv2.getValue();
                }
            } else {
                str = value;
            }
            if (!lv2.getCanCache() || !rv2.getCanCache()) {
                z = false;
            }
            return new Result(hit2, str, z);
        } else {
            String input = node.getInput();
            if (operator == Operator.Custom.Bucket) {
                DDBucket bucket = DDBucket.Companion.decodeFromString(input);
                if (bucket == null) {
                    throw new IllegalStateException("bucket configuration error".toString());
                }
                Prop prop = getProp(bucket.getPName(), null);
                String value2 = prop.getValue();
                if (value2 == null) {
                    value2 = "0";
                }
                String pValue = value2;
                return decide$createResult(input, value, this, operator, bucket.decide(pValue), prop, null);
            } else if (operator instanceof Operator.Compare) {
                String pName = node.getProperty();
                if (pName == null) {
                    throw new IllegalStateException((operator + " need 'p'").toString());
                }
                Prop prop2 = getProp(pName, node.getExtra());
                Utils.Companion companion = Utils.Companion;
                String string$iv = node.getExtra();
                if (string$iv == null) {
                    obj = null;
                } else {
                    try {
                        Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                        json$iv.getSerializersModule();
                        obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(DDNodeOperationConfig.Companion.serializer()), string$iv);
                    } catch (Exception e$iv) {
                        DDConst dDConst = DDConst.INSTANCE;
                        String message = e$iv.getMessage();
                        if (message == null) {
                            message = "undefined";
                        }
                        DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
                        obj = null;
                    }
                }
                DDNodeOperationConfig config = (DDNodeOperationConfig) obj;
                if ((config != null ? config.getRepeatMode() : null) != null) {
                    DDNodeOperationConfig.RepeatMode repeatMode = config.getRepeatMode();
                    Intrinsics.checkNotNull(repeatMode);
                    dDVersionComparator = new DDTimeStampComparator(prop2.getValue(), (Operator.Compare) operator, input, config, repeatMode);
                } else {
                    dDVersionComparator = (config != null ? config.getComparatorType() : null) == DDNodeOperationConfig.ComparatorType.DefaultVersion ? new DDVersionComparator(prop2.getValue(), (Operator.Compare) operator, input, config) : new DDComparator(prop2.getValue(), (Operator.Compare) operator, input, config);
                }
                DDComparator comparator = dDVersionComparator;
                return decide$createResult$default(input, value, this, operator, comparator.compare(), prop2, null, 64, null);
            } else {
                throw new IllegalStateException(("operator " + operator.getRaw() + " not support!").toString());
            }
        }
    }

    static /* synthetic */ Result decide$createResult$default(String str, String str2, DecisionMaker decisionMaker, Operator operator, boolean z, Prop prop, String str3, int i, Object obj) {
        String str4;
        if ((i & 64) == 0) {
            str4 = str3;
        } else {
            str4 = str;
        }
        return decide$createResult(str, str2, decisionMaker, operator, z, prop, str4);
    }

    private static final Result decide$createResult(String input, String value, DecisionMaker this$0, Operator operator, boolean hit, Prop prop, String inputValue) {
        Result it = new Result(hit, value, prop.getCacheable());
        if (this$0.verbose) {
            this$0._process.add(new ProcessData(it.getHit(), prop.getName(), prop.getValue(), operator, inputValue, null, 32, null));
        }
        return it;
    }

    public final boolean needTrack(DDNode track) {
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(track, "track");
        Result ddResult = decide(track);
        String value = ddResult.getValue();
        if (value == null || (doubleOrNull = StringsKt.toDoubleOrNull(value)) == null) {
            return false;
        }
        int sampleRate = Double.compare(doubleOrNull.doubleValue(), Random.Default.nextDouble(0.0d, 1.0d));
        return sampleRate > 0;
    }

    static /* synthetic */ Prop getProp$default(DecisionMaker decisionMaker, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return decisionMaker.getProp(str, str2);
    }

    private final Prop getProp(String name, String extra) {
        String key = name + ":" + (extra == null ? "" : extra);
        Prop prop = this.props.get(key);
        if (prop == null) {
            Prop it = new Prop(name, this.propertyCenter.get(name, extra), this.propertyCenter.isCacheableProp(name));
            this.props.put(key, it);
            return it;
        }
        return prop;
    }
}