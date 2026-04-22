package tv.danmaku.bili.auth.helper;

import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ModifyHelperApi.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\fH&J(\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0011H&JJ\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0017j\b\u0012\u0004\u0012\u00020\u000b`\u00182\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0019H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/helper/ModifyHelper;", "", "requestCheckStatus", "", "requstType", "", "listener", "Ltv/danmaku/bili/auth/helper/CheckStatusListener;", "(Ljava/lang/Integer;Ltv/danmaku/bili/auth/helper/CheckStatusListener;)V", "requestCheckIDCardDigits", "digits", "", "Ltv/danmaku/bili/auth/helper/CheckCardDigitsLitener;", "requestUploadPhoto", "accessKey", "photo", "Ljava/io/File;", "Ltv/danmaku/bili/auth/helper/RequestUploadPhotoListener;", "requestChangePerson", "token_new", "token_old", "reason", "tokenList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ltv/danmaku/bili/auth/helper/RequestChangePersonListener;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ModifyHelper {
    void requestChangePerson(String str, String str2, String str3, ArrayList<String> arrayList, RequestChangePersonListener requestChangePersonListener);

    void requestCheckIDCardDigits(String str, CheckCardDigitsLitener checkCardDigitsLitener);

    void requestCheckStatus(Integer num, CheckStatusListener checkStatusListener);

    void requestUploadPhoto(String str, File file, RequestUploadPhotoListener requestUploadPhotoListener);

    /* compiled from: ModifyHelperApi.kt */
    /* renamed from: tv.danmaku.bili.auth.helper.ModifyHelper$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void requestCheckStatus$default(ModifyHelper modifyHelper, Integer num, CheckStatusListener checkStatusListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestCheckStatus");
            }
            if ((i & 2) != 0) {
                checkStatusListener = null;
            }
            modifyHelper.requestCheckStatus(num, checkStatusListener);
        }

        public static /* synthetic */ void requestCheckIDCardDigits$default(ModifyHelper modifyHelper, String str, CheckCardDigitsLitener checkCardDigitsLitener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestCheckIDCardDigits");
            }
            if ((i & 2) != 0) {
                checkCardDigitsLitener = null;
            }
            modifyHelper.requestCheckIDCardDigits(str, checkCardDigitsLitener);
        }

        public static /* synthetic */ void requestUploadPhoto$default(ModifyHelper modifyHelper, String str, File file, RequestUploadPhotoListener requestUploadPhotoListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestUploadPhoto");
            }
            if ((i & 4) != 0) {
                requestUploadPhotoListener = null;
            }
            modifyHelper.requestUploadPhoto(str, file, requestUploadPhotoListener);
        }

        public static /* synthetic */ void requestChangePerson$default(ModifyHelper modifyHelper, String str, String str2, String str3, ArrayList arrayList, RequestChangePersonListener requestChangePersonListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestChangePerson");
            }
            if ((i & 16) != 0) {
                requestChangePersonListener = null;
            }
            modifyHelper.requestChangePerson(str, str2, str3, arrayList, requestChangePersonListener);
        }
    }
}