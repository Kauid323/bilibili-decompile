package tv.danmaku.bili.ui.appeal;

import android.content.Context;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import java.util.List;

public interface IImageUploader {

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OnUploadListener {
        void onCanceled();

        void onFailed(ImageUploadException imageUploadException);

        void onStart();

        void onSuccess(List<String> list);
    }

    void cancel();

    void upload(Context context, List<ImageMedia> list, int i, OnUploadListener onUploadListener);
}