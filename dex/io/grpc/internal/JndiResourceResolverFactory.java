package io.grpc.internal;

import com.google.common.base.Verify;
import io.grpc.internal.DnsNameResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: Access modifiers changed from: package-private */
public final class JndiResourceResolverFactory implements DnsNameResolver.ResourceResolverFactory {
    @Nullable
    private static final Throwable JNDI_UNAVAILABILITY_CAUSE = initJndi();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    interface RecordFetcher {
        List<String> getAllRecords(String str, String str2) throws NamingException;
    }

    @Nullable
    private static Throwable initJndi() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e2) {
            return e2;
        } catch (Error e3) {
            return e3;
        } catch (RuntimeException e4) {
            return e4;
        }
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    @Nullable
    public DnsNameResolver.ResourceResolver newResourceResolver() {
        if (unavailabilityCause() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    @Nullable
    public Throwable unavailabilityCause() {
        return JNDI_UNAVAILABILITY_CAUSE;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final Logger logger = Logger.getLogger(JndiResourceResolver.class.getName());
        private static final Pattern whitespace = Pattern.compile("\\s+");
        private final RecordFetcher recordFetcher;

        public JndiResourceResolver(RecordFetcher recordFetcher) {
            this.recordFetcher = recordFetcher;
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<String> resolveTxt(String serviceConfigHostname) throws NamingException {
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query TXT records for {0}", new Object[]{serviceConfigHostname});
            }
            List<String> serviceConfigRawTxtRecords = this.recordFetcher.getAllRecords("TXT", "dns:///" + serviceConfigHostname);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} TXT records", new Object[]{Integer.valueOf(serviceConfigRawTxtRecords.size())});
            }
            List<String> serviceConfigTxtRecords = new ArrayList<>(serviceConfigRawTxtRecords.size());
            for (String serviceConfigRawTxtRecord : serviceConfigRawTxtRecords) {
                serviceConfigTxtRecords.add(unquote(serviceConfigRawTxtRecord));
            }
            return Collections.unmodifiableList(serviceConfigTxtRecords);
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<DnsNameResolver.SrvRecord> resolveSrv(String host2) throws Exception {
            String[] parts;
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query SRV records for {0}", new Object[]{host2});
            }
            List<String> rawSrvRecords = this.recordFetcher.getAllRecords("SRV", "dns:///" + host2);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} SRV records", new Object[]{Integer.valueOf(rawSrvRecords.size())});
            }
            List<DnsNameResolver.SrvRecord> srvRecords = new ArrayList<>(rawSrvRecords.size());
            Exception first = null;
            Level level = Level.WARNING;
            for (String rawSrv : rawSrvRecords) {
                try {
                    parts = whitespace.split(rawSrv);
                    Verify.verify(parts.length == 4, "Bad SRV Record: %s", rawSrv);
                } catch (RuntimeException e2) {
                    logger.log(level, "Failed to construct SRV record " + rawSrv, (Throwable) e2);
                    if (first == null) {
                        first = e2;
                        level = Level.FINE;
                    }
                }
                if (!parts[3].endsWith(".")) {
                    throw new RuntimeException("Returned SRV host does not end in period: " + parts[3]);
                    break;
                }
                srvRecords.add(new DnsNameResolver.SrvRecord(parts[3], Integer.parseInt(parts[2])));
            }
            if (srvRecords.isEmpty() && first != null) {
                throw first;
            }
            return Collections.unmodifiableList(srvRecords);
        }

        static String unquote(String txtRecord) {
            StringBuilder sb = new StringBuilder(txtRecord.length());
            boolean inquote = false;
            int i2 = 0;
            while (i2 < txtRecord.length()) {
                char c = txtRecord.charAt(i2);
                if (!inquote) {
                    if (c != ' ') {
                        if (c == '\"') {
                            inquote = true;
                        }
                        sb.append(c);
                    }
                } else if (c == '\"') {
                    inquote = false;
                } else {
                    if (c == '\\' && (c = txtRecord.charAt((i2 = i2 + 1))) != '\"' && c != '\\') {
                        throw new AssertionError();
                    }
                    sb.append(c);
                }
                i2++;
            }
            return sb.toString();
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class JndiRecordFetcher implements RecordFetcher {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        JndiRecordFetcher() {
        }

        @Override // io.grpc.internal.JndiResourceResolverFactory.RecordFetcher
        public List<String> getAllRecords(String recordType, String name) throws NamingException {
            checkAvailable();
            String[] rrType = {recordType};
            List<String> records = new ArrayList<>();
            Hashtable<String, String> env2 = new Hashtable<>();
            env2.put("com.sun.jndi.ldap.connect.timeout", "5000");
            env2.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(env2);
            try {
                Attributes attrs = initialDirContext.getAttributes(name, rrType);
                NamingEnumeration<? extends Attribute> rrGroups = attrs.getAll();
                while (rrGroups.hasMore()) {
                    try {
                        Attribute rrEntry = (Attribute) rrGroups.next();
                        if (!Arrays.asList(rrType).contains(rrEntry.getID())) {
                            throw new AssertionError();
                        }
                        NamingEnumeration<?> rrValues = rrEntry.getAll();
                        while (rrValues.hasMore()) {
                            try {
                                records.add(String.valueOf(rrValues.next()));
                            } catch (NamingException ne) {
                                closeThenThrow(rrValues, ne);
                            }
                        }
                        rrValues.close();
                    } catch (NamingException ne2) {
                        closeThenThrow(rrGroups, ne2);
                    }
                }
                rrGroups.close();
            } catch (NamingException ne3) {
                closeThenThrow((DirContext) initialDirContext, ne3);
            }
            initialDirContext.close();
            return records;
        }

        private static void closeThenThrow(NamingEnumeration<?> namingEnumeration, NamingException e2) throws NamingException {
            try {
                namingEnumeration.close();
            } catch (NamingException e3) {
            }
            throw e2;
        }

        private static void closeThenThrow(DirContext ctx, NamingException e2) throws NamingException {
            try {
                ctx.close();
            } catch (NamingException e3) {
            }
            throw e2;
        }

        private static void checkAvailable() {
            if (JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE);
            }
        }
    }
}