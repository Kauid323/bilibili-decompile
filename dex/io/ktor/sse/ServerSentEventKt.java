package io.ktor.sse;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: ServerSentEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087T¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087T¢\u0006\f\n\u0004\b\r\u0010\n\u0012\u0004\b\u000e\u0010\f\"\u001a\u0010\u000f\u001a\u00020\u00038\u0006X\u0087T¢\u0006\f\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0010\u0010\f\" \u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"T", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", ContentDisposition.Parameters.Name, "value", "", "appendField", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V", "COLON", "Ljava/lang/String;", "getCOLON$annotations", "()V", "SPACE", "getSPACE$annotations", "END_OF_LINE", "getEND_OF_LINE$annotations", "Lkotlin/text/Regex;", "END_OF_LINE_VARIANTS", "Lkotlin/text/Regex;", "getEND_OF_LINE_VARIANTS", "()Lkotlin/text/Regex;", "getEND_OF_LINE_VARIANTS$annotations", "ktor-sse"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ServerSentEventKt {
    public static final String COLON = ":";
    public static final String END_OF_LINE = "\r\n";
    private static final Regex END_OF_LINE_VARIANTS = new Regex("\r\n|\r|\n");
    public static final String SPACE = " ";

    public static final /* synthetic */ void access$appendField(StringBuilder $receiver, String name, Object value) {
        appendField($receiver, name, value);
    }

    @InternalAPI
    public static /* synthetic */ void getCOLON$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getEND_OF_LINE$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getEND_OF_LINE_VARIANTS$annotations() {
    }

    @InternalAPI
    public static /* synthetic */ void getSPACE$annotations() {
    }

    public static final <T> void appendField(StringBuilder $this$appendField, String name, T t) {
        if (t != null) {
            Iterable values = END_OF_LINE_VARIANTS.split(t.toString(), 0);
            Iterable $this$forEach$iv = values;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                $this$appendField.append(name + ": " + it + END_OF_LINE);
            }
        }
    }

    public static final Regex getEND_OF_LINE_VARIANTS() {
        return END_OF_LINE_VARIANTS;
    }
}