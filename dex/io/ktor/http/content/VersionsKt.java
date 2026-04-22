package io.ktor.http.content;

import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: Versions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "spec", "Lio/ktor/http/content/EntityTagVersion;", "EntityTagVersion", "(Ljava/lang/String;)Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/util/AttributeKey;", "", "Lio/ktor/http/content/Version;", "VersionListProperty", "Lio/ktor/util/AttributeKey;", "getVersionListProperty", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/http/content/OutgoingContent;", "value", "getVersions", "(Lio/ktor/http/content/OutgoingContent;)Ljava/util/List;", "setVersions", "(Lio/ktor/http/content/OutgoingContent;Ljava/util/List;)V", "versions", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VersionsKt {
    private static final AttributeKey<List<Version>> VersionListProperty;

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            kType = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Version.class)));
        } catch (Throwable th) {
            kType = null;
        }
        VersionListProperty = new AttributeKey<>("VersionList", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final AttributeKey<List<Version>> getVersionListProperty() {
        return VersionListProperty;
    }

    public static final List<Version> getVersions(OutgoingContent $this$versions) {
        Intrinsics.checkNotNullParameter($this$versions, "<this>");
        List<Version> list = (List) $this$versions.getProperty(VersionListProperty);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final void setVersions(OutgoingContent $this$versions, List<? extends Version> list) {
        Intrinsics.checkNotNullParameter($this$versions, "<this>");
        Intrinsics.checkNotNullParameter(list, "value");
        $this$versions.setProperty(VersionListProperty, list);
    }

    public static final EntityTagVersion EntityTagVersion(String spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        return EntityTagVersion.Companion.parseSingle(spec);
    }
}