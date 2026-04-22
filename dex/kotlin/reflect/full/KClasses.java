package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeSubstitutor;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: KClasses.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\u001a\u001c\u0010S\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010T\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a\u001c\u0010U\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010V\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a+\u0010W\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010Y\u001a-\u0010Z\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010Y\u001a!\u0010[\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0010\"6\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\f\"$\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0011\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\",\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b\",\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b\",\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\u001b\",\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u001b\",\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u001b\",\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\u001b\",\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\u001b\",\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\u001b\",\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\u001b\">\u00105\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\u001b\"B\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\u001b\">\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b?\u0010\u001b\"B\u0010@\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010\u001b\"\u001c\u0010C\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010F\"\u001c\u0010G\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010F\",\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040I*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010L\"(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010\u0006\u001a\u0004\bO\u0010\u001b\",\u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\u001b¨\u0006\\"}, d2 = {"primaryConstructor", "Lkotlin/reflect/KFunction;", "T", "", "Lkotlin/reflect/KClass;", "getPrimaryConstructor$annotations", "(Lkotlin/reflect/KClass;)V", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "defaultType", "Lkotlin/reflect/KType;", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "declaredMembers", "", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "functions", "getFunctions$annotations", "getFunctions", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "declaredFunctions", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "memberProperties", "Lkotlin/reflect/KProperty1;", "getMemberProperties$annotations", "getMemberProperties", "memberExtensionProperties", "Lkotlin/reflect/KProperty2;", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "declaredMemberProperties", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMemberExtensionProperties", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "allSupertypes", "getAllSupertypes$annotations", "getAllSupertypes", "allSuperclasses", "getAllSuperclasses$annotations", "getAllSuperclasses", "isSubclassOf", "base", "isSuperclassOf", "derived", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "createInstance", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KClasses {
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> kClass) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$firstOrNull$iv = ((KClassImpl) kClass).getConstructors();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                KFunction it2 = (KFunction) element$iv;
                Intrinsics.checkNotNull(it2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
                FunctionDescriptor descriptor = ((KFunctionImpl) it2).getDescriptor();
                Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
                if (((ConstructorDescriptor) descriptor).isPrimary()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (KFunction) element$iv;
    }

    public static final KClass<?> getCompanionObject(KClass<?> kClass) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$firstOrNull$iv = kClass.getNestedClasses();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                KClass p0 = (KClass) element$iv;
                if (p0.isCompanion()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (KClass) element$iv;
    }

    public static final Object getCompanionObjectInstance(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    public static final KType getDefaultType(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KClass<?> kClass2 = kClass;
        Iterable $this$map$iv = kClass.getTypeParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KTypeParameter typeParameter = (KTypeParameter) item$iv$iv;
            destination$iv$iv.add(new KTypeProjection(KVariance.INVARIANT, KClassifiers.createType$default(typeParameter, null, false, null, 7, null)));
        }
        return KClassifiers.createType$default(kClass2, (List) destination$iv$iv, false, null, 6, null);
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filterIsInstance$iv = kClass.getMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof KFunction) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filterIsInstance$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof KFunction) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) element$iv$iv;
            if (isNotExtension(it) && (it instanceof KFunction)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) element$iv$iv;
            if (isExtension(it) && (it instanceof KFunction)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filterIsInstance$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof KFunction) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) element$iv$iv;
            if (isNotExtension(it) && (it instanceof KFunction)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) element$iv$iv;
            if (isExtension(it) && (it instanceof KFunction)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) element$iv$iv;
            if (isNotExtension(it) && (it instanceof KProperty0)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) t;
            if (isNotExtension(it) && (it instanceof KProperty1)) {
                destination$iv$iv.add(t);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) t;
            if (isExtension(it) && (it instanceof KProperty2)) {
                destination$iv$iv.add(t);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) t;
            if (isNotExtension(it) && (it instanceof KProperty1)) {
                destination$iv$iv.add(t);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$filter$iv = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            KCallableImpl it = (KCallableImpl) t;
            if (isExtension(it) && (it instanceof KProperty2)) {
                destination$iv$iv.add(t);
            }
        }
        return (List) destination$iv$iv;
    }

    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$mapNotNull$iv = kClass.getSupertypes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            KType it = (KType) element$iv$iv$iv;
            KClassifier classifier = it.getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 != null) {
                destination$iv$iv.add(kClass2);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Object dfs = DFS.dfs(kClass.getSupertypes(), new DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$$Lambda$0
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable _get_allSupertypes_$lambda$0;
                _get_allSupertypes_$lambda$0 = KClasses._get_allSupertypes_$lambda$0((KType) obj);
                return _get_allSupertypes_$lambda$0;
            }
        }, new DFS.VisitedWithSet(), new DFS.NodeHandlerWithListResult<KType, KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(KType current) {
                Intrinsics.checkNotNullParameter(current, "current");
                ((LinkedList) this.result).add(current);
                return true;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(...)");
        return (Collection) dfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable _get_allSupertypes_$lambda$0(KType current) {
        KClassifier classifier = current.getClassifier();
        KClass klass = classifier instanceof KClass ? (KClass) classifier : null;
        if (klass == null) {
            throw new KotlinReflectionInternalError("Supertype not a class: " + current);
        }
        Iterable supertypes = klass.getSupertypes();
        if (current.getArguments().isEmpty()) {
            return supertypes;
        }
        KTypeSubstitutor substitutor = KTypeSubstitutor.Companion.create(klass, current.getArguments());
        Iterable $this$map$iv = supertypes;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType it = (KType) item$iv$iv;
            KType type = substitutor.substitute(it).getType();
            if (type == null) {
                throw new KotlinReflectionInternalError("Incorrect type substitution: " + it);
            }
            destination$iv$iv.add(type);
        }
        return (List) destination$iv$iv;
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$map$iv = getAllSupertypes(kClass);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType supertype = (KType) item$iv$iv;
            KClassifier classifier = supertype.getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 == null) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + supertype);
            }
            destination$iv$iv.add(kClass2);
        }
        return (List) destination$iv$iv;
    }

    public static final boolean isSubclassOf(KClass<?> kClass, final KClass<?> base) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        if (!Intrinsics.areEqual(kClass, base)) {
            final KClasses$isSubclassOf$1 kClasses$isSubclassOf$1 = new PropertyReference1Impl() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object receiver0) {
                    return KClasses.getSuperclasses((KClass) receiver0);
                }
            };
            if (!DFS.ifAny(CollectionsKt.listOf(kClass), new DFS.Neighbors(kClasses$isSubclassOf$1) { // from class: kotlin.reflect.full.KClasses$$Lambda$1
                private final KProperty1 arg$0;

                {
                    this.arg$0 = kClasses$isSubclassOf$1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                public Iterable getNeighbors(Object obj) {
                    Iterable isSubclassOf$lambda$0;
                    isSubclassOf$lambda$0 = KClasses.isSubclassOf$lambda$0(this.arg$0, (KClass) obj);
                    return isSubclassOf$lambda$0;
                }
            }, new Function1(base) { // from class: kotlin.reflect.full.KClasses$$Lambda$2
                private final KClass arg$0;

                {
                    this.arg$0 = base;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Boolean isSubclassOf$lambda$1;
                    isSubclassOf$lambda$1 = KClasses.isSubclassOf$lambda$1(this.arg$0, (KClass) obj);
                    return isSubclassOf$lambda$1;
                }
            }).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable isSubclassOf$lambda$0(KProperty1 $tmp0, KClass p0) {
        return (Iterable) $tmp0.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isSubclassOf$lambda$1(KClass $base, KClass it) {
        return Boolean.valueOf(Intrinsics.areEqual(it, $base));
    }

    public static final boolean isSuperclassOf(KClass<?> kClass, KClass<?> derived) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(derived, "derived");
        return isSubclassOf(derived, kClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(KClass<T> kClass, Object value) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (!kClass.isInstance(value)) {
            throw new TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
        }
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T safeCast(KClass<T> kClass, Object value) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (kClass.isInstance(value)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
            return value;
        }
        return null;
    }

    public static final <T> T createInstance(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable $this$singleOrNull$iv = kClass.getConstructors();
        Object single$iv = null;
        boolean found$iv = false;
        Iterator<T> it = $this$singleOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                KFunction it2 = (KFunction) element$iv;
                Iterable $this$all$iv = it2.getParameters();
                boolean z = true;
                if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                    Iterator<T> it3 = $this$all$iv.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        KParameter p0 = (KParameter) it3.next();
                        if (!p0.isOptional()) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    if (found$iv) {
                        single$iv = null;
                        break;
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
            } else if (!found$iv) {
                single$iv = null;
            }
        }
        KFunction noArgsConstructor = (KFunction) single$iv;
        if (noArgsConstructor != null) {
            return (T) noArgsConstructor.callBy(MapsKt.emptyMap());
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + kClass);
    }
}