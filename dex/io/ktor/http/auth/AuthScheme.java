package io.ktor.http.auth;

import kotlin.Metadata;

/* compiled from: AuthScheme.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/ktor/http/auth/AuthScheme;", "", "<init>", "()V", "", AuthScheme.Basic, "Ljava/lang/String;", AuthScheme.Digest, AuthScheme.Negotiate, AuthScheme.OAuth, AuthScheme.Bearer, "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuthScheme {
    public static final String Basic = "Basic";
    public static final String Bearer = "Bearer";
    public static final String Digest = "Digest";
    public static final AuthScheme INSTANCE = new AuthScheme();
    public static final String Negotiate = "Negotiate";
    public static final String OAuth = "OAuth";

    private AuthScheme() {
    }
}