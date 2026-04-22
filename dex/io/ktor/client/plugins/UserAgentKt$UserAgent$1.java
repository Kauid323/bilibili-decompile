package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: UserAgent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class UserAgentKt$UserAgent$1 extends AdaptedFunctionReference implements Function0<UserAgentConfig> {
    public static final UserAgentKt$UserAgent$1 INSTANCE = new UserAgentKt$UserAgent$1();

    UserAgentKt$UserAgent$1() {
        super(0, UserAgentConfig.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
    }

    /* renamed from: invoke */
    public final UserAgentConfig m3457invoke() {
        return new UserAgentConfig(null, 1, null);
    }
}