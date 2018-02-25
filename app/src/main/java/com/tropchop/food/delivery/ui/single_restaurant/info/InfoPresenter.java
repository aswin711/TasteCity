package com.tropchop.food.delivery.ui.single_restaurant.info;

import com.tropchop.food.delivery.ui.base.BasePresenter;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by cedex on 7/3/2017.
 */

public class InfoPresenter<V extends InfoMvpView> extends BasePresenter<V>
              implements InfoMvpPresenter<V>{

    @Inject
    public InfoPresenter() {

    }

    @Override
    public void onViewPrepared() {
        //Dummy contents
        List<Tag> chips = new ArrayList<>();
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        chips.add(new Tag("Chineese"));
        getMvpView().updateChipView(chips);
    }
}
