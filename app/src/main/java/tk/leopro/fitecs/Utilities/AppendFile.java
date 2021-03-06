/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tk.leopro.fitecs.Utilities;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;

import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Appends file to internal storage.
 */
final class AppendFile implements FactoryInterface {

    private Context mContext;

    private String mFilename;

    private String mMessage;

    public AppendFile(Context context, String filename, String message) {
        mContext = context;
        mFilename = filename;
        mMessage = message;

    }

    @Override
    public Object doTask() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream outputStream = mContext
                            .openFileOutput(mFilename, Context.MODE_APPEND);
                    outputStream.write(mMessage.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        return null;
    }
}
