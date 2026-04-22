package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel in) {
            return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(in));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int size) {
            return new MediaDescriptionCompat[size];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private static final String TAG = "MediaDescriptionCompat";
    private final CharSequence mDescription;
    private MediaDescription mDescriptionFwk;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    MediaDescriptionCompat(String mediaId, CharSequence title, CharSequence subtitle, CharSequence description, Bitmap icon, Uri iconUri, Bundle extras, Uri mediaUri) {
        this.mMediaId = mediaId;
        this.mTitle = title;
        this.mSubtitle = subtitle;
        this.mDescription = description;
        this.mIcon = icon;
        this.mIconUri = iconUri;
        this.mExtras = extras;
        this.mMediaUri = mediaUri;
    }

    MediaDescriptionCompat(Parcel in) {
        this.mMediaId = in.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        ClassLoader loader = getClass().getClassLoader();
        this.mIcon = (Bitmap) in.readParcelable(loader);
        this.mIconUri = (Uri) in.readParcelable(loader);
        this.mExtras = in.readBundle(loader);
        this.mMediaUri = (Uri) in.readParcelable(loader);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((MediaDescription) getMediaDescription()).writeToParcel(dest, flags);
    }

    public String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.mSubtitle) + ", " + ((Object) this.mDescription);
    }

    public Object getMediaDescription() {
        if (this.mDescriptionFwk != null) {
            return this.mDescriptionFwk;
        }
        MediaDescription.Builder bob = Api21Impl.createBuilder();
        Api21Impl.setMediaId(bob, this.mMediaId);
        Api21Impl.setTitle(bob, this.mTitle);
        Api21Impl.setSubtitle(bob, this.mSubtitle);
        Api21Impl.setDescription(bob, this.mDescription);
        Api21Impl.setIconBitmap(bob, this.mIcon);
        Api21Impl.setIconUri(bob, this.mIconUri);
        Api21Impl.setExtras(bob, this.mExtras);
        Api23Impl.setMediaUri(bob, this.mMediaUri);
        this.mDescriptionFwk = Api21Impl.build(bob);
        return this.mDescriptionFwk;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object descriptionObj) {
        if (descriptionObj != null) {
            Builder bob = new Builder();
            MediaDescription description = (MediaDescription) descriptionObj;
            bob.setMediaId(Api21Impl.getMediaId(description));
            bob.setTitle(Api21Impl.getTitle(description));
            bob.setSubtitle(Api21Impl.getSubtitle(description));
            bob.setDescription(Api21Impl.getDescription(description));
            bob.setIconBitmap(Api21Impl.getIconBitmap(description));
            bob.setIconUri(Api21Impl.getIconUri(description));
            Bundle extras = Api21Impl.getExtras(description);
            if (extras != null) {
                extras = MediaSessionCompat.unparcelWithClassLoader(extras);
            }
            Uri mediaUri = null;
            if (extras != null) {
                mediaUri = (Uri) extras.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
            }
            if (mediaUri != null) {
                if (extras.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) && extras.size() == 2) {
                    extras = null;
                } else {
                    extras.remove(DESCRIPTION_KEY_MEDIA_URI);
                    extras.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
                }
            }
            bob.setExtras(extras);
            if (mediaUri != null) {
                bob.setMediaUri(mediaUri);
            } else {
                bob.setMediaUri(Api23Impl.getMediaUri(description));
            }
            MediaDescriptionCompat descriptionCompat = bob.build();
            descriptionCompat.mDescriptionFwk = description;
            return descriptionCompat;
        }
        return null;
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder setMediaId(String mediaId) {
            this.mMediaId = mediaId;
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.mTitle = title;
            return this;
        }

        public Builder setSubtitle(CharSequence subtitle) {
            this.mSubtitle = subtitle;
            return this;
        }

        public Builder setDescription(CharSequence description) {
            this.mDescription = description;
            return this;
        }

        public Builder setIconBitmap(Bitmap icon) {
            this.mIcon = icon;
            return this;
        }

        public Builder setIconUri(Uri iconUri) {
            this.mIconUri = iconUri;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public Builder setMediaUri(Uri mediaUri) {
            this.mMediaUri = mediaUri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static MediaDescription.Builder createBuilder() {
            return new MediaDescription.Builder();
        }

        static void setMediaId(MediaDescription.Builder builder, String mediaId) {
            builder.setMediaId(mediaId);
        }

        static void setTitle(MediaDescription.Builder builder, CharSequence title) {
            builder.setTitle(title);
        }

        static void setSubtitle(MediaDescription.Builder builder, CharSequence subtitle) {
            builder.setSubtitle(subtitle);
        }

        static void setDescription(MediaDescription.Builder builder, CharSequence description) {
            builder.setDescription(description);
        }

        static void setIconBitmap(MediaDescription.Builder builder, Bitmap icon) {
            builder.setIconBitmap(icon);
        }

        static void setIconUri(MediaDescription.Builder builder, Uri iconUri) {
            builder.setIconUri(iconUri);
        }

        static void setExtras(MediaDescription.Builder builder, Bundle extras) {
            builder.setExtras(extras);
        }

        static MediaDescription build(MediaDescription.Builder builder) {
            return builder.build();
        }

        static String getMediaId(MediaDescription description) {
            return description.getMediaId();
        }

        static CharSequence getTitle(MediaDescription description) {
            return description.getTitle();
        }

        static CharSequence getSubtitle(MediaDescription description) {
            return description.getSubtitle();
        }

        static CharSequence getDescription(MediaDescription description) {
            return description.getDescription();
        }

        static Bitmap getIconBitmap(MediaDescription description) {
            return description.getIconBitmap();
        }

        static Uri getIconUri(MediaDescription description) {
            return description.getIconUri();
        }

        static Bundle getExtras(MediaDescription description) {
            return description.getExtras();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static void setMediaUri(MediaDescription.Builder builder, Uri mediaUri) {
            builder.setMediaUri(mediaUri);
        }

        static Uri getMediaUri(MediaDescription description) {
            return description.getMediaUri();
        }
    }
}