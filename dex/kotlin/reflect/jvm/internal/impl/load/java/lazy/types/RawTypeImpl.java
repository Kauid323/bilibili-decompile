package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.slf4j.Marker;

/* compiled from: RawType.kt */
public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType lowerBound, SimpleType upperBound, boolean disableAssertion) {
        super(lowerBound, upperBound);
        if (disableAssertion || KotlinTypeChecker.DEFAULT.isSubtypeOf(lowerBound, upperBound)) {
            return;
        }
        throw new AssertionError("Lower bound " + lowerBound + " of a flexible type must be a subtype of the upper bound " + upperBound);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(SimpleType lowerBound, SimpleType upperBound) {
        this(lowerBound, upperBound, false);
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor mo1171getDeclarationDescriptor = getConstructor().mo1171getDeclarationDescriptor();
        ClassDescriptor classDescriptor = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo1171getDeclarationDescriptor()).toString());
        }
        MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAttributes(TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(newAttributes), getUpperBound().replaceAttributes(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean newNullability) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(newNullability), getUpperBound().makeNullableAsSpecified(newNullability));
    }

    private static final boolean render$onlyOutDiffers(String first, String second) {
        return Intrinsics.areEqual(first, StringsKt.removePrefix(second, (CharSequence) "out ")) || Intrinsics.areEqual(second, Marker.ANY_MARKER);
    }

    private static final List<String> render$renderArguments(DescriptorRenderer $renderer, KotlinType type) {
        Iterable $this$map$iv = type.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeProjection it = (TypeProjection) item$iv$iv;
            destination$iv$iv.add($renderer.renderTypeProjection(it));
        }
        return (List) destination$iv$iv;
    }

    private static final String render$replaceArgs(String $this$render_u24replaceArgs, String newArgs) {
        return !StringsKt.contains$default((CharSequence) $this$render_u24replaceArgs, (char) Typography.less, false, 2, (Object) null) ? $this$render_u24replaceArgs : StringsKt.substringBefore$default($this$render_u24replaceArgs, (char) Typography.less, (String) null, 2, (Object) null) + Typography.less + newArgs + Typography.greater + StringsKt.substringAfterLast$default($this$render_u24replaceArgs, (char) Typography.greater, (String) null, 2, (Object) null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer renderer, DescriptorRendererOptions options) {
        String newUpper;
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        String lowerRendered = renderer.renderType(getLowerBound());
        String upperRendered = renderer.renderType(getUpperBound());
        if (options.getDebugMode()) {
            return "raw (" + lowerRendered + ".." + upperRendered + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return renderer.renderFlexibleType(lowerRendered, upperRendered, TypeUtilsKt.getBuiltIns(this));
        }
        List lowerArgs = render$renderArguments(renderer, getLowerBound());
        List upperArgs = render$renderArguments(renderer, getUpperBound());
        String newArgs = CollectionsKt.joinToString$default(lowerArgs, ", ", null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence render$lambda$1;
                render$lambda$1 = RawTypeImpl.render$lambda$1((String) obj);
                return render$lambda$1;
            }
        }, 30, null);
        Iterable $this$all$iv = CollectionsKt.zip(lowerArgs, upperArgs);
        boolean z = true;
        if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
            Iterator it = $this$all$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                Pair it2 = (Pair) element$iv;
                if (!render$onlyOutDiffers((String) it2.getFirst(), (String) it2.getSecond())) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            newUpper = render$replaceArgs(upperRendered, newArgs);
        } else {
            newUpper = upperRendered;
        }
        String newLower = render$replaceArgs(lowerRendered, newArgs);
        return Intrinsics.areEqual(newLower, newUpper) ? newLower : renderer.renderFlexibleType(newLower, newUpper, TypeUtilsKt.getBuiltIns(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence render$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "(raw) " + it;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType((KotlinTypeMarker) getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType((KotlinTypeMarker) getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) refineType, (SimpleType) refineType2, true);
    }
}