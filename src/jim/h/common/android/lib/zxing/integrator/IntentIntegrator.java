// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IntentIntegrator.java

package jim.h.common.android.lib.zxing.integrator;

import android.app.Activity;
import android.content.Intent;
import jim.h.common.android.lib.zxing.CaptureActivity;

// Referenced classes of package jim.h.common.android.zxinglib.integrator:
//            IntentResult

public final class IntentIntegrator
{

    private IntentIntegrator()
    {
    }

    public static void initiateScan(Activity activity, int layoutResId, int viewFinderViewResId, int previewViewResId, boolean useFrontLight)
    {
        Intent intent = new Intent(activity,CaptureActivity.class);
        intent.putExtra("layoutResId", layoutResId);
        intent.putExtra("viewFinderViewResId", viewFinderViewResId);
        intent.putExtra("previewViewResId", previewViewResId);
        intent.putExtra("useFrontLight", useFrontLight);
        activity.startActivityForResult(intent, 0x0000c0de);
    }

    public static IntentResult parseActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(requestCode == 0x0000c0de)
        {
            if(resultCode == -1)
            {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String formatName = intent.getStringExtra("SCAN_RESULT_FORMAT");
                return new IntentResult(contents, formatName);
            } 
            else
            {
                return new IntentResult(null, null);
            }
        } 
        else
        {
            return null;
        }
    }

    public static final int REQUEST_CODE = 0x0000c0de;
}
