package io.ktor.client.engine;

import java.net.Proxy;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProxyConfigJvm.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0006*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b*\n\u0010\n\"\u00020\u00002\u00020\u0000¨\u0006\u000b"}, d2 = {"Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "resolveAddress", "(Ljava/net/Proxy;)Ljava/net/SocketAddress;", "Lio/ktor/client/engine/ProxyType;", "getType", "(Ljava/net/Proxy;)Lio/ktor/client/engine/ProxyType;", "type", "ProxyConfig", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProxyConfigJvmKt {

    /* compiled from: ProxyConfigJvm.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.SOCKS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SocketAddress resolveAddress(Proxy $this$resolveAddress) {
        Intrinsics.checkNotNullParameter($this$resolveAddress, "<this>");
        SocketAddress address = $this$resolveAddress.address();
        Intrinsics.checkNotNullExpressionValue(address, "address(...)");
        return address;
    }

    public static final ProxyType getType(Proxy $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        Proxy.Type type = $this$type.type();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return ProxyType.SOCKS;
            case 2:
                return ProxyType.HTTP;
            default:
                return ProxyType.UNKNOWN;
        }
    }
}