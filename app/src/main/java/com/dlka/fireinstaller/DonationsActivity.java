package com.dlka.fireinstaller;

/**
 * Created by dkulsch on 04.10.15.
 */


/*
 * Copyright (C) 2011-2015 Dominik Schürmann <dominik@dominikschuermann.de>
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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.sufficientlysecure.donations.DonationsFragment;

public class DonationsActivity extends FragmentActivity {

    /**
     * Google
     */
    private static final String GOOGLE_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2ibePzdjfxN/PFlEHV6YqP9aNkJY2GDcJGNJ4kQ24v07wNUvqciagMukbfQVv2IJXozVm/4piohxyXZTM+/goU3PRY6RuBw+N76MXoOBt6ke6axgu7It1xBw4mHJIxrwIiN86P3sMrM8HNDoE5cCXVyuenhRX0V78AnZzpiI/LZJdoCRfDO4nzVv7jJF32kGp3R5UQ2MCxEQmLaoV3ieeNCnvonN6kCpxbVtdT4twbQnemsLkLou41K1QsnMz/aVvtm9Hr+uIAhPbsVSwnBIL3lEFQkgXsCEzN7iKA5RpfJQkXbUHWS6R69E7Xut6fRE4si4Uwqut57H94lCk0CAYQIDAQAB";
    private static final String[] GOOGLE_CATALOG = new String[]{"fireinstaller.donation.1",
            "fireinstaller.donation.2", "fireinstaller.donation.3", "fireinstaller.donation.5", "fireinstaller.donation.8",
            "fireinstaller.donation.13"};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.donations_activity);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DonationsFragment donationsFragment;

        donationsFragment = DonationsFragment.newInstance(BuildConfig.DEBUG, true, GOOGLE_PUBKEY, GOOGLE_CATALOG,
                    getResources().getStringArray(R.array.donation_google_catalog_values), false, null, null,
                    null, false, null, null, false, null);

        ft.replace(R.id.donations_activity_container, donationsFragment, "donationsFragment");
        ft.commit();
    }

    /**
     * Needed for Google Play In-app Billing. It uses startIntentSenderForResult(). The result is not propagated to
     * the Fragment like in startActivityForResult(). Thus we need to propagate manually to our Fragment.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("donationsFragment");
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}