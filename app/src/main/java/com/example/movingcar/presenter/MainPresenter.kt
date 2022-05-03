package com.example.movingcar.presenter

import com.example.movingcar.view.IMainView
import moxy.MvpPresenter

class MainPresenter: MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.animateCarMovement()
    }
}