package com.example.shoper

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.shoper.databinding.ActivityMain2Binding
import com.example.shoper.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var addresses: String = {"Asmod88@mail.ru"}.toString()// создаем переменную для отправки на адрес
    var subject: String = "Дорый день.Ваш заказ:"// тема переменной
    var emailText: String? = null// создаем переменную для емайл
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setTitle("Мой заказ")// меняем название активити

        var inent = intent// принимаем данные из первого активти
        var UserName = inent.getStringExtra("Имя")
        var Namenovania = inent.getStringExtra("Наименование")
        var Price = inent.getDoubleExtra("Прайс", 0.0)
        var Summa = inent.getDoubleExtra("Summa", 0.0)
        var Count = inent.getIntExtra("Count", 0)
        emailText = "Мое имя: " + UserName + "\n" +// вписываем в переменную емайл данные из интента
                "Мой товар: " + Namenovania + "\n" +
                "Цена товара " + Price + "\n" +
                "Сумма товара:" + Summa + "\n" +
                "Количество товара: " + Count
        binding.Intent.text = emailText// выводим на экран принятые данные
    }

    fun Email(view: View) {//создаем переменную для кнопки отправляющей на емайл
        var intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)// передаем записываемый адрес
            putExtra(Intent.EXTRA_SUBJECT, subject)//передаем данные темы
            putExtra(Intent.EXTRA_TEXT, emailText)// передаем данные интента
        }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    //  binding.button.setOnClickListener {
              //  var intent = Intent(Intent.ACTION_SENDTO).apply {
                 //   data = Uri.parse("mailto:") // only email apps should handle this
                  //  putExtra(Intent.EXTRA_EMAIL, addresses)
                  //  putExtra(Intent.EXTRA_SUBJECT, subject)
                  //  putExtra(Intent.EXTRA_TEXT, emailText)

             //   if (intent.resolveActivity(packageManager) != null) {
             //       startActivity(intent)





