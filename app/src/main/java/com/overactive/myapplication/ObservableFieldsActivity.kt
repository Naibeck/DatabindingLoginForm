package com.overactive.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.overactive.myapplication.databinding.ActivityObservableFieldsBinding

class ObservableFieldsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityObservableFieldsBinding>(this, R.layout.activity_observable_fields).also {  binding ->
            binding.viewModel = LoginFormViewModel().also { viewModel ->
                val loginCallback = object : Observable.OnPropertyChangedCallback() {
                    override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                        viewModel.loginEnableObservable.set(
                            Patterns.EMAIL_ADDRESS.matcher(viewModel.emailObservable.get()).matches()
                                    && !viewModel.passwordObservable.get().isNullOrBlank())
                    }
                }

                viewModel.emailObservable.addOnPropertyChangedCallback(loginCallback)
                viewModel.passwordObservable.addOnPropertyChangedCallback(loginCallback)
            }
        }
    }
}
