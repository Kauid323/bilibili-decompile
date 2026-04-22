package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.tencent.open.SocialConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class InternalChannelz {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger log = Logger.getLogger(InternalChannelz.class.getName());
    private static final InternalChannelz INSTANCE = new InternalChannelz();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ServerStats>> servers = new ConcurrentSkipListMap();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ChannelStats>> rootChannels = new ConcurrentSkipListMap();
    private final ConcurrentMap<Long, InternalInstrumented<ChannelStats>> subchannels = new ConcurrentHashMap();
    private final ConcurrentMap<Long, InternalInstrumented<SocketStats>> otherSockets = new ConcurrentHashMap();
    private final ConcurrentMap<Long, ServerSocketMap> perServerSockets = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ServerSocketMap extends ConcurrentSkipListMap<Long, InternalInstrumented<SocketStats>> {
        private static final long serialVersionUID = -7883772124944661414L;

        private ServerSocketMap() {
        }
    }

    public static InternalChannelz instance() {
        return INSTANCE;
    }

    public void addServer(InternalInstrumented<ServerStats> server) {
        ServerSocketMap prev = this.perServerSockets.put(Long.valueOf(id(server)), new ServerSocketMap());
        if (prev != null) {
            throw new AssertionError();
        }
        add(this.servers, server);
    }

    public void addSubchannel(InternalInstrumented<ChannelStats> subchannel) {
        add(this.subchannels, subchannel);
    }

    public void addRootChannel(InternalInstrumented<ChannelStats> rootChannel) {
        add(this.rootChannels, rootChannel);
    }

    public void addClientSocket(InternalInstrumented<SocketStats> socket) {
        add(this.otherSockets, socket);
    }

    public void addListenSocket(InternalInstrumented<SocketStats> socket) {
        add(this.otherSockets, socket);
    }

    public void addServerSocket(InternalInstrumented<ServerStats> server, InternalInstrumented<SocketStats> socket) {
        ServerSocketMap serverSockets = this.perServerSockets.get(Long.valueOf(id(server)));
        if (serverSockets == null) {
            throw new AssertionError();
        }
        add(serverSockets, socket);
    }

    public void removeServer(InternalInstrumented<ServerStats> server) {
        remove(this.servers, server);
        ServerSocketMap prev = this.perServerSockets.remove(Long.valueOf(id(server)));
        if (prev == null) {
            throw new AssertionError();
        }
        if (!prev.isEmpty()) {
            throw new AssertionError();
        }
    }

    public void removeSubchannel(InternalInstrumented<ChannelStats> subchannel) {
        remove(this.subchannels, subchannel);
    }

    public void removeRootChannel(InternalInstrumented<ChannelStats> channel) {
        remove(this.rootChannels, channel);
    }

    public void removeClientSocket(InternalInstrumented<SocketStats> socket) {
        remove(this.otherSockets, socket);
    }

    public void removeListenSocket(InternalInstrumented<SocketStats> socket) {
        remove(this.otherSockets, socket);
    }

    public void removeServerSocket(InternalInstrumented<ServerStats> server, InternalInstrumented<SocketStats> socket) {
        ServerSocketMap socketsOfServer = this.perServerSockets.get(Long.valueOf(id(server)));
        if (socketsOfServer == null) {
            throw new AssertionError();
        }
        remove(socketsOfServer, socket);
    }

    public RootChannelList getRootChannels(long fromId, int maxPageSize) {
        ArrayList arrayList = new ArrayList();
        Iterator<InternalInstrumented<ChannelStats>> iterator = this.rootChannels.tailMap((ConcurrentNavigableMap<Long, InternalInstrumented<ChannelStats>>) Long.valueOf(fromId)).values().iterator();
        while (iterator.hasNext() && arrayList.size() < maxPageSize) {
            arrayList.add(iterator.next());
        }
        return new RootChannelList(arrayList, !iterator.hasNext());
    }

    @Nullable
    public InternalInstrumented<ChannelStats> getChannel(long id) {
        return (InternalInstrumented) this.rootChannels.get(Long.valueOf(id));
    }

    @Nullable
    public InternalInstrumented<ChannelStats> getSubchannel(long id) {
        return this.subchannels.get(Long.valueOf(id));
    }

    public ServerList getServers(long fromId, int maxPageSize) {
        ArrayList arrayList = new ArrayList(maxPageSize);
        Iterator<InternalInstrumented<ServerStats>> iterator = this.servers.tailMap((ConcurrentNavigableMap<Long, InternalInstrumented<ServerStats>>) Long.valueOf(fromId)).values().iterator();
        while (iterator.hasNext() && arrayList.size() < maxPageSize) {
            arrayList.add(iterator.next());
        }
        return new ServerList(arrayList, !iterator.hasNext());
    }

    @Nullable
    public InternalInstrumented<ServerStats> getServer(long id) {
        return (InternalInstrumented) this.servers.get(Long.valueOf(id));
    }

    @Nullable
    public ServerSocketsList getServerSockets(long serverId, long fromId, int maxPageSize) {
        ServerSocketMap serverSockets = this.perServerSockets.get(Long.valueOf(serverId));
        if (serverSockets == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(maxPageSize);
        Iterator<InternalInstrumented<SocketStats>> iterator = serverSockets.tailMap((ServerSocketMap) Long.valueOf(fromId)).values().iterator();
        while (arrayList.size() < maxPageSize && iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return new ServerSocketsList(arrayList, !iterator.hasNext());
    }

    @Nullable
    public InternalInstrumented<SocketStats> getSocket(long id) {
        InternalInstrumented<SocketStats> clientSocket = this.otherSockets.get(Long.valueOf(id));
        if (clientSocket != null) {
            return clientSocket;
        }
        return getServerSocket(id);
    }

    private InternalInstrumented<SocketStats> getServerSocket(long id) {
        for (ServerSocketMap perServerSockets : this.perServerSockets.values()) {
            InternalInstrumented<SocketStats> serverSocket = perServerSockets.get(Long.valueOf(id));
            if (serverSocket != null) {
                return serverSocket;
            }
        }
        return null;
    }

    public boolean containsServer(InternalLogId serverRef) {
        return contains(this.servers, serverRef);
    }

    public boolean containsSubchannel(InternalLogId subchannelRef) {
        return contains(this.subchannels, subchannelRef);
    }

    public InternalInstrumented<ChannelStats> getRootChannel(long id) {
        return (InternalInstrumented) this.rootChannels.get(Long.valueOf(id));
    }

    public boolean containsClientSocket(InternalLogId transportRef) {
        return contains(this.otherSockets, transportRef);
    }

    private static <T extends InternalInstrumented<?>> void add(Map<Long, T> map, T object) {
        T prev = map.put(Long.valueOf(object.getLogId().getId()), object);
        if (prev != null) {
            throw new AssertionError();
        }
    }

    private static <T extends InternalInstrumented<?>> void remove(Map<Long, T> map, T object) {
        T prev = map.remove(Long.valueOf(id(object)));
        if (prev == null) {
            throw new AssertionError();
        }
    }

    private static <T extends InternalInstrumented<?>> boolean contains(Map<Long, T> map, InternalLogId id) {
        return map.containsKey(Long.valueOf(id.getId()));
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class RootChannelList {
        public final List<InternalInstrumented<ChannelStats>> channels;
        public final boolean end;

        public RootChannelList(List<InternalInstrumented<ChannelStats>> channels, boolean end) {
            this.channels = (List) Preconditions.checkNotNull(channels);
            this.end = end;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ServerList {
        public final boolean end;
        public final List<InternalInstrumented<ServerStats>> servers;

        public ServerList(List<InternalInstrumented<ServerStats>> servers, boolean end) {
            this.servers = (List) Preconditions.checkNotNull(servers);
            this.end = end;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ServerSocketsList {
        public final boolean end;
        public final List<InternalWithLogId> sockets;

        public ServerSocketsList(List<InternalWithLogId> sockets, boolean end) {
            this.sockets = sockets;
            this.end = end;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ServerStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        public final long lastCallStartedNanos;
        public final List<InternalInstrumented<SocketStats>> listenSockets;

        public ServerStats(long callsStarted, long callsSucceeded, long callsFailed, long lastCallStartedNanos, List<InternalInstrumented<SocketStats>> listenSockets) {
            this.callsStarted = callsStarted;
            this.callsSucceeded = callsSucceeded;
            this.callsFailed = callsFailed;
            this.lastCallStartedNanos = lastCallStartedNanos;
            this.listenSockets = (List) Preconditions.checkNotNull(listenSockets);
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private long lastCallStartedNanos;
            public List<InternalInstrumented<SocketStats>> listenSockets = new ArrayList();

            public Builder setCallsStarted(long callsStarted) {
                this.callsStarted = callsStarted;
                return this;
            }

            public Builder setCallsSucceeded(long callsSucceeded) {
                this.callsSucceeded = callsSucceeded;
                return this;
            }

            public Builder setCallsFailed(long callsFailed) {
                this.callsFailed = callsFailed;
                return this;
            }

            public Builder setLastCallStartedNanos(long lastCallStartedNanos) {
                this.lastCallStartedNanos = lastCallStartedNanos;
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder addListenSockets(List<InternalInstrumented<SocketStats>> listenSockets) {
                Preconditions.checkNotNull(listenSockets, "listenSockets");
                for (InternalInstrumented<SocketStats> ss : listenSockets) {
                    this.listenSockets.add(Preconditions.checkNotNull(ss, "null listen socket"));
                }
                return this;
            }

            public ServerStats build() {
                return new ServerStats(this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.listenSockets);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ChannelStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        @Nullable
        public final ChannelTrace channelTrace;
        public final long lastCallStartedNanos;
        public final List<InternalWithLogId> sockets;
        public final ConnectivityState state;
        public final List<InternalWithLogId> subchannels;
        public final String target;

        private ChannelStats(String target, ConnectivityState state, @Nullable ChannelTrace channelTrace, long callsStarted, long callsSucceeded, long callsFailed, long lastCallStartedNanos, List<InternalWithLogId> subchannels, List<InternalWithLogId> sockets) {
            Preconditions.checkState(subchannels.isEmpty() || sockets.isEmpty(), "channels can have subchannels only, subchannels can have either sockets OR subchannels, neither can have both");
            this.target = target;
            this.state = state;
            this.channelTrace = channelTrace;
            this.callsStarted = callsStarted;
            this.callsSucceeded = callsSucceeded;
            this.callsFailed = callsFailed;
            this.lastCallStartedNanos = lastCallStartedNanos;
            this.subchannels = (List) Preconditions.checkNotNull(subchannels);
            this.sockets = (List) Preconditions.checkNotNull(sockets);
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private ChannelTrace channelTrace;
            private long lastCallStartedNanos;
            private ConnectivityState state;
            private String target;
            private List<InternalWithLogId> subchannels = Collections.emptyList();
            private List<InternalWithLogId> sockets = Collections.emptyList();

            public Builder setTarget(String target) {
                this.target = target;
                return this;
            }

            public Builder setState(ConnectivityState state) {
                this.state = state;
                return this;
            }

            public Builder setChannelTrace(ChannelTrace channelTrace) {
                this.channelTrace = channelTrace;
                return this;
            }

            public Builder setCallsStarted(long callsStarted) {
                this.callsStarted = callsStarted;
                return this;
            }

            public Builder setCallsSucceeded(long callsSucceeded) {
                this.callsSucceeded = callsSucceeded;
                return this;
            }

            public Builder setCallsFailed(long callsFailed) {
                this.callsFailed = callsFailed;
                return this;
            }

            public Builder setLastCallStartedNanos(long lastCallStartedNanos) {
                this.lastCallStartedNanos = lastCallStartedNanos;
                return this;
            }

            public Builder setSubchannels(List<InternalWithLogId> subchannels) {
                Preconditions.checkState(this.sockets.isEmpty());
                this.subchannels = Collections.unmodifiableList((List) Preconditions.checkNotNull(subchannels));
                return this;
            }

            public Builder setSockets(List<InternalWithLogId> sockets) {
                Preconditions.checkState(this.subchannels.isEmpty());
                this.sockets = Collections.unmodifiableList((List) Preconditions.checkNotNull(sockets));
                return this;
            }

            public ChannelStats build() {
                return new ChannelStats(this.target, this.state, this.channelTrace, this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.subchannels, this.sockets);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ChannelTrace {
        public final long creationTimeNanos;
        public final List<Event> events;
        public final long numEventsLogged;

        private ChannelTrace(long numEventsLogged, long creationTimeNanos, List<Event> events) {
            this.numEventsLogged = numEventsLogged;
            this.creationTimeNanos = creationTimeNanos;
            this.events = events;
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private Long creationTimeNanos;
            private List<Event> events = Collections.emptyList();
            private Long numEventsLogged;

            public Builder setNumEventsLogged(long numEventsLogged) {
                this.numEventsLogged = Long.valueOf(numEventsLogged);
                return this;
            }

            public Builder setCreationTimeNanos(long creationTimeNanos) {
                this.creationTimeNanos = Long.valueOf(creationTimeNanos);
                return this;
            }

            public Builder setEvents(List<Event> events) {
                this.events = Collections.unmodifiableList(new ArrayList(events));
                return this;
            }

            public ChannelTrace build() {
                Preconditions.checkNotNull(this.numEventsLogged, "numEventsLogged");
                Preconditions.checkNotNull(this.creationTimeNanos, "creationTimeNanos");
                return new ChannelTrace(this.numEventsLogged.longValue(), this.creationTimeNanos.longValue(), this.events);
            }
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Event {
            @Nullable
            public final InternalWithLogId channelRef;
            public final String description;
            public final Severity severity;
            @Nullable
            public final InternalWithLogId subchannelRef;
            public final long timestampNanos;

            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public enum Severity {
                CT_UNKNOWN,
                CT_INFO,
                CT_WARNING,
                CT_ERROR
            }

            private Event(String description, Severity severity, long timestampNanos, @Nullable InternalWithLogId channelRef, @Nullable InternalWithLogId subchannelRef) {
                this.description = description;
                this.severity = (Severity) Preconditions.checkNotNull(severity, "severity");
                this.timestampNanos = timestampNanos;
                this.channelRef = channelRef;
                this.subchannelRef = subchannelRef;
            }

            public int hashCode() {
                return Objects.hashCode(new Object[]{this.description, this.severity, Long.valueOf(this.timestampNanos), this.channelRef, this.subchannelRef});
            }

            public boolean equals(Object o) {
                if (o instanceof Event) {
                    Event that = (Event) o;
                    return Objects.equal(this.description, that.description) && Objects.equal(this.severity, that.severity) && this.timestampNanos == that.timestampNanos && Objects.equal(this.channelRef, that.channelRef) && Objects.equal(this.subchannelRef, that.subchannelRef);
                }
                return false;
            }

            public String toString() {
                return MoreObjects.toStringHelper(this).add(SocialConstants.PARAM_COMMENT, this.description).add("severity", this.severity).add("timestampNanos", this.timestampNanos).add("channelRef", this.channelRef).add("subchannelRef", this.subchannelRef).toString();
            }

            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class Builder {
                private InternalWithLogId channelRef;
                private String description;
                private Severity severity;
                private InternalWithLogId subchannelRef;
                private Long timestampNanos;

                public Builder setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public Builder setTimestampNanos(long timestampNanos) {
                    this.timestampNanos = Long.valueOf(timestampNanos);
                    return this;
                }

                public Builder setSeverity(Severity severity) {
                    this.severity = severity;
                    return this;
                }

                public Builder setChannelRef(InternalWithLogId channelRef) {
                    this.channelRef = channelRef;
                    return this;
                }

                public Builder setSubchannelRef(InternalWithLogId subchannelRef) {
                    this.subchannelRef = subchannelRef;
                    return this;
                }

                public Event build() {
                    Preconditions.checkNotNull(this.description, SocialConstants.PARAM_COMMENT);
                    Preconditions.checkNotNull(this.severity, "severity");
                    Preconditions.checkNotNull(this.timestampNanos, "timestampNanos");
                    Preconditions.checkState(this.channelRef == null || this.subchannelRef == null, "at least one of channelRef and subchannelRef must be null");
                    return new Event(this.description, this.severity, this.timestampNanos.longValue(), this.channelRef, this.subchannelRef);
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Security {
        @Nullable
        public final OtherSecurity other;
        @Nullable
        public final Tls tls;

        public Security(Tls tls) {
            this.tls = (Tls) Preconditions.checkNotNull(tls);
            this.other = null;
        }

        public Security(OtherSecurity other) {
            this.tls = null;
            this.other = (OtherSecurity) Preconditions.checkNotNull(other);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class OtherSecurity {
        @Nullable
        public final Object any;
        public final String name;

        public OtherSecurity(String name, @Nullable Object any) {
            this.name = (String) Preconditions.checkNotNull(name);
            Preconditions.checkState(any == null || any.getClass().getName().endsWith("com.google.protobuf.Any"), "the 'any' object must be of type com.google.protobuf.Any");
            this.any = any;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Tls {
        public final String cipherSuiteStandardName;
        @Nullable
        public final Certificate localCert;
        @Nullable
        public final Certificate remoteCert;

        public Tls(String cipherSuiteName, Certificate localCert, Certificate remoteCert) {
            this.cipherSuiteStandardName = cipherSuiteName;
            this.localCert = localCert;
            this.remoteCert = remoteCert;
        }

        public Tls(SSLSession session) {
            String cipherSuiteStandardName = session.getCipherSuite();
            Certificate remoteCert = null;
            Certificate[] localCerts = session.getLocalCertificates();
            Certificate localCert = localCerts != null ? localCerts[0] : null;
            try {
                Certificate[] peerCerts = session.getPeerCertificates();
                if (peerCerts != null) {
                    remoteCert = peerCerts[0];
                }
            } catch (SSLPeerUnverifiedException e2) {
                InternalChannelz.log.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", session.getPeerHost()), (Throwable) e2);
            }
            this.cipherSuiteStandardName = cipherSuiteStandardName;
            this.localCert = localCert;
            this.remoteCert = remoteCert;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SocketStats {
        @Nullable
        public final TransportStats data;
        @Nullable
        public final SocketAddress local;
        @Nullable
        public final SocketAddress remote;
        @Nullable
        public final Security security;
        public final SocketOptions socketOptions;

        public SocketStats(TransportStats data, @Nullable SocketAddress local, @Nullable SocketAddress remote, SocketOptions socketOptions, Security security) {
            this.data = data;
            this.local = (SocketAddress) Preconditions.checkNotNull(local, "local socket");
            this.remote = remote;
            this.socketOptions = (SocketOptions) Preconditions.checkNotNull(socketOptions);
            this.security = security;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class TcpInfo {
        public final int advmss;
        public final int ato;
        public final int backoff;
        public final int caState;
        public final int fackets;
        public final int lastAckRecv;
        public final int lastAckSent;
        public final int lastDataRecv;
        public final int lastDataSent;
        public final int lost;
        public final int options;
        public final int pmtu;
        public final int probes;
        public final int rcvMss;
        public final int rcvSsthresh;
        public final int rcvWscale;
        public final int reordering;
        public final int retrans;
        public final int retransmits;
        public final int rto;
        public final int rtt;
        public final int rttvar;
        public final int sacked;
        public final int sndCwnd;
        public final int sndMss;
        public final int sndSsthresh;
        public final int sndWscale;
        public final int state;
        public final int unacked;

        TcpInfo(int state, int caState, int retransmits, int probes, int backoff, int options, int sndWscale, int rcvWscale, int rto, int ato, int sndMss, int rcvMss, int unacked, int sacked, int lost, int retrans, int fackets, int lastDataSent, int lastAckSent, int lastDataRecv, int lastAckRecv, int pmtu, int rcvSsthresh, int rtt, int rttvar, int sndSsthresh, int sndCwnd, int advmss, int reordering) {
            this.state = state;
            this.caState = caState;
            this.retransmits = retransmits;
            this.probes = probes;
            this.backoff = backoff;
            this.options = options;
            this.sndWscale = sndWscale;
            this.rcvWscale = rcvWscale;
            this.rto = rto;
            this.ato = ato;
            this.sndMss = sndMss;
            this.rcvMss = rcvMss;
            this.unacked = unacked;
            this.sacked = sacked;
            this.lost = lost;
            this.retrans = retrans;
            this.fackets = fackets;
            this.lastDataSent = lastDataSent;
            this.lastAckSent = lastAckSent;
            this.lastDataRecv = lastDataRecv;
            this.lastAckRecv = lastAckRecv;
            this.pmtu = pmtu;
            this.rcvSsthresh = rcvSsthresh;
            this.rtt = rtt;
            this.rttvar = rttvar;
            this.sndSsthresh = sndSsthresh;
            this.sndCwnd = sndCwnd;
            this.advmss = advmss;
            this.reordering = reordering;
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private int advmss;
            private int ato;
            private int backoff;
            private int caState;
            private int fackets;
            private int lastAckRecv;
            private int lastAckSent;
            private int lastDataRecv;
            private int lastDataSent;
            private int lost;
            private int options;
            private int pmtu;
            private int probes;
            private int rcvMss;
            private int rcvSsthresh;
            private int rcvWscale;
            private int reordering;
            private int retrans;
            private int retransmits;
            private int rto;
            private int rtt;
            private int rttvar;
            private int sacked;
            private int sndCwnd;
            private int sndMss;
            private int sndSsthresh;
            private int sndWscale;
            private int state;
            private int unacked;

            public Builder setState(int state) {
                this.state = state;
                return this;
            }

            public Builder setCaState(int caState) {
                this.caState = caState;
                return this;
            }

            public Builder setRetransmits(int retransmits) {
                this.retransmits = retransmits;
                return this;
            }

            public Builder setProbes(int probes) {
                this.probes = probes;
                return this;
            }

            public Builder setBackoff(int backoff) {
                this.backoff = backoff;
                return this;
            }

            public Builder setOptions(int options) {
                this.options = options;
                return this;
            }

            public Builder setSndWscale(int sndWscale) {
                this.sndWscale = sndWscale;
                return this;
            }

            public Builder setRcvWscale(int rcvWscale) {
                this.rcvWscale = rcvWscale;
                return this;
            }

            public Builder setRto(int rto) {
                this.rto = rto;
                return this;
            }

            public Builder setAto(int ato) {
                this.ato = ato;
                return this;
            }

            public Builder setSndMss(int sndMss) {
                this.sndMss = sndMss;
                return this;
            }

            public Builder setRcvMss(int rcvMss) {
                this.rcvMss = rcvMss;
                return this;
            }

            public Builder setUnacked(int unacked) {
                this.unacked = unacked;
                return this;
            }

            public Builder setSacked(int sacked) {
                this.sacked = sacked;
                return this;
            }

            public Builder setLost(int lost) {
                this.lost = lost;
                return this;
            }

            public Builder setRetrans(int retrans) {
                this.retrans = retrans;
                return this;
            }

            public Builder setFackets(int fackets) {
                this.fackets = fackets;
                return this;
            }

            public Builder setLastDataSent(int lastDataSent) {
                this.lastDataSent = lastDataSent;
                return this;
            }

            public Builder setLastAckSent(int lastAckSent) {
                this.lastAckSent = lastAckSent;
                return this;
            }

            public Builder setLastDataRecv(int lastDataRecv) {
                this.lastDataRecv = lastDataRecv;
                return this;
            }

            public Builder setLastAckRecv(int lastAckRecv) {
                this.lastAckRecv = lastAckRecv;
                return this;
            }

            public Builder setPmtu(int pmtu) {
                this.pmtu = pmtu;
                return this;
            }

            public Builder setRcvSsthresh(int rcvSsthresh) {
                this.rcvSsthresh = rcvSsthresh;
                return this;
            }

            public Builder setRtt(int rtt) {
                this.rtt = rtt;
                return this;
            }

            public Builder setRttvar(int rttvar) {
                this.rttvar = rttvar;
                return this;
            }

            public Builder setSndSsthresh(int sndSsthresh) {
                this.sndSsthresh = sndSsthresh;
                return this;
            }

            public Builder setSndCwnd(int sndCwnd) {
                this.sndCwnd = sndCwnd;
                return this;
            }

            public Builder setAdvmss(int advmss) {
                this.advmss = advmss;
                return this;
            }

            public Builder setReordering(int reordering) {
                this.reordering = reordering;
                return this;
            }

            public TcpInfo build() {
                return new TcpInfo(this.state, this.caState, this.retransmits, this.probes, this.backoff, this.options, this.sndWscale, this.rcvWscale, this.rto, this.ato, this.sndMss, this.rcvMss, this.unacked, this.sacked, this.lost, this.retrans, this.fackets, this.lastDataSent, this.lastAckSent, this.lastDataRecv, this.lastAckRecv, this.pmtu, this.rcvSsthresh, this.rtt, this.rttvar, this.sndSsthresh, this.sndCwnd, this.advmss, this.reordering);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SocketOptions {
        @Nullable
        public final Integer lingerSeconds;
        public final Map<String, String> others;
        @Nullable
        public final Integer soTimeoutMillis;
        @Nullable
        public final TcpInfo tcpInfo;

        public SocketOptions(@Nullable Integer timeoutMillis, @Nullable Integer lingerSeconds, @Nullable TcpInfo tcpInfo, Map<String, String> others) {
            Preconditions.checkNotNull(others);
            this.soTimeoutMillis = timeoutMillis;
            this.lingerSeconds = lingerSeconds;
            this.tcpInfo = tcpInfo;
            this.others = Collections.unmodifiableMap(new HashMap(others));
        }

        /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
        public static final class Builder {
            private Integer lingerSeconds;
            private final Map<String, String> others = new HashMap();
            private TcpInfo tcpInfo;
            private Integer timeoutMillis;

            public Builder setSocketOptionTimeoutMillis(Integer timeoutMillis) {
                this.timeoutMillis = timeoutMillis;
                return this;
            }

            public Builder setSocketOptionLingerSeconds(Integer lingerSeconds) {
                this.lingerSeconds = lingerSeconds;
                return this;
            }

            public Builder setTcpInfo(TcpInfo tcpInfo) {
                this.tcpInfo = tcpInfo;
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder addOption(String name, String value) {
                this.others.put(name, Preconditions.checkNotNull(value));
                return this;
            }

            public Builder addOption(String name, int value) {
                this.others.put(name, Integer.toString(value));
                return this;
            }

            public Builder addOption(String name, boolean value) {
                this.others.put(name, Boolean.toString(value));
                return this;
            }

            public SocketOptions build() {
                return new SocketOptions(this.timeoutMillis, this.lingerSeconds, this.tcpInfo, this.others);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class TransportStats {
        public final long keepAlivesSent;
        public final long lastLocalStreamCreatedTimeNanos;
        public final long lastMessageReceivedTimeNanos;
        public final long lastMessageSentTimeNanos;
        public final long lastRemoteStreamCreatedTimeNanos;
        public final long localFlowControlWindow;
        public final long messagesReceived;
        public final long messagesSent;
        public final long remoteFlowControlWindow;
        public final long streamsFailed;
        public final long streamsStarted;
        public final long streamsSucceeded;

        public TransportStats(long streamsStarted, long lastLocalStreamCreatedTimeNanos, long lastRemoteStreamCreatedTimeNanos, long streamsSucceeded, long streamsFailed, long messagesSent, long messagesReceived, long keepAlivesSent, long lastMessageSentTimeNanos, long lastMessageReceivedTimeNanos, long localFlowControlWindow, long remoteFlowControlWindow) {
            this.streamsStarted = streamsStarted;
            this.lastLocalStreamCreatedTimeNanos = lastLocalStreamCreatedTimeNanos;
            this.lastRemoteStreamCreatedTimeNanos = lastRemoteStreamCreatedTimeNanos;
            this.streamsSucceeded = streamsSucceeded;
            this.streamsFailed = streamsFailed;
            this.messagesSent = messagesSent;
            this.messagesReceived = messagesReceived;
            this.keepAlivesSent = keepAlivesSent;
            this.lastMessageSentTimeNanos = lastMessageSentTimeNanos;
            this.lastMessageReceivedTimeNanos = lastMessageReceivedTimeNanos;
            this.localFlowControlWindow = localFlowControlWindow;
            this.remoteFlowControlWindow = remoteFlowControlWindow;
        }
    }

    public static long id(InternalWithLogId withLogId) {
        return withLogId.getLogId().getId();
    }
}