package nl.adaptivity.xmlutil.dom;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.CharacterData;

/* compiled from: CharacterData.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"4\u0010\u0002\u001a\u00020\u0001*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"value", "", "data", "Lorg/w3c/dom/CharacterData;", "Lnl/adaptivity/xmlutil/dom/CharacterData;", "getData$annotations", "(Lorg/w3c/dom/CharacterData;)V", "getData", "(Lorg/w3c/dom/CharacterData;)Ljava/lang/String;", "setData", "(Lorg/w3c/dom/CharacterData;Ljava/lang/String;)V", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharacterDataKt {
    @Deprecated(message = "Use accessor methods for dom2 compatibility")
    public static /* synthetic */ void getData$annotations(CharacterData characterData) {
    }

    public static final String getData(CharacterData $this$data) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        String data = $this$data.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        return data;
    }

    public static final void setData(CharacterData $this$data, String value) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$data.setData(value);
    }
}