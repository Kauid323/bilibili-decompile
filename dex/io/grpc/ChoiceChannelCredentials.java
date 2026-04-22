package io.grpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ChoiceChannelCredentials extends ChannelCredentials {
    private final List<ChannelCredentials> creds;

    public static ChannelCredentials create(ChannelCredentials... creds) {
        if (creds.length == 0) {
            throw new IllegalArgumentException("At least one credential is required");
        }
        for (ChannelCredentials cred : creds) {
            if (cred == null) {
                throw new NullPointerException();
            }
        }
        return new ChoiceChannelCredentials(Collections.unmodifiableList(new ArrayList(Arrays.asList(creds))));
    }

    private ChoiceChannelCredentials(List<ChannelCredentials> creds) {
        this.creds = creds;
    }

    public List<ChannelCredentials> getCredentialsList() {
        return this.creds;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        List<ChannelCredentials> credsWithoutTokens = new ArrayList<>();
        for (ChannelCredentials cred : this.creds) {
            credsWithoutTokens.add(cred.withoutBearerTokens());
        }
        return new ChoiceChannelCredentials(Collections.unmodifiableList(credsWithoutTokens));
    }
}