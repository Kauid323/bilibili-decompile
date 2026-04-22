package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.events.EventDefinition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00060\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/MonitoringEvent;", "", "Param", "Lio/ktor/events/EventDefinition;", "Event", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function1;", "", "event", "<init>", "(Lio/ktor/events/EventDefinition;)V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MonitoringEvent<Param, Event extends EventDefinition<Param>> implements ClientHook<Function1<? super Param, ? extends Unit>> {
    private final Event event;

    public MonitoringEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient client, Object handler) {
        install(client, (Function1) ((Function1) handler));
    }

    public void install(HttpClient client, final Function1<? super Param, Unit> function1) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function1, "handler");
        client.getMonitor().subscribe(this.event, new Function1() { // from class: io.ktor.client.plugins.api.MonitoringEvent$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit install$lambda$0;
                install$lambda$0 = MonitoringEvent.install$lambda$0(function1, obj);
                return install$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(Function1 $handler, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $handler.invoke(it);
        return Unit.INSTANCE;
    }
}