package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebSocketExtension.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00052\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\b2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0015j\u0002`\u00160\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionsConfig;", Column.INVAL_VALUE, "<init>", "()V", "ConfigType", "Lio/ktor/websocket/WebSocketExtensionFactory;", "extension", "Lkotlin/Function1;", Column.INVAL_VALUE, "Lkotlin/ExtensionFunctionType;", "config", "install", "(Lio/ktor/websocket/WebSocketExtensionFactory;Lkotlin/jvm/functions/Function1;)V", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtension;", "build", "()Ljava/util/List;", "extensionFactory", "checkConflicts", "(Lio/ktor/websocket/WebSocketExtensionFactory;)V", Column.INVAL_VALUE, "Lkotlin/Function0;", "Lio/ktor/websocket/ExtensionInstaller;", "installers", "Ljava/util/List;", Column.INVAL_VALUE, Column.INVAL_VALUE, "rcv", "[Ljava/lang/Boolean;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketExtensionsConfig {
    private final List<Function0<WebSocketExtension<?>>> installers = new ArrayList();
    private final Boolean[] rcv = {false, false, false};

    public static /* synthetic */ void install$default(WebSocketExtensionsConfig webSocketExtensionsConfig, WebSocketExtensionFactory webSocketExtensionFactory, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.websocket.WebSocketExtensionsConfig$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit install$lambda$0;
                    install$lambda$0 = WebSocketExtensionsConfig.install$lambda$0(obj2);
                    return install$lambda$0;
                }
            };
        }
        webSocketExtensionsConfig.install(webSocketExtensionFactory, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return Unit.INSTANCE;
    }

    public final <ConfigType> void install(final WebSocketExtensionFactory<ConfigType, ?> webSocketExtensionFactory, final Function1<? super ConfigType, Unit> function1) {
        Intrinsics.checkNotNullParameter(webSocketExtensionFactory, "extension");
        Intrinsics.checkNotNullParameter(function1, "config");
        checkConflicts(webSocketExtensionFactory);
        this.installers.add(new Function0() { // from class: io.ktor.websocket.WebSocketExtensionsConfig$$ExternalSyntheticLambda1
            public final Object invoke() {
                WebSocketExtension install;
                install = WebSocketExtensionFactory.this.install(function1);
                return install;
            }
        });
    }

    public final List<WebSocketExtension<?>> build() {
        Iterable $this$map$iv = this.installers;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Function0 it = (Function0) item$iv$iv;
            destination$iv$iv.add((WebSocketExtension) it.invoke());
        }
        return (List) destination$iv$iv;
    }

    private final void checkConflicts(WebSocketExtensionFactory<?, ?> webSocketExtensionFactory) {
        boolean hasConflict = webSocketExtensionFactory.getRsv1() && this.rcv[1].booleanValue();
        boolean hasConflict2 = hasConflict || (webSocketExtensionFactory.getRsv2() && this.rcv[2].booleanValue());
        boolean hasConflict3 = hasConflict2 || (webSocketExtensionFactory.getRsv3() && this.rcv[3].booleanValue());
        if (!(hasConflict3 ? false : true)) {
            throw new IllegalStateException("Failed to install extension. Please check configured extensions for conflicts.".toString());
        }
    }
}