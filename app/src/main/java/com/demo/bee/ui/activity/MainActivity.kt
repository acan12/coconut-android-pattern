package com.demo.bee.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import app.beelabs.com.codebase.base.BaseActivity
import app.beelabs.com.codebase.component.ProgressDialogComponent.dismissProgressDialog
import app.beelabs.com.codebase.component.ProgressDialogComponent.showProgressDialog
import app.beelabs.com.codebase.support.rx.RxTimer
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.demo.bee.App
import com.demo.bee.BuildConfig
import com.demo.bee.IConfig.Companion.MODULE_INSURANCE_CLASSNAME
import com.demo.bee.R
import com.demo.bee.ui.component.impl.IAnimationLogic
import com.demo.bee.ui.component.impl.IPaymentLogic
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val moduleInsurance by lazy { getString(R.string.insurance_feature_module) }
    private lateinit var manager: SplitInstallManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = SplitInstallManagerFactory.create(this)
        val navigation = App.getNavigationComponent()


        RxTimer.doTimer(10000, false, object : RxTimer() {
            override fun onCallback(along: Long?) {
                navigation.homeNavigation(intent).showLabelManager(
                    "Demo Dependency Injection OK!",
                    labelText,
                    this@MainActivity
                )
            }
        })

        RxTimer.doTimer(1000, false, object : RxTimer() {
            override fun onCallback(along: Long?) {
                val supportPayment = App.getPaymentLogic() as IPaymentLogic
                supportPayment.setupPayment(this@MainActivity)
            }
        })

        RxTimer.doTimer(1000, false, object : RxTimer() {
            override fun onCallback(along: Long?) {
                val supportAnimation = App.getAnimationLogic() as IAnimationLogic
                supportAnimation.setupAnimation(this@MainActivity)
            }
        })

        RxTimer.doTimer(1000, false, object : RxTimer() {
            override fun onCallback(along: Long?) {
                val supportEvent = App.getEvent()
                supportEvent.setupEvent(this@MainActivity)
            }
        })


        doReactiveAction()
    }

    private fun loadInsuranceModule() {
        val request = SplitInstallRequest.newBuilder()
            .addModule(moduleInsurance)
            .build()

        // Load and install the requested feature module.
        manager.startInstall(request)

        if (manager.installedModules.contains(moduleInsurance)) {
            onSuccessfulLoad(moduleInsurance, launch = true)
            return
        }
    }

    private fun onSuccessfulLoad(moduleName: String, launch: Boolean) {
        if (launch) {
            launchActivity(MODULE_INSURANCE_CLASSNAME)
        }
    }

    private fun launchActivity(className: String) {
        intent = Intent()
        intent.setClassName(BuildConfig.APPLICATION_ID, className)
            .also {
                it.putExtra("data", 123)
                startActivity(it)
            }
    }

    // trigger reactive programming
    @SuppressLint("CheckResult")
    private fun doReactiveAction() {
        val inputTextObservable = inputTextWatcher()
        inputTextObservable
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { showProgressDialog(this, "Loading..l", true) }
            .observeOn(Schedulers.io())
            .map { addQuestionMark(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                dismissProgressDialog(this)
                showResult(it)
                if (it.toLowerCase().contains("done")) {
                    loadInsuranceModule()
                    App.getNavigationComponent().homeNavigation(intent).goSecondPage(it, this)
                }
            }

        val buttonObservable = createButtonClickObservable()
        buttonObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                dismissProgressDialog(this)
                showProgressDialog(this, "Do Reactive...", true)
            }
            .observeOn(Schedulers.io())
            .map { searchEngine(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                //                dismissProgressDialog(this)
                showResult(it)
            }
    }


    // reactive by clickable listener
    private fun createButtonClickObservable(): Observable<String> {
        return Observable.create { emit ->
            demoButton.setOnClickListener {
                emit.onNext("Reactive works")
            }

            emit.setCancellable {
                demoButton.setOnClickListener(null)
            }
        }
    }

    // reactive by textwatcher listener
    private fun inputTextWatcher(): Observable<String> {
        return Observable.create { emit ->
            val tw = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) = Unit

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    s?.toString()?.let { emit.onNext(it) }
                }

            }
            inputText.addTextChangedListener(tw)
            emit.setCancellable { inputText.removeTextChangedListener(tw) }
        }
    }


    // function bussiness logic
    private fun addQuestionMark(it: String): String {
        Log.d("", "timer active")
        return "$it ?"
    }

    private fun showResult(it: String) {
        labelText.text = it
    }

    private fun searchEngine(it: String): String {
        Log.d("", "timer active")
        return it
    }


}
