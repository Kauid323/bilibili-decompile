package kntr.app.digital.preview.usage;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BiliNftAvatarUploader.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/BiliNftAvatarUploader;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Companion", "UploadBFSCallback", "UploadCallback", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BiliNftAvatarUploader {
    public static final int $stable = 0;
    private static final int CONNECT_NETWORK_ERROR = -4097;
    public static final Companion Companion = new Companion(null);
    private static final String NFT_LIST_BFS_BUCKET = "medialist";
    private static final String NFT_LIST_COVER_DIR = "nft";
    private static final String TAG = "BiliNftAvatarUploader";

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/usage/BiliNftAvatarUploader$UploadBFSCallback;", RoomRecommendViewModel.EMPTY_CURSOR, "onSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "onFailure", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface UploadBFSCallback {
        void onFailure();

        void onSuccess(String str);
    }

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/usage/BiliNftAvatarUploader$UploadCallback;", RoomRecommendViewModel.EMPTY_CURSOR, "onUploadSuccess", RoomRecommendViewModel.EMPTY_CURSOR, "onUploadFailed", "code", RoomRecommendViewModel.EMPTY_CURSOR, "msg", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface UploadCallback {
        void onUploadFailed(int i, String str);

        void onUploadSuccess();
    }

    /* compiled from: BiliNftAvatarUploader.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/digital/preview/usage/BiliNftAvatarUploader$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "CONNECT_NETWORK_ERROR", RoomRecommendViewModel.EMPTY_CURSOR, "uploadAvatar", RoomRecommendViewModel.EMPTY_CURSOR, "width", "height", "offsetX", "offsetY", "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "uploadCallback", "Lkntr/app/digital/preview/usage/BiliNftAvatarUploader$UploadCallback;", "NFT_LIST_BFS_BUCKET", "NFT_LIST_COVER_DIR", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void uploadAvatar(int width, int height, int offsetX, int offsetY, long cardId, UploadCallback uploadCallback) {
        }
    }
}