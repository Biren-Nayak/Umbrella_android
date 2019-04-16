package org.secfirst.umbrella.whitelabel.feature.maskapp.presenter

import org.secfirst.umbrella.whitelabel.feature.base.presenter.BasePresenterImp
import org.secfirst.umbrella.whitelabel.feature.maskapp.interactor.MaskAppBaseInteractor
import org.secfirst.umbrella.whitelabel.feature.maskapp.view.MaskAppView
import javax.inject.Inject


class MaskAppPresenterImp<V : MaskAppView, I : MaskAppBaseInteractor> @Inject constructor(
        interactor: I) : BasePresenterImp<V, I>(
        interactor = interactor), MaskAppBasePresenter<V, I> {

    override fun setMaskApp() {
        interactor?.setMaskApp(false)
    }
}