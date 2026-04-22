package android.support.v4.media;

import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer extends androidx.media.AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel parcel) {
        return androidx.media.AudioAttributesImplBaseParcelizer.read(parcel);
    }

    public static void write(AudioAttributesImplBase obj, VersionedParcel parcel) {
        androidx.media.AudioAttributesImplBaseParcelizer.write(obj, parcel);
    }
}