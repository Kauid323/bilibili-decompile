package io.grpc;

import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public final class TlsServerCredentials extends ServerCredentials {
    private final byte[] certificateChain;
    private final boolean fakeFeature;
    private final byte[] privateKey;
    private final String privateKeyPassword;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum Feature {
        FAKE
    }

    public static ServerCredentials create(File certChain, File privateKey) throws IOException {
        return newBuilder().keyManager(certChain, privateKey).build();
    }

    public static ServerCredentials create(InputStream certChain, InputStream privateKey) throws IOException {
        return newBuilder().keyManager(certChain, privateKey).build();
    }

    TlsServerCredentials(Builder builder) {
        this.fakeFeature = builder.fakeFeature;
        this.certificateChain = builder.certificateChain;
        this.privateKey = builder.privateKey;
        this.privateKeyPassword = builder.privateKeyPassword;
    }

    public byte[] getCertificateChain() {
        return Arrays.copyOf(this.certificateChain, this.certificateChain.length);
    }

    public byte[] getPrivateKey() {
        return Arrays.copyOf(this.privateKey, this.privateKey.length);
    }

    public String getPrivateKeyPassword() {
        return this.privateKeyPassword;
    }

    public Set<Feature> incomprehensible(Set<Feature> understoodFeatures) {
        Set<Feature> incomprehensible = EnumSet.noneOf(Feature.class);
        if (this.fakeFeature) {
            requiredFeature(understoodFeatures, incomprehensible, Feature.FAKE);
        }
        return Collections.unmodifiableSet(incomprehensible);
    }

    private static void requiredFeature(Set<Feature> understoodFeatures, Set<Feature> incomprehensible, Feature feature) {
        if (!understoodFeatures.contains(feature)) {
            incomprehensible.add(feature);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        private byte[] certificateChain;
        private boolean fakeFeature;
        private byte[] privateKey;
        private String privateKeyPassword;

        private Builder() {
        }

        public Builder requireFakeFeature() {
            this.fakeFeature = true;
            return this;
        }

        public Builder keyManager(File certChain, File privateKey) throws IOException {
            return keyManager(certChain, privateKey, (String) null);
        }

        public Builder keyManager(File certChain, File privateKey, String privateKeyPassword) throws IOException {
            InputStream certChainIs = new FileInputStream(certChain);
            try {
                InputStream privateKeyIs = new FileInputStream(privateKey);
                Builder keyManager = keyManager(certChainIs, privateKeyIs, privateKeyPassword);
                privateKeyIs.close();
                return keyManager;
            } finally {
                certChainIs.close();
            }
        }

        public Builder keyManager(InputStream certChain, InputStream privateKey) throws IOException {
            return keyManager(certChain, privateKey, (String) null);
        }

        public Builder keyManager(InputStream certChain, InputStream privateKey, String privateKeyPassword) throws IOException {
            byte[] certChainBytes = ByteStreams.toByteArray(certChain);
            byte[] privateKeyBytes = ByteStreams.toByteArray(privateKey);
            this.certificateChain = certChainBytes;
            this.privateKey = privateKeyBytes;
            this.privateKeyPassword = privateKeyPassword;
            return this;
        }

        public ServerCredentials build() {
            if (this.certificateChain == null) {
                throw new IllegalStateException("A key manager is required");
            }
            return new TlsServerCredentials(this);
        }
    }
}