package android.view;

import android.content.Context;

class JavaViewSpy extends View {
    JavaViewSpy(Context context) {
        super(context);
        throw new UnsupportedOperationException("This class isn't meant to be instantiated");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int windowAttachCount(View view) {
        return view.getWindowAttachCount();
    }
}