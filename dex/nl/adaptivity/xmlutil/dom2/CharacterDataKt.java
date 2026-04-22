package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharacterData.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"*\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"value", "", "data", "Lnl/adaptivity/xmlutil/dom2/CharacterData;", "getData", "(Lnl/adaptivity/xmlutil/dom2/CharacterData;)Ljava/lang/String;", "setData", "(Lnl/adaptivity/xmlutil/dom2/CharacterData;Ljava/lang/String;)V", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharacterDataKt {
    public static final String getData(CharacterData $this$data) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        return $this$data.getData();
    }

    public static final void setData(CharacterData $this$data, String value) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$data.setData(value);
    }
}