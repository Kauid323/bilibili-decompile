package kntr.base.dd.impl.internal.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DDModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 H2\u00020\u0001:\u0002GHB\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fB\u007f\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0086\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0011HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\bFR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010+\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010*R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018¨\u0006I"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNode;", "", "name", "", "operator", "left", "right", "value", "property", "input", "extra", AppKey.VERSION, "", "expiredTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNode;Lkntr/base/dd/impl/internal/model/DDNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNode;Lkntr/base/dd/impl/internal/model/DDNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getOperator$annotations", "getOperator", "getLeft$annotations", "getLeft", "()Lkntr/base/dd/impl/internal/model/DDNode;", "getRight$annotations", "getRight", "getValue$annotations", "getValue", "getProperty$annotations", "getProperty", "getInput$annotations", "getInput", "getExtra$annotations", "getExtra", "getVersion$annotations", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiredTime$annotations", "getExpiredTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNode;Lkntr/base/dd/impl/internal/model/DDNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/base/dd/impl/internal/model/DDNode;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_debug", "$serializer", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DDNode {
    public static final Companion Companion = new Companion(null);
    private final String expiredTime;
    private final String extra;
    private final String input;
    private final DDNode left;
    private final String name;
    private final String operator;
    private final String property;
    private final DDNode right;
    private final String value;
    private final Long version;

    public DDNode() {
        this((String) null, (String) null, (DDNode) null, (DDNode) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    @SerialName("et")
    public static /* synthetic */ void getExpiredTime$annotations() {
    }

    @SerialName("e")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("i")
    public static /* synthetic */ void getInput$annotations() {
    }

    @SerialName("l")
    public static /* synthetic */ void getLeft$annotations() {
    }

    @SerialName("n")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("o")
    public static /* synthetic */ void getOperator$annotations() {
    }

    @SerialName("p")
    public static /* synthetic */ void getProperty$annotations() {
    }

    @SerialName("r")
    public static /* synthetic */ void getRight$annotations() {
    }

    @SerialName("v")
    public static /* synthetic */ void getValue$annotations() {
    }

    @SerialName("pv")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.expiredTime;
    }

    public final String component2() {
        return this.operator;
    }

    public final DDNode component3() {
        return this.left;
    }

    public final DDNode component4() {
        return this.right;
    }

    public final String component5() {
        return this.value;
    }

    public final String component6() {
        return this.property;
    }

    public final String component7() {
        return this.input;
    }

    public final String component8() {
        return this.extra;
    }

    public final Long component9() {
        return this.version;
    }

    public final DDNode copy(String str, String str2, DDNode dDNode, DDNode dDNode2, String str3, String str4, String str5, String str6, Long l, String str7) {
        return new DDNode(str, str2, dDNode, dDNode2, str3, str4, str5, str6, l, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DDNode) {
            DDNode dDNode = (DDNode) obj;
            return Intrinsics.areEqual(this.name, dDNode.name) && Intrinsics.areEqual(this.operator, dDNode.operator) && Intrinsics.areEqual(this.left, dDNode.left) && Intrinsics.areEqual(this.right, dDNode.right) && Intrinsics.areEqual(this.value, dDNode.value) && Intrinsics.areEqual(this.property, dDNode.property) && Intrinsics.areEqual(this.input, dDNode.input) && Intrinsics.areEqual(this.extra, dDNode.extra) && Intrinsics.areEqual(this.version, dDNode.version) && Intrinsics.areEqual(this.expiredTime, dDNode.expiredTime);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.operator == null ? 0 : this.operator.hashCode())) * 31) + (this.left == null ? 0 : this.left.hashCode())) * 31) + (this.right == null ? 0 : this.right.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + (this.property == null ? 0 : this.property.hashCode())) * 31) + (this.input == null ? 0 : this.input.hashCode())) * 31) + (this.extra == null ? 0 : this.extra.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31) + (this.expiredTime != null ? this.expiredTime.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.operator;
        DDNode dDNode = this.left;
        DDNode dDNode2 = this.right;
        String str3 = this.value;
        String str4 = this.property;
        String str5 = this.input;
        String str6 = this.extra;
        Long l = this.version;
        return "DDNode(name=" + str + ", operator=" + str2 + ", left=" + dDNode + ", right=" + dDNode2 + ", value=" + str3 + ", property=" + str4 + ", input=" + str5 + ", extra=" + str6 + ", version=" + l + ", expiredTime=" + this.expiredTime + ")";
    }

    /* compiled from: DDModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNode$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/dd/impl/internal/model/DDNode;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DDNode> serializer() {
            return DDNode$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DDNode(int seen0, String name, String operator, DDNode left, DDNode right, String value, String property, String input, String extra, Long version, String expiredTime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 2) == 0) {
            this.operator = null;
        } else {
            this.operator = operator;
        }
        if ((seen0 & 4) == 0) {
            this.left = null;
        } else {
            this.left = left;
        }
        if ((seen0 & 8) == 0) {
            this.right = null;
        } else {
            this.right = right;
        }
        if ((seen0 & 16) == 0) {
            this.value = null;
        } else {
            this.value = value;
        }
        if ((seen0 & 32) == 0) {
            this.property = null;
        } else {
            this.property = property;
        }
        if ((seen0 & 64) == 0) {
            this.input = null;
        } else {
            this.input = input;
        }
        if ((seen0 & 128) == 0) {
            this.extra = null;
        } else {
            this.extra = extra;
        }
        if ((seen0 & 256) == 0) {
            this.version = null;
        } else {
            this.version = version;
        }
        if ((seen0 & 512) == 0) {
            this.expiredTime = null;
        } else {
            this.expiredTime = expiredTime;
        }
    }

    public DDNode(String name, String operator, DDNode left, DDNode right, String value, String property, String input, String extra, Long version, String expiredTime) {
        this.name = name;
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.value = value;
        this.property = property;
        this.input = input;
        this.extra = extra;
        this.version = version;
        this.expiredTime = expiredTime;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_debug(DDNode self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.operator != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.operator);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.left != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, DDNode$$serializer.INSTANCE, self.left);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.right != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DDNode$$serializer.INSTANCE, self.right);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.value != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.value);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.property != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.property);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.input != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.input);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.extra != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.extra);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.version != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.version);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.expiredTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.expiredTime);
        }
    }

    public /* synthetic */ DDNode(String str, String str2, DDNode dDNode, DDNode dDNode2, String str3, String str4, String str5, String str6, Long l, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : dDNode, (i & 8) != 0 ? null : dDNode2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : l, (i & 512) == 0 ? str7 : null);
    }

    public final String getName() {
        return this.name;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final DDNode getLeft() {
        return this.left;
    }

    public final DDNode getRight() {
        return this.right;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getProperty() {
        return this.property;
    }

    public final String getInput() {
        return this.input;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }
}