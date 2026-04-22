package io.ktor.util.debug.plugins;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginName.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0016"}, d2 = {"Lio/ktor/util/debug/plugins/PluginName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "", "pluginName", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Lio/ktor/util/debug/plugins/PluginName;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getPluginName", "Key", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PluginName extends AbstractCoroutineContextElement {
    public static final Key Key = new Key(null);
    private final String pluginName;

    public static /* synthetic */ PluginName copy$default(PluginName pluginName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pluginName.pluginName;
        }
        return pluginName.copy(str);
    }

    public final String component1() {
        return this.pluginName;
    }

    public final PluginName copy(String str) {
        Intrinsics.checkNotNullParameter(str, "pluginName");
        return new PluginName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PluginName) && Intrinsics.areEqual(this.pluginName, ((PluginName) obj).pluginName);
    }

    public int hashCode() {
        return this.pluginName.hashCode();
    }

    public final String getPluginName() {
        return this.pluginName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginName(String pluginName) {
        super(Key);
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        this.pluginName = pluginName;
    }

    /* compiled from: PluginName.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/util/debug/plugins/PluginName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lio/ktor/util/debug/plugins/PluginName;", "<init>", "()V", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static final class Key implements CoroutineContext.Key<PluginName> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public String toString() {
        return "PluginName(" + this.pluginName + ')';
    }
}