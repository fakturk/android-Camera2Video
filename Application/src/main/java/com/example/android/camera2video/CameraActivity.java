/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CameraActivity extends Activity {
    SmallCircleView smallCircleView;
    float currentY=100, updateY=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2VideoFragment.newInstance(), "FRAGMENT")
                    .commit();
        }

        startService(new Intent(CameraActivity.this, SensorService.class));
//        smallCircleView = (SmallCircleView) findViewById(R.id.smallCircleView);
//        float ydpi = getResources().getDisplayMetrics().ydpi; //1 inch
//        final float yCm = ydpi/2.54f;
//        TimerTask myTimerTask = new TimerTask() {
//            @Override
//            public void run() {
//                // Update logic here
//                currentY=smallCircleView.getY();
//                if (currentY>yCm*5+100)
//                {
//                    updateY=-5;
//                }
//                if (currentY<100)
//                {
//                    updateY=5;
//                }
//
//
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // Drawing logic here
//                        smallCircleView.setYMove(updateY);
//
//                    }
//                });
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(myTimerTask, 10, 10);
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        stopService(new Intent(this,SensorService.class));
    }
    @Override
    protected void onPause() {

        super.onPause();
        stopService(new Intent(this,SensorService.class));


    }

    @Override
    protected void onResume() {

        super.onResume();
        startService(new Intent(this, SensorService.class));
    }

}
