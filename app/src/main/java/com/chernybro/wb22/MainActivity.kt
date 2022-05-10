package com.chernybro.wb22

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import timber.log.Timber


// Q: отличия жизненного цикла фрагмента от жизненного цикла активити,
//    ответить на вопрос - для чего нужны эти отличия, почему они возникли?
// A: В жизненном цикле фрагмента больше методов, потому что фрагмент не может существовть без активити
//    Например, нам нужно знать прикреплен ли фрагмент к активити прежде чем вызывать методы которые используют getActivity()

// Q: Для чего нужен жизненный цикл?
// A: ЖЦ позволяет нам отслеживать в каком состоянии находится экран пользователя
//    Зная жц мы можем очищать ссылки на неиспользуемые объекты, переживать изменение конфигурации

//    Примеры использования в приложении:
//    переживать изменение конфигурации,
//    запрос в сеть при попадании на экран,
//    сбрасывать запросы в onDestroy()
class MainActivity : AppCompatActivity(), BaseRouter, MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${this.javaClass.canonicalName} onRestart")
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commit()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("${this.localClassName} onRestart")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("${this.localClassName} onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${this.localClassName} onResume")
    }


    override fun onPause() {
        super.onPause()
        Timber.d("${this.localClassName} onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${this.localClassName} onDestroy")
    }

    override fun routeTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun showFragmentDialog(title: String) {
        val fm: FragmentManager = supportFragmentManager
        val alertDialog: BaseDialogFragment = BaseDialogFragment.newInstance(title)
        alertDialog.show(fm, "fragment_alert")
    }

}