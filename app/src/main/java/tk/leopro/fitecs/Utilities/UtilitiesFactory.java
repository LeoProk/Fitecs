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

import android.app.Fragment;
import android.content.Context;

import java.util.List;
import tk.leopro.fitecs.Interfaces.FactoryInterface;

/**
 * Factory for network statues , retrieving files , saving and appending new files.
 */
public class UtilitiesFactory {

    //Switch between 2 fragments
    public static FactoryInterface switchFragments(Context context, String newFragmentTag) {
        return new FragmentSwitcher(context, newFragmentTag);
    }

    //Check for network status return bool
    public static FactoryInterface checkNetwork(Context context) {
        return new NetworkCheck(context);
    }

    //Gets file from external storage by name
    public static FactoryInterface getFile(Context context, String filename) {
        return new FileGetter(context, filename);
    }

    //Save file to external storage with name and message
    public static FactoryInterface saveFile(Context context, String filename, String message) {
        return new SaveFile(context, filename, message);
    }

    //Appends message to existing file
    public static FactoryInterface appendFile(Context context, String filename, String message) {
        return new AppendFile(context, filename, message);
    }


    //Adds new fragment.
    public static FactoryInterface addFragment(Context context, Fragment fragment, String tag,
                                               boolean addToBackStack) {
        return new AddFragment(context, fragment, tag, addToBackStack);
    }

    //Replace the current fragment with new fragment.
    public static FactoryInterface replaceFragment(Context context, Fragment fragment, String tag,
                                                   boolean addToBackStack) {
        return new ReplaceFragment(context, fragment, tag, addToBackStack);
    }
    //Gets info from json url
    public static FactoryInterface getFromUrl(String url){

        return new JSONConverter(url);
    }
}
