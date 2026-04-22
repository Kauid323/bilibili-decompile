package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: RenderingUtils.kt */
public final class RenderingUtilsKt {
    public static final String render(Name $this$render) {
        Intrinsics.checkNotNullParameter($this$render, "<this>");
        if (!shouldBeEscaped($this$render)) {
            String asString = $this$render.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }
        StringBuilder sb = new StringBuilder();
        String asString2 = $this$render.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        return sb.append('`' + asString2).append('`').toString();
    }

    private static final boolean shouldBeEscaped(Name $this$shouldBeEscaped) {
        CharSequence $this$any$iv;
        String string = $this$shouldBeEscaped.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        if (KeywordStringsGenerated.KEYWORDS.contains(string)) {
            return true;
        }
        String $this$any$iv2 = string;
        int i = 0;
        while (true) {
            if (i < $this$any$iv2.length()) {
                char element$iv = $this$any$iv2.charAt(i);
                char it = (Character.isLetterOrDigit(element$iv) || element$iv == '_') ? (char) 0 : (char) 1;
                if (it != 0) {
                    $this$any$iv = 1;
                    break;
                }
                i++;
            } else {
                $this$any$iv = null;
                break;
            }
        }
        if ($this$any$iv == null) {
            return (string.length() == 0) || !Character.isJavaIdentifierStart(string.codePointAt(0));
        }
        return true;
    }

    public static final String render(FqNameUnsafe $this$render) {
        Intrinsics.checkNotNullParameter($this$render, "<this>");
        return renderFqName($this$render.pathSegments());
    }

    public static final String renderFqName(List<Name> pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder $this$renderFqName_u24lambda_u240 = new StringBuilder();
        for (Name element : pathSegments) {
            if ($this$renderFqName_u24lambda_u240.length() > 0) {
                $this$renderFqName_u24lambda_u240.append(".");
            }
            $this$renderFqName_u24lambda_u240.append(render(element));
        }
        return $this$renderFqName_u24lambda_u240.toString();
    }

    public static /* synthetic */ String renderFlexibleMutabilityOrArrayElementVarianceType$default(String str, String str2, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj2) {
                    return RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0((String) obj2);
                }
            };
        }
        return renderFlexibleMutabilityOrArrayElementVarianceType(str, str2, function0, function02, function1);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static final java.lang.String renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0(java.lang.String r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0(java.lang.String):java.lang.String");
    }

    public static final String renderFlexibleMutabilityOrArrayElementVarianceType(String lowerRendered, String upperRendered, Function0<String> renderKotlinCollectionsPrefix, Function0<String> renderKotlinPrefix, Function1<? super String, String> escape) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(renderKotlinCollectionsPrefix, "renderKotlinCollectionsPrefix");
        Intrinsics.checkNotNullParameter(renderKotlinPrefix, "renderKotlinPrefix");
        Intrinsics.checkNotNullParameter(escape, "escape");
        String kotlinCollectionsPrefix = renderKotlinCollectionsPrefix.invoke();
        String simpleCollection = replacePrefixesInTypeRepresentations(lowerRendered, kotlinCollectionsPrefix + "Mutable", upperRendered, kotlinCollectionsPrefix, kotlinCollectionsPrefix + "(Mutable)");
        if (simpleCollection != null) {
            return simpleCollection;
        }
        String mutableEntry = replacePrefixesInTypeRepresentations(lowerRendered, kotlinCollectionsPrefix + "MutableMap.MutableEntry", upperRendered, kotlinCollectionsPrefix + "Map.Entry", kotlinCollectionsPrefix + "(Mutable)Map.(Mutable)Entry");
        if (mutableEntry != null) {
            return mutableEntry;
        }
        String kotlinPrefix = renderKotlinPrefix.invoke();
        String array = replacePrefixesInTypeRepresentations(lowerRendered, kotlinPrefix + escape.invoke("Array<"), upperRendered, kotlinPrefix + escape.invoke("Array<out "), kotlinPrefix + escape.invoke("Array<(out) "));
        if (array != null) {
            return array;
        }
        return null;
    }

    public static final String replacePrefixesInTypeRepresentations(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, (Object) null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, (Object) null)) {
            String lowerWithoutPrefix = lowerRendered.substring(lowerPrefix.length());
            Intrinsics.checkNotNullExpressionValue(lowerWithoutPrefix, "substring(...)");
            String upperWithoutPrefix = upperRendered.substring(upperPrefix.length());
            Intrinsics.checkNotNullExpressionValue(upperWithoutPrefix, "substring(...)");
            String flexibleCollectionName = foldedPrefix + lowerWithoutPrefix;
            if (Intrinsics.areEqual(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName;
            }
            if (typeStringsDifferOnlyInNullability(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName + '!';
            }
        }
        return null;
    }

    public static final boolean typeStringsDifferOnlyInNullability(String lower, String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        return Intrinsics.areEqual(lower, StringsKt.replace$default(upper, "?", "", false, 4, (Object) null)) || (StringsKt.endsWith$default(upper, "?", false, 2, (Object) null) && Intrinsics.areEqual(new StringBuilder().append(lower).append('?').toString(), upper)) || Intrinsics.areEqual(new StringBuilder().append('(').append(lower).append(")?").toString(), upper);
    }
}