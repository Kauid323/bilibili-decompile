package kntr.app.digital.preview.usage;

import com.bilibili.lib.foundation.FoundationAlias;
import dagger.hilt.EntryPoints;
import kotlin.Metadata;

/* compiled from: AvatarUploader.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"uploadAvatar", "Lkntr/app/digital/preview/usage/UploadAvatar;", "getUploadAvatar", "()Lkntr/app/digital/preview/usage/UploadAvatar;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AvatarUploader_androidKt {
    private static final UploadAvatar uploadAvatar = ((UploadAvatarEntryPoint) EntryPoints.get(FoundationAlias.getFapp(), UploadAvatarEntryPoint.class)).uploadAvatar();

    public static final UploadAvatar getUploadAvatar() {
        return uploadAvatar;
    }
}