package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.webrtc.H265Utils;

/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 B2\u00020\u0001:\u0004?@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJE\u0010 \u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0002\u0010'J=\u0010(\u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0002\u0010)J(\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dJ \u0010/\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&J\u0014\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ4\u00103\u001a\u0002042\u0010\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005062\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,2\u0006\u00108\u001a\u00020&H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020&H\u0002J$\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0002R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "<init>", "()V", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "findPropertyDescriptor", "", "signature", "findFunctionDescriptor", "lookupMethod", "Ljava/lang/reflect/Method;", "parameterTypes", "", "returnType", "isStaticDefault", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "Ljava/lang/reflect/Constructor;", "", "findMethodBySignature", "desc", "findDefaultMethod", "isMember", "findConstructorBySignature", "findDefaultConstructor", "addParametersAndMasks", "", "result", "", "valueParameters", "isConstructor", "parseJvmDescriptor", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "parseReturnType", "parseType", "begin", "end", "Data", "MemberBelonginess", "FunctionJvmDescriptor", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Data.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};
        private final ReflectProperties.LazySoftVal moduleData$delegate;

        public Data() {
            final KDeclarationContainerImpl kDeclarationContainerImpl = KDeclarationContainerImpl.this;
            this.moduleData$delegate = ReflectProperties.lazySoft(new Function0(kDeclarationContainerImpl) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$$Lambda$0
                private final KDeclarationContainerImpl arg$0;

                {
                    this.arg$0 = kDeclarationContainerImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    RuntimeModuleData moduleData_delegate$lambda$0;
                    moduleData_delegate$lambda$0 = KDeclarationContainerImpl.Data.moduleData_delegate$lambda$0(this.arg$0);
                    return moduleData_delegate$lambda$0;
                }
            });
        }

        public final RuntimeModuleData getModuleData() {
            T value = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (RuntimeModuleData) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RuntimeModuleData moduleData_delegate$lambda$0(KDeclarationContainerImpl this$0) {
            return ModuleByClassLoaderKt.getOrCreateModule(this$0.getJClass());
        }
    }

    protected Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<KCallableImpl<?>> getMembers(MemberScope scope, MemberBelonginess belonginess) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(belonginess, "belonginess");
        CreateKCallableVisitor createKCallableVisitor = new CreateKCallableVisitor(this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor descriptor, Unit data) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(data, "data");
                throw new IllegalStateException("No constructors should appear here: " + descriptor);
            }
        };
        Iterable $this$mapNotNull$iv = ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            DeclarationDescriptor descriptor = (DeclarationDescriptor) element$iv$iv$iv;
            KCallableImpl kCallableImpl = ((descriptor instanceof CallableMemberDescriptor) && !Intrinsics.areEqual(((CallableMemberDescriptor) descriptor).getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) && belonginess.accept((CallableMemberDescriptor) descriptor)) ? (KCallableImpl) descriptor.accept(createKCallableVisitor, Unit.INSTANCE) : null;
            if (kCallableImpl != null) {
                destination$iv$iv.add(kCallableImpl);
            }
        }
        return CollectionsKt.toList((List) destination$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public final boolean accept(CallableMemberDescriptor member) {
            Intrinsics.checkNotNullParameter(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String signature) {
        boolean z;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        MatchResult match = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (match != null) {
            String number = match.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(number));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + number + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterable $this$filter$iv = getProperties(identifier);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PropertyDescriptor descriptor = (PropertyDescriptor) element$iv$iv;
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).asString(), signature)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List properties = (List) destination$iv$iv;
        if (properties.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (properties.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single((List<? extends Object>) properties);
        }
        List $this$groupBy$iv = properties;
        boolean z2 = false;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Object element$iv$iv2 : $this$groupBy$iv) {
            PropertyDescriptor it = (PropertyDescriptor) element$iv$iv2;
            DescriptorVisibility visibility = it.getVisibility();
            MatchResult match2 = match;
            Iterable $this$groupBy$iv2 = $this$groupBy$iv;
            Object value$iv$iv$iv = destination$iv$iv2.get(visibility);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                z = z2;
                destination$iv$iv2.put(visibility, arrayList);
            } else {
                z = z2;
                arrayList = value$iv$iv$iv;
            }
            List list$iv$iv = (List) arrayList;
            list$iv$iv.add(element$iv$iv2);
            $this$groupBy$iv = $this$groupBy$iv2;
            match = match2;
            z2 = z;
        }
        final KDeclarationContainerImpl$$Lambda$0 kDeclarationContainerImpl$$Lambda$0 = new Function2() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj, Object obj2) {
                int findPropertyDescriptor$lambda$2;
                findPropertyDescriptor$lambda$2 = KDeclarationContainerImpl.findPropertyDescriptor$lambda$2((DescriptorVisibility) obj, (DescriptorVisibility) obj2);
                return Integer.valueOf(findPropertyDescriptor$lambda$2);
            }
        };
        Collection values = MapsKt.toSortedMap(destination$iv$iv2, new Comparator(kDeclarationContainerImpl$$Lambda$0) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$1
            private final Function2 arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl$$Lambda$0;
            }

            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                int findPropertyDescriptor$lambda$3;
                findPropertyDescriptor$lambda$3 = KDeclarationContainerImpl.findPropertyDescriptor$lambda$3(this.arg$0, obj, obj2);
                return findPropertyDescriptor$lambda$3;
            }
        }).values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        List mostVisibleProperties = (List) CollectionsKt.last(values);
        if (mostVisibleProperties.size() == 1) {
            Intrinsics.checkNotNull(mostVisibleProperties);
            return (PropertyDescriptor) CollectionsKt.first((List<? extends Object>) mostVisibleProperties);
        }
        Name identifier2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        String allMembers = CollectionsKt.joinToString$default(getProperties(identifier2), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence findPropertyDescriptor$lambda$4;
                findPropertyDescriptor$lambda$4 = KDeclarationContainerImpl.findPropertyDescriptor$lambda$4((PropertyDescriptor) obj);
                return findPropertyDescriptor$lambda$4;
            }
        }, 30, null);
        throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this + AbstractJsonLexerKt.COLON + (allMembers.length() == 0 ? " no members found" : '\n' + allMembers));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$2(DescriptorVisibility first, DescriptorVisibility second) {
        Integer compare = DescriptorVisibilities.compare(first, second);
        if (compare != null) {
            return compare.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findPropertyDescriptor$lambda$4(PropertyDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).asString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FunctionDescriptor findFunctionDescriptor(String name, String signature) {
        int $i$f$filter;
        Collection members;
        List functions;
        Collection members2;
        List functions2;
        Iterable $this$filter$iv;
        boolean z;
        String initial;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        List functions3 = null;
        if (Intrinsics.areEqual(name, "<init>")) {
            Collection members3 = CollectionsKt.toList(getConstructorDescriptors());
            Collection $this$filter$iv2 = members3;
            boolean z2 = false;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv2) {
                ConstructorDescriptor descriptor = (ConstructorDescriptor) element$iv$iv;
                if (descriptor.isPrimary()) {
                    ClassifierDescriptorWithTypeParameters containingDeclaration = descriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                    if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration)) {
                        members2 = members3;
                        String initial2 = RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
                        functions2 = functions3;
                        $this$filter$iv = $this$filter$iv2;
                        z = z2;
                        if (!(StringsKt.startsWith$default(initial2, "constructor-impl", false, 2, (Object) null) && StringsKt.endsWith$default(initial2, ")V", false, 2, (Object) null))) {
                            throw new IllegalArgumentException(("Invalid signature of " + descriptor + ": " + initial2).toString());
                        }
                        StringBuilder append = new StringBuilder().append(StringsKt.removeSuffix(initial2, (CharSequence) "V"));
                        ClassifierDescriptorWithTypeParameters containingDeclaration2 = descriptor.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                        initial = append.append(ValueClassAwareCallerKt.toJvmDescriptor(containingDeclaration2)).toString();
                        if (!Intrinsics.areEqual(initial, signature)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        members3 = members2;
                        functions3 = functions2;
                        $this$filter$iv2 = $this$filter$iv;
                        z2 = z;
                    }
                }
                members2 = members3;
                functions2 = functions3;
                $this$filter$iv = $this$filter$iv2;
                z = z2;
                initial = RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
                if (!Intrinsics.areEqual(initial, signature)) {
                }
                members3 = members2;
                functions3 = functions2;
                $this$filter$iv2 = $this$filter$iv;
                z2 = z;
            }
            members = members3;
            $i$f$filter = 0;
            functions = (List) destination$iv$iv;
        } else {
            $i$f$filter = 0;
            Name identifier = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            Collection members4 = getFunctions(identifier);
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : members4) {
                if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) element$iv$iv2).asString(), signature)) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            members = members4;
            functions = (List) destination$iv$iv2;
        }
        if (functions.size() != 1) {
            String allMembers = CollectionsKt.joinToString$default(members, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    CharSequence findFunctionDescriptor$lambda$2;
                    findFunctionDescriptor$lambda$2 = KDeclarationContainerImpl.findFunctionDescriptor$lambda$2((FunctionDescriptor) obj);
                    return findFunctionDescriptor$lambda$2;
                }
            }, 30, null);
            throw new KotlinReflectionInternalError("Function '" + name + "' (JVM signature: " + signature + ") not resolved in " + this + AbstractJsonLexerKt.COLON + ((allMembers.length() != 0 ? $i$f$filter : 1) != 0 ? " no members found" : '\n' + allMembers));
        }
        return (FunctionDescriptor) CollectionsKt.single((List<? extends Object>) functions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findFunctionDescriptor$lambda$2(FunctionDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
    }

    private final Method lookupMethod(Class<?> cls, String name, Class<?>[] clsArr, Class<?> cls2, boolean isStaticDefault) {
        Class defaultImpls;
        Method it;
        if (isStaticDefault) {
            clsArr[0] = cls;
        }
        Method it2 = tryGetMethod(cls, name, clsArr, cls2);
        if (it2 != null) {
            return it2;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (it = lookupMethod(superclass, name, clsArr, cls2, isStaticDefault)) == null) {
            Class[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
            for (Class superInterface : interfaces) {
                Intrinsics.checkNotNull(superInterface);
                Method it3 = lookupMethod(superInterface, name, clsArr, cls2, isStaticDefault);
                if (it3 != null) {
                    return it3;
                }
                if (isStaticDefault && (defaultImpls = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(superInterface), superInterface.getName() + "$DefaultImpls")) != null) {
                    clsArr[0] = superInterface;
                    Method it4 = tryGetMethod(defaultImpls, name, clsArr, cls2);
                    if (it4 != null) {
                        return it4;
                    }
                }
            }
            return null;
        }
        return it;
    }

    private final Method tryGetMethod(Class<?> cls, String name, Class<?>[] clsArr, Class<?> cls2) {
        Object element$iv;
        try {
            Method result = cls.getDeclaredMethod(name, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual(result.getReturnType(), cls2)) {
                return result;
            }
            Object[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            Object[] $this$firstOrNull$iv = declaredMethods;
            int length = $this$firstOrNull$iv.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    element$iv = $this$firstOrNull$iv[i];
                    Method method = (Method) element$iv;
                    if (Intrinsics.areEqual(method.getName(), name) && Intrinsics.areEqual(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                        break;
                    }
                    i++;
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (Method) element$iv;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            List<? extends Class<?>> $this$toTypedArray$iv = list;
            Class[] clsArr = (Class[]) $this$toTypedArray$iv.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public final Method findMethodBySignature(String name, String desc) {
        Method it;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        FunctionJvmDescriptor functionJvmDescriptor = parseJvmDescriptor(desc, true);
        Collection $this$toTypedArray$iv = functionJvmDescriptor.getParameters();
        Class[] parameterTypes = (Class[]) $this$toTypedArray$iv.toArray(new Class[0]);
        Class returnType = functionJvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        Method it2 = lookupMethod(getMethodOwner(), name, parameterTypes, returnType, false);
        if (it2 != null) {
            return it2;
        }
        if (!getMethodOwner().isInterface() || (it = lookupMethod(Object.class, name, parameterTypes, returnType, false)) == null) {
            return null;
        }
        return it;
    }

    public final Method findDefaultMethod(String name, String desc, boolean isMember) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList parameterTypes = new ArrayList();
        if (isMember) {
            parameterTypes.add(getJClass());
        }
        FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(desc, true);
        addParametersAndMasks(parameterTypes, jvmDescriptor.getParameters(), false);
        Class<?> methodOwner = getMethodOwner();
        String str = name + "$default";
        ArrayList $this$toTypedArray$iv = parameterTypes;
        Class<?> returnType = jvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return lookupMethod(methodOwner, str, (Class[]) $this$toTypedArray$iv.toArray(new Class[0]), returnType, isMember);
    }

    public final Constructor<?> findConstructorBySignature(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return tryGetConstructor(getJClass(), parseJvmDescriptor(desc, false).getParameters());
    }

    public final Constructor<?> findDefaultConstructor(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Class<?> jClass = getJClass();
        ArrayList parameterTypes = new ArrayList();
        List parsedParameters = parseJvmDescriptor(desc, false).getParameters();
        addParametersAndMasks(parameterTypes, parsedParameters, true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, parameterTypes);
    }

    private final void addParametersAndMasks(List<Class<?>> list, List<? extends Class<?>> list2, boolean isConstructor) {
        List<? extends Class<?>> subList = Intrinsics.areEqual(CollectionsKt.lastOrNull((List<? extends Object>) list2), DEFAULT_CONSTRUCTOR_MARKER) ? list2.subList(0, list2.size() - 1) : list2;
        list.addAll(subList);
        int size = ((subList.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> TYPE = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            list.add(TYPE);
        }
        Class cls = isConstructor ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        Intrinsics.checkNotNull(cls);
        list.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "", "parameters", "", "Ljava/lang/Class;", "returnType", "<init>", "(Ljava/util/List;Ljava/lang/Class;)V", "getParameters", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FunctionJvmDescriptor {
        private final List<Class<?>> parameters;
        private final Class<?> returnType;

        /* JADX WARN: Multi-variable type inference failed */
        public FunctionJvmDescriptor(List<? extends Class<?>> parameters, Class<?> cls) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.parameters = parameters;
            this.returnType = cls;
        }

        public final List<Class<?>> getParameters() {
            return this.parameters;
        }

        public final Class<?> getReturnType() {
            return this.returnType;
        }
    }

    private final FunctionJvmDescriptor parseJvmDescriptor(String desc, boolean parseReturnType) {
        int end;
        ArrayList result = new ArrayList();
        int begin = 1;
        while (true) {
            if (desc.charAt(begin) != ')') {
                int end2 = begin;
                while (desc.charAt(end2) == '[') {
                    end2++;
                }
                char charAt = desc.charAt(end2);
                if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                    end = end2 + 1;
                } else if (charAt != 'L') {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
                } else {
                    end = StringsKt.indexOf$default((CharSequence) desc, ';', begin, false, 4, (Object) null) + 1;
                }
                result.add(parseType(desc, begin, end));
                begin = end;
            } else {
                Class returnType = parseReturnType ? parseType(desc, begin + 1, desc.length()) : null;
                return new FunctionJvmDescriptor(result, returnType);
            }
        }
    }

    private final Class<?> parseType(String desc, int begin, int end) {
        switch (desc.charAt(begin)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            case 'F':
                return Float.TYPE;
            case 'I':
                return Integer.TYPE;
            case HelpFormatter.DEFAULT_WIDTH /* 74 */:
                return Long.TYPE;
            case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
                ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
                String substring = desc.substring(begin + 1, end - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Class<?> loadClass = safeClassLoader.loadClass(StringsKt.replace$default(substring, '/', (char) FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null));
                Intrinsics.checkNotNullExpressionValue(loadClass, "loadClass(...)");
                return loadClass;
            case 'S':
                return Short.TYPE;
            case 'V':
                Class<?> TYPE = Void.TYPE;
                Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                return TYPE;
            case H265Utils.kLevel3 /* 90 */:
                return Boolean.TYPE;
            case '[':
                return UtilKt.createArrayType(parseType(desc, begin + 1, end));
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "<init>", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}