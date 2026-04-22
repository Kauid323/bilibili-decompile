package kntr.app.digital.preview.save;

import com.bilibili.lib.foundation.FoundationAlias;
import dagger.hilt.EntryPoints;
import kotlin.Metadata;

/* compiled from: Save.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"save", "Lkntr/app/digital/preview/save/Save;", "getSave", "()Lkntr/app/digital/preview/save/Save;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Save_androidKt {
    private static final Save save = ((SaveEntryPoint) EntryPoints.get(FoundationAlias.getFapp(), SaveEntryPoint.class)).save();

    public static final Save getSave() {
        return save;
    }
}