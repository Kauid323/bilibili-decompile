package io.ktor.util.debug.plugins;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginsTrace.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, d2 = {"Lio/ktor/util/debug/plugins/PluginTraceElement;", "", "", "pluginName", "handler", "Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "event", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;)Lio/ktor/util/debug/plugins/PluginTraceElement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPluginName", "getHandler", "Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "getEvent", "PluginEvent", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PluginTraceElement {
    private final PluginEvent event;
    private final String handler;
    private final String pluginName;

    public static /* synthetic */ PluginTraceElement copy$default(PluginTraceElement pluginTraceElement, String str, String str2, PluginEvent pluginEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pluginTraceElement.pluginName;
        }
        if ((i & 2) != 0) {
            str2 = pluginTraceElement.handler;
        }
        if ((i & 4) != 0) {
            pluginEvent = pluginTraceElement.event;
        }
        return pluginTraceElement.copy(str, str2, pluginEvent);
    }

    public final String component1() {
        return this.pluginName;
    }

    public final String component2() {
        return this.handler;
    }

    public final PluginEvent component3() {
        return this.event;
    }

    public final PluginTraceElement copy(String str, String str2, PluginEvent pluginEvent) {
        Intrinsics.checkNotNullParameter(str, "pluginName");
        Intrinsics.checkNotNullParameter(str2, "handler");
        Intrinsics.checkNotNullParameter(pluginEvent, "event");
        return new PluginTraceElement(str, str2, pluginEvent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginTraceElement) {
            PluginTraceElement pluginTraceElement = (PluginTraceElement) obj;
            return Intrinsics.areEqual(this.pluginName, pluginTraceElement.pluginName) && Intrinsics.areEqual(this.handler, pluginTraceElement.handler) && this.event == pluginTraceElement.event;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pluginName.hashCode() * 31) + this.handler.hashCode()) * 31) + this.event.hashCode();
    }

    public String toString() {
        return "PluginTraceElement(pluginName=" + this.pluginName + ", handler=" + this.handler + ", event=" + this.event + ')';
    }

    public PluginTraceElement(String pluginName, String handler, PluginEvent event) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(event, "event");
        this.pluginName = pluginName;
        this.handler = handler;
        this.event = event;
    }

    public final PluginEvent getEvent() {
        return this.event;
    }

    public final String getHandler() {
        return this.handler;
    }

    public final String getPluginName() {
        return this.pluginName;
    }

    /* compiled from: PluginsTrace.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "FINISHED", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public enum PluginEvent {
        STARTED,
        FINISHED;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<PluginEvent> getEntries() {
            return $ENTRIES;
        }
    }
}