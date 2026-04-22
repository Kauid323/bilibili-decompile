package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* compiled from: KClassImpl.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 t*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0002stB\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060.2\u0006\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020:0.2\u0006\u00107\u001a\u000208H\u0016J\u0012\u0010;\u001a\u0004\u0018\u0001062\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010k\u001a\u00020M2\b\u0010l\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010m\u001a\u00020=H\u0016J\b\u0010n\u001a\u00020?H\u0016J\u0018\u0010o\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010p\u001a\u00020qH\u0002J\u0018\u0010r\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010p\u001a\u00020qH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u001e\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00101R\u0016\u0010>\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR \u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000E0.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u00101R\u001e\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u00101R\u0016\u0010I\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u001eR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001eR\"\u0010U\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u001eR\u0016\u0010W\u001a\u0004\u0018\u00010X8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010`R\u0014\u0010b\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010`R\u0014\u0010c\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010`R\u0014\u0010d\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010`R\u0014\u0010e\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010`R\u0014\u0010f\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010`R\u0014\u0010g\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010`R\u0014\u0010h\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u0010`R\u0014\u0010i\u001a\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010`¨\u0006u"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "getData", "()Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classKind", "Lkotlin/reflect/jvm/internal/impl/km/ClassKind;", "getClassKind$kotlin_reflection", "()Lkotlin/metadata/ClassKind;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "staticScope", "getStaticScope$kotlin_reflection", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "sealedSubclasses", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "modality", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "isFinal", "()Z", "isOpen", "isAbstract", "isSealed", "isData", "isInner", "isCompanion", "isFun", "isValue", "isInline", "isInline$kotlin_reflection", "equals", "other", "hashCode", "toString", "createSyntheticClassOrFail", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "createSyntheticClass", "Data", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> SPECIAL_JVM_ANNOTATION_NAMES;
    private final Lazy<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    /* compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KClassImpl(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$0
            private final KClassImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KClassImpl.Data data$lambda$0;
                data$lambda$0 = KClassImpl.data$lambda$0(this.arg$0);
                return data$lambda$0;
            }
        });
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u001f\u001a\u00020\u00182\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR-\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0#8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0010\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R%\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010(R#\u0010.\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b2\u0010\n\u0012\u0004\b/\u0010&\u001a\u0004\b0\u00101R!\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b5\u0010\u0015R!\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b9\u0010\u0015R)\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000+0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b<\u0010\u0015R%\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b@\u0010(R%\u0010B\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bC\u0010(R%\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bF\u0010(R%\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bI\u0010(R%\u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bL\u0010(R%\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bO\u0010(R%\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bR\u0010(R%\u0010T\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0010\u001a\u0004\bU\u0010(¨\u0006W"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass$delegate", "Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "simpleName$delegate", "qualifiedName", "getQualifiedName", "qualifiedName$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "()Ljava/util/Collection;", "constructors$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "declaredNonStaticMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "allMembers", "getAllMembers", "allMembers$delegate", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Data.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};
        private final ReflectProperties.LazySoftVal allMembers$delegate;
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal annotations$delegate;
        private final ReflectProperties.LazySoftVal constructors$delegate;
        private final ReflectProperties.LazySoftVal declaredMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
        private final Lazy kmClass$delegate;
        private final ReflectProperties.LazySoftVal nestedClasses$delegate;
        private final Lazy objectInstance$delegate;
        private final ReflectProperties.LazySoftVal qualifiedName$delegate;
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        private final ReflectProperties.LazySoftVal simpleName$delegate;
        private final ReflectProperties.LazySoftVal supertypes$delegate;
        private final ReflectProperties.LazySoftVal typeParameters$delegate;

        public Data() {
            super();
            this.kmClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    KmClass kmClass_delegate$lambda$0;
                    kmClass_delegate$lambda$0 = KClassImpl.Data.kmClass_delegate$lambda$0(this.arg$0);
                    return kmClass_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl = KClassImpl.this;
            this.descriptor$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$1
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ClassDescriptor descriptor_delegate$lambda$0;
                    descriptor_delegate$lambda$0 = KClassImpl.Data.descriptor_delegate$lambda$0(this.arg$0);
                    return descriptor_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl2 = KClassImpl.this;
            this.annotations$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl2) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$2
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List annotations_delegate$lambda$0;
                    annotations_delegate$lambda$0 = KClassImpl.Data.annotations_delegate$lambda$0(this.arg$0);
                    return annotations_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl3 = KClassImpl.this;
            this.simpleName$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl3, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$3
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl3;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    String simpleName_delegate$lambda$0;
                    simpleName_delegate$lambda$0 = KClassImpl.Data.simpleName_delegate$lambda$0(this.arg$0, this.arg$1);
                    return simpleName_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl4 = KClassImpl.this;
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl4) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$4
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl4;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    String qualifiedName_delegate$lambda$0;
                    qualifiedName_delegate$lambda$0 = KClassImpl.Data.qualifiedName_delegate$lambda$0(this.arg$0);
                    return qualifiedName_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl5 = KClassImpl.this;
            this.constructors$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl5) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$5
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl5;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List constructors_delegate$lambda$0;
                    constructors_delegate$lambda$0 = KClassImpl.Data.constructors_delegate$lambda$0(this.arg$0);
                    return constructors_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl6 = KClassImpl.this;
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new Function0(this, kClassImpl6) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$6
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl6;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List nestedClasses_delegate$lambda$0;
                    nestedClasses_delegate$lambda$0 = KClassImpl.Data.nestedClasses_delegate$lambda$0(this.arg$0, this.arg$1);
                    return nestedClasses_delegate$lambda$0;
                }
            });
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            final KClassImpl<T> kClassImpl7 = KClassImpl.this;
            this.objectInstance$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, kClassImpl7) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$7
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl7;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Object objectInstance_delegate$lambda$0;
                    objectInstance_delegate$lambda$0 = KClassImpl.Data.objectInstance_delegate$lambda$0(this.arg$0, this.arg$1);
                    return objectInstance_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl8 = KClassImpl.this;
            this.typeParameters$delegate = ReflectProperties.lazySoft(new Function0(this, kClassImpl8) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$8
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl8;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List typeParameters_delegate$lambda$0;
                    typeParameters_delegate$lambda$0 = KClassImpl.Data.typeParameters_delegate$lambda$0(this.arg$0, this.arg$1);
                    return typeParameters_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl9 = KClassImpl.this;
            this.supertypes$delegate = ReflectProperties.lazySoft(new Function0(this, kClassImpl9) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$9
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl9;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List supertypes_delegate$lambda$0;
                    supertypes_delegate$lambda$0 = KClassImpl.Data.supertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                    return supertypes_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl10 = KClassImpl.this;
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl10, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl10;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List sealedSubclasses_delegate$lambda$0;
                    sealedSubclasses_delegate$lambda$0 = KClassImpl.Data.sealedSubclasses_delegate$lambda$0(this.arg$0, this.arg$1);
                    return sealedSubclasses_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl11 = KClassImpl.this;
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl11) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$11
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl11;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection declaredNonStaticMembers_delegate$lambda$0;
                    declaredNonStaticMembers_delegate$lambda$0 = KClassImpl.Data.declaredNonStaticMembers_delegate$lambda$0(this.arg$0);
                    return declaredNonStaticMembers_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl12 = KClassImpl.this;
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl12) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$12
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl12;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection declaredStaticMembers_delegate$lambda$0;
                    declaredStaticMembers_delegate$lambda$0 = KClassImpl.Data.declaredStaticMembers_delegate$lambda$0(this.arg$0);
                    return declaredStaticMembers_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl13 = KClassImpl.this;
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl13) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$13
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl13;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection inheritedNonStaticMembers_delegate$lambda$0;
                    inheritedNonStaticMembers_delegate$lambda$0 = KClassImpl.Data.inheritedNonStaticMembers_delegate$lambda$0(this.arg$0);
                    return inheritedNonStaticMembers_delegate$lambda$0;
                }
            });
            final KClassImpl<T> kClassImpl14 = KClassImpl.this;
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(kClassImpl14) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl14;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection inheritedStaticMembers_delegate$lambda$0;
                    inheritedStaticMembers_delegate$lambda$0 = KClassImpl.Data.inheritedStaticMembers_delegate$lambda$0(this.arg$0);
                    return inheritedStaticMembers_delegate$lambda$0;
                }
            });
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$15
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allNonStaticMembers_delegate$lambda$0;
                    allNonStaticMembers_delegate$lambda$0 = KClassImpl.Data.allNonStaticMembers_delegate$lambda$0(this.arg$0);
                    return allNonStaticMembers_delegate$lambda$0;
                }
            });
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$16
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allStaticMembers_delegate$lambda$0;
                    allStaticMembers_delegate$lambda$0 = KClassImpl.Data.allStaticMembers_delegate$lambda$0(this.arg$0);
                    return allStaticMembers_delegate$lambda$0;
                }
            });
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$17
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List declaredMembers_delegate$lambda$0;
                    declaredMembers_delegate$lambda$0 = KClassImpl.Data.declaredMembers_delegate$lambda$0(this.arg$0);
                    return declaredMembers_delegate$lambda$0;
                }
            });
            this.allMembers$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$18
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allMembers_delegate$lambda$0;
                    allMembers_delegate$lambda$0 = KClassImpl.Data.allMembers_delegate$lambda$0(this.arg$0);
                    return allMembers_delegate$lambda$0;
                }
            });
        }

        public final KmClass getKmClass() {
            return (KmClass) this.kmClass$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KmClass kmClass_delegate$lambda$0(Data this$0) {
            ClassDescriptor descriptor = this$0.getDescriptor();
            DeserializedClassDescriptor descriptor2 = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
            if (descriptor2 != null) {
                return ReadersKt.toKmClass$default(descriptor2.getClassProto(), descriptor2.getC().getNameResolver(), false, null, 6, null);
            }
            return null;
        }

        public final ClassDescriptor getDescriptor() {
            T value = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (ClassDescriptor) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClassDescriptor descriptor_delegate$lambda$0(KClassImpl this$0) {
            ClassDescriptor descriptor;
            ClassId classId = this$0.getClassId();
            RuntimeModuleData moduleData = ((Data) this$0.getData().getValue()).getModuleData();
            ModuleDescriptor module = moduleData.getModule();
            if (classId.isLocal() && this$0.getJClass().isAnnotationPresent(Metadata.class)) {
                descriptor = moduleData.getDeserialization().deserializeClass(classId);
            } else {
                descriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
            }
            return descriptor == null ? this$0.createSyntheticClassOrFail(classId, moduleData) : descriptor;
        }

        public final List<Annotation> getAnnotations() {
            T value = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List annotations_delegate$lambda$0(KClassImpl this$0) {
            Annotation[] annotationArr;
            Annotation[] annotations = this$0.getJClass().getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
            Collection destination$iv$iv = new ArrayList();
            for (Annotation annotation : annotations) {
                Annotation it = annotation;
                if (!KClassImpl.SPECIAL_JVM_ANNOTATION_NAMES.contains(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it)).getName())) {
                    destination$iv$iv.add(annotation);
                }
            }
            return UtilKt.unwrapRepeatableAnnotations((List) destination$iv$iv);
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String simpleName_delegate$lambda$0(KClassImpl this$0, Data this$1) {
            if (this$0.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = this$0.getClassId();
            if (classId.isLocal()) {
                return this$1.calculateLocalClassName(this$0.getJClass());
            }
            String asString = classId.getShortClassName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String qualifiedName_delegate$lambda$0(KClassImpl this$0) {
            if (this$0.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = this$0.getClassId();
            if (classId.isLocal()) {
                return null;
            }
            return classId.asSingleFqName().asString();
        }

        private final String calculateLocalClassName(Class<?> cls) {
            String name = cls.getSimpleName();
            Method method = cls.getEnclosingMethod();
            if (method != null) {
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, method.getName() + Typography.dollar, (String) null, 2, (Object) null);
            }
            Constructor constructor = cls.getEnclosingConstructor();
            if (constructor != null) {
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, constructor.getName() + Typography.dollar, (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNull(name);
            return StringsKt.substringAfter$default(name, (char) Typography.dollar, (String) null, 2, (Object) null);
        }

        public final Collection<KFunction<T>> getConstructors() {
            T value = this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List constructors_delegate$lambda$0(KClassImpl this$0) {
            Iterable $this$map$iv = this$0.getConstructorDescriptors();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ConstructorDescriptor descriptor = (ConstructorDescriptor) item$iv$iv;
                destination$iv$iv.add(new KFunctionImpl(this$0, descriptor));
            }
            return (List) destination$iv$iv;
        }

        public final Collection<KClass<?>> getNestedClasses() {
            T value = this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List nestedClasses_delegate$lambda$0(Data this$0, KClassImpl this$1) {
            KmClass kmClass = this$0.getKmClass();
            if (kmClass == null) {
                Object[] declaredClasses = this$1.getJClass().getDeclaredClasses();
                Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
                Object[] $this$mapNotNull$iv = declaredClasses;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Class it = (Class) element$iv$iv$iv;
                    Intrinsics.checkNotNull(it);
                    KClass kotlinClass = JvmClassMappingKt.getKotlinClass(it);
                    if (kotlinClass != null) {
                        destination$iv$iv.add(kotlinClass);
                    }
                }
                return (List) destination$iv$iv;
            }
            ClassId classId = MetadataUtilKt.toClassId(kmClass.getName());
            ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this$1.getJClass());
            Iterable $this$mapNotNull$iv2 = kmClass.getNestedClasses();
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                String name = (String) element$iv$iv$iv2;
                Name identifier = Name.identifier(name);
                KmClass kmClass2 = kmClass;
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                ClassId classId2 = classId;
                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
                Class loadClass$default = UtilKt.loadClass$default(classLoader, classId.createNestedClassId(identifier), 0, 2, null);
                KClass kotlinClass2 = loadClass$default != null ? JvmClassMappingKt.getKotlinClass(loadClass$default) : null;
                if (kotlinClass2 != null) {
                    destination$iv$iv2.add(kotlinClass2);
                }
                kmClass = kmClass2;
                classId = classId2;
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
            }
            return (List) destination$iv$iv2;
        }

        public final T getObjectInstance() {
            return (T) this.objectInstance$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object objectInstance_delegate$lambda$0(Data this$0, KClassImpl this$1) {
            Field field;
            KmClass kmClass = this$0.getKmClass();
            if (kmClass == null || (Attributes.getKind(kmClass) != ClassKind.OBJECT && Attributes.getKind(kmClass) != ClassKind.COMPANION_OBJECT)) {
                return null;
            }
            if (Attributes.getKind(kmClass) == ClassKind.COMPANION_OBJECT && !CollectionsKt.contains(CompanionObjectMapping.INSTANCE.getClassIds(), MetadataUtilKt.toClassId(kmClass.getName()).getOuterClassId())) {
                field = this$1.getJClass().getEnclosingClass().getDeclaredField(MetadataUtilKt.toNonLocalSimpleName(kmClass.getName()));
            } else {
                field = this$1.getJClass().getDeclaredField("INSTANCE");
            }
            Object obj = field.get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        public final List<KTypeParameter> getTypeParameters() {
            T value = this.typeParameters$delegate.getValue(this, $$delegatedProperties[6]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List typeParameters_delegate$lambda$0(Data this$0, KClassImpl this$1) {
            Iterable declaredTypeParameters = this$0.getDescriptor().getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
            Iterable $this$map$iv = declaredTypeParameters;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TypeParameterDescriptor descriptor = (TypeParameterDescriptor) item$iv$iv;
                Intrinsics.checkNotNull(descriptor);
                destination$iv$iv.add(new KTypeParameterImpl(this$1, descriptor));
            }
            return (List) destination$iv$iv;
        }

        public final List<KType> getSupertypes() {
            T value = this.supertypes$delegate.getValue(this, $$delegatedProperties[7]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List supertypes_delegate$lambda$0(final Data this$0, final KClassImpl this$1) {
            KTypeImpl it;
            Collection kotlinTypes = this$0.getDescriptor().getTypeConstructor().mo1172getSupertypes();
            Intrinsics.checkNotNullExpressionValue(kotlinTypes, "getSupertypes(...)");
            ArrayList result = new ArrayList(kotlinTypes.size());
            Collection $this$mapTo$iv = kotlinTypes;
            ArrayList destination$iv = result;
            for (Object item$iv : $this$mapTo$iv) {
                final KotlinType kotlinType = (KotlinType) item$iv;
                Intrinsics.checkNotNull(kotlinType);
                destination$iv.add(new KTypeImpl(kotlinType, new Function0(kotlinType, this$0, this$1) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$19
                    private final KotlinType arg$0;
                    private final KClassImpl.Data arg$1;
                    private final KClassImpl arg$2;

                    {
                        this.arg$0 = kotlinType;
                        this.arg$1 = this$0;
                        this.arg$2 = this$1;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Type supertypes_delegate$lambda$0$0$0;
                        supertypes_delegate$lambda$0$0$0 = KClassImpl.Data.supertypes_delegate$lambda$0$0$0(this.arg$0, this.arg$1, this.arg$2);
                        return supertypes_delegate$lambda$0$0$0;
                    }
                }));
            }
            if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this$0.getDescriptor())) {
                ArrayList $this$all$iv = result;
                boolean z = true;
                if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
                    Iterator<T> it2 = $this$all$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object element$iv = it2.next();
                        KTypeImpl it3 = (KTypeImpl) element$iv;
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind = DescriptorUtils.getClassDescriptorForType(it3.getType()).getKind();
                        Intrinsics.checkNotNullExpressionValue(classKind, "getKind(...)");
                        if (classKind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || classKind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it == null) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this$0.getDescriptor()).getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                    result.add(new KTypeImpl(anyType, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$20
                        @Override // kotlin.jvm.functions.Function0
                        public Object invoke() {
                            Type supertypes_delegate$lambda$0$2;
                            supertypes_delegate$lambda$0$2 = KClassImpl.Data.supertypes_delegate$lambda$0$2();
                            return supertypes_delegate$lambda$0$2;
                        }
                    }));
                }
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(result);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type supertypes_delegate$lambda$0$0$0(KotlinType $kotlinType, Data this$0, KClassImpl this$1) {
            ClassifierDescriptor superClass = $kotlinType.getConstructor().mo1171getDeclarationDescriptor();
            if (!(superClass instanceof ClassDescriptor)) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + superClass);
            }
            Class superJavaClass = UtilKt.toJavaClass((ClassDescriptor) superClass);
            if (superJavaClass == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + this$0 + ": " + superClass);
            }
            if (Intrinsics.areEqual(this$1.getJClass().getSuperclass(), superJavaClass)) {
                Type genericSuperclass = this$1.getJClass().getGenericSuperclass();
                Intrinsics.checkNotNull(genericSuperclass);
                return genericSuperclass;
            }
            Class<?>[] interfaces = this$1.getJClass().getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
            int index = ArraysKt.indexOf(interfaces, superJavaClass);
            if (index < 0) {
                throw new KotlinReflectionInternalError("No superclass of " + this$0 + " in Java reflection for " + superClass);
            }
            Type type = this$1.getJClass().getGenericInterfaces()[index];
            Intrinsics.checkNotNull(type);
            return type;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type supertypes_delegate$lambda$0$2() {
            return Object.class;
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            T value = this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[8]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List sealedSubclasses_delegate$lambda$0(KClassImpl this$0, Data this$1) {
            List emptyList;
            ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this$0.getJClass());
            KmClass kmClass = this$1.getKmClass();
            if (kmClass != null) {
                Iterable $this$mapNotNull$iv = kmClass.getSealedSubclasses();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    String p0 = (String) element$iv$iv$iv;
                    KClass<?> loadKClass = MetadataUtilKt.loadKClass(classLoader, p0);
                    if (loadKClass != null) {
                        destination$iv$iv.add(loadKClass);
                    }
                }
                emptyList = (List) destination$iv$iv;
            } else if (Intrinsics.areEqual((Object) Java16SealedRecordLoader.INSTANCE.loadIsSealed(this$0.getJClass()), (Object) true)) {
                Class<?>[] loadGetPermittedSubclasses = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this$0.getJClass());
                if (loadGetPermittedSubclasses != null) {
                    Collection destination$iv$iv2 = new ArrayList(loadGetPermittedSubclasses.length);
                    for (Class<?> cls : loadGetPermittedSubclasses) {
                        destination$iv$iv2.add(JvmClassMappingKt.getKotlinClass(cls));
                    }
                    emptyList = (List) destination$iv$iv2;
                } else {
                    emptyList = null;
                }
                if (emptyList == null) {
                    emptyList = CollectionsKt.emptyList();
                }
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            List result = emptyList;
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.collections.List<kotlin.reflect.KClass<out T of kotlin.reflect.jvm.internal.KClassImpl>>");
            return result;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredNonStaticMembers_delegate$lambda$0(KClassImpl this$0) {
            return this$0.getMembers(this$0.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            T value = this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredStaticMembers_delegate$lambda$0(KClassImpl this$0) {
            return this$0.getMembers(this$0.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        private final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            T value = this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            T value = this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedNonStaticMembers_delegate$lambda$0(KClassImpl this$0) {
            return this$0.getMembers(this$0.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        private final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            T value = this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedStaticMembers_delegate$lambda$0(KClassImpl this$0) {
            return this$0.getMembers(this$0.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allNonStaticMembers_delegate$lambda$0(Data this$0) {
            return CollectionsKt.plus((Collection) this$0.getDeclaredNonStaticMembers(), (Iterable) this$0.getInheritedNonStaticMembers());
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            T value = this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allStaticMembers_delegate$lambda$0(Data this$0) {
            return CollectionsKt.plus((Collection) this$0.getDeclaredStaticMembers(), (Iterable) this$0.getInheritedStaticMembers());
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            T value = this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List declaredMembers_delegate$lambda$0(Data this$0) {
            return CollectionsKt.plus((Collection) this$0.getDeclaredNonStaticMembers(), (Iterable) this$0.getDeclaredStaticMembers());
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            T value = this.declaredMembers$delegate.getValue(this, $$delegatedProperties[15]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allMembers_delegate$lambda$0(Data this$0) {
            return CollectionsKt.plus((Collection) this$0.getAllNonStaticMembers(), (Iterable) this$0.getAllStaticMembers());
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            T value = this.allMembers$delegate.getValue(this, $$delegatedProperties[16]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data data$lambda$0(KClassImpl this$0) {
        return new Data();
    }

    public final Lazy<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return ((Data) this.data.getValue()).getDescriptor();
    }

    private final KmClass getKmClass() {
        return ((Data) this.data.getValue()).getKmClass();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return ((Data) this.data.getValue()).getAnnotations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public final ClassKind getClassKind$kotlin_reflection() {
        ClassKind kind;
        KmClass kmClass = getKmClass();
        if (kmClass == null || (kind = Attributes.getKind(kmClass)) == null) {
            return getJClass().isAnnotation() ? ClassKind.ANNOTATION_CLASS : getJClass().isInterface() ? ClassKind.INTERFACE : getJClass().isEnum() ? ClassKind.ENUM_CLASS : getJClass().getSuperclass().isEnum() ? ClassKind.ENUM_ENTRY : ClassKind.CLASS;
        }
        return kind;
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
        return staticScope;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return ((Data) this.data.getValue()).getAllMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        return constructors;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int index) {
        Class interfaceClass;
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (interfaceClass = getJClass().getDeclaringClass()) != null && interfaceClass.isInterface()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(interfaceClass);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(index);
        }
        ClassDescriptor descriptor = getDescriptor();
        DeserializedClassDescriptor descriptor2 = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (descriptor2 != null) {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = JvmProtoBuf.classLocalVariable;
            Intrinsics.checkNotNullExpressionValue(classLocalVariable, "classLocalVariable");
            ProtoBuf.Property proto = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(descriptor2.getClassProto(), classLocalVariable, index);
            if (proto != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), proto, descriptor2.getC().getNameResolver(), descriptor2.getC().getTypeTable(), descriptor2.getMetadataVersion(), new Function2() { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$1
                    @Override // kotlin.jvm.functions.Function2
                    public Object invoke(Object obj, Object obj2) {
                        PropertyDescriptor localProperty$lambda$1$0$0;
                        localProperty$lambda$1$0$0 = KClassImpl.getLocalProperty$lambda$1$0$0((MemberDeserializer) obj, (ProtoBuf.Property) obj2);
                        return localProperty$lambda$1$0$0;
                    }
                });
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PropertyDescriptor getLocalProperty$lambda$1$0$0(MemberDeserializer deserializeToDescriptor, ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(deserializeToDescriptor, "$this$deserializeToDescriptor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        return deserializeToDescriptor.loadProperty(proto, true);
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return ((Data) this.data.getValue()).getSimpleName();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return ((Data) this.data.getValue()).getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return ((Data) this.data.getValue()).getConstructors();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        return ((Data) this.data.getValue()).getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return (T) ((Data) this.data.getValue()).getObjectInstance();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            int arity = functionClassArity.intValue();
            return TypeIntrinsics.isFunctionOfArity(value, arity);
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return ((Data) this.data.getValue()).getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return ((Data) this.data.getValue()).getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return ((Data) this.data.getValue()).getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return UtilKt.toKVisibility(visibility);
    }

    private final Modality getModality() {
        Modality modality;
        KmClass kmClass = getKmClass();
        if (kmClass == null || (modality = Attributes.getModality(kmClass)) == null) {
            if (getJClass().isAnnotation() || getJClass().isEnum()) {
                return Modality.FINAL;
            }
            return Intrinsics.areEqual((Object) Java16SealedRecordLoader.INSTANCE.loadIsSealed(getJClass()), (Object) true) ? Modality.SEALED : Modifier.isAbstract(getJClass().getModifiers()) ? Modality.ABSTRACT : !Modifier.isFinal(getJClass().getModifiers()) ? Modality.OPEN : Modality.FINAL;
        }
        return modality;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getModality() == Modality.SEALED;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        KmClass kmClass = getKmClass();
        return kmClass != null && Attributes.isData(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        KmClass kmClass = getKmClass();
        if (kmClass == null) {
            return (getJClass().getDeclaringClass() == null || Modifier.isStatic(getJClass().getModifiers())) ? false : true;
        }
        return Attributes.isInner(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        KmClass kmClass = getKmClass();
        return (kmClass != null ? Attributes.getKind(kmClass) : null) == ClassKind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        KmClass kmClass = getKmClass();
        return kmClass != null && Attributes.isFunInterface(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        KmClass kmClass = getKmClass();
        return kmClass != null && Attributes.isValue(kmClass);
    }

    public final boolean isInline$kotlin_reflection() {
        KmClass kmClass = getKmClass();
        return (kmClass != null ? kmClass.getInlineClassUnderlyingType() : null) != null;
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object other) {
        return (other instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        String packagePrefix = packageFqName.isRoot() ? "" : packageFqName.asString() + FilenameUtils.EXTENSION_SEPARATOR;
        String classSuffix = StringsKt.replace$default(classId.getRelativeClassName().asString(), (char) FilenameUtils.EXTENSION_SEPARATOR, (char) Typography.dollar, false, 4, (Object) null);
        return append.append(packagePrefix + classSuffix).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor createSyntheticClassOrFail(ClassId classId, RuntimeModuleData moduleData) {
        KotlinClassHeader classHeader;
        if (getJClass().isSynthetic()) {
            return createSyntheticClass(classId, moduleData);
        }
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + getJClass() + " (kind = " + kind + ')');
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return createSyntheticClass(classId, moduleData);
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + ')');
        }
    }

    private final ClassDescriptor createSyntheticClass(ClassId classId, RuntimeModuleData moduleData) {
        final ClassDescriptorImpl descriptor = new ClassDescriptorImpl(new EmptyPackageFragmentDescriptor(moduleData.getModule(), classId.getPackageFqName()), classId.getShortClassName(), kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, CollectionsKt.listOf(moduleData.getModule().getBuiltIns().getAny().getDefaultType()), SourceElement.NO_SOURCE, false, moduleData.getDeserialization().getStorageManager());
        final StorageManager storageManager = moduleData.getDeserialization().getStorageManager();
        descriptor.initialize(new GivenFunctionsMemberScope(descriptor, storageManager) { // from class: kotlin.reflect.jvm.internal.KClassImpl$createSyntheticClass$1$1
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
            protected List<FunctionDescriptor> computeDeclaredFunctions() {
                return CollectionsKt.emptyList();
            }
        }, SetsKt.emptySet(), null);
        return descriptor;
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Companion;", "", "<init>", "()V", "SPECIAL_JVM_ANNOTATION_NAMES", "", "", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Iterable $this$mapTo$iv = SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS();
        Collection destination$iv = new HashSet();
        for (Object item$iv : $this$mapTo$iv) {
            ClassId it = (ClassId) item$iv;
            destination$iv.add(it.asSingleFqName().toString());
        }
        SPECIAL_JVM_ANNOTATION_NAMES = (Set) destination$iv;
    }
}