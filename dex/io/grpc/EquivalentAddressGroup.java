package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EquivalentAddressGroup {
    public static final Attributes.Key<String> ATTR_AUTHORITY_OVERRIDE = Attributes.Key.create("io.grpc.EquivalentAddressGroup.authorityOverride");
    private final List<SocketAddress> addrs;
    private final Attributes attrs;
    private final int hashCode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public @interface Attr {
    }

    public EquivalentAddressGroup(List<SocketAddress> addrs) {
        this(addrs, Attributes.EMPTY);
    }

    public EquivalentAddressGroup(List<SocketAddress> addrs, Attributes attrs) {
        Preconditions.checkArgument(!addrs.isEmpty(), "addrs is empty");
        this.addrs = Collections.unmodifiableList(new ArrayList(addrs));
        this.attrs = (Attributes) Preconditions.checkNotNull(attrs, "attrs");
        this.hashCode = this.addrs.hashCode();
    }

    public EquivalentAddressGroup(SocketAddress addr) {
        this(addr, Attributes.EMPTY);
    }

    public EquivalentAddressGroup(SocketAddress addr, Attributes attrs) {
        this(Collections.singletonList(addr), attrs);
    }

    public List<SocketAddress> getAddresses() {
        return this.addrs;
    }

    public Attributes getAttributes() {
        return this.attrs;
    }

    public String toString() {
        return "[" + this.addrs + "/" + this.attrs + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object other) {
        if (other instanceof EquivalentAddressGroup) {
            EquivalentAddressGroup that = (EquivalentAddressGroup) other;
            if (this.addrs.size() != that.addrs.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.addrs.size(); i2++) {
                if (!this.addrs.get(i2).equals(that.addrs.get(i2))) {
                    return false;
                }
            }
            return this.attrs.equals(that.attrs);
        }
        return false;
    }
}