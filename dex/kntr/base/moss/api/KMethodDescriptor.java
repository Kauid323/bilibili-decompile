package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: KMethodDescriptor.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\f\b\u0001\u0010\u0004*\u00060\u0002j\u0002`\u00032\u00020\u0002B\u0087\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010\nHÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015HÆ\u0003J¯\u0001\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lkntr/base/moss/api/KMethodDescriptor;", "KReqT", "", "Lkntr/base/moss/api/KProtoMessage;", "KRespT", "packageName", "", "serviceName", "methodName", "reqClass", "Lkotlin/reflect/KClass;", "reqProtoName", "reqJavaClassName", "reqObjcClassName", "respClass", "respProtoName", "respJavaClassName", "respObjcClassName", "reqSerialization", "Lkotlinx/serialization/SerializationStrategy;", "respDeserialization", "Lkotlinx/serialization/DeserializationStrategy;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/SerializationStrategy;Lkotlinx/serialization/DeserializationStrategy;)V", "getPackageName", "()Ljava/lang/String;", "getServiceName", "getMethodName", "getReqClass", "()Lkotlin/reflect/KClass;", "getReqProtoName", "getReqJavaClassName", "getReqObjcClassName", "getRespClass", "getRespProtoName", "getRespJavaClassName", "getRespObjcClassName", "getReqSerialization", "()Lkotlinx/serialization/SerializationStrategy;", "getRespDeserialization", "()Lkotlinx/serialization/DeserializationStrategy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMethodDescriptor<KReqT, KRespT> {
    private final String methodName;
    private final String packageName;
    private final KClass<KReqT> reqClass;
    private final String reqJavaClassName;
    private final String reqObjcClassName;
    private final String reqProtoName;
    private final SerializationStrategy<KReqT> reqSerialization;
    private final KClass<KRespT> respClass;
    private final DeserializationStrategy<KRespT> respDeserialization;
    private final String respJavaClassName;
    private final String respObjcClassName;
    private final String respProtoName;
    private final String serviceName;

    public final String component1() {
        return this.packageName;
    }

    public final String component10() {
        return this.respJavaClassName;
    }

    public final String component11() {
        return this.respObjcClassName;
    }

    public final SerializationStrategy<KReqT> component12() {
        return this.reqSerialization;
    }

    public final DeserializationStrategy<KRespT> component13() {
        return this.respDeserialization;
    }

    public final String component2() {
        return this.serviceName;
    }

    public final String component3() {
        return this.methodName;
    }

    public final KClass<KReqT> component4() {
        return this.reqClass;
    }

    public final String component5() {
        return this.reqProtoName;
    }

    public final String component6() {
        return this.reqJavaClassName;
    }

    public final String component7() {
        return this.reqObjcClassName;
    }

    public final KClass<KRespT> component8() {
        return this.respClass;
    }

    public final String component9() {
        return this.respProtoName;
    }

    public final KMethodDescriptor<KReqT, KRespT> copy(String str, String str2, String str3, KClass<KReqT> kClass, String str4, String str5, String str6, KClass<KRespT> kClass2, String str7, String str8, String str9, SerializationStrategy<? super KReqT> serializationStrategy, DeserializationStrategy<? extends KRespT> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(str2, "serviceName");
        Intrinsics.checkNotNullParameter(str3, "methodName");
        Intrinsics.checkNotNullParameter(kClass, "reqClass");
        Intrinsics.checkNotNullParameter(str4, "reqProtoName");
        Intrinsics.checkNotNullParameter(str5, "reqJavaClassName");
        Intrinsics.checkNotNullParameter(str6, "reqObjcClassName");
        Intrinsics.checkNotNullParameter(kClass2, "respClass");
        Intrinsics.checkNotNullParameter(str7, "respProtoName");
        Intrinsics.checkNotNullParameter(str8, "respJavaClassName");
        Intrinsics.checkNotNullParameter(str9, "respObjcClassName");
        Intrinsics.checkNotNullParameter(serializationStrategy, "reqSerialization");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "respDeserialization");
        return new KMethodDescriptor<>(str, str2, str3, kClass, str4, str5, str6, kClass2, str7, str8, str9, serializationStrategy, deserializationStrategy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KMethodDescriptor) {
            KMethodDescriptor kMethodDescriptor = (KMethodDescriptor) obj;
            return Intrinsics.areEqual(this.packageName, kMethodDescriptor.packageName) && Intrinsics.areEqual(this.serviceName, kMethodDescriptor.serviceName) && Intrinsics.areEqual(this.methodName, kMethodDescriptor.methodName) && Intrinsics.areEqual(this.reqClass, kMethodDescriptor.reqClass) && Intrinsics.areEqual(this.reqProtoName, kMethodDescriptor.reqProtoName) && Intrinsics.areEqual(this.reqJavaClassName, kMethodDescriptor.reqJavaClassName) && Intrinsics.areEqual(this.reqObjcClassName, kMethodDescriptor.reqObjcClassName) && Intrinsics.areEqual(this.respClass, kMethodDescriptor.respClass) && Intrinsics.areEqual(this.respProtoName, kMethodDescriptor.respProtoName) && Intrinsics.areEqual(this.respJavaClassName, kMethodDescriptor.respJavaClassName) && Intrinsics.areEqual(this.respObjcClassName, kMethodDescriptor.respObjcClassName) && Intrinsics.areEqual(this.reqSerialization, kMethodDescriptor.reqSerialization) && Intrinsics.areEqual(this.respDeserialization, kMethodDescriptor.respDeserialization);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.packageName.hashCode() * 31) + this.serviceName.hashCode()) * 31) + this.methodName.hashCode()) * 31) + this.reqClass.hashCode()) * 31) + this.reqProtoName.hashCode()) * 31) + this.reqJavaClassName.hashCode()) * 31) + this.reqObjcClassName.hashCode()) * 31) + this.respClass.hashCode()) * 31) + this.respProtoName.hashCode()) * 31) + this.respJavaClassName.hashCode()) * 31) + this.respObjcClassName.hashCode()) * 31) + this.reqSerialization.hashCode()) * 31) + this.respDeserialization.hashCode();
    }

    public String toString() {
        String str = this.packageName;
        String str2 = this.serviceName;
        String str3 = this.methodName;
        KClass<KReqT> kClass = this.reqClass;
        String str4 = this.reqProtoName;
        String str5 = this.reqJavaClassName;
        String str6 = this.reqObjcClassName;
        KClass<KRespT> kClass2 = this.respClass;
        String str7 = this.respProtoName;
        String str8 = this.respJavaClassName;
        String str9 = this.respObjcClassName;
        SerializationStrategy<KReqT> serializationStrategy = this.reqSerialization;
        return "KMethodDescriptor(packageName=" + str + ", serviceName=" + str2 + ", methodName=" + str3 + ", reqClass=" + kClass + ", reqProtoName=" + str4 + ", reqJavaClassName=" + str5 + ", reqObjcClassName=" + str6 + ", respClass=" + kClass2 + ", respProtoName=" + str7 + ", respJavaClassName=" + str8 + ", respObjcClassName=" + str9 + ", reqSerialization=" + serializationStrategy + ", respDeserialization=" + this.respDeserialization + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KMethodDescriptor(String packageName, String serviceName, String methodName, KClass<KReqT> kClass, String reqProtoName, String reqJavaClassName, String reqObjcClassName, KClass<KRespT> kClass2, String respProtoName, String respJavaClassName, String respObjcClassName, SerializationStrategy<? super KReqT> serializationStrategy, DeserializationStrategy<? extends KRespT> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(kClass, "reqClass");
        Intrinsics.checkNotNullParameter(reqProtoName, "reqProtoName");
        Intrinsics.checkNotNullParameter(reqJavaClassName, "reqJavaClassName");
        Intrinsics.checkNotNullParameter(reqObjcClassName, "reqObjcClassName");
        Intrinsics.checkNotNullParameter(kClass2, "respClass");
        Intrinsics.checkNotNullParameter(respProtoName, "respProtoName");
        Intrinsics.checkNotNullParameter(respJavaClassName, "respJavaClassName");
        Intrinsics.checkNotNullParameter(respObjcClassName, "respObjcClassName");
        Intrinsics.checkNotNullParameter(serializationStrategy, "reqSerialization");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "respDeserialization");
        this.packageName = packageName;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.reqClass = kClass;
        this.reqProtoName = reqProtoName;
        this.reqJavaClassName = reqJavaClassName;
        this.reqObjcClassName = reqObjcClassName;
        this.respClass = kClass2;
        this.respProtoName = respProtoName;
        this.respJavaClassName = respJavaClassName;
        this.respObjcClassName = respObjcClassName;
        this.reqSerialization = serializationStrategy;
        this.respDeserialization = deserializationStrategy;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final KClass<KReqT> getReqClass() {
        return this.reqClass;
    }

    public final String getReqProtoName() {
        return this.reqProtoName;
    }

    public final String getReqJavaClassName() {
        return this.reqJavaClassName;
    }

    public final String getReqObjcClassName() {
        return this.reqObjcClassName;
    }

    public final KClass<KRespT> getRespClass() {
        return this.respClass;
    }

    public final String getRespProtoName() {
        return this.respProtoName;
    }

    public final String getRespJavaClassName() {
        return this.respJavaClassName;
    }

    public final String getRespObjcClassName() {
        return this.respObjcClassName;
    }

    public final SerializationStrategy<KReqT> getReqSerialization() {
        return this.reqSerialization;
    }

    public final DeserializationStrategy<KRespT> getRespDeserialization() {
        return this.respDeserialization;
    }
}