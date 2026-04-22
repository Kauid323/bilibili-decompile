package shark;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import shark.internal.StringsKt;

/* compiled from: LeakTraceObject.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 32\u00020\u0001:\u0003345BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J^\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\fHÖ\u0001J\b\u0010.\u001a\u00020\u0005H\u0016J/\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020*2\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b2R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010¨\u00066"}, d2 = {"Lshark/LeakTraceObject;", "Ljava/io/Serializable;", "type", "Lshark/LeakTraceObject$ObjectType;", "className", "", "labels", "", "leakingStatus", "Lshark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "retainedHeapByteSize", "", "retainedObjectCount", "(Lshark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClassName", "()Ljava/lang/String;", "classSimpleName", "getClassSimpleName", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lshark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetainedObjectCount", "getType", "()Lshark/LeakTraceObject$ObjectType;", "typeName", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lshark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lshark/LeakTraceObject;", "equals", "", "other", "", "hashCode", "toString", "firstLinePrefix", "additionalLinesPrefix", "showLeakingStatus", "toString$shark", "Companion", "LeakingStatus", "ObjectType", "shark"}, k = 1, mv = {1, 4, 1})
public final class LeakTraceObject implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = -3616216391305196341L;
    private final String className;
    private final Set<String> labels;
    private final LeakingStatus leakingStatus;
    private final String leakingStatusReason;
    private final Integer retainedHeapByteSize;
    private final Integer retainedObjectCount;
    private final ObjectType type;

    /* compiled from: LeakTraceObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lshark/LeakTraceObject$LeakingStatus;", "", "(Ljava/lang/String;I)V", "NOT_LEAKING", "LEAKING", "UNKNOWN", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum LeakingStatus {
        NOT_LEAKING,
        LEAKING,
        UNKNOWN
    }

    /* compiled from: LeakTraceObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lshark/LeakTraceObject$ObjectType;", "", "(Ljava/lang/String;I)V", "CLASS", "ARRAY", "INSTANCE", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ObjectType {
        CLASS,
        ARRAY,
        INSTANCE
    }

    public static /* synthetic */ LeakTraceObject copy$default(LeakTraceObject leakTraceObject, ObjectType objectType, String str, Set set, LeakingStatus leakingStatus, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            objectType = leakTraceObject.type;
        }
        if ((i & 2) != 0) {
            str = leakTraceObject.className;
        }
        String str3 = str;
        Set<String> set2 = set;
        if ((i & 4) != 0) {
            set2 = leakTraceObject.labels;
        }
        Set set3 = set2;
        if ((i & 8) != 0) {
            leakingStatus = leakTraceObject.leakingStatus;
        }
        LeakingStatus leakingStatus2 = leakingStatus;
        if ((i & 16) != 0) {
            str2 = leakTraceObject.leakingStatusReason;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            num = leakTraceObject.retainedHeapByteSize;
        }
        Integer num3 = num;
        if ((i & 64) != 0) {
            num2 = leakTraceObject.retainedObjectCount;
        }
        return leakTraceObject.copy(objectType, str3, set3, leakingStatus2, str4, num3, num2);
    }

    public final ObjectType component1() {
        return this.type;
    }

    public final String component2() {
        return this.className;
    }

    public final Set<String> component3() {
        return this.labels;
    }

    public final LeakingStatus component4() {
        return this.leakingStatus;
    }

    public final String component5() {
        return this.leakingStatusReason;
    }

    public final Integer component6() {
        return this.retainedHeapByteSize;
    }

    public final Integer component7() {
        return this.retainedObjectCount;
    }

    public final LeakTraceObject copy(ObjectType objectType, String str, Set<String> set, LeakingStatus leakingStatus, String str2, Integer num, Integer num2) {
        Intrinsics.checkParameterIsNotNull(objectType, "type");
        Intrinsics.checkParameterIsNotNull(str, "className");
        Intrinsics.checkParameterIsNotNull(set, "labels");
        Intrinsics.checkParameterIsNotNull(leakingStatus, "leakingStatus");
        Intrinsics.checkParameterIsNotNull(str2, "leakingStatusReason");
        return new LeakTraceObject(objectType, str, set, leakingStatus, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LeakTraceObject) {
                LeakTraceObject leakTraceObject = (LeakTraceObject) obj;
                return Intrinsics.areEqual(this.type, leakTraceObject.type) && Intrinsics.areEqual(this.className, leakTraceObject.className) && Intrinsics.areEqual(this.labels, leakTraceObject.labels) && Intrinsics.areEqual(this.leakingStatus, leakTraceObject.leakingStatus) && Intrinsics.areEqual(this.leakingStatusReason, leakTraceObject.leakingStatusReason) && Intrinsics.areEqual(this.retainedHeapByteSize, leakTraceObject.retainedHeapByteSize) && Intrinsics.areEqual(this.retainedObjectCount, leakTraceObject.retainedObjectCount);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        ObjectType objectType = this.type;
        int hashCode = (objectType != null ? objectType.hashCode() : 0) * 31;
        String str = this.className;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Set<String> set = this.labels;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        LeakingStatus leakingStatus = this.leakingStatus;
        int hashCode4 = (hashCode3 + (leakingStatus != null ? leakingStatus.hashCode() : 0)) * 31;
        String str2 = this.leakingStatusReason;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.retainedHeapByteSize;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.retainedObjectCount;
        return hashCode6 + (num2 != null ? num2.hashCode() : 0);
    }

    public LeakTraceObject(ObjectType type, String className, Set<String> set, LeakingStatus leakingStatus, String leakingStatusReason, Integer retainedHeapByteSize, Integer retainedObjectCount) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(set, "labels");
        Intrinsics.checkParameterIsNotNull(leakingStatus, "leakingStatus");
        Intrinsics.checkParameterIsNotNull(leakingStatusReason, "leakingStatusReason");
        this.type = type;
        this.className = className;
        this.labels = set;
        this.leakingStatus = leakingStatus;
        this.leakingStatusReason = leakingStatusReason;
        this.retainedHeapByteSize = retainedHeapByteSize;
        this.retainedObjectCount = retainedObjectCount;
    }

    public final ObjectType getType() {
        return this.type;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Set<String> getLabels() {
        return this.labels;
    }

    public final LeakingStatus getLeakingStatus() {
        return this.leakingStatus;
    }

    public final String getLeakingStatusReason() {
        return this.leakingStatusReason;
    }

    public final Integer getRetainedHeapByteSize() {
        return this.retainedHeapByteSize;
    }

    public final Integer getRetainedObjectCount() {
        return this.retainedObjectCount;
    }

    public final String getClassSimpleName() {
        return StringsKt.lastSegment(this.className, '.');
    }

    public final String getTypeName() {
        String name = this.type.name();
        Locale locale = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public String toString() {
        return toString$shark$default(this, "", "\u200b  ", true, null, 8, null);
    }

    public static /* synthetic */ String toString$shark$default(LeakTraceObject leakTraceObject, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = leakTraceObject.getTypeName();
        }
        return leakTraceObject.toString$shark(str, str2, z, str3);
    }

    public final String toString$shark(String firstLinePrefix, String additionalLinesPrefix, boolean showLeakingStatus, String typeName) {
        String leakStatus;
        Intrinsics.checkParameterIsNotNull(firstLinePrefix, "firstLinePrefix");
        Intrinsics.checkParameterIsNotNull(additionalLinesPrefix, "additionalLinesPrefix");
        Intrinsics.checkParameterIsNotNull(typeName, "typeName");
        switch (this.leakingStatus) {
            case UNKNOWN:
                leakStatus = "UNKNOWN";
                break;
            case NOT_LEAKING:
                leakStatus = "NO (" + this.leakingStatusReason + ')';
                break;
            case LEAKING:
                leakStatus = "YES (" + this.leakingStatusReason + ')';
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String result = "" + firstLinePrefix + this.className + ' ' + typeName;
        if (showLeakingStatus) {
            result = result + '\n' + additionalLinesPrefix + "Leaking: " + leakStatus;
        }
        if (this.retainedHeapByteSize != null) {
            String humanReadableRetainedHeapSize = Companion.humanReadableByteCount(this.retainedHeapByteSize.intValue());
            result = result + '\n' + additionalLinesPrefix + "Retaining " + humanReadableRetainedHeapSize + " in " + this.retainedObjectCount + " objects";
        }
        for (String label : this.labels) {
            result = result + '\n' + additionalLinesPrefix + label;
        }
        return result;
    }

    /* compiled from: LeakTraceObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lshark/LeakTraceObject$Companion;", "", "()V", "serialVersionUID", "", "humanReadableByteCount", "", "bytes", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final String humanReadableByteCount(long bytes) {
            if (bytes < 1000) {
                return bytes + " B";
            }
            int exp = (int) (Math.log(bytes) / Math.log(1000));
            char pre = "kMGTPE".charAt(exp - 1);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f %sB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / Math.pow(1000, exp)), Character.valueOf(pre)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            return format;
        }
    }
}