package tv.danmaku.bili.videopage.common.share;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.qrcode.QrcodeService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import kntr.base.localization.NumberFormat_androidKt;
import tv.danmaku.bili.videopage.common.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class ShareOutHelper {
    public static Bitmap generateShareView(View rootView, ShareElements adapter) {
        String discussBStr;
        int disLength;
        if (rootView == null) {
            return null;
        }
        View poster = LayoutInflater.from(rootView.getContext()).inflate(R.layout.bili_app_share_out_pic_type_b, (ViewGroup) null);
        TextView detail = (TextView) poster.findViewById(R.id.iv_share_topic_detail);
        String playCount = adapter.play;
        if (playCount == null) {
            playCount = "";
        }
        String likeCount = adapter.like;
        if (likeCount == null) {
            likeCount = "";
        }
        String sysnopsis = String.format("%s播放", NumberFormat_androidKt.format(playCount, "0")) + " · " + String.format("%s点赞", NumberFormat_androidKt.format(likeCount, "0"));
        if (!TextUtils.isEmpty(sysnopsis)) {
            detail.setText(sysnopsis);
        }
        ImageView cover = (ImageView) poster.findViewById(R.id.iv_share_topic_pic);
        displayCover(cover, adapter.cover);
        TextView discuss = (TextView) poster.findViewById(R.id.iv_share_discuss);
        ImageView avatar = (ImageView) poster.findViewById(R.id.iv_share_user_pic);
        TextView username = (TextView) poster.findViewById(R.id.iv_share_user_name);
        TextView title = (TextView) poster.findViewById(R.id.iv_share_topic_title);
        ImageView qrcode = (ImageView) poster.findViewById(R.id.iv_share_qr_code);
        TextView discuss_base = (TextView) poster.findViewById(R.id.iv_share_discuss_base);
        View layout_base = poster.findViewById(R.id.iv_share_base);
        String discussStr = adapter.discuss.toString();
        if (adapter.discussBase == null) {
            discussBStr = "";
        } else {
            String discussBStr2 = adapter.discussBase.toString();
            discussBStr = discussBStr2;
        }
        if (TextUtils.isEmpty(discussStr)) {
            disLength = 0;
        } else {
            disLength = discussStr.length();
            discuss.setText(discussStr);
            if (disLength < 30) {
                discuss.setTextSize(1, 24.0f);
            } else if (disLength < 141) {
                discuss.setTextSize(1, 18.0f);
            } else {
                discuss.setTextSize(1, 14.0f);
            }
        }
        if (!TextUtils.isEmpty(discussBStr)) {
            int disBLength = discussBStr.length();
            if (disBLength > 1000 - disLength) {
                disBLength = 1000 - disLength;
                if (disBLength > 10) {
                    discussBStr = discussBStr.substring(0, disBLength - 1) + "...";
                } else {
                    disBLength = -1;
                }
            }
            if (disBLength > 0) {
                discuss_base.setText(discussBStr);
                if (disBLength < 30) {
                    discuss_base.setTextSize(1, 24.0f);
                } else if (disBLength < 141) {
                    discuss_base.setTextSize(1, 18.0f);
                } else {
                    discuss_base.setTextSize(1, 14.0f);
                }
                layout_base.setVisibility(0);
            }
        }
        String avatarStr = adapter.userAvatar;
        if (!TextUtils.isEmpty(avatarStr)) {
            displayAvatar(avatar, adapter.userAvatar);
        }
        String userStr = adapter.userName;
        if (!TextUtils.isEmpty(userStr)) {
            username.setText(userStr);
        }
        String titleStr = adapter.title;
        if (!TextUtils.isEmpty(titleStr)) {
            title.setText(titleStr);
        }
        String avatarStr2 = adapter.videoUrl;
        qrcode.setImageBitmap(generateQrCode(avatarStr2, qrcode.getWidth(), qrcode.getHeight(), -16777216));
        WindowManager wm = (WindowManager) rootView.getContext().getSystemService("window");
        DisplayMetrics dm = new DisplayMetrics();
        if (wm != null) {
            wm.getDefaultDisplay().getMetrics(dm);
        }
        int width = dm.widthPixels;
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        poster.measure(widthSpec, heightSpec);
        int heightSpec2 = poster.getMeasuredWidth();
        int width2 = poster.getMeasuredHeight();
        poster.layout(0, 0, heightSpec2, width2);
        Bitmap posterBitmap = Bitmap.createBitmap(poster.getWidth(), poster.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(posterBitmap);
        poster.draw(canvas);
        return posterBitmap;
    }

    private static Bitmap generateQrCode(String source, int bitmapWidth, int bitmapHeight, int color) {
        QrcodeService service;
        if (TextUtils.isEmpty(source) || (service = (QrcodeService) BLRouter.INSTANCE.get(QrcodeService.class, "default")) == null) {
            return null;
        }
        return service.generateBitmap(source, bitmapWidth, bitmapHeight, color);
    }

    private static void displayAvatar(ImageView ivAvatar, String avatarUrl) {
        if (!TextUtils.isEmpty(avatarUrl)) {
            ImageRequest request = ImageRequest.fromUri(avatarUrl);
            if (request != null) {
                DataSource<CloseableReference<CloseableImage>> dataSource = Fresco.getImagePipeline().fetchDecodedImage(request, (Object) null);
                try {
                    CloseableReference<CloseableImage> result = (CloseableReference) DataSources.waitForFinalResult(dataSource);
                    if (result != null) {
                        CloseableBitmap closeableBitmap = (CloseableImage) result.get();
                        if (closeableBitmap instanceof CloseableBitmap) {
                            Bitmap temp = closeableBitmap.getUnderlyingBitmap();
                            Bitmap avatarBit = Bitmap.createBitmap(temp);
                            ivAvatar.setImageBitmap(createCircleBitmap(avatarBit));
                        } else {
                            ivAvatar.setImageResource(com.bilibili.lib.basecomponent.R.drawable.bili_default_avatar);
                        }
                    } else {
                        ivAvatar.setImageResource(com.bilibili.lib.basecomponent.R.drawable.bili_default_avatar);
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        ivAvatar.setImageResource(com.bilibili.lib.basecomponent.R.drawable.bili_default_avatar);
    }

    private static void displayCover(ImageView ivCover, String coverUrl) {
        if (!TextUtils.isEmpty(coverUrl)) {
            ImageRequest request = ImageRequest.fromUri(coverUrl);
            if (request != null) {
                DataSource<CloseableReference<CloseableImage>> dataSource = Fresco.getImagePipeline().fetchDecodedImage(request, (Object) null);
                try {
                    CloseableReference<CloseableImage> result = (CloseableReference) DataSources.waitForFinalResult(dataSource);
                    if (result != null) {
                        CloseableBitmap closeableBitmap = (CloseableImage) result.get();
                        if (closeableBitmap instanceof CloseableBitmap) {
                            Bitmap temp = closeableBitmap.getUnderlyingBitmap();
                            Bitmap avatarBit = Bitmap.createBitmap(temp);
                            ivCover.setImageBitmap(createCoverBitmap(avatarBit));
                        } else {
                            ivCover.setImageResource(tv.danmaku.biliplayer.baseres.R.drawable.share_out_default_img);
                        }
                    } else {
                        ivCover.setImageResource(tv.danmaku.biliplayer.baseres.R.drawable.share_out_default_img);
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        ivCover.setImageResource(tv.danmaku.biliplayer.baseres.R.drawable.share_out_default_img);
    }

    private static Bitmap createCoverBitmap(Bitmap resource) {
        int width = resource.getWidth();
        int height = resource.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap coverBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(coverBitmap);
        RectF rectF = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, width, height);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, paint);
        return coverBitmap;
    }

    private static Bitmap createCircleBitmap(Bitmap resource) {
        int width = resource.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, paint);
        return circleBitmap;
    }
}