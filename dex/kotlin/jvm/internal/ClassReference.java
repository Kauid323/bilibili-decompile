package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.internal.CollectionDescriptorsKt;

/* compiled from: ClassReference.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010I\u001a\u00020JH\u0002J\u0013\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010(\u001a\u0004\b-\u0010\u001eR(\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001eR\u001c\u00101\u001a\u0004\u0018\u0001028VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u00108R\u001a\u00109\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u00108R\u001a\u0010;\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b<\u0010(\u001a\u0004\b;\u00108R\u001a\u0010=\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b>\u0010(\u001a\u0004\b=\u00108R\u001a\u0010?\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010(\u001a\u0004\b?\u00108R\u001a\u0010A\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bB\u0010(\u001a\u0004\bA\u00108R\u001a\u0010C\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010(\u001a\u0004\bC\u00108R\u001a\u0010E\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bF\u0010(\u001a\u0004\bE\u00108R\u001a\u0010G\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bH\u0010(\u001a\u0004\bG\u00108¨\u0006Q"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "equals", "other", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private final Class<?> jClass;

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        return Companion.isInstance(value, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }

    /* compiled from: ClassReference.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006R&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNameOf", "", "type", "simpleNameOf", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String classFqNameOf(String type) {
            switch (type.hashCode()) {
                case -2061550653:
                    if (type.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "kotlin.Double.Companion";
                    }
                    break;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "kotlin.Int";
                    }
                    break;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "kotlin.Cloneable";
                    }
                    break;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "kotlin.Annotation";
                    }
                    break;
                case -1811142716:
                    if (type.equals("kotlin.jvm.functions.Function10")) {
                        return "kotlin.Function10";
                    }
                    break;
                case -1811142715:
                    if (type.equals("kotlin.jvm.functions.Function11")) {
                        return "kotlin.Function11";
                    }
                    break;
                case -1811142714:
                    if (type.equals("kotlin.jvm.functions.Function12")) {
                        return "kotlin.Function12";
                    }
                    break;
                case -1811142713:
                    if (type.equals("kotlin.jvm.functions.Function13")) {
                        return "kotlin.Function13";
                    }
                    break;
                case -1811142712:
                    if (type.equals("kotlin.jvm.functions.Function14")) {
                        return "kotlin.Function14";
                    }
                    break;
                case -1811142711:
                    if (type.equals("kotlin.jvm.functions.Function15")) {
                        return "kotlin.Function15";
                    }
                    break;
                case -1811142710:
                    if (type.equals("kotlin.jvm.functions.Function16")) {
                        return "kotlin.Function16";
                    }
                    break;
                case -1811142709:
                    if (type.equals("kotlin.jvm.functions.Function17")) {
                        return "kotlin.Function17";
                    }
                    break;
                case -1811142708:
                    if (type.equals("kotlin.jvm.functions.Function18")) {
                        return "kotlin.Function18";
                    }
                    break;
                case -1811142707:
                    if (type.equals("kotlin.jvm.functions.Function19")) {
                        return "kotlin.Function19";
                    }
                    break;
                case -1811142685:
                    if (type.equals("kotlin.jvm.functions.Function20")) {
                        return "kotlin.Function20";
                    }
                    break;
                case -1811142684:
                    if (type.equals("kotlin.jvm.functions.Function21")) {
                        return "kotlin.Function21";
                    }
                    break;
                case -1811142683:
                    if (type.equals("kotlin.jvm.functions.Function22")) {
                        return "kotlin.Function22";
                    }
                    break;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "kotlin.Comparable";
                    }
                    break;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "kotlin.collections.Map";
                    }
                    break;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "kotlin.collections.Set";
                    }
                    break;
                case -1325958191:
                    if (type.equals("double")) {
                        return "kotlin.Double";
                    }
                    break;
                case -1182275604:
                    if (type.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                        return "kotlin.Byte.Companion";
                    }
                    break;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "kotlin.CharSequence";
                    }
                    break;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "kotlin.collections.Collection";
                    }
                    break;
                case -527879800:
                    if (type.equals("java.lang.Float")) {
                        return "kotlin.Float";
                    }
                    break;
                case -515992664:
                    if (type.equals("java.lang.Short")) {
                        return "kotlin.Short";
                    }
                    break;
                case -246476834:
                    if (type.equals("kotlin.jvm.internal.CharCompanionObject")) {
                        return "kotlin.Char.Companion";
                    }
                    break;
                case -207262728:
                    if (type.equals("kotlin.jvm.internal.LongCompanionObject")) {
                        return "kotlin.Long.Companion";
                    }
                    break;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "kotlin.collections.Map.Entry";
                    }
                    break;
                case 104431:
                    if (type.equals("int")) {
                        return "kotlin.Int";
                    }
                    break;
                case 3039496:
                    if (type.equals("byte")) {
                        return "kotlin.Byte";
                    }
                    break;
                case 3052374:
                    if (type.equals("char")) {
                        return "kotlin.Char";
                    }
                    break;
                case 3327612:
                    if (type.equals("long")) {
                        return "kotlin.Long";
                    }
                    break;
                case 64711720:
                    if (type.equals("boolean")) {
                        return "kotlin.Boolean";
                    }
                    break;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "kotlin.collections.List";
                    }
                    break;
                case 77230534:
                    if (type.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                        return "kotlin.Short.Companion";
                    }
                    break;
                case 80123371:
                    if (type.equals("kotlin.jvm.functions.Function0")) {
                        return "kotlin.Function0";
                    }
                    break;
                case 80123372:
                    if (type.equals("kotlin.jvm.functions.Function1")) {
                        return "kotlin.Function1";
                    }
                    break;
                case 80123373:
                    if (type.equals("kotlin.jvm.functions.Function2")) {
                        return "kotlin.Function2";
                    }
                    break;
                case 80123374:
                    if (type.equals("kotlin.jvm.functions.Function3")) {
                        return "kotlin.Function3";
                    }
                    break;
                case 80123375:
                    if (type.equals("kotlin.jvm.functions.Function4")) {
                        return "kotlin.Function4";
                    }
                    break;
                case 80123376:
                    if (type.equals("kotlin.jvm.functions.Function5")) {
                        return "kotlin.Function5";
                    }
                    break;
                case 80123377:
                    if (type.equals("kotlin.jvm.functions.Function6")) {
                        return "kotlin.Function6";
                    }
                    break;
                case 80123378:
                    if (type.equals("kotlin.jvm.functions.Function7")) {
                        return "kotlin.Function7";
                    }
                    break;
                case 80123379:
                    if (type.equals("kotlin.jvm.functions.Function8")) {
                        return "kotlin.Function8";
                    }
                    break;
                case 80123380:
                    if (type.equals("kotlin.jvm.functions.Function9")) {
                        return "kotlin.Function9";
                    }
                    break;
                case 97526364:
                    if (type.equals("float")) {
                        return "kotlin.Float";
                    }
                    break;
                case 109413500:
                    if (type.equals("short")) {
                        return "kotlin.Short";
                    }
                    break;
                case 155276373:
                    if (type.equals("java.lang.Character")) {
                        return "kotlin.Char";
                    }
                    break;
                case 226173651:
                    if (type.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                        return "kotlin.Enum.Companion";
                    }
                    break;
                case 344809556:
                    if (type.equals("java.lang.Boolean")) {
                        return "kotlin.Boolean";
                    }
                    break;
                case 398507100:
                    if (type.equals("java.lang.Byte")) {
                        return "kotlin.Byte";
                    }
                    break;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "kotlin.Enum";
                    }
                    break;
                case 398795216:
                    if (type.equals("java.lang.Long")) {
                        return "kotlin.Long";
                    }
                    break;
                case 482629606:
                    if (type.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                        return "kotlin.Float.Companion";
                    }
                    break;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "kotlin.collections.Iterator";
                    }
                    break;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "kotlin.collections.ListIterator";
                    }
                    break;
                case 599019395:
                    if (type.equals("kotlin.jvm.internal.StringCompanionObject")) {
                        return "kotlin.String.Companion";
                    }
                    break;
                case 761287205:
                    if (type.equals("java.lang.Double")) {
                        return "kotlin.Double";
                    }
                    break;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "kotlin.Number";
                    }
                    break;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "kotlin.Any";
                    }
                    break;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "kotlin.String";
                    }
                    break;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "kotlin.collections.Iterable";
                    }
                    break;
                case 1383693018:
                    if (type.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "kotlin.Boolean.Companion";
                    }
                    break;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "kotlin.Throwable";
                    }
                    break;
                case 1877171123:
                    if (type.equals("kotlin.jvm.internal.IntCompanionObject")) {
                        return "kotlin.Int.Companion";
                    }
                    break;
            }
            return null;
        }

        private final String simpleNameOf(String type) {
            switch (type.hashCode()) {
                case -2061550653:
                    if (type.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "Int";
                    }
                    break;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "Cloneable";
                    }
                    break;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "Annotation";
                    }
                    break;
                case -1811142716:
                    if (type.equals("kotlin.jvm.functions.Function10")) {
                        return "Function10";
                    }
                    break;
                case -1811142715:
                    if (type.equals("kotlin.jvm.functions.Function11")) {
                        return "Function11";
                    }
                    break;
                case -1811142714:
                    if (type.equals("kotlin.jvm.functions.Function12")) {
                        return "Function12";
                    }
                    break;
                case -1811142713:
                    if (type.equals("kotlin.jvm.functions.Function13")) {
                        return "Function13";
                    }
                    break;
                case -1811142712:
                    if (type.equals("kotlin.jvm.functions.Function14")) {
                        return "Function14";
                    }
                    break;
                case -1811142711:
                    if (type.equals("kotlin.jvm.functions.Function15")) {
                        return "Function15";
                    }
                    break;
                case -1811142710:
                    if (type.equals("kotlin.jvm.functions.Function16")) {
                        return "Function16";
                    }
                    break;
                case -1811142709:
                    if (type.equals("kotlin.jvm.functions.Function17")) {
                        return "Function17";
                    }
                    break;
                case -1811142708:
                    if (type.equals("kotlin.jvm.functions.Function18")) {
                        return "Function18";
                    }
                    break;
                case -1811142707:
                    if (type.equals("kotlin.jvm.functions.Function19")) {
                        return "Function19";
                    }
                    break;
                case -1811142685:
                    if (type.equals("kotlin.jvm.functions.Function20")) {
                        return "Function20";
                    }
                    break;
                case -1811142684:
                    if (type.equals("kotlin.jvm.functions.Function21")) {
                        return "Function21";
                    }
                    break;
                case -1811142683:
                    if (type.equals("kotlin.jvm.functions.Function22")) {
                        return "Function22";
                    }
                    break;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "Comparable";
                    }
                    break;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "Map";
                    }
                    break;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "Set";
                    }
                    break;
                case -1325958191:
                    if (type.equals("double")) {
                        return "Double";
                    }
                    break;
                case -1182275604:
                    if (type.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "CharSequence";
                    }
                    break;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "Collection";
                    }
                    break;
                case -527879800:
                    if (type.equals("java.lang.Float")) {
                        return "Float";
                    }
                    break;
                case -515992664:
                    if (type.equals("java.lang.Short")) {
                        return "Short";
                    }
                    break;
                case -246476834:
                    if (type.equals("kotlin.jvm.internal.CharCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case -207262728:
                    if (type.equals("kotlin.jvm.internal.LongCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "Entry";
                    }
                    break;
                case 104431:
                    if (type.equals("int")) {
                        return "Int";
                    }
                    break;
                case 3039496:
                    if (type.equals("byte")) {
                        return "Byte";
                    }
                    break;
                case 3052374:
                    if (type.equals("char")) {
                        return "Char";
                    }
                    break;
                case 3327612:
                    if (type.equals("long")) {
                        return "Long";
                    }
                    break;
                case 64711720:
                    if (type.equals("boolean")) {
                        return "Boolean";
                    }
                    break;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "List";
                    }
                    break;
                case 77230534:
                    if (type.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case 80123371:
                    if (type.equals("kotlin.jvm.functions.Function0")) {
                        return "Function0";
                    }
                    break;
                case 80123372:
                    if (type.equals("kotlin.jvm.functions.Function1")) {
                        return "Function1";
                    }
                    break;
                case 80123373:
                    if (type.equals("kotlin.jvm.functions.Function2")) {
                        return "Function2";
                    }
                    break;
                case 80123374:
                    if (type.equals("kotlin.jvm.functions.Function3")) {
                        return "Function3";
                    }
                    break;
                case 80123375:
                    if (type.equals("kotlin.jvm.functions.Function4")) {
                        return "Function4";
                    }
                    break;
                case 80123376:
                    if (type.equals("kotlin.jvm.functions.Function5")) {
                        return "Function5";
                    }
                    break;
                case 80123377:
                    if (type.equals("kotlin.jvm.functions.Function6")) {
                        return "Function6";
                    }
                    break;
                case 80123378:
                    if (type.equals("kotlin.jvm.functions.Function7")) {
                        return "Function7";
                    }
                    break;
                case 80123379:
                    if (type.equals("kotlin.jvm.functions.Function8")) {
                        return "Function8";
                    }
                    break;
                case 80123380:
                    if (type.equals("kotlin.jvm.functions.Function9")) {
                        return "Function9";
                    }
                    break;
                case 97526364:
                    if (type.equals("float")) {
                        return "Float";
                    }
                    break;
                case 109413500:
                    if (type.equals("short")) {
                        return "Short";
                    }
                    break;
                case 155276373:
                    if (type.equals("java.lang.Character")) {
                        return "Char";
                    }
                    break;
                case 226173651:
                    if (type.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case 344809556:
                    if (type.equals("java.lang.Boolean")) {
                        return "Boolean";
                    }
                    break;
                case 398507100:
                    if (type.equals("java.lang.Byte")) {
                        return "Byte";
                    }
                    break;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "Enum";
                    }
                    break;
                case 398795216:
                    if (type.equals("java.lang.Long")) {
                        return "Long";
                    }
                    break;
                case 482629606:
                    if (type.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "Iterator";
                    }
                    break;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "ListIterator";
                    }
                    break;
                case 599019395:
                    if (type.equals("kotlin.jvm.internal.StringCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case 761287205:
                    if (type.equals("java.lang.Double")) {
                        return "Double";
                    }
                    break;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "Number";
                    }
                    break;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "Any";
                    }
                    break;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "String";
                    }
                    break;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "Iterable";
                    }
                    break;
                case 1383693018:
                    if (type.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "Companion";
                    }
                    break;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "Throwable";
                    }
                    break;
                case 1877171123:
                    if (type.equals("kotlin.jvm.internal.IntCompanionObject")) {
                        return "Companion";
                    }
                    break;
            }
            return null;
        }

        public final String getClassSimpleName(Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (jClass.isLocalClass()) {
                String name = jClass.getSimpleName();
                Method method = jClass.getEnclosingMethod();
                if (method != null) {
                    Intrinsics.checkNotNull(name);
                    String substringAfter$default = StringsKt.substringAfter$default(name, method.getName() + Typography.dollar, (String) null, 2, (Object) null);
                    if (substringAfter$default != null) {
                        return substringAfter$default;
                    }
                }
                Constructor constructor = jClass.getEnclosingConstructor();
                if (constructor != null) {
                    Intrinsics.checkNotNull(name);
                    return StringsKt.substringAfter$default(name, constructor.getName() + Typography.dollar, (String) null, 2, (Object) null);
                }
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, (char) Typography.dollar, (String) null, 2, (Object) null);
            } else if (jClass.isArray()) {
                Class componentType = jClass.getComponentType();
                if (componentType.isPrimitive()) {
                    String name2 = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String simpleNameOf = simpleNameOf(name2);
                    if (simpleNameOf != null) {
                        str = simpleNameOf + "Array";
                    }
                }
                return str == null ? "Array" : str;
            } else {
                String name3 = jClass.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                String simpleNameOf2 = simpleNameOf(name3);
                return simpleNameOf2 == null ? jClass.getSimpleName() : simpleNameOf2;
            }
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class componentType = jClass.getComponentType();
                if (componentType.isPrimitive()) {
                    String name = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String classFqNameOf = classFqNameOf(name);
                    if (classFqNameOf != null) {
                        str = classFqNameOf + "Array";
                    }
                }
                return str == null ? CollectionDescriptorsKt.ARRAY_NAME : str;
            }
            String name2 = jClass.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            String classFqNameOf2 = classFqNameOf(name2);
            return classFqNameOf2 == null ? jClass.getCanonicalName() : classFqNameOf2;
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Map map = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                int arity = num.intValue();
                return TypeIntrinsics.isFunctionOfArity(value, arity);
            }
            Class objectType = jClass.isPrimitive() ? JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass)) : jClass;
            return objectType.isInstance(value);
        }
    }

    static {
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Class clazz = (Class) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(clazz, Integer.valueOf(index$iv$iv)));
            index$iv$iv = index$iv$iv2;
        }
        FUNCTION_CLASSES = MapsKt.toMap((List) destination$iv$iv);
    }
}