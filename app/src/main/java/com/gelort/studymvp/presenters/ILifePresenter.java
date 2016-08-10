package com.gelort.studymvp.presenters;

import android.os.Bundle;

/**
 * Created by gelort on 08.08.2016.
 */

public interface ILifePresenter {

    void onCreateView(Bundle saveInstance);

    void onStart();

    void onStop();

    void onDestroy();
}
