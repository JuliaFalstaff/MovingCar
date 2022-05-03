package com.example.movingcar.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IMainView: MvpView {
    fun animateCarMovement()
}