package shark;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferencePattern.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lshark/ReferencePattern;", "Ljava/io/Serializable;", "()V", "Companion", "InstanceFieldPattern", "JavaLocalPattern", "NativeGlobalVariablePattern", "StaticFieldPattern", "Lshark/ReferencePattern$JavaLocalPattern;", "Lshark/ReferencePattern$StaticFieldPattern;", "Lshark/ReferencePattern$InstanceFieldPattern;", "Lshark/ReferencePattern$NativeGlobalVariablePattern;", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class ReferencePattern implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = -5113635523713591133L;

    private ReferencePattern() {
    }

    public /* synthetic */ ReferencePattern(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: ReferencePattern.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lshark/ReferencePattern$JavaLocalPattern;", "Lshark/ReferencePattern;", "threadName", "", "(Ljava/lang/String;)V", "getThreadName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class JavaLocalPattern extends ReferencePattern {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = -8985446122829543654L;
        private final String threadName;

        public static /* synthetic */ JavaLocalPattern copy$default(JavaLocalPattern javaLocalPattern, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = javaLocalPattern.threadName;
            }
            return javaLocalPattern.copy(str);
        }

        public final String component1() {
            return this.threadName;
        }

        public final JavaLocalPattern copy(String str) {
            Intrinsics.checkParameterIsNotNull(str, "threadName");
            return new JavaLocalPattern(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof JavaLocalPattern) && Intrinsics.areEqual(this.threadName, ((JavaLocalPattern) obj).threadName);
            }
            return true;
        }

        public int hashCode() {
            String str = this.threadName;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaLocalPattern(String threadName) {
            super(null);
            Intrinsics.checkParameterIsNotNull(threadName, "threadName");
            this.threadName = threadName;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public String toString() {
            return "local variable on thread " + this.threadName;
        }

        /* compiled from: ReferencePattern.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ReferencePattern$JavaLocalPattern$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    /* compiled from: ReferencePattern.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lshark/ReferencePattern$StaticFieldPattern;", "Lshark/ReferencePattern;", "className", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getFieldName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StaticFieldPattern extends ReferencePattern {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 7656908128775899611L;
        private final String className;
        private final String fieldName;

        public static /* synthetic */ StaticFieldPattern copy$default(StaticFieldPattern staticFieldPattern, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = staticFieldPattern.className;
            }
            if ((i & 2) != 0) {
                str2 = staticFieldPattern.fieldName;
            }
            return staticFieldPattern.copy(str, str2);
        }

        public final String component1() {
            return this.className;
        }

        public final String component2() {
            return this.fieldName;
        }

        public final StaticFieldPattern copy(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            return new StaticFieldPattern(str, str2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof StaticFieldPattern) {
                    StaticFieldPattern staticFieldPattern = (StaticFieldPattern) obj;
                    return Intrinsics.areEqual(this.className, staticFieldPattern.className) && Intrinsics.areEqual(this.fieldName, staticFieldPattern.fieldName);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.className;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.fieldName;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StaticFieldPattern(String className, String fieldName) {
            super(null);
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            this.className = className;
            this.fieldName = fieldName;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getFieldName() {
            return this.fieldName;
        }

        public String toString() {
            return "static field " + this.className + '#' + this.fieldName;
        }

        /* compiled from: ReferencePattern.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ReferencePattern$StaticFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    /* compiled from: ReferencePattern.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lshark/ReferencePattern$InstanceFieldPattern;", "Lshark/ReferencePattern;", "className", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getFieldName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InstanceFieldPattern extends ReferencePattern {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 6649791455204159802L;
        private final String className;
        private final String fieldName;

        public static /* synthetic */ InstanceFieldPattern copy$default(InstanceFieldPattern instanceFieldPattern, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = instanceFieldPattern.className;
            }
            if ((i & 2) != 0) {
                str2 = instanceFieldPattern.fieldName;
            }
            return instanceFieldPattern.copy(str, str2);
        }

        public final String component1() {
            return this.className;
        }

        public final String component2() {
            return this.fieldName;
        }

        public final InstanceFieldPattern copy(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            return new InstanceFieldPattern(str, str2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof InstanceFieldPattern) {
                    InstanceFieldPattern instanceFieldPattern = (InstanceFieldPattern) obj;
                    return Intrinsics.areEqual(this.className, instanceFieldPattern.className) && Intrinsics.areEqual(this.fieldName, instanceFieldPattern.fieldName);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.className;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.fieldName;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstanceFieldPattern(String className, String fieldName) {
            super(null);
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            this.className = className;
            this.fieldName = fieldName;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getFieldName() {
            return this.fieldName;
        }

        public String toString() {
            return "instance field " + this.className + '#' + this.fieldName;
        }

        /* compiled from: ReferencePattern.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ReferencePattern$InstanceFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    /* compiled from: ReferencePattern.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lshark/ReferencePattern$NativeGlobalVariablePattern;", "Lshark/ReferencePattern;", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NativeGlobalVariablePattern extends ReferencePattern {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = -2651328076202244933L;
        private final String className;

        public static /* synthetic */ NativeGlobalVariablePattern copy$default(NativeGlobalVariablePattern nativeGlobalVariablePattern, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeGlobalVariablePattern.className;
            }
            return nativeGlobalVariablePattern.copy(str);
        }

        public final String component1() {
            return this.className;
        }

        public final NativeGlobalVariablePattern copy(String str) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            return new NativeGlobalVariablePattern(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof NativeGlobalVariablePattern) && Intrinsics.areEqual(this.className, ((NativeGlobalVariablePattern) obj).className);
            }
            return true;
        }

        public int hashCode() {
            String str = this.className;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeGlobalVariablePattern(String className) {
            super(null);
            Intrinsics.checkParameterIsNotNull(className, "className");
            this.className = className;
        }

        public final String getClassName() {
            return this.className;
        }

        public String toString() {
            return "native global variable referencing " + this.className;
        }

        /* compiled from: ReferencePattern.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ReferencePattern$NativeGlobalVariablePattern$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    /* compiled from: ReferencePattern.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ReferencePattern$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}