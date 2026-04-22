package nl.adaptivity.xmlutil.core.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntityMap.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/EntityMap;", "", "<init>", "()V", "otherEntities", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "get", "key", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntityMap {
    private final HashMap<String, String> otherEntities = new HashMap<>(8);
    private static final Companion Companion = new Companion(null);
    private static final HashSet<String> BUILTIN_KEYS = SetsKt.hashSetOf("gt", "lt", "amp", "apos", "quot");
    private static final List<String> BUILTIN_VALUES = CollectionsKt.listOf((Object[]) new String[]{">", "<", "&", "'", "\""});

    public final String get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        switch (key.length()) {
            case 2:
                if (Intrinsics.areEqual(key, "gt")) {
                    return ">";
                }
                if (Intrinsics.areEqual(key, "lt")) {
                    return "<";
                }
                break;
            case 3:
                if (Intrinsics.areEqual(key, "amp")) {
                    return "&";
                }
                break;
            case 4:
                if (Intrinsics.areEqual(key, "apos")) {
                    return "'";
                }
                if (Intrinsics.areEqual(key, "quot")) {
                    return "\"";
                }
                break;
        }
        return this.otherEntities.get(key);
    }

    /* compiled from: EntityMap.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/EntityMap$Companion;", "", "<init>", "()V", "BUILTIN_KEYS", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getBUILTIN_KEYS$annotations", "BUILTIN_VALUES", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getBUILTIN_KEYS$annotations() {
        }

        private Companion() {
        }
    }
}