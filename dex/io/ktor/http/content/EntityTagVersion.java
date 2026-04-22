package io.ktor.http.content;

import BottomSheetItemData$;
import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.ApplicationResponsePropertiesKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Versions.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u000e\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010¢\u0006\u0004\b\u000e\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001dR\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'¨\u0006-"}, d2 = {"Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/http/content/Version;", "", "etag", "", "weak", "<init>", "(Ljava/lang/String;Z)V", "Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/VersionCheckResult;", "check", "(Lio/ktor/http/Headers;)Lio/ktor/http/content/VersionCheckResult;", "other", "match", "(Lio/ktor/http/content/EntityTagVersion;)Z", "", "givenNoneMatchEtags", "noneMatch", "(Ljava/util/List;)Lio/ktor/http/content/VersionCheckResult;", "givenMatchEtags", "Lio/ktor/http/HeadersBuilder;", "builder", "", "appendHeadersTo", "(Lio/ktor/http/HeadersBuilder;)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "copy", "(Ljava/lang/String;Z)Lio/ktor/http/content/EntityTagVersion;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getEtag", "Z", "getWeak", "normalized", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityTagVersion implements Version {
    public static final Companion Companion = new Companion(null);
    private static final EntityTagVersion STAR = new EntityTagVersion("*", false);
    private final String etag;
    private final String normalized;
    private final boolean weak;

    public static /* synthetic */ EntityTagVersion copy$default(EntityTagVersion entityTagVersion, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = entityTagVersion.etag;
        }
        if ((i2 & 2) != 0) {
            z = entityTagVersion.weak;
        }
        return entityTagVersion.copy(str, z);
    }

    public final String component1() {
        return this.etag;
    }

    public final boolean component2() {
        return this.weak;
    }

    public final EntityTagVersion copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "etag");
        return new EntityTagVersion(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EntityTagVersion) {
            EntityTagVersion entityTagVersion = (EntityTagVersion) obj;
            return Intrinsics.areEqual(this.etag, entityTagVersion.etag) && this.weak == entityTagVersion.weak;
        }
        return false;
    }

    public int hashCode() {
        return (this.etag.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.weak);
    }

    public String toString() {
        return "EntityTagVersion(etag=" + this.etag + ", weak=" + this.weak + ')';
    }

    public EntityTagVersion(String etag, boolean weak) {
        String quote;
        Intrinsics.checkNotNullParameter(etag, "etag");
        this.etag = etag;
        this.weak = weak;
        if (Intrinsics.areEqual(this.etag, "*")) {
            quote = this.etag;
        } else {
            quote = StringsKt.startsWith$default(this.etag, "\"", false, 2, (Object) null) ? this.etag : HeaderValueWithParametersKt.quote(this.etag);
        }
        this.normalized = quote;
        int index = 0;
        int length = this.etag.length();
        while (index < length) {
            char ch = this.etag.charAt(index);
            if (Intrinsics.compare(ch, 32) <= 0 || ch == '\"') {
                if (!(index == 0 || index == StringsKt.getLastIndex(this.etag))) {
                    throw new IllegalArgumentException(("Character '" + ch + "' is not allowed in entity-tag.").toString());
                }
            }
            index++;
        }
    }

    public final String getEtag() {
        return this.etag;
    }

    public final boolean getWeak() {
        return this.weak;
    }

    @Override // io.ktor.http.content.Version
    public VersionCheckResult check(Headers requestHeaders) {
        List givenMatchEtags;
        VersionCheckResult result;
        List givenNoneMatchEtags;
        VersionCheckResult result2;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        String it = requestHeaders.get(HttpHeaders.INSTANCE.getIfNoneMatch());
        if (it == null || (givenNoneMatchEtags = Companion.parse(it)) == null || (result2 = noneMatch(givenNoneMatchEtags)) == VersionCheckResult.OK) {
            String it2 = requestHeaders.get(HttpHeaders.INSTANCE.getIfMatch());
            return (it2 == null || (givenMatchEtags = Companion.parse(it2)) == null || (result = match(givenMatchEtags)) == VersionCheckResult.OK) ? VersionCheckResult.OK : result;
        }
        return result2;
    }

    public final boolean match(EntityTagVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(this, STAR) || Intrinsics.areEqual(other, STAR)) {
            return true;
        }
        return Intrinsics.areEqual(this.normalized, other.normalized);
    }

    public final VersionCheckResult noneMatch(List<EntityTagVersion> list) {
        Intrinsics.checkNotNullParameter(list, "givenNoneMatchEtags");
        if (list.contains(STAR)) {
            return VersionCheckResult.OK;
        }
        List<EntityTagVersion> $this$any$iv = list;
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                EntityTagVersion it2 = (EntityTagVersion) element$iv;
                if (match(it2)) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return VersionCheckResult.NOT_MODIFIED;
        }
        return VersionCheckResult.OK;
    }

    public final VersionCheckResult match(List<EntityTagVersion> list) {
        Intrinsics.checkNotNullParameter(list, "givenMatchEtags");
        if (!list.isEmpty() && !list.contains(STAR)) {
            for (EntityTagVersion given : list) {
                if (match(given)) {
                    return VersionCheckResult.OK;
                }
            }
            return VersionCheckResult.PRECONDITION_FAILED;
        }
        return VersionCheckResult.OK;
    }

    @Override // io.ktor.http.content.Version
    public void appendHeadersTo(HeadersBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ApplicationResponsePropertiesKt.etag(builder, this.normalized);
    }

    /* compiled from: Versions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/content/EntityTagVersion$Companion;", "", "<init>", "()V", "", "headerValue", "", "Lio/ktor/http/content/EntityTagVersion;", "parse", "(Ljava/lang/String;)Ljava/util/List;", "value", "parseSingle", "(Ljava/lang/String;)Lio/ktor/http/content/EntityTagVersion;", "STAR", "Lio/ktor/http/content/EntityTagVersion;", "getSTAR", "()Lio/ktor/http/content/EntityTagVersion;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EntityTagVersion getSTAR() {
            return EntityTagVersion.STAR;
        }

        public final List<EntityTagVersion> parse(String headerValue) {
            Intrinsics.checkNotNullParameter(headerValue, "headerValue");
            Iterable rawEntries = HttpHeaderValueParserKt.parseHeaderValue(headerValue);
            Iterable $this$map$iv = rawEntries;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                HeaderValue entry = (HeaderValue) item$iv$iv;
                if (!(entry.getQuality() == 1.0d)) {
                    throw new IllegalStateException(("entity-tag quality parameter is not allowed: " + entry.getQuality() + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
                }
                if (!entry.getParams().isEmpty()) {
                    throw new IllegalStateException(("entity-tag parameters are not allowed: " + entry.getParams() + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
                }
                destination$iv$iv.add(EntityTagVersion.Companion.parseSingle(entry.getValue()));
            }
            return (List) destination$iv$iv;
        }

        public final EntityTagVersion parseSingle(String value) {
            boolean weak;
            String rawEtag;
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "*")) {
                return getSTAR();
            }
            if (StringsKt.startsWith$default(value, "W/", false, 2, (Object) null)) {
                weak = true;
                rawEtag = StringsKt.drop(value, 2);
            } else {
                weak = false;
                rawEtag = value;
            }
            String etag = StringsKt.startsWith$default(rawEtag, "\"", false, 2, (Object) null) ? rawEtag : HeaderValueWithParametersKt.quote(rawEtag);
            return new EntityTagVersion(etag, weak);
        }
    }
}