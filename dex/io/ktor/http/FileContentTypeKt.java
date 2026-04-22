package io.ktor.http;

import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.ContentType;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: FileContentType.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\r\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\n\u001a\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001aC\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u001a\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00190\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"-\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"-\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "extension", "Lio/ktor/http/ContentType;", "defaultForFileExtension", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Lio/ktor/http/ContentType;", "path", "defaultForFilePath", "", "fromFilePath", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Ljava/util/List;", "ext", "fromFileExtension", "fileExtensions", "(Lio/ktor/http/ContentType;)Ljava/util/List;", "selectDefault", "(Ljava/util/List;)Lio/ktor/http/ContentType;", "", "matchApplicationTypeWithCharset", "(Lio/ktor/http/ContentType;)Z", "withCharsetUTF8IfNeeded", "(Lio/ktor/http/ContentType;)Lio/ktor/http/ContentType;", "A", "B", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "groupByPairs", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "toContentType", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "contentTypesByExtensions$delegate", "Lkotlin/Lazy;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions", "extensionsByContentType$delegate", "getExtensionsByContentType", "extensionsByContentType", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FileContentTypeKt {
    private static final Lazy contentTypesByExtensions$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.FileContentTypeKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            Map contentTypesByExtensions_delegate$lambda$1;
            contentTypesByExtensions_delegate$lambda$1 = FileContentTypeKt.contentTypesByExtensions_delegate$lambda$1();
            return contentTypesByExtensions_delegate$lambda$1;
        }
    });
    private static final Lazy extensionsByContentType$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.http.FileContentTypeKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            Map extensionsByContentType_delegate$lambda$3;
            extensionsByContentType_delegate$lambda$3 = FileContentTypeKt.extensionsByContentType_delegate$lambda$3();
            return extensionsByContentType_delegate$lambda$3;
        }
    });

    public static final ContentType defaultForFileExtension(ContentType.Companion $this$defaultForFileExtension, String extension) {
        Intrinsics.checkNotNullParameter($this$defaultForFileExtension, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return selectDefault(fromFileExtension(ContentType.Companion, extension));
    }

    public static final ContentType defaultForFilePath(ContentType.Companion $this$defaultForFilePath, String path) {
        Intrinsics.checkNotNullParameter($this$defaultForFilePath, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return selectDefault(fromFilePath(ContentType.Companion, path));
    }

    public static final List<ContentType> fromFilePath(ContentType.Companion $this$fromFilePath, String path) {
        Intrinsics.checkNotNullParameter($this$fromFilePath, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        int slashIndex = StringsKt.lastIndexOfAny$default(path, CharsetKt.toCharArray("/\\"), 0, false, 6, (Object) null);
        int index = StringsKt.indexOf$default(path, (char) ClassUtils.PACKAGE_SEPARATOR_CHAR, slashIndex + 1, false, 4, (Object) null);
        if (index == -1) {
            return CollectionsKt.emptyList();
        }
        String substring = path.substring(index + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return fromFileExtension($this$fromFilePath, substring);
    }

    public static final List<ContentType> fromFileExtension(ContentType.Companion $this$fromFileExtension, String ext) {
        Intrinsics.checkNotNullParameter($this$fromFileExtension, "<this>");
        Intrinsics.checkNotNullParameter(ext, "ext");
        String current = TextKt.toLowerCasePreservingASCIIRules(StringsKt.removePrefix(ext, "."));
        while (true) {
            if (current.length() > 0) {
                List type = getContentTypesByExtensions().get(current);
                if (type == null) {
                    current = StringsKt.substringAfter(current, ".", "");
                } else {
                    return type;
                }
            } else {
                return CollectionsKt.emptyList();
            }
        }
    }

    public static final List<String> fileExtensions(ContentType $this$fileExtensions) {
        Intrinsics.checkNotNullParameter($this$fileExtensions, "<this>");
        List<String> list = getExtensionsByContentType().get($this$fileExtensions);
        if (list == null) {
            List<String> list2 = getExtensionsByContentType().get($this$fileExtensions.withoutParameters());
            return list2 == null ? CollectionsKt.emptyList() : list2;
        }
        return list;
    }

    private static final Map<String, List<ContentType>> getContentTypesByExtensions() {
        return (Map) contentTypesByExtensions$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map contentTypesByExtensions_delegate$lambda$1() {
        Map $this$contentTypesByExtensions_delegate_u24lambda_u241_u24lambda_u240 = io.ktor.util.CollectionsKt.caseInsensitiveMap();
        $this$contentTypesByExtensions_delegate_u24lambda_u241_u24lambda_u240.putAll(groupByPairs(CollectionsKt.asSequence(MimesKt.getMimes())));
        return $this$contentTypesByExtensions_delegate_u24lambda_u241_u24lambda_u240;
    }

    private static final Map<ContentType, List<String>> getExtensionsByContentType() {
        return (Map) extensionsByContentType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map extensionsByContentType_delegate$lambda$3() {
        return groupByPairs(SequencesKt.map(CollectionsKt.asSequence(MimesKt.getMimes()), new Function1() { // from class: io.ktor.http.FileContentTypeKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Pair extensionsByContentType_delegate$lambda$3$lambda$2;
                extensionsByContentType_delegate$lambda$3$lambda$2 = FileContentTypeKt.extensionsByContentType_delegate$lambda$3$lambda$2((Pair) obj);
                return extensionsByContentType_delegate$lambda$3$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair extensionsByContentType_delegate$lambda$3$lambda$2(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String first = (String) pair.component1();
        ContentType second = (ContentType) pair.component2();
        return TuplesKt.to(second, first);
    }

    public static final ContentType selectDefault(List<ContentType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ContentType contentType = (ContentType) CollectionsKt.firstOrNull(list);
        if (contentType == null) {
            contentType = ContentType.Application.INSTANCE.getOctetStream();
        }
        if (!contentType.match(ContentType.Text.INSTANCE.getAny()) && !contentType.match(ContentType.Image.INSTANCE.getSVG()) && !matchApplicationTypeWithCharset(contentType)) {
            return contentType;
        }
        return withCharsetUTF8IfNeeded(contentType);
    }

    private static final boolean matchApplicationTypeWithCharset(ContentType $this$matchApplicationTypeWithCharset) {
        if ($this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getAny())) {
            return $this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getAtom()) || $this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getJavaScript()) || $this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getRss()) || $this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getXml()) || $this$matchApplicationTypeWithCharset.match(ContentType.Application.INSTANCE.getXml_Dtd());
        }
        return false;
    }

    private static final ContentType withCharsetUTF8IfNeeded(ContentType $this$withCharsetUTF8IfNeeded) {
        return ContentTypesKt.charset($this$withCharsetUTF8IfNeeded) != null ? $this$withCharsetUTF8IfNeeded : ContentTypesKt.withCharset($this$withCharsetUTF8IfNeeded, Charsets.UTF_8);
    }

    public static final <A, B> Map<A, List<B>> groupByPairs(Sequence<? extends Pair<? extends A, ? extends B>> sequence) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : sequence) {
            Pair it = (Pair) element$iv$iv;
            Object key$iv$iv = it.getFirst();
            Object value$iv$iv$iv = destination$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                destination$iv$iv.put(key$iv$iv, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            List list$iv$iv = (List) arrayList;
            list$iv$iv.add(element$iv$iv);
        }
        Map $this$mapValues$iv = destination$iv$iv;
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry e2 = (Map.Entry) element$iv$iv$iv;
            Iterable $this$map$iv = (Iterable) e2.getValue();
            Map $this$mapValues$iv2 = $this$mapValues$iv;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Pair it2 = (Pair) item$iv$iv;
                destination$iv$iv3.add(it2.getSecond());
            }
            destination$iv$iv2.put(key, (List) destination$iv$iv3);
            $this$mapValues$iv = $this$mapValues$iv2;
        }
        return destination$iv$iv2;
    }

    public static final ContentType toContentType(String $this$toContentType) {
        Intrinsics.checkNotNullParameter($this$toContentType, "<this>");
        try {
            return ContentType.Companion.parse($this$toContentType);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to parse " + $this$toContentType, e2);
        }
    }
}