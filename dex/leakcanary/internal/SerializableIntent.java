package leakcanary.internal;

import android.content.Intent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SerializableIntent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lleakcanary/internal/SerializableIntent;", "Ljava/io/Serializable;", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "_intent", "getIntent", "()Landroid/content/Intent;", "uri", "", "kotlin.jvm.PlatformType", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class SerializableIntent implements Serializable {
    private transient Intent _intent;
    private final String uri;

    public SerializableIntent(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        this.uri = intent.toUri(0);
        this._intent = intent;
    }

    public final Intent getIntent() {
        Intent $this$run = this._intent;
        if ($this$run == null) {
            Intent $this$apply = Intent.parseUri(this.uri, 0);
            this._intent = $this$apply;
            $this$run = $this$apply;
        }
        Intrinsics.checkExpressionValueIsNotNull($this$run, "_intent.run {\n      this… { _intent = this }\n    }");
        return $this$run;
    }
}