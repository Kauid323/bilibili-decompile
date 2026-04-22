package io.grpc;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public final class TlsChannelCredentials extends ChannelCredentials {
    private final boolean fakeFeature;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum Feature {
        FAKE
    }

    public static ChannelCredentials create() {
        return newBuilder().build();
    }

    TlsChannelCredentials(Builder builder) {
        this.fakeFeature = builder.fakeFeature;
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

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        private boolean fakeFeature;

        private Builder() {
        }

        public Builder requireFakeFeature() {
            this.fakeFeature = true;
            return this;
        }

        public ChannelCredentials build() {
            return new TlsChannelCredentials(this);
        }
    }
}