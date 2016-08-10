package com.gelort.studymvp.view;

import com.gelort.studymvp.data.entity.Repository;

import java.util.List;

/**
 * Created by gelort on 05.08.2016.
 */

public interface ReposListView extends BaseView {
    void showRepositories(List<Repository> repositories);
}
