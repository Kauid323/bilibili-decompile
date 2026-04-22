package c.t.m.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: TML */
public class c1 {
    public Context a;

    public c1(Context context) {
        this.a = context;
    }

    public String a() {
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            }
        } catch (Exception e) {
        }
        return r0;
    }
}