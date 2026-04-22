package io.grpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ChoiceServerCredentials extends ServerCredentials {
    private final List<ServerCredentials> creds;

    public static ServerCredentials create(ServerCredentials... creds) {
        if (creds.length == 0) {
            throw new IllegalArgumentException("At least one credential is required");
        }
        return new ChoiceServerCredentials(creds);
    }

    private ChoiceServerCredentials(ServerCredentials... creds) {
        for (ServerCredentials cred : creds) {
            if (cred == null) {
                throw new NullPointerException();
            }
        }
        this.creds = Collections.unmodifiableList(new ArrayList(Arrays.asList(creds)));
    }

    public List<ServerCredentials> getCredentialsList() {
        return this.creds;
    }
}