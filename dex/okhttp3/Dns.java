package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: okhttp3.Dns.1
        @Override // okhttp3.Dns
        public Record lookup(String hostname) throws UnknownHostException {
            if (hostname == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return new Record(hostname, Arrays.asList(InetAddress.getAllByName(hostname)), Dns.SYSTEM_PROVIDER);
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };
    public static final String SYSTEM_PROVIDER = "system";

    Record lookup(String str) throws UnknownHostException;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class Record {
        public final List<InetAddress> addresses;
        public final String host;
        public final String provider;

        public Record(String host, List<InetAddress> addresses) {
            this(host, addresses, "");
        }

        public Record(String host, List<InetAddress> addresses, String provider) {
            this.host = host;
            this.addresses = addresses;
            this.provider = provider;
        }
    }
}